package com.cst.contacts.contacts

import android.content.Intent
import android.graphics.Color
import android.graphics.ColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cst.contacts.R
import com.cst.contacts.details.ContactDetailedActivity
import com.cst.contacts.donottouch.ContactInfo
import kotlin.random.Random


class Adapter(private val contacts: List<ContactInfo>) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vName: TextView =
            view.findViewById(R.id.contactNameId) as TextView
        val vImage: TextView = view.findViewById(R.id.mainFirstLetter) as TextView
        val vShapeColor:ImageView = view.findViewById(R.id.mainShapeImage) as ImageView
        var color:Int = 0
//        val color: Int = vShapeColor.colorFilter.hashCode()
        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                val intent: Intent = Intent(v.context, ContactDetailedActivity::class.java).apply {
                    putExtra("id", contacts[position].id)
                    putExtra("shapeColor", color)
                }
                v.context.startActivity(intent)
            }
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.vImage.text = contacts[position].name.substring(0, 1)
        holder.vName.text = contacts[position].name
        holder.color = getRandomColor()
        holder.vShapeColor.setColorFilter(holder.color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.lsit_layout, parent, false)
        return MyViewHolder(itemView)
    }
    private fun getRandomColor(): Int {
        return Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))

    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}