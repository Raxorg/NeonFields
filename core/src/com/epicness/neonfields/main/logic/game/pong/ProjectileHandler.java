package com.epicness.neonfields.main.logic.game.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.neonfields.main.MainAssets;
import com.epicness.neonfields.main.logic.MainLogic;
import com.epicness.neonfields.main.stuff.MainStuff;
import com.epicness.neonfields.main.stuff.pong.Projectile;
import com.epicness.neonfields.main.stuff.pong.shapes.Shape;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.neonfields.main.MainConstants.PROJECTILE_GLOW_SIZE;
import static com.epicness.neonfields.main.MainConstants.PROJECTILE_SPEED;

public class ProjectileHandler {

    private MainAssets assets;
    private MainLogic logic;
    private MainStuff stuff;

    public void spawnProjectile(float x, float y, float movementAngle, Color color) {
        Projectile projectile = new Projectile(assets.getDot(), assets.getDotGlow());
        projectile.setPosition(x, y);
        projectile.setMovementAngle(movementAngle);
        projectile.setColor(color);
        stuff.getPongGame().getProjectiles().add(projectile);
    }

    public void update(float delta) {
        DelayedRemovalArray<Projectile> projectiles = stuff.getPongGame().getProjectiles();
        DelayedRemovalArray<Shape> shapes = stuff.getPongGame().getShapes();
        projectiles.begin();
        shapes.begin();
        for (int i = 0; i < projectiles.size; i++) {
            moveProjectile(projectiles.get(i), delta);
            checkProjectilePosition(projectiles.get(i), projectiles);
            if (checkProjectileCollision(projectiles.get(i), projectiles, shapes)) {
                break;
            }
        }
        shapes.end();
        projectiles.end();
    }

    private void moveProjectile(Projectile projectile, float delta) {
        Vector2 movementVector = new Vector2(1f, 1f).setAngleDeg(projectile.getMovementAngle());
        movementVector.x = movementVector.x * PROJECTILE_SPEED * delta;
        movementVector.y = movementVector.y * PROJECTILE_SPEED * delta;
        projectile.setPosition(projectile.getCenterX() + movementVector.x, projectile.getCenterY() + movementVector.y);
    }

    private void checkProjectilePosition(Projectile projectile, DelayedRemovalArray<Projectile> projectiles) {
        if (projectile.getCenterX() <= -PROJECTILE_GLOW_SIZE) {
            projectiles.removeValue(projectile, true);
        } else if (projectile.getCenterX() >= CAMERA_WIDTH + PROJECTILE_GLOW_SIZE) {
            projectiles.removeValue(projectile, true);
        } else if (projectile.getCenterY() <= -PROJECTILE_GLOW_SIZE) {
            projectiles.removeValue(projectile, true);
        } else if (projectile.getCenterY() >= CAMERA_HEIGHT + PROJECTILE_GLOW_SIZE) {
            projectiles.removeValue(projectile, true);
        }
    }

    private boolean checkProjectileCollision(Projectile projectile, DelayedRemovalArray<Projectile> projectiles,
                                             DelayedRemovalArray<Shape> shapes) {
        for (int i = 0; i < shapes.size; i++) {
            Shape shape = shapes.get(i);
            if (projectile.getBounds().overlaps(shape.getBounds())) {
                projectiles.removeValue(projectile, true);
                logic.getPongGameHandler().getExplosionHandler().explodeShape(shape, shapes);
                return true;
            }
        }
        return false;
    }

    // Structure
    public void setAssets(MainAssets assets) {
        this.assets = assets;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MainStuff stuff) {
        this.stuff = stuff;
    }
}