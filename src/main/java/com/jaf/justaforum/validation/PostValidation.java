package com.jaf.justaforum.validation;

import com.jaf.justaforum.dao.PostDao;
import com.jaf.justaforum.dto.NewPostDto;
import com.jaf.justaforum.exception.*;
import com.jaf.justaforum.model.Post;
import com.jaf.justaforum.model.PostCategory;

import java.util.Optional;

public class PostValidation {
    private static final PostDao postDao = new PostDao();

    public static void newPostValidation(NewPostDto newPostDto) throws InvalidPostTitleException, InvalidPostContentException, InvalidPostCategoryException {
        postTitleValidation(newPostDto.getTitle());
        postContentValidation(newPostDto.getContent());
        postCategoryValidation(newPostDto.getPostCategory());
    }

    public static void postTitleValidation(String postTitle) throws InvalidPostTitleException {
        if (postTitle == null || postTitle.length() < 3 || postTitle.length() > 80) {
            throw new InvalidPostTitleException("Post title must be between 3 and 80 characters long.");
        }
    }

    public static void postContentValidation(String postContent) throws InvalidPostContentException {
        if (postContent == null || postContent.length() < 3) {
            throw new InvalidPostContentException("Post must be at least 3 characters long.");
        }
    }

    public static void postCategoryValidation(String postCategory) throws InvalidPostCategoryException {
        if (postCategory == null || !contains(postCategory)) {
            throw new InvalidPostCategoryException("Invalid post category");
        }
    }

    public static void delPostValidation(String username, Long id) throws PostNotFoundException, NotAuthorizedException {
        Optional<Post> optionalPost = postDao.findById(id);

        if (optionalPost.isEmpty()) throw new PostNotFoundException("The post does not exist.");
        if (!optionalPost.get().getUsername().equals(username)) throw new NotAuthorizedException("You are not authorized!");

    }

    private static boolean contains(String categoryValue) {

        for (PostCategory category : PostCategory.values()) {
            if (category.name().equals(categoryValue)) {
                return true;
            }
        }

        return false;
    }
}
