package com.example.volume.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.volume.R
import kotlinx.android.synthetic.main.activity_move_for_result.*

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {
    companion object {

        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btn_submit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_submit) {
            if (radio_group_number.checkedRadioButtonId != 0) {
                var value = 0
                when (radio_group_number.checkedRadioButtonId) {
                    R.id.rdb_50 -> value = rdb_50.text.toString().toInt()
                    R.id.rdb_100 -> value = rdb_100.text.toString().toInt()
                    R.id.rdb_150 -> value = rdb_150.text.toString().toInt()
                    R.id.rdb_200 -> value = rdb_200.text.toString().toInt()
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}
