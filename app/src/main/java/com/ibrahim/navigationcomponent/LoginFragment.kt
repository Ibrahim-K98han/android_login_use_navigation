package com.ibrahim.navigationcomponent

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {
    private lateinit var nameET:EditText
    private lateinit var emailET:EditText
    private lateinit var passET:EditText
    private lateinit var loginBtn:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameET = view.findViewById(R.id.inputNameET)
        emailET = view.findViewById(R.id.inputEmailET)
        passET = view.findViewById(R.id.inputPasswordET)
        loginBtn = view.findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val name = nameET.text.toString()
            val email = emailET.text.toString()
            val password = passET.text.toString()
            if (email.isEmpty()){
                emailET.error = getString(R.string.empty_email)
                return@setOnClickListener
            }else if(password.isEmpty()){
                passET.error = getString(R.string.empty_password)
                return@setOnClickListener
            }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailET.error = getString(R.string.invalid_email)
                return@setOnClickListener
            }
            val bundle = Bundle().apply {
                putString("name_value",name)
                putString("email_value",email)
            }
            findNavController().navigate(R.id.login_to_home,bundle)
        }

    }

}