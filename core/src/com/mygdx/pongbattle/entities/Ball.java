package com.mygdx.pongbattle.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pongbattle.Game;

/**
 * Created by Joshua on 10/11/2015.
 */
public class Ball extends Entity {

    private float speed, radians;
    private Vector2 velocity;
    private Vector2 spawn;

    public static final int BOUNCE_TOP_BOTTOM = 0;
    public static final int BOUNCE_ALL_SIDES = 1;

    private int bounceMode;

    public Ball(Vector2 position, float width, float height, int bounceMode) {
        bounds = new Rectangle(position.x, position.y, width, height);
        spawn = new Vector2(position);
        this.bounceMode = bounceMode;
        init();
    }

    public Ball(float x, float y, float width, float height, int bounceMode) {
        bounds = new Rectangle(x, y, width, height);
        spawn = new Vector2(x, y);
        this.bounceMode = bounceMode;
        init();
    }

    @Override
    protected void init() {
        velocity = new Vector2();
        reset();
    }

    @Override
    public void draw(ShapeRenderer sr, SpriteBatch sb) {
        sr.rect(getX(), getY(), getWidth(), getHeight());
    }

    public void update() {
        if(bounceMode == Ball.BOUNCE_ALL_SIDES) {
            bounceAllSides();
        }
        if(bounceMode == Ball.BOUNCE_TOP_BOTTOM) {
            bounceTopBottom();
        }
        bounds.x += velocity.x;
        bounds.y += velocity.y;
    }

    private void bounceAllSides() {
        if(getX() >= Game.size.x - getWidth()) {
            bounds.x--;
            bounceX();
        }
        if(getX() <= 0) {
            bounds.x++;
            bounceX();
        }
        if(getY() >= Game.size.y - getHeight()) {
            bounds.y--;
            bounceY();
        }
        if(getY() <= 0) {
            bounds.y++;
            bounceY();
        }

    }

    private void bounceTopBottom() {
        if (getX() >= Game.size.x - getWidth() + 50) {
            reset();
        }
        if (getX() <= -50) {
            reset();
        }
        if (getY() >= Game.size.y - getHeight()) {
            bounds.y--;
            bounceY();
        }
        if (getY() <= 0) {
            bounds.y++;
            bounceY();
        }
    }

    public void collisions() {

    }

    public void bounceX() {
        //Game.res.getSound("beep").play();
        velocity.x *= -1;
        if(velocity.x > 0) {
            velocity.x++;
        } else {
            velocity.x--;
        }
    }

    public void bounceY() {
       //Game.res.getSound("plop").play();
        velocity.y *= -1;
        if(velocity.y > 0) {
            velocity.y++;
        } else {
            velocity.y--;
        }
    }

    public void reset() {
        //Game.res.getSound("peep").play();
        speed = 10;
        do {
            radians = MathUtils.random(2 * MathUtils.PI);
        } while (Math.abs(MathUtils.cos(radians) * speed) < 1.5f);
        velocity.set(0, 0);
        bounds.x = spawn.x;
        bounds.y  = spawn.y;
        velocity.x = MathUtils.cos(radians) * speed;
        velocity.y = MathUtils.sin(radians) * speed;
    }

    public Vector2 getSpawn() {
        return spawn;
    }

    public void setSpawn(Vector2 spawn) {
        this.spawn = spawn;
    }




}
