package syahputro.bimo.kade.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import syahputro.bimo.kade.R
import syahputro.bimo.kade.model.LeagueModel

class DetailActivity : AppCompatActivity() {
    companion object {
        val DATA: String = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getParcelableExtra<LeagueModel>(DATA)

        if (item == null){
            Toast.makeText(this, "NULL", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "${item.id}", Toast.LENGTH_SHORT).show()
        }

    }
}
