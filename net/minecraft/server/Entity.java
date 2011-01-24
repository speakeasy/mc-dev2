package net.minecraft.server;

import java.util.List;
import java.util.Random;

public abstract class Entity {

    private static int a = 0;
    public int c;
    public double d;
    public boolean e;
    public Entity f;
    public Entity g;
    protected World h;
    public double i;
    public double j;
    public double k;
    public double l;
    public double m;
    public double n;
    public double o;
    public double p;
    public double q;
    public float r;
    public float s;
    public float t;
    public float u;
    public final AxisAlignedBB v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;
    public boolean A;
    public boolean B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    protected boolean H;
    protected float I;
    private int b;
    public double J;
    public double K;
    public double L;
    public float M;
    public float N;
    public boolean O;
    public float P;
    public boolean Q;
    protected Random R;
    public int S;
    public int T;
    public int U;
    protected int V;
    protected boolean W;
    public int X;
    public int Y;
    private boolean ad;
    private double ae;
    private double af;
    public boolean Z;
    public int aa;
    public int ab;
    public int ac;

    public Entity(World world) {
        this.c = a++;
        this.d = 1.0D;
        this.e = false;
        this.v = AxisAlignedBB.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        this.w = false;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = 0.0F;
        this.D = 0.6F;
        this.E = 1.8F;
        this.F = 0.0F;
        this.G = 0.0F;
        this.H = true;
        this.I = 0.0F;
        this.b = 1;
        this.M = 0.0F;
        this.N = 0.0F;
        this.O = false;
        this.P = 0.0F;
        this.Q = false;
        this.R = new Random();
        this.S = 0;
        this.T = 1;
        this.U = 0;
        this.V = 300;
        this.W = false;
        this.X = 0;
        this.Y = 300;
        this.ad = true;
        this.Z = false;
        this.h = world;
        this.a(0.0D, 0.0D, 0.0D);
    }

    public boolean equals(Object object) {
        return object instanceof Entity ? ((Entity) object).c == this.c : false;
    }

    public int hashCode() {
        return this.c;
    }

    public void j() {
        this.B = true;
    }

    protected void a(float f1, float f2) {
        this.D = f1;
        this.E = f2;
    }

    protected void b(float f1, float f2) {
        this.r = f1;
        this.s = f2;
    }

    public void a(double d1, double d2, double d3) {
        this.l = d1;
        this.m = d2;
        this.n = d3;
        float f1 = this.D / 2.0F;
        float f2 = this.E;

        this.v.c(d1 - (double) f1, d2 - (double) this.C + (double) this.M, d3 - (double) f1, d1 + (double) f1, d2 - (double) this.C + (double) this.M + (double) f2, d3 + (double) f1);
    }

    public void b_() {
        this.k();
    }

    public void k() {
        if (this.g != null && this.g.B) {
            this.g = null;
        }

        ++this.S;
        this.F = this.G;
        this.i = this.l;
        this.j = this.m;
        this.k = this.n;
        this.u = this.s;
        this.t = this.r;
        if (this.o()) {
            if (!this.W && !this.ad) {
                float f1 = MathHelper.a(this.o * this.o * 0.20000000298023224D + this.p * this.p + this.q * this.q * 0.20000000298023224D) * 0.2F;

                if (f1 > 1.0F) {
                    f1 = 1.0F;
                }

                this.h.a(this, "random.splash", f1, 1.0F + (this.R.nextFloat() - this.R.nextFloat()) * 0.4F);
                float f2 = (float) MathHelper.b(this.v.b);

                int i;
                float f3;
                float f4;

                for (i = 0; (float) i < 1.0F + this.D * 20.0F; ++i) {
                    f3 = (this.R.nextFloat() * 2.0F - 1.0F) * this.D;
                    f4 = (this.R.nextFloat() * 2.0F - 1.0F) * this.D;
                    this.h.a("bubble", this.l + (double) f3, (double) (f2 + 1.0F), this.n + (double) f4, this.o, this.p - (double) (this.R.nextFloat() * 0.2F), this.q);
                }

                for (i = 0; (float) i < 1.0F + this.D * 20.0F; ++i) {
                    f3 = (this.R.nextFloat() * 2.0F - 1.0F) * this.D;
                    f4 = (this.R.nextFloat() * 2.0F - 1.0F) * this.D;
                    this.h.a("splash", this.l + (double) f3, (double) (f2 + 1.0F), this.n + (double) f4, this.o, this.p, this.q);
                }
            }

            this.I = 0.0F;
            this.W = true;
            this.U = 0;
        } else {
            this.W = false;
        }

        if (this.U > 0) {
            if (this.U % 20 == 0) {
                this.a((Entity) null, 1);
            }

            --this.U;
        }

        if (this.q()) {
            this.a((Entity) null, 10);
            this.U = 600;
        }

        if (this.m < -64.0D) {
            this.l();
        }

        this.ad = false;
    }

