package co.com.user.taskusers.mapper;

import co.com.user.taskusers.persistence.entity.Dependence;
import co.com.user.taskusers.persistence.entity.User;
import co.com.user.taskusers.service.DTO.UserInDTO;
import org.springframework.stereotype.Component;

@Component
public class UserInDTOToUser implements IMapper<UserInDTO, Dependence, User> {
    public User map(UserInDTO in, Dependence dependence){
        User user = new User();

        user.setActive(false);
        user.setDateBirth(in.getDateBirth());
        user.setDependence(dependence.toString());

        return user;
    }
}
