package com.example.learningui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.learningui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.relativeLayout.setOnClickListener {
            val intent = Intent(this, BranchList::class.java)
            mGetContent.launch(intent)
        }

        binding.relativeLayout1.setOnClickListener {
            val intent = Intent(this, BranchList1::class.java)
            mGetContent.launch(intent)
        }
        binding.listRowTr.text = (intent.extras?.getString("namme") ?: "2500655")
        binding.relativeLayout2.setOnClickListener {
            val intent = Intent(this, BranchList2::class.java)
            mGetContent.launch(intent)
        }
        binding.listRowTt.text = (intent.extras?.getString("nammme") ?: "Savings account")

        binding.recepientEtName.addTextChangedListener(loginTextWatcher)
        binding.accountEtNumber.addTextChangedListener(loginTextWatcher)
        binding.emailEtAddress.addTextChangedListener(loginTextWatcher)
        binding.cellphoneetNumber.addTextChangedListener(loginTextWatcher)
        binding.editTextText8.addTextChangedListener(loginTextWatcher)
        binding.editTextText9.addTextChangedListener(loginTextWatcher)

        binding.button.isEnabled = false
    }
    private var mGetContent: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result:ActivityResult-> result.data
        if(result.resultCode == RESULT_OK){
            binding.listRowTe.text = (result.data?.getStringExtra("name") ?: "Select Bank")
        }
        if(result.resultCode == RESULT_CANCELED){
            binding.listRowTr.text = (result.data?.getStringExtra("name")?: "Select Account NUmber")
        }
        if(result.resultCode == 1000){
            binding.listRowTt.text = (result.data?.getStringExtra("name")?: "Select Account NUmber")
        }
    }

    private val loginTextWatcher = object : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val recipientName = binding.recepientEtName.text.toString().trim()
            val accountNumber = binding.accountEtNumber.text.toString().trim()
            val emailAddress = binding.emailEtAddress.text.toString().trim()
            val cellphoneNumber = binding.cellphoneetNumber.text.toString().trim()
            val statementDesc = binding.editTextText8.text.toString().trim()
            val myStatementDesc = binding.editTextText9.text.toString().trim()

            if(recipientName.isEmpty()){
                binding.etRecipientNameLayout.error = "Recipient Name cannot be empty!"
            } else{
                binding.etRecipientNameLayout.error = null
            }
            if(accountNumber.isEmpty()){
                binding.etAccountNumberLayout.error = "Account Number cannot be empty"
            }else{
                binding.etAccountNumberLayout.error = null
            }
            if(emailAddress.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
                binding.etEmailAddress.error = "Invalid Email Address"
            } else{
                binding.etEmailAddress.error = null
            }
            if(cellphoneNumber.isEmpty()){
                binding.etCellphoneNumber.error = "Invalid Cellphone Number"
            }
            else{
                binding.etCellphoneNumber.error = null
            }
            if(statementDesc.isEmpty()){
                binding.editTextText8.setBackgroundResource(R.drawable.with_error)
            }
            if(myStatementDesc.isEmpty()){
                binding.editTextText9.setBackgroundResource(R.drawable.with_error)
            }
            if(statementDesc.isNotEmpty()){
                binding.editTextText8.setBackgroundResource(R.drawable.with_foc)
            }
            if(myStatementDesc.isNotEmpty()){
                binding.editTextText9.setBackgroundResource(R.drawable.with_foc)
            }
            binding.button.isEnabled =  recipientName.isNotEmpty() && accountNumber.isNotEmpty() && emailAddress.isNotEmpty() && cellphoneNumber.isNotEmpty()
                    && statementDesc.isNotEmpty() && myStatementDesc.isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {

        }

    }
}