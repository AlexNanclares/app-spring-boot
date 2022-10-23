package co.com.user.taskusers.controller;

import co.com.user.taskusers.exceptions.UserException;
import co.com.user.taskusers.persistence.entity.Row;
import co.com.user.taskusers.persistence.entity.Task;
import co.com.user.taskusers.service.DTO.TaskInDTO;
import co.com.user.taskusers.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping
    public Task updateTask(@RequestBody TaskInDTO task){

        Task result = taskService.updateTask(task);

        if(Objects.isNull(result)){
            throw new UserException("Task not found", HttpStatus.NOT_FOUND);
        }

        return result;
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable Long id){

        Task result = taskService.deleteTask(id);

        if(Objects.isNull(result)){
            throw new UserException("Task not found", HttpStatus.NOT_FOUND);
        }

        return result;
    }

    @GetMapping
    public List<Task> findAllTask(){
        return taskService.findAllTask();
    }

}
