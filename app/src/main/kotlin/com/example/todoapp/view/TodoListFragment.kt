package com.example.todoapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.todoapp.R
import com.example.todoapp.databinding.TodoListFragmentBinding
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


class TodoListFragment : Fragment() {

  private lateinit var binding: TodoListFragmentBinding
  private val todoViewModel: TodoViewModel by viewModel()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = TodoListFragmentBinding.inflate(layoutInflater)
    return binding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    lifecycleScope.launch {
      println("testing to fetch list of strings async")
      todoViewModel.getQuotes().observe(this@TodoListFragment, Observer {
        val partAdapterStatic = ArrayAdapter<String>(this@TodoListFragment.requireContext(), R.layout.todo_list_item, R.id.todo_list_item_text, it)
        binding.todoListView.adapter = partAdapterStatic
      })
    }
  }
}
