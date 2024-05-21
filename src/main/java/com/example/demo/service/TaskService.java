package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
      
        return taskRepository.save(task);
    }

    public Task findTaskById(Long id) {

        return taskRepository.findById(id).orElseThrow();
    }

    public List<Task> getAllTasks() {
        
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task task) {
    
        Task existingTask = findTaskById(id);
        existingTask.setTaskName(task.getTaskName());
        existingTask.setTaskDescription(task.getTaskDescription());
        existingTask.setTaskStatus(task.getTaskStatus());
        existingTask.setCompletionDate(task.getCompletionDate());
        return taskRepository.save(existingTask);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByTaskStatus(status);
    }

  
    


    
}
