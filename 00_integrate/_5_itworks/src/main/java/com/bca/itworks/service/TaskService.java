package com.bca.itworks.service;

import com.bca.itworks.model.Task;
import com.bca.itworks.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
@Slf4j
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAll()
    {
        List<Task> tasks= new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);

        if(tasks.isEmpty())
        {
            log.info("You have no tasks!");
            return new ArrayList<>();
        }
        return tasks;
    }

    public Task addTask(Task task)
    {
        return taskRepository.save(new Task(task.getTitle()));
    }

    public Task updateTask(String id)
    {
        Optional<Task> task = taskRepository.findById(UUID.fromString(id));
        if(task.isPresent())
        {
            Task existingTask = task.get();
            existingTask.setIsDone(!existingTask.getIsDone());
            existingTask.setModifiedDate(new Date());
            return taskRepository.save(existingTask);
        } else
        {
            throw new IllegalArgumentException(String.format("Task data with id %s not found" , id));
        }
    }
}
