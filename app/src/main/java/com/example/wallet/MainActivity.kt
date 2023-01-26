package com.example.wallet


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.wallet.model.Transaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    lateinit var transactionArrayList: ArrayList<Transaction>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment=HomeFragment()
        val secondFragment=UserPageFragment()
        val thirdFragment=ChartFragment()
        val forthFragment=NotificationFragment()
        //val thirdFragment=ThirdFragment()

// hello world

        setCurrentFragment(firstFragment)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment->setCurrentFragment(firstFragment)
                R.id.userPageFragment->setCurrentFragment(secondFragment)
                R.id.chartFragment->setCurrentFragment(thirdFragment)
                R.id.notificationFragment->setCurrentFragment(forthFragment)
            }
            true
        }


        //add test transactions
//        val transactions = arrayListOf<Transaction>()
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
//        editor.clear()
//        editor.putString("transactions", json)
//        editor.apply()

    }


    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment,fragment)
            commit()
        }


}



