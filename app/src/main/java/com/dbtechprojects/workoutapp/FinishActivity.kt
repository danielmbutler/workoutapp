package com.dbtechprojects.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sevenminuteworkout.SqliteOpenHelper
import kotlinx.android.synthetic.main.activity_finish.*
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        setSupportActionBar(toolbar_finish_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar_finish_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        btnFinish.setOnClickListener {
            finish()
        }

        addDateToDatabase()

    }

    private fun addDateToDatabase(){
        val calendar = Calendar.getInstance()
        val dateTime = calendar.time
        Log.i("FinishActivity", dateTime.toString())


        val sdf = SimpleDateFormat("dd MMM, yyyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)
        Log.i("FinishActivity", date.toString())

        val dbhandler = SqliteOpenHelper(this, null)

        dbhandler.addDate(date)


    }
}