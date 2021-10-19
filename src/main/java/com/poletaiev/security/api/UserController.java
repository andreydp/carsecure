package com.poletaiev.security.api;

import com.poletaiev.security.entity.User;
import com.poletaiev.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    ResponseEntity<Page<User>> getUsers(
            @PageableDefault(size = 2)
                    Pageable pageable) {
        List<User> users = userService.getAllUsers();
        int sizeOfUsers = users.size();
        int start = (int) pageable.getOffset();
        int offset = start + pageable.getPageSize();
        int end = Math.min(offset, sizeOfUsers);
        if (start > users.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<User> usersPage = new PageImpl<>(users.subList(start, end), pageable, users.size());

        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public User getById( @PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}