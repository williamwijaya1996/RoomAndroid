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
public class DeleteUserFragment extends Fragment {


    Button btnDelete;
    EditText etDelete;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        btnDelete = view.findViewById(R.id.btnDelete);
        etDelete = view.findViewById(R.id.etUserIdDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int del = Integer.parseInt(etDelete.getText().toString());

                User user = new User();
                user.setId(del);
                MainActivity.myAppDataBase.myDao().deleteUsers(user);
                Toast.makeText(getContext(),"User Successfully Remove",Toast.LENGTH_SHORT).show();

                etDelete.setText("");
            }
        });

        return view;
    }

}
