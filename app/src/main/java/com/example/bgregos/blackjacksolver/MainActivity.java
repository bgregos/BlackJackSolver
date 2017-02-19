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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private int userid;
    private int dealerid;

    private void createNewDealerCard(){
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        TableLayout dealerTable = (TableLayout) /*view.*/findViewById(R.id.dealertable);
        View tableLayout = inflater.inflate(R.layout.card, null);
        TableRow t = (TableRow) tableLayout.findViewById(R.id.tr);
        t.setTag(dealerid);
        dealerid++;
        Spinner suitSpinner = (Spinner) t.getChildAt(0);
        Spinner valueSpinner = (Spinner) t.getChildAt(1);
        dealerSuit.add(suitSpinner.getSelectedItem().toString());
        dealerValue.add(valueSpinner.getSelectedItem().toString());
        dealerTable.addView(tableLayout);
    }

    private void createNewUserCard() {
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        TableLayout userView = (TableLayout) /*view.*/findViewById(R.id.usertable);
        View tableLayout = inflater.inflate(R.layout.card, null);
        TableRow t = (TableRow) tableLayout.findViewById(R.id.tr);
        //System.out.println(t.toString());
        t.setTag(userid);
        userid++;
        Spinner suitSpinner = (Spinner) t.getChildAt(0);
        Spinner valueSpinner = (Spinner) t.getChildAt(1);
        userSuit.add(suitSpinner.getSelectedItem().toString());
        userValue.add(valueSpinner.getSelectedItem().toString());
        //NOTE: get with findViewByTag();
        userView.addView(tableLayout);
    }

    private ArrayList<String> userSuit;
    private ArrayList<String> userValue;
    private ArrayList<String> dealerSuit;
    private ArrayList<String> dealerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userid=0;
        dealerid=0;
        userSuit = new ArrayList<>();
        userValue = new ArrayList<>();
        dealerSuit = new ArrayList<>();
        dealerValue = new ArrayList<>();
        System.out.println("Launched!");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton dfab = (FloatingActionButton) findViewById(R.id.dfab);
        FloatingActionButton calculate = (FloatingActionButton) findViewById(R.id.calculate);
        final TextView disptext = findViewById(R.id.dispText);

        for (int i = 0; i < 2; i++) {
            createNewUserCard();
        }

        createNewDealerCard();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewUserCard();
            }
        });

        dfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewDealerCard();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double percentage = new BlackJack(userSuit, userValue, dealerSuit, dealerValue).returnPercentage();
                disptext.setText(percentage + "%");
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        for(String s: userSuit){
            System.out.println(s);
        }
        //END OF ON CREATE
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
