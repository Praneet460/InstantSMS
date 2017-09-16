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

    //this is declaring of variables. like we do in C/C++ int a, int b etc
    //what is private ? its access-modifier can be public or protected also
    //this is also Global Declaration of variables as you know
    private ListView listViewWishes;
    private String messageForEditText;
    private TextView textView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the layout for our Java file
        setContentView(R.layout.activity_main);
        
        //Example of Local Decalartion of Variables
        private String exampleLocalDeclaration;

        //init Views
        //this stands for initializing of various Views. Links XML to Java basically
        listViewWishes = (ListView) findViewById(R.id.ListView);
        textView = (TextView) findViewById(R.id.et1);
        
        //here we set an ArrayAdapter to inflate(to fill) our ListView
        final ArrayAdapter<CharSequence> adapterWishes = ArrayAdapter.createFromResource(this,
                R.array.wishes,
                android.R.layout.simple_list_item_1);
        listViewWishes.setAdapter(adapterWishes);

        //this is as you the click listener for out List
        //for click on Send Button same needs to be done
        listViewWishes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                
                //using the getItemAtPosition method we get to know which item is clicked!
                messageForEditText = listViewWishes.getItemAtPosition(position).toString();
                //then we set the corresponding message to our EditText.
                textView.setText(messageForEditText);
            
            }
        });


        //Logic for sharing message through Send Button on clicking on Send Button
        //getting the value from EditText
        String share_Message = textView.getText().toString();
        
        //create Intent
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, share_Message);
            startActivity(Intent.createChooser(sharingIntent, "Share Using")));

    }
}
