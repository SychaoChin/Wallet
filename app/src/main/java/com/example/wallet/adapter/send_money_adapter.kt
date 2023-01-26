package com.example.wallet.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallet.HomeFragment
import com.example.wallet.R
import com.example.wallet.TransactionInfoFragment
import com.example.wallet.model.Transaction

internal class send_money_adapter(
    var context: FragmentActivity?,
    var arrayList: ArrayList<Transaction>,
) :
    RecyclerView.Adapter<send_money_adapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.send_money_profile)
        val name: TextView = view.findViewById(R.id.send_money_name)
        val money: TextView = view.findViewById(R.id.send_money_money)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.send_money, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val transactionList: Transaction = arrayList[position]
        context?.let {
            Glide.with(it)
                .load(transactionList.icon)
                .centerCrop()
                .dontAnimate()
                .into(holder.image)
        }

        holder.name.text = transactionList.name
        holder.money.text = transactionList.money.toString()
        holder.itemView.setOnClickListener {
            val fragment = TransactionInfoFragment()
            val bundle = Bundle()

            bundle.putString("name", transactionList.name)
            bundle.putDouble("money", transactionList.money)
            bundle.putString("icon", transactionList.icon)
            fragment.arguments = bundle

            val supportFragment1 =context?.supportFragmentManager?.beginTransaction()
            if (supportFragment1 != null) {
                supportFragment1.replace(R.id.flfragment, fragment)
                supportFragment1.disallowAddToBackStack()
                supportFragment1.commit()
            }
        }
    }


    override fun getItemCount(): Int {
        return arrayList.size
    }
}