package co.com.user.taskusers.service;

import co.com.user.taskusers.mapper.UserInDTOToUser;
import co.com.user.taskusers.persistence.entity.Dependence;
import co.com.user.taskusers.persistence.entity.User;
import co.com.user.taskusers.persistence.repository.UserRepository;
import co.com.user.taskusers.service.DTO.UserInDTO;
import co.com.user.taskusers.service.DTO.UserInUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserInDTOToUser userInDTOToUser;

    @Override
    public User createUser(UserInDTO user, Dependence dependence){
        return repository.save(userInDTOToUser.map(user,dependence));
    }

    @Override
    @Transactional
    public User updateUser(UserInUpdateDTO user, Dependence dependence){
        Optional<User> resultSearch = repository.findById(user.getId());

        if(resultSearch.isEmpty()){
            return null;
        }

        repository.updateUser(user.getDateBirth(), user.getActive(), dependence.toString(), user.getId());
        return resultSearch.orElse(null);
    }

    @Override
    public User deleteUser(Long id){
        Optional<User> user = repository.findById(id);

        if(user.isEmpty()){
            return null;
        }

        repository.deleteById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> findAllUsers(){
        return repository.findAll();
    }

    public Integer binaryToInteger(String binary) {
        char[] numbers = binary.toCharArray();
        int result = 0;
        for(int i=numbers.length - 1; i>=0; i--)
            if(numbers[i]=='1')
                result += Math.pow(2, (numbers.length-i - 1));
        return result;
    }
}
