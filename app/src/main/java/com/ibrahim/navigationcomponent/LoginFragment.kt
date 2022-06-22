package com.ibrahim.navigationcomponent

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class LoginFragment : Fragment() {
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
        emailET = view.findViewById(R.id.inputEmailET)
        passET = view.findViewById(R.id.inputPasswordET)
        loginBtn = view.findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
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

        }

    }

}