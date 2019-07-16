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

class Step1Fragment : Fragment() {

    private lateinit var etName:EditText
    private lateinit var etSurname:EditText
    private lateinit var etEmail:EditText
    private lateinit var btnConfirmStep1:Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_step1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etName = view.findViewById(R.id.et_name)
        etSurname = view.findViewById(R.id.et_surname)
        etEmail = view.findViewById(R.id.et_email)
        btnConfirmStep1 = view.findViewById(R.id.btn_confirm_step1)
        btnConfirmStep1.setOnClickListener{
            if(etName.equals("") && etSurname.equals("") && etEmail.equals("")){
                Toast.makeText(context,"I campi sono obbligatori",Toast.LENGTH_SHORT).show()
            }else{
                onSaveInstanceState(savedInstanceState!!)
                Navigation.findNavController(it).navigate(R.id.action_step1_to_step2,savedInstanceState)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("step1",true)
        outState.putString("name",etName.text.toString())
        outState.putString("surname",etSurname.text.toString())
        outState.putString("email",etEmail.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if(savedInstanceState!!.getBoolean("step1")){
            etName.setText(savedInstanceState.getString("name"))
            etSurname.setText(savedInstanceState.getString("surname"))
            etEmail.setText(savedInstanceState.getString("email"))
        }
    }
}
