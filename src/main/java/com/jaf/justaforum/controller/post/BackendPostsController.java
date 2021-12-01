package com.jaf.justaforum.controller.post;

import com.jaf.justaforum.model.PostCategory;
import com.jaf.justaforum.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/backend")
public class BackendPostsController  extends HttpServlet {
private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("backendPosts", postService.getPostsByCategory(PostCategory.BACKEND));

        request.getRequestDispatcher("WEB-INF/views/posts/backend.jsp").forward(request, response);
    }
}
