package com.task.taskregister.controllers;

import com.task.taskregister.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping("/create")
    public String home(){
        return "create";
    }

    public void crate(Task task){

    }
}
