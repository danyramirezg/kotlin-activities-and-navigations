package com.dany.activitiesandnavigations

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


/*
    An activity is a single, focused thing that the user can do.
    Almost all activities interact with the user.

    There are two methods almost all subclasses of Activity will implement:

    - onCreate(Bundle): Initializes the activity.
    - onPause(): Is where you deal with the user pausing active interaction with the activity.

    For passing between activities:

    1. Create an instance of Intent class:
    var intent = Intent(this, SecondActivity::class.java)

    To send to the activity number x:
    intent.putExtra("key", "value")

    To start the activity:
    startActivity(intent)

    To receive from the activity that sent me:
        var getData = intent.extras
        getData.get()

*/

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonActivity1.setOnClickListener {
            // I want to move to the second activity:

            // Create an instance of the kotlin class Intent
            var intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("name", "Dany")
            intent.putExtra("Char", 'D')
            intent.putExtra("Integer", 25)

            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    // To receive data from the second activity:

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                var result = data?.extras?.get("return")
                result.let {
                    Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}


