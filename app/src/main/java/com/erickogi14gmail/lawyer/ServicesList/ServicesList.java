package com.erickogi14gmail.lawyer.ServicesList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erickogi14gmail.lawyer.MainActivity;
import com.erickogi14gmail.lawyer.R;
import com.erickogi14gmail.lawyer.utills.RecyclerTouchListener;
import com.erickogi14gmail.lawyer.utills.StaggeredHiddingScrollListener;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class ServicesList extends Fragment {
    private View view;
    private ArrayList<servicesPojo> servicesPojo=new ArrayList<>();

    RecyclerView recyclerView;

    private ServiceListAdapter serviceListAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private BottomNavigationView bottomNavigationView ;
    private Fragment fragment;


    private void setView(){
        getActivity().setTitle(MainActivity.product);
        recyclerView=(RecyclerView)view.findViewById(R.id.notifications_recycleView);
        if(MainActivity.product.equals("Personal")) {
            serviceListAdapter = new ServiceListAdapter(getContext(), populateList());
        }
        else if(MainActivity.product.equals("E-Business")){
            serviceListAdapter = new ServiceListAdapter(getContext(), populateListEbusiness());
        }else{
            serviceListAdapter = new ServiceListAdapter(getContext(), populateListCourtMatters());
        }
        serviceListAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(serviceListAdapter);
    }

    @Override
    public Object getReturnTransition() {
        return super.getReturnTransition();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.servicesfragment, container, false);
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
                MainActivity.serviceName=servicesPojo.get(position).getTitle();
               // MainActivity.isMain=false;
                fragment = new ReadService();
                setUpView();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }

    private ArrayList<servicesPojo> populateList() {
        servicesPojo servicesPojo1=new servicesPojo(1,"Estate Administration");
        servicesPojo servicesPojo2=new servicesPojo(2,"Name Change");
        servicesPojo servicesPojo3=new servicesPojo(3,"Marriage");
        servicesPojo servicesPojo4=new servicesPojo(4,"Divorce");
        servicesPojo servicesPojo5=new servicesPojo(5,"Tenancy");
        servicesPojo servicesPojo6=new servicesPojo(6,"Loans");
        servicesPojo servicesPojo7=new servicesPojo(7,"Landlord");
        servicesPojo servicesPojo8=new servicesPojo(8,"Guardianship");
        servicesPojo servicesPojo9=new servicesPojo(9,"Taxation");
        servicesPojo servicesPojo10=new servicesPojo(10,"Bankruptcy");
        servicesPojo servicesPojo11=new servicesPojo(11,"E-Banking");

            this.servicesPojo.add(servicesPojo1);
            this.servicesPojo.add(servicesPojo2);
            this.servicesPojo.add(servicesPojo3);
            this.servicesPojo.add(servicesPojo4);
            this.servicesPojo.add(servicesPojo5);
            this.servicesPojo.add(servicesPojo6);
            this.servicesPojo.add(servicesPojo7);
            this.servicesPojo.add(servicesPojo8);
            this.servicesPojo.add(servicesPojo9);
        this.servicesPojo.add(servicesPojo10);
        this.servicesPojo.add(servicesPojo11);

        return this.servicesPojo;
    }
    private ArrayList<servicesPojo> populateListCourtMatters() {
        servicesPojo servicesPojo1=new servicesPojo(1,"Free Legal Advice");
        servicesPojo servicesPojo2=new servicesPojo(2,"Documents Drafting");
        servicesPojo servicesPojo3=new servicesPojo(3,"Property Valuation for Bail and Bond");
        servicesPojo servicesPojo4=new servicesPojo(4,"Self-Representation Couching");


        this.servicesPojo.add(servicesPojo1);
        this.servicesPojo.add(servicesPojo2);
        this.servicesPojo.add(servicesPojo3);
        this.servicesPojo.add(servicesPojo4);


        return this.servicesPojo;
    }
    private ArrayList<servicesPojo> populateListEbusiness() {
        servicesPojo servicesPojo1=new servicesPojo(1,"Online Company Registration");
        servicesPojo servicesPojo2=new servicesPojo(2,"Land And Vehicle Registration");
        servicesPojo servicesPojo3=new servicesPojo(3,"Sole Proprietorship");
        servicesPojo servicesPojo4=new servicesPojo(4,"Non_Profit Organisation");
        servicesPojo servicesPojo5=new servicesPojo(5,"Find The Right Business Type");
        servicesPojo servicesPojo6=new servicesPojo(6,"Starting a Business");
        servicesPojo servicesPojo7=new servicesPojo(7,"Intellectual Property");
        servicesPojo servicesPojo8=new servicesPojo(8,"Copyright");
        servicesPojo servicesPojo9=new servicesPojo(9,"Patents");
        servicesPojo servicesPojo10=new servicesPojo(10,"See All Business Documents");
        servicesPojo servicesPojo11=new servicesPojo(11,"Request For Online Legal Assistance");

        this.servicesPojo.add(servicesPojo1);
        this.servicesPojo.add(servicesPojo2);
        this.servicesPojo.add(servicesPojo3);
        this.servicesPojo.add(servicesPojo4);
        this.servicesPojo.add(servicesPojo5);
        this.servicesPojo.add(servicesPojo6);
        this.servicesPojo.add(servicesPojo7);
        this.servicesPojo.add(servicesPojo8);
        this.servicesPojo.add(servicesPojo9);
        this.servicesPojo.add(servicesPojo10);
        this.servicesPojo.add(servicesPojo11);

        return this.servicesPojo;
    }

    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
        }

    }
}
