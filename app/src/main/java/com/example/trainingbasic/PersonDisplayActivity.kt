package com.example.trainingbasic

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_person_display.*
import java.util.*

class PersonDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_display)
        setSupportActionBar(toolbar)

        val person:Person = intent.getSerializableExtra("person") as Person
        val firstNameTextView: TextView = findViewById(R.id.first_name_textview)
        val lastNameTextView: TextView = findViewById(R.id.last_name_textview)
        val ageTextView: TextView = findViewById(R.id.age_textview)

        firstNameTextView.text = person.firstname
        lastNameTextView.text = person.lastname
        ageTextView.text = person.age.toString()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val saveButton: Button = findViewById(R.id.save_button)
        val cancelButton: Button = findViewById(R.id.cancel_button)

        saveButton.setOnClickListener{

            val newPerson: Person = Person("first name has been changed!", "last name has been changed too!", 10)
            val returnIntent: Intent = Intent()
            returnIntent.putExtra("return_person", newPerson)

            setResult(Activity.RESULT_OK, returnIntent)
            finish()

        }

        cancelButton.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()

        }
    }

}
