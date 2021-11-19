package com.jaf.justaforum.controller;

import com.jaf.justaforum.exception.InvalidConfirmPasswordException;
import com.jaf.justaforum.exception.InvalidEmailException;
import com.jaf.justaforum.exception.InvalidPasswordException;
import com.jaf.justaforum.exception.InvalidUsernameException;
import com.jaf.justaforum.service.UserRegistration;
import com.jaf.justaforum.service.UserService;
import com.jaf.justaforum.validation.UserRegisterValidation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserRegistration userRegistration = getUserData(request);

            UserRegisterValidation.newUserValidation(userRegistration);

            userService.register(userRegistration);

            request.setAttribute("confirmStart",("Activate your email: " + request.getParameter("email")));
            request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);

        } catch (InvalidUsernameException e) {
            request.setAttribute("usernameError", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
        } catch (InvalidEmailException e) {
            request.setAttribute("emailError", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
        } catch (InvalidPasswordException e) {
            request.setAttribute("passwordError", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
        } catch (InvalidConfirmPasswordException e) {
            request.setAttribute("confirmPasswordError", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
        }
    }

    private UserRegistration getUserData(HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        return new UserRegistration(username, email, password, confirmPassword);
    }
}