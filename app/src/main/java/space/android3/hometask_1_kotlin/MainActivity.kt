package space.android3.hometask_1_kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var txt: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        txt = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { text ->
            if (text.resultCode == Activity.RESULT_OK) {
                val intent = text.data
                edt_txt1.setText(intent?.getStringExtra(MainActivity2.KEY))
            }
        }
        btn1.setOnClickListener {
            if (edt_txt1.text.isEmpty())
                Toast.makeText(applicationContext, R.string.something, Toast.LENGTH_SHORT).show()
            else {
                txt.launch(
                    Intent(this, MainActivity2::class.java).putExtra(
                        MainActivity2.KEY,
                        edt_txt1.text.toString()
                    )
                )
            }
        }
    }
}