package com.example.todoapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.todoapp.service.TodoService

class TodoViewModel(private val todoService: TodoService) : ViewModel() {

  private val _todos: MutableLiveData<List<String>> = MutableLiveData(listOf())

  init {
    _todos.value = listOf()
  }

  suspend fun getQuotes() = liveData {
    val result = todoService.getAll()
    emit(result)
  }
}
