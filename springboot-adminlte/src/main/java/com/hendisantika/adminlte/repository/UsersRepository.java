package com.hendisantika.adminlte.repository;

import com.hendisantika.adminlte.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
