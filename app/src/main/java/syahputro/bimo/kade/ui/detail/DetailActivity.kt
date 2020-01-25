package syahputro.bimo.kade.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import syahputro.bimo.kade.R

class DetailActivity : AppCompatActivity() {
    companion object{
        val DATA: String = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
