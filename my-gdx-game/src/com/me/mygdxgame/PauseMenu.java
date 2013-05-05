package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.mygdxgame.GameScreen.GameState;

public class PauseMenu extends MyScreen {
	private Texture pauseImage;
	TextureRegion frame;

	public PauseMenu(MyGdxGame g) {
		// super(g);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, RESW, RESH);
		spriteBatch = new SpriteBatch();
		game = g;
		pauseImage = new Texture(Gdx.files.internal("data/whitepaper.png"));
	}

	@Override
	public void render(float delta) {
		camera.update();

		spriteBatch.setProjectionMatrix(camera.combined);
		// spriteBatch.begin();
		// spriteBatch.draw(pauseImage, 0, 0);
		// spriteBatch.end();
		spriteBatch.begin();
		spriteBatch.draw(frame, 0, 0, RESW, RESH);
		spriteBatch.end();
		
		if (Gdx.input.isKeyPressed(Keys.ANY_KEY)) {
			//game.setScreen(game.getGameScreen());
		}

	}

	public void setFrame(TextureRegion f) {
		frame = f;
	}

	 @Override
	   public boolean keyDown(int keycode) {
	        if(keycode == Keys.BACK){
	        	game.setScreen(game.getGameScreen());
	        }
	        return false;
	   }

}
