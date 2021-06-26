package kg.tutorialapp.hw_44

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), TodoListener{

    private var titleList = mutableListOf<Todo>()
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var btnAdd: Button
    private lateinit var etText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
        onButtonAdd()
    }

    private fun setup() {
        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(this)
        rv.adapter = todoAdapter

        btnAdd = findViewById(R.id.btn_add)
        etText = findViewById(R.id.et_text)
    }

    private fun onButtonAdd() {
        btnAdd.setOnClickListener {
            val text = etText.text.toString()
            val title = Todo(text)
            todoAdapter.setItems(title)
        }
    }

    override fun onButtonDelete(position: Int) {
        todoAdapter.delete(position)
        todoAdapter.notifyDataSetChanged()
    }

}




