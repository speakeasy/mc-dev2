package net.minecraft.server;

public class MobSpawnerHell extends MobSpawnerBase {

    public MobSpawnerHell() {
        this.r = new Class[] { EntityGhast.class, EntityPigZombie.class};
        this.s = new Class[0];
    }
}
