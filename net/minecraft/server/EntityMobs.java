package net.minecraft.server;

public class EntityMobs extends EntityCreature implements IMobs {

    protected int c = 2;

    public EntityMobs(World world) {
        super(world);
        this.aZ = 20;
    }

    public void o() {
        float f1 = this.b(1.0F);

        if (f1 > 0.5F) {
            this.bw += 2;
        }

        super.o();
    }

    public void b_() {
        super.b_();
        if (this.l.k == 0) {
            this.q();
        }
    }

    protected Entity l() {
        EntityPlayer entityplayer = this.l.a(this, 16.0D);

        return entityplayer != null && this.i(entityplayer) ? entityplayer : null;
    }

    public boolean a(Entity entity, int i) {
        if (super.a(entity, i)) {
            if (this.j != entity && this.k != entity) {
                if (entity != this) {
                    this.d = entity;
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
            this.bf = 20;
            entity.a(this, this.c);
        }
    }

    protected float a(int i, int j, int k) {
        return 0.5F - this.l.l(i, j, k);
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

        if (this.l.a(EnumSkyBlock.SKY, i, j, k) > this.W.nextInt(32)) {
            return false;
        } else {
            int l = this.l.j(i, j, k);

            return l <= this.W.nextInt(8) && super.b();
        }
    }
}
