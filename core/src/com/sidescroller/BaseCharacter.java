package com.sidescroller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;


public class BaseCharacter extends Image{
	
	
	private int level = 1;
	private int maxHP = getLevel() * 10;
	private int healthAmount = maxHP;
	private int maxPOW = getLevel() * 5;
	private int powAmount = maxPOW;
	private int currentEXP = 0;
	private int maxEXP = getLevel() * 15;

	private final float defaultYvalue = 160;
	private float Gravity = 0;
	private int jumpCount = 0;
	private final int maxJumps = 2;
	private final int attackRange = 500;
	
	
	private static Array<BaseCharacter> characterList = new Array<BaseCharacter>();
	
	
	public BaseCharacter(Texture texture){
		super(texture);
	}
	
	@Override
	protected void setStage(Stage stage) {
		super.setStage(stage);
		
		if (stage != null) {
			characterList.add(this);
		} else {
			characterList.removeValue(this, true);
		}
	}

	public void attack(){
		
		float x1, x2;
		getScaleX();
		
		if(getScaleX() < 0){
			x1 = getX();
			x2 = x1 + attackRange;
		}
		else{
			x2 = getRight();
			x1 = x2 - attackRange;
		}
		
		Rectangle hitbox = Rectangle.tmp.set(x1, getY(), x2 - x1, getHeight());
		for (BaseCharacter ch : characterList) {
			if (ch == this) {
				continue;
			}
			if (hitbox.overlaps(Rectangle.tmp2.set(ch.getX(), ch.getY(), ch.getWidth(), ch.getHeight()))) {
				ch.Damage(3);
			}
		}
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public void setHealthAmount(int healthAmount) {
		this.healthAmount = healthAmount;
	}

	public void setMaxPOW(int maxPOW) {
		this.maxPOW = maxPOW;
	}

	public void setPowAmount(int powAmount) {
		this.powAmount = powAmount;
	}

	public void setCurrentEXP(int currentEXP) {
		this.currentEXP = currentEXP;
	}

	public void setMaxEXP(int maxEXP) {
		this.maxEXP = maxEXP;
	}

	public void setGravity(float gravity) {
		Gravity = gravity;
	}

	public void setJumpCount(int jumpCount) {
		this.jumpCount = jumpCount;
	}

	public static void setCharacterList(Array<BaseCharacter> characterList) {
		BaseCharacter.characterList = characterList;
	}

	public void jump(){
		if (getJumpCount() < getMaxJumps()){
		jumpCount++;
		Gravity = -7;
		}
	}
	
// Getters
	public int getLevel() {
		return level;
	}
	
	public int getMaxHP() {
		return maxHP;
	}


	public int getHealthAmount() {
		return healthAmount;
	}


	public int getMaxPOW() {
		return maxPOW;
	}


	public int getPowAmount() {
		return powAmount;
	}


	public int getCurrentEXP() {
		return currentEXP;
	}


	public int getMaxEXP() {
		return maxEXP;
	}


	public float getDefaultYvalue() {
		return defaultYvalue;
	}



	public float getGravity() {
		return Gravity;
	}



	public int getJumpCount() {
		return jumpCount;
	}



	public int getMaxJumps() {
		return maxJumps;
	}
	
	public void Damage(int amount){
		healthAmount -= amount;
	}

	public void Die(){
		healthAmount = 0;
		remove();
	}

	@Override
	public void act(float delta) {

		if(getHealthAmount() <= 0){
			
			Die();
		}
		
		
		
		moveBy(0, -Gravity);
		

		if (getY() > defaultYvalue){
			// AKA I luften
			Gravity += 0.3;
		}
		
		else{
			Gravity = 0;
			jumpCount = 0;
			setY(defaultYvalue);
		}
		super.act(delta);
	}
	
	
}