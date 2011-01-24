package net.minecraft.server;

public class EntityZombie extends EntityMobs {

    public EntityZombie(World world) {
        super(world);
        this.aQ = "/mob/zombie.png";
        this.bD = 0.5F;
        this.f = 5;
    }

    public void G() {
        if (this.l.b()) {
            float f1 = this.b(1.0F);

            if (f1 > 0.5F && this.l.h(MathHelper.b(this.p), MathHelper.b(this.q), MathHelper.b(this.r)) && this.W.nextFloat() * 30.0F < (f1 - 0.4F) * 2.0F) {
                this.Z = 300;
            }
        }

        super.G();
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
