package telegram.telegarm_intern.dto.user;

import telegram.telegarm_intern.enums.Role;

public record UserCreateDTO(
        String name,
        String surname,
        String username,
        String password,
        Role role
) {
    public record UserResponse(
            String name,
            String surname,
            String username,
            Role role
    ){}
}
