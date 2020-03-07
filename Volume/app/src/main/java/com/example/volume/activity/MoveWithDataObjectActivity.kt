package com.example.volume.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.volume.R
import com.example.volume.model.Person
import kotlinx.android.synthetic.main.activity_move_with_data_object.*

class MoveWithDataObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data_object)

        if (intent.hasExtra(EXTRA_PERSON)) {
            val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)

            txt_receiver_data_obj_name.text = person.name
            txt_receiver_data_obj_age.text = person.age.toString()
            txt_receiver_data_obj_email.text = person.email
            txt_receiver_data_obj_address.text = person.address
        }
    }
}
