package com.example.finalappsmoviles_reforaccion;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private RecyclerView mainRV_MV;
    private ActivityAdapter activityAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        mainRV_MV = view.findViewById(R.id.mainRV_MV);
        mainRV_MV.setLayoutManager(new LinearLayoutManager(getContext()));

        FloatingActionButton addActivityFAB_MV = view.findViewById(R.id.addActivityFAB_MV);
        // Supongamos que tienes una lista de activities
        List<Activity> activitiesList = obtenerListaDeActivities();

        activityAdapter = new ActivityAdapter(activitiesList);
        mainRV_MV.setAdapter(activityAdapter);

        addActivityFAB_MV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirigir a la actividad para añadir una nueva Activity
                startActivity(new Intent(getActivity(), AddActivityActivity.class));
                finalizarActividad();
            }
        });

        return view;
    }

    private List<Activity> obtenerListaDeActivities() {
        List<Activity> activitiesList = Activity.getActivitiesList();
        return activitiesList;
    }
    private void finalizarActividad() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

}
