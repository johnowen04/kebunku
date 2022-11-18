package com.john.kebunku.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.john.kebunku.R
import com.john.kebunku.viewmodel.CreateAccountViewModel
import kotlinx.android.synthetic.main.fragment_create_account.*
import kotlinx.android.synthetic.main.fragment_edit_account.*

class CreateAccountFragment : Fragment() {
    private lateinit var viewModel: CreateAccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CreateAccountViewModel::class.java)

        buttonRegisterUser.setOnClickListener {
            if (editPasswordCreateFragment.text.toString() == editRetypePasswordCreateFragment.toString()) {
                viewModel.register(
                    editUsernameCreateFragment.text.toString(),
                    editNameCreateFragment.text.toString(),
                    editPasswordCreateFragment.text.toString()
                )

                Navigation.findNavController(it).popBackStack()
            }
        }
    }
}