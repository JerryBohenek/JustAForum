package com.jaf.justaforum.validation;

import com.jaf.justaforum.dao.UserDao;
import com.jaf.justaforum.exception.NotAuthorizedException;
import com.jaf.justaforum.exception.UserNotFoundException;
import com.jaf.justaforum.model.User;

import java.util.Optional;

public class UserValidation {
    private static final UserDao userDao = new UserDao();

    public static void delUserValidation(String username, Long id) throws UserNotFoundException, NotAuthorizedException {
        Optional<User> optionalUser = userDao.findById(id);

        if(optionalUser.isEmpty()) throw new UserNotFoundException("The user does not exist.");
        if (!optionalUser.get().getUsername().equals(username)) throw new NotAuthorizedException("You are not authorized!");
    }
}
