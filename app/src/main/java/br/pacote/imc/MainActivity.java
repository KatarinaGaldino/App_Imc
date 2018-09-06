package br.pacote.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //ATRIBUTOS
    private EditText edtPeso, edtAltura,  edtResultado, edtDetalhe;
    private Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERENCIAR OS CONTROLES
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        edtResultado = (EditText) findViewById(R.id.edtResultado);
        edtDetalhe = (EditText) findViewById(R.id.edtDetalhe);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);


        //ASSOCIAR TRATADOR DE EVENTOS
        btnCalcular.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
    }


    // TRATATOR DE EVENTOS
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular) {
                double peso = Double.parseDouble(edtPeso.getText().toString());
                double altura = Double.parseDouble(edtAltura.getText().toString());
                double resultado = (peso / Math.pow(altura, 2));

                edtResultado.setText(String.format("%.2f", resultado));

                if (resultado < 18.5) {
                    edtDetalhe.setText("Abaixo do Peso!");
                } else if ((resultado >= 18.5) && (resultado <= 24.9)) {
                    edtDetalhe.setText("Peso Ideal! Parabéns!!");
                } else if ((resultado >= 25.0) && (resultado <= 29.9)) {
                    edtDetalhe.setText("Levemente Acima do Peso.");
                } else if ((resultado >= 30.0) && (resultado <= 34.9)) {
                    edtDetalhe.setText("Obesidade Grau I.");
                } else if ((resultado >= 35.0) && (resultado <= 39.9)) {
                    edtDetalhe.setText("Obesidade Grau II(Severa).");
                } else if (resultado > 40.0) {
                    edtDetalhe.setText("Obesidade Grau III(Mórbida).");
                }


        } else if (v.getId() == R.id.btnLimpar) {
            edtPeso.setText("");
            edtAltura.setText("");
            edtResultado.setText("");
            edtDetalhe.setText("");
            edtPeso.requestFocus();

            Toast.makeText(this, "Dados apagados!" , Toast.LENGTH_LONG).show();
        }
    }


}
