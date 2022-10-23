package co.com.user.taskusers.service.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInUpdateDTO {
    private Long id;
    private LocalDate dateBirth;
    private Boolean active;
}
