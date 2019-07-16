package com.example.threesteplogin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Step3Fragment : Fragment() {

    private lateinit var tvRegistrationComplete:TextView
    private lateinit var tvYourName:TextView
    private lateinit var tvYourSurname:TextView
    private lateinit var tvYourEmail:TextView
    private lateinit var tvYourUsername:TextView
    private lateinit var tvYourPassword:TextView
    private lateinit var btnUndo:Button
    private lateinit var btnConfirmStep3:Button

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
        btnConfirmStep3 = view.findViewById(R.id.btn_confirm_step3)
        btnConfirmStep3.setOnClickListener{
            Toast.makeText(context,"Evviva!!Hai completato i 3 step",Toast.LENGTH_SHORT).show()
        }
    }

//    override fun onViewStateRestored(savedInstanceState: Bundle?) {
//        super.onViewStateRestored(savedInstanceState)
//        tvYourName.text = savedInstanceState!!.getString("name")
//        tvYourPassword.text = savedInstanceState!!.getString("surname")
//        tvYourEmail.text = savedInstanceState!!.getString("email")
//        tvYourUsername.text = savedInstanceState!!.getString("username")
//        tvYourPassword.text = savedInstanceState!!.getString("password")
//    }
}
