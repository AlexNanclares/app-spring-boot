package co.com.user.taskusers.mapper;

import co.com.user.taskusers.persistence.entity.Dependence;
import co.com.user.taskusers.persistence.entity.Profile;
import co.com.user.taskusers.persistence.entity.User;
import co.com.user.taskusers.service.DTO.UserInDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class UserInDTOToUser implements IMapper<UserInDTO, Dependence, List<Profile>, User> {
    public User map(UserInDTO in, Dependence dependence, List<Profile> profile){
        User user = new User();

        user.setActive(false);
        user.setDateBirth(in.getDateBirth());
        user.setDependence(dependence.toString());
        user.setProfile(profile);

        return user;
    }
}
