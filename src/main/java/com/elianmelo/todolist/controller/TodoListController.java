package com.elianmelo.todolist.controller;

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

import com.elianmelo.todolist.domain.TodoList;
import com.elianmelo.todolist.service.TodoListService;

@RestController
@RequestMapping("/list")
class TodoListController {

        @Autowired
        private TodoListService service;

        @GetMapping
        public List<TodoList> all() {
                return service.todos();
        }
        
        @PostMapping
        public TodoList novo(@RequestBody TodoList list) {
                return service.novo(list);
        }

        @GetMapping("/{id}")
        public TodoList one(@PathVariable Integer id) throws Exception {
                return service.lista(id);
        }

        @PutMapping("/{id}")
        public TodoList replaceList(@RequestBody TodoList list, @PathVariable Integer id) {
                return service.atualiza(list, id);
        }

        @DeleteMapping("/{id}")
        void deleteList(@PathVariable Integer id) {
                service.deleteList(id);
        }
}