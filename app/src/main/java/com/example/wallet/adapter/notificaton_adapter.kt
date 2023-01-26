package com.example.wallet.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallet.R
import com.example.wallet.TransactionInfoFragment
import com.example.wallet.model.Notification
import com.example.wallet.model.Transaction

internal class notificaton_adapter(
    var context: FragmentActivity?,
    var arrayList: ArrayList<Notification>,
) :
    RecyclerView.Adapter<notificaton_adapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.notification_icon)
        val title: TextView = view.findViewById(R.id.notification_title)
        val detail: TextView = view.findViewById(R.id.notification_detail)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.notification_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val notificaton: Notification = arrayList[position]
        context?.let {
            Glide.with(it)
                .load(notificaton.icon)
                .centerCrop()
                .dontAnimate()
                .into(holder.icon)
        }

        holder.title.text = notificaton.title
        holder.detail.text = notificaton.detail
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}