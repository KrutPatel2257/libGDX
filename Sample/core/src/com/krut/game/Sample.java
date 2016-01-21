package com.krut.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.krut.game.parallax.ParallaxBackground;
import com.krut.game.parallax.ParallaxLayer;

public class Sample extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;
	ParallaxBackground rbg;
	private AssetManager assets;
	private Sprite sprite;
	private TextureAtlas atlas;

	@Override
	public void create () {
		batch = new SpriteBatch();
		assets = new AssetManager();
		assets.load("packedSamples.pack", TextureAtlas.class);
		assets.finishLoading();

		atlas = assets.get("packedSamples.pack");

		rbg = new ParallaxBackground(new ParallaxLayer[]{
				new ParallaxLayer(atlas.findRegion("sample1"),new Vector2(),new Vector2(0, 0)),
				new ParallaxLayer(atlas.findRegion("sample2"),new Vector2(1.0f,1.0f),new Vector2(0, 500)),
				new ParallaxLayer(atlas.findRegion("sample3"),new Vector2(0.1f,0),new Vector2(0,400-200),new Vector2(0, 0)),
		}, 800, 480,new Vector2(150,0));


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		rbg.render(Gdx.graphics.getDeltaTime());
		batch.end();
	}
}
