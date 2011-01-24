package net.minecraft.server;

public class EntityZombieSimple extends EntityMobs {

    public EntityZombieSimple(World world) {
        super(world);
        this.aF = "/mob/zombie.png";
        this.br = 0.5F;
        this.e = 50;
        this.aP *= 10;
        this.G *= 6.0F;
        this.a(this.H * 6.0F, this.I * 6.0F);
    }

    protected float a(int i, int j, int k) {
        return this.l.j(i, j, k) - 0.5F;
    }
}
