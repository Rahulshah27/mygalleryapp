package com.example.mygalleryca2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag1 extends Fragment {


    EditText n1,n2;

    Button b1;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_frag1,container,false);
        n1=v.findViewById(R.id.n1);
        n2=v.findViewById(R.id.n2);

        b1=v.findViewById(R.id.add);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one=n1.getText().toString();
                String two=n2.getText().toString();
                compulsorytask2 mv= (compulsorytask2) getActivity();
                mv.getdata(one,two);


            }
        });


        return v;
    }




}
