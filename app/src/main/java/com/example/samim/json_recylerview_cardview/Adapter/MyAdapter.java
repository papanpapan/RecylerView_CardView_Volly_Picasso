package com.example.samim.json_recylerview_cardview.Adapter;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.samim.json_recylerview_cardview.Item.ListItem;
import com.example.samim.json_recylerview_cardview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SAMIM on 2/13/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext())
               .inflate(R.layout.user_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem=listItems.get(position);


        //chenges anather project
        holder.txtName.setText(listItem.getName());
        holder.txtTeam.setText(listItem.getTeam());


        Picasso.with(context).load(listItem.getImageUrl()).into(holder.userImage);

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Defind textView and Image view ite from user_item
        public TextView txtName;
        public TextView txtTeam;
        public ImageView userImage;
        public ViewHolder(View itemView) {
            super(itemView);

            //Cust this textView and imageView
            txtName=(TextView)itemView.findViewById(R.id.textName);
            txtTeam=(TextView)itemView.findViewById(R.id.textTeam);
            userImage=(ImageView)itemView.findViewById(R.id.imgUser);
        }
    }
}
