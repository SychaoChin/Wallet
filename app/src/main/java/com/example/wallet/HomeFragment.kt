package com.example.wallet

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallet.adapter.send_money_adapter
import com.example.wallet.adapter.upcoming_payment_adapter
import com.example.wallet.databinding.FragmentHomeBinding
import com.example.wallet.model.Transaction
import org.json.JSONArray


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val transactions = arrayListOf<Transaction>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // This code is a fragment class for an Android app called "HomeFragment".
        // It handles the creation and initialization of the layout for the fragment.
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        //Hello There
            // First, it uses a binding object to inflate the layout for the fragment.
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


        // Then it retrieves shared preferences data with the key "transactions_list"
        // If the json string is not null, it processes the json array by adding the transaction objects to a transactions list.
        binding.sendMoneyView.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)
        binding.sendMoneyView.adapter = send_money_adapter(this.activity, transactions)
        binding.upcomingPaymentView.layoutManager = GridLayoutManager(this.activity, 1)
        binding.upcomingPaymentView.adapter = upcoming_payment_adapter(this.activity, transactions)



        // It sets up the layout manager and adapter for the send_money_view and upcoming_payment_view.
        binding.homeCreditCard.setOnClickListener{
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val secondFragment=CreditCardInfoFragment()
            if (transaction != null) {
                transaction.replace(R.id.flfragment, secondFragment)
                transaction.disallowAddToBackStack()
                transaction.commit()
            }
        }

        // It also sets up a click listener for the homeCreditCard view. When clicked, it replaces the current fragment with the CreditCardInfoFragment.
        // Finally, the root view of the binding object is returned to be displayed in the app.
        return binding.root
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
        }
    }


}