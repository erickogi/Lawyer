package com.erickogi14gmail.lawyer.AskLawyer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erickogi14gmail.lawyer.R;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class AskLawyerFragment extends Fragment {
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.asklawyer, container, false);
        getActivity().setTitle("Ask A Lawyer");
        return view;
    }
}
