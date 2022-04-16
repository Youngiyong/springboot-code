package com.cheese.domain.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByTelAndDeleteDateIsNull(String hp);
    Optional<User> findByIdAndDeleteDateIsNull(Long id);
}
