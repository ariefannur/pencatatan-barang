package com.arief.buku.catatan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arief.buku.catatan.model.Barang;

/**
 * Created by arief pc on 5/15/2017.
 */

public class PencatatanActivity extends AppCompatActivity {

    private String user;
    private TextView txtUser;
    private Button btnAdd;
    private LinearLayout layItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pencatatan);
        user = getIntent().getStringExtra("user");

        txtUser = (TextView) findViewById(R.id.txtName);
        txtUser.setText(user);

        layItem = (LinearLayout) findViewById(R.id.itemBarang);
        layItem.addView(add(null));

        btnAdd = (Button) findViewById(R.id.addItem);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBarang dialogBarang = new DialogBarang(PencatatanActivity.this);
                dialogBarang.setOnSubmit(new DialogBarang.Submit() {
                    @Override
                    public void onSubmit(Barang barang) {
                        layItem.addView(add(barang));
                    }
                });
                dialogBarang.show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add, menu);
        return true;
    }

    ViewGroup add(Barang barang){
        View v = LayoutInflater.from(this).inflate(R.layout.item_barang, null, false);
        TextView txtBarang = (TextView) v.findViewById(R.id.txtNamaBarang);
        TextView txtHarga = (TextView) v.findViewById(R.id.txtNamaBarang);
        TextView txtStok = (TextView) v.findViewById(R.id.txtNamaBarang);

        if(barang != null) {
            txtBarang.setText(barang.nama_barang);
            txtHarga.setText(String.valueOf(barang.harga));
            txtStok.setText(String.valueOf(barang.stok));
        }else{
            txtBarang.setText("Nama Barang");
            txtHarga.setText("Harga");
            txtStok.setText("Stok");
        }

        return (ViewGroup) v;
    }
}
