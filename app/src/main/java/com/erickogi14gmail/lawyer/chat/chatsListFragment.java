package com.erickogi14gmail.lawyer.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erickogi14gmail.lawyer.R;
import com.erickogi14gmail.lawyer.utills.RecyclerTouchListener;
import com.erickogi14gmail.lawyer.utills.StaggeredHiddingScrollListener;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class chatsListFragment extends Fragment {
    private View view;
    private Fragment fragment = null;
    private ArrayList<ChatsListPojo> chatsListPojo=new ArrayList<>();

    RecyclerView recyclerView;

    private ChatsListAdapter chatsListAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
   

    private void setView(){
        getActivity().setTitle("Chats");
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleView);
        chatsListAdapter=new ChatsListAdapter(getContext(),populateList());
        chatsListAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(chatsListAdapter);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.chat_list_fragment, container, false);
        setView();
        recyclerView.setOnScrollListener(new StaggeredHiddingScrollListener() {

            @Override
            public void onHide() {

            }

            @Override
            public void onShow() {


            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),recyclerView,new RecyclerTouchListener.ClickListener(){

            @Override
            public void onClick(View view, int position) {
             //   Chat.isMain=false;
                fragment = new ChatThreadFragment();
                setUpView();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }
    private ArrayList<ChatsListPojo> populateList() {
        ChatsListPojo chatsListPojo=new ChatsListPojo(1,10,"Accidents Lawyer-Ahmed Om","Okay thank you i will do that");
        this.chatsListPojo.add(chatsListPojo);
        return this.chatsListPojo;
    }
    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
        }

    }










}
