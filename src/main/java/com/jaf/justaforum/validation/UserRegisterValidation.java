package com.jaf.justaforum.validation;

import com.jaf.justaforum.dao.UserDao;
import com.jaf.justaforum.exception.InvalidConfirmPasswordException;
import com.jaf.justaforum.exception.InvalidEmailException;
import com.jaf.justaforum.exception.InvalidPasswordException;
import com.jaf.justaforum.exception.InvalidUsernameException;
import com.jaf.justaforum.service.UserRegistration;
import com.jaf.justaforum.util.RegexChecker;

public class UserRegisterValidation {
    private static final UserDao userDao = new UserDao();
    private static final String usernameRegex = "^[A-Za-z]\\w{5,29}$";
    private static final String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z\\d\\s:]).{8,20}$";

    public static void newUserValidation(UserRegistration userRegistration) throws InvalidUsernameException, InvalidPasswordException, InvalidEmailException, InvalidConfirmPasswordException {
        usernameValidation(userRegistration.getUsername());
        emailValidation(userRegistration.getEmail());
        passwordValidation(userRegistration.getPassword());
        confirmPasswordValidation(userRegistration.getPassword(),userRegistration.getConfirmPassword());
    }

    private static void usernameValidation(String username) throws InvalidUsernameException {
        String errorMessage = "";

        if(!RegexChecker.regexCheck(usernameRegex, username)){

            if (username.length() < 6 || username.length() > 30) errorMessage += "Username must be between 6 and 30 characters long. ";
            if (!RegexChecker.regexCheck("^[a-zA-Z].*", username)) errorMessage += "Username must start with a letter. ";
            if (!RegexChecker.regexCheck("^[a-zA-Z0-9_]*$", username)) errorMessage += "Only alphanumeric characters and underscores \"_\" are allowed. ";

            throw new InvalidUsernameException(errorMessage);
        }

        if (userDao.findByUsername(username).isPresent()) {
            errorMessage += "This username already exists. ";

            throw new InvalidUsernameException(errorMessage);
        }
    }

    private static void emailValidation(String email) throws InvalidEmailException {
        String errorMessage = "";

        if(!RegexChecker.regexCheck(emailRegex, email)){

            errorMessage = "Invalid email.";

            throw new InvalidEmailException(errorMessage);
        }

        if (userDao.findByEmail(email).isPresent()) {
            errorMessage += "This email already exists. ";

            throw new InvalidEmailException(errorMessage);
        }
    }

    private static void passwordValidation(String password) throws InvalidPasswordException {
        String errorMessage = "";

        if(!RegexChecker.regexCheck(passwordRegex, password)){

            if (password.length() < 8 || password.length() > 20) errorMessage += "Password must be between 8 and 20 characters long. ";
            if (!RegexChecker.regexCheck(".*[0-9].*", password)) errorMessage += "Must contain at least one digit. ";
            if (!RegexChecker.regexCheck(".*[a-z].*", password)) errorMessage += "Must contain at least one lowercase Latin character [a-z]. ";
            if (!RegexChecker.regexCheck(".*[A-Z].*", password)) errorMessage += "Must contain at least one uppercase Latin character [A-Z]. ";
            if (!RegexChecker.regexCheck(".*[^a-zA-Z\\d\\s:].*", password)) errorMessage += "Must contain at least one special character like. ";

            throw new InvalidPasswordException(errorMessage);
        }
    }

    private static void confirmPasswordValidation(String password, String confirmPassword) throws InvalidConfirmPasswordException {
        if(!password.equals(confirmPassword)){
            throw new InvalidConfirmPasswordException("Those passwords didn’t match.");
        }
    }
}