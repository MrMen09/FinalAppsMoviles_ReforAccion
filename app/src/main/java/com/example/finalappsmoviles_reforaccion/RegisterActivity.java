package com.example.finalappsmoviles_reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private EditText userNameET_RV, emailRegisterET_RV, passwordET_RV, confirmPasswordET_RV;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        // Inicializar los EditText y el botón
        userNameET_RV = findViewById(R.id.userNameET_RV);
        emailRegisterET_RV = findViewById(R.id.emailRegisterET_RV);
        passwordET_RV = findViewById(R.id.passwordET_RV);
        confirmPasswordET_RV = findViewById(R.id.confirmPasswordET_RV);
        Button registerRegisterBTN_RV = findViewById(R.id.registerRegisterBTN_RV);

        //Inicializando el gestor de usuarios
        userManager = UserManager.getInstance();

        // Configurar el listener para el botón de registro
        registerRegisterBTN_RV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Obtener datos de los EditText
        String userName = userNameET_RV.getText().toString().trim();
        String email = emailRegisterET_RV.getText().toString().trim();
        String password = passwordET_RV.getText().toString();
        String confirmPassword = confirmPasswordET_RV.getText().toString();

        // Validaciones
        if (userName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showErrorMessage("Todos los campos son obligatorios");
            return;
        }

        // Verificar si el nombre de usuario ya está registrado
        if (userManager.isExistingUser(userName)) {
            showErrorMessage("El nombre de usuario ya está registrado");
            return;
        }
        //Verifica el formato del Email
        //if (!esFormatoEmailValido(email)) {
        //    showErrorMessage("El formato del correo electrónico no es válido");
        //    return;
        //}

        // Verificar si el correo electrónico ya está registrado
        if (userManager.isExistingEmail(email)) {
            showErrorMessage("El correo electrónico ya está registrado");
            return;
        }

        // Verificar coincidencia de contraseñas
        if (!password.equals(confirmPassword)) {
            showErrorMessage("Las contraseñas no coinciden");
            return;
        }

        // Crear un nuevo usuario y agregarlo a la lista
        User newUser = new User(userName, email, password);
        userManager.addUser(newUser);

        // Aquí puedes implementar lógica adicional, como redireccionar a otra actividad o mostrar un mensaje de éxito
        showMessage("Registro exitoso");

        // Limpiar los EditText después del registro
        cleanFields();

        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
    private boolean esFormatoEmailValido(String email) {
        String regularExpression = "^[\\\\w.-]+@([\\\\w\\\\-]+\\\\.)+[A-Z]{2,4}$";
        return email.matches(regularExpression);
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showErrorMessage(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    private void cleanFields() {
        userNameET_RV.setText("");
        emailRegisterET_RV.setText("");
        passwordET_RV.setText("");
        confirmPasswordET_RV.setText("");
    }
}