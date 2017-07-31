package com.erickogi14gmail.lawyer.Login;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kimani kogi on 4/6/2017.
 */

public class PrefrnceManager {
    int PRIVATE_MODE = 0;

    private  static final  String selectionS="MYPREFRENCE";

    public  boolean setP(Context context,String name,String phone,
                         String city,String address,String email,String password,String pic,boolean isLoggedIn){

try {
    SharedPreferences settings = context.getSharedPreferences(selectionS, PRIVATE_MODE);
    SharedPreferences.Editor editor = settings.edit();
    editor.putString("name", name);
    editor.putString("phone", phone);
    editor.putString("city", city);
    editor.putString("address", address);
    editor.putString("email", email);
    editor.putString("password",password);
    editor.putString("pic", pic);



    editor.putBoolean("login", isLoggedIn);
    editor.commit();
    return true;
}
catch (Exception n){
return false;
}

    }
    public String[] read(Context context){

        SharedPreferences settings  = context.getSharedPreferences(selectionS, PRIVATE_MODE);

        String vale[]=new String[7];
        vale[0]=  settings.getString("name","null");
        vale[1]=  settings.getString("phone","null");
        vale[2]=  settings.getString("city","null");
        vale[3]=  settings.getString("address","null");
        vale[4]=  settings.getString("email","null");
        vale[5]=  settings.getString("password","null");
        vale[6]=  settings.getString("pic","null");

        return  vale;
    }
    public boolean onorof(Context context){
        SharedPreferences settings=  context.getSharedPreferences(selectionS, PRIVATE_MODE);

        boolean isLoggedIn=settings.getBoolean("login",false);
        return  isLoggedIn;

    }


    public void setLogged(Context context, boolean isLoggedIn) {
        SharedPreferences settings = context.getSharedPreferences(selectionS, PRIVATE_MODE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("login", isLoggedIn);
        editor.commit();
    }
}





