package com.jaf.justaforum.dao;

import com.jaf.justaforum.model.Comment;
import com.jaf.justaforum.model.Post;
import com.jaf.justaforum.model.PostCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentDao extends BaseDao {

    public void saveComment(Comment comment) {
        final String query = """
                INSERT INTO
                    comments (comment, write_date_time, users_username, posts_id)
                VALUES
                    (?, ?, ?, ?)
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, comment.getContent());
            statement.setObject(2, comment.getWriteDateTime());
            statement.setString(3, comment.getUsername());
            statement.setLong(4, comment.getPostsId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comment> findByPostIdOrderByWriteDateTimeDesc(Long id) {
        List<Comment> comments = new ArrayList<>();
        final String query = """
                SELECT
                    comments.id, comments.comment, comments.write_date_time, comments.users_username, comments.posts_id
                FROM
                    comments
                WHERE
                    comments.posts_id = ?
                ORDER BY comments.write_date_time DESC
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                comments.add(mapRow(resultSet));
            }
            return comments;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Comment mapRow(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String content = resultSet.getString("comment");
        LocalDateTime writeDateTime = resultSet.getObject("write_date_time", LocalDateTime.class);
        String username = resultSet.getString("users_username");
        Long postsId = resultSet.getLong("posts_id");

        return new Comment(id, content, writeDateTime, username, postsId);
    }
}