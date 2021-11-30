package com.jaf.justaforum.service;

import com.jaf.justaforum.dao.PostDao;
import com.jaf.justaforum.model.Post;
import com.jaf.justaforum.model.PostCategory;

import java.util.List;

public class PostService {
    private final PostDao postDao = new PostDao();

    public List<Post> getPostsByCategory(PostCategory postCategory) {
        return postDao.findByPostCategoryOrderByPublishedDateTimeDesc(postCategory);
    }
}
