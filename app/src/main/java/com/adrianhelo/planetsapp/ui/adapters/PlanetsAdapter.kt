package com.adrianhelo.planetsapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.adrianhelo.planetsapp.R
import com.adrianhelo.planetsapp.ui.models.PlanestsModel

class PlanetsAdapter (private val itemList: ArrayList<PlanestsModel>): RecyclerView.Adapter<PlanetsAdapter.PlanetsVH>(){

    inner class PlanetsVH(private val itemView: View): RecyclerView.ViewHolder(itemView){

        val itemName: TextView
        val itemDescription: TextView
        val itemImage: ImageView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemDescription = itemView.findViewById(R.id.item_description)
            itemName = itemView.findViewById(R.id.item_tittle)
            itemView.setOnClickListener{
                Toast.makeText(itemView.context, "${itemList[layoutPosition].planetName} clicked!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetsVH {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)
        return PlanetsVH(view)
    }

    override fun onBindViewHolder(holder: PlanetsVH, position: Int) {
        holder.itemImage.setImageResource(itemList[position].planetImage)
        holder.itemName.text = itemList[position].planetName
        holder.itemDescription.text = itemList[position].planetDescription
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}