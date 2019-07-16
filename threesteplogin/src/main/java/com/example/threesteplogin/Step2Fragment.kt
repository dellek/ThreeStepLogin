package com.example.threesteplogin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation


class Step2Fragment : Fragment() {

    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnCancelStep2:Button
    private lateinit var btnConfirmStep2:Button
    companion object{
        @JvmStatic var bundle2Instantiated = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_step2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etUsername = view.findViewById(R.id.et_username)
        etPassword = view.findViewById(R.id.et_password)
        btnCancelStep2 = view.findViewById(R.id.btn_cancel_step2)

        if(bundle2Instantiated){
            etUsername.setText(arguments?.getString("username"))
            etPassword.setText(arguments?.getString("password"))
        }

        btnCancelStep2.setOnClickListener{
            if(etUsername.text.toString() != "" && etPassword.text.toString() != ""){
                etUsername.setText("")
                etPassword.setText("")
            }
            Navigation.findNavController(it).navigate(R.id.action_step2_to_step1,arguments)
        }

        btnConfirmStep2 = view.findViewById(R.id.btn_confirm_step2)

        btnConfirmStep2.setOnClickListener{
            if(etUsername.text.toString() == "" && etPassword.text.toString() == ""){
                Toast.makeText(context,"I campi sono obbligatori",Toast.LENGTH_SHORT).show()
            }else{
                bundle2Instantiated = true
                arguments?.putString("username",etUsername.text.toString())
                arguments?.putString("password",etPassword.text.toString())
                Navigation.findNavController(it).navigate(R.id.action_step2_to_step3,arguments)
            }
        }
    }
}
