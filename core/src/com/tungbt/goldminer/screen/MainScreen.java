package com.tungbt.goldminer.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tungbt.goldminer.actor.PlayButton;

public class MainScreen implements Screen {

    SpriteBatch batch;
    Game game;
    OrthographicCamera camera;
    Stage stage;
    // Background
    Texture img;
    TextureRegion background;
    // Play Button
    PlayButton playButton;

    public MainScreen(Game game) {
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
        // Sprite playButton = new Sprite(new Texture("images/play.png"));
        playButton = new PlayButton(this.game);
        stage.addActor(playButton);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

        stage.act();
        this.updateButtonTouched();
        stage.draw();
    }

    public void updateButtonTouched(){
        if (playButton != null) {
            if (playButton.checkClick(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.app.log("Click X", String.valueOf(Gdx.input.getX()));
                Gdx.app.log("Click Y", String.valueOf(Gdx.input.getY()));
                game.setScreen(new PlayScreen(this.game));
            }
        }
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
