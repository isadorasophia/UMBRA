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
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		selector.update(Gdx.graphics.getDeltaTime());
		selector.draw();
	}

	public void dispose (){
		selector.dispose();
	}
}
