package com.sidescroller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;

public class Player extends BaseCharacter{	
	/**
	 * Spelar Variabler eller något
	 */
	private Camera playerCamera;
	

	
	/**
	 * Spelar konstruktorn
	 */
	public Player(Camera playerCamera) {
		super(new Texture("PlayerSprite.png"));
		this.playerCamera = playerCamera;
		
		Player.this.setPosition(Gdx.graphics.getWidth()/2 - Player.this.getWidth()/2, getDefaultYvalue());
		setOrigin(Align.center);

	}
	



	@Override
	protected void positionChanged() {

		if((playerCamera.position.x = getX()) < playerCamera.viewportWidth/2){
			playerCamera.position.x = playerCamera.viewportWidth/2;
		}
		super.positionChanged();
	}
	
	   @Override
	public void Damage(int amount) {
		
		if (!hasActions()){
		   super.Damage(amount);
		   
		   addAction(Actions.repeat(3, Actions.sequence(Actions.alpha(0.5f, 0.2f), Actions.alpha(1, 0.2f))));
		}
		
	}
	   
	
	/**
	 * Actören gör sitt jobb :D
	 */
	@Override
	public void act(float delta) {
		
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			setScaleX(1);
			moveBy(10, 0);
		}
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			setScaleX(-1);
			moveBy(-10, 0);
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.ALT_LEFT)){
			super.jump();

		}
		if(Gdx.input.isKeyJustPressed(Keys.CONTROL_LEFT)){
			
			super.attack();
			
		}
		
		
		super.act(delta);
	}
	
	

}