package com.example.todoapp.config.di

import com.example.todoapp.service.TodoService
import com.example.todoapp.service.TodoServiceImpl
import com.example.todoapp.view.TodoViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
  single<TodoService> { TodoServiceImpl() }
  viewModel { TodoViewModel(get()) }
}
