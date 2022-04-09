package com.vperelygin.todoapp.view


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vperelygin.todoapp.R
import com.vperelygin.todoapp.model.Todo
import kotlinx.android.synthetic.main.todo_item_layout.view.*

class TodoListAdapter(val todoList: ArrayList<Todo>) :
    RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>() {

    class TodoListViewHolder( var   view: View) : RecyclerView.ViewHolder(view)


    @SuppressLint("NotifyDataSetChanged")
    fun updateTodoList(newTodoList: List<Todo>) {

        todoList.clear()
        todoList.addAll(newTodoList)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.todo_item_layout, parent, false)
        return TodoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        //возможно ошибка! в оригинале вместо itemView идет view
        holder.view.checkTask.text = todoList[position].title

        holder.view.checkTask.setOnCheckedChangeListener { _, _ -> }
    }

    override fun getItemCount(): Int {
        return this.todoList.size
    }

}