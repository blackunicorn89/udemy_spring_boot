package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.AutoUserMapper;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

//    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
//        Convert UserDto into User JPA entity
//        User user = UserMapper.mapToUser(userDto);
//        User user = modelMapper.map(userDto, User.class);
        User user = AutoUserMapper.MAPPER.maptoUser(userDto);


        User savedUser = userRepository.save(user);

        //        Convert saved User Jpa entity into UserDto
//        UserDto savedUserDt0 = UserMapper.mapToUserDto(savedUser);
//        UserDto savedUserDt0 = modelMapper.map(savedUser, UserDto.class);
        UserDto savedUserDt0 = AutoUserMapper.MAPPER.mapToUserDto(savedUser);


        return savedUserDt0;

    }

    @Override
    public UserDto getUserById(Long userId) {
       Optional<User> optionalUser =  userRepository.findById(userId);
       User user = optionalUser.get();
//       return UserMapper.mapToUserDto(user);
//        return modelMapper.map(user, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//        return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);

    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
