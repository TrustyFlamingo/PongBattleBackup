package com.mygdx.pongbattle.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.pongbattle.Game;


public abstract class Paddle extends Entity {

    protected int side;

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    protected float yVel;

    public Paddle(float width, float height, int side) {
        float x, y;
        this.side = side;
        x = 0;
        y = Game.center.y - (height * .5f);
        yVel = 0;
        bounds = new Rectangle(x, y, width, height);
        resetX(width);
        init();
    }

    @Override
    protected void init() {}

    @Override
    public void draw(ShapeRenderer sr, SpriteBatch sb) {
        sr.rect(getX(), getY(), getWidth(), getHeight());
    }

    public void update() {
        behave();
        bounds.y += yVel;
        if(bounds.y > Game.size.y - bounds.height) {
            bounds.y = Game.size.y - bounds.height;
        }
        if(bounds.y < 0) {
            bounds.y = 0;
        }
    }

    public int getSide() {
        return side;
    }

    public abstract void behave();

    public void resetX(float width) {
        if(this.side == Paddle.LEFT) {
            bounds.x = (Game.size.x * .15f) - (width * .5f);
        }
        if(this.side == Paddle.RIGHT) {
            bounds.x = (Game.size.x * .85f) - (width * .5f);
        }
    }

}
