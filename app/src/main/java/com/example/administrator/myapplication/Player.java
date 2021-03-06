package com.example.administrator.myapplication;

/**
 * Created by nitzberg16 on 9/24/2015.
 */
public class Player {

    //initializing all assets of the player class.
    protected String firstName;
    protected String lastName;
    protected int uniformNumber;
    protected String position;
    protected int goalsScored;
    protected String hometown;

public Player (String firstname, String lastName, int uniformNumber, String position, int goalsScored, String hometown)
{
    //Setting all assets of the player class.
    this.firstName = firstname;
    this.lastName = lastName;
    this.uniformNumber = uniformNumber;
    this.position = position;
    this.goalsScored = goalsScored;
    this.hometown = hometown;

}

    //Get functions that allow for accessing the information for
    //each player
    public String getFirstName()
    {
        return firstName;

    }

    public String getLastName()
    {
        return lastName;

    }

    public int getUniformNumber()
    {
        return uniformNumber;

    }

    public String getPosition()
    {
        return position;

    }

    public int getGoalsScored()
    {
        return goalsScored;

    }

    public String getHometown()
    {
        return hometown;

    }
}
