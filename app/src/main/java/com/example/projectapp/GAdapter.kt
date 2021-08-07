package com.example.projectapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call

class GAdapter(
    val context: Context,
    val usr: List<DataClass>,
): RecyclerView.Adapter<GAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name: TextView
        var DateofB: TextView
        var ImageP : ImageView

        init {
            Name = itemView.findViewById(R.id.name)
            DateofB = itemView.findViewById(R.id.dateob)

            ImageP = itemView.findViewById(R.id.Image)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.gridlayoutadapter, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = usr[position]

        holder.Name.text = "Name: " + current.person.name
        //holder.mUser.text = "Username: "+ current.username
        holder.DateofB.text= "D.O.B: " + current.person.birthday
        // holder.mAdd.text = "Address: " + current.address.suite + ", " + current.address.street

        Picasso
            .with(this.context)
            .load(current.person.image.original)
            .resize(400,200)
            .onlyScaleDown()
            .centerInside()
            .into(holder.ImageP)

    }

    override fun getItemCount() = usr.size
}