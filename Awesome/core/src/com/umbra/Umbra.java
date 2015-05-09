package com.umbra;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.umbra.maneger.Selector;
import com.umbra.maneger.Vulto;

public class Umbra extends ApplicationAdapter {
	SpriteBatch batch;
	Selector selector;
	Vulto vulto;

	@Override
	public void create () {
		batch = new SpriteBatch();
		selector = new Selector();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		selector.update(Gdx.graphics.getDeltaTime());
		selector.draw();
	}
}
