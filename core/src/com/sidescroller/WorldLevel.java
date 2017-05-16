package com.sidescroller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class WorldLevel extends Actor{
	
	
	Sprite worldLevel = new Sprite(new Texture("world-level.png"));
	
		public WorldLevel() {
		setBounds(worldLevel.getX(), worldLevel.getY(), worldLevel.getWidth(), worldLevel.getHeight());
		setTouchable(Touchable.enabled);
		worldLevel.getTexture().setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(worldLevel.getTexture(), 0, 0, 0, 0, 990000, worldLevel.getTexture().getHeight());
	}

}