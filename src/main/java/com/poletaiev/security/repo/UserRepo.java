package com.poletaiev.security.repo;

import com.poletaiev.security.entity.Car;
import com.poletaiev.security.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepo {

    List<User> USERS = new ArrayList<>(
            Arrays.asList(
                    new User(1L, "Alex", "Doe", "alex.doe@gmail.com", "password1", new Car("Toyota", "Corolla")),
                    new User(2L, "Alex2", "Doe", "alex2.doe@gmail.com", "password1", new Car("Toyota", "Corolla")),
                    new User(3L, "Alex3", "Doe", "alex3.doe@gmail.com", "password1", new Car("Toyota", "Corolla")),
                    new User(4L, "Alex4", "Doe", "alex4.doe@gmail.com", "password1", new Car("Toyota", "Corolla")),
                    new User(5L, "Alex5", "Doe", "alex5.doe@gmail.com", "password1", new Car("Toyota", "Corolla")),
                    new User(6L, "Alex6", "Doe", "alex6.doe@gmail.com", "password1", new Car("Toyota", "Corolla"))
            )
    );

    public List<User> findAll() {
        return USERS;
    }

    public User findById(Long id) {
        return USERS.stream()
                .filter(user -> id.equals(user.getId()))
                .findAny()
                .orElse(null);
    }

    public boolean save(User user) {
        return USERS.add(user);
    }

    public void deleteById(Long id) {
        USERS.removeIf(user -> user.getId().equals(id));
    }
}
