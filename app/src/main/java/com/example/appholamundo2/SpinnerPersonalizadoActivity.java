package com.example.appholamundo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SpinnerPersonalizadoActivity extends AppCompatActivity {
    private Spinner sp;
    private Button btnCerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner_personalizado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCerrar = findViewById(R.id.btnCerrar);

        ArrayList<ItemsDatos> list = new ArrayList<>();
        list.add(new ItemsDatos(getString(R.string.itemsFrappses), getString(R.string.msgFrapses), R.drawable.categorias));
        list.add(new ItemsDatos(getString(R.string.itemsAgradecimiento), getString(R.string.msgAgradecimientos), R.drawable.agradecimiento));
        list.add(new ItemsDatos(getString(R.string.itemsAmor), getString(R.string.msgAmor), R.drawable.corazon));
        list.add(new ItemsDatos(getString(R.string.itemsNewYear), getString(R.string.msgNewYear), R.drawable.nuevo));
        list.add(new ItemsDatos(getString(R.string.itemsCanciones), getString(R.string.msgCanciones), R.drawable.canciones));

        sp = findViewById(R.id.spinner1);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_layout, R.id.lblCategorias, list);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), getString(R.string.msgSeleccionado).toString() + " " + ((ItemsDatos) parent.getItemAtPosition(position)).getTxtCategoria(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
