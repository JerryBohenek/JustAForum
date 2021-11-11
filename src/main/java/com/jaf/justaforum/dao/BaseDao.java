package com.jaf.justaforum.dao;

import com.jaf.justaforum.config.DatabaseConfig;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseDao {
    private final DataSource dataSource;

    public BaseDao() {
        try {
            this.dataSource = DatabaseConfig.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
