package com.septianPramana.latihan2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.septianPramana.latihan2a.Model.Contact;

public class MainActivity extends AppCompatActivity {

    private RadioButton male;
    private EditText telp, address, id, name;
    private Spinner city;
    private Button save;

    private CheckBox s1,s2,s3,sd,smp,sma;
    private void init() {
        id = (EditText)findViewById(R.id.input_idText);
        name = (EditText)findViewById(R.id.input_nameText);
        telp = (EditText)findViewById(R.id.input_telpText);
        address = (EditText)findViewById(R.id.input_addressText);

        city = (Spinner)findViewById(R.id.input_cityText);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.kota, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(adapter);

        s1 = (CheckBox)findViewById(R.id.input_s1);
        s2 = (CheckBox)findViewById(R.id.input_s2);
        s3 = (CheckBox)findViewById(R.id.input_s3);

        sd = (CheckBox)findViewById(R.id.input_sd);
        smp = (CheckBox)findViewById(R.id.input_smp);
        sma = (CheckBox)findViewById(R.id.input_sma);

        male = (RadioButton) findViewById(R.id.input_maleRadio);
        male.setChecked(true);

        ((Button) findViewById(R.id.button_save)).setOnClickListener(this::buttonOnClick);
    }

    void buttonOnClick(View view){
        Contact c = new Contact();

        c.setAddress(address.getText().toString());
        c.setId(id.getText().toString());
        c.setPhone(telp.getText().toString());
        c.setName(name.getText().toString());
        c.setCity(city.getSelectedItem().toString());

        c.setMale(male.isChecked());

        c.setS1(s1.isChecked());
        c.setS2(s2.isChecked());
        c.setS3(s3.isChecked());

        c.setSd(sd.isChecked());
        c.setSmp(smp.isChecked());
        c.setSma(sma.isChecked());

        if (c.getAddress() == null || c.getAddress().isEmpty() || c.getAddress().isBlank()){
            address.setError("Address cannot be null");
        }

        if (c.getId() == null || c.getId().isEmpty() || c.getId().isBlank()){
            id.setError("ID cannot be null");
        }

        if (c.getPhone() == null || c.getPhone().isEmpty() || c.getPhone().isBlank()){
            telp.setError("Phone cannot be null");
        }

        if (c.getName() == null || c.getName().isEmpty() || c.getName().isBlank()){
            name.setError("City cannot be null");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_p4);

        init();
    }

}