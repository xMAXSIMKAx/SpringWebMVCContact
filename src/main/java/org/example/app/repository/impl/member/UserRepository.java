package org.example.app.repository.impl.member;

import org.example.app.entity.User;
import org.example.app.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    boolean create(User user);
    Optional<List<User>> fetchAll();
    Optional<User> fetchById(Long id);
    boolean update(Long id, User user);
    boolean delete(Long id);
}
