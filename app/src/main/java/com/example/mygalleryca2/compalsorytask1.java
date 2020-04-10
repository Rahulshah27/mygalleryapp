package com.example.mygalleryca2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class compalsorytask1 extends AppCompatActivity {

    EditText content;
    Button btn1,btn2,btn3;

    String filename="saved.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compalsorytask1);

        content=findViewById(R.id.content);



        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.clear);

        content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                btn3.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    btn3.setVisibility(View.VISIBLE);
                }
                else{
                    btn3.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O&&checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=content.getText().toString();
                saveTextasFile(text);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextfile();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setText("");
            }
        });


    }

    public void saveTextasFile(String msg){




        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(msg.getBytes());
            fos.close();
            Toast.makeText(this,"Text Saved",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this,"File NOt Found",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }catch (IOException e){
            Toast.makeText(this,"Error Saving",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }





    }

    public void showTextfile(){
        String text="";

        try {

            FileInputStream fin=openFileInput(filename);
            int size=fin.available();
            byte[] buffer=new byte[size];
            fin.read(buffer);
            fin.close();
            text=new String(buffer);
            Toast.makeText(this,""+text,Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 100:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(),"Permission Granted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Permission not Granted",Toast.LENGTH_SHORT).show();
                    finish();
                }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public static class frag1 extends Fragment {

        private FragmentAListner fragmentAListner;

        public interface FragmentAListner{
            void onInputASent(CharSequence input);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v=inflater.inflate(R.layout.fragment_frag1,container,false);
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }
}

