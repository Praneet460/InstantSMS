package com.example.android.instantsms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewWishes = (ListView) findViewById(R.id.ListView);
        final ArrayAdapter<CharSequence> adapterWishes = ArrayAdapter.createFromResource(this,
                R.array.wishes,
                android.R.layout.simple_list_item_1);
        listViewWishes.setAdapter(adapterWishes);

        listViewWishes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String message = "You Picked";
                Toast.makeText(getApplicationContext(),
                        message,
                        Toast.LENGTH_SHORT).show();

            }
        });



    }
}
