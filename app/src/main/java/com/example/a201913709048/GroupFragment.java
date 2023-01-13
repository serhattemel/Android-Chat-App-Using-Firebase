package com.example.a201913709048;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GroupFragment extends Fragment {
    EditText t1,t2;
    RecyclerView recyclerView;
    DatabaseReference database;
    GroupAdapter groupAdapter;
    ArrayList<GroupModel> list;
    Button recylerviewbtn;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_group, container, false);
        t1 = (EditText) root.findViewById(R.id.et_groupName);
        t2 = (EditText) root.findViewById(R.id.et_groupDesc);
        context = getContext();
        recylerviewbtn = root.findViewById(R.id.recylerviewbtn);
        recyclerView = root.findViewById(R.id.groupList);
        database = FirebaseDatabase.getInstance().getReference("Groups");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        list = new ArrayList<>();
        groupAdapter = new GroupAdapter(context,list);
        recyclerView.setAdapter(groupAdapter);

        recylerviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                GroupModel group = new GroupModel(t1.getText().toString(),t2.getText().toString());
                database.push().setValue(group);
            }
        });

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    GroupModel group = dataSnapshot.getValue(GroupModel.class);
                    list.add(group);
                }
                groupAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return root;
    }
}