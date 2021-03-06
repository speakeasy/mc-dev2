package net.minecraft.server;

public abstract class EntityAnimals extends EntityCreature implements IAnimals {

    public EntityAnimals(World world) {
        super(world);
    }

    protected float a(int i, int j, int k) {
        return this.l.a(i, j - 1, k) == Block.GRASS.bi ? 10.0F : this.l.l(i, j, k) - 0.5F;
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public boolean b() {
        int i = MathHelper.b(this.p);
        int j = MathHelper.b(this.z.b);
        int k = MathHelper.b(this.r);

        return this.l.a(i, j - 1, k) == Block.GRASS.bi && this.l.j(i, j, k) > 8 && super.b();
    }

    public int c() {
        return 120;
    }
}
