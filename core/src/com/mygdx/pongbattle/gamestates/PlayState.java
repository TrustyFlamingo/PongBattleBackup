package com.mygdx.pongbattle.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pongbattle.Game;
import com.mygdx.pongbattle.MyCamera;
import com.mygdx.pongbattle.entities.Ball;
import com.mygdx.pongbattle.entities.Paddle;
import com.mygdx.pongbattle.entities.Player;
import com.mygdx.pongbattle.entities.Wall;
import com.mygdx.pongbattle.managers.GameStateManager;

public class PlayState extends GameState{

    private Ball b, b1, b2, b3, b4;
    private Paddle player, player2;
    private Wall w1, w2;
    private MyCamera cam;


    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        b = new Ball(Game.center, 25, 25, Ball.BOUNCE_ALL_SIDES);
        b1 = new Ball(Game.center, 25, 25, Ball.BOUNCE_ALL_SIDES);
        b2 = new Ball(Game.center, 25, 25, Ball.BOUNCE_ALL_SIDES);
        b3 = new Ball(Game.center, 25, 25, Ball.BOUNCE_ALL_SIDES);
        b4 = new Ball(Game.center, 25, 25, Ball.BOUNCE_ALL_SIDES);
        w1 = new Wall(Gdx.graphics.getWidth(), 25, 0, Wall.LEFT);
        w2 = new Wall(Gdx.graphics.getWidth(), 25, Game.size.y-25, Wall.RIGHT);

        player = new Player(25, 650, Paddle.LEFT);
        player2 = new Player(25, 650, Paddle.RIGHT);


        cam = new MyCamera(Game.size);
        cam.translate(Game.center);
        cam.update();
    }

    @Override
    public void update(float dt) {
       /* b.update();
        b1.update();
        b2.update();
        b3.update();
        b4.update();

        player.update();
        player2.update();

        b.collisions(w1);
        b1.collisions(w1);
        b2.collisions(w1);
        b3.collisions(w1);
        b4.collisions(w1);
        b.collisions(w2);
        b1.collisions(w2);
        b2.collisions(w2);
        b3.collisions(w2);
        b4.collisions(w2);

        b.collisions(player);
        b1.collisions(player);
        b2.collisions(player);
        b3.collisions(player);
        b4.collisions(player);

        b.collisions(player2);
        b1.collisions(player2);
        b2.collisions(player2);
        b3.collisions(player2);
        b4.collisions(player2);

        w1.update();
        w2.update();
        */
    }

    @Override
    public void draw(SpriteBatch sb, ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setProjectionMatrix(cam.combined);
        sr.setColor(Color.WHITE);
        b.draw(sr, sb);
        b1.draw(sr, sb);
        b2.draw(sr, sb);
        b3.draw(sr, sb);
        b4.draw(sr, sb);
        w1.draw(sr, sb);
        w2.draw(sr, sb);
        player.draw(sr, sb);
        player2.draw(sr, sb);
        sr.end();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void resize(Vector2 size) {
        cam.resize(size, true);
        b.setSpawn((new Vector2(size.x * .5f, size.y * .5f)));
        //w.resetX(w.getWidth());
        player.resetX(player.getWidth());
        player2.resetX(player.getWidth());
    }

    @Override
    public void dispose() {

    }
}
