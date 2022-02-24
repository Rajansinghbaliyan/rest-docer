package com.cherrytechnologies.restdocker.repositories;

import com.cherrytechnologies.restdocker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositories extends JpaRepository<User, UUID> {

}
