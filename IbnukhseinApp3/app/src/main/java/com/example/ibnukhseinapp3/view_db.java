package com.example.ibnukhseinapp3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class view_db extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_db);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (question TEXT, variants TEXT)");
        Cursor query = db.rawQuery("SELECT * FROM users;", null);

        TextView textView = (TextView) findViewById(R.id.textView);

        if(query.moveToFirst()){
            do{
                String question = query.getString(0);
                String variants = query.getString(1);
                textView.append("Питання: " + question + "\nОбрані варіанти: " + variants + "\n\n");
            }
            while(query.moveToNext());
        } else{ textView.append("База даних пуста \n");}
        query.close();
    }
}
