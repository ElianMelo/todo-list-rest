package com.elianmelo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elianmelo.todolist.domain.TodoListItem;

@Repository
public interface TodoListItemRepository extends JpaRepository<TodoListItem, Integer>{

}
