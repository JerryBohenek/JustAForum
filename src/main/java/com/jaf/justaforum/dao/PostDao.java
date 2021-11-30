package com.jaf.justaforum.dao;

import com.jaf.justaforum.model.Post;
import com.jaf.justaforum.model.PostCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDao extends BaseDao {

    public List<Post> findByPostCategoryOrderByPublishedDateTimeDesc(PostCategory postCategory) {
        List<Post> posts = new ArrayList<>();
        final String query = """
                SELECT
                    posts.id, posts.title, posts.content, posts.post_category, posts.published_date_time, posts.users_id, users.username
                FROM
                    posts
                JOIN users ON  posts.users_id = users.id
                WHERE
                    posts.post_category = ?
                ORDER BY posts.published_date_time DESC
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, postCategory.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                posts.add(mapRow(resultSet));
            }
            return posts;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> findByUsernameOrderByPublishedDateTimeDesc(String username) {
        List<Post> posts = new ArrayList<>();
        final String query = """
                SELECT
                    posts.id, posts.title, posts.content, posts.post_category, posts.published_date_time, posts.users_id, users.username
                FROM
                    posts
                JOIN users ON  posts.users_id = users.id
                WHERE
                    users.username = ?
                ORDER BY posts.published_date_time DESC
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                posts.add(mapRow(resultSet));
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Long countByUsername(String username) {
        final String query = """
                SELECT
                    count(posts.id)
                FROM
                    posts
                JOIN users ON  users_id = users.id
                WHERE
                users.username = ?
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            return result.getLong(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Post> findById(int id) {
        final String query = """
                SELECT
                    posts.id, posts.title, posts.content, posts.post_category, posts.published_date_time, posts.users_id, users.username
                FROM
                    posts
                JOIN users ON  posts.users_id = users.id
                WHERE
                    posts.id = ?
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return Optional.of(mapRow(resultSet));
            else
                return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Post mapRow(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        PostCategory postCategory = PostCategory.valueOf(resultSet.getString("post_category"));
        LocalDateTime publishedDateTime = resultSet.getObject("published_date_time", LocalDateTime.class);
        Integer  userId = resultSet.getObject("users_id", Integer.class);
        String  username = resultSet.getString("username");

        return new Post(id, title, content, postCategory, publishedDateTime, userId, username);

    }
}
