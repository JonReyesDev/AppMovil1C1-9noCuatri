package com.example.appholamundo2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CoinsActivity extends AppCompatActivity {

    private EditText editTextAmount;
    private Spinner spinnerCurrency;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coins);

        editTextAmount = findViewById(R.id.editTextAmount);
        spinnerCurrency = findViewById(R.id.spinnerCurrency);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonClose = findViewById(R.id.buttonClose);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrency.setAdapter(adapter);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateConversion();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void calculateConversion() {
        String amountStr = editTextAmount.getText().toString();
        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese una cantidad", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountStr);
        String selectedCurrency = spinnerCurrency.getSelectedItem().toString();
        double result = 0;

        switch (selectedCurrency) {
            case "Dólares Americanos":
                result = amount * 0.056; // Ejemplo de tasa de cambio
                break;
            case "Euros":
                result = amount * 0.051; // Ejemplo de tasa de cambio
                break;
            case "Dólar Canadiense":
                result = amount * 0.076; // Ejemplo de tasa de cambio
                break;
            case "Libra Esterlina":
                result = amount * 0.044; // Ejemplo de tasa de cambio
                break;
        }

        textViewResult.setText(String.format("Resultado: %.2f %s", result, selectedCurrency));
    }

    private void clearFields() {
        editTextAmount.setText("");
        spinnerCurrency.setSelection(0);
        textViewResult.setText("Resultado");
    }

}

