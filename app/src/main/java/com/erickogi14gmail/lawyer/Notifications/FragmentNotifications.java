package com.erickogi14gmail.lawyer.Notifications;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.erickogi14gmail.lawyer.R;
import com.erickogi14gmail.lawyer.utills.RecyclerTouchListener;
import com.erickogi14gmail.lawyer.utills.StaggeredHiddingScrollListener;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/22/2017.
 */

public class FragmentNotifications extends Fragment {
    View view;
    RecyclerView recyclerView;
    private ArrayList<NotificationsPojo> notificationsPojo=new ArrayList<>();
    private NotificationListAdapter notificationListAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;


    private void setView(){
        recyclerView=(RecyclerView)view.findViewById(R.id.notifications_recycleView);
        notificationListAdapter=new NotificationListAdapter(getContext(),populateList());
        notificationListAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(notificationListAdapter);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private void hideViews() {
      //  bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }

    private void showViews() {
     //   bottomNavigationView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_notifications,container,false);
        getActivity().setTitle("Notices");
        setView();

        recyclerView.setOnScrollListener(new StaggeredHiddingScrollListener() {

            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();

            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),recyclerView,new RecyclerTouchListener.ClickListener(){

            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));





        return view;
    }

    private ArrayList<NotificationsPojo> populateList(){
       NotificationsPojo notificationsPojo1=new NotificationsPojo(1,"Notice one","This is an example of a notice to app users","3/9/2017","General","");
        NotificationsPojo notificationsPojo2=new NotificationsPojo(2,"Notice two","This is an example of a notice to app users","3/9/2017","General","");
        NotificationsPojo notificationsPojo3=new NotificationsPojo(3,"Notice three","This is an example of a notice to app users","3/9/2017","General","");
        NotificationsPojo notificationsPojo4=new NotificationsPojo(4,"Notice four","This is an example of a notice to app users","3/9/2017","General","");
        NotificationsPojo notificationsPojo5=new NotificationsPojo(5,"Notice five","This is an example of a notice to app users","3/9/2017","General","");
        NotificationsPojo notificationsPojo6=new NotificationsPojo(6,"Notice six","This is an example of a notice to app users","3/9/2017","General","");
        NotificationsPojo notificationsPojo7=new NotificationsPojo(7,"Notice seven","This is an example of a notice to app users","3/9/2017","General","");
        NotificationsPojo notificationsPojo8=new NotificationsPojo(8,"Notice eight","This is an example of a notice to app users","3/9/2017","General","");
        NotificationsPojo notificationsPojo9=new NotificationsPojo(9,"Notice nine","This is an example of a notice to app users","3/9/2017","General","");
        this.notificationsPojo.add(notificationsPojo1);
        this.notificationsPojo.add(notificationsPojo2);
        this.notificationsPojo.add(notificationsPojo3);
        this.notificationsPojo.add(notificationsPojo4);
        this.notificationsPojo.add(notificationsPojo5);
        this.notificationsPojo.add(notificationsPojo6);
        this.notificationsPojo.add(notificationsPojo7);
        this.notificationsPojo.add(notificationsPojo8);
        this.notificationsPojo.add(notificationsPojo9);

        return this.notificationsPojo;



    }



}
