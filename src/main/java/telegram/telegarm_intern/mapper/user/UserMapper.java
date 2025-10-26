package telegram.telegarm_intern.mapper.user;

import org.mapstruct.Mapper;
import telegram.telegarm_intern.dto.user.UserCreateDTO;
import telegram.telegarm_intern.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserCreateDTO.UserResponse toUserResponse(User user);
}
