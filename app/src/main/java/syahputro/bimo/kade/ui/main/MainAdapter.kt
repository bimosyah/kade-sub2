package syahputro.bimo.kade.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import syahputro.bimo.kade.R
import syahputro.bimo.kade.model.LeagueModel

class MainAdapter(private val items: List<LeagueModel>, listener: ItemClickListener) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    val callback:ItemClickListener = listener

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(leagueModel: LeagueModel) {
            val name = itemView.findViewById<TextView>(R.id.tvLeague)
            val image = itemView.findViewById<ImageView>(R.id.ivLeague)
            val kode = itemView.findViewById<TextView>(R.id.tvLeagueCode)

            name.text = leagueModel.name
            kode.text = leagueModel.kode
            Glide.with(itemView).load(leagueModel.image).into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener{
            callback.itemClick(items[position])
        }
    }
}


interface ItemClickListener {
    fun itemClick(leagueModel: LeagueModel)
}