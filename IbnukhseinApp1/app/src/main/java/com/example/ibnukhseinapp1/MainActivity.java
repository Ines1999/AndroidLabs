package com.example.ibnukhseinapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        // Получаем флажки
        CheckBox var1 = (CheckBox) findViewById(R.id.var1);
        CheckBox var2 = (CheckBox) findViewById(R.id.var2);
        CheckBox var3 = (CheckBox) findViewById(R.id.var3);
        CheckBox var4 = (CheckBox) findViewById(R.id.var4);

        EditText question = (EditText) findViewById(R.id.selection);


        String selectedItems = "";
        selectedItems += question.getText()+ "\n";
        if(var1.isChecked())
            selectedItems +=var1.getText() + " ";
        if(var2.isChecked())
            selectedItems +=var2.getText() + " ";
        if(var3.isChecked())
            selectedItems +=var3.getText() + " ";
        if(var4.isChecked())
            selectedItems +=var4.getText();

        Toast toast = Toast.makeText(this, selectedItems,Toast.LENGTH_LONG);
        toast.show();
    }
}