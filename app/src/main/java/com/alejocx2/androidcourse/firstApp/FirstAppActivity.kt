package com.alejocx2.androidcourse.firstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.alejocx2.androidcourse.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        // Al arrancar la pantalla
        val btn_1 = findViewById<AppCompatButton>(R.id.btn_1)
        val edName = findViewById<AppCompatEditText>(R.id.edName)

        btn_1.setOnClickListener {
            val name = edName.text.toString()
            if (name.isNotEmpty()) {
                Log.i("Course Tag", "push me HARDER, ${edName.text.toString()}")
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }
    }
}