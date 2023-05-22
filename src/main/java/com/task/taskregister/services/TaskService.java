package com.task.taskregister.services;

import com.task.taskregister.models.Task;
import com.task.taskregister.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Transactional
    public void save(Task task) {
        taskRepository.save(task);
    }

    public Object findAll() {
        return taskRepository.findAll();
    }
}
