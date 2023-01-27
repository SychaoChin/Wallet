package com.example.wallet


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import android.widget.AdapterView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.model.Notification
import com.example.wallet.model.Transaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment=HomeFragment()
        val secondFragment=UserPageFragment()
        val thirdFragment=ChartFragment()
        val forthFragment=NotificationFragment()

        setCurrentFragment(firstFragment)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                if(firstFragment.isAdded() && firstFragment.isVisible()){
                    val nestedScrollView = firstFragment.view?.findViewById<NestedScrollView>(R.id.nestedScroll)
                    nestedScrollView?.postDelayed( { nestedScrollView.smoothScrollTo(0, 0) }, 100)
                }
            }
            R.id.chartFragment -> {
            if(thirdFragment.isAdded() && thirdFragment.isVisible()){
                val nestedScrollView = thirdFragment.view?.findViewById<NestedScrollView>(R.id.chart_nestedScroll)
                nestedScrollView?.postDelayed({ nestedScrollView.smoothScrollTo(0, 0) }, 100)
            }
        }
                R.id.notificationFragment -> {
                    if(forthFragment.isAdded() && forthFragment.isVisible()){
                        val recyclerView = forthFragment.view?.findViewById<RecyclerView>(R.id.notification_View)
                        recyclerView?.post { recyclerView.scrollToPosition(0) }
                    }
               }
            }
        }
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment->setCurrentFragment(firstFragment)
                R.id.userPageFragment->setCurrentFragment(secondFragment)
                R.id.chartFragment->setCurrentFragment(thirdFragment)
                R.id.notificationFragment->setCurrentFragment(forthFragment)
            }
            true
        }

        //add test notification
//        val notifications = arrayListOf<Notification>()
//        notifications.add(Notification("Transaction Success","https://media.discordapp.net/attachments/787991185427922945/1068084096758198382/tick.png" , "We have successfully received your payment for ..."))
//        notifications.add(Notification("Transaction Failed", "https://media.discordapp.net/attachments/787991185427922945/1068083396544311306/close.png","We cannot proceed your transaction now. Please try again later."))
//        notifications.add(Notification("Transaction Report", "https://media.discordapp.net/attachments/787991185427922945/1068083396863070248/history.png","You can see your transaction history in this app."))
//        notifications.add(Notification("Transaction Success","https://media.discordapp.net/attachments/787991185427922945/1068084096758198382/tick.png" , "We have successfully received your payment for ..."))
//        notifications.add(Notification("Transaction Failed", "https://media.discordapp.net/attachments/787991185427922945/1068083396544311306/close.png","We cannot proceed your transaction now. Please try again later."))
//        notifications.add(Notification("Transaction Report", "https://media.discordapp.net/attachments/787991185427922945/1068083396863070248/history.png","You can see your transaction history in this app."))
//        val gson = Gson()
//        val json = gson.toJson(notifications)
//        val sharedPref = getSharedPreferences("notifications_list", Context.MODE_PRIVATE)
//        val editor = sharedPref.edit()
//        editor.clear()
//        editor.putString("notifications", json)
//        editor.apply()


        //add test transactions

//        val transactions = arrayListOf<Transaction>()
//        transactions.add(Transaction(1, "Transaction 1",500.00 , "https://cdn.discordapp.com/emojis/949150188197531648.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(2, "Transaction 2", 1000.00,"https://cdn.discordapp.com/emojis/948911767310975037.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(3, "Transaction 3", 1500.00,"https://cdn.discordapp.com/emojis/948911453321179137.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(4, "Transaction 4",500.00 , "https://cdn.discordapp.com/emojis/949150188197531648.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(5, "Transaction 5", 1000.00,"https://cdn.discordapp.com/emojis/948911767310975037.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(6, "Transaction 6", 1500.00,"https://cdn.discordapp.com/emojis/948911453321179137.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(1, "Transaction 1",500.00 , "https://cdn.discordapp.com/emojis/949150188197531648.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(2, "Transaction 2", 1000.00,"https://cdn.discordapp.com/emojis/948911767310975037.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(3, "Transaction 3", 1500.00,"https://cdn.discordapp.com/emojis/948911453321179137.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(4, "Transaction 4",500.00 , "https://cdn.discordapp.com/emojis/949150188197531648.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(5, "Transaction 5", 1000.00,"https://cdn.discordapp.com/emojis/948911767310975037.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(6, "Transaction 6", 1500.00,"https://cdn.discordapp.com/emojis/948911453321179137.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(1, "Transaction 1",500.00 , "https://cdn.discordapp.com/emojis/949150188197531648.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(2, "Transaction 2", 1000.00,"https://cdn.discordapp.com/emojis/948911767310975037.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(3, "Transaction 3", 1500.00,"https://cdn.discordapp.com/emojis/948911453321179137.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(4, "Transaction 4",500.00 , "https://cdn.discordapp.com/emojis/949150188197531648.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(5, "Transaction 5", 1000.00,"https://cdn.discordapp.com/emojis/948911767310975037.webp?size=128&quality=lossless"))
//        transactions.add(Transaction(6, "Transaction 6", 1500.00,"https://cdn.discordapp.com/emojis/948911453321179137.webp?size=128&quality=lossless"))
//        val gson = Gson()
//        val json = gson.toJson(transactions)
//        val sharedPref = getSharedPreferences("transactions_list", Context.MODE_PRIVATE)
//        val editor = sharedPref.edit()
//        //editor.clear()
//        editor.putString("transactions", json)
//        editor.apply()


    }


    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment,fragment)
            commit()
        }


}



