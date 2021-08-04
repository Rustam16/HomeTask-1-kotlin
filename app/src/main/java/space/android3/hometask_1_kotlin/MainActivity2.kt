package space.android3.hometask_1_kotlin


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
        init()
    }

    private fun init() {
        text_view_second.text = intent.getStringExtra(KEY)
        btnSecond.setOnClickListener {
            if (edit_text2.text.isEmpty())
                Toast.makeText(applicationContext, R.string.something, Toast.LENGTH_SHORT).show()
            else {
                setResult(Activity.RESULT_OK, Intent().putExtra(KEY, edit_text2.text.toString()))
                finish()
            }
        }
    }

    companion object {
        const val KEY = "Key"
    }
}
