package telegram.telegarm_intern.service;

import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import telegram.telegarm_intern.dto.user.UserCreateDTO;
import telegram.telegarm_intern.entity.User;
import telegram.telegarm_intern.exceptions.UserNotFoundException;
import telegram.telegarm_intern.exceptions.UsernameAlreadyExistsException;
import telegram.telegarm_intern.mapper.user.UserMapper;
import telegram.telegarm_intern.repository.UserRepository;
import telegram.telegarm_intern.util.UserUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static telegram.telegarm_intern.util.UserUtil.isValidPassword;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    private UserMapper userMapper;



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

    public List<UserCreateDTO.UserResponse> getAll() {
        List<UserCreateDTO.UserResponse> userResponses = new ArrayList<>();
        for (User user : repository.findAll()) {
            userResponses.add(userMapper.toUserResponse(user));
        }

        return userResponses;
    }

    public UserCreateDTO.UserResponse update(Long userId, UserCreateDTO updateUser) {
        if (!UserUtil.userFound(userId)) {
            throw new UserNotFoundException("User not found");
        }
        if (repository.existsByUsername(updateUser.username())) {
            throw new UsernameAlreadyExistsException("This username is already taken");
        }

        Optional<User> optionalUser = repository.findById(userId);
        User user = optionalUser.get();

        user.setName(updateUser.name());
        user.setSurname(updateUser.surname());
        user.setUsername(updateUser.username());
        user.setRole(updateUser.role());
        user.setPassword(passwordEncoder.encode(updateUser.password()));
        repository.save(user);
        return userMapper.toUserResponse(user);
    }


    public String delete(Long userId) {
        if (UserUtil.userFound(userId)) {
            throw new UserNotFoundException("User not found");
        }
        repository.deleteById(userId);
        return "User deleted";
    }
}
