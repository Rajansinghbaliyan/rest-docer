package com.cherrytechnologies.restdocker.services.User;

import com.cherrytechnologies.restdocker.Exception.NotFoundException;
import com.cherrytechnologies.restdocker.domain.User;
import com.cherrytechnologies.restdocker.repositories.UserRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositories repositories;

    @Override
    public User getUser(UUID userId) {
        return repositories.findById(userId).orElseThrow(NotFoundException::new);
    }

    @Override
    public User createUser(User user) {
        user.setUuid(null);
        return repositories.save(user);
    }
}
