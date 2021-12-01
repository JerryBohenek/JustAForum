package com.jaf.justaforum.controller.post;

import com.jaf.justaforum.model.PostCategory;
import com.jaf.justaforum.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/mobile")
public class MobilePostsController extends HttpServlet {
private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("mobilePosts", postService.getPostsByCategory(PostCategory.MOBILE));

        request.getRequestDispatcher("WEB-INF/views/posts/mobile.jsp").forward(request, response);
    }
}
