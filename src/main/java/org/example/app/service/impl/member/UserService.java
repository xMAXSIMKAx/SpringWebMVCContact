package org.example.app.service.impl.member;

import org.example.app.entity.User;
import org.example.app.service.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {
    boolean create(User user);
    List<User> fetchAll();
    User fetchById(Long id);
    boolean update(Long id, User user);
    boolean delete(Long id);
}
