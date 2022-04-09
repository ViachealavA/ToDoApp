package com.vperelygin.todoapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.vperelygin.todoapp.R
import com.vperelygin.todoapp.viewmodel.ListTodoViewModel
import kotlinx.android.synthetic.main.fragment_to_do_list.*


class ToDoListFragment : Fragment() {

    private lateinit var viewModel:ListTodoViewModel
    private var todoListAdapter: TodoListAdapter = TodoListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListTodoViewModel::class.java)
        viewModel.refresh()

        recViewTodoList.layoutManager = LinearLayoutManager(context)
        recViewTodoList.adapter = todoListAdapter

        fabAdd.setOnClickListener {
            val action = ToDoListFragmentDirections.actionCreateTodo()
            Navigation.findNavController(it).navigate(action)
        }
        observeViewModel()
    }

    private fun observeViewModel() {
         viewModel.todoLD.observe(
             viewLifecycleOwner,
             Observer{
                 Log.d("LogD",it.toString())
//               todoListAdapter.updateTodoList(it)
//                 with(tvEmpty){
//                      visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
//                 }

             })
    }
}