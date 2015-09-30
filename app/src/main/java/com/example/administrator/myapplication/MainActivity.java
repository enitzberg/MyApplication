package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

//ALL IMAGES ARE TAKEN FROM GOOGLE.COM/IMAGES
//15 images total:
//              seven vegetables
//              seven fruit
//              one soccer field
//
//Reference log entries word document is included in the
//assignment2 zip file.

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    //initializing all instance variables.
    Button createTeam;
    Button AddPlayer;
    TextView iTeamName;
    TextView newTeamData;
    Spinner playerSpinner;
    Spinner teamSpinner;
    ArrayList<String> newTeam;
    ArrayList<String> newTeamName;
    Player[] players = new Player[12];
    HashMap<String, Team> teamHashMap;
    Team currentTeam;
    Player currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Each time player selects a pre-set team, the corresponding
        //activity will be reached.
        ImageButton Fruit = (ImageButton)findViewById(R.id.Fruit);
        Fruit.setBackgroundResource(R.mipmap.teamfruit);
        Fruit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2Activity.class));
            }
        });

        ImageButton Vegetable = (ImageButton)findViewById(R.id.Vegetable);
        Vegetable.setBackgroundResource(R.mipmap.teamvegetable);
        Vegetable.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity3Activity.class));
            }
        });

        //initializing the widgets on the current activity.
        newTeamData = (TextView)findViewById(R.id.newTeamData);
        teamHashMap = new HashMap<String, Team>();

        AddPlayer = (Button)findViewById(R.id.AddPlayer);
        AddPlayer.setOnClickListener(this);
        createTeam = (Button)findViewById(R.id.createTeam);
        createTeam.setOnClickListener(this);
        iTeamName = (EditText)findViewById(R.id.iTeamName);


        playerSpinner = (Spinner)findViewById(R.id.PlayerSpinner);
        teamSpinner = (Spinner)findViewById(R.id.teamSpinner);

        //Creating a list of player objects that will appear within the
        //players to add spinner as a user creates a new team.
        players[0] = new Player("Apple", "Red", 2, "Goalie", 1, "Minneapolis, MN");
        players[1] = new Player("Banana", "Yellow", 24, "Sweeper", 2, "Miami, FL");
        players[2] = new Player("Cherry", "Pink", 6, "Wing-Back", 0, "Isla Vista, CA");
        players[3] = new Player("Pear", "Green", 13, "Full-Back", 2, "Dallas, TX");
        players[4] = new Player("Straw", "Berry", 2, "Midfielder", 0, "Atlanta, Georgia");
        players[5] = new Player("Watermelon", "Delicious", 11, "Forward", 8, "Stanford, CA");
        players[6] = new Player("Tomato", "Sweet", 17, "Goalie", 0, "Charlott, NC");
        players[7] = new Player("Artichoke", "Buddy", 44, "Sweeper", 1, "Cambridge, MA");
        players[8] = new Player("Squash", "Jackson", 62, "Wing-Back", 4, "Tulsa, OK");
        players[9] = new Player("Carrot", "Top", 8, "Full-Back", 2, "Beaverton, OR");
        players[10] = new Player("Beat", "Em", 35, "Midfielder", 2, "New Orleans, LA");
        players[11] = new Player("Lettuce", "Beachu", 47, "Forward", 6, "Chicago, IL");

        //need to add the names of all players to the array list
        //that will appear on the screen when spinner is selected.
        newTeam = new ArrayList<>();
        newTeam.add(players[0].getFirstName()+" "+players[0].getLastName());
        newTeam.add(players[1].getFirstName()+" "+players[1].getLastName());
        newTeam.add(players[2].getFirstName() + " " + players[2].getLastName());
        newTeam.add(players[3].getFirstName()+" "+players[3].getLastName());
        newTeam.add(players[4].getFirstName()+" "+players[4].getLastName());
        newTeam.add(players[5].getFirstName()+" "+players[5].getLastName());
        newTeam.add(players[6].getFirstName()+" "+players[6].getLastName());
        newTeam.add(players[7].getFirstName()+" "+players[7].getLastName());
        newTeam.add(players[8].getFirstName()+" "+players[8].getLastName());
        newTeam.add(players[9].getFirstName()+" "+players[9].getLastName());
        newTeam.add(players[10].getFirstName()+" "+players[10].getLastName());
        newTeam.add(players[11].getFirstName()+" "+players[11].getLastName());

        newTeamName = new ArrayList<>();
        newTeamName.add("<Choose Team>");

        //need to create a new adapter for each spinner, with a corresponding onItemSelectedListener
        //that is unique to each inidvidual spinner.
        ArrayAdapter<String> playerAdap = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line, newTeam);
        playerSpinner.setAdapter(playerAdap);

        AdapterView.OnItemSelectedListener playerSpin = new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                currentPlayer = players[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        playerSpinner.setOnItemSelectedListener(playerSpin);

        //need to create a new adapter for each spinner, with a corresponding onItemSelectedListener
        //that is unique to each inidvidual spinner.
        ArrayAdapter<String> teamAdap = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line, newTeamName);
        teamSpinner.setAdapter(teamAdap);

        AdapterView.OnItemSelectedListener teamSpin = new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                currentTeam = teamHashMap.get(teamSpinner.getItemAtPosition(position).toString());

                if ( currentTeam != null ) {
                    newTeamData.setText(currentTeam.getPlayers());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        teamSpinner.setOnItemSelectedListener(teamSpin);
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

    @Override
    public void onClick(View v) {

        //Add a new team if the team name is one that is not already defined.
        if(v == createTeam)
        {

            Team teamTemp = new Team();
            teamTemp.teamName = iTeamName.getText().toString();

            if(!(teamHashMap.containsKey(teamTemp.teamName)))
            {
                teamHashMap.put(teamTemp.teamName, teamTemp);
                newTeamName.add(teamTemp.teamName);
            }
        }

        //Display the name of the players on the screen when a particular
        //team is chosen.
        if(v == AddPlayer)
        {
            currentTeam.addPlayer(currentPlayer);

            if ( currentTeam != null ) {
                newTeamData.setText("");
                newTeamData.setText(currentTeam.getPlayers());
            }

        }
    }
}
