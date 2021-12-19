package com.jaf.justaforum.util;

import com.jaf.justaforum.dto.CommentDto;
import com.jaf.justaforum.dto.PostDto;
import com.jaf.justaforum.model.Comment;
import com.jaf.justaforum.model.Post;

import java.time.format.DateTimeFormatter;

public class CommentConverter {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss");

    private CommentConverter() {
    }

    public static CommentDto createCommentDto(Comment source) {
        return new CommentDto(
                source.getId(),
                source.getContent(),
                source.getWriteDateTime().format(formatter),
                source.getUsername()
        );
    }
}
