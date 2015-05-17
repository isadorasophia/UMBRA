package com.umbra;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.umbra.manager.Selector;

public class Umbra extends ApplicationAdapter {
	Selector selector;

	@Override
	public void create () {
		selector = new Selector();
		selector.init();
	}

	@Override
	public void render () {
		selector.update(Gdx.graphics.getDeltaTime());
		selector.draw();
	}

	public void dispose (){
		selector.dispose();
	}
}
