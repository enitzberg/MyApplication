package com.example.administrator.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity3Activity extends ActionBarActivity implements View.OnClickListener{

    //initialize an array of players on this pre-set team
    ImageButton[] imageButtonsVeg = new ImageButton[6];
    Player[] playersVeg = new Player[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);

        //Set back button to go back to the main activity
        Button BackV = (Button) findViewById(R.id.BackV);
        BackV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //initialize every button to correspond to a player on the team and display
        //the picture of each player selected.
        imageButtonsVeg[0] = (ImageButton) findViewById(R.id.Tomato);
        imageButtonsVeg[0].setBackgroundResource(R.mipmap.tomato);
        playersVeg[0] = new Player("Tomato", "Sweet", 17, "Goalie", 0, "Charlott, NC");
        imageButtonsVeg[0].setOnClickListener(this);

        imageButtonsVeg[1] = (ImageButton) findViewById(R.id.Artichoke);
        imageButtonsVeg[1].setBackgroundResource(R.mipmap.artichoke);
        playersVeg[1] = new Player("Artichoke", "Buddy", 44, "Sweeper", 1, "Cambridge, MA");
        imageButtonsVeg[1].setOnClickListener(this);

        imageButtonsVeg[2] = (ImageButton) findViewById(R.id.Squash);
        imageButtonsVeg[2].setBackgroundResource(R.mipmap.squash);
        playersVeg[2] = new Player("Squash", "Jackson", 62, "Wing-Back", 4, "Tulsa, OK");
        imageButtonsVeg[2].setOnClickListener(this);

        imageButtonsVeg[3] = (ImageButton) findViewById(R.id.Carrot);
        imageButtonsVeg[3].setBackgroundResource(R.mipmap.carrot);
        playersVeg[3] = new Player("Carrot", "Top", 8, "Full-Back", 2, "Beaverton, OR");
        imageButtonsVeg[3].setOnClickListener(this);

        imageButtonsVeg[4] = (ImageButton) findViewById(R.id.Beat);
        imageButtonsVeg[4].setBackgroundResource(R.mipmap.beat);
        playersVeg[4] = new Player("Beat", "Em", 35, "Midfielder", 2, "New Orleans, LA");
        imageButtonsVeg[4].setOnClickListener(this);

        imageButtonsVeg[5] = (ImageButton) findViewById(R.id.Lettuce);
        imageButtonsVeg[5].setBackgroundResource(R.mipmap.lettuce);
        playersVeg[5] = new Player("Lettuce", "Beachu", 47, "Forward", 6, "Chicago, IL");
        imageButtonsVeg[5].setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
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
        int j;
        for (j = 0; j < imageButtonsVeg.length; j++) {
            if (imageButtonsVeg[j] == v) {
                break;
            }
        }

        //Player that the user selected.
        Player thisPlayer = playersVeg[j];
        displayData(thisPlayer);
    }

    private void displayData(Player thisPlayer) {

        //Display all of the stats that correspond to the player selected.
        TextView FirstNameVeg = (TextView)findViewById(R.id.FirstName);
        FirstNameVeg.setText("First Name:  " + thisPlayer.getFirstName());

        TextView LastNameVeg = (TextView)findViewById(R.id.LastName);
        LastNameVeg.setText("Last Name:  " + thisPlayer.getLastName());

        TextView UniformNumVeg = (TextView)findViewById(R.id.UniformNumber);
        UniformNumVeg.setText("Uniform Number:  " + thisPlayer.getUniformNumber());

        TextView PositionVeg = (TextView)findViewById(R.id.Position);
        PositionVeg.setText("Player Position:  " + thisPlayer.getPosition());

        TextView GoalsScoredVeg = (TextView)findViewById(R.id.GoalsScored);
        GoalsScoredVeg.setText("Number of Goals Scored:  " + thisPlayer.getGoalsScored());

        TextView HomeTownVeg = (TextView)findViewById(R.id.HomeTown);
        HomeTownVeg.setText("Hometown:  " + thisPlayer.getHometown());
    }
}
