package com.example.assignment1smd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReviewInformation extends AppCompatActivity {


    TextView tvsdName,tvsdCountry,tvsdAddress,tvsdContact,tvrvName,tvrvCountry,tvrvAddress,tvrvContact;
    ImageButton fabAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review_information);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        Intent intent=getIntent();
        String senderEmail = intent.getStringExtra("senderEmail");
        String senderName = intent.getStringExtra("senderFullName");
        String senderContact = intent.getStringExtra("senderContact");
        String senderCountry = intent.getStringExtra("senderCountry");
        String senderAddress = intent.getStringExtra("senderAddress");


        String receiverEmail = intent.getStringExtra("receiverEmail");
        String receiverName = intent.getStringExtra("receiverFullName");
        String receiverContact = intent.getStringExtra("receiverContact");
        String receiverCountry = intent.getStringExtra("receiverCountry");
        String receiverAddress = intent.getStringExtra("receiverAddress");

        tvsdName.setText(senderName);
        tvsdCountry.setText(senderCountry);
        tvsdAddress.setText(senderAddress);
        tvsdContact.setText(senderContact);
        tvrvName.setText(receiverName);
        tvrvCountry.setText(receiverCountry);
        tvrvAddress.setText(receiverAddress);
        tvrvContact.setText(receiverContact);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ReviewInformation.this,SenderInformationForm.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void init(){
        tvsdName =findViewById(R.id.tvsdName);
        tvsdCountry =findViewById(R.id.tvsdCountry);
        tvsdAddress =findViewById(R.id.tvsdAddress);
        tvsdContact =findViewById(R.id.tvsdContact);
        tvrvName=findViewById(R.id.tvrvName);
        tvrvCountry=findViewById(R.id.tvrvCountry);
        tvrvAddress=findViewById(R.id.tvrvAddress);
        tvrvContact=findViewById(R.id.tvrvContact);
        fabAdd=findViewById(R.id.fabAdd);

    }
}