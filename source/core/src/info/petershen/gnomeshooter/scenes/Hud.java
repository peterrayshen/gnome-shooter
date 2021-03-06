package info.petershen.gnomeshooter.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import info.petershen.gnomeshooter.screens.PlayScreen;

public class Hud implements Disposable {
	public Stage stage;
	private Viewport viewport;
	private Skin skin;
	Label scoreLabel;

	Label levelLabel, healthLabel, clipLabel, ammoLabel, cashLabel, roundLabel;
	ProgressBar healthBar;

	public TextureRegionDrawable pistol;
	public ImageButton button;
	private PlayScreen screen;
	private ProgressBar bar;

	public Hud(SpriteBatch sb, PlayScreen screen) {

		BitmapFont font = screen.game.assets.size20;
		BitmapFont fontbig = screen.game.assets.size27;
		

		this.screen = screen;

		skin = new Skin();

		Pixmap pixmap = new Pixmap(150, 30, Format.RGB888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();

		Pixmap pixmap1 = new Pixmap(150, 30, Format.RGB888);
		pixmap1.setColor(Color.RED);
		pixmap1.fill();

		skin.add("white", new Texture(pixmap));
		skin.add("red", new Texture(pixmap1));

		skin.add("default", font);

		ProgressBarStyle progressBarStyle = new ProgressBarStyle();

		progressBarStyle.background = skin.newDrawable("red");
		progressBarStyle.knobAfter = skin.newDrawable("white");
		bar = new ProgressBar(0, 100, 1, false, progressBarStyle);

		bar.setValue(screen.player.health);
		bar.setBounds(20, 415, 180, 30);

		viewport = new FitViewport(800, 480, new OrthographicCamera());
		stage = new Stage(viewport, sb);

		healthLabel = new Label("HEALTH", new Label.LabelStyle(font, Color.WHITE));
		healthLabel.setBounds(20, 450, 20, 20);

		clipLabel = new Label(Integer.toString(screen.currentWeapon.clip), new Label.LabelStyle(font, Color.WHITE));
		clipLabel.setBounds(700, 424, 10, 10);
		clipLabel.setAlignment(Align.right);

		ammoLabel = new Label(Integer.toString(screen.currentWeapon.ammo), new Label.LabelStyle(font, Color.DARK_GRAY));
		ammoLabel.setBounds(725, 424, 10, 10);
		ammoLabel.setAlignment(Align.left);

		cashLabel = new Label("$" + Integer.toString(screen.money), new Label.LabelStyle(fontbig, Color.GOLD));
		cashLabel.setBounds(755, 453, 10, 10);
		cashLabel.setAlignment(Align.right);

		roundLabel = new Label("round " + Integer.toString(screen.roundController.round),
				new Label.LabelStyle(font, Color.WHITE));
		roundLabel.setBounds(420, 450, 10, 10);
		roundLabel.setAlignment(Align.center);

		button = new ImageButton(pistol);

		stage.addActor(cashLabel);
		stage.addActor(clipLabel);
		stage.addActor(ammoLabel);
		stage.addActor(healthLabel);
		stage.addActor(bar);
		stage.addActor(roundLabel);

	}

	public void update(float delta) {
		bar.setValue(screen.player.health);
		ammoLabel.setText(Integer.toString(screen.currentWeapon.ammo));
		if (screen.currentWeapon.reloading)
			clipLabel.setText("reloading");
		else
			clipLabel.setText(Integer.toString(screen.currentWeapon.clip));
		cashLabel.setText(Integer.toString(screen.money));
		
		roundLabel.setText("Round " + Integer.toString(screen.roundController.round));

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();

	}

}
