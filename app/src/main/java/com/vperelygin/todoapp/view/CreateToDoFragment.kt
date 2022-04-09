package com.vperelygin.todoapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.vperelygin.todoapp.R
import com.vperelygin.todoapp.model.Todo
import com.vperelygin.todoapp.viewmodel.DetailTodoViewModel
import kotlinx.android.synthetic.main.fragment_create_to_do.*


class CreateToDoFragment : Fragment() {
    private lateinit var viewModel: DetailTodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =  ViewModelProvider(this).get(DetailTodoViewModel::class.java)


          btnAdd.setOnClickListener {
            val todo = Todo(tvTitle.text.toString(),tvNote.text.toString())
            viewModel.addTodo(todo)
            //перевести
            Toast.makeText(it.context,getString(R.string.todo_created) ,Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }
    }

}