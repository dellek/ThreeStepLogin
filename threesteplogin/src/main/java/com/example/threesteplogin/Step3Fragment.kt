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

/**
 *
 * Recap Fragment
 *
 */
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
        tvYourName.text = "Your name is: ${arguments?.getString("name")} \n"
        tvYourSurname.text ="Your surname is: ${arguments?.getString("surname")} \n"
        tvYourEmail.text = "Your email is: ${arguments?.getString("email")} \n"
        tvYourUsername.text = "Your username is: ${arguments?.getString("username")} \n"
        tvYourPassword.text = "Your password is: ${arguments?.getString("password")} \n"
        btnUndo.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_step3_to_step1,Bundle())
        }
        btnConfirmStep3 = view.findViewById(R.id.btn_confirm_step3)
        btnConfirmStep3.setOnClickListener{
            Toast.makeText(context,"Evviva!!Hai completato i 3 step",Toast.LENGTH_SHORT).show()
        }
    }

    fun getStep3Fragment():Step3Fragment{
        return this
    }
}
