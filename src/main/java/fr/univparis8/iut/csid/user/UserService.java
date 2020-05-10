package fr.univparis8.iut.csid.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(JdbcUserDetailsManager jdbcUserDetailsManager, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public List<UserDetails> getAll(){
        return Collections.singletonList(jdbcUserDetailsManager.loadUserByUsername("admin"));
    }

    public void changePassword(ChangePasswordDto passwordDto){
        jdbcUserDetailsManager.changePassword(passwordDto.getOldPassword(), passwordEncoder.encode(passwordDto.getNewPassword()));
    }

    public void createUser(UserCredentials newUser){
        jdbcUserDetailsManager.createUser(
                User.withUsername(newUser.getUsername())
                        .password(passwordEncoder.encode(newUser.getPassword()))
                        .authorities(AuthorityUtils.createAuthorityList("USER")).build());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUser(String user){
        jdbcUserDetailsManager.deleteUser(user);
    }

    public Object getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public String getCurrentUserId(){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getUsername());
        return user.getUsername();
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }


}
