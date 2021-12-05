package com.jaf.justaforum.util;

import com.jaf.justaforum.dto.PostDto;
import com.jaf.justaforum.model.Post;

import java.time.format.DateTimeFormatter;

public class PostConverter {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss");
    private PostConverter() {}

    public static PostDto createShortPostDto(Post source) {
        int charsInContent = 350;

        String shortContent = source.getContent();
        if (shortContent.length() > charsInContent) {
            shortContent = shortContent.substring(0, charsInContent) + "...";
        }

        return new PostDto(
                source.getId(),
                source.getTitle(),
                shortContent,
                source.getPostCategory(),
                source.getPublishedDateTime().format(formatter),
                source.getUsername()
        );
    }
        public static PostDto createPostDto(Post source){
        return new PostDto(
                    source.getId(),
                    source.getTitle(),
                    source.getContent(),
                    source.getPostCategory(),
                    source.getPublishedDateTime().format(formatter),
                    source.getUsername()
            );
    }
}
