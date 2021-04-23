package com.elianmelo.todolist.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.elianmelo.todolist.domain.TodoList;
import com.elianmelo.todolist.repository.TodoListRepository;

@Service
public class TodoListService {
	
	@Autowired
	TodoListRepository repository;
	
	public List<TodoList> todos() {
		return repository.findAll();
	}
	
	public TodoList novo(TodoList lista) {
		return repository.save(lista);
	}
	
    public TodoList lista(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Lista não encontrada"));
    }

    public TodoList atualiza(TodoList list, Integer id) {
    	list.setId(id);
        return repository.save(list);
	}

	public void deleteList(@PathVariable Integer id) {
	        repository.deleteById(id);
	}
	
}
