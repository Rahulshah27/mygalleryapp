package com.example.mygalleryca2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class compulsorytask2 extends AppCompatActivity {

    FragmentManager fragmentManager=getSupportFragmentManager();
    FragmentTransaction transaction=fragmentManager.beginTransaction();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compulsorytask2);

        frag1 f1=new frag1();
        frag2 f2=new frag2();
        frag3 f3=new frag3();
        frag4 f4=new frag4();
        frag5 f5=new frag5();



        transaction.add(R.id.container1,f1);
        transaction.add(R.id.container2,f2);
        transaction.add(R.id.container3,f3);
        transaction.add(R.id.container4,f4);
        transaction.add(R.id.container5,f5);
        transaction.commit();



    }

    public void getdata(String n1, String n2) {

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction t=fm.beginTransaction();

        frag2 f2=new frag2();
        frag3 f3=new frag3();
        frag4 f4=new frag4();
        frag5 f5=new frag5();
        Bundle bundle=new Bundle();
        bundle.putString("num1",n1);
        bundle.putString("num2",n2);
        f2.setArguments(bundle);
        f3.setArguments(bundle);
        f4.setArguments(bundle);
        f5.setArguments(bundle);
        //Toast.makeText(getApplicationContext(),"n1 :"+n1+"\nn2 :"+n2,Toast.LENGTH_SHORT).show();

        t.add(R.id.container2,f2);
        t.add(R.id.container3,f3);
        t.add(R.id.container4,f4);
        t.add(R.id.container5,f5);
        t.commit();

    }



}
