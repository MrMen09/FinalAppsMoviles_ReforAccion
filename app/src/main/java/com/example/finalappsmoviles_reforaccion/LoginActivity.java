package com.example.finalappsmoviles_reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailET_LV, passwordET_LV;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar los EditText y los botones
        emailET_LV = findViewById(R.id.emailET_LV);
        passwordET_LV = findViewById(R.id.passwordET_LV);
        Button loginButton = findViewById(R.id.loginBTN_LV);
        Button goToRegisterButton = findViewById(R.id.registerBTN_LV);

        //Inicializando el gestor de usuarios
        userManager = UserManager.getInstance();

        // Configurar el listener para el botón de inicio de sesión
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        // Configurar el listener para el botón de ir a registro
        goToRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });
    }

    private void login() {
        // Obtener datos de los EditText
        String email = emailET_LV.getText().toString().trim();
        String password = passwordET_LV.getText().toString();

        // Realizar validaciones de inicio de sesión
        if (validateCredentials(email, password)) {
            // Iniciar sesión exitosa
            showMessage("Inicio de sesión exitoso");

            // Puedes redirigir a otra actividad después del inicio de sesión exitoso
            // Aquí, por ejemplo, redirigiremos a una actividad principal
            startActivity(new Intent(this, MainActivity.class));
            finish();  // Finalizar la actividad actual
        } else {
            // Mostrar mensaje de error si las credenciales no son válidas
            showErrorMessage("Credenciales no válidas");
        }
    }

    private boolean validateCredentials(String email, String password) {

        // Por ahora, simularemos la autenticación con una lista de usuarios registrados
        for (User user : userManager.getUserList()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private void goToRegister() {
        // Redirigir a la actividad de Registro
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showErrorMessage(String message) {
        // Puedes personalizar la presentación del mensaje de error según tus necesidades
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}