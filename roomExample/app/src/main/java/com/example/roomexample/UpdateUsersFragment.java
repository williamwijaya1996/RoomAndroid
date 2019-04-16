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
public class UpdateUsersFragment extends Fragment {

    EditText editId,editName,editEmail;
    Button btnEditSave;


    public UpdateUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_users, container, false);

        editId = view.findViewById(R.id.editUserid);
        editName = view.findViewById(R.id.editUsername);
        editEmail = view.findViewById(R.id.editEmail);
        btnEditSave = view.findViewById(R.id.btnSaveEdit);

        btnEditSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(editId.getText().toString());
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDataBase.myDao().updateUsers(user);

                Toast.makeText(getContext(),"Update Success",Toast.LENGTH_SHORT).show();
                editId.setText("");
                editName.setText("");
                editEmail.setText("");
            }
        });

        return view;
    }

}
