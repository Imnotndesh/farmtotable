package com.example.farmtotable

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [register_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class register_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var uName: EditText
    private lateinit var uPass : EditText
    private lateinit var uEmail : EditText
    private lateinit var db: sqlHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.register_fragment, container, false)
        val uName = v.findViewById<EditText>(R.id.userName)
        val uEmail = v.findViewById<TextView>(R.id.usrName)
        val uPass = v.findViewById<TextView>(R.id.usrPassword)
        val signUpButton = v.findViewById<Button>(R.id.registerBttn)
        db = sqlHelper(activity)
        signUpButton.setOnClickListener{
            val usrNameContent = uName.text.toString()
            val usrEmailContent = uEmail.text.toString()
            val userPassContent = uPass.text.toString()
            val saveToDB = db.insertdata(usrNameContent,userPassContent,usrEmailContent)

            if (TextUtils.isEmpty(usrNameContent) || TextUtils.isEmpty(userPassContent) || TextUtils.isEmpty(usrEmailContent)){
                Toast.makeText(context, "Error creating user, check sign-up details", Toast.LENGTH_SHORT).show()
            }
            else{
                if (saveToDB){
                    Toast.makeText(context, "User $usrNameContent created successfully", Toast.LENGTH_SHORT).show()
                    val moveToHome = Intent(activity,MainActivity::class.java)
                    startActivity(moveToHome)
                }
                else{
                    Toast.makeText(context, "User $usrNameContent exists, Login instead.", Toast.LENGTH_SHORT).show()
                }
            }
        }



        return v;
    }

}