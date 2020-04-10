package com.example.mygalleryca2.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mygalleryca2.R;

public class fragment1 extends Fragment {

    ImageView imgview;
    Uri image;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.pager_1,container,false);
        imgview=(ImageView)view.findViewById(R.id.img1);

        if(getArguments()!=null){
            image=Uri.parse(getArguments().getString("img"));
            imgview.setImageURI(image);
        }

        else{
            Toast.makeText(getContext(),"Choose a Image", Toast.LENGTH_SHORT).show();
        }



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
