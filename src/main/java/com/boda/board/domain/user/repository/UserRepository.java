package com.boda.board.domain.user.repository;

import com.boda.board.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(@NonNull String mail);
}
