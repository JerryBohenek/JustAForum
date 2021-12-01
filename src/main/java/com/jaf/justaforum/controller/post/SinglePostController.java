package com.jaf.justaforum.controller.post;

import com.jaf.justaforum.dto.PostDto;
import com.jaf.justaforum.exception.PostNotFoundException;
import com.jaf.justaforum.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/single-post")
public class SinglePostController extends HttpServlet {
    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            PostDto post = postService.getPostById(Long.valueOf(request.getParameter("id")));
            request.setAttribute("post", post);
        } catch (PostNotFoundException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }
        request.getRequestDispatcher("WEB-INF/views/posts/singlepost.jsp").forward(request, response);
    }

}
