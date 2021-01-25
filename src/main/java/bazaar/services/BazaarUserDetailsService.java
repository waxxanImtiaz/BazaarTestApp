package bazaar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class BazaarUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        bazaar.entities.User dbUser = userService.findUserByUsername(s);
        User user = null;
        if (dbUser != null)
         user = new User(dbUser.getUsername(),dbUser.getPassword(),new ArrayList<>());

        return user;
    }

}
