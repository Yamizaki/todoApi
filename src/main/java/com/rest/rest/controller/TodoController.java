package com.rest.rest.controller;

import com.rest.rest.models.Task;
import com.rest.rest.repository.TaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TodoController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/show")
    public List<Task> getTask() {
        return taskRepository.findAll();
    }

    @PostMapping("/save")
    public String saveTask(@RequestBody Task task) {
        taskRepository.save(task);
        return "Task saved correctly";
    }

    @PutMapping("/edit/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task) {
        Task updatedTask = taskRepository.findById(id).get();

        updatedTask.setDescription(task.getDescription());
        updatedTask.setTitle(task.getTitle());
        updatedTask.setStatus(task.getStatus());
        taskRepository.save(updatedTask);
        return "Correct Updated";
    }

    
    @PutMapping("/hide/{id}")
    public String hideTask(@PathVariable long id) {
        Task hideTask = taskRepository.findById(id).get();
        
        if(!hideTask.isHidden()){
            hideTask.setHidden(true);
            taskRepository.save(hideTask);
            return "Correct Hide";
        }
        return "Task is already hide";
        
        
        
    }
    
    @PutMapping("/done/{id}")
    public String doneTask(@PathVariable long id) {
        Task doneTask = taskRepository.findById(id).get();
        
        doneTask.setStatus(true);
        taskRepository.save(doneTask);
        return "Correct done";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id) {
        Task deletedTask = taskRepository.findById(id).get();
        taskRepository.delete(deletedTask);
        return "Correct Deleted";

    }

}
