package com.jaf.justaforum.validation;

import com.jaf.justaforum.dao.CommentDao;
import com.jaf.justaforum.exception.CommentNotFoundException;
import com.jaf.justaforum.exception.InvalidCommentContentException;
import com.jaf.justaforum.exception.NotAuthorizedException;
import com.jaf.justaforum.model.Comment;

import java.util.Optional;

public class CommentValidation {
    private static final CommentDao commentDao = new CommentDao();

    public static void newCommentValidation(String commentContent) throws InvalidCommentContentException {
        if (commentContent == null || commentContent.length() < 3) {
            throw new InvalidCommentContentException("Post must be at least 3 characters long.");
        }
    }

    public static void deleteCommentValidation(String username, Long id) throws CommentNotFoundException, NotAuthorizedException {
        Optional<Comment> optionalComment = commentDao.findById(id);

        if (optionalComment.isEmpty()) throw new CommentNotFoundException("The comment does not exist.");
        if (!optionalComment.get().getUsername().equals(username)) throw new NotAuthorizedException("You are not authorized!");
    }
}
