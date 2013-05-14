package com.aaronclover.sketchescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class PauseMenu extends MyScreen {
	private Texture resumeButton;
	private Texture paper;
	final int RESUME_BUTTON_WIDTH = 120;
	final int RESUME_BUTTON_HEIGHT = 38;
	private Rectangle resumeBox;

	public PauseMenu(SketchEscape g) {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, RESW, RESH);
		spriteBatch = new SpriteBatch();
		game = g;
		paper = new Texture(Gdx.files.internal("data/whitepaper.png"));
		resumeButton = new Texture(Gdx.files.internal("data/resume.png"));
		pReleased = false;
		
		resumeBox = new Rectangle(camera.position.x - RESUME_BUTTON_WIDTH / 2,
				camera.position.y - RESUME_BUTTON_HEIGHT / 2, RESUME_BUTTON_WIDTH,
			RESUME_BUTTON_HEIGHT);
	}

	@Override
	public void render(float delta) {
		camera.update();
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		spriteBatch.draw(paper, 0, 0);
		spriteBatch.draw(resumeButton, resumeBox.x, resumeBox.y);
		spriteBatch.end();

		if (Gdx.input.isKeyPressed(Keys.P)) {
			if (pReleased == true) {
				pReleased = false;
				game.setScreen(game.getGameScreen());
			}
		} else {
			if (Gdx.input.isTouched()) {
				int touchX = getTouchX();
				int touchY = getTouchY();
				if (touchX >= resumeBox.x) {
					if (touchX <= resumeBox.x + resumeBox.width) {
						if (touchY >= resumeBox.y) {
							if (touchY <= RESH - resumeBox.y + resumeBox.height) {
								game.setScreen(game.getGameScreen());
							}
						}
					}
				}
			}
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.BACK) {
			game.setScreen(game.getGameScreen());
		}
		return false;
	}
}
