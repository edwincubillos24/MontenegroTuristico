package com.edwinacubillos.montenegroturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText eRUsuario, eRRepPassword, eRPassword, eCorreo;
    Button bRegistrarse, bCancelar;

    String usuario, password, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        /*Bundle extras = getIntent().getExtras();
        Toast.makeText(this, extras.getString("username"),Toast.LENGTH_SHORT).show();*/



        eRUsuario = (EditText) findViewById(R.id.eRUsuario);
        eRRepPassword = (EditText) findViewById(R.id.eRRepPassword);
        eRPassword = (EditText) findViewById(R.id.eRPassword);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        bRegistrarse = (Button) findViewById(R.id.bRegistarse);
        bCancelar = (Button) findViewById(R.id.bCancelar);

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

        bRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Comunicacion en una direcciòn
            /*    Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                intent.putExtra("username", eRUsuario.getText().toString());
                intent.putExtra("contrasena", eRPassword.getText().toString());
                intent.putExtra("correo",eCorreo.getText().toString());
                startActivity(intent);*/

                //Validar que todos los campos esten llenos
                //Validar que las dos contraseñas sean iguales
                Intent intent = new Intent();
                intent.putExtra("username", eRUsuario.getText().toString());
                intent.putExtra("password", eRPassword.getText().toString());
                intent.putExtra("correo",eCorreo.getText().toString());
                setResult(RESULT_OK,intent);
                finish();

                //en caso contrario
                //se debe mostrar mensajes o notificaciones tipo TOAST
            }
        });


    }
}
