package com.example.todobackend.todo

import org.springframework.stereotype.Service

@Service
class TodoService(private val todoRepository: TodoRepository) {

    fun getAllTodos(): List<Todo> = todoRepository.findAll()

    fun getTodoById(id: Long): Todo = todoRepository.findById(id).orElseThrow { RuntimeException("Todo not found") }

    fun createTodo(todo: Todo): Todo = todoRepository.save(todo)

    fun updateTodo(id: Long, updatedTodo: Todo): Todo {
        val existingTodo = getTodoById(id)
        val todoToUpdate = existingTodo.copy(
            title = updatedTodo.title, completed = updatedTodo.completed
        )
        return todoRepository.save(todoToUpdate)
    }

    fun deleteTodoById(id: Long) {
        if (!todoRepository.existsById(id)) {
            throw RuntimeException("Todo not found")
        }
        todoRepository.deleteById(id)
    }
}
