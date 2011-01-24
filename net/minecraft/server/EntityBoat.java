package net.minecraft.server;

import java.util.List;

public class EntityBoat extends Entity {

    public int a;
    public int b;
    public int c;
    private int d;
    private double e;
    private double f;
    private double aj;
    private double ak;
    private double al;

    public EntityBoat(World world) {
        super(world);
        this.a = 0;
        this.b = 0;
        this.c = 1;
        this.i = true;
        this.a(1.5F, 0.6F);
        this.H = this.J / 2.0F;
        this.M = false;
    }

    public AxisAlignedBB d(Entity entity) {
        return entity.z;
    }

    public AxisAlignedBB q() {
        return this.z;
    }

    public boolean v() {
        return true;
    }

    public EntityBoat(World world, double d1, double d2, double d3) {
        this(world);
        this.a(d1, d2 + (double) this.H, d3);
        this.s = 0.0D;
        this.t = 0.0D;
        this.u = 0.0D;
        this.m = d1;
        this.n = d2;
        this.o = d3;
    }

    public double j() {
        return (double) this.J * 0.0D - 0.30000001192092896D;
    }

    public boolean a(Entity entity, int i) {
        if (this.l.z) {
            return true;
        } else {
            this.c = -this.c;
            this.b = 10;
            this.a += i * 10;
            this.u();
            if (this.a > 40) {
                int j;

                for (j = 0; j < 3; ++j) {
                    this.a(Block.x.bh, 1, 0.0F);
                }

                for (j = 0; j < 2; ++j) {
                    this.a(Item.B.aW, 1, 0.0F);
                }

                this.l();
            }

            return true;
        }
    }

    public boolean c_() {
        return !this.G;
    }

