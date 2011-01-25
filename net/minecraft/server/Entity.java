package net.minecraft.server;

import java.util.List;
import java.util.Random;

public abstract class Entity {

    private static int a = 0;
    public int g;
    public double h;
    public boolean i;
    public Entity j;
    public Entity k;
    public World l;
    public double m;
    public double n;
    public double o;
    public double p;
    public double q;
    public double r;
    public double s;
    public double t;
    public double u;
    public float v;
    public float w;
    public float x;
    public float y;
    public final AxisAlignedBB z;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public float H;
    public float I;
    public float J;
    public float K;
    public float L;
    protected boolean M;
    protected float N;
    private int b;
    public double O;
    public double P;
    public double Q;
    public float R;
    public float S;
    public boolean T;
    public float U;
    public boolean V;
    protected Random W;
    public int X;
    public int Y;
    public int Z;
    protected int aa;
    protected boolean ab;
    public int ac;
    public int ad;
    private boolean c;
    protected boolean ae;
    protected DataWatcher af;
    private double d;
    private double e;
    public boolean ag;
    public int ah;
    public int ai;
    public int aj;

    public Entity(World world) {
        this.g = a++;
        this.h = 1.0D;
        this.i = false;
        this.z = AxisAlignedBB.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        this.A = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = 0.0F;
        this.I = 0.6F;
        this.J = 1.8F;
        this.K = 0.0F;
        this.L = 0.0F;
        this.M = true;
        this.N = 0.0F;
        this.b = 1;
        this.R = 0.0F;
        this.S = 0.0F;
        this.T = false;
        this.U = 0.0F;
        this.V = false;
        this.W = new Random();
        this.X = 0;
        this.Y = 1;
        this.Z = 0;
        this.aa = 300;
        this.ab = false;
        this.ac = 0;
        this.ad = 300;
        this.c = true;
        this.ae = false;
        this.af = new DataWatcher();
        this.ag = false;
        this.l = world;
        this.a(0.0D, 0.0D, 0.0D);
        this.af.a(0, Byte.valueOf((byte) 0));
        this.a();
    }

    protected abstract void a();

    public DataWatcher p() {
        return this.af;
    }

    public boolean equals(Object object) {
        return object instanceof Entity ? ((Entity) object).g == this.g : false;
    }

    public int hashCode() {
        return this.g;
    }

    public void q() {
        this.G = true;
    }

    protected void a(float f1, float f2) {
        this.I = f1;
        this.J = f2;
    }

    protected void b(float f1, float f2) {
        this.v = f1;
        this.w = f2;
    }

    public void a(double d1, double d2, double d3) {
        this.p = d1;
        this.q = d2;
        this.r = d3;
        float f1 = this.I / 2.0F;
        float f2 = this.J;

        this.z.c(d1 - (double) f1, d2 - (double) this.H + (double) this.R, d3 - (double) f1, d1 + (double) f1, d2 - (double) this.H + (double) this.R + (double) f2, d3 + (double) f1);
    }

    public void b_() {
        this.r();
    }

