package com.example.mygalleryca2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag5 extends Fragment {


    TextView t1,t2,t3;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_frag5,container,false);

        t1=v.findViewById(R.id.frag5n1);
        t2=v.findViewById(R.id.frag5n2);
        t3=v.findViewById(R.id.frag5n3);
        Bundle b2=getArguments();
        if(b2!=null){
            String n1=b2.getString("num1");
            String n2=b2.getString("num2");
            int sum=Integer.parseInt(n1)/Integer.parseInt(n2);
            t1.append(n1);
            t2.append(""+n2);
            t3.append(""+sum);


        }


        return v;
    }




}
