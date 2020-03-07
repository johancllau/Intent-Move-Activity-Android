package com.example.volume.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.volume.R
import kotlinx.android.synthetic.main.activity_move_with_data.*

class MoveWithDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        if (intent.hasExtra(EXTRA_NAME) && intent.hasExtra(EXTRA_AGE)) {
            val name: String = intent.getStringExtra(EXTRA_NAME)
            val age: Int = intent.getIntExtra(EXTRA_AGE, 0)

            txt_receiver_data_name.text = name
            txt_receiver_data_age.text = age.toString()
        }
    }
}
