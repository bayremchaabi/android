package Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import Model.User;
import isetb.tp5.appuser.R;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView t1,t2,t3,t4;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        t1=itemView.findViewById(R.id.firstname);
        t2=itemView.findViewById(R.id.lastname);
        t3=itemView.findViewById(R.id.age);
        t4=itemView.findViewById(R.id.email);



    }
    public void bind(User user)
    {
        t1.setText(user.getFirstName());
        t2.setText(user.getLastName());
        t3.setText(String.valueOf(user.getAge()));
        t4.setText(user.getEmail());
    }
}
