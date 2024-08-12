package com.marcin.kalkulator_odl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton milaM,milaL,jard,stopa,cal;
    private Button button;
    private TextView textView;
    private EditText dist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioGroup = (RadioGroup) findViewById(R.id.rgroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbMilaM){
                    Toast.makeText(getApplicationContext(),"wybrano: Mile Morskie",Toast.LENGTH_SHORT).show();
                }
                else if(i==R.id.rbMilaL){
                    Toast.makeText(getApplicationContext(),"wybrano: Mile Lądowe",Toast.LENGTH_SHORT).show();
                }
                else if(i==R.id.rbJard){
                    Toast.makeText(getApplicationContext(),"wybrano: Jardy",Toast.LENGTH_SHORT).show();
                }
                else if(i==R.id.rbStopa){
                    Toast.makeText(getApplicationContext(),"wybrano: Stopy",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"wybrano: Cale",Toast.LENGTH_SHORT).show();
                }
            }
        });

        milaM = (RadioButton) findViewById(R.id.rbMilaM);
        milaL = (RadioButton) findViewById(R.id.rbMilaL);
        jard = (RadioButton) findViewById(R.id.rbJard);
        stopa = (RadioButton) findViewById(R.id.rbStopa);
        cal = (RadioButton) findViewById(R.id.rbCal);
        textView = (TextView) findViewById(R.id.tvWynik);

        button = (Button) findViewById(R.id.btnPolicz);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                dist = (EditText) findViewById(R.id.etOdl);
                final double ds = new Double(dist.getText().toString());

                java.text.DecimalFormat df = new java.text.DecimalFormat();
                df.setMaximumFractionDigits(2);
                df.setMaximumFractionDigits(2);

                if(selectedId == milaM.getId()){
                    Anglo mm = new Anglo(ds,IPrzeliczniki.milaPP);
                    textView.setText("odległośc w milach morskich: " + df.format(mm.policzOdl()));
                }

                if(selectedId == milaL.getId()){
                    Anglo ml = new Anglo(ds,IPrzeliczniki.milaLP);
                    textView.setText("odległośc w milach lądowych: " + df.format(ml.policzOdl()));
                }

                if(selectedId == jard.getId()){
                    Anglo jd = new Anglo(ds,IPrzeliczniki.jardP);
                    textView.setText("odległośc w jardach: " + df.format(jd.policzOdl()));
                }

                if(selectedId == stopa.getId()){
                    Anglo st = new Anglo(ds,IPrzeliczniki.stopaP);
                    textView.setText("odległośc w stopach: " + df.format(st.policzOdl()));
                }

                if(selectedId == cal.getId()){
                    Anglo cl = new Anglo(ds,IPrzeliczniki.calP);
                    textView.setText("odległośc w calach: " + df.format(cl.policzOdl()));
                }
            }
        });

    }
}
