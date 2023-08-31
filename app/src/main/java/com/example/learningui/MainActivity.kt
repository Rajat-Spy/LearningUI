package com.example.learningui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Selection
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var firstList: RelativeLayout
    private lateinit var textShow: TextView
    private lateinit var secondList: RelativeLayout
    private lateinit var textShow2: TextView
    private lateinit var thirdList: RelativeLayout
    private lateinit var textShow3: TextView
//    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var editText5: EditText
    private lateinit var editText6: EditText
    private lateinit var continueButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstList = findViewById(R.id.relativeLayout)
        textShow = findViewById(R.id.list_row_te)
        firstList.setOnClickListener {
            val intent = Intent(this, BranchList::class.java)
            startActivity(intent)
        }
        textShow.text = (intent.extras?.getString("name") ?: "Abass")
        secondList = findViewById(R.id.relativeLayout1)
        textShow2 = findViewById(R.id.list_row_tr)
        secondList.setOnClickListener {
            val intent = Intent(this, BranchList1::class.java)
            startActivity(intent)
        }
        textShow2.text = (intent.extras?.getString("namme") ?: "2500655")
        thirdList = findViewById(R.id.relativeLayout2)
        textShow3 = findViewById(R.id.list_row_tt)
        thirdList.setOnClickListener {
            val intent = Intent(this, BranchList2::class.java)
            startActivity(intent)
        }
        textShow3.text = (intent.extras?.getString("nammme") ?: "Savings account")

//        editText1 = findViewById(R.id.editTextText2)
        editText2 = findViewById(R.id.editTextText3)
        editText3 = findViewById(R.id.editTextText4)
        editText4 = findViewById(R.id.editTextText5)
        editText5 = findViewById(R.id.editTextText8)
        editText6 = findViewById(R.id.editTextText9)
        continueButton = findViewById(R.id.button)
//        editText1.addTextChangedListener(loginTextWatcher)
        editText2.addTextChangedListener(loginTextWatcher)
        editText3.addTextChangedListener(loginTextWatcher)
        editText4.addTextChangedListener(loginTextWatcher)
        editText5.addTextChangedListener(loginTextWatcher)
        editText6.addTextChangedListener(loginTextWatcher)

        continueButton.isEnabled = false
    }

    private val loginTextWatcher = object : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            val edit_text1 = editText1.text.toString().trim()
            val edit_text2 = editText2.text.toString().trim()
            val edit_text3 = editText3.text.toString().trim()
            val edit_text4 = editText4.text.toString().trim()
            val edit_text5 = editText5.text.toString().trim()
            val edit_text6 = editText6.text.toString().trim()

            continueButton.isEnabled =  edit_text2.isNotEmpty() && edit_text3.isNotEmpty() && edit_text4.isNotEmpty()
                    && edit_text5.isNotEmpty() && edit_text6.isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }
}