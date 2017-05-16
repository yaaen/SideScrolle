package com.sidescroller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Align;

/**
 * Fiende Sprite
 */

public class Enemy extends BaseCharacter {
	
	private Player player;
	private static int amountOfDeadEnemys = 0;
	
	public Enemy(Player player){
		super(new Texture("enemy.png"));
		this.player = player;
		setTouchable(Touchable.enabled);
		Enemy.this.setPosition(Gdx.graphics.getWidth()/2 - Enemy.this.getWidth()/2, getDefaultYvalue());
		setOrigin(Align.center);
		setPosition(player.getX() + 300, player.getY());
	}

	@Override
	protected void positionChanged() {
		super.positionChanged();
	}
	
	@Override
	public void Die() {
		if(this.remove()){
			amountOfDeadEnemys++;
			player.setCurrentEXP(amountOfDeadEnemys);
		}
		super.Die();
	}

	/**
	 * Fiende actören rör sig mot spelaren och sen skadar spelaren
	 */
	@Override
	public void act(float delta) {
		
		if(Math.abs(getX() - player.getX()) > 5){
			if(getX() < player.getX()){
				setScaleX(1);
				moveBy(3, 0);
			}
			else if(getX() > player.getX()){
				setScaleX(-1);
				moveBy(-3, 0);
			}
			else{
				setPosition(player.getX(), player.getY());
			}
		}
		if(getY() == player.getY() && getRight() > player.getX() && getX() < player.getRight()){
			attack();
		}

		super.act(delta);
	}
	


}