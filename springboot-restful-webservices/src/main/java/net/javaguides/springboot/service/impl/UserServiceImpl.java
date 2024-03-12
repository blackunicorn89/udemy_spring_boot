package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
//        Convert UserDto into User JPA entity
        User user = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        //        Convert saved User Jpa entity into UserDto
        UserDto savedUserDt0 = UserMapper.mapToUserDto(savedUser);

        return savedUserDt0;


    }

    @Override
    public UserDto getUserById(Long userId) {
//       Optional<UserDto> user =  userRepository.findById(userId);
//       return user.get();
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
//        return userRepository.findAll();
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user) {
//        UserDto existingUser = userRepository.findById(user.getId()).get();
//        existingUser.setFirstName(user.getFirstName());
//        existingUser.setLastName(user.getLastName());
//        existingUser.setEmail(user.getEmail());
//        UserDto updatedUser = userRepository.save(existingUser);
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