    public void r() {
        if (this.k != null && this.k.G) {
            this.k = null;
        }

        ++this.X;
        this.K = this.L;
        this.m = this.p;
        this.n = this.q;
        this.o = this.r;
        this.y = this.w;
        this.x = this.v;
        if (this.v()) {
            if (!this.ab && !this.c) {
                float f1 = MathHelper.a(this.s * this.s * 0.20000000298023224D + this.t * this.t + this.u * this.u * 0.20000000298023224D) * 0.2F;

                if (f1 > 1.0F) {
                    f1 = 1.0F;
                }

                this.l.a(this, "random.splash", f1, 1.0F + (this.W.nextFloat() - this.W.nextFloat()) * 0.4F);
                float f2 = (float) MathHelper.b(this.z.b);

                int i;
                float f3;
                float f4;

                for (i = 0; (float) i < 1.0F + this.I * 20.0F; ++i) {
                    f3 = (this.W.nextFloat() * 2.0F - 1.0F) * this.I;
                    f4 = (this.W.nextFloat() * 2.0F - 1.0F) * this.I;
                    this.l.a("bubble", this.p + (double) f3, (double) (f2 + 1.0F), this.r + (double) f4, this.s, this.t - (double) (this.W.nextFloat() * 0.2F), this.u);
                }

                for (i = 0; (float) i < 1.0F + this.I * 20.0F; ++i) {
                    f3 = (this.W.nextFloat() * 2.0F - 1.0F) * this.I;
                    f4 = (this.W.nextFloat() * 2.0F - 1.0F) * this.I;
                    this.l.a("splash", this.p + (double) f3, (double) (f2 + 1.0F), this.r + (double) f4, this.s, this.t, this.u);
                }
            }

            this.N = 0.0F;
            this.ab = true;
            this.Z = 0;
        } else {
            this.ab = false;
        }

        if (this.l.z) {
            this.Z = 0;
        } else if (this.Z > 0) {
            if (this.ae) {
                this.Z -= 4;
                if (this.Z < 0) {
                    this.Z = 0;
                }
            } else {
                if (this.Z % 20 == 0) {
                    this.a((Entity) null, 1);
                }

                --this.Z;
            }
        }

        if (this.x()) {
            this.s();
        }

        if (this.q < -64.0D) {
            this.t();
        }

        if (!this.l.z) {
            this.a(0, this.Z > 0);
            this.a(2, this.k != null);
        }

        this.c = false;
    }

    protected void s() {
        if (!this.ae) {
            this.a((Entity) null, 4);
            this.Z = 600;
        }
    }

    protected void t() {
        this.q();
    }

    public boolean b(double d1, double d2, double d3) {
        AxisAlignedBB axisalignedbb = this.z.c(d1, d2, d3);
        List list = this.l.a(this, axisalignedbb);

        return list.size() > 0 ? false : !this.l.b(axisalignedbb);
    }

