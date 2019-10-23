package com.example.todoapp

import android.app.Application
import com.example.todoapp.config.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TodoApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidLogger()
      androidContext(this@TodoApplication)
      modules(listOf(appModules))
    }
  }
}
