package com.example.mygalleryca2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mygalleryca2.Fragment.fragment1;
import com.example.mygalleryca2.Fragment.fragment2;
import com.example.mygalleryca2.Fragment.fragment3;
import com.example.mygalleryca2.Fragment.fragment4;
import com.example.mygalleryca2.Fragment.fragment5;
import com.example.mygalleryca2.Fragment.fragment6;
import com.example.mygalleryca2.Fragment.fragment7;
import com.example.mygalleryca2.Fragment.fragment8;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  int imagePickcode=1000;
    private int PERMISSION_CODE=1001;
    Bundle bundle=new Bundle();
    ImageView img;


    List<Fragment> list;

    fragment1 fragment1=new fragment1();
    fragment2 fragment2=new fragment2();
    fragment3 fragment3=new fragment3();
    fragment4 fragment4=new fragment4();
    fragment5 fragment5=new fragment5();
    fragment6 fragment6=new fragment6();
    fragment7 fragment7=new fragment7();
    fragment8 fragment8=new fragment8();
    Uri imageuri;
    Bitmap bitmap;
    ViewPager viewPager;
    private pageradapter pageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager=findViewById(R.id.pager);

        setViewPager();

    }

    public void setViewPager(){
        list=new ArrayList<>();

        if(imageuri!=null){

            bundle.putString("img",imageuri.toString());
            fragment1.setArguments(bundle);
            fragment2.setArguments(bundle);
            fragment3.setArguments(bundle);
            fragment4.setArguments(bundle);
            fragment5.setArguments(bundle);
            fragment6.setArguments(bundle);
            fragment7.setArguments(bundle);
            fragment8.setArguments(bundle);

            list.add(fragment1);
            list.add(fragment2);
            list.add(fragment3);
            list.add(fragment4);
            list.add(fragment5);
            list.add(fragment6);
            list.add(fragment7);
            list.add(fragment8);

            pageradapter=new pageradapter(getSupportFragmentManager(),list);
            viewPager.setAdapter(pageradapter);
        }
        else{
            list.add(fragment1);
            list.add(fragment2);
            list.add(fragment3);
            list.add(fragment4);
            list.add(fragment5);
            list.add(fragment6);
            list.add(fragment7);
            list.add(fragment8);

            pageradapter=new pageradapter(getSupportFragmentManager(),list);
            viewPager.setAdapter(pageradapter);

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addImage:
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){

                        String[] permission={Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permission,PERMISSION_CODE);
                    }
                    else{
                        pickImagefromGallery();
                       // img.setImageURI(imageuri);




                    }
                }
                else{
                    pickImagefromGallery();

                }
             default:
                 return true;

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1001:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    pickImagefromGallery();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_SHORT).show();
                }

        }

    }

    private  void pickImagefromGallery(){

        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,imagePickcode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == imagePickcode) {
            imageuri = data.getData();

            setViewPager();
        }
    }
}