    public void c(double d1, double d2, double d3) {
        if (this.T) {
            this.z.d(d1, d2, d3);
            this.p = (this.z.a + this.z.d) / 2.0D;
            this.q = this.z.b + (double) this.H - (double) this.R;
            this.r = (this.z.c + this.z.f) / 2.0D;
        } else {
            double d4 = this.p;
            double d5 = this.r;
            double d6 = d1;
            double d7 = d2;
            double d8 = d3;
            AxisAlignedBB axisalignedbb = this.z.b();
            boolean flag = this.A && this.J();

            if (flag) {
                double d9;

                for (d9 = 0.05D; d1 != 0.0D && this.l.a(this, this.z.c(d1, -1.0D, 0.0D)).size() == 0; d6 = d1) {
                    if (d1 < d9 && d1 >= -d9) {
                        d1 = 0.0D;
                    } else if (d1 > 0.0D) {
                        d1 -= d9;
                    } else {
                        d1 += d9;
                    }
                }

                for (; d3 != 0.0D && this.l.a(this, this.z.c(0.0D, -1.0D, d3)).size() == 0; d8 = d3) {
                    if (d3 < d9 && d3 >= -d9) {
                        d3 = 0.0D;
                    } else if (d3 > 0.0D) {
                        d3 -= d9;
                    } else {
                        d3 += d9;
                    }
                }
            }

            List list = this.l.a(this, this.z.a(d1, d2, d3));

            for (int i = 0; i < list.size(); ++i) {
                d2 = ((AxisAlignedBB) list.get(i)).b(this.z, d2);
            }

            this.z.d(0.0D, d2, 0.0D);
            if (!this.F && d7 != d2) {
                d3 = 0.0D;
                d2 = 0.0D;
                d1 = 0.0D;
            }

            boolean flag1 = this.A || d7 != d2 && d7 < 0.0D;

            int j;

            for (j = 0; j < list.size(); ++j) {
                d1 = ((AxisAlignedBB) list.get(j)).a(this.z, d1);
            }

            this.z.d(d1, 0.0D, 0.0D);
            if (!this.F && d6 != d1) {
                d3 = 0.0D;
                d2 = 0.0D;
                d1 = 0.0D;
            }

            for (j = 0; j < list.size(); ++j) {
                d3 = ((AxisAlignedBB) list.get(j)).c(this.z, d3);
            }

            this.z.d(0.0D, 0.0D, d3);
            if (!this.F && d8 != d3) {
                d3 = 0.0D;
                d2 = 0.0D;
                d1 = 0.0D;
            }

            double d10;
            double d11;
            int k;

            if (this.S > 0.0F && flag1 && this.R < 0.05F && (d6 != d1 || d8 != d3)) {
                d10 = d1;
                d11 = d2;
                double d12 = d3;

                d1 = d6;
                d2 = (double) this.S;
                d3 = d8;
                AxisAlignedBB axisalignedbb1 = this.z.b();

                this.z.b(axisalignedbb);
                list = this.l.a(this, this.z.a(d6, d2, d8));

                for (k = 0; k < list.size(); ++k) {
                    d2 = ((AxisAlignedBB) list.get(k)).b(this.z, d2);
                }

                this.z.d(0.0D, d2, 0.0D);
                if (!this.F && d7 != d2) {
                    d3 = 0.0D;
                    d2 = 0.0D;
                    d1 = 0.0D;
                }

                for (k = 0; k < list.size(); ++k) {
                    d1 = ((AxisAlignedBB) list.get(k)).a(this.z, d1);
                }

                this.z.d(d1, 0.0D, 0.0D);
                if (!this.F && d6 != d1) {
                    d3 = 0.0D;
                    d2 = 0.0D;
                    d1 = 0.0D;
                }

                for (k = 0; k < list.size(); ++k) {
                    d3 = ((AxisAlignedBB) list.get(k)).c(this.z, d3);
                }

                this.z.d(0.0D, 0.0D, d3);
                if (!this.F && d8 != d3) {
                    d3 = 0.0D;
                    d2 = 0.0D;
                    d1 = 0.0D;
                }

                if (d10 * d10 + d12 * d12 >= d1 * d1 + d3 * d3) {
                    d1 = d10;
                    d2 = d11;
                    d3 = d12;
                    this.z.b(axisalignedbb1);
                } else {
                    this.R = (float) ((double) this.R + 0.5D);
                }
            }

            this.p = (this.z.a + this.z.d) / 2.0D;
            this.q = this.z.b + (double) this.H - (double) this.R;
            this.r = (this.z.c + this.z.f) / 2.0D;
            this.B = d6 != d1 || d8 != d3;
            this.C = d7 != d2;
            this.A = d7 != d2 && d7 < 0.0D;
            this.D = this.B || this.C;
            this.a(d2, this.A);
            if (d6 != d1) {
                this.s = 0.0D;
            }

            if (d7 != d2) {
                this.t = 0.0D;
            }

            if (d8 != d3) {
                this.u = 0.0D;
            }

            d10 = this.p - d4;
            d11 = this.r - d5;
            int l;
            int i1;
            int j1;

            if (this.M && !flag) {
                this.L = (float) ((double) this.L + (double) MathHelper.a(d10 * d10 + d11 * d11) * 0.6D);
                l = MathHelper.b(this.p);
                i1 = MathHelper.b(this.q - 0.20000000298023224D - (double) this.H);
                j1 = MathHelper.b(this.r);
                k = this.l.a(l, i1, j1);
                if (this.L > (float) this.b && k > 0) {
                    ++this.b;
                    StepSound stepsound = Block.m[k].br;

                    if (this.l.a(l, i1 + 1, j1) == Block.SNOW.bi) {
                        stepsound = Block.SNOW.br;
                        this.l.a(this, stepsound.c(), stepsound.a() * 0.15F, stepsound.b());
                    } else if (!Block.m[k].bt.d()) {
                        this.l.a(this, stepsound.c(), stepsound.a() * 0.15F, stepsound.b());
                    }

                    Block.m[k].b(this.l, l, i1, j1, this);
                }
            }

            l = MathHelper.b(this.z.a);
            i1 = MathHelper.b(this.z.b);
            j1 = MathHelper.b(this.z.c);
            k = MathHelper.b(this.z.d);
            int k1 = MathHelper.b(this.z.e);
            int l1 = MathHelper.b(this.z.f);

            if (this.l.a(l, i1, j1, k, k1, l1)) {
                for (int i2 = l; i2 <= k; ++i2) {
                    for (int j2 = i1; j2 <= k1; ++j2) {
                        for (int k2 = j1; k2 <= l1; ++k2) {
                            int l2 = this.l.a(i2, j2, k2);

                            if (l2 > 0) {
                                Block.m[l2].a(this.l, i2, j2, k2, this);
                            }
                        }
                    }
                }
            }

            this.R *= 0.4F;
            boolean flag2 = this.v();

            if (this.l.c(this.z)) {
                this.b(1);
                if (!flag2) {
                    ++this.Z;
                    if (this.Z == 0) {
                        this.Z = 300;
                    }
                }
            } else if (this.Z <= 0) {
                this.Z = -this.Y;
            }

            if (flag2 && this.Z > 0) {
                this.l.a(this, "random.fizz", 0.7F, 1.6F + (this.W.nextFloat() - this.W.nextFloat()) * 0.4F);
                this.Z = -this.Y;
            }
        }
    }

