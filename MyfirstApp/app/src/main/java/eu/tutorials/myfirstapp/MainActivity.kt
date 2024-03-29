package eu.tutorials.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickMe = findViewById<Button>(R.id.mybutton)
//        btnClickMe.text = "Change Button Text"
        val my_text = findViewById<TextView>(R.id.textView)
        var timesClicked = 0

        btnClickMe.setOnClickListener{
            timesClicked = timesClicked + 1
            btnClickMe.text = "You just clicked on me!"
            my_text.text = timesClicked.toString()
            Toast.makeText(this, "Hey Logan!", Toast.LENGTH_LONG).show()
        }

    }
}