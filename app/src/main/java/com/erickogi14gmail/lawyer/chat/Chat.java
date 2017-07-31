package com.erickogi14gmail.lawyer.chat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.erickogi14gmail.lawyer.R;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {
    private static Fragment fragment = null;
    static  boolean isMain=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragment=new chatsListFragment();
        setUpView();
        
//        recyclerView=(RecyclerView)findViewById(R.id.recyclerChat);
//        chatsAdapter=new ChatsAdapter(Chat.this,populateList());
//        chatsAdapter.notifyDataSetChanged();
//        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(mStaggeredLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(chatsAdapter);


    }
    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
        }

    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()==0) {
            super.onBackPressed();
        }
        else{
           getFragmentManager().popBackStack();
        }

    }
}
