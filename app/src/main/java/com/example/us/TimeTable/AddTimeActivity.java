package com.example.us.TimeTable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.us.inputdatabase_t163472_w06.R;

public class AddTimeActivity extends AppCompatActivity {
    Button them,sua,xoa,thoat;
    EditText emaxe,etenxe,enamsx;
   Time time= new Time(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        them=(Button)findViewById(R.id.btn_them);
        sua=(Button)findViewById(R.id.btn_sua);
        xoa=(Button)findViewById(R.id.btn_xoa);

        thoat=(Button)findViewById(R.id.btn_thoat);
        emaxe=(EditText)findViewById(R.id.et_maxe);
        etenxe=(EditText)findViewById(R.id.et_tenxe);
        enamsx=(EditText)findViewById(R.id.ed_namsx);


        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // lay thong tin de chuyen qua coso dulieu
                time.taocar(emaxe.getText().toString(),etenxe.getText().toString(),enamsx.getText().toString());
                finish();
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.suacar(emaxe.getText().toString(),etenxe.getText().toString(),enamsx.getText().toString());
                finish();
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.xoacar(emaxe.getText().toString());
                finish();
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
