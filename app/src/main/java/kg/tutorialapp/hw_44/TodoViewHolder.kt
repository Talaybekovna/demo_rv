package kg.tutorialapp.hw_44

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val tvText: TextView = itemView.findViewById(R.id.tv_todo)
    val btnDelete: TextView = itemView.findViewById(R.id.btn_delete)

    fun bind(title: Todo){
        tvText.text = title.todo
    }

    companion object{
        fun create(parent: ViewGroup,listener: TodoListener): TodoViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_holder, parent, false)
            val holder = TodoViewHolder(view)

            holder.btnDelete.setOnClickListener {
                val position: Int = holder.absoluteAdapterPosition
                listener.onButtonDelete(position)
            }

            return holder
        }
    }
}