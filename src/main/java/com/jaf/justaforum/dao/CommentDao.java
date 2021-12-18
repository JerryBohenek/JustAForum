package com.jaf.justaforum.dao;

import com.jaf.justaforum.model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