    protected void l() {
        this.j();
    }

    public boolean b(double d1, double d2, double d3) {
        AxisAlignedBB axisalignedbb = this.v.c(d1, d2, d3);
        List list = this.h.a(this, axisalignedbb);

        return list.size() > 0 ? false : !this.h.b(axisalignedbb);
    }

    public void c(double d1, double d2, double d3) {
        if (this.O) {
            this.v.d(d1, d2, d3);
            this.l = (this.v.a + this.v.d) / 2.0D;
            this.m = this.v.b + (double) this.C - (double) this.M;
            this.n = (this.v.c + this.v.f) / 2.0D;
        } else {
            double d4 = this.l;
            double d5 = this.n;
            double d6 = d1;
            double d7 = d2;
            double d8 = d3;
            AxisAlignedBB axisalignedbb = this.v.b();
            boolean flag = this.w && this.m();

            if (flag) {
                double d9;

                for (d9 = 0.05D; d1 != 0.0D && this.h.a(this, this.v.c(d1, -1.0D, 0.0D)).size() == 0; d6 = d1) {
                    if (d1 < d9 && d1 >= -d9) {
                        d1 = 0.0D;
                    } else if (d1 > 0.0D) {
                        d1 -= d9;
                    } else {
                        d1 += d9;
                    }
                }

                for (; d3 != 0.0D && this.h.a(this, this.v.c(0.0D, -1.0D, d3)).size() == 0; d8 = d3) {
                    if (d3 < d9 && d3 >= -d9) {
                        d3 = 0.0D;
                    } else if (d3 > 0.0D) {
                        d3 -= d9;
                    } else {
                        d3 += d9;
                    }
                }
            }

            List list = this.h.a(this, this.v.a(d1, d2, d3));

            for (int i = 0; i < list.size(); ++i) {
                d2 = ((AxisAlignedBB) list.get(i)).b(this.v, d2);
            }

            this.v.d(0.0D, d2, 0.0D);
            if (!this.A && d7 != d2) {
                d3 = 0.0D;
                d2 = 0.0D;
                d1 = 0.0D;
            }

            boolean flag1 = this.w || d7 != d2 && d7 < 0.0D;

            int j;

            for (j = 0; j < list.size(); ++j) {
                d1 = ((AxisAlignedBB) list.get(j)).a(this.v, d1);
            }

            this.v.d(d1, 0.0D, 0.0D);
            if (!this.A && d6 != d1) {
                d3 = 0.0D;
                d2 = 0.0D;
                d1 = 0.0D;
            }

            for (j = 0; j < list.size(); ++j) {
                d3 = ((AxisAlignedBB) list.get(j)).c(this.v, d3);
            }

            this.v.d(0.0D, 0.0D, d3);
            if (!this.A && d8 != d3) {
                d3 = 0.0D;
                d2 = 0.0D;
                d1 = 0.0D;
            }

            double d10;
            double d11;
            int k;

            if (this.N > 0.0F && flag1 && this.M < 0.05F && (d6 != d1 || d8 != d3)) {
                d10 = d1;
                d11 = d2;
                double d12 = d3;

                d1 = d6;
                d2 = (double) this.N;
                d3 = d8;
                AxisAlignedBB axisalignedbb1 = this.v.b();

                this.v.b(axisalignedbb);
                list = this.h.a(this, this.v.a(d6, d2, d8));

                for (k = 0; k < list.size(); ++k) {
                    d2 = ((AxisAlignedBB) list.get(k)).b(this.v, d2);
                }

                this.v.d(0.0D, d2, 0.0D);
                if (!this.A && d7 != d2) {
                    d3 = 0.0D;
                    d2 = 0.0D;
                    d1 = 0.0D;
                }

                for (k = 0; k < list.size(); ++k) {
                    d1 = ((AxisAlignedBB) list.get(k)).a(this.v, d1);
                }

                this.v.d(d1, 0.0D, 0.0D);
                if (!this.A && d6 != d1) {
                    d3 = 0.0D;
                    d2 = 0.0D;
                    d1 = 0.0D;
                }

                for (k = 0; k < list.size(); ++k) {
                    d3 = ((AxisAlignedBB) list.get(k)).c(this.v, d3);
                }

                this.v.d(0.0D, 0.0D, d3);
                if (!this.A && d8 != d3) {
                    d3 = 0.0D;
                    d2 = 0.0D;
                    d1 = 0.0D;
                }

                if (d10 * d10 + d12 * d12 >= d1 * d1 + d3 * d3) {
                    d1 = d10;
                    d2 = d11;
                    d3 = d12;
                    this.v.b(axisalignedbb1);
                } else {
                    this.M = (float) ((double) this.M + 0.5D);
                }
            }

            this.l = (this.v.a + this.v.d) / 2.0D;
            this.m = this.v.b + (double) this.C - (double) this.M;
            this.n = (this.v.c + this.v.f) / 2.0D;
            this.x = d6 != d1 || d8 != d3;
            this.y = d7 != d2;
            this.w = d7 != d2 && d7 < 0.0D;
            this.z = this.x || this.y;
            if (this.w) {
                if (this.I > 0.0F) {
                    this.a(this.I);
                    this.I = 0.0F;
                }
            } else if (d2 < 0.0D) {
                this.I = (float) ((double) this.I - d2);
            }

            if (d6 != d1) {
                this.o = 0.0D;
            }

            if (d7 != d2) {
                this.p = 0.0D;
            }

            if (d8 != d3) {
                this.q = 0.0D;
            }

            d10 = this.l - d4;
            d11 = this.n - d5;
            this.G = (float) ((double) this.G + (double) MathHelper.a(d10 * d10 + d11 * d11) * 0.6D);
            int l;
            int i1;
            int j1;

            if (this.H && !flag) {
                l = MathHelper.b(this.l);
                i1 = MathHelper.b(this.m - 0.20000000298023224D - (double) this.C);
                j1 = MathHelper.b(this.n);
                k = this.h.a(l, i1, j1);
                if (this.G > (float) this.b && k > 0) {
                    ++this.b;
                    StepSound stepsound = Block.n[k].bl;

                    if (this.h.a(l, i1 + 1, j1) == Block.aT.bc) {
                        stepsound = Block.aT.bl;
                        this.h.a(this, stepsound.c(), stepsound.a() * 0.15F, stepsound.b());
                    } else if (!Block.n[k].bn.d()) {
                        this.h.a(this, stepsound.c(), stepsound.a() * 0.15F, stepsound.b());
                    }

                    Block.n[k].b(this.h, l, i1, j1, this);
                }
            }

            l = MathHelper.b(this.v.a);
            i1 = MathHelper.b(this.v.b);
            j1 = MathHelper.b(this.v.c);
            k = MathHelper.b(this.v.d);
            int k1 = MathHelper.b(this.v.e);
            int l1 = MathHelper.b(this.v.f);

            for (int i2 = l; i2 <= k; ++i2) {
                for (int j2 = i1; j2 <= k1; ++j2) {
                    for (int k2 = j1; k2 <= l1; ++k2) {
                        int l2 = this.h.a(i2, j2, k2);

                        if (l2 > 0) {
                            Block.n[l2].a(this.h, i2, j2, k2, this);
                        }
                    }
                }
            }

            this.M *= 0.4F;
            boolean flag2 = this.o();

            if (this.h.c(this.v)) {
                this.b(1);
                if (!flag2) {
                    ++this.U;
                    if (this.U == 0) {
                        this.U = 300;
                    }
                }
            } else if (this.U <= 0) {
                this.U = -this.T;
            }

            if (flag2 && this.U > 0) {
                this.h.a(this, "random.fizz", 0.7F, 1.6F + (this.R.nextFloat() - this.R.nextFloat()) * 0.4F);
                this.U = -this.T;
            }
        }
    }

