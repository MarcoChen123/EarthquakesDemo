package com.example.earthquakesdemo.widget

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquakesdemo.R
import com.example.earthquakesdemo.data.EarthquakeBean
import com.example.earthquakesdemo.ui.MapActivity

class EarthquakeAdapter(var list: ArrayList<EarthquakeBean>?) :
    RecyclerView.Adapter<EarthquakeAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mag: TextView = view.findViewById(R.id.mag)
        var place: TextView = view.findViewById(R.id.place)
        var status: TextView = view.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_earthquake, parent, false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mag.text = list?.get(position)?.properties?.mag.toString()
        holder.place.text = list?.get(position)?.properties?.place
        holder.status.text = list?.get(position)?.properties?.status
        if(list?.get(position)?.properties?.mag?.compareTo(7.5) ?: 1 > 0){
            holder.itemView.setBackgroundColor(Color.RED)
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MapActivity::class.java).apply {
                putExtra("lat",list?.get(position)?.geometry?.coordinates?.get(1)?.toDouble())
                putExtra("lng",list?.get(position)?.geometry?.coordinates?.get(0)?.toDouble())
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    fun update(newList: ArrayList<EarthquakeBean>){
        list = newList
        notifyDataSetChanged()
    }
}