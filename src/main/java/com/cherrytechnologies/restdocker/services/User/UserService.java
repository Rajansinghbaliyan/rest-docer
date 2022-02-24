package com.cherrytechnologies.restdocker.services.User;

import com.cherrytechnologies.restdocker.domain.User;

import java.util.UUID;

public interface UserService {
    User getUser(UUID userId);
    User createUser(User user);
}
