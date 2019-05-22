package com.example.ibnukhseinapp3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ContentValues;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        // Получаем флажки
        CheckBox var1 = (CheckBox) findViewById(R.id.var1);
        CheckBox var2 = (CheckBox) findViewById(R.id.var2);
        CheckBox var3 = (CheckBox) findViewById(R.id.var3);
        CheckBox var4 = (CheckBox) findViewById(R.id.var4);

        EditText questions = (EditText) findViewById(R.id.selection);
        String question = "";
        question += questions.getText();

        String selectedItems = "";
        if(var1.isChecked())
            selectedItems +=var1.getText() + " ";
        if(var2.isChecked())
            selectedItems +=var2.getText() + " ";
        if(var3.isChecked())
            selectedItems +=var3.getText() + " ";
        if(var4.isChecked())
            selectedItems +=var4.getText();



        if (question!="" && selectedItems!=""){
            Toast toast_selected = Toast.makeText(this, "Введені дані: \n"+question+"\n"+selectedItems ,Toast.LENGTH_LONG);
            toast_selected.show();
            addToDB(question,selectedItems);
        }
        else{
            Toast toast_selected = Toast.makeText(this, "Дані не введені" ,Toast.LENGTH_LONG);
            toast_selected.show();
        }


    }

    public void addToDB(String question, String selectedItems){
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (question TEXT, variants TEXT)");

        ContentValues cv = new ContentValues();
        cv.put("question" , question);
        cv.put("variants" , selectedItems);
        db.insertOrThrow("users", null, cv);

        Toast toast_db = Toast.makeText(this, "База даних оновлена",Toast.LENGTH_LONG);
        toast_db.show();

        db.close();
    }
    public void onDB(View view) {
        Intent intent = new Intent(getApplicationContext(),
                view_db.class);
        startActivity(intent);

    }
}
