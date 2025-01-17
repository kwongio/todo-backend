package com.example.todobackend.todo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api/todos")
class TodoController(private val todoService: TodoService) {

    @GetMapping
    fun getAllTodos(): List<Todo> = todoService.getAllTodos()

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long): ResponseEntity<Todo> =
        ResponseEntity.ok(todoService.getTodoById(id))

    @PostMapping
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<Todo> =
        ResponseEntity.ok(todoService.createTodo(todo))

    @PutMapping("/{id}")
    fun updateTodo(
        @PathVariable id: Long,
        @RequestBody updatedTodo: Todo
    ): ResponseEntity<Todo> =
        ResponseEntity.ok(todoService.updateTodo(id, updatedTodo))

    @DeleteMapping("/{id}")
    fun deleteTodoById(@PathVariable id: Long): ResponseEntity<Void> {
        todoService.deleteTodoById(id)
        return ResponseEntity.noContent().build()
    }
}
