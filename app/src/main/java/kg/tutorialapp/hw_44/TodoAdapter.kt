package kg.tutorialapp.hw_44

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val listener: TodoListener) : RecyclerView.Adapter<TodoViewHolder>() {

    private val titleList = mutableListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder.create(parent, listener)
    }

    override fun getItemCount() = titleList.count()

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(titleList[position])
    }

    fun setItems(newTitle: Todo) {
        titleList.add(newTitle)
        notifyDataSetChanged()
    }

    fun delete(position: Int){
        titleList.removeAt(position)
        notifyDataSetChanged()
    }

}

