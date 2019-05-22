package com.example.ibnukhseinapp2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Date;

public class ListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Button button = (Button) view.findViewById(R.id.update_button);
        // задаем обработчик кнопки
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });
        return view;
    }

    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
    public void updateDetail() {
        // генерируем некоторые данные
        // Получаем флажки
        CheckBox var1 = (CheckBox) getView().findViewById(R.id.var1);
        CheckBox var2 = (CheckBox) getView().findViewById(R.id.var2);
        CheckBox var3 = (CheckBox) getView().findViewById(R.id.var3);
        CheckBox var4 = (CheckBox) getView().findViewById(R.id.var4);

        EditText question = (EditText) getView().findViewById(R.id.selection);


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

        // Посылаем данные Activity
        mListener.onFragmentInteraction(selectedItems);
    }
}