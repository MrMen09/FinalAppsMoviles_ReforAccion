package com.example.finalappsmoviles_reforaccion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TipsFragment extends Fragment {

    private RecyclerView recyclerViewTip;
    private TipAdapter tipAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tips, container, false);

        recyclerViewTip = view.findViewById(R.id.recyclerViewTip);
        recyclerViewTip.setLayoutManager(new LinearLayoutManager(getContext()));

        // Supongamos que tienes una lista de tips
        List<Tip> tipList = obtenerListaDeTips();

        tipAdapter = new TipAdapter(tipList);
        recyclerViewTip.setAdapter(tipAdapter);

        return view;
    }

    private List<Tip> obtenerListaDeTips() {
        // Aquí deberías obtener la lista de tips desde tu fuente de datos (base de datos, API, etc.)
        // Por ahora, simplemente crearemos una lista de ejemplo
        List<Tip> tips = new ArrayList<>();
        tips.add(new Tip("Título 1", "Descripción 1", "Categoría 1", R.drawable.icon_tips));
        tips.add(new Tip("Título 2", "Descripción 2", "Categoría 2", R.drawable.icon_tips));
        // Añade más tips según sea necesario
        return tips;
    }
}