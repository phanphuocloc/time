package com.example.us.TimeTable;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.us.inputdatabase_t163472_w06.R;

public class MainActivity extends AppCompatActivity {
    Button add,reload;
    TextView result;
    Time time= new Time(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reload=(Button)findViewById(R.id.btn_reload);
        add=(Button)findViewById(R.id.btn_Add);
        result=(TextView)findViewById(R.id.tv_Result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddTimeActivity.class);
                startActivity(intent);
            }
        });
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor con_tro= time.getAllCar();
                String chuoi="";
                if(con_tro.getCount()>=1){
                    con_tro.moveToFirst();
                    do {
                        chuoi+=con_tro.getString(0) + "\t\t\t";
                        chuoi+=con_tro.getString(1) + "\t\t\t";
                        chuoi+=con_tro.getString(2) + "\t\t\t";
                        chuoi+=con_tro.getString(3) + "\n";
                    }while (con_tro.moveToNext());
                    result.setText(chuoi);
                }
            }
        });
    }
}
