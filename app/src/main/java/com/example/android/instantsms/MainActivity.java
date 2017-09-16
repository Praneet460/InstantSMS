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

    private ListView listViewWishes;
    private String messageForEditText;
    private TextView textView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewWishes = (ListView) findViewById(R.id.ListView);
        textView = (TextView) findViewById(R.id.et1);
        
        final ArrayAdapter<CharSequence> adapterWishes = ArrayAdapter.createFromResource(this,
                R.array.wishes,
                android.R.layout.simple_list_item_1);
        listViewWishes.setAdapter(adapterWishes);

        listViewWishes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                
                //see we use the int position to get the corresponding item . Tell if this works
                messageForEditText = listViewWishes.getItemAtPosition(position).toString();
                textView.setText(messageForEditText);
            
            }
        });



    }
}
