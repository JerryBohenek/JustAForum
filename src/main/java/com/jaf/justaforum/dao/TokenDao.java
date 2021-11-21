package com.jaf.justaforum.dao;

import com.jaf.justaforum.model.Token;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class TokenDao extends BaseDao {

    public void saveToken(Token token) {
        final String query = """
                        INSERT INTO
                            tokens (token, created_date, users_id)
                        VALUES
                            (?, ?, ?)
                        """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, token.getToken());
            statement.setObject(2, token.getCreatedDate());
            statement.setInt(3, token.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteToken(Integer id) {
        final String query = """
                        DELETE FROM
                            tokens
                        WHERE
                            id = ?
                        """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Token> findByToken(String token) {
        final String query = """
                SELECT
                    id, token, created_date, users_id
                FROM
                    tokens
                WHERE
                    token = ?
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return Optional.of(mapRow(resultSet));
            else
                return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Token mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String token = resultSet.getString("token");
        LocalDateTime createdDate = resultSet.getObject("created_date", LocalDateTime.class);
        Integer  userId = resultSet.getObject("users_id", Integer.class);

        return new Token(id, token, createdDate, userId);
    }
}
