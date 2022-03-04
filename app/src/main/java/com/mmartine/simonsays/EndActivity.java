package com.mmartine.simonsays;

import static java.lang.Integer.parseInt;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {

    private SQLiteDatabase bd;

    EditText et_name;
    TextView tv_score;
    TextView tv_out;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name =findViewById(R.id.et_name);
        SQLAdmin adminSQLite = new SQLAdmin(this, "records", null, 1);
        bd = adminSQLite.getWritableDatabase();
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            String s =(String) bundle.get("name");
            tv_score.setText(s);
            score = parseInt(s);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        bd.close();
    }

    public void altaSQL() {
        //Si la base de datos se abrió correctamente
        if(bd != null)
        {
            String name = et_name.getText().toString();
            String sql;
            sql = "INSERT INTO records VALUES (" + score + ", '" + name +"')";
            bd.execSQL(sql);
            Toast.makeText(this, "Your score has been uploaded", Toast.LENGTH_SHORT).show();
        }
    }

    public void consulta(View v) {
        String name = et_name.getText().toString();
        String str = "";
        Cursor c = bd.rawQuery(
                "select * from records" + " ORDER BY score"+
                        " LIMIT 5", null);

        // Asegurar que existe, al menos, un registro
        if (c.moveToFirst()) {
            // Recorrer el cursor hasta que no haya más registros
            do {
                String qname= c.getString(0);
                String qscore = c.getString(1);
                str += qname + "-" + qscore + System.getProperty ("line.separator");
            } while(c.moveToNext());
            tv_out.setText(str);
        }else{
            Toast.makeText(this, "No existe un artículo con dicha descripción",
                    Toast.LENGTH_SHORT).show();
        }
    }

}

