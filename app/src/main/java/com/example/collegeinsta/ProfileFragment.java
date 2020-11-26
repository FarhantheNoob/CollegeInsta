package com.example.collegeinsta;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.fragment_profile, container, false);
        toolbar = view.findViewById(R.id.toolBar);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Profile");
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.tool_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logOut) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(getActivity(), "Logged Out Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), LoginPage.class));
            getActivity().finish();
            return true;
        }
        return false;
    }
}