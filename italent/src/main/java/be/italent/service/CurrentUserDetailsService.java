package be.italent.service;

import be.italent.model.CurrentUser;
import be.italent.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
    private static final Logger logger = LogManager.getLogger(CurrentUserDetailsService.class.getName());

    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves the {@link CurrentUser} by its username
     *
     * @param username a {@link String} with the wanted user's username
     * @return the requested {@link CurrentUser}
     * @throws UsernameNotFoundException when username is not found
     */
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " + username);

        User user = userService.getUserByUsername(username);
        return new CurrentUser(user);
    }
}
