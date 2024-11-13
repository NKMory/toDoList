//Even though it shows an error do NOT delete it
package com.nkmory.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nkmory.todolist.models.ToDo;
import com.nkmory.todolist.services.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService todoService;

    // Inject the ToDoService into the controller
    @Autowired
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<ToDo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo){
        ToDo savedToDo = ToDoService.createToDo(toDo);
        return new ResponseEntity<>(savedToDo, HttpStatus.CREATED);
    }
}
