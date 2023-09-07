package com.sainrahmani.cityofindonesia

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCityAdapter(private val listCity: ArrayList<City>, private val detailInterface: DetailInterface) : RecyclerView.Adapter<ListCityAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_city, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listCity[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
//            val itemDetail = Intent(holder.itemView.context, DetailActivity::class.java)
//            itemDetail.putExtra(DetailActivity.CITY_NAME, name)
//            itemDetail.putExtra(DetailActivity.CITY_DESC, description)
//            itemDetail.putExtra(DetailActivity.CITY_LOGO, photo)
//            holder.itemView.context.startActivity(itemDetail)

            detailInterface.getDetail(name, description, photo)

        }
    }

    override fun getItemCount(): Int = listCity.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}