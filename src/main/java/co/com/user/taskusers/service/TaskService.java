package co.com.user.taskusers.service;

import co.com.user.taskusers.persistence.entity.Task;
import co.com.user.taskusers.service.DTO.TaskInDTO;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    Task updateTask(TaskInDTO task);

    Task deleteTask(Long id);

    List<Task> findAllTask();

}
