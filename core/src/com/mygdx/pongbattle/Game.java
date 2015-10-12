package com.mygdx.pongbattle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pongbattle.managers.*;


public class Game extends ApplicationAdapter implements InputProcessor{

	private GameStateManager gsm;

	public float time;
	public int frames, fps;
	public static Vector2 size, center;
	public static Content res;


	//private MyCamera camera;
	//private Ball ball;
	private SpriteBatch batch;//*
	private BitmapFont font;//*
	private GlyphLayout glyphLayout;//*
	private int screenWidth, screenHeight;//*
	private String message = "Touch me";//*

	@Override
	public void create () {
		this.batch = new SpriteBatch();//*
		this.glyphLayout = new GlyphLayout();//*

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		res = new Content();
		res.loadSound("sound", "ping_pong_8bit_beeep.ogg", "beep");
		res.loadSound("sound", "ping_pong_8bit_peeeeeep.ogg", "peep");
		res.loadSound("sound", "ping_pong_8bit_plop.ogg", "plop");


		font = new BitmapFont();//*
		font.setColor(Color.GREEN);//*
		font.getData().scale(5);//*

		size = new Vector2(screenWidth, screenHeight);
		center = new Vector2(screenWidth * .5f, screenHeight * .5f);
		gsm = new GameStateManager();
		Gdx.input.setInputProcessor(this);//*

		//camera = new MyCamera();
		//ball = new Ball(Game.center, 25, 25, Ball.BOUNCE_ALL_SIDES);

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		frames++;
		float dt = Gdx.graphics.getDeltaTime();
		glyphLayout.setText(font, message);//*

		batch.begin();//*
		font.draw(batch, glyphLayout, screenWidth / 2 - glyphLayout.width / 2, screenHeight / 2 + glyphLayout.height / 2);//*
		batch.end();//*

		gsm.handleInput();
		gsm.update(dt);
		gsm.draw();
		//camera.inView(screenWidth, screenHeight);
		//ball.update();

	}

	public void dispose(){
		res.removeAll();
		batch.dispose();//*
		font.dispose();//*
		gsm.dispose();
	}

	@Override
	public void resize(int width, int height) {
		Game.size.set(screenHeight, screenWidth);
		Game.center.set(screenWidth * .5f, screenHeight * .5f);
		gsm.resize(Game.size);
		//camera.resize(size, true);
		//ball.setSpawn(new Vector2(size.x * .5f, size.y * .5f));
	}
	//Inputs
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		message = "Touch down at " + screenX + ", " + screenY;
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		message = "Touch up at " + screenX + ", " + screenY;
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		message = "Dragging at " + screenX + ", " + screenY;
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
