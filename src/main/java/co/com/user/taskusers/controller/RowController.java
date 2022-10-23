package co.com.user.taskusers.controller;

import co.com.user.taskusers.exceptions.UserException;
import co.com.user.taskusers.persistence.entity.Row;
import co.com.user.taskusers.persistence.entity.User;
import co.com.user.taskusers.service.DTO.RowInDTO;
import co.com.user.taskusers.service.RowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/Rows")
@RequiredArgsConstructor
public class RowController {
    private final RowService rowService;

    @PostMapping
    public Row createRow(@RequestBody Row row){

        if(row.getDuration() < 1 || row.getDuration() > 60){
            throw new UserException("The duration must be a range between 1-60", HttpStatus.BAD_REQUEST);
        }

        return rowService.createRow(row);
    }

    @PutMapping
    public Row updateRow(@RequestBody RowInDTO row){

        if(row.getDuration() < 1 || row.getDuration() > 60){
            throw new UserException("The duration must be a range between 1-60", HttpStatus.BAD_REQUEST);
        }

        Row result = rowService.updateRow(row);

        if(Objects.isNull(result)){
            throw new UserException("Row not found", HttpStatus.NOT_FOUND);
        }

        return result;
    }

    @DeleteMapping("/{id}")
    public Row deleteRow(@PathVariable Long id){

        Row result = rowService.deleteRow(id);

        if(Objects.isNull(result)){
            throw new UserException("Row not found", HttpStatus.NOT_FOUND);
        }

        return result;
    }

    @GetMapping
    public List<Row> findAllRows(){
        return rowService.findAllRows();
    }
}
