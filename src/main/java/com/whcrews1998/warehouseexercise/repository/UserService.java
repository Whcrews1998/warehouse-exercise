package com.whcrews1998.warehouseexercise.repository;

import com.whcrews1998.warehouseexercise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends JpaRepository<User, Integer> {
}
