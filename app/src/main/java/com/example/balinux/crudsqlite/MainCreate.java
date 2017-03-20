package com.example.balinux.crudsqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {

    private DatabaseHandler db;
    private EditText Enama,Ekelas;
    private String $nama,$kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = new DatabaseHandler(this);

        Enama = (EditText) findViewById(R.id.create_nama);
        Ekelas = (EditText) findViewById(R.id.create_kelas);

        Button btnCreate  = (Button) findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                $nama = String.valueOf(Enama.getText());
                $kelas = String.valueOf(Ekelas.getText());

                if ($nama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this,"MASUKKAN NAMA", Toast.LENGTH_SHORT).show();
                }
                else if ($kelas.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this,"MASUKKAN KELAS", Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText(" ");
                    Ekelas.setText(" ");
                    Toast.makeText(MainCreate.this,"DATA TELAH DI TAMBAH", Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new ModalMahasiswa(null, $nama, $kelas));
                }
            }
        });
    }
}
