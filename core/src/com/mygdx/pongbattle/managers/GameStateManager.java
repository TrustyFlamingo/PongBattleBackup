package com.mygdx.pongbattle.managers;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pongbattle.gamestates.*;

/**
 * Created by Joshua on 10/11/2015.
 */
public class GameStateManager {

    SpriteBatch sb;
    ShapeRenderer sr;

    GameState state;

    public final int TITLE = 0;
    public final int PLAY = 1;

    public GameStateManager() {
        sb = new SpriteBatch();
        sr = new ShapeRenderer();
        setState(PLAY);
    }

    public void setState(int newState) {
        if(state != null) state.dispose();
        if(newState == TITLE) {
            state = new TitleState(this);
        }
        if(newState == PLAY) {
            state = new PlayState(this);
        }
    }

    public void update(float dt) {
        state.update(dt);
    }

    public void draw() {
        state.draw(sb, sr);
    }

    public void handleInput() {
        state.handleInput();
    }

    public void resize(Vector2 size) {
        state.resize(size);
    }

    public void dispose() {
        state.dispose();
        sb.dispose();
        sr.dispose();
    }
}
