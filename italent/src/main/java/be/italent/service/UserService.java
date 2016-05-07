package be.italent.service;

import be.italent.model.User;

public interface UserService {
    User getUserByUsername(String username);
}