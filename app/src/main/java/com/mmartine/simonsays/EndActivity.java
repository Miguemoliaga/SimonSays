package com.mmartine.simonsays;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {

    private SQLiteDatabase bd;

    Button b_up;
    Button b_out;
    EditText et_name;
    TextView tv_score;
    TextView tv_out;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name =findViewById(R.id.et_name);
        tv_score = findViewById(R.id.tv_score);
        tv_out = findViewById(R.id.tv_out);
        b_out = findViewById(R.id.b_out);
        b_up = findViewById(R.id.b_upl);
        SQLAdmin adminSQLite = new SQLAdmin(this, "records", null, 1);
        bd = adminSQLite.getWritableDatabase();
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            String s =(String) bundle.get("points");
            tv_score.setText(s);
            score = Integer.parseInt(s);
        }
        b_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query(v);
            }
        });
        b_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                altaSQL();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        bd.close();
    }

    public void altaSQL() {
        if(bd != null)
        {
            String name = et_name.getText().toString();
            String sql;
            sql = "INSERT INTO records VALUES (" + score + ", '" + name +"')";
            bd.execSQL(sql);
            Toast.makeText(this, "Your score has been uploaded", Toast.LENGTH_SHORT).show();
        }
    }

    public void query(View v) {
        String name = et_name.getText().toString();
        String str = "";
        Cursor c = bd.rawQuery(
                "select * from records" + " ORDER BY score"+
                        " LIMIT 5", null);

        if (c.moveToFirst()) {
            do {
                String qname= c.getString(0);
                String qscore = c.getString(1);
                str += qname + "-" + qscore + System.getProperty ("line.separator");
            } while(c.moveToNext());
            tv_out.setText(str);
        }else{
            Toast.makeText(this, "There isn't any record yet",
                    Toast.LENGTH_SHORT).show();
        }
    }

}

