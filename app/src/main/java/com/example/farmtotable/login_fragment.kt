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
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [login_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class login_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var loginButton: Button
    private lateinit var usrName : EditText
    private lateinit var usrPassword : EditText
    private lateinit var db : sqlHelper

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
        val v = inflater.inflate(R.layout.login_fragment, container, false)
        //fetching items from layout id
        loginButton = v.findViewById<Button>(R.id.loginBttn)
        usrName = v.findViewById<EditText>(R.id.usrName)
        usrPassword = v.findViewById<EditText>(R.id.usrPassword)
        db = sqlHelper(activity)
        loginButton.setOnClickListener{
            val usrNameContent = usrName.text.toString()
            val usrPasswordContent = usrPassword.text.toString()

            if (TextUtils.isEmpty(usrNameContent) || TextUtils.isEmpty(usrPasswordContent)){
                Toast.makeText(context, "Invalid Entry. Check user details then try again", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkUser =db.checkUserPass(usrNameContent,usrPasswordContent)
                if (checkUser){
                    Toast.makeText(context, "Welcome $usrNameContent", Toast.LENGTH_SHORT).show()
                    val moveToHomepage = Intent(activity,MainActivity::class.java)
                    startActivity(moveToHomepage)

                }
                else{
                    Toast.makeText(context, "Incorrect password or username!...Try again", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return v
    }

}