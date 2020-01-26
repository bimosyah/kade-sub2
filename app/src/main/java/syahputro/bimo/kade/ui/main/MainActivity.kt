package syahputro.bimo.kade.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import syahputro.bimo.kade.R
import syahputro.bimo.kade.model.LeagueModel
import syahputro.bimo.kade.ui.detail.DetailActivity

class MainActivity : AppCompatActivity(), ItemClickListener {
    private var items: MutableList<LeagueModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.rv_league)
        initData()

        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        list.adapter = MainAdapter(items,this)
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.league_name)
        val id = resources.getStringArray(R.array.id_league)
        val image = resources.obtainTypedArray(R.array.league_image)
        val desc = resources.getStringArray(R.array.league_desc)
        val kode = resources.getStringArray(R.array.league_code)

        items.clear()
        for (i in name.indices) {
            items.add(
                LeagueModel(
                    id[i],
                    name[i],
                    image.getResourceId(i, 0),
                    desc[i],
                    kode[i]
                )
            )
        }
        image.recycle()
    }

    override fun itemClick(leagueModel: LeagueModel) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.DATA,leagueModel)
        startActivity(intent)
    }
}
