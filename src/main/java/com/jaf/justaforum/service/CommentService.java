package com.jaf.justaforum.service;

import com.jaf.justaforum.dao.CommentDao;
import com.jaf.justaforum.dto.NewCommentDto;
import com.jaf.justaforum.model.Comment;

import java.time.LocalDateTime;

public class CommentService {
    private final CommentDao commentDao = new CommentDao();

    public void addNewComment(NewCommentDto newCommentDto) {
        Comment commentToSave = CommentService.CommentMapper.map(newCommentDto);

        commentDao.saveComment(commentToSave);
    }

    private static class CommentMapper {
        static Comment map(NewCommentDto newCommentDto) {
            return new Comment(
                    newCommentDto.getContent(),
                    LocalDateTime.now(),
                    newCommentDto.getUsername(),
                    newCommentDto.getPostsId()
            );
        }
    }
}
