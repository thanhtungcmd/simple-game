package com.tungbt.goldminer.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tungbt.goldminer.actor.PlayButton;

public class PlayScreen implements Screen {

    SpriteBatch batch;
    Game game;
    OrthographicCamera camera;
    Stage stage;
    // Background
    Texture img;
    TextureRegion background;
    // Play Button
    PlayButton playButton;

    public PlayScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        // Global
        camera = new OrthographicCamera(1280, 720);
        batch = new SpriteBatch();
        stage = new Stage();
        // Background
        img = new Texture("images/menubg.png");
        img.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        background = new TextureRegion(img, img.getWidth()*5, img.getHeight()*3);
        // Play Button
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
        stage.dispose();
    }

}
