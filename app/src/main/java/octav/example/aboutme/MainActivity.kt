package octav.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Last Part - Set the clicklistener for the button
        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text // we set the text of the nickname textview to the text in the nickname edit text
        editText.visibility = View.GONE // we hide the edit text
        view.visibility = View.GONE  // we hide the button
        nicknameTextView.visibility = View.VISIBLE  // we make the text view visible

        // Hide the Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}