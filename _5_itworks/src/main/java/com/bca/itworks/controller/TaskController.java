package com.bca.itworks.controller;


import com.bca.itworks.model.Task;
import com.bca.itworks.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "")
@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("")
    public ResponseEntity<List<Task>> getAll()
    {
        log.info("Getting task list....");

        try{
            List<Task> tasks = taskService.getAll();
            if(tasks.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("")
    public ResponseEntity<Task> task(@RequestBody Task task){
        try{
            if(task.getTitle() == null || !StringUtils.hasText(task.getTitle()))
            {
                log.info("To add Item to your list, you must give it a title");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(taskService.addTask(task) , HttpStatus.BAD_REQUEST);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("")
    public ResponseEntity<Task> updateTask(@RequestBody Map<String, String> body)
    {
        try{
            if(body.get("id") == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(taskService.updateTask(body.get("id")),HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
