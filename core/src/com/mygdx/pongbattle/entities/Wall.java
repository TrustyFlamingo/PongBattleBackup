package com.mygdx.pongbattle.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.pongbattle.Game;


public class Wall extends Entity {

    protected int side;

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    public float x, y;

    public Wall(float width, float height, float Yaxis, int side) {
        this.side = side;
        x = 0;
        y = Yaxis;//Game.center.y - (height * .5f);
        bounds = new Rectangle(x, y, width, height);
        //resetX(width);
        init();
    }
    @Override
    protected void init() {

    }

    @Override
    public void draw(ShapeRenderer sr, SpriteBatch sb) {
        sr.rect(getX(), getY(), getWidth(), getHeight());
    }

    public void update(){
            bounds.x = x;
            bounds.y = y;
    }

    public int getSide(){
        return side;
    }

    public void resetX(float width) {
        if(this.side == Wall.LEFT) {
            bounds.x = (Game.size.x * .15f) - (width * .5f);
        }
        if(this.side == Wall.RIGHT) {
            bounds.x = (Game.size.x * .85f) - (width * .5f);
        }
    }
}
