package com.mygdx.pongbattle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;


public class Game extends ApplicationAdapter implements InputProcessor{
	private SpriteBatch batch;
	private BitmapFont font;
	private GlyphLayout glyphLayout;
	private int screenWidth, screenHeight;
	private String message = "Touch me";

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.glyphLayout = new GlyphLayout();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		font = new BitmapFont();
		font.setColor(Color.GREEN);
		font.getData().scale(5);

		Gdx.input.setInputProcessor(this);


	}

	public void dispose(){
		batch.dispose();
		font.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		glyphLayout.setText(font, message);

		batch.begin();
		font.draw(batch, glyphLayout, screenWidth/2 - glyphLayout.width/2, screenHeight/2 + glyphLayout.height/2);
		batch.end();


	}

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
