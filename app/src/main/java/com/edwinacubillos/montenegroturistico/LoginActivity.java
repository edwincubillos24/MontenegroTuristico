package com.edwinacubillos.montenegroturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, ePassword;
    Button bIniciar;
    TextView tRegistrarse;
    String username="", password="",correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        ePassword = (EditText) findViewById(R.id.ePassword);
        bIniciar = (Button) findViewById(R.id.bIniciar);
        tRegistrarse = (TextView) findViewById(R.id.tRegistrarse);

        /*Bundle extras = getIntent().getExtras();
        Toast.makeText(this, extras.getString("username"),Toast.LENGTH_LONG).show();*/


        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aplica para comunicacion en un solo sentido
                /*Intent intent = new Intent (LoginActivity.this, RegistroActivity.class);
                startActivity(intent);*/

                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(intent,1234);
            }
        });

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validar que el usuario y contrasña sean iguales a los recibidos
                if (eUsuario.getText().toString().equals(username) && ePassword.getText().toString().equals(password)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("correo",correo);
                    startActivity(intent);
                }
            }
        });
     }

    @Override

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");
            Log.d("nombre",data.getExtras().getString("username"));
            Log.d("correo",data.getExtras().getString("correo"));
        }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Error en login",Toast.LENGTH_SHORT).show();
        }

    }

}
