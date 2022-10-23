package co.com.user.taskusers.service;

import co.com.user.taskusers.persistence.entity.Dependence;
import co.com.user.taskusers.persistence.entity.User;
import co.com.user.taskusers.service.DTO.UserInDTO;
import co.com.user.taskusers.service.DTO.UserInUpdateDTO;

import java.util.List;

public interface UserService {

    User createUser(UserInDTO user, Dependence dependence);

    User updateUser(UserInUpdateDTO user, Dependence dependence);

    User deleteUser(Long id);

    List<User> findAllUsers();

}