    protected void a(double d1, boolean flag) {
        if (flag) {
            if (this.N > 0.0F) {
                this.a(this.N);
                this.N = 0.0F;
            }
        } else if (d1 < 0.0D) {
            this.N = (float) ((double) this.N - d1);
        }
    }

    public AxisAlignedBB u() {
        return null;
    }

    protected void b(int i) {
        if (!this.ae) {
            this.a((Entity) null, i);
        }
    }

    protected void a(float f1) {}

    public boolean v() {
        return this.l.a(this.z.b(0.0D, -0.4000000059604645D, 0.0D), Material.f, this);
    }

    public boolean a(Material material) {
        double d1 = this.q + (double) this.w();
        int i = MathHelper.b(this.p);
        int j = MathHelper.d((float) MathHelper.b(d1));
        int k = MathHelper.b(this.r);
        int l = this.l.a(i, j, k);

        if (l != 0 && Block.m[l].bt == material) {
            float f1 = BlockFluids.c(this.l.b(i, j, k)) - 0.11111111F;
            float f2 = (float) (j + 1) - f1;

            return d1 < (double) f2;
        } else {
            return false;
        }
    }

    public float w() {
        return 0.0F;
    }

    public boolean x() {
        return this.l.a(this.z.b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.g);
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
            float f5 = MathHelper.a(this.v * 3.1415927F / 180.0F);
            float f6 = MathHelper.b(this.v * 3.1415927F / 180.0F);

            this.s += (double) (f1 * f6 - f2 * f5);
            this.u += (double) (f2 * f6 + f1 * f5);
        }
    }

    public float b(float f1) {
        int i = MathHelper.b(this.p);
        double d1 = (this.z.e - this.z.b) * 0.66D;
        int j = MathHelper.b(this.q - (double) this.H + d1);
        int k = MathHelper.b(this.r);

        return this.l.a(MathHelper.b(this.z.a), MathHelper.b(this.z.b), MathHelper.b(this.z.c), MathHelper.b(this.z.d), MathHelper.b(this.z.e), MathHelper.b(this.z.f)) ? this.l.l(i, j, k) : 0.0F;
    }

    public void b(double d1, double d2, double d3, float f1, float f2) {
        this.m = this.p = d1;
        this.n = this.q = d2;
        this.o = this.r = d3;
        this.x = this.v = f1;
        this.y = this.w = f2;
        this.R = 0.0F;
        double d4 = (double) (this.x - f1);

        if (d4 < -180.0D) {
            this.x += 360.0F;
        }

        if (d4 >= 180.0D) {
            this.x -= 360.0F;
        }

        this.a(this.p, this.q, this.r);
        this.b(f1, f2);
    }

    public void c(double d1, double d2, double d3, float f1, float f2) {
        this.O = this.m = this.p = d1;
        this.P = this.n = this.q = d2 + (double) this.H;
        this.Q = this.o = this.r = d3;
        this.v = f1;
        this.w = f2;
        this.a(this.p, this.q, this.r);
    }

    public float a(Entity entity) {
        float f1 = (float) (this.p - entity.p);
        float f2 = (float) (this.q - entity.q);
        float f3 = (float) (this.r - entity.r);

        return MathHelper.c(f1 * f1 + f2 * f2 + f3 * f3);
    }

    public double d(double d1, double d2, double d3) {
        double d4 = this.p - d1;
        double d5 = this.q - d2;
        double d6 = this.r - d3;

        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double e(double d1, double d2, double d3) {
        double d4 = this.p - d1;
        double d5 = this.q - d2;
        double d6 = this.r - d3;

        return (double) MathHelper.a(d4 * d4 + d5 * d5 + d6 * d6);
    }

    public double b(Entity entity) {
        double d1 = this.p - entity.p;
        double d2 = this.q - entity.q;
        double d3 = this.r - entity.r;

        return d1 * d1 + d2 * d2 + d3 * d3;
    }

    public void b(EntityPlayer entityplayer) {}

    public void c(Entity entity) {
        if (entity.j != this && entity.k != this) {
            double d1 = entity.p - this.p;
            double d2 = entity.r - this.r;
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
                d1 *= (double) (1.0F - this.U);
                d2 *= (double) (1.0F - this.U);
                this.f(-d1, 0.0D, -d2);
                entity.f(d1, 0.0D, d2);
            }
        }
    }

    public void f(double d1, double d2, double d3) {
        this.s += d1;
        this.t += d2;
        this.u += d3;
    }

    protected void y() {
        this.E = true;
    }

    public boolean a(Entity entity, int i) {
        this.y();
        return false;
    }

    public boolean c_() {
        return false;
    }

    public boolean z() {
        return false;
    }

    public void b(Entity entity, int i) {}

    public boolean c(NBTTagCompound nbttagcompound) {
        String s = this.A();

        if (!this.G && s != null) {
            nbttagcompound.a("id", s);
            this.d(nbttagcompound);
            return true;
        } else {
            return false;
        }
    }

    public void d(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Pos", (NBTBase) this.a(new double[] { this.p, this.q, this.r}));
        nbttagcompound.a("Motion", (NBTBase) this.a(new double[] { this.s, this.t, this.u}));
        nbttagcompound.a("Rotation", (NBTBase) this.a(new float[] { this.v, this.w}));
        nbttagcompound.a("FallDistance", this.N);
        nbttagcompound.a("Fire", (short) this.Z);
        nbttagcompound.a("Air", (short) this.ad);
        nbttagcompound.a("OnGround", this.A);
        this.a(nbttagcompound);
    }

    public void e(NBTTagCompound nbttagcompound) {
        NBTTagList nbttaglist = nbttagcompound.k("Pos");
        NBTTagList nbttaglist1 = nbttagcompound.k("Motion");
        NBTTagList nbttaglist2 = nbttagcompound.k("Rotation");

        this.a(0.0D, 0.0D, 0.0D);
        this.s = ((NBTTagDouble) nbttaglist1.a(0)).a;
        this.t = ((NBTTagDouble) nbttaglist1.a(1)).a;
        this.u = ((NBTTagDouble) nbttaglist1.a(2)).a;
        this.m = this.O = this.p = ((NBTTagDouble) nbttaglist.a(0)).a;
        this.n = this.P = this.q = ((NBTTagDouble) nbttaglist.a(1)).a;
        this.o = this.Q = this.r = ((NBTTagDouble) nbttaglist.a(2)).a;
        this.x = this.v = ((NBTTagFloat) nbttaglist2.a(0)).a;
        this.y = this.w = ((NBTTagFloat) nbttaglist2.a(1)).a;
        this.N = nbttagcompound.f("FallDistance");
        this.Z = nbttagcompound.c("Fire");
        this.ad = nbttagcompound.c("Air");
        this.A = nbttagcompound.l("OnGround");
        this.a(this.p, this.q, this.r);
        this.b(nbttagcompound);
    }

    protected final String A() {
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
        return this.a(new ItemStack(i, j, 0), f1);
    }

    public EntityItem a(ItemStack itemstack, float f1) {
        EntityItem entityitem = new EntityItem(this.l, this.p, this.q + (double) f1, this.r, itemstack);

        entityitem.c = 10;
        this.l.a((Entity) entityitem);
        return entityitem;
    }

    public boolean B() {
        return !this.G;
    }

    public boolean C() {
        int i = MathHelper.b(this.p);
        int j = MathHelper.b(this.q + (double) this.w());
        int k = MathHelper.b(this.r);

        return this.l.d(i, j, k);
    }

    public boolean a(EntityPlayer entityplayer) {
        return false;
    }

    public AxisAlignedBB d(Entity entity) {
        return null;
    }

    public void D() {
        if (this.k.G) {
            this.k = null;
        } else {
            this.s = 0.0D;
            this.t = 0.0D;
            this.u = 0.0D;
            this.b_();
            this.k.E();
            this.e += (double) (this.k.v - this.k.x);

            for (this.d += (double) (this.k.w - this.k.y); this.e >= 180.0D; this.e -= 360.0D) {
                ;
            }

            while (this.e < -180.0D) {
                this.e += 360.0D;
            }

            while (this.d >= 180.0D) {
                this.d -= 360.0D;
            }

            while (this.d < -180.0D) {
                this.d += 360.0D;
            }

            double d1 = this.e * 0.5D;
            double d2 = this.d * 0.5D;
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

            this.e -= d1;
            this.d -= d2;
            this.v = (float) ((double) this.v + d1);
            this.w = (float) ((double) this.w + d2);
        }
    }

    public void E() {
        this.j.a(this.p, this.q + this.k() + this.j.F(), this.r);
    }

    public double F() {
        return (double) this.H;
    }

    public double k() {
        return (double) this.J * 0.75D;
    }

    public void e(Entity entity) {
        this.d = 0.0D;
        this.e = 0.0D;
        if (entity == null) {
            if (this.k != null) {
                this.c(this.k.p, this.k.z.b + (double) this.k.J, this.k.r, this.v, this.w);
                this.k.j = null;
            }

            this.k = null;
        } else if (this.k == entity) {
            this.k.j = null;
            this.k = null;
            this.c(entity.p, entity.z.b + (double) entity.J, entity.r, this.v, this.w);
        } else {
            if (this.k != null) {
                this.k.j = null;
            }

            if (entity.j != null) {
                entity.j.k = null;
            }

            this.k = entity;
            entity.j = this;
        }
    }

    public Vec3D G() {
        return null;
    }

    public void H() {}

    public ItemStack[] I() {
        return null;
    }

    public boolean J() {
        return this.c(1);
    }

    public void b(boolean flag) {
        this.a(1, flag);
    }

    protected boolean c(int i) {
        return (this.af.a(0) & 1 << i) != 0;
    }

    protected void a(int i, boolean flag) {
        byte b1 = this.af.a(0);

        if (flag) {
            this.af.b(0, Byte.valueOf((byte) (b1 | 1 << i)));
        } else {
            this.af.b(0, Byte.valueOf((byte) (b1 & ~(1 << i))));
        }
    }
}
