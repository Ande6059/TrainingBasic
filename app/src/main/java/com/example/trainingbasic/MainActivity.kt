package com.example.trainingbasic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.display_button)
        val firstNameEditText: EditText = findViewById(R.id.firstname_edittext)
        val lastNameEditText: EditText = findViewById(R.id.lastname_edittext)
        val ageEditText: EditText = findViewById(R.id.age_edittext)

        button.setOnClickListener{
            val person:Person = Person(firstNameEditText.text.toString(),
                lastname_edittext.text.toString(), ageEditText.text.toString().toInt(), Date())

            val intent: Intent = Intent(this, PersonDisplayActivity::class.java)
            intent.putExtra("person", person)
            startActivityForResult(intent, 12)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null){
        if (resultCode == Activity.RESULT_OK){
            //Do something
            val returnedPerson: Person = data.getSerializableExtra("return_person") as Person
            Log.d("EA", returnedPerson.toString())
        }

        }
        else if (resultCode == Activity.RESULT_CANCELED){
            Log.d("EA", "User cancelled!")
            //ignore
    }

    }

}
