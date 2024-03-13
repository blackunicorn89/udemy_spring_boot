package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    //If mapped classes have to different named fields you can use @Mapping to tell Mapstruct which field are related to each other.
//    @Mapping(source = "email", target = "emailAddress")

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);
    User maptoUser(UserDto userDto);
}
