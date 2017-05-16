package com.sidescroller.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sidescroller.SideScroller;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//SpelRutan
		config.width = 800;
		config.height = 600;
		new LwjglApplication(new SideScroller(), config);
	}
}