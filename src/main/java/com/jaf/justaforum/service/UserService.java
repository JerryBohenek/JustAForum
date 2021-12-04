package com.jaf.justaforum.service;

import com.jaf.justaforum.dao.TokenDao;
import com.jaf.justaforum.dao.UserDao;
import com.jaf.justaforum.dto.UserRegistrationDto;
import com.jaf.justaforum.model.Token;
import com.jaf.justaforum.model.User;
import com.jaf.justaforum.util.EmailUtil;
import org.apache.commons.codec.digest.DigestUtils;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class UserService {
    private final UserDao userDao = new UserDao();
    private final TokenDao tokenDao = new TokenDao();

    public void register(UserRegistrationDto userRegistrationDto) {
        User userToSave = UserMapper.map(userRegistrationDto);
        try {
            hashPasswordWithSha256(userToSave);
            userDao.save(userToSave);
            Token token = new Token(userToSave.getId());
            tokenDao.saveToken(token);
            EmailUtil.sendActivationEmail(userToSave.getEmail(),token.getToken());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    private void hashPasswordWithSha256(User user) throws NoSuchAlgorithmException {
        String sha256Password = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(sha256Password);
    }

    public void confirmUser(Token token) {
        Short active = 1;

        userDao.updateActive(token.getUserId(), active);
        tokenDao.deleteToken(token.getId());
    }

    private static class UserMapper {
        static User map(UserRegistrationDto userRegistrationDto) {
            return new User(
                    userRegistrationDto.getUsername(),
                    userRegistrationDto.getEmail(),
                    userRegistrationDto.getPassword(),
                    LocalDateTime.now(),
                    (short) 0
            );
        }
    }
}