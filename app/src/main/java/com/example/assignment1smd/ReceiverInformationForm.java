package com.example.assignment1smd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class ReceiverInformationForm extends AppCompatActivity {
    TextInputEditText rvEmail,rvFullname,rvContact,rvCountry,rvAddress;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver_information_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=rvEmail.getText().toString();
                String Fullname=rvFullname.getText().toString();
                String Address=rvAddress.getText().toString();
                String Country=rvCountry.getText().toString();
                String contact=rvContact.getText().toString();
                if(Email.contains("@gmail.com")&& contact.length()>8 && !Country.isEmpty() && !Fullname.isEmpty() && !Address.isEmpty())
                {
                    Intent senderIntent=getIntent();
                    String senderEmail = senderIntent.getStringExtra("senderEmail");
                    String senderFullName = senderIntent.getStringExtra("senderFullName");
                    String senderContact = senderIntent.getStringExtra("senderContact");
                    String senderCountry = senderIntent.getStringExtra("senderCountry");
                    String senderAddress = senderIntent.getStringExtra("senderAddress");

                    Intent i=new Intent(ReceiverInformationForm.this,ReviewInformation.class);
                    i.putExtra("receiverEmail",Email);
                    i.putExtra("receiverFullName",Fullname);
                    i.putExtra("receiverContact",contact);
                    i.putExtra("receiverCountry",Country);
                    i.putExtra("receiverAddress",Address);
                    i.putExtra("senderEmail",senderEmail);
                    i.putExtra("senderFullName",senderFullName);
                    i.putExtra("senderContact",senderContact);
                    i.putExtra("senderCountry",senderCountry);
                    i.putExtra("senderAddress",senderAddress);
                    startActivity(i);
                    finish();}
                else {
                    Toast.makeText(ReceiverInformationForm.this,"Enter Correct Information",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void init(){
        btnNext =findViewById(R.id.btnNext);
        rvEmail=findViewById(R.id.etREmail);
        rvFullname=findViewById(R.id.etRFullName);
        rvContact=findViewById(R.id.etRContactInfo);
        rvCountry=findViewById(R.id.etRCountry);
        rvAddress=findViewById(R.id.etRAddress);

    }
}