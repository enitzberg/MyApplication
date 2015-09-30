package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity implements View.OnClickListener {

    //initialize an array of players on this pre-set team
    ImageButton[] imageButtons = new ImageButton[6];
    Player[] players = new Player[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        //Set back button to go back to the main activity
        Button Back = (Button) findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //initialize every button to correspond to a player on the team and display
        //the picture of each player selected.
        imageButtons[0] = (ImageButton) findViewById(R.id.Apple);
        imageButtons[0].setBackgroundResource(R.mipmap.apple);
        players[0] = new Player("Apple", "Red", 2, "Goalie", 1, "Minneapolis, MN");
        imageButtons[0].setOnClickListener(this);

        imageButtons[1] = (ImageButton) findViewById(R.id.Banana);
        imageButtons[1].setBackgroundResource(R.mipmap.banana);
        players[1] = new Player("Banana", "Yellow", 24, "Sweeper", 2, "Miami, FL");
        imageButtons[1].setOnClickListener(this);

        imageButtons[2] = (ImageButton) findViewById(R.id.Cherry);
        imageButtons[2].setBackgroundResource(R.mipmap.cherry);
        players[2] = new Player("Cherry", "Pink", 6, "Wing-Back", 0, "Isla Vista, CA");
        imageButtons[2].setOnClickListener(this);

        imageButtons[3] = (ImageButton) findViewById(R.id.Pear);
        imageButtons[3].setBackgroundResource(R.mipmap.pear);
        players[3] = new Player("Pear", "Green", 13, "Full-Back", 2, "Dallas, TX");
        imageButtons[3].setOnClickListener(this);

        imageButtons[4] = (ImageButton) findViewById(R.id.Strawberry);
        imageButtons[4].setBackgroundResource(R.mipmap.strawberry);
        players[4] = new Player("Straw", "Berry", 2, "Midfielder", 0, "Atlanta, Georgia");
        imageButtons[4].setOnClickListener(this);

        imageButtons[5] = (ImageButton) findViewById(R.id.Watermelon);
        imageButtons[5].setBackgroundResource(R.mipmap.watermelon);
        players[5] = new Player("Watermelon", "Delicious", 11, "Forward", 8, "Stanford, CA");
        imageButtons[5].setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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


    @Override
    public void onClick(View v) {

        //Iterate through all of the players to find the
        //corresponding player that is selected.
        int i;
        for(i =0; i<imageButtons.length; i++)
        {
            if (imageButtons[i] == v)
            {
                break;
            }

        }

        //Player that the user selected.
        Player thisPlayer = players[i];
        displayData(thisPlayer);

    }

    public void displayData(Player p)
    {
        //Display all of the stats that correspond to the player selected.
        TextView FirstNameFruit = (TextView)findViewById(R.id.FirstNameFruit);
        FirstNameFruit.setText("First Name:  " + p.getFirstName());

        TextView LastNameFruit = (TextView)findViewById(R.id.LastNameFruit);
        LastNameFruit.setText("Last Name:  " + p.getLastName());

        TextView UniformNumFruit = (TextView)findViewById(R.id.UniformNumFruit);
        UniformNumFruit.setText("Uniform Number:  " + p.getUniformNumber());

        TextView PositionFruit = (TextView)findViewById(R.id.PositionFruit);
        PositionFruit.setText("Player Position:  " + p.getPosition());

        TextView GoalsScoredFruit = (TextView)findViewById(R.id.GoalsScoredFruit);
        GoalsScoredFruit.setText("Number of Goals Scored:  " + p.getGoalsScored());

        TextView HomeTownFruit = (TextView)findViewById(R.id.HometownFruit);
        HomeTownFruit.setText("Hometown:  " + p.getHometown());

    }
}
