package com.elianmelo.todolist.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.elianmelo.todolist.domain.TodoListItem;
import com.elianmelo.todolist.repository.TodoListItemRepository;

@Service
public class TodoListItemService {
	
	@Autowired
	TodoListItemRepository repository;
	
	public List<TodoListItem> todos() {
		return repository.findAll();
	}
	
	public TodoListItem novo(TodoListItem lista) {
		return repository.save(lista);
	}
	
    public TodoListItem itemLista(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Item da Lista não encontrado"));
    }

    public TodoListItem atualiza(TodoListItem list, Integer id) {
    	list.setId(id);
        return repository.save(list);
	}

	public void deleteListItem(@PathVariable Integer id) {
	        repository.deleteById(id);
	}
	
}
