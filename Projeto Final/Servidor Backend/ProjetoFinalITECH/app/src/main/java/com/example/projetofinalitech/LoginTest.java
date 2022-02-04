package com.example.projetofinalitech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginTest extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button button_cadastrar, button_logar;
    private EditText edtText_email, edtText_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);

        edtText_email = findViewById(R.id.edtText_emailLogin);
        edtText_senha = findViewById(R.id.edtText_senhaLogin);
        button_cadastrar = findViewById(R.id.button_cadastrar);
        button_logar = findViewById(R.id.button_logar);

        mAuth = FirebaseAuth.getInstance();

        button_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaLogin();
            }
        });
    }

    public void realizaLogin(){
        String email = edtText_email.getText().toString().trim();
        String senha = edtText_senha.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(LoginTest.this, MainActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
                            edtText_email.setError("Email incorreto");
                        }
                    }
                });

    }

}