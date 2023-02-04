package com.example.clubregistration;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFragment extends Fragment {

    Button pickImage, button;
    EditText edtName, edtLast, edtEmail;
    Spinner spinner;
    DatabaseReference databaseReference;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            pickImage = view.findViewById(R.id.pickImage);
            edtName = view.findViewById(R.id.edtName);
            edtLast = view.findViewById(R.id.edtSurname);
            edtEmail = view.findViewById(R.id.edtEmail);
            spinner = view.findViewById(R.id.spinner);
            button = view.findViewById(R.id.button);

            databaseReference = FirebaseDatabase.getInstance().getReference();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    InsertData();
                }
            });
        }

    private  void InsertData(){
        String name = edtName.getText().toString();
        String lastName = edtLast.getText().toString();
        String email = edtEmail.getText().toString();
        String club = spinner.getSelectedItem().toString();


        members members = new members(name,lastName,email,club,id);
        databaseReference.child("members").child(String.valueOf(id)).setValue(members)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getView().getContext(), "Registration Successfully", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add,container,false);
    }
}