    public boolean m() {
        return false;
    }

    public AxisAlignedBB n() {
        return null;
    }

    protected void b(int i) {
        this.a((Entity) null, i);
    }

    protected void a(float f1) {}

    public boolean o() {
        return this.h.a(this.v.b(0.0D, -0.4000000059604645D, 0.0D), Material.f, this);
    }

    public boolean a(Material material) {
        double d1 = this.m + (double) this.p();
        int i = MathHelper.b(this.l);
        int j = MathHelper.d((float) MathHelper.b(d1));
        int k = MathHelper.b(this.n);
        int l = this.h.a(i, j, k);

        if (l != 0 && Block.n[l].bn == material) {
            float f1 = BlockFluids.b(this.h.b(i, j, k)) - 0.11111111F;
            float f2 = (float) (j + 1) - f1;

            return d1 < (double) f2;
        } else {
            return false;
        }
    }

    protected float p() {
        return 0.0F;
    }

    public boolean q() {
        return this.h.a(this.v.b(0.0D, -0.4000000059604645D, 0.0D), Material.g);
    }

    public void a(float f1, float f2, float f3) {
        float f4 = MathHelper.c(f1 * f1 + f2 * f2);

        if (f4 >= 0.01F) {
            if (f4 < 1.0F) {
                f4 = 1.0F;
            }

            f4 = f3 / f4;
            f1 *= f4;
            f2 *= f4;
            float f5 = MathHelper.a(this.r * 3.1415927F / 180.0F);
            float f6 = MathHelper.b(this.r * 3.1415927F / 180.0F);

            this.o += (double) (f1 * f6 - f2 * f5);
            this.q += (double) (f2 * f6 + f1 * f5);
        }
    }

