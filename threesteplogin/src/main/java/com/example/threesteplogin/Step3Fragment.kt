package com.example.threesteplogin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation

class Step3Fragment : Fragment() {

    private lateinit var tvRegistrationComplete:TextView
    private lateinit var tvYourName:TextView
    private lateinit var tvYourSurname:TextView
    private lateinit var tvYourEmail:TextView
    private lateinit var tvYourUsername:TextView
    private lateinit var tvYourPassword:TextView
    private lateinit var btnUndo:Button
    private lateinit var btnConfirmStep3:Button
    private lateinit var bundle: Bundle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_step3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvRegistrationComplete = view.findViewById(R.id.tv_registration_complete)
        tvYourName = view.findViewById(R.id.tv_your_name)
        tvYourSurname = view.findViewById(R.id.tv_your_surname)
        tvYourEmail = view.findViewById(R.id.tv_your_email)
        tvYourUsername = view.findViewById(R.id.tv_your_username)
        tvYourPassword = view.findViewById(R.id.tv_your_password)
        btnUndo = view.findViewById(R.id.btn_undo)
        bundle = arguments!!
        tvYourName.text = bundle.getString("name")
        tvYourSurname.text = bundle.getString("surname")
        tvYourEmail.text = bundle.getString("email")
        tvYourUsername.text = bundle.getString("username")
        tvYourPassword.text = bundle.getString("password")
        btnUndo.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_step3_to_step1,Bundle())
        }
        btnConfirmStep3 = view.findViewById(R.id.btn_confirm_step3)
        btnConfirmStep3.setOnClickListener{
            Toast.makeText(context,"Evviva!!Hai completato i 3 step",Toast.LENGTH_SHORT).show()
        }
    }
}
