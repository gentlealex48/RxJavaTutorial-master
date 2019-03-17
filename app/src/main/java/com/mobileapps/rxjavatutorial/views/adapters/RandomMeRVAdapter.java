package com.mobileapps.rxjavatutorial.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mobileapps.rxjavatutorial.R;
import com.mobileapps.rxjavatutorial.models.local.randomme.RandomResponse;
import com.mobileapps.rxjavatutorial.models.local.randomme.User;
import com.mobileapps.rxjavatutorial.utilities.StringUtils;

public class RandomMeRVAdapter extends RecyclerView.Adapter<RandomMeRVAdapter.ViewHolder> {
    RandomResponse randomResponse;

    public RandomMeRVAdapter(RandomResponse randomResponse) {
        this.randomResponse = randomResponse;
    }

    @NonNull
    @Override
    public RandomMeRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewHolder viewHolder = new ViewHolder(inflater.inflate(R.layout.user_item,viewGroup,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomMeRVAdapter.ViewHolder viewHolder, int i) {
        User currentUser = randomResponse.getResults().get(i);
        if(currentUser!= null) {
            viewHolder.tvUserName.setText(StringUtils.getFullName(currentUser.getName()));
            viewHolder.tvUserLocation.setText(StringUtils.getLocation(currentUser.getLocation()));
            viewHolder.tvUserPhone.setText(currentUser.getPhone());
            Glide.with(viewHolder.itemView)
                    .load(currentUser.getPicture().getThumbnail())
                    .into(viewHolder.imgUserImage);
        }
    }

    @Override
    public int getItemCount() {
        return randomResponse.getResults().size();
    }

    public void updateRandomResponse(RandomResponse randomResponse) {
        this.randomResponse = randomResponse;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUserImage;
        TextView tvUserName;
        TextView tvUserLocation;
        TextView tvUserPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUserImage = itemView.findViewById(R.id.imgUserImage);
            tvUserName = itemView.findViewById(R.id.tvName);
            tvUserLocation = itemView.findViewById(R.id.tvLocation);
            tvUserPhone = itemView.findViewById(R.id.tvPhone);
        }
    }
}
