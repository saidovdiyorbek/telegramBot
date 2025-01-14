package telegram.telegarm_intern.service;

import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import telegram.telegarm_intern.dto.user.UserCreateDTO;
import telegram.telegarm_intern.entity.User;
import telegram.telegarm_intern.exceptions.UsernameAlreadyExistsException;
import telegram.telegarm_intern.repository.UserRepository;

import java.time.LocalDateTime;

import static telegram.telegarm_intern.util.UserUtil.isValidPassword;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;



    public UserCreateDTO create(UserCreateDTO userDTO) {
        if (repository.existsByUsername(userDTO.username())) {
            throw new UsernameAlreadyExistsException("This username is already taken");
        }
        if (!isValidPassword(userDTO.password())) {
            throw new BadRequestException("Password is not valid");
        }

        User createUser = new User();
        createUser.setName(userDTO.name());
        createUser.setSurname(userDTO.surname());
        createUser.setUsername(userDTO.username());
        createUser.setPassword(passwordEncoder.encode(userDTO.password()));
        createUser.setRole(userDTO.role());
        createUser.setActive(true);
        createUser.setCreatedAt(LocalDateTime.now());
        repository.save(createUser);
        return userDTO;
    }
}