    public float b(float f1) {
        int i = MathHelper.b(this.l);
        double d1 = (this.v.e - this.v.b) * 0.66D;
        int j = MathHelper.b(this.m - (double) this.C + d1);
        int k = MathHelper.b(this.n);

        return this.h.j(i, j, k);
    }

    public void b(double d1, double d2, double d3, float f1, float f2) {
        this.i = this.l = d1;
        this.j = this.m = d2;
        this.k = this.n = d3;
        this.r = f1;
        this.s = f2;
        this.M = 0.0F;
        double d4 = (double) (this.t - f1);

        if (d4 < -180.0D) {
            this.t += 360.0F;
        }

        if (d4 >= 180.0D) {
            this.t -= 360.0F;
        }

        this.a(this.l, this.m, this.n);
    }

    public void c(double d1, double d2, double d3, float f1, float f2) {
        this.i = this.l = d1;
        this.j = this.m = d2 + (double) this.C;
        this.k = this.n = d3;
        this.r = f1;
        this.s = f2;
        this.a(this.l, this.m, this.n);
    }

    public float a(Entity entity) {
        float f1 = (float) (this.l - entity.l);
        float f2 = (float) (this.m - entity.m);
        float f3 = (float) (this.n - entity.n);

        return MathHelper.c(f1 * f1 + f2 * f2 + f3 * f3);
    }

