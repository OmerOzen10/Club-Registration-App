package com.example.clubregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<members> members;
    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).addToBackStack(null).commit();

        members = new ArrayList<>();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnItemSelectedListener(naviListener);

        getDataFireBase();



    }

    private NavigationBarView.OnItemSelectedListener naviListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.seeMembers:
                            selectedFragment = new SeeFragment();
                            break;
                        case R.id.nav_addMember:
                            selectedFragment = new AddFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).addToBackStack(null).commit();
                    return true;

                }
            };

    private void getDataFireBase(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("members").orderBy("id").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot dc:task.getResult()) {
                        String firstName = dc.getString("firstName");
                        String lastName = dc.getString("lastName");
                        String email = dc.getString("email");
                        String club = dc.getString("club");
                        int id = dc.getLong("id").intValue();
                        members.add(new members(firstName,lastName,email,club,id));
                    }
                    Log.d(TAG, "The data has been reached: ");
                }else {
                    Log.d(TAG, "Couldn't reach the data: ", task.getException());
                }
            }
        });
    }

}



