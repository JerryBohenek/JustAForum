package com.jaf.justaforum.service;

import com.jaf.justaforum.dao.PostDao;
import com.jaf.justaforum.dto.PostDto;
import com.jaf.justaforum.exception.PostNotFoundException;
import com.jaf.justaforum.model.Post;
import com.jaf.justaforum.model.PostCategory;
import com.jaf.justaforum.util.PostConverter;

import java.util.List;
import java.util.stream.Collectors;

public class PostService {
    private final PostDao postDao = new PostDao();

    public List<PostDto> getPostsByCategory(PostCategory postCategory) {
        List<Post> result = postDao.findByPostCategoryOrderByPublishedDateTimeDesc(postCategory);

        return result.stream().map(PostConverter::createCategoryPostDto).collect(Collectors.toList());
    }

    public PostDto getPostById(Long id) throws RuntimeException, PostNotFoundException {
        return PostConverter.createPostDto(postDao.findById(id).orElseThrow(() -> new PostNotFoundException("Post not found.")));
    }
}
