package com.sidescroller;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;


public class InGameHud extends Stage{
		
	ShapeRenderer shapes;
	Player player;
	
	Label healthLabel;
	Label powLabel;
	Label expLabel;
	Label LvLabel;
	
	public InGameHud(Player player) {
		this.player = player;
		shapes = new ShapeRenderer();
		LabelStyle style = new LabelStyle();
		style.font = new BitmapFont();
		healthLabel = new Label(null, style);
		powLabel = new Label(null, style);
		expLabel = new Label(null, style);
		LvLabel = new Label(null, style);
		
		addActor(healthLabel);
		addActor(powLabel);
		addActor(expLabel);
		addActor(LvLabel);

		healthLabel.setPosition(230, 60);
		powLabel.setPosition(550, 60);
		expLabel.setPosition(400, 20);
		LvLabel.setPosition(40, 30);
		LvLabel.setFontScale(3);
		
	}
	
	@Override
	public void act(float delta) {
		healthLabel.setText("Health: " + player.getHealthAmount());
		powLabel.setText("Power: " + player.getPowAmount());
		expLabel.setText("EXP: " + player.getCurrentEXP());
		LvLabel.setText("LV " + player.getLevel());
		super.act(delta);
	}


	public void drawBar(float x, float y, float width, float bgWidth, float height, Color color){
		shapes.setColor(Color.BLACK);
		shapes.rect(x, y, bgWidth, height);
		shapes.setColor(color);
		shapes.rect(x, y, width, height);
	}

	@Override
	public void draw() {
				
		shapes.begin(ShapeType.Filled);
		//Health bar
		drawBar(172, 50, 230 * ((float)player.getHealthAmount() / player.getMaxHP()), 230, 30, Color.RED);
		//"Power" Bar
		drawBar(472, 50, 230 * ((float)player.getPowAmount() / player.getMaxPOW()), 230, 30, Color.BLUE);
		//EXP bar
		drawBar(172, 10, 530 * ((float)player.getCurrentEXP() / player.getMaxEXP()), 530, 30, Color.LIME);
		//LVL ruta - aktuellt level
		shapes.setColor(Color.ORANGE);
		shapes.rect(32, 10, 120, 70);
		//Settings
		shapes.setColor(Color.CYAN);
		shapes.rect(720, 10, 70, 70);
		shapes.end();
		super.draw();
	}
	
	
}