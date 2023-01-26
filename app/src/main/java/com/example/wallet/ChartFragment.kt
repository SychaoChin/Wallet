package com.example.wallet

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallet.adapter.send_money_adapter
import com.example.wallet.adapter.upcoming_payment_adapter
import com.example.wallet.databinding.FragmentChartBinding
import com.example.wallet.databinding.FragmentHomeBinding
import com.example.wallet.model.Transaction
import org.json.JSONArray


class ChartFragment : Fragment() {
    private var _binding: FragmentChartBinding? = null
    private val binding get() = _binding!!
    val transactions = arrayListOf<Transaction>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChartBinding.inflate(inflater, container, false)
//        binding.tranSacBackButton.setOnClickListener{
//            val transaction = activity?.supportFragmentManager?.beginTransaction()
//            val secondFragment=HomeFragment()
//            if (transaction != null) {
//                transaction.replace(R.id.flfragment, secondFragment)
//                transaction.disallowAddToBackStack()
//                transaction.commit()
//            }
//        }


        val sharedPref = activity?.getSharedPreferences("transactions_list", Context.MODE_PRIVATE)
        val json = sharedPref?.getString("transactions", "")
        if (json != null) {
            if (json.isNotEmpty()) {
                transactions.clear()
                val jsonArray = JSONArray(json)
                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val icon = jsonObject.getString("icon")
                    val id = jsonObject.getInt("id")
                    val money = jsonObject.getDouble("money")
                    val name = jsonObject.getString("name")
                    transactions.add(Transaction(id, name, money, icon))
                }
            }
        }
        binding.upcomingPaymentChartView.layoutManager = GridLayoutManager(this.activity, 1)
        binding.upcomingPaymentChartView.adapter = upcoming_payment_adapter(this.activity, transactions)
        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChartFragment().apply {
            }
    }
}




