package telegram.telegarm_intern.util;

import telegram.telegarm_intern.entity.User;
import telegram.telegarm_intern.repository.UserRepository;

import java.util.Optional;

public class UserUtil {

    private static UserRepository userRepository;

    public UserUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 6) {
            return false;
        }
        return true;
    }

    public static boolean userFound(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.isPresent();
    }
}
