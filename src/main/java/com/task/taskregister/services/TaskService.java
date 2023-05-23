package com.task.taskregister.services;

import com.task.taskregister.models.Task;
import com.task.taskregister.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }
    @Transactional
    public void save(Task task) {
        taskRepository.save(task);
    }

    public Object findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findAllList(){
        return taskRepository.findAll();
    }

    public void delete(Task taskDeleted) {
        taskRepository.delete(taskDeleted);
    }
}
