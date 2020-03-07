 package com.example.volume.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.volume.R
import com.example.volume.model.Person
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity(), View.OnClickListener {

     companion object {
         private const val STATE_RESULT = "state_result"
         private const val STATE_RESULT_FROM_ANOTHER_ACTIVITY = "state_result_from_another_activity"
         private const val REQUEST_CODE = 100
     }

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         btn_calculate.setOnClickListener(this)
         btn_move_activity.setOnClickListener(this)
         btn_move_activity_with_data.setOnClickListener(this)
         btn_move_activity_with_object.setOnClickListener(this)
         btn_move_to_dial_number.setOnClickListener(this)
         btn_move_activity_to_get_result.setOnClickListener(this)

         if (savedInstanceState != null) {
             val result = savedInstanceState.getString(STATE_RESULT) as String
             val resultFromAnotherActivity = savedInstanceState.getString(STATE_RESULT_FROM_ANOTHER_ACTIVITY) as String

             txt_result.text = result
             txt_result_from_activity.text = resultFromAnotherActivity
         }

    }

     override fun onSaveInstanceState(outState: Bundle) {
         super.onSaveInstanceState(outState)
         outState.putString(STATE_RESULT, txt_result.text.toString())
         outState.putString(STATE_RESULT_FROM_ANOTHER_ACTIVITY, txt_result_from_activity.text.toString())
     }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)

         if (requestCode == REQUEST_CODE) {
             if (resultCode == MoveForResultActivity.RESULT_CODE) {
                 val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                 txt_result_from_activity.text = selectedValue.toString()
             }
         }
     }

     override fun onClick(v: View?) {
         when (v?.id ) {
             R.id.btn_calculate -> {
                 val inputLength: String = edit_length.text.toString().trim()
                 val inputWidth: String = edit_width.text.toString().trim()
                 val inputHeight: String = edit_height.text.toString().trim()

                 var isEmptyField = false

                 when {
                     inputLength.isEmpty() -> {
                         isEmptyField = true
                         edit_length.error = "Field ini tidak boleh kosong"
                     }
                     inputWidth.isEmpty() -> {
                         isEmptyField = true
                         edit_width.error = "Field ini tidak boleh kosong"
                     }
                     inputHeight.isEmpty() -> {
                         isEmptyField = true
                         edit_height.error = "Field ini tidak boleh kosong"
                     }
                 }

                 if (!isEmptyField) {
                     val volume: Double = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                     txt_result.text = volume.toString()
                 }
             }
             R.id.btn_move_activity -> {
                 val intentMoveToActivity = Intent(this, MoveActivity::class.java)
                 startActivity(intentMoveToActivity)
             }
             R.id.btn_move_activity_with_data -> {
                 val intentMoveToActivityWithData = Intent(this, MoveWithDataActivity::class.java)
                 intentMoveToActivityWithData .putExtra(MoveWithDataActivity.EXTRA_NAME, "Johan cllau")
                 intentMoveToActivityWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                 startActivity(intentMoveToActivityWithData )
             }
             R.id.btn_move_activity_with_object -> {
                 val person = Person("Johan cllau", 20, "cllaujhohan@gmail.com", "Janti")

                 val intentMoveToActivityWithDataObject = Intent(this, MoveWithDataObjectActivity::class.java)
                 intentMoveToActivityWithDataObject.putExtra(MoveWithDataObjectActivity.EXTRA_PERSON, person)
                 startActivity(intentMoveToActivityWithDataObject)
             }
             R.id.btn_move_to_dial_number -> {
                 val phoneNumber = "082237064375"
                 val intentDialNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                 startActivity(intentDialNumber)
             }
             R.id.btn_move_activity_to_get_result -> {
                 val intentMoveActivityForGetResult = Intent(this, MoveForResultActivity::class.java)
                 startActivityForResult(intentMoveActivityForGetResult, REQUEST_CODE)
             }
         }
     }
 }
