package com.mygdx.pongbattle.gamestates;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pongbattle.Game;
import com.mygdx.pongbattle.MyCamera;
import com.mygdx.pongbattle.entities.Ball;
import com.mygdx.pongbattle.managers.GameStateManager;

/**
 * Created by Joshua on 10/11/2015.
 */
public class PlayState extends GameState{

    private Ball b;
    private MyCamera cam;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        b = new Ball(Game.center, 25, 25, Ball.BOUNCE_ALL_SIDES);
        cam = new MyCamera(Game.size);
        cam.translate(Game.center);
        cam.update();
    }

    @Override
    public void update(float dt) {
        b.update();
    }

    @Override
    public void draw(SpriteBatch sb, ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        //sr.setProjectionMatrix();
        sr.setColor(Color.WHITE);
        b.draw(sr, sb);
        sr.end();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void resize(Vector2 size) {
        cam.resize(size, true);
        b.setSpawn((new Vector2(size.x * .5f, size.y * .5f)));
    }

    @Override
    public void dispose() {

    }
}
