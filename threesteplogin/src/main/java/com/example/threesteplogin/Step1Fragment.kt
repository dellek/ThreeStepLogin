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
    companion object{
        @JvmStatic var bundleInstantiated = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_step1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etName = view.findViewById(R.id.et_name)
        etSurname = view.findViewById(R.id.et_surname)
        etEmail = view.findViewById(R.id.et_email)
        btnConfirmStep1 = view.findViewById(R.id.btn_confirm_step1)
        val bundle = Bundle()
        if(bundleInstantiated) {
            etName.setText(bundle.getString("name"))
            etSurname.setText(bundle.getString("surname"))
            etEmail.setText(bundle.getString("email"))
        }
        if(etName.text.equals("") && etSurname.text.equals("") && etEmail.text.equals("")) {
            Toast.makeText(context, "I campi sono obbligatori", Toast.LENGTH_SHORT).show()
        }else{
        btnConfirmStep1.setOnClickListener{
                bundleInstantiated = true
                bundle.putString("name",etName.text.toString())
                bundle.putString("surname",etSurname.text.toString())
                bundle.putString("email",etEmail.text.toString())
                Navigation.findNavController(it).navigate(R.id.action_step1_to_step2,bundle)
            }
        }
    }
}
