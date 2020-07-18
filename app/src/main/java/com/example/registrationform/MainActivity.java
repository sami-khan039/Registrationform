package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    MaterialCardView cv;
    ImageView img;
    Button btnimg, reg, reg1;
    TextView wname, wemail, wpass, wrepass, gender, country, la, wgender;
    EditText name, email, pass, repass;
    RadioGroup rg;
    RadioButton male, female, other;
    CheckBox cb;
    Spinner clist;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inititems();
        refresh();
        spinnr();
        btnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you dont have images bitch!", Toast.LENGTH_SHORT).show();
            }
        });
        register();

    }


    private void register() {
 reg.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         if (validate()) {
             if (confirmpassword()) {
                 removewarning();
                 if (cb.isChecked()) {
                     Snackbar.make(rl, "you are registered man!", Snackbar.LENGTH_INDEFINITE).setAction("dismiss", new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             removewarning();
                             refresh();
                         }
                     }).show();
                 }
                else if(!cb.isChecked()){
                     Toast.makeText(MainActivity.this,"you should agree first !",Toast.LENGTH_SHORT).show();
//                     toast();
                 }
             }

         }
     }
 });
    }

    private void toast() {
         Toast.makeText(MainActivity.this,"you should agree first !",Toast.LENGTH_SHORT);
    }


    private boolean confirmpassword() {
        if (!pass.getText().toString().equals(repass.getText().toString())) {
            wrepass.setText("password doesnt match !");
            wrepass.setVisibility(View.VISIBLE);
            return false;
        }
        return true;
    }

    private void removewarning() {
        wname.setVisibility(View.GONE);
        wemail.setVisibility(View.GONE);
        wpass.setVisibility(View.GONE);
        wrepass.setVisibility(View.GONE);

    }

    private boolean validate() {
        if (name.getText().toString().equals("")) {
            wname.setVisibility(View.VISIBLE);
            return false;
        } else if (email.getText().toString().equals("")) {
            wemail.setVisibility(View.VISIBLE);
            return false;
        } else if (pass.getText().toString().equals("")) {
            wpass.setVisibility(View.VISIBLE);
            return false;
        } else if (repass.getText().toString().equals("")) {
            wrepass.setVisibility(View.VISIBLE);
            return false;
        }
        return true;
    }

    private void refresh() {
        name.setText("");
        email.setText("");
        pass.setText("");
        repass.setText("");
        cb.setChecked(false);
        wname.setVisibility(View.GONE);
        wemail.setVisibility(View.GONE);
        wpass.setVisibility(View.GONE);
        wrepass.setVisibility(View.GONE);

        reg.setVisibility(View.VISIBLE);

    }

    private void spinnr() {
        ArrayList<String> countries = new ArrayList<>(Arrays.asList("America", "Africa", "China", "Germany", "India", "Pakistan", "England", "Spain", "Bangladesh", "Japan"));
        ArrayAdapter<String> aa = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, countries);
        clist.setAdapter(aa);
    }

    private void inititems() {
        reg1 = findViewById(R.id.reg1);
        wgender = findViewById(R.id.wgender);
        rl = findViewById(R.id.rl);
        cv = findViewById(R.id.cvimg);
        img = findViewById(R.id.img);
        btnimg = findViewById(R.id.btnimg);
        reg = findViewById(R.id.reg);
        wname = findViewById(R.id.wname);
        wemail = findViewById(R.id.wemail);
        wpass = findViewById(R.id.wpass);
        wrepass = findViewById(R.id.wrepass);
        gender = findViewById(R.id.gender);
        country = findViewById(R.id.country);
        la = findViewById(R.id.la);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        repass = findViewById(R.id.repass);
        rg = findViewById(R.id.rg);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        other = findViewById(R.id.other);
        cb = findViewById(R.id.cb);
        clist = findViewById(R.id.clist);
    }
}