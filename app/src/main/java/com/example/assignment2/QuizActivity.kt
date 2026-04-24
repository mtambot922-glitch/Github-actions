package com.example.assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        val txtResponse = findViewById<TextView>(R.id.txtResponse)
        val btnHack = findViewById<Button>(R.id.btnHack)
        val btnMyth = findViewById<Button>(R.id.btnMyth)
        val btnNext = findViewById<Button>(R.id.btnNext)

        var index = 0

        val questions = arrayOf(
            "To make a stale loaf of bread fresh again, you should freeze it.",
            "Putting a metal spoon in a bottle of champagne keeps it bubbly.",
            "A wet umbrella can be used to go up a chimney when down, but not down when up.",
            "Humans share over 90% of their DNA with bananas.",
            "Sugar causes hyperactivity in children."
        )

        val answers = arrayOf(
            false, // Myth
            false, // Myth
            true, // Hack
            false, // Myth
            true, // Hack
        )

        txtQuestion.text = questions[index]
        btnNext.visibility = android.view.View.INVISIBLE

        btnMyth.setOnClickListener {
            if (answers[index] == false) {
                txtResponse.text = "Correct!"
                btnNext.visibility = android.view.View.VISIBLE
            } else {
                txtResponse.text = "Wrong, try again!"
            }
        }

        btnHack.setOnClickListener {
            if (answers[index] == true) {
                txtResponse.text = "Correct!"
                btnNext.visibility = android.view.View.VISIBLE
            } else {
                txtResponse.text = "Wrong, try again!"
            }
        }

        btnNext.setOnClickListener {
            index++
            if (index < questions.size) {
                txtQuestion.text = questions[index]
                txtResponse.text = "Hack or Myth?"
                btnNext.visibility = android.view.View.INVISIBLE
            } else {
                txtResponse.text = "Quiz Finished!"
                btnNext.text = "Finish"
                btnNext.setOnClickListener {
                    finish()
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
