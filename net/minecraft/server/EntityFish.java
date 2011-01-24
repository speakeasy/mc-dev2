package net.minecraft.server;

import java.util.List;

public class EntityFish extends Entity {

    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int aj = 0;
    private boolean ak = false;
    public int a = 0;
    public EntityPlayer b;
    private int al;
    private int am = 0;
    private int an = 0;
    public Entity c = null;
    private int ao;
    private double ap;
    private double aq;
    private double ar;
    private double as;
    private double at;

    public EntityFish(World world) {
        super(world);
        this.a(0.25F, 0.25F);
    }

    public EntityFish(World world, EntityPlayer entityplayer) {
        super(world);
        this.b = entityplayer;
        this.b.aE = this;
        this.a(0.25F, 0.25F);
        this.c(entityplayer.p, entityplayer.q + 1.62D - (double) entityplayer.H, entityplayer.r, entityplayer.v, entityplayer.w);
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
        super.b_();
        if (this.ao > 0) {
            double d1 = this.p + (this.ap - this.p) / (double) this.ao;
            double d2 = this.q + (this.aq - this.q) / (double) this.ao;
            double d3 = this.r + (this.ar - this.r) / (double) this.ao;

            double d4;

            for (d4 = this.as - (double) this.v; d4 < -180.0D; d4 += 360.0D) {
                ;
            }

            while (d4 >= 180.0D) {
                d4 -= 360.0D;
            }

            this.v = (float) ((double) this.v + d4 / (double) this.ao);
            this.w = (float) ((double) this.w + (this.at - (double) this.w) / (double) this.ao);
            --this.ao;
            this.a(d1, d2, d3);
            this.b(this.v, this.w);
        } else {
            if (!this.l.z) {
                ItemStack itemstack = this.b.M();

                if (this.b.G || !this.b.x() || itemstack == null || itemstack.a() != Item.aP || this.b(this.b) > 1024.0D) {
                    this.l();
                    this.b.aE = null;
                    return;
                }

                if (this.c != null) {
                    if (!this.c.G) {
                        this.p = this.c.p;
                        this.q = this.c.z.b + (double) this.c.J * 0.8D;
                        this.r = this.c.r;
                        return;
                    }

                    this.c = null;
                }
            }

            if (this.a > 0) {
                --this.a;
            }

            if (this.ak) {
                int i = this.l.a(this.d, this.e, this.f);

                if (i == this.aj) {
                    ++this.al;
                    if (this.al == 1200) {
                        this.l();
                    }

                    return;
                }

                this.ak = false;
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

            Entity entity = null;
            List list = this.l.b((Entity) this, this.z.a(this.s, this.t, this.u).b(1.0D, 1.0D, 1.0D));
            double d5 = 0.0D;

            double d6;

            for (int j = 0; j < list.size(); ++j) {
                Entity entity1 = (Entity) list.get(j);

                if (entity1.c_() && (entity1 != this.b || this.am >= 5)) {
                    float f1 = 0.3F;
                    AxisAlignedBB axisalignedbb = entity1.z.b((double) f1, (double) f1, (double) f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb.a(vec3d, vec3d1);

                    if (movingobjectposition1 != null) {
                        d6 = vec3d.a(movingobjectposition1.f);
                        if (d6 < d5 || d5 == 0.0D) {
                            entity = entity1;
                            d5 = d6;
                        }
                    }
                }
            }

            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }

            if (movingobjectposition != null) {
                if (movingobjectposition.g != null) {
                    if (movingobjectposition.g.a(this.b, 0)) {
                        this.c = movingobjectposition.g;
                    }
                } else {
                    this.ak = true;
                }
            }

            if (!this.ak) {
                this.c(this.s, this.t, this.u);
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
                float f3 = 0.92F;

                if (this.A || this.B) {
                    f3 = 0.5F;
                }

                byte b1 = 5;
                double d7 = 0.0D;

                for (int k = 0; k < b1; ++k) {
                    double d8 = this.z.b + (this.z.e - this.z.b) * (double) (k + 0) / (double) b1 - 0.125D + 0.125D;
                    double d9 = this.z.b + (this.z.e - this.z.b) * (double) (k + 1) / (double) b1 - 0.125D + 0.125D;
                    AxisAlignedBB axisalignedbb1 = AxisAlignedBB.b(this.z.a, d8, this.z.c, this.z.d, d9, this.z.f);

                    if (this.l.b(axisalignedbb1, Material.f)) {
                        d7 += 1.0D / (double) b1;
                    }
                }

                if (d7 > 0.0D) {
                    if (this.an > 0) {
                        --this.an;
                    } else if (this.W.nextInt(500) == 0) {
                        this.an = this.W.nextInt(30) + 10;
                        this.t -= 0.20000000298023224D;
                        this.l.a(this, "random.splash", 0.25F, 1.0F + (this.W.nextFloat() - this.W.nextFloat()) * 0.4F);
                        float f4 = (float) MathHelper.b(this.z.b);

                        int l;
                        float f5;
                        float f6;

                        for (l = 0; (float) l < 1.0F + this.I * 20.0F; ++l) {
                            f5 = (this.W.nextFloat() * 2.0F - 1.0F) * this.I;
                            f6 = (this.W.nextFloat() * 2.0F - 1.0F) * this.I;
                            this.l.a("bubble", this.p + (double) f5, (double) (f4 + 1.0F), this.r + (double) f6, this.s, this.t - (double) (this.W.nextFloat() * 0.2F), this.u);
                        }

                        for (l = 0; (float) l < 1.0F + this.I * 20.0F; ++l) {
                            f5 = (this.W.nextFloat() * 2.0F - 1.0F) * this.I;
                            f6 = (this.W.nextFloat() * 2.0F - 1.0F) * this.I;
                            this.l.a("splash", this.p + (double) f5, (double) (f4 + 1.0F), this.r + (double) f6, this.s, this.t, this.u);
                        }
                    }
                }

                if (this.an > 0) {
                    this.t -= (double) (this.W.nextFloat() * this.W.nextFloat() * this.W.nextFloat()) * 0.2D;
                }

                d6 = d7 * 2.0D - 1.0D;
                this.t += 0.03999999910593033D * d6;
                if (d7 > 0.0D) {
                    f3 = (float) ((double) f3 * 0.9D);
                    this.t *= 0.8D;
                }

                this.s *= (double) f3;
                this.t *= (double) f3;
                this.u *= (double) f3;
                this.a(this.p, this.q, this.r);
            }
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("xTile", (short) this.d);
        nbttagcompound.a("yTile", (short) this.e);
        nbttagcompound.a("zTile", (short) this.f);
        nbttagcompound.a("inTile", (byte) this.aj);
        nbttagcompound.a("shake", (byte) this.a);
        nbttagcompound.a("inGround", (byte) (this.ak ? 1 : 0));
    }

    public void b(NBTTagCompound nbttagcompound) {
        this.d = nbttagcompound.c("xTile");
        this.e = nbttagcompound.c("yTile");
        this.f = nbttagcompound.c("zTile");
        this.aj = nbttagcompound.b("inTile") & 255;
        this.a = nbttagcompound.b("shake") & 255;
        this.ak = nbttagcompound.b("inGround") == 1;
    }

    public int c() {
        byte b1 = 0;

        if (this.c != null) {
            double d1 = this.b.p - this.p;
            double d2 = this.b.q - this.q;
            double d3 = this.b.r - this.r;
            double d4 = (double) MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);
            double d5 = 0.1D;

            this.c.s += d1 * d5;
            this.c.t += d2 * d5 + (double) MathHelper.a(d4) * 0.08D;
            this.c.u += d3 * d5;
            b1 = 3;
        } else if (this.an > 0) {
            EntityItem entityitem = new EntityItem(this.l, this.p, this.q, this.r, new ItemStack(Item.aS.aW));
            double d6 = this.b.p - this.p;
            double d7 = this.b.q - this.q;
            double d8 = this.b.r - this.r;
            double d9 = (double) MathHelper.a(d6 * d6 + d7 * d7 + d8 * d8);
            double d10 = 0.1D;

            entityitem.s = d6 * d10;
            entityitem.t = d7 * d10 + (double) MathHelper.a(d9) * 0.08D;
            entityitem.u = d8 * d10;
            this.l.a((Entity) entityitem);
            b1 = 1;
        }

        if (this.ak) {
            b1 = 2;
        }

        this.l();
        this.b.aE = null;
        return b1;
    }
}
