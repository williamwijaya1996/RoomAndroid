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
public class addUserFragment extends Fragment {

    private EditText etEmail,etUsername,etUserId;
    private Button btnsave;

    public addUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);


        etUserId = view.findViewById(R.id.userid);
        etUsername=view.findViewById(R.id.username);
        etEmail = view.findViewById(R.id.userEmail);
        btnsave = view.findViewById(R.id.btnSave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userid = Integer.parseInt(etUserId.getText().toString());
                String name= etUsername.getText().toString();
                String email = etEmail.getText().toString();

                User user = new User();
                user.setId(userid);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDataBase.myDao().addUser(user);
                Toast.makeText(getContext(),"succesfully",Toast.LENGTH_SHORT).show();

                etUserId.setText("");
                etUsername.setText("");
                etEmail.setText("");
            }
        });

    return view;
    }

}
