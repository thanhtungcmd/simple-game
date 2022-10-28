package com.tungbt.goldminer;

import com.badlogic.gdx.Game;
import com.tungbt.goldminer.screen.MainScreen;

public class Application extends Game {
	@Override
	public void create() {
		setScreen(new MainScreen(this));
	}
}
