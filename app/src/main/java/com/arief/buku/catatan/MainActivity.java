package com.arief.buku.catatan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etName, etPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.etName);
        etPass = (EditText) findViewById(R.id.etPass);

       findViewById(R.id.btnMasuk).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(etName.getText().toString().length() > 0 && etPass.getText().toString().length() > 0) {
                   String nama = etName.getText().toString();
                   Intent i = new Intent(getApplicationContext(), PencatatanActivity.class);
                   i.putExtra("user", nama);
                   startActivity(i);
               }

           }
       });
    }


}
