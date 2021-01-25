package bazaar.controllers;

import bazaar.api.BaseResponse;
import bazaar.entities.User;
import bazaar.model.AuthenticationRequest;
import bazaar.model.AuthenticationResponse;
import bazaar.repositories.UserRepository;
import bazaar.services.BazaarUserDetailsService;
import bazaar.services.UserService;
import bazaar.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private BazaarUserDetailsService userDetailsService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
//			throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    @RequestMapping( "/user/{email}/{password}")
    public BaseResponse getUserByEmailAndPassword(@PathVariable String email,@PathVariable String password){
                return userService.getUserByEmailAndPassword(email,password);
    }

    @RequestMapping(produces = "application/json",method = RequestMethod.POST, value = "/signup")
    public BaseResponse signup(@RequestBody User user){
        return userService.createUser(user);
    }




}


