package syahputro.bimo.kade.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import syahputro.bimo.kade.R
import syahputro.bimo.kade.model.LeagueModel
import syahputro.bimo.kade.ui.detail.DetailActivity

class MainAdapter(private val context: Context, private val items: List<LeagueModel>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(leagueModel: LeagueModel) {
            val name = itemView.findViewById<TextView>(R.id.tvLeague)
            val image = itemView.findViewById<ImageView>(R.id.ivLeague)
            val kode = itemView.findViewById<TextView>(R.id.tvLeagueCode)
            val card = itemView.findViewById<CardView>(R.id.cardview)

            name.text = leagueModel.name
            kode.text = leagueModel.kode
            Glide.with(itemView).load(leagueModel.image).into(image)

            card.setOnClickListener {
                val position: Int = getAdapterPosition()
                Snackbar.make(it, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()

                val intent: Intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.DATA,adapterPosition)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list2, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])

    }

}