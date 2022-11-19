package com.john.kebunku.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.john.kebunku.R
import com.john.kebunku.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        buttonLogin.setOnClickListener {
            var login = true

            if (editUsername.text.toString().isEmpty()) {
                login = false
                Toast.makeText(view.context, "Username cannot be empty", Toast.LENGTH_SHORT).show()
            } else if (editPassword.text.toString().isEmpty()) {
                login = false
                Toast.makeText(view.context, "Password cannot be empty", Toast.LENGTH_SHORT).show()
            }

            if (login) {
                viewModel.login(editUsername.text.toString(), editPassword.text.toString())

                viewModel.userLiveData.observe(viewLifecycleOwner) {
                    if (it != null) {
                        Toast.makeText(view.context, "Login successful", Toast.LENGTH_SHORT).show()
                        val action = LoginFragmentDirections.actionDashboardFragment(editUsername.text.toString())
                        Navigation.findNavController(view).navigate(action)
                    } else {
                        Toast.makeText(view.context, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        buttonRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionCreateAccountFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}