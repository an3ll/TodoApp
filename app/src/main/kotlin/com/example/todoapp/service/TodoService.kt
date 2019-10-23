package com.example.todoapp.service

interface TodoService {
  fun getAll(): List<String>
}

class TodoServiceImpl : TodoService {

  //TODO: use database call instead of mock values
  override fun getAll() = listOf(
    "köpa mjölk",
    "diska",
    "gå ut med hund",
    "dansa",
    "betala räkningar",
    "farbror vattenmelon",
    "jag hette putte som grabb va",
    "brandsta city släckers"
  )
}
