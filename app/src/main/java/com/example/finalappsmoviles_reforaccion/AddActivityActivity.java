package com.example.finalappsmoviles_reforaccion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddActivityActivity extends AppCompatActivity {

    private List<Activity> activitiesList; // Asegúrate de tener una lista existente
    private ActivityAdapter adapter; // Asegúrate de tener un adaptador existente

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);

        // Inicializar vistas
        EditText titleET_AAV = findViewById(R.id.titleET_AAV);
        EditText cityET_AAV = findViewById(R.id.cityET_AAV);
        EditText countryET_AAV = findViewById(R.id.countryET_AAV);
        EditText dateET_AAV = findViewById(R.id.dateET_AAV);
        EditText descriptionET_AAV = findViewById(R.id.descriptionET_AAV);
        Button addActivityButton_AAV = findViewById(R.id.addActivityButton_AAV);

        // Configurar el listener para añadir una actividad
        addActivityButton_AAV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addActivity(titleET_AAV, cityET_AAV, countryET_AAV, dateET_AAV, descriptionET_AAV);
            }
        });
    }

    private void addActivity(EditText titleET_AAV, EditText cityET_AAV,
                                 EditText countryET_AAV, EditText dateET_AAV,
                                 EditText descriptionET_AAV) {
        // Obtener los valores de los EditText
        String titulo = titleET_AAV.getText().toString().trim();
        String ciudad = cityET_AAV.getText().toString().trim();
        String pais = countryET_AAV.getText().toString().trim();
        String ubicacion = ciudad + ", " + pais;
        String fechaString = dateET_AAV.getText().toString().trim();
        String descripcion = descriptionET_AAV.getText().toString().trim();

        // Validar que los campos no estén vacíos
        if (titulo.isEmpty() || ciudad.isEmpty() || pais.isEmpty() || fechaString.isEmpty() || descripcion.isEmpty()) {
            // Mostrar un mensaje indicando que todos los campos son obligatorios
            showToast("Todos los campos son obligatorios");
            return;
        }

        // Añadir la actividad utilizando la clase Activity
        Activity.addActivity(titulo, descripcion, fechaString, ubicacion);

        // Mostrar un mensaje indicando que la actividad se añadió correctamente
        showToast("Actividad añadida correctamente");

        // Cerrar la actividad después de añadir la actividad
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    private Date parsearFecha(String fechaString) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
            return formatoFecha.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void showToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}