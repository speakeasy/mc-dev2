package net.minecraft.server;

import java.util.List;

public class EntityEgg extends Entity {

    private int b = -1;
    private int c = -1;
    private int d = -1;
    private int e = 0;
    private boolean f = false;
    public int a = 0;
    private EntityLiving ak;
    private int al;
    private int am = 0;

    public EntityEgg(World world) {
        super(world);
        this.a(0.25F, 0.25F);
    }

    protected void a() {}

    public EntityEgg(World world, EntityLiving entityliving) {
        super(world);
        this.ak = entityliving;
        this.a(0.25F, 0.25F);
        this.c(entityliving.p, entityliving.q + (double) entityliving.w(), entityliving.r, entityliving.v, entityliving.w);
        this.p -= (double) (MathHelper.b(this.v / 180.0F * 3.1415927F) * 0.16F);
        this.q -= 0.10000000149011612D;
        this.r -= (double) (MathHelper.a(this.v / 180.0F * 3.1415927F) * 0.16F);
        this.a(this.p, this.q, this.r);
        this.H = 0.0F;
        float f1 = 0.4F;

        this.s = (double) (-MathHelper.a(this.v / 180.0F * 3.1415927F) * MathHelper.b(this.w / 180.0F * 3.1415927F) * f1);
        this.u = (double) (MathHelper.b(this.v / 180.0F * 3.1415927F) * MathHelper.b(this.w / 180.0F * 3.1415927F) * f1);
        this.t = (double) (-MathHelper.a(this.w / 180.0F * 3.1415927F) * f1);
        this.a(this.s, this.t, this.u, 1.5F, 1.0F);
    }

    public EntityEgg(World world, double d1, double d2, double d3) {
        super(world);
        this.al = 0;
        this.a(0.25F, 0.25F);
        this.a(d1, d2, d3);
        this.H = 0.0F;
    }

    public void a(double d1, double d2, double d3, float f1, float f2) {
        float f3 = MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);

        d1 /= (double) f3;
        d2 /= (double) f3;
        d3 /= (double) f3;
        d1 += this.W.nextGaussian() * 0.007499999832361937D * (double) f2;
        d2 += this.W.nextGaussian() * 0.007499999832361937D * (double) f2;
        d3 += this.W.nextGaussian() * 0.007499999832361937D * (double) f2;
        d1 *= (double) f1;
        d2 *= (double) f1;
        d3 *= (double) f1;
        this.s = d1;
        this.t = d2;
        this.u = d3;
        float f4 = MathHelper.a(d1 * d1 + d3 * d3);

        this.x = this.v = (float) (Math.atan2(d1, d3) * 180.0D / 3.1415927410125732D);
        this.y = this.w = (float) (Math.atan2(d2, (double) f4) * 180.0D / 3.1415927410125732D);
        this.al = 0;
    }

    public void b_() {
        this.O = this.p;
        this.P = this.q;
        this.Q = this.r;
        super.b_();
        if (this.a > 0) {
            --this.a;
        }

        if (this.f) {
            int i = this.l.a(this.b, this.c, this.d);

            if (i == this.e) {
                ++this.al;
                if (this.al == 1200) {
                    this.q();
                }

                return;
            }

            this.f = false;
            this.s *= (double) (this.W.nextFloat() * 0.2F);
            this.t *= (double) (this.W.nextFloat() * 0.2F);
            this.u *= (double) (this.W.nextFloat() * 0.2F);
            this.al = 0;
            this.am = 0;
        } else {
            ++this.am;
        }

        Vec3D vec3d = Vec3D.b(this.p, this.q, this.r);
        Vec3D vec3d1 = Vec3D.b(this.p + this.s, this.q + this.t, this.r + this.u);
        MovingObjectPosition movingobjectposition = this.l.a(vec3d, vec3d1);

        vec3d = Vec3D.b(this.p, this.q, this.r);
        vec3d1 = Vec3D.b(this.p + this.s, this.q + this.t, this.r + this.u);
        if (movingobjectposition != null) {
            vec3d1 = Vec3D.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
        }

        if (!this.l.z) {
            Entity entity = null;
            List list = this.l.b((Entity) this, this.z.a(this.s, this.t, this.u).b(1.0D, 1.0D, 1.0D));
            double d1 = 0.0D;

            for (int j = 0; j < list.size(); ++j) {
                Entity entity1 = (Entity) list.get(j);

                if (entity1.c_() && (entity1 != this.ak || this.am >= 5)) {
                    float f1 = 0.3F;
                    AxisAlignedBB axisalignedbb = entity1.z.b((double) f1, (double) f1, (double) f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb.a(vec3d, vec3d1);

                    if (movingobjectposition1 != null) {
                        double d2 = vec3d.a(movingobjectposition1.f);

                        if (d2 < d1 || d1 == 0.0D) {
                            entity = entity1;
                            d1 = d2;
                        }
                    }
                }
            }

            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }
        }

        if (movingobjectposition != null) {
            if (movingobjectposition.g != null && movingobjectposition.g.a(this.ak, 0)) {
                ;
            }

            if (!this.l.z && this.W.nextInt(8) == 0) {
                byte b1 = 1;

                if (this.W.nextInt(32) == 0) {
                    b1 = 4;
                }

                for (int k = 0; k < b1; ++k) {
                    EntityChicken entitychicken = new EntityChicken(this.l);

                    entitychicken.c(this.p, this.q, this.r, this.v, 0.0F);
                    this.l.a((Entity) entitychicken);
                }
            }

            for (int l = 0; l < 8; ++l) {
                this.l.a("snowballpoof", this.p, this.q, this.r, 0.0D, 0.0D, 0.0D);
            }

            this.q();
        }

        this.p += this.s;
        this.q += this.t;
        this.r += this.u;
        float f2 = MathHelper.a(this.s * this.s + this.u * this.u);

        this.v = (float) (Math.atan2(this.s, this.u) * 180.0D / 3.1415927410125732D);

        for (this.w = (float) (Math.atan2(this.t, (double) f2) * 180.0D / 3.1415927410125732D); this.w - this.y < -180.0F; this.y -= 360.0F) {
            ;
        }

        while (this.w - this.y >= 180.0F) {
            this.y += 360.0F;
        }

        while (this.v - this.x < -180.0F) {
            this.x -= 360.0F;
        }

        while (this.v - this.x >= 180.0F) {
            this.x += 360.0F;
        }

        this.w = this.y + (this.w - this.y) * 0.2F;
        this.v = this.x + (this.v - this.x) * 0.2F;
        float f3 = 0.99F;
        float f4 = 0.03F;

        if (this.v()) {
            for (int i1 = 0; i1 < 4; ++i1) {
                float f5 = 0.25F;

                this.l.a("bubble", this.p - this.s * (double) f5, this.q - this.t * (double) f5, this.r - this.u * (double) f5, this.s, this.t, this.u);
            }

            f3 = 0.8F;
        }

        this.s *= (double) f3;
        this.t *= (double) f3;
        this.u *= (double) f3;
        this.t -= (double) f4;
        this.a(this.p, this.q, this.r);
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("xTile", (short) this.b);
        nbttagcompound.a("yTile", (short) this.c);
        nbttagcompound.a("zTile", (short) this.d);
        nbttagcompound.a("inTile", (byte) this.e);
        nbttagcompound.a("shake", (byte) this.a);
        nbttagcompound.a("inGround", (byte) (this.f ? 1 : 0));
    }

    public void b(NBTTagCompound nbttagcompound) {
        this.b = nbttagcompound.c("xTile");
        this.c = nbttagcompound.c("yTile");
        this.d = nbttagcompound.c("zTile");
        this.e = nbttagcompound.b("inTile") & 255;
        this.a = nbttagcompound.b("shake") & 255;
        this.f = nbttagcompound.b("inGround") == 1;
    }

    public void b(EntityPlayer entityplayer) {
        if (this.f && this.ak == entityplayer && this.a <= 0 && entityplayer.an.a(new ItemStack(Item.j, 1))) {
            this.l.a(this, "random.pop", 0.2F, ((this.W.nextFloat() - this.W.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            entityplayer.c(this, 1);
            this.q();
        }
    }
}
