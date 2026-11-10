package com.example.corasocialsparks
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
private val TAG = "CoraSocialApp"
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)
val etTime = findViewById<EditText>(R.id.etTimeOfDay)
val btnGet = findViewById<Button>(R.id.btnGetSpark)
val btnReset = findViewById<Button>(R.id.btnReset)
val tvResult = findViewById<TextView>(R.id.tvSuggestion)
btnGet.setOnClickListener {
val rawInput = etTime.text.toString()
val time = rawInput.trim().lowercase()
if (time.isEmpty()) {
Toast.makeText(this, "Please enter time!", Toast.LENGTH_SHORT).show()
tvResult.text = "Please enter a time!"
return@setOnClickListener
}
val spark = if (time == "morning") "Morning: Send Good morning text to family"
else if (time == "mid-morning" || time == "mid morning") "Mid-morning: Thank a colleague"
else if (time == "afternoon") "Afternoon: Share funny meme"
else if (time.contains("snack")) "Snack Time: Send thinking of you message"
else if (time == "dinner") "Dinner: Call friend for 5-min catch-up"
else if (time == "after dinner" || time == "night" || time == "evening") "Night: Leave thoughtful comment"
else "Unknown. Try: Morning, Mid-morning, Afternoon, Snack Time, Dinner, After Dinner"
tvResult.text = spark
}
btnReset.setOnClickListener {
etTime.text.clear()
tvResult.text = "Your spark will appear here..."
}
}
}
