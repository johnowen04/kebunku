package com.john.kebunku.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.john.kebunku.R
import com.john.kebunku.util.SharedPreferencesManager
import com.john.kebunku.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {
    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        val username = DashboardFragmentArgs.fromBundle(requireArguments()).username

        viewModel.fetch(username, 1)

        observeViewModel()

        buttonLight.setOnClickListener {
            viewModel.turnLight()
            observeViewModel()
        }

        buttonAccount.setOnClickListener {
            val action = DashboardFragmentDirections.actionEditAccountFragment()
            Navigation.findNavController(it).navigate(action)
        }

        buttonLogout.setOnClickListener {
            SharedPreferencesManager.clearUsername(view.context)
            val action = DashboardFragmentDirections.actionLoginFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    private fun observeViewModel() {
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            textView4.text = "Hello, ${it.name}"
        }

        viewModel.kebunLiveData.observe(viewLifecycleOwner) {
            textWaterLevel.text = "${it.waterLevel * 100}%"
            textFertilizerLevel.text = "${it.fertilizerLevel * 100}%"
            textHumidityLevel.text = "${it.humidityLevel * 100}%"
            textLightIntensity.text = "${it.lightIntensity * 100}%"

            buttonLight.text = if (it.lightIsOn == 1) "Turn Off Light" else "Turn On Light"
        }
    }
}