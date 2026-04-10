package org.example.homework5.infrastructure.persistence.repository;

import org.example.homework5.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    @Modifying
    @Query(value =
            "insert into users (email,name,password,role) " +
                    "values (:email,:name,:password, CAST(:role AS user_role))",
            nativeQuery = true)
    void saveUser(
            @Param("email") String email,
            @Param("name") String name,
            @Param("password") String password,
            @Param("role") String role
    );
}
