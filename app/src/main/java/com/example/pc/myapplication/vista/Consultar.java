package com.example.pc.myapplication.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.myapplication.R;
import com.example.pc.myapplication.controlador.ControladorMascotas;
import com.example.pc.myapplication.controlador.ControladorPropietario;
import com.example.pc.myapplication.modelo.Mascota;
import com.example.pc.myapplication.modelo.Propietario;

import static com.example.pc.myapplication.R.id.nombrePropietario;
import static com.example.pc.myapplication.R.id.telefonoPropietario;

public class Consultar extends AppCompatActivity {
    Mascota mascota;
    Propietario propietario;
    EditText cedulaMasc;
    ControladorMascotas controladorMascotas;
    ControladorPropietario controladorPropietario;
    TextView datosMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        cedulaMasc=(EditText)findViewById(R.id.edt_cedula_mascota);
        datosMascota=(TextView)findViewById(R.id.tv_dato_mascota);
        controladorMascotas=new ControladorMascotas(this);
        controladorPropietario = new ControladorPropietario(this);


    }
    public  void  buscarEliPro(View v){
       String cedulaMas;
        cedulaMas=cedulaMasc.getText().toString();

        mascota=controladorMascotas.consultarMascota(cedulaMas);
        if (mascota== null){

            Toast.makeText(this, "La Mascota  No Existe", Toast.LENGTH_SHORT).show();
        }else {
            propietario=controladorPropietario.consultarPropietario(mascota.getNombreP());

         datosMascota.setText("Nombre Mascota:"+mascota.getNombre()+" \n Tipo Mascota:"+mascota.getTipo()+" \n Edad Mascota:"+mascota.getEdad()+" \n Raza Mascota:"+mascota.getRaza()+" \n Cedula Propietario:"+propietario.getCedula()+" \n Nombre Propietario:"+propietario.getNombre()+" \n Telefono Propietario:"+propietario.getTelefono());

        }




    }
    public  void  eliminarMascotaC(View v){
        controladorMascotas.eliminararMascota(mascota.getCedula());
        Toast.makeText(this, "Mascota Eliminada Correctamente", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

        }

    public void volver(View v){
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
        finish();


    }
}
