package com.marcin.komponentlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView content;

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

        content = findViewById(R.id.textView);
        String[] values = new String[]{
                "Opcja wejściowa",
                "Opcja strategiczna",
                "Opcja specjalna",
                "Opcja pusta",
                "Opcja wielozadaniowa",
                "Opcja dodatkowa",
                "Opcja awaryjna",
                "Opcja ukryta",
                "Opcja wyjściowa",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,values);
        ListView list = findViewById(R.id.lista);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int itemPosition = i+1;
                String itemValue = (String) adapterView.getItemAtPosition(i);
                content.setText("Kliknięto\npozycja: " + itemPosition + "\nwartośc opcji: " + itemValue);
            }
        });
    }
}
