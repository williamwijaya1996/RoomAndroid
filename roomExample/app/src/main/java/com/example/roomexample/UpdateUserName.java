package com.example.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserName extends Fragment {

    EditText changeUserName,changeUser;
    Button btnChangeUser;

    public UpdateUserName() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user_name, container, false);

        changeUserName = view.findViewById(R.id.etUserName);
        changeUser = view.findViewById(R.id.etUserChange);
        btnChangeUser = view.findViewById(R.id.btnUpdateUser);

        btnChangeUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(changeUser.getText().toString());
                String changeName = changeUserName.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(changeName);

                MainActivity.myAppDataBase.myDao().updateUserName(changeName,id);
                Toast.makeText(getContext(),"Update Username Successfull",Toast.LENGTH_SHORT).show();

                changeUserName.setText("");
                changeUser.setText("");
            }
        });

        return view;
    }

}
