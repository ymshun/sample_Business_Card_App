package com.example.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        // 共有プリファレンス
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreferences.apply {
            nameEdit.setText(getString("name", ""))
            companyEdit.setText(getString("company", ""))
            roleEdit.setText(getString("role", ""))
            addressEdit.setText(getString("address", ""))
            telEdit.setText(getString("tel", ""))
        }


        //保存ボタン
        saveBtn.setOnClickListener {
            sharedPreferences.edit().putString("name", nameEdit.text.toString()).commit()

            sharedPreferences.edit().apply {
                putString("role", roleEdit.text.toString())
                putString("address", addressEdit.text.toString())
                putString("tel", telEdit.text.toString())
                putString("company", companyEdit.text.toString())
            }.commit()

            finish()
        }
        // キャンセルボタン
        cancelBtn.setOnClickListener {
            finish()
        }
    }

}