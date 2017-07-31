package com.erickogi14gmail.lawyer.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.erickogi14gmail.lawyer.MainActivity;
import com.erickogi14gmail.lawyer.R;

/**
 * Created by kimani kogi on 7/27/2017.
 */

public class LoginFragment extends Fragment {
    private View view;
    EditText ViewPassword;
    Button buttonLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_fragment, container, false);
        getActivity().setTitle("Login");
        ViewPassword=(EditText) view.findViewById(R.id.editTextPassword);
        buttonLogin=(Button)view.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("password".equals(ViewPassword.getText().toString())){
                    PrefrnceManager prefrnceManager =new PrefrnceManager();
                    prefrnceManager.setLogged(getContext(),true);
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();
                }
                else {
                    Toast.makeText(getContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
