package com.ayub.pabmodul3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements TextWatcher {
    AutoCompleteTextView ac;
    public String[] stringdatapro = {"Prodi Teknik Informatika", "Prodi Sistem Informasi",
            "Prodi Desain Komunikasi Visual ","Prodi Teknik Sipil", "Prodi Hukum", "Prodi Manajemen Informatika"};
            EditText lv;
            @Override public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac = (AutoCompleteTextView) findViewById(R.id.dataautocomplete);
        ac.addTextChangedListener(this);
        ac.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stringdatapro));
    }
    public void pilihprodi (View v) { lv = (EditText) findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Prodi Fakultas Komputer");
        builder.setItems(stringdatapro, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdatapro[item]);
                dialog.dismiss();
            }
        }).show();
    }
    public void onTextChanged(CharSequence s, int start, int before, int count) { }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    public void afterTextChanged(Editable s) { }

    protected void onPause() {
        super.onPause();
        LinearLayout layout = findViewById(R.id.layout);
        layout.setBackgroundColor(Color.BLACK);

        Toast.makeText(this, "Aplikasi sedang dalam posisi pause", Toast.LENGTH_LONG).show();
    }
            }