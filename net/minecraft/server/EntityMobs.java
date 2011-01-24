package net.minecraft.server;

public class EntityMobs extends EntityCreature implements IMobs {

    protected int e = 2;

    public EntityMobs(World world) {
        super(world);
        this.aP = 20;
    }

    public void D() {
        float f1 = this.b(1.0F);

        if (f1 > 0.5F) {
            this.bf += 2;
        }

        super.D();
    }

    public void b_() {
        super.b_();
        if (this.l.k == 0) {
            this.l();
        }
    }

    protected Entity k() {
        EntityPlayer entityplayer = this.l.a(this, 16.0D);

        return entityplayer != null && this.g(entityplayer) ? entityplayer : null;
    }

    public boolean a(Entity entity, int i) {
        if (super.a(entity, i)) {
            if (this.j != entity && this.k != entity) {
                if (entity != this) {
                    this.f = entity;
                }

                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    protected void a(Entity entity, float f1) {
        if ((double) f1 < 2.5D && entity.z.e > this.z.b && entity.z.b < this.z.e) {
            this.aV = 20;
            entity.a(this, this.e);
        }
    }

    protected float a(int i, int j, int k) {
        return 0.5F - this.l.j(i, j, k);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public boolean a() {
        int i = MathHelper.b(this.p);
        int j = MathHelper.b(this.z.b);
        int k = MathHelper.b(this.r);

        if (this.l.a(EnumSkyBlock.a, i, j, k) > this.V.nextInt(32)) {
            return false;
        } else {
            int l = this.l.h(i, j, k);

            return l <= this.V.nextInt(8) && super.a();
        }
    }
}
