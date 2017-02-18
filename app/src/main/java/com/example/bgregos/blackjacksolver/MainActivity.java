package com.example.bgregos.blackjacksolver;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.widget.TableLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton dfab = (FloatingActionButton) findViewById(R.id.dfab);
        //ArrayAdapter<String > gender_adapter = new ArrayAdapter<String> (getActivity(), R.layout.spinner_style,gender_spinner );

        for (int i = 0; i < 2; i++) {
            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);
                TableLayout tableView = (TableLayout) /*view.*/findViewById(R.id.usertable);
            System.out.println(tableView.toString());
            View tableLayout = inflater.inflate(R.layout.card, null);
            tableView.addView(tableLayout);
        }

        //create new card
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        TableLayout tableView = (TableLayout) /*view.*/findViewById(R.id.dealertable);
        System.out.println(tableView.toString());
        View tableLayout = inflater.inflate(R.layout.card, null);
        tableView.addView(tableLayout);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create new card
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);
                TableLayout tableView = (TableLayout) /*view.*/findViewById(R.id.usertable);
                System.out.println(tableView.toString());
                View tableLayout = inflater.inflate(R.layout.card, null);
                tableView.addView(tableLayout);
            }
        });

        dfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create new card
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);
                TableLayout tableView = (TableLayout) /*view.*/findViewById(R.id.dealertable);
                System.out.println(tableView.toString());
                View tableLayout = inflater.inflate(R.layout.card, null);
                tableView.addView(tableLayout);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

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

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
