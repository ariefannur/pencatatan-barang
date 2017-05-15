package com.arief.buku.catatan;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arief.buku.catatan.model.Barang;

/**
 * Created by arief pc on 5/15/2017.
 */

public class DialogBarang extends Dialog {

    private EditText etNamaBarang, etHarga, etStok;
    private Button btnAdd;
    private Submit iSubmit;

    public DialogBarang(Context context) {
        super(context);
        setTitle("Add Barang");
        setContentView(R.layout.add_barang);

        etHarga = (EditText) findViewById(R.id.etHarga);
        etNamaBarang = (EditText) findViewById(R.id.etNamaBarang);
        etStok = (EditText) findViewById(R.id.etStok);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iSubmit != null){
                    Barang barang = new Barang();
                    if(etHarga.getText().toString().length() > 0 &&
                            etNamaBarang.getText().toString().length() > 0 &&
                            etStok.getText().toString().length() > 0
                            ) {
                        barang.nama_barang = etNamaBarang.getText().toString();
                        barang.harga = Integer.parseInt(etHarga.getText().toString());
                        barang.stok = Integer.parseInt(etStok.getText().toString());
                        iSubmit.onSubmit(barang);
                    }else{
                        Toast.makeText(etHarga.getContext(), "Lengkapi semua data", Toast.LENGTH_SHORT).show();
                    }
                }

                dismiss();
            }
        });
    }

    public void setOnSubmit(Submit submit){
        iSubmit = submit;
    }

    interface Submit{
        void onSubmit(Barang barang);
    }
}
