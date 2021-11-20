package com.jaf.justaforum.service;

import com.jaf.justaforum.dao.UserDao;
import com.jaf.justaforum.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void register(UserRegistration userRegistration) {
        User userToSave = UserMapper.map(userRegistration);
        try {
            hashPasswordWithSha256(userToSave);
            userDao.save(userToSave);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void hashPasswordWithSha256(User user) throws NoSuchAlgorithmException {
        String sha256Password = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(sha256Password);
    }

    private static class UserMapper {
        static User map(UserRegistration userRegistration) {
            return new User(
                    userRegistration.getUsername(),
                    userRegistration.getEmail(),
                    userRegistration.getPassword(),
                    LocalDateTime.now(),
                    (short) 0
            );
        }
    }
}