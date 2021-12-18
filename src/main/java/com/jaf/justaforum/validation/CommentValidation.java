package com.jaf.justaforum.validation;

import com.jaf.justaforum.exception.InvalidCommentContentException;

public class CommentValidation {

    public static void newCommentValidation(String commentContent) throws InvalidCommentContentException {
        if (commentContent == null || commentContent.length() < 3) {
            throw new InvalidCommentContentException("Post must be at least 3 characters long.");
        }
    }
}
