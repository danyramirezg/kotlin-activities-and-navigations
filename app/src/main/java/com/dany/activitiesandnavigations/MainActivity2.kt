package com.dany.activitiesandnavigations

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Create intent.extras to receive from the MainActivity

        var getData = intent.extras

        if (getData != null ){
            var name = getData.get("name")
            var char = getData.getChar("Char")
            var int = getData.getInt("Integer")

            Toast.makeText(this, name.toString() + " $char, $int", Toast.LENGTH_LONG).show()
        }

        // To send data to MainaAtivity
        buttonActivity2.setOnClickListener{

//            var intent2 = Intent(this, MainActivity::class.java)
//            startActivity(intent2)

            var returnIntent = this.intent
            returnIntent.putExtra("return","Hi, from Main Activity 2!")
            setResult(Activity.RESULT_OK, returnIntent)
            // finish, close the activity:
            finish()
        }
    }
}