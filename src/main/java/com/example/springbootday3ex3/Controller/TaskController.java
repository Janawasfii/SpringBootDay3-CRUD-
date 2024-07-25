package com.example.springbootday3ex3.Controller;


import com.example.springbootday3ex3.API.APIResponse;
import com.example.springbootday3ex3.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
   public ArrayList<Task> tasks = new ArrayList<>();

   @GetMapping("/get")
   public ArrayList<Task> getTask() {
      return tasks;
   }

   @PostMapping("/add")
   public APIResponse addTask(@RequestBody Task task) {
      tasks.add(task);
      return new APIResponse("Successfully added task");
   }

   @PutMapping("/update")
   public APIResponse updateTask(@PathVariable int index, @RequestBody Task task) {
      tasks.set(tasks.indexOf(task), task);
      return new APIResponse("Successfully updated task");
   }

   @DeleteMapping("/delete")
   public APIResponse deleteTask(@PathVariable int index) {
      tasks.remove(index);
      return new APIResponse("Successfully deleted task");
   }

   @PutMapping("/set/{index}")
   public APIResponse changeTask(@PathVariable int index) {
      if (tasks.get(index).getStatus().equalsIgnoreCase("not done")) {
         tasks.get(index).setStatus("Done");
         return new APIResponse("Successfully changed task");
      } else return new APIResponse("It's already done");
   }

   @GetMapping("/search/{str}")
   public Task searchTask(@PathVariable String str) {
      for (Task task : tasks) {
         if (task.getTitle().equals(str)) {
            return task;
         }
      }
      return null;
   }

}