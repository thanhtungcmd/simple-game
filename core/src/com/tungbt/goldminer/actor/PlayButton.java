package com.tungbt.goldminer.actor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class PlayButton extends Actor {

    Sprite sprite = new Sprite(new Texture("images/play.png"));
    Game game;

    public PlayButton (final Game game) {
        Gdx.app.log("PlayButton X", String.valueOf(Gdx.graphics.getWidth()/2 - 25));
        Gdx.app.log("PlayButton X End", String.valueOf(Gdx.graphics.getWidth()/2 - 25 + 50));
        Gdx.app.log("PlayButton Y", String.valueOf(Gdx.graphics.getHeight()/2 - 25));
        Gdx.app.log("PlayButton Y End", String.valueOf(Gdx.graphics.getHeight()/2 - 25 + 50));
        this.game = game;
        setBounds((float) (Gdx.graphics.getWidth()/2 - 25),
                (float) (Gdx.graphics.getHeight()/2 - 25),
                50,
                50);
        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {
                    Gdx.app.log("Test", "OK");
                }
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(sprite,
                (float) (Gdx.graphics.getWidth()/2 - 25),
                (float) (Gdx.graphics.getHeight()/2 - 25),
                50,
                50);
    }

    public boolean checkClick(int screenX, int screenY) {
        if (Gdx.input.justTouched()) {
            boolean checkX = ((Gdx.graphics.getWidth() / 2 - 25) < screenX) && screenX < ((Gdx.graphics.getWidth() / 2 - 25 + 50));
            boolean checkY = ((Gdx.graphics.getHeight() / 2 - 25) < screenY) && screenY < ((Gdx.graphics.getHeight() / 2 - 25 + 50));
            if (checkX && checkY) {
                return true;
            }
        }
        return false;
    }

}
