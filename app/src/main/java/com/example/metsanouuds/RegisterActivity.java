package com.example.metsanouuds;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText newUsername = findViewById(R.id.newUsername);
        EditText newPassword = findViewById(R.id.newPassword);
        Button registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(v -> {
            String username = newUsername.getText().toString();
            String password = newPassword.getText().toString();

            if (!username.isEmpty() && !password.isEmpty()) {
                // Simuler en enregistrant dans une Intent
                Intent intent = new Intent();
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                setResult(RESULT_OK, intent);
                finish(); // Retour à LoginActivity
            } else {
                Toast.makeText(this, "Champs vides !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
