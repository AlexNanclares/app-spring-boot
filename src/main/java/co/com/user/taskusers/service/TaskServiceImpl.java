package co.com.user.taskusers.service;

import co.com.user.taskusers.persistence.entity.Task;
import co.com.user.taskusers.persistence.repository.TaskRepository;
import co.com.user.taskusers.service.DTO.TaskInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public Task createTask(Task task){
        return repository.save(task);
    }

    @Override
    @Transactional
    public Task updateTask(TaskInDTO task){

        Optional<Task> result = repository.findById(task.getId());

        if(result.isEmpty()){
            return null;
        }

        repository.updateTask(task.getName(), task.getId());
        return result.orElse(null);
    }

    @Override
    public Task deleteTask(Long id){

        Optional<Task> task = repository.findById(id);

        if(task.isEmpty()){
            return null;
        }

        repository.deleteById(id);
        return task.orElse(null);
    }

    @Override
    public List<Task> findAllTask(){
        return repository.findAll();
    }

}
