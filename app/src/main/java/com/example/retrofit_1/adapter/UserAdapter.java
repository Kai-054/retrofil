package com.example.retrofit_1.adapter;

import android.view.LayoutInflater;
import  android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_1.R;
import com.example.retrofit_1.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> mListUser;

    public UserAdapter(List<User> mListUser) {
        this.mListUser = mListUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null){
            return;
        }
        holder.tvId.setText(String.valueOf(user.getId()));
        holder.tvTitle.setText(user.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mListUser != null){
            return mListUser.size();
        }

        return 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvId, tvTitle;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
