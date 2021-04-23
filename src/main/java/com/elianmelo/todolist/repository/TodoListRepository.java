package com.elianmelo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elianmelo.todolist.domain.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Integer>{

}