    public double d(double d1, double d2, double d3) {
        double d4 = this.l - d1;
        double d5 = this.m - d2;
        double d6 = this.n - d3;

        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double e(double d1, double d2, double d3) {
        double d4 = this.l - d1;
        double d5 = this.m - d2;
        double d6 = this.n - d3;

        return (double) MathHelper.a(d4 * d4 + d5 * d5 + d6 * d6);
    }

    public double b(Entity entity) {
        double d1 = this.l - entity.l;
        double d2 = this.m - entity.m;
        double d3 = this.n - entity.n;

        return d1 * d1 + d2 * d2 + d3 * d3;
    }

    public void a(EntityPlayer entityplayer) {}

    public void c(Entity entity) {
        if (entity.f != this && entity.g != this) {
            double d1 = entity.l - this.l;
            double d2 = entity.n - this.n;
            double d3 = MathHelper.a(d1, d2);

            if (d3 >= 0.009999999776482582D) {
                d3 = (double) MathHelper.a(d3);
                d1 /= d3;
                d2 /= d3;
                double d4 = 1.0D / d3;

                if (d4 > 1.0D) {
                    d4 = 1.0D;
                }

                d1 *= d4;
                d2 *= d4;
                d1 *= 0.05000000074505806D;
                d2 *= 0.05000000074505806D;
                d1 *= (double) (1.0F - this.P);
                d2 *= (double) (1.0F - this.P);
                this.f(-d1, 0.0D, -d2);
                entity.f(d1, 0.0D, d2);
            }
        }
    }

    public void f(double d1, double d2, double d3) {
        this.o += d1;
        this.p += d2;
        this.q += d3;
    }

    public boolean a(Entity entity, int i) {
        return false;
    }

    public boolean c_() {
        return false;
    }

    public boolean r() {
        return false;
    }

    public void b(Entity entity, int i) {}

    public boolean c(NBTTagCompound nbttagcompound) {
        String s = this.s();

        if (!this.B && s != null) {
            nbttagcompound.a("id", s);
            this.d(nbttagcompound);
            return true;
        } else {
            return false;
        }
    }

    public void d(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Pos", (NBTBase) this.a(new double[] { this.l, this.m, this.n}));
        nbttagcompound.a("Motion", (NBTBase) this.a(new double[] { this.o, this.p, this.q}));
        nbttagcompound.a("Rotation", (NBTBase) this.a(new float[] { this.r, this.s}));
        nbttagcompound.a("FallDistance", this.I);
        nbttagcompound.a("Fire", (short) this.U);
        nbttagcompound.a("Air", (short) this.Y);
        nbttagcompound.a("OnGround", this.w);
        this.a(nbttagcompound);
    }

    public void e(NBTTagCompound nbttagcompound) {
        NBTTagList nbttaglist = nbttagcompound.k("Pos");
        NBTTagList nbttaglist1 = nbttagcompound.k("Motion");
        NBTTagList nbttaglist2 = nbttagcompound.k("Rotation");

        this.a(0.0D, 0.0D, 0.0D);
        this.o = ((NBTTagDouble) nbttaglist1.a(0)).a;
        this.p = ((NBTTagDouble) nbttaglist1.a(1)).a;
        this.q = ((NBTTagDouble) nbttaglist1.a(2)).a;
        this.i = this.J = this.l = ((NBTTagDouble) nbttaglist.a(0)).a;
        this.j = this.K = this.m = ((NBTTagDouble) nbttaglist.a(1)).a;
        this.k = this.L = this.n = ((NBTTagDouble) nbttaglist.a(2)).a;
        this.t = this.r = ((NBTTagFloat) nbttaglist2.a(0)).a;
        this.u = this.s = ((NBTTagFloat) nbttaglist2.a(1)).a;
        this.I = nbttagcompound.f("FallDistance");
        this.U = nbttagcompound.c("Fire");
        this.Y = nbttagcompound.c("Air");
        this.w = nbttagcompound.l("OnGround");
        this.a(this.l, this.m, this.n);
        this.b(nbttagcompound);
    }

    protected final String s() {
        return EntityList.b(this);
    }

    protected abstract void b(NBTTagCompound nbttagcompound);

    protected abstract void a(NBTTagCompound nbttagcompound);

    protected NBTTagList a(double... adouble) {
        NBTTagList nbttaglist = new NBTTagList();
        double[] adouble1 = adouble;
        int i = adouble.length;

        for (int j = 0; j < i; ++j) {
            double d1 = adouble1[j];

            nbttaglist.a((NBTBase) (new NBTTagDouble(d1)));
        }

        return nbttaglist;
    }

    protected NBTTagList a(float... afloat) {
        NBTTagList nbttaglist = new NBTTagList();
        float[] afloat1 = afloat;
        int i = afloat.length;

        for (int j = 0; j < i; ++j) {
            float f1 = afloat1[j];

            nbttaglist.a((NBTBase) (new NBTTagFloat(f1)));
        }

        return nbttaglist;
    }

    public EntityItem a(int i, int j) {
        return this.a(i, j, 0.0F);
    }

    public EntityItem a(int i, int j, float f1) {
        EntityItem entityitem = new EntityItem(this.h, this.l, this.m + (double) f1, this.n, new ItemStack(i, j));

        entityitem.ad = 10;
        this.h.a((Entity) entityitem);
        return entityitem;
    }

    public boolean t() {
        return !this.B;
    }

    public boolean u() {
        int i = MathHelper.b(this.l);
        int j = MathHelper.b(this.m + (double) this.p());
        int k = MathHelper.b(this.n);

        return this.h.d(i, j, k);
    }

    public AxisAlignedBB d(Entity entity) {
        return null;
    }

    public void v() {
        if (this.g.B) {
            this.g = null;
        } else {
            this.o = 0.0D;
            this.p = 0.0D;
            this.q = 0.0D;
            this.b_();
            this.g.w();
            this.af += (double) (this.g.r - this.g.t);

            for (this.ae += (double) (this.g.s - this.g.u); this.af >= 180.0D; this.af -= 360.0D) {
                ;
            }

            while (this.af < -180.0D) {
                this.af += 360.0D;
            }

            while (this.ae >= 180.0D) {
                this.ae -= 360.0D;
            }

            while (this.ae < -180.0D) {
                this.ae += 360.0D;
            }

            double d1 = this.af * 0.5D;
            double d2 = this.ae * 0.5D;
            float f1 = 10.0F;

            if (d1 > (double) f1) {
                d1 = (double) f1;
            }

            if (d1 < (double) (-f1)) {
                d1 = (double) (-f1);
            }

            if (d2 > (double) f1) {
                d2 = (double) f1;
            }

            if (d2 < (double) (-f1)) {
                d2 = (double) (-f1);
            }

            this.af -= d1;
            this.ae -= d2;
            this.r = (float) ((double) this.r + d1);
            this.s = (float) ((double) this.s + d2);
        }
    }

    protected void w() {
        this.f.a(this.l, this.m + this.h() + this.f.x(), this.n);
    }

    public double x() {
        return (double) this.C;
    }

    public double h() {
        return (double) this.E * 0.75D;
    }

    public void e(Entity entity) {
        this.ae = 0.0D;
        this.af = 0.0D;
        if (this.g == entity) {
            this.g.f = null;
            this.g = null;
            this.c(entity.l, entity.v.b + (double) entity.E, entity.n, this.r, this.s);
        } else {
            if (this.g != null) {
                this.g.f = null;
            }

            if (entity.f != null) {
                entity.f.g = null;
            }

            this.g = entity;
            entity.f = this;
        }
    }
}
