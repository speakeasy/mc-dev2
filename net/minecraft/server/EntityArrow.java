package net.minecraft.server;

import java.util.List;

public class EntityArrow extends Entity {

    private int c = -1;
    private int d = -1;
    private int e = -1;
    private int f = 0;
    private boolean aj = false;
    public int a = 0;
    public EntityLiving b;
    private int ak;
    private int al = 0;

    public EntityArrow(World world) {
        super(world);
        this.a(0.5F, 0.5F);
    }

    public EntityArrow(World world, EntityLiving entityliving) {
        super(world);
        this.b = entityliving;
        this.a(0.5F, 0.5F);
        this.c(entityliving.p, entityliving.q + (double) entityliving.s(), entityliving.r, entityliving.v, entityliving.w);
        this.p -= (double) (MathHelper.b(this.v / 180.0F * 3.1415927F) * 0.16F);
        this.q -= 0.10000000149011612D;
        this.r -= (double) (MathHelper.a(this.v / 180.0F * 3.1415927F) * 0.16F);
        this.a(this.p, this.q, this.r);
        this.H = 0.0F;
        this.s = (double) (-MathHelper.a(this.v / 180.0F * 3.1415927F) * MathHelper.b(this.w / 180.0F * 3.1415927F));
        this.u = (double) (MathHelper.b(this.v / 180.0F * 3.1415927F) * MathHelper.b(this.w / 180.0F * 3.1415927F));
        this.t = (double) (-MathHelper.a(this.w / 180.0F * 3.1415927F));
        this.a(this.s, this.t, this.u, 1.5F, 1.0F);
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
        this.ak = 0;
    }

    public void b_() {
        super.b_();
        if (this.y == 0.0F && this.x == 0.0F) {
            float f1 = MathHelper.a(this.s * this.s + this.u * this.u);

            this.x = this.v = (float) (Math.atan2(this.s, this.u) * 180.0D / 3.1415927410125732D);
            this.y = this.w = (float) (Math.atan2(this.t, (double) f1) * 180.0D / 3.1415927410125732D);
        }

        if (this.a > 0) {
            --this.a;
        }

        if (this.aj) {
            int i = this.l.a(this.c, this.d, this.e);

            if (i == this.f) {
                ++this.ak;
                if (this.ak == 1200) {
                    this.l();
                }

                return;
            }

            this.aj = false;
            this.s *= (double) (this.W.nextFloat() * 0.2F);
            this.t *= (double) (this.W.nextFloat() * 0.2F);
            this.u *= (double) (this.W.nextFloat() * 0.2F);
            this.ak = 0;
            this.al = 0;
        } else {
            ++this.al;
        }

        Vec3D vec3d = Vec3D.b(this.p, this.q, this.r);
        Vec3D vec3d1 = Vec3D.b(this.p + this.s, this.q + this.t, this.r + this.u);
        MovingObjectPosition movingobjectposition = this.l.a(vec3d, vec3d1);

        vec3d = Vec3D.b(this.p, this.q, this.r);
        vec3d1 = Vec3D.b(this.p + this.s, this.q + this.t, this.r + this.u);
        if (movingobjectposition != null) {
            vec3d1 = Vec3D.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
        }

        Entity entity = null;
        List list = this.l.b((Entity) this, this.z.a(this.s, this.t, this.u).b(1.0D, 1.0D, 1.0D));
        double d1 = 0.0D;

        float f2;

        for (int j = 0; j < list.size(); ++j) {
            Entity entity1 = (Entity) list.get(j);

            if (entity1.c_() && (entity1 != this.b || this.al >= 5)) {
                f2 = 0.3F;
                AxisAlignedBB axisalignedbb = entity1.z.b((double) f2, (double) f2, (double) f2);
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

        float f3;

        if (movingobjectposition != null) {
            if (movingobjectposition.g != null) {
                if (movingobjectposition.g.a(this.b, 4)) {
                    this.l.a(this, "random.drr", 1.0F, 1.2F / (this.W.nextFloat() * 0.2F + 0.9F));
                    this.l();
                } else {
                    this.s *= -0.10000000149011612D;
                    this.t *= -0.10000000149011612D;
                    this.u *= -0.10000000149011612D;
                    this.v += 180.0F;
                    this.x += 180.0F;
                    this.al = 0;
                }
            } else {
                this.c = movingobjectposition.b;
                this.d = movingobjectposition.c;
                this.e = movingobjectposition.d;
                this.f = this.l.a(this.c, this.d, this.e);
                this.s = (double) ((float) (movingobjectposition.f.a - this.p));
                this.t = (double) ((float) (movingobjectposition.f.b - this.q));
                this.u = (double) ((float) (movingobjectposition.f.c - this.r));
                f3 = MathHelper.a(this.s * this.s + this.t * this.t + this.u * this.u);
                this.p -= this.s / (double) f3 * 0.05000000074505806D;
                this.q -= this.t / (double) f3 * 0.05000000074505806D;
                this.r -= this.u / (double) f3 * 0.05000000074505806D;
                this.l.a(this, "random.drr", 1.0F, 1.2F / (this.W.nextFloat() * 0.2F + 0.9F));
                this.aj = true;
                this.a = 7;
            }
        }

        this.p += this.s;
        this.q += this.t;
        this.r += this.u;
        f3 = MathHelper.a(this.s * this.s + this.u * this.u);
        this.v = (float) (Math.atan2(this.s, this.u) * 180.0D / 3.1415927410125732D);

        for (this.w = (float) (Math.atan2(this.t, (double) f3) * 180.0D / 3.1415927410125732D); this.w - this.y < -180.0F; this.y -= 360.0F) {
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
        float f4 = 0.99F;

        f2 = 0.03F;
        if (this.r()) {
            for (int k = 0; k < 4; ++k) {
                float f5 = 0.25F;

                this.l.a("bubble", this.p - this.s * (double) f5, this.q - this.t * (double) f5, this.r - this.u * (double) f5, this.s, this.t, this.u);
            }

            f4 = 0.8F;
        }

        this.s *= (double) f4;
        this.t *= (double) f4;
        this.u *= (double) f4;
        this.t -= (double) f2;
        this.a(this.p, this.q, this.r);
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("xTile", (short) this.c);
        nbttagcompound.a("yTile", (short) this.d);
        nbttagcompound.a("zTile", (short) this.e);
        nbttagcompound.a("inTile", (byte) this.f);
        nbttagcompound.a("shake", (byte) this.a);
        nbttagcompound.a("inGround", (byte) (this.aj ? 1 : 0));
    }

    public void b(NBTTagCompound nbttagcompound) {
        this.c = nbttagcompound.c("xTile");
        this.d = nbttagcompound.c("yTile");
        this.e = nbttagcompound.c("zTile");
        this.f = nbttagcompound.b("inTile") & 255;
        this.a = nbttagcompound.b("shake") & 255;
        this.aj = nbttagcompound.b("inGround") == 1;
    }

    public void b(EntityPlayer entityplayer) {
        if (!this.l.z) {
            if (this.aj && this.b == entityplayer && this.a <= 0 && entityplayer.an.a(new ItemStack(Item.j.aW, 1))) {
                this.l.a(this, "random.pop", 0.2F, ((this.W.nextFloat() - this.W.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                entityplayer.c(this, 1);
                this.l();
            }
        }
    }
}
