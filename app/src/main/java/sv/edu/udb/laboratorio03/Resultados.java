package sv.edu.udb.laboratorio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    private TextView lblresultado;
    private TextView lblnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        lblresultado = (TextView)findViewById(R.id.textView);
        lblnombre = (TextView)findViewById(R.id.textView3);
        String dato = getIntent().getStringExtra("pago");
        String nombre = getIntent().getStringExtra("nombre");
        lblresultado.setText("Su salario es: " + dato);
        lblnombre.setText("Empleado: " + nombre);
    }

    public void Regresar(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}