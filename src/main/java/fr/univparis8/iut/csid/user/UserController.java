package fr.univparis8.iut.csid.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {



    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserDetails> getAllForOne(){
        return userService.getAll();
    }

    @PostMapping("/change_psw")
    public String changePassword(@RequestBody ChangePasswordDto passwordDto){
        userService.changePassword(passwordDto);
        return "Le nouveau mot de passe est: "+passwordDto.getNewPassword();
    }

    @PostMapping("/create_user")
    public UserCredentials createUser(@RequestBody UserCredentials newUser){
        userService.createUser(newUser);
        return newUser;
    }

    @DeleteMapping("/{user}")
    public String deleteUser(@PathVariable String user){
        userService.deleteUser(user);
        return "L'utilisateur "+user+" à été supprimé";
    }

    @GetMapping("/me")
    public Object getCurrentUser(){
        return userService.getCurrentUser();
    }

    @GetMapping("/list")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

}
