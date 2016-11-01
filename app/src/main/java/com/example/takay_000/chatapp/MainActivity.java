package com.example.takay_000.chatapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import static android.R.attr.button;
import static android.R.attr.id;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public EditText editText;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView=(ListView)findViewById(R.id.ListView);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        editText = (EditText) findViewById(R.id.editText);

        listView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

        adapter.add("Taka: "+editText.getText().toString());

        // 1秒後に応答
        new Handler().postDelayed(func, 1000);

    }

    private final Runnable func= new Runnable() {
        @Override
        public void run() {
            adapter.add("Computer: "+editText.getText().toString());
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
