package co.com.user.taskusers.service;

import co.com.user.taskusers.persistence.entity.Dependence;
import co.com.user.taskusers.persistence.entity.Profile;
import co.com.user.taskusers.persistence.entity.User;
import co.com.user.taskusers.service.DTO.UserInDTO;
import co.com.user.taskusers.service.DTO.UserInUpdateDTO;

import java.util.Collection;
import java.util.List;

public interface UserService {

    User createUser(UserInDTO user, Dependence dependence, List<Profile> profile);

    User updateUser(UserInUpdateDTO user, Dependence dependence, List<Profile> profile);

    User deleteUser(Long id);

    List<User> findAllUsers();

}
