package guru.springframework.services;


import guru.springframework.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findById(String id);

    List<User> findAll();
}
