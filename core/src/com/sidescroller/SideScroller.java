package com.sidescroller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SideScroller extends ApplicationAdapter {
	
	//SpelVariabler, skapar "spelscenen"
	
	Stage stage;
	Stage inGameHud;
	Player player; 
	
	//"SpelSkapare"
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		
		
		WorldLevel worldLevel = new WorldLevel();
		stage.addActor(worldLevel);
		
		player = new Player(stage.getCamera());
		
		stage.setKeyboardFocus(player);

		Enemy enemy = new Enemy(player);
		stage.addActor(enemy);
		stage.addActor(player);
		
		
		inGameHud = new InGameHud(player);
		startloopSpawnEnemy();
	}
	
	private void spawnEnemy(){
		Enemy enemy = new Enemy(player);
		stage.addActor(enemy);
	}
	
	private void startloopSpawnEnemy(){
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				spawnEnemy();
			}
		}, 0, 5);
	}
	

	/**
	 * Updaterar varjer bild
	 */
	@Override
	public void render () {
		//OpenGls rensare
		Gdx.gl.glClearColor(0.25f, 0.25f, 0.75f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Allt som händer på scenen
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		inGameHud.act();
		inGameHud.draw();
	}
	/**
	 * Rensare
	 */
	@Override
	public void dispose () {
		stage.dispose();
	}
}