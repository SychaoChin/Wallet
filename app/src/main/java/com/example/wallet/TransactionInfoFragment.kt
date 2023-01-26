package com.example.wallet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.wallet.databinding.FragmentHomeBinding
import com.example.wallet.databinding.FragmentTransactionInfoBinding


class TransactionInfoFragment : Fragment() {
    private var _binding: FragmentTransactionInfoBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
//        _binding = FragmentTransactionInfoBinding.inflate(inflater, container, false)
//        val sharedPref  = activity?.getSharedPreferences("transactions_list", Context.MODE_PRIVATE)
//        val json = sharedPref?.getString("transactions", "")
//        val gson = Gson()
//        val tranSac = gson.fromJson(json, Transaction::class.java)
//        Glide.with(requireContext()).load(tranSac.icon).into(binding.transactionInfoIcon)
//        binding.transactionNameTextview.text = tranSac.name
//        binding.transactionMoneyTextview.text = tranSac.money.toString()
//            return view

        _binding = FragmentTransactionInfoBinding.inflate(inflater, container, false)
        //val view = inflater.inflate(R.layout.fragment_transaction_info, container, false)
        //val id = arguments?.getString("id")
        val name = arguments?.getString("name")
        val money = arguments?.getDouble("money")
        val icon = arguments?.getString("icon")

        // Use the information from the arguments to display the transaction details on the UI
        binding.transactionNameTextview.text = name
        binding.transactionMoneyTextview.text = "+$" +  money.toString()
        Glide.with(requireContext()).load(icon).into(binding.transactionInfoIcon)

        return binding.root
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransactionInfoFragment().apply {

            }
    }
}






