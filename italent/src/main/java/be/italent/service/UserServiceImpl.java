package be.italent.service;

import be.italent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieve the {@link User} by username
     *
     * @param username {@link String} containing the username
     * @return the requested {@link User}
     */
    @Override
    public User getUserByUsername(String username) {
        return (User)userRepository.findByUsername(username);
    }
    
}
