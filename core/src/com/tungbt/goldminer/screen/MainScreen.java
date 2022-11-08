package com.tungbt.goldminer.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tungbt.goldminer.actor.PlayButton;

public class MainScreen implements Screen {

    Game game;
    OrthographicCamera camera;
    Stage stage;
    PlayButton[] test;

    public MainScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        // Global
        camera = new OrthographicCamera(1280, 720);
        stage = new Stage();

        // Play button
        test = new PlayButton[100];
        for(int i = 0; i < 10; i++) {
            test[i] = new PlayButton(this.game);
            stage.addActor(test[i]);
        }

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
        stage.dispose();
    }

}
