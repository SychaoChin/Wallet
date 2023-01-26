package com.example.wallet.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallet.CreditCardInfoFragment
import com.example.wallet.HomeFragment
import com.example.wallet.R
import com.example.wallet.TransactionInfoFragment
import com.example.wallet.model.Transaction

internal class upcoming_payment_adapter(
    var context: FragmentActivity?,
    var arrayList: ArrayList<Transaction>,
    //var context1: TransactionInfoFragment?

) : RecyclerView.Adapter<upcoming_payment_adapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.upcoming_payment_icon)
        val name: TextView = view.findViewById(R.id.upcoming_payment_name)
        val money: TextView = view.findViewById(R.id.upcoming_payment_money)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.upcoming_payment, parent, false)
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
        holder.money.text = "+$" + transactionList.money.toString()

        holder.itemView.setOnClickListener {
            val fragment = TransactionInfoFragment()
            val bundle = Bundle()

            bundle.putString("name", transactionList.name)
            bundle.putDouble("money", transactionList.money)
            bundle.putString("icon", transactionList.icon)
            fragment.arguments = bundle

            val supportFragment =context?.supportFragmentManager?.beginTransaction()
            if (supportFragment != null) {
                supportFragment.replace(R.id.flfragment, fragment)
                supportFragment.disallowAddToBackStack()
                supportFragment.commit()
            }
        }

//            if (supportFragmentManager != null) {
//                supportFragmentManager.beginTransaction().replace(R.id.flfragment, fragment).commit()
//            }
        }





    override fun getItemCount(): Int {
        return arrayList.size
    }
}