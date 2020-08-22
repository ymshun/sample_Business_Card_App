package com.example.helloworld

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        editBtn.setOnClickListener {
            // クリックイベント
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onStart() {
        super.onStart()

        val name = sharedPreferences?.getString("name", "No Data")
        val company = sharedPreferences?.getString("company", "No Data")

        sharedPreferences?.apply {
            val address = getString("address", "No Data")
            val tel = getString("tel", "No Data")

            roleText.text = getString("role", "No Data")
            nameText.text = name
            companyText.text = company
            telText.text = "TEL: $tel"
            addressText.text = "住所: $address"
        }
    }
}