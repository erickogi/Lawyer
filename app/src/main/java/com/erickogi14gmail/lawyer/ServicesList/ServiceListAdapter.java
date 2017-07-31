package com.erickogi14gmail.lawyer.ServicesList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.lawyer.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<servicesPojo> modelList;

    public ServiceListAdapter(Context context, ArrayList<servicesPojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ServiceListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ServiceListAdapter.MyViewHolder holder, int position) {
    servicesPojo servicesPojo=modelList.get(position);
        holder.txtServiceNo.setText(String.valueOf(servicesPojo.getNo()));
        holder.txtServiceTitle.setText(servicesPojo.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  txtServiceNo,txtServiceTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtServiceNo=(TextView)itemView.findViewById(R.id.service_no);
            txtServiceTitle=(TextView)itemView.findViewById(R.id.service_title);
        }
    }
}
