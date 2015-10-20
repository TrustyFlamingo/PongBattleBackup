package com.mygdx.pongbattle.entities;

/*
 * Created by Joshua on 10/15/2015.
 */
public class Player extends Paddle{

    public Player(float width, float height, int side) {
        super(width, height, side);
    }

    @Override
    public void behave() {
        /*
        if(MyInput.isDown(MyInput.UP)) {
            yVel = 10;
        } else if(MyInput.isDown(MyInput.DOWN)) {
            yVel = -10;
        } else {
            yVel = 0;
        }
        */
    }
}