    public void b_() {
        super.b_();
        if (this.b > 0) {
            --this.b;
        }

        if (this.a > 0) {
            --this.a;
        }

        this.m = this.p;
        this.n = this.q;
        this.o = this.r;
        byte b1 = 5;
        double d1 = 0.0D;

        for (int i = 0; i < b1; ++i) {
            double d2 = this.z.b + (this.z.e - this.z.b) * (double) (i + 0) / (double) b1 - 0.125D;
            double d3 = this.z.b + (this.z.e - this.z.b) * (double) (i + 1) / (double) b1 - 0.125D;
            AxisAlignedBB axisalignedbb = AxisAlignedBB.b(this.z.a, d2, this.z.c, this.z.d, d3, this.z.f);

            if (this.l.b(axisalignedbb, Material.f)) {
                d1 += 1.0D / (double) b1;
            }
        }

        double d4;
        double d5;
        double d6;
        double d7;

        if (this.l.z) {
            if (this.d > 0) {
                d4 = this.p + (this.e - this.p) / (double) this.d;
                d5 = this.q + (this.f - this.q) / (double) this.d;
                d6 = this.r + (this.aj - this.r) / (double) this.d;

                for (d7 = this.ak - (double) this.v; d7 < -180.0D; d7 += 360.0D) {
                    ;
                }

                while (d7 >= 180.0D) {
                    d7 -= 360.0D;
                }

                this.v = (float) ((double) this.v + d7 / (double) this.d);
                this.w = (float) ((double) this.w + (this.al - (double) this.w) / (double) this.d);
                --this.d;
                this.a(d4, d5, d6);
                this.b(this.v, this.w);
            } else {
                d4 = this.p + this.s;
                d5 = this.q + this.t;
                d6 = this.r + this.u;
                this.a(d4, d5, d6);
                if (this.A) {
                    this.s *= 0.5D;
                    this.t *= 0.5D;
                    this.u *= 0.5D;
                }

                this.s *= 0.9900000095367432D;
                this.t *= 0.949999988079071D;
                this.u *= 0.9900000095367432D;
            }
        } else {
            d4 = d1 * 2.0D - 1.0D;
            this.t += 0.03999999910593033D * d4;
            if (this.j != null) {
                this.s += this.j.s * 0.2D;
                this.u += this.j.u * 0.2D;
            }

            d5 = 0.4D;
            if (this.s < -d5) {
                this.s = -d5;
            }

            if (this.s > d5) {
                this.s = d5;
            }

            if (this.u < -d5) {
                this.u = -d5;
            }

            if (this.u > d5) {
                this.u = d5;
            }

            if (this.A) {
                this.s *= 0.5D;
                this.t *= 0.5D;
                this.u *= 0.5D;
            }

            this.c(this.s, this.t, this.u);
            d6 = Math.sqrt(this.s * this.s + this.u * this.u);
            double d8;

            if (d6 > 0.15D) {
                d7 = Math.cos((double) this.v * 3.141592653589793D / 180.0D);
                d8 = Math.sin((double) this.v * 3.141592653589793D / 180.0D);

                for (int j = 0; (double) j < 1.0D + d6 * 60.0D; ++j) {
                    double d9 = (double) (this.W.nextFloat() * 2.0F - 1.0F);
                    double d10 = (double) (this.W.nextInt(2) * 2 - 1) * 0.7D;
                    double d11;
                    double d12;

                    if (this.W.nextBoolean()) {
                        d11 = this.p - d7 * d9 * 0.8D + d8 * d10;
                        d12 = this.r - d8 * d9 * 0.8D - d7 * d10;
                        this.l.a("splash", d11, this.q - 0.125D, d12, this.s, this.t, this.u);
                    } else {
                        d11 = this.p + d7 + d8 * d9 * 0.7D;
                        d12 = this.r + d8 - d7 * d9 * 0.7D;
                        this.l.a("splash", d11, this.q - 0.125D, d12, this.s, this.t, this.u);
                    }
                }
            }

            if (this.B && d6 > 0.15D) {
                if (!this.l.z) {
                    this.l();

                    int k;

                    for (k = 0; k < 3; ++k) {
                        this.a(Block.x.bh, 1, 0.0F);
                    }

                    for (k = 0; k < 2; ++k) {
                        this.a(Item.B.aW, 1, 0.0F);
                    }
                }
            } else {
                this.s *= 0.9900000095367432D;
                this.t *= 0.949999988079071D;
                this.u *= 0.9900000095367432D;
            }

            this.w = 0.0F;
            d7 = (double) this.v;
            d8 = this.m - this.p;
            double d13 = this.o - this.r;

            if (d8 * d8 + d13 * d13 > 0.0010D) {
                d7 = (double) ((float) (Math.atan2(d13, d8) * 180.0D / 3.141592653589793D));
            }

            double d14;

            for (d14 = d7 - (double) this.v; d14 >= 180.0D; d14 -= 360.0D) {
                ;
            }

            while (d14 < -180.0D) {
                d14 += 360.0D;
            }

            if (d14 > 20.0D) {
                d14 = 20.0D;
            }

            if (d14 < -20.0D) {
                d14 = -20.0D;
            }

            this.v = (float) ((double) this.v + d14);
            this.b(this.v, this.w);
            List list = this.l.b((Entity) this, this.z.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

            if (list != null && list.size() > 0) {
                for (int l = 0; l < list.size(); ++l) {
                    Entity entity = (Entity) list.get(l);

                    if (entity != this.j && entity.v() && entity instanceof EntityBoat) {
                        entity.c((Entity) this);
                    }
                }
            }

            if (this.j != null && this.j.G) {
                this.j = null;
            }
        }
    }

    public void A() {
        if (this.j != null) {
            double d1 = Math.cos((double) this.v * 3.141592653589793D / 180.0D) * 0.4D;
            double d2 = Math.sin((double) this.v * 3.141592653589793D / 180.0D) * 0.4D;

            this.j.a(this.p + d1, this.q + this.j() + this.j.B(), this.r + d2);
        }
    }

    protected void a(NBTTagCompound nbttagcompound) {}

    protected void b(NBTTagCompound nbttagcompound) {}

    public boolean a(EntityPlayer entityplayer) {
        if (this.j != null && this.j instanceof EntityPlayer && this.j != entityplayer) {
            return true;
        } else {
            if (!this.l.z) {
                entityplayer.e(this);
            }

            return true;
        }
    }
}
