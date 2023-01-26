package com.example.wallet

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallet.adapter.notificaton_adapter
import com.example.wallet.adapter.upcoming_payment_adapter
import com.example.wallet.databinding.FragmentHomeBinding
import com.example.wallet.databinding.FragmentNotificationBinding
import com.example.wallet.databinding.NotificationLayoutBinding
import com.example.wallet.model.Notification
import com.example.wallet.model.Transaction
import org.json.JSONArray


class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    val notifications = arrayListOf<Notification>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)



        val sharedPref = activity?.getSharedPreferences("notifications_list", Context.MODE_PRIVATE)
        val json = sharedPref?.getString("notifications", "")
        if (json != null) {
            if (json.isNotEmpty()) {
                notifications.clear()
                val jsonArray = JSONArray(json)
                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val title = jsonObject.getString("title")
                    val icon = jsonObject.getString("icon")
                    val detail = jsonObject.getString("detail")
                    notifications.add(Notification(title, icon, detail))
                }
            }
        }
        //
        binding.notificationView.layoutManager = GridLayoutManager(this.activity, 1)
        binding.notificationView.adapter = notificaton_adapter(this.activity, notifications)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationFragment().apply {
            }
    }
}