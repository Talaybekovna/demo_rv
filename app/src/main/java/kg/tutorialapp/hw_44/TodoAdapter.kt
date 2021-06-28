package kg.tutorialapp.hw_44

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val listener: TodoListener) : RecyclerView.Adapter<TodoViewHolder>() {

    private val todoList = mutableListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder.create(parent, listener)
    }

    override fun getItemCount() = todoList.count()

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    fun setItems(newTodo: Todo) {
        todoList.add(newTodo)
        notifyDataSetChanged()
    }

    fun delete(position: Int){
        todoList.removeAt(position)
        notifyDataSetChanged()
    }

}

