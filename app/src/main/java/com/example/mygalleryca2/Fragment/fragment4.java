package com.example.mygalleryca2.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mygalleryca2.R;

public class fragment4 extends Fragment {

    ImageView img;
    Uri image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.pager_4,container,false);

        img=v.findViewById(R.id.img4);

        if(getArguments()!=null){

            image= Uri.parse(getArguments().getString("img"));
            img.setImageURI(image);
        }


        return v;
    }
}
