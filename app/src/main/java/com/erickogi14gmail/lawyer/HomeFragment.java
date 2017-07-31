package com.erickogi14gmail.lawyer;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erickogi14gmail.lawyer.Login.PrefrnceManager;

import java.io.IOException;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class HomeFragment extends Fragment {
    private View view;
    TextView  textViewName,textViewEmail;
    ImageView imageView;
    Bitmap mImageBitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fomefragment, container, false);
        getActivity().setTitle("E-Lawyer");
        PrefrnceManager prefrnceManager=new PrefrnceManager();
      String items[]=  prefrnceManager.read(getContext());
        textViewName=(TextView)view.findViewById(R.id.profile_name);
        textViewEmail=(TextView)view.findViewById(R.id.profile_email);
        imageView=(ImageView)view.findViewById(R.id.profile_image);


        if(items[0].equals("null")){

        }else {
            textViewName.setText(items[0]);
            textViewEmail.setText(items[4]);
            try {
                mImageBitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), Uri.parse(items[6]));
                imageView.setImageBitmap(mImageBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return view;
    }
}
