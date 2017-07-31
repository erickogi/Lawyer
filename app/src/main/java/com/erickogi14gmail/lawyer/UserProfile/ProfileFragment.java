package com.erickogi14gmail.lawyer.UserProfile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.erickogi14gmail.lawyer.HomeFragment;
import com.erickogi14gmail.lawyer.Login.PrefrnceManager;
import com.erickogi14gmail.lawyer.MainActivity;
import com.erickogi14gmail.lawyer.R;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class ProfileFragment extends Fragment {
    private View view;
    Button buttonChange;
    EditText editTextName,editTextPhone,editTextCity,editTextAddress,editTextEmail;
    private Fragment fragment=null;
    ImageView imgProfile;
    private Bitmap mImageBitmap;
    private String mCurrentPhotoPath="null";
    static final int PICK_PHOTO_FOR_AVATAR=2;
    InputStream is=null;
    InputStream inputStream;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profilefragment, container, false);
        editTextName=(EditText)view.findViewById(R.id.editTextName);
        editTextPhone=(EditText)view.findViewById(R.id.editTextPhoneNo);
        editTextCity=(EditText)view.findViewById(R.id.editTextCity);
        editTextAddress=(EditText)view.findViewById(R.id.editTextAddress);
        editTextEmail=(EditText)view.findViewById(R.id.editTextEmail);
        imgProfile=(ImageView)view.findViewById(R.id.profile_image);

       // editTextName=(EditText)view.findViewById(R.id.editTextName);
        PrefrnceManager p=new PrefrnceManager();
        String items[]=p.read(getContext());
        editTextName.setText(items[0]);
        editTextPhone.setText(items[1]);
        editTextCity.setText(items[2]);
        editTextAddress.setText(items[3]);
        editTextEmail.setText(items[4]);

        try {
            mCurrentPhotoPath=items[6];
            mImageBitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), Uri.parse(items[6]));
            imgProfile.setImageBitmap(mImageBitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }



        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            pickImage();
            }
        });






        buttonChange=(Button)view.findViewById(R.id.buttonSave);
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    changeProfileImage();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        return view;
    }
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  // prefix
                ".jpg",         // suffix
                storageDir
                // directory
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
       // Toast.makeText(getContext(), ""+mCurrentPhotoPath, Toast.LENGTH_SHORT).show();
        return image;
    }
    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        this.startActivityForResult(intent, PICK_PHOTO_FOR_AVATAR);
    }

    public void changeProfileImage() throws IOException {
        if(TextUtils.isEmpty(editTextName.getText())||
                TextUtils.isEmpty(editTextPhone.getText())||
                TextUtils.isEmpty(editTextCity.getText())||
                TextUtils.isEmpty(editTextAddress.getText())||
                TextUtils.isEmpty(editTextEmail.getText())){
            Toast.makeText(getActivity(), "Fill All Fields", Toast.LENGTH_SHORT).show();
        }
        else {
            if (mCurrentPhotoPath.equals("null")) {
                Toast.makeText(getContext(), "Select Picture By Clicking on Image", Toast.LENGTH_SHORT).show();

            } else {

                Drawable d=imgProfile.getDrawable();
                Bitmap b=((BitmapDrawable)d).getBitmap();

               // Bitmap   bmp = BitmapFactory.decodeStream(inputStream);

                FileOutputStream out=getActivity().getApplicationContext().openFileOutput("profile_pic",getActivity().getApplicationContext().MODE_PRIVATE);
                b.compress(Bitmap.CompressFormat.PNG,90,new FileOutputStream(createImageFile()));
                PrefrnceManager p = new PrefrnceManager();

                if (p.setP(getContext(), editTextName.getText().toString(), editTextPhone.getText().toString(), editTextCity.getText().toString()
                        , editTextAddress.getText().toString(), editTextEmail.getText().toString(), "password", mCurrentPhotoPath, true)) {
                    fragment = new HomeFragment();
                    MainActivity.isMain = true;
                    setUpView();

                } else
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }


    }
    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
        }

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            try {
                inputStream = getActivity().getContentResolver().openInputStream(data.getData());
                     is=inputStream;


                Bitmap   bmp = BitmapFactory.decodeStream(inputStream);

                imgProfile.setImageBitmap(bmp);
                mCurrentPhotoPath="jk";

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //Now you can do whatever you want with your inpustream, save it as file, upload to a server, decode a bitmap...
        }
    }
}
