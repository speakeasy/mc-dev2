package net.minecraft.server;

public class EntityZombie extends EntityMobs {

    public EntityZombie(World world) {
        super(world);
        this.aF = "/mob/zombie.png";
        this.br = 0.5F;
        this.e = 5;
    }

    public void D() {
        if (this.l.b()) {
            float f1 = this.b(1.0F);

            if (f1 > 0.5F && this.l.g(MathHelper.b(this.p), MathHelper.b(this.q), MathHelper.b(this.r)) && this.V.nextFloat() * 30.0F < (f1 - 0.4F) * 2.0F) {
                this.Y = 300;
            }
        }

        super.D();
    }

    protected String d() {
        return "mob.zombie";
    }

    protected String e() {
        return "mob.zombiehurt";
    }

    protected String f() {
        return "mob.zombiedeath";
    }

    protected int g() {
        return Item.J.aW;
    }
}
