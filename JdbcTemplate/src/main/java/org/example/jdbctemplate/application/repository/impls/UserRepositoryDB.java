package org.example.jdbctemplate.application.repository.impls;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jdbctemplate.application.entities.UserEntity;
import org.example.jdbctemplate.application.repository.CRUDRepository;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
@Slf4j
public class UserRepositoryDB implements CRUDRepository<UserEntity> {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean create(UserEntity userEntity) {
        String sql = "INSERT INTO users (id, age, fullname) values(:id, :age, :fullname);";
        log.info(userEntity.getFullname() + userEntity.getAge());
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(userEntity)) > 0;
    }

    @Override
    public UserEntity read(Integer id) {
        String sql = "SELECT * from users where id=:id";
        return namedParameterJdbcTemplate.queryForObject(sql,
                Collections.singletonMap("id", id),
                (rs, rowNum) -> new UserEntity(rs.getInt("id"), rs.getInt("age"), rs.getString("fullname"))
        );
    }

    @Override
    public boolean update(UserEntity userEntity) {
        String sql = "UPDATE users set age=:age, fullname=:fullname where id=:id";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(userEntity)) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM users where id=:id";
        return namedParameterJdbcTemplate.update(sql, Collections.singletonMap("id", id)) > 0;
    }

    @Override
    public List<UserEntity> getAll() {
        String sql = "SELECT * FROM users";

        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> new UserEntity(rs.getInt("id"), rs.getInt("age"), rs.getString("fullname")));
    }

}
