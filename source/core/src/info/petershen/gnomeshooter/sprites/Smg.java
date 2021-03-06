package info.petershen.gnomeshooter.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;

import info.petershen.gnomeshooter.GnomeShooter;
import info.petershen.gnomeshooter.screens.PlayScreen;

public class Smg extends WeaponBase {

	public Smg(World world, PlayScreen screen) {

		super(world, screen);

		this.initAmmo = 120;
		this.initClip = 30;

		this.world = world;
		this.screen = screen;

		this.reloadSound = screen.game.assets.loadmed;

		this.originX = 2;
		this.originY = 3;
		this.posXOffset = 3;
		this.posYOffset = -14;
		this.gunWidth = 25;
		this.gunHeight = 23;
		this.fpRadius = (float) Math.sqrt(650);
		this.fpxright = 1;
		this.fpyright = 25;
		this.fpxleft = -12.5f;
		this.fpyleft = 25;
		this.fireRate = 950;
		this.clip = initClip;
		this.ammo = initAmmo;
		this.reloadTime = 1.7f;
		this.clipsize = 30;
		this.minDeviant = -5;
		this.maxDeviant = 5;

		this.region = screen.game.assets.smg;
		setRegion(region);
		this.bulletOffRight = -4;
		this.bulletOffLeft = 4;
		this.bulletSpeed = 40;
		this.bulletDamage = 12;
		this.bulletLife = 5;
		this.bulletHealth = 1;
		this.radius = 0;
		this.bulletWidth = 4;
		this.bulletHeight = 2.5f;
		this.b2radius = 0;
		this.b2width = 2.5f;
		this.b2height = 4;

		this.isAuto = true;

		this.muzzleHeight = 15;
		this.muzzleWidth = 15;
		this.muzzleFlash = screen.game.assets.muzzleFlash;

		this.flashYLeft = 2;
		this.flashXLeft = -2;

		this.flash = new MuzzleFlash(muzzleFlash, muzzleWidth, muzzleHeight);

		this.circleBullets = false;
		this.color = Color.DARK_GRAY;

		this.shotSound = screen.game.assets.smgShot;

		setBounds(screen.player.b2body.getWorldCenter().x + this.posXOffset / GnomeShooter.PPM,
				screen.player.b2body.getWorldCenter().y + this.posYOffset / GnomeShooter.PPM,
				gunWidth / GnomeShooter.PPM, gunHeight / GnomeShooter.PPM);

		setOrigin(
				(screen.arm.getX() * 150 + screen.arm.getOriginX() * 150 - this.getX() * 150) / GnomeShooter.PPM
						+ originX / GnomeShooter.PPM,
				(screen.arm.getY() * 150 + screen.arm.getOriginX() * 150 - this.getY() * 150) / GnomeShooter.PPM
						+ originY / GnomeShooter.PPM);

	}
}
