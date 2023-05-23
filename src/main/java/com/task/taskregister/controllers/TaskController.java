package com.task.taskregister.controllers;

import com.task.taskregister.models.Task;
import com.task.taskregister.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping("/create")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("task", new Task());
        return mv;
    }

    @PostMapping("/create")
    public String create(Task task){
        if (task.getId() != null){
            var taskModel = new Task();

            taskModel.setId(task.getId());
            taskModel.setName(task.getName());
            taskModel.setDate(task.getDate());

            taskService.save(taskModel);
        } else {
            taskService.save(task);
        }
        return "redirect:/list";
    }
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("tasks", taskService.findAll());
        return mv;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") Long id){
        ModelAndView mv = new ModelAndView("create");
        Task taskFind = taskService.findAllList().stream().filter(task -> task.getId().equals(id)).findFirst().get();


        mv.addObject(taskFind);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value="id") Long id){
        var taskDeleted = taskService.findById(id);
        taskService.delete(taskDeleted.get());

        return "redirect:/list";
    }
}
