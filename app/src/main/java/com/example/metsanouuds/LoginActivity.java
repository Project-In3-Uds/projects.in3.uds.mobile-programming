package com.example.metsanouuds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    private HashMap<String, String> fakeDatabase = new HashMap<>(); // username -> password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Récupération des composants
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        TextView errorTextView = findViewById(R.id.errorTextView);
        TextView registerTextView = findViewById(R.id.registerTextView);

        // Cacher le message d’erreur au départ
        errorTextView.setVisibility(View.GONE);

        // Simuler une base de données
        fakeDatabase.put("admin", "admin"); // username: admin, password: admin
        fakeDatabase.put("nanfack", "pass123");
        fakeDatabase.put("adeline", "kaa");

        // Gestion du clic sur le bouton "Se connecter"
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (fakeDatabase.containsKey(username) && fakeDatabase.get(username).equals(password)) {
                errorTextView.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);

            } else if (!fakeDatabase.containsKey(username)) {
                errorTextView.setText("Utilisateur inconnu. Veuillez vous inscrire.");
                errorTextView.setVisibility(View.VISIBLE);
            } else {
                errorTextView.setText("Nom d'utilisateur ou mot de passe incorrect.");
                errorTextView.setVisibility(View.VISIBLE);
            }
        });

        // Clic sur "S’inscrire ?"
        registerTextView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String username = data.getStringExtra("username");
            String password = data.getStringExtra("password");
            fakeDatabase.put(username, password); // Ajout dans la base
            Toast.makeText(this, "Inscription réussie, veuillez vous connecter", Toast.LENGTH_SHORT).show();
        }
    }
}
