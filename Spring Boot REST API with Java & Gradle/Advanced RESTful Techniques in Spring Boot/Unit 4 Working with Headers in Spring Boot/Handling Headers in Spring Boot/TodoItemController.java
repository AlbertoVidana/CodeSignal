package com.codesignal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TodoItemController {
    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/todos")
    public ResponseEntity<List<TodoItem>> getAllTodoItems(@RequestHeader HttpHeaders headers) {
        headers.forEach((key, value) -> System.out.println(key + ": " + String.join(",", value)));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Custom-Header", "CustomHeaderValue");
        return new ResponseEntity<>(todoItemRepository.findAll(), responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/todos/{id}")
    public TodoItem getTodoItemById(@PathVariable int id, @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String acceptLanguage) {
        System.out.println("Accept-Language: " + acceptLanguage);
        return todoItemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo item with id " + id + " not found"));
    }
}