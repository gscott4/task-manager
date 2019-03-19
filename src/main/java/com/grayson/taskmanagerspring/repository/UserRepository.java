package com.grayson.taskmanagerspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayson.taskmanagerspring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
