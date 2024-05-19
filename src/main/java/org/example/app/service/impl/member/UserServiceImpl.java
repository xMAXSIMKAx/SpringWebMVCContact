package org.example.app.service.impl.member;

import jakarta.transaction.Transactional;
import org.example.app.entity.User;
import org.example.app.repository.impl.member.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

// @Service - анотування класів сервісів.
// @Transactional застосовується до сервісного шару
// для підтримки транзакцій.
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    @Transactional
    public boolean create(User user) {
        return repository.create(user);
    }

    @Override
    @Transactional
    public List<User> fetchAll() {
        return repository.fetchAll()
                .orElse(Collections.emptyList());
    }

    @Override
    @Transactional
    public User fetchById(Long id) {
        return repository.fetchById(id)
                .orElse(null);
    }

    @Override
    @Transactional
    public boolean update(Long id, User user) {
        return repository.update(id, user);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        Optional<User> optional = repository.fetchById(id);
        if (optional.isPresent())
            return repository.delete(id);
        else return false;
    }
}
