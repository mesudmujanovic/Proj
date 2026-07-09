package com.practiseB.practiseB.repository;

import com.practiseB.practiseB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}