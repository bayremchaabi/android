package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Adapter.UserViewHolder;
import Model.User;
import isetb.tp5.appuser.R;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<User> list;

    public UserAdapter(List<User> users) {
        this.list = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_users, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = list.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
