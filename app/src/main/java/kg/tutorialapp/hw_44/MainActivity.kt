package kg.tutorialapp.hw_44

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), TodoListener{

    private lateinit var todoAdapter: TodoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAdd: Button
    private lateinit var etText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
        onButtonAdd()
    }

    private fun setup() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(this)
        recyclerView.adapter = todoAdapter

        btnAdd = findViewById(R.id.btn_add)
        etText = findViewById(R.id.et_text)
    }

    private fun onButtonAdd() {
        btnAdd.setOnClickListener {
            val text = etText.text.toString()

            if (text == "") {
                Toast.makeText(this, "Please, type some todo", Toast.LENGTH_LONG)
                    .show()
            } else {
                val title = Todo(text)
                todoAdapter.setItems(title)
            }
        }
    }

    override fun onButtonDelete(position: Int) {
        todoAdapter.delete(position)
        todoAdapter.notifyDataSetChanged()
    }

}




