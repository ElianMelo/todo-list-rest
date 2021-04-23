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

import com.elianmelo.todolist.domain.TodoListItem;
import com.elianmelo.todolist.service.TodoListItemService;

@RestController
@RequestMapping("/list-item")
class TodoListItemController {

        @Autowired
        private TodoListItemService service;

        @GetMapping
        public List<TodoListItem> all() {
                return service.todos();
        }
        
        @PostMapping
        public TodoListItem novo(@RequestBody TodoListItem list) {
                return service.novo(list);
        }

        @GetMapping("/{id}")
        public TodoListItem one(@PathVariable Integer id) throws Exception {
                return service.itemLista(id);
        }

        @PutMapping("/{id}")
        public TodoListItem replaceListItem(@RequestBody TodoListItem list, @PathVariable Integer id) {
                return service.atualiza(list, id);
        }

        @DeleteMapping("/{id}")
        void deleteListItem(@PathVariable Integer id) {
                service.deleteListItem(id);
        }
}