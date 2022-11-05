package com.example.admin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class updateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView cse,ise,ece,civil,mechanical;
    private LinearLayout csNoData,isNoData,ecNoData,cvNoData,mechNoData;
    private List<TeacherData> list1,list2,list3,list4,list5;

    private DatabaseReference reference,dbRef;
    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        cse=findViewById(R.id.cse);
        ise=findViewById(R.id.ise);
        ece=findViewById(R.id.ece);
        civil=findViewById(R.id.civil);
        mechanical=findViewById(R.id.mech);

        csNoData=findViewById(R.id.csNoData);
        isNoData=findViewById(R.id.isNoData);
        ecNoData=findViewById(R.id.ecNoData);
        cvNoData=findViewById(R.id.cvNoData);
        mechNoData=findViewById(R.id.mechNoData);

        reference= FirebaseDatabase.getInstance().getReference().child("Faculty");

        cse();
        ise();
        ece();
        civil();
        mechanical();

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(updateFaculty.this,addTeacher.class));
            }
        });
    }

    private void cse() {
        dbRef=reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1=new ArrayList<>();
                if(!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    cse.setVisibility(View.GONE);
                }else {
                    csNoData.setVisibility(View.GONE);
                    cse.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        TeacherData data=snapshot1.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    cse.setHasFixedSize(true);
                    cse.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter=new TeacherAdapter(list1,updateFaculty.this,"Computer Science");
                    cse.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(updateFaculty.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ise() {
        dbRef=reference.child("Information Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2=new ArrayList<>();
                if(!snapshot.exists()){
                    isNoData.setVisibility(View.VISIBLE);
                    ise.setVisibility(View.GONE);
                }else {
                    isNoData.setVisibility(View.GONE);
                    ise.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        TeacherData data=snapshot1.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    ise.setHasFixedSize(true);
                    ise.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter=new TeacherAdapter(list2,updateFaculty.this,"Information Science");
                    ise.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(updateFaculty.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ece() {
        dbRef=reference.child("Electronics & Communications");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3=new ArrayList<>();
                if(!snapshot.exists()){
                    ecNoData.setVisibility(View.VISIBLE);
                    ece.setVisibility(View.GONE);
                }else {
                    ecNoData.setVisibility(View.GONE);
                    ece.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        TeacherData data=snapshot1.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    ece.setHasFixedSize(true);
                    ece.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter=new TeacherAdapter(list3,updateFaculty.this,"Electronics & Communications");
                    ece.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(updateFaculty.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mechanical() {
        dbRef=reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4=new ArrayList<>();
                if(!snapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mechanical.setVisibility(View.GONE);
                }else {
                    mechNoData.setVisibility(View.GONE);
                    mechanical.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        TeacherData data=snapshot1.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    mechanical.setHasFixedSize(true);
                    mechanical.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter=new TeacherAdapter(list4,updateFaculty.this,"Mechanical");
                    mechanical.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(updateFaculty.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void civil() {
        dbRef=reference.child("Civil");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5=new ArrayList<>();
                if(!snapshot.exists()){
                    cvNoData.setVisibility(View.VISIBLE);
                    civil.setVisibility(View.GONE);
                }else {
                    cvNoData.setVisibility(View.GONE);
                    civil.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        TeacherData data=snapshot1.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    civil.setHasFixedSize(true);
                    civil.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter=new TeacherAdapter(list5,updateFaculty.this,"Civil");
                    civil.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(updateFaculty.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}