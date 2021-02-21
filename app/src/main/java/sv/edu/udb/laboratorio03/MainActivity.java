package sv.edu.udb.laboratorio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private Button btn;
    Validaciones  validar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.editTextTextPersonName);
        et2 = (EditText)findViewById(R.id.editTextNumber2);
        et3 = (EditText)findViewById(R.id.editTextNumber);
        validar = new Validaciones();
    }

    public void Enviar(View view){
        try {
        int salario = Integer.parseInt(et2.getText().toString());
        int anios = Integer.parseInt(et3.getText().toString());
        double totalPagar = 0.00;

            if (!validar.Vacio(et1) && !validar.Vacio(et2) && !validar.Vacio(et3)) {
                if (validar.soloLetras(et1.getText().toString())) {
                    if (salario >= 100) {
                        Intent i = new Intent(this, Resultados.class);
                        i.putExtra("nombre", et1.getText().toString());
                        startActivity(i);

                        if (salario < 500 && anios >= 10) {
                            totalPagar = (salario + (salario * 0.20));
                            i.putExtra("pago", Double.toString(totalPagar));
                            startActivity(i);

                        } else if (salario < 500 && anios < 10) {
                            totalPagar = (salario + (salario * 0.05));
                            i.putExtra("pago", Double.toString(totalPagar));
                            startActivity(i);

                        } else {
                            totalPagar = salario;
                            i.putExtra("pago", Double.toString(totalPagar));
                            startActivity(i);
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "El salario debe mayor o igual a $100", Toast.LENGTH_SHORT).show();
                        et2.setError("Alerta");
                        et2.requestFocus();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Campo Nombre requiere solo letras", Toast.LENGTH_SHORT).show();
                    et1.setError("Solo letras");
                    et1.requestFocus();
                }
            }
        }catch (Exception error1){
            Toast.makeText(getApplicationContext(), "No se permiten campos vacios", Toast.LENGTH_SHORT).show();
        }
    }
}