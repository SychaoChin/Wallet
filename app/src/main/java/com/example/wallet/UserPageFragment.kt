package com.example.wallet

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wallet.databinding.FragmentUserPageBinding
import com.example.wallet.model.User
import com.google.gson.Gson

class UserPageFragment : Fragment() {
    private var _binding: FragmentUserPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserPageBinding.inflate(inflater, container, false)
        val sharedPref  = activity?.getSharedPreferences("users_list", Context.MODE_PRIVATE)
        val json = sharedPref?.getString("users", "")
        val gson = Gson()
        val user = gson.fromJson(json, User::class.java)
        binding.usernametext.text = user.username
        binding.titletext.text = user.title
        binding.infoId.text = user.id.toString()
        binding.infoPhone.text = user.phone
        binding.infoTitle.text = user.title
        binding.infoEmail.text = user.email
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserPageFragment().apply {

            }
    }
}