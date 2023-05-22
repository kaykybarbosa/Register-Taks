package com.task.taskregister.controllers;

import com.task.taskregister.models.Task;
import com.task.taskregister.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping("/create")
    public String home(){
        return "create";
    }

    @PostMapping("/create")
    public String create(Task task){
        taskService.save(task);

        return "redirect:/list";
    }
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("tasks", taskService.findAll());
        return mv;
    }
    @GetMapping("/edit/{id}")
    public void edit(@PathVariable(value = "id") Long id){
        ModelAndView mv = new ModelAndView("create");

        //Task taskFind = taskService.findAllList().stream().filter(task -> task.getId().equals(id).;
    }
}
