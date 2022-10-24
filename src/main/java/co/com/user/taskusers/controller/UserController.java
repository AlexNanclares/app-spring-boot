package co.com.user.taskusers.controller;

import co.com.user.taskusers.exceptions.UserException;
import co.com.user.taskusers.persistence.entity.Dependence;
import co.com.user.taskusers.persistence.entity.Profile;
import co.com.user.taskusers.persistence.entity.User;
import co.com.user.taskusers.service.DTO.UserInDTO;
import co.com.user.taskusers.service.DTO.UserInUpdateDTO;
import co.com.user.taskusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/dependence/{dependence}/profile/{profile}")
    public User createUser(@RequestBody UserInDTO user, @PathVariable List<Profile> profile, @PathVariable Dependence dependence){

        LocalDate currentDate = LocalDate.now();
        LocalDate BirthDate = user.getDateBirth();

        if(ChronoUnit.YEARS.between(BirthDate, currentDate) < 18){
            throw new UserException("User must be greater than or equal to 18", HttpStatus.BAD_REQUEST);
        }

        return userService.createUser(user, dependence, profile);
    }

    @PutMapping("/dependence/{dependence}/profile/{profile}")
    public User updateUser(@RequestBody UserInUpdateDTO user, @PathVariable List<Profile> profile, @PathVariable Dependence dependence){

        LocalDate currentDate = LocalDate.now();
        LocalDate BirthDate = user.getDateBirth();

        if(ChronoUnit.YEARS.between(BirthDate, currentDate) < 18){
            throw new UserException("User must be greater than or equal to 18", HttpStatus.BAD_REQUEST);
        }

        User result = userService.updateUser(user, dependence, profile);

        if(Objects.isNull(result)){
            throw new UserException("User not found", HttpStatus.NOT_FOUND);
        }

        return result;
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Long id){
        User result = userService.deleteUser(id);

        if(Objects.isNull(result)){
            throw new UserException("User not found", HttpStatus.NOT_FOUND);
        }

        return result;
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

}
