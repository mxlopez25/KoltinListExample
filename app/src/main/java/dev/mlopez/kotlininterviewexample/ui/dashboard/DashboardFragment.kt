package dev.mlopez.kotlininterviewexample.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.mlopez.kotlininterviewexample.R
import dev.mlopez.kotlininterviewexample.databinding.FragmentDashboardBinding
import dev.mlopez.kotlininterviewexample.models.UserAdapter

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
//
//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val rvUsers: RecyclerView = binding.rvUsers
        rvUsers.adapter = UserAdapter(activity, dashboardViewModel.userList.value)
        rvUsers.layoutManager = LinearLayoutManager(activity)

        dashboardViewModel.userList.observe(viewLifecycleOwner, {
            rvUsers.adapter = UserAdapter(activity, dashboardViewModel.userList.value)
            rvUsers.layoutManager = LinearLayoutManager(activity)
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}