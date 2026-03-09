package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurant.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}