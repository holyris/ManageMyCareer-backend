package fr.univparis8.iut.csid;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univparis8.iut.csid.user.UserCredentials;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JsonAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final ObjectMapper objectMapper;

    public JsonAuthentificationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper) {
        super();
        this.authenticationManager = authenticationManager;
        this.objectMapper = objectMapper;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        try {
            UserCredentials userCredentials = objectMapper.readValue(request.getInputStream(), UserCredentials.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userCredentials.getUsername(),userCredentials.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid authentication object", e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
    }
}
