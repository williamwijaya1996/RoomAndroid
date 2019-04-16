package com.example.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment  {

  private Button btnAdd,btnView,btnDelete,btnUpdate,btnUpdateNama;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        btnAdd = view.findViewById(R.id.btn_add_user);
        btnView = view.findViewById(R.id.btn_view_user);
        btnDelete = view.findViewById(R.id.btn_delete_user);
        btnUpdate = view.findViewById(R.id.btn_update_user);
        btnUpdateNama = view.findViewById(R.id.btn_update_nama);


        FragmentManager fm = getFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.layout_main,new addUserFragment()).addToBackStack(null).commit();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.layout_main,new ReadUserFragment()).addToBackStack(null).commit();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.layout_main,new DeleteUserFragment()).addToBackStack(null).commit();

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.layout_main,new UpdateUsersFragment()).addToBackStack(null).commit();
            }
        });
        btnUpdateNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.layout_main,new UpdateUserName()).addToBackStack(null).commit();
            }
        });

        return view;
    }


}
