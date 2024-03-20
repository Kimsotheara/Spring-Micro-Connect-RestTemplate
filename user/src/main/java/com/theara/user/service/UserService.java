package com.theara.user.service;

import com.theara.user.dto.DepartmentDto;
import com.theara.user.dto.ResponseDto;
import com.theara.user.dto.UserDto;
import com.theara.user.entity.User;
import com.theara.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private RestTemplate restTemplate;

    public ResponseDto findAll(Long userId){

        ResponseDto responseDto = new ResponseDto();
        Optional<User> user = this.userRepository.findById(userId);
        UserDto userDto = mapToUser(user.get());

        ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8181/api/departments/" + user.get().getDepartmentId(),DepartmentDto.class);
        DepartmentDto departmentDto= responseEntity.getBody();
        System.out.println(responseEntity.getStatusCode());
        responseDto.setUserDto(userDto);
        responseDto.setDepartmentDto(departmentDto);
        return responseDto;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
