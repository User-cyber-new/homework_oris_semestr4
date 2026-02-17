package org.oris.dao;

import org.oris.entities.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createUser(UserEntity userEntity) {
        return jdbcTemplate.update(
                "INSERT INTO users(id, name) VALUES(?, ?)",
                userEntity.getId(),
                userEntity.getName()
        ) > 0;
    }

    public UserEntity findUserById(int id){
        return jdbcTemplate.queryForObject(
                "SELECT id, name FROM users WHERE id = ?",
                (rs, rowNum) -> {
                    UserEntity userEntity = new UserEntity(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                    return userEntity;
                },
                id
        );
    }

    public boolean updateUserById(int id, String name){
        return jdbcTemplate.update(
                "UPDATE users SET name = ? WHERE id = ?",
                name,
                id
        ) > 0;
    }

    public boolean deleteUserById(int id){
        return jdbcTemplate.update(
                "DELETE FROM users WHERE id = ?",
                id
        ) > 0;
    }

}