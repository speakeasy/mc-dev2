package net.minecraft.server;

import java.util.List;

public class EntityLiving extends Entity {

    public int ar = 20;
    public float as;
    public float at;
    public float au;
    public float av = 0.0F;
    public float aw = 0.0F;
    protected float ax;
    protected float ay;
    protected float az;
    protected float aA;
    protected boolean aB = true;
    protected String aC = "/char.png";
    protected boolean aD = true;
    protected float aE = 0.0F;
    protected String aF = null;
    protected float aG = 1.0F;
    protected int aH = 0;
    protected float aI = 0.0F;
    public boolean aJ = false;
    public float aK;
    public float aL;
    public int aM = 10;
    public int aN;
    private int a;
    public int aO;
    public int aP;
    public float aQ = 0.0F;
    public int aR = 0;
    public int aS = 0;
    public float aT;
    public float aU;
    protected boolean aV = false;
    public int aW = -1;
    public float aX = (float) (Math.random() * 0.8999999761581421D + 0.10000000149011612D);
    public float aY;
    public float aZ;
    public float ba;
    private int b;
    private double ad;
    private double ae;
    private double af;
    private double ag;
    private double ah;
    float bb = 0.0F;
    protected int bc = 0;
    protected float bd;
    protected float be;
    protected float bf;
    protected boolean bg = false;
    protected float bh = 0.0F;
    protected float bi = 0.7F;
    private Entity ai;
    private int aj = 0;

    public EntityLiving(World world) {
        super(world);
        this.e = true;
        this.au = (float) (Math.random() + 1.0D) * 0.01F;
        this.a(this.l, this.m, this.n);
        this.as = (float) Math.random() * 12398.0F;
        this.r = (float) (Math.random() * 3.1415927410125732D * 2.0D);
        this.at = 1.0F;
        this.N = 0.5F;
    }

    protected boolean g(Entity entity) {
        return this.h.a(Vec3D.b(this.l, this.m + (double) this.p(), this.n), Vec3D.b(entity.l, entity.m + (double) entity.p(), entity.n)) == null;
    }

    public boolean c_() {
        return !this.B;
    }

    public boolean r() {
        return !this.B;
    }

    protected float p() {
        return this.E * 0.85F;
    }

    public int b() {
        return 80;
    }

    public void k() {
        this.aK = this.aL;
        super.k();
        if (this.R.nextInt(1000) < this.a++) {
            this.a = -this.b();
            String s = this.c();

            if (s != null) {
                this.h.a(this, s, this.f(), (this.R.nextFloat() - this.R.nextFloat()) * 0.2F + 1.0F);
            }
        }

        if (this.t() && this.u()) {
            this.a((Entity) null, 1);
        }

        int i;

        if (this.t() && this.a(Material.f)) {
            --this.Y;
            if (this.Y == -20) {
                this.Y = 0;

                for (i = 0; i < 8; ++i) {
                    float f1 = this.R.nextFloat() - this.R.nextFloat();
                    float f2 = this.R.nextFloat() - this.R.nextFloat();
                    float f3 = this.R.nextFloat() - this.R.nextFloat();

                    this.h.a("bubble", this.l + (double) f1, this.m + (double) f2, this.n + (double) f3, this.o, this.p, this.q);
                }

                this.a((Entity) null, 2);
            }

            this.U = 0;
        } else {
            this.Y = this.V;
        }

        this.aT = this.aU;
        if (this.aS > 0) {
            --this.aS;
        }

        if (this.aO > 0) {
            --this.aO;
        }

        if (this.X > 0) {
            --this.X;
        }

        if (this.aM <= 0) {
            ++this.aR;
            if (this.aR > 20) {
                this.G();
                this.j();

                for (i = 0; i < 20; ++i) {
                    double d1 = this.R.nextGaussian() * 0.02D;
                    double d2 = this.R.nextGaussian() * 0.02D;
                    double d3 = this.R.nextGaussian() * 0.02D;

                    this.h.a("explode", this.l + (double) (this.R.nextFloat() * this.D * 2.0F) - (double) this.D, this.m + (double) (this.R.nextFloat() * this.E), this.n + (double) (this.R.nextFloat() * this.D * 2.0F) - (double) this.D, d1, d2, d3);
                }
            }
        }

        this.aA = this.az;
        this.aw = this.av;
        this.t = this.r;
        this.u = this.s;
    }

    public void D() {
        for (int i = 0; i < 20; ++i) {
            double d1 = this.R.nextGaussian() * 0.02D;
            double d2 = this.R.nextGaussian() * 0.02D;
            double d3 = this.R.nextGaussian() * 0.02D;
            double d4 = 10.0D;

            this.h.a("explode", this.l + (double) (this.R.nextFloat() * this.D * 2.0F) - (double) this.D - d1 * d4, this.m + (double) (this.R.nextFloat() * this.E) - d2 * d4, this.n + (double) (this.R.nextFloat() * this.D * 2.0F) - (double) this.D - d3 * d4, d1, d2, d3);
        }
    }

    public void v() {
        super.v();
        this.ax = this.ay;
        this.ay = 0.0F;
    }

    public void b_() {
        super.b_();
        this.y();
        double d1 = this.l - this.i;
        double d2 = this.n - this.k;
        float f1 = MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = this.av;
        float f3 = 0.0F;

        this.ax = this.ay;
        float f4 = 0.0F;

        if (f1 > 0.05F) {
            f4 = 1.0F;
            f3 = f1 * 3.0F;
            f2 = (float) Math.atan2(d2, d1) * 180.0F / 3.1415927F - 90.0F;
        }

        if (this.aL > 0.0F) {
            f2 = this.r;
        }

        if (!this.w) {
            f4 = 0.0F;
        }

        this.ay += (f4 - this.ay) * 0.3F;

        float f5;

        for (f5 = f2 - this.av; f5 < -180.0F; f5 += 360.0F) {
            ;
        }

        while (f5 >= 180.0F) {
            f5 -= 360.0F;
        }

        this.av += f5 * 0.3F;

        float f6;

        for (f6 = this.r - this.av; f6 < -180.0F; f6 += 360.0F) {
            ;
        }

        while (f6 >= 180.0F) {
            f6 -= 360.0F;
        }

        boolean flag = f6 < -90.0F || f6 >= 90.0F;

        if (f6 < -75.0F) {
            f6 = -75.0F;
        }

        if (f6 >= 75.0F) {
            f6 = 75.0F;
        }

        this.av = this.r - f6;
        if (f6 * f6 > 2500.0F) {
            this.av += f6 * 0.2F;
        }

        if (flag) {
            f3 *= -1.0F;
        }

        while (this.r - this.t < -180.0F) {
            this.t -= 360.0F;
        }

        while (this.r - this.t >= 180.0F) {
            this.t += 360.0F;
        }

        while (this.av - this.aw < -180.0F) {
            this.aw -= 360.0F;
        }

        while (this.av - this.aw >= 180.0F) {
            this.aw += 360.0F;
        }

        while (this.s - this.u < -180.0F) {
            this.u -= 360.0F;
        }

        while (this.s - this.u >= 180.0F) {
            this.u += 360.0F;
        }

        this.az += f3;
    }

    protected void a(float f1, float f2) {
        super.a(f1, f2);
    }

    public void a(int i) {
        if (this.aM > 0) {
            this.aM += i;
            if (this.aM > 20) {
                this.aM = 20;
            }

            this.X = this.ar / 2;
        }
    }

    public boolean a(Entity entity, int i) {
        if (this.h.x) {
            i = 0;
        }

        this.bc = 0;
        if (this.aM <= 0) {
            return false;
        } else {
            this.aZ = 1.5F;
            if ((float) this.X > (float) this.ar / 2.0F) {
                if (this.aN - i >= this.aM) {
                    return false;
                }

                this.aM = this.aN - i;
            } else {
                this.aN = this.aM;
                this.X = this.ar;
                this.aM -= i;
                this.aO = this.aP = 10;
            }

            this.aQ = 0.0F;
            if (entity != null) {
                double d1 = entity.l - this.l;

                double d2;

                for (d2 = entity.n - this.n; d1 * d1 + d2 * d2 < 1.0E-4D; d2 = (Math.random() - Math.random()) * 0.01D) {
                    d1 = (Math.random() - Math.random()) * 0.01D;
                }

                this.aQ = (float) (Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - this.r;
                this.a(entity, i, d1, d2);
            } else {
                this.aQ = (float) ((int) (Math.random() * 2.0D) * 180);
            }

            if (this.aM <= 0) {
                this.h.a(this, this.e(), this.f(), (this.R.nextFloat() - this.R.nextFloat()) * 0.2F + 1.0F);
                this.f(entity);
            } else {
                this.h.a(this, this.d(), this.f(), (this.R.nextFloat() - this.R.nextFloat()) * 0.2F + 1.0F);
            }

            return true;
        }
    }

    protected float f() {
        return 1.0F;
    }

    protected String c() {
        return null;
    }

    protected String d() {
        return "random.hurt";
    }

    protected String e() {
        return "random.hurt";
    }

    public void a(Entity entity, int i, double d1, double d2) {
        float f1 = MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = 0.4F;

        this.o /= 2.0D;
        this.p /= 2.0D;
        this.q /= 2.0D;
        this.o -= d1 / (double) f1 * (double) f2;
        this.p += 0.4000000059604645D;
        this.q -= d2 / (double) f1 * (double) f2;
        if (this.p > 0.4000000059604645D) {
            this.p = 0.4000000059604645D;
        }
    }

    public void f(Entity entity) {
        if (this.aH > 0 && entity != null) {
            entity.b(this, this.aH);
        }

        this.aV = true;
        int i = this.g();

        if (i > 0) {
            int j = this.R.nextInt(3);

            for (int k = 0; k < j; ++k) {
                this.a(i, 1);
            }
        }
    }

    protected int g() {
        return 0;
    }

    protected void a(float f1) {
        int i = (int) Math.ceil((double) (f1 - 3.0F));

        if (i > 0) {
            this.a((Entity) null, i);
            int j = this.h.a(MathHelper.b(this.l), MathHelper.b(this.m - 0.20000000298023224D - (double) this.C), MathHelper.b(this.n));

            if (j > 0) {
                StepSound stepsound = Block.n[j].bl;

                this.h.a(this, stepsound.c(), stepsound.a() * 0.5F, stepsound.b() * 0.75F);
            }
        }
    }

    public void c(float f1, float f2) {
        double d1;

        if (this.o()) {
            d1 = this.m;
            this.a(f1, f2, 0.02F);
            this.c(this.o, this.p, this.q);
            this.o *= 0.800000011920929D;
            this.p *= 0.800000011920929D;
            this.q *= 0.800000011920929D;
            this.p -= 0.02D;
            if (this.x && this.b(this.o, this.p + 0.6000000238418579D - this.m + d1, this.q)) {
                this.p = 0.30000001192092896D;
            }
        } else if (this.q()) {
            d1 = this.m;
            this.a(f1, f2, 0.02F);
            this.c(this.o, this.p, this.q);
            this.o *= 0.5D;
            this.p *= 0.5D;
            this.q *= 0.5D;
            this.p -= 0.02D;
            if (this.x && this.b(this.o, this.p + 0.6000000238418579D - this.m + d1, this.q)) {
                this.p = 0.30000001192092896D;
            }
        } else {
            float f3 = 0.91F;

            if (this.w) {
                f3 = 0.54600006F;
                int i = this.h.a(MathHelper.b(this.l), MathHelper.b(this.v.b) - 1, MathHelper.b(this.n));

                if (i > 0) {
                    f3 = Block.n[i].bo * 0.91F;
                }
            }

            float f4 = 0.16277136F / (f3 * f3 * f3);

            this.a(f1, f2, this.w ? 0.1F * f4 : 0.02F);
            f3 = 0.91F;
            if (this.w) {
                f3 = 0.54600006F;
                int j = this.h.a(MathHelper.b(this.l), MathHelper.b(this.v.b) - 1, MathHelper.b(this.n));

                if (j > 0) {
                    f3 = Block.n[j].bo * 0.91F;
                }
            }

            if (this.E()) {
                this.I = 0.0F;
                if (this.p < -0.15D) {
                    this.p = -0.15D;
                }
            }

            this.c(this.o, this.p, this.q);
            if (this.x && this.E()) {
                this.p = 0.2D;
            }

            this.p -= 0.08D;
            this.p *= 0.9800000190734863D;
            this.o *= (double) f3;
            this.q *= (double) f3;
        }

        this.aY = this.aZ;
        d1 = this.l - this.i;
        double d2 = this.n - this.k;
        float f5 = MathHelper.a(d1 * d1 + d2 * d2) * 4.0F;

        if (f5 > 1.0F) {
            f5 = 1.0F;
        }

        this.aZ += (f5 - this.aZ) * 0.4F;
        this.ba += this.aZ;
    }

    public boolean E() {
        int i = MathHelper.b(this.l);
        int j = MathHelper.b(this.v.b);
        int k = MathHelper.b(this.n);

        return this.h.a(i, j, k) == Block.aG.bc || this.h.a(i, j + 1, k) == Block.aG.bc;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Health", (short) this.aM);
        nbttagcompound.a("HurtTime", (short) this.aO);
        nbttagcompound.a("DeathTime", (short) this.aR);
        nbttagcompound.a("AttackTime", (short) this.aS);
    }

    public void b(NBTTagCompound nbttagcompound) {
        this.aM = nbttagcompound.c("Health");
        if (!nbttagcompound.a("Health")) {
            this.aM = 10;
        }

        this.aO = nbttagcompound.c("HurtTime");
        this.aR = nbttagcompound.c("DeathTime");
        this.aS = nbttagcompound.c("AttackTime");
    }

    public boolean t() {
        return !this.B && this.aM > 0;
    }

    public void y() {
        if (this.b > 0) {
            double d1 = this.l + (this.ad - this.l) / (double) this.b;
            double d2 = this.m + (this.ae - this.m) / (double) this.b;
            double d3 = this.n + (this.af - this.n) / (double) this.b;

            double d4;

            for (d4 = this.ag - (double) this.r; d4 < -180.0D; d4 += 360.0D) {
                ;
            }

            while (d4 >= 180.0D) {
                d4 -= 360.0D;
            }

            this.r = (float) ((double) this.r + d4 / (double) this.b);
            this.s = (float) ((double) this.s + (this.ah - (double) this.s) / (double) this.b);
            --this.b;
            this.a(d1, d2, d3);
            this.b(this.r, this.s);
        }

        if (this.aM <= 0) {
            this.bg = false;
            this.bd = 0.0F;
            this.be = 0.0F;
            this.bf = 0.0F;
        } else if (!this.aJ) {
            this.d_();
        }

        boolean flag = this.o();
        boolean flag1 = this.q();

        if (this.bg) {
            if (flag) {
                this.p += 0.03999999910593033D;
            } else if (flag1) {
                this.p += 0.03999999910593033D;
            } else if (this.w) {
                this.F();
            }
        }

        this.bd *= 0.98F;
        this.be *= 0.98F;
        this.bf *= 0.9F;
        this.c(this.bd, this.be);
        List list = this.h.b((Entity) this, this.v.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity) list.get(i);

                if (entity.r()) {
                    entity.c((Entity) this);
                }
            }
        }
    }

    protected void F() {
        this.p = 0.41999998688697815D;
    }

    protected void d_() {
        ++this.bc;
        EntityPlayer entityplayer = this.h.a(this, -1.0D);

        if (entityplayer != null) {
            double d1 = entityplayer.l - this.l;
            double d2 = entityplayer.m - this.m;
            double d3 = entityplayer.n - this.n;
            double d4 = d1 * d1 + d2 * d2 + d3 * d3;

            if (d4 > 16384.0D) {
                this.j();
            }

            if (this.bc > 600 && this.R.nextInt(800) == 0) {
                if (d4 < 1024.0D) {
                    this.bc = 0;
                } else {
                    this.j();
                }
            }
        }

        this.bd = 0.0F;
        this.be = 0.0F;
        float f1 = 8.0F;

        if (this.R.nextFloat() < 0.02F) {
            entityplayer = this.h.a(this, (double) f1);
            if (entityplayer != null) {
                this.ai = entityplayer;
                this.aj = 10 + this.R.nextInt(20);
            } else {
                this.bf = (this.R.nextFloat() - 0.5F) * 20.0F;
            }
        }

        if (this.ai != null) {
            this.b(this.ai, 10.0F);
            if (this.aj-- <= 0 || this.ai.B || this.ai.b((Entity) this) > (double) (f1 * f1)) {
                this.ai = null;
            }
        } else {
            if (this.R.nextFloat() < 0.05F) {
                this.bf = (this.R.nextFloat() - 0.5F) * 20.0F;
            }

            this.r += this.bf;
            this.s = this.bh;
        }

        boolean flag = this.o();
        boolean flag1 = this.q();

        if (flag || flag1) {
            this.bg = this.R.nextFloat() < 0.8F;
        }
    }

    public void b(Entity entity, float f1) {
        double d1 = entity.l - this.l;
        double d2 = entity.n - this.n;
        double d3;

        if (entity instanceof EntityLiving) {
            EntityLiving entityliving = (EntityLiving) entity;

            d3 = entityliving.m + (double) entityliving.p() - (this.m + (double) this.p());
        } else {
            d3 = (entity.v.b + entity.v.e) / 2.0D - (this.m + (double) this.p());
        }

        double d4 = (double) MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = (float) (Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
        float f3 = (float) (Math.atan2(d3, d4) * 180.0D / 3.1415927410125732D);

        this.s = this.b(this.s, f3, f1);
        this.r = this.b(this.r, f2, f1);
    }

    private float b(float f1, float f2, float f3) {
        float f4;

        for (f4 = f2 - f1; f4 < -180.0F; f4 += 360.0F) {
            ;
        }

        while (f4 >= 180.0F) {
            f4 -= 360.0F;
        }

        if (f4 > f3) {
            f4 = f3;
        }

        if (f4 < -f3) {
            f4 = -f3;
        }

        return f1 + f4;
    }

    public void G() {}

    public boolean a() {
        return this.h.a(this.v) && this.h.a((Entity) this, this.v).size() == 0 && !this.h.b(this.v);
    }

    protected void l() {
        this.a((Entity) null, 4);
    }

    public Vec3D c(float f1) {
        if (f1 == 1.0F) {
            return Vec3D.b(this.l, this.m, this.n);
        } else {
            double d1 = this.i + (this.l - this.i) * (double) f1;
            double d2 = this.j + (this.m - this.j) * (double) f1;
            double d3 = this.k + (this.n - this.k) * (double) f1;

            return Vec3D.b(d1, d2, d3);
        }
    }

    public Vec3D d(float f1) {
        float f2;
        float f3;
        float f4;
        float f5;

        if (f1 == 1.0F) {
            f2 = MathHelper.b(-this.r * 0.017453292F - 3.1415927F);
            f3 = MathHelper.a(-this.r * 0.017453292F - 3.1415927F);
            f4 = -MathHelper.b(-this.s * 0.017453292F);
            f5 = MathHelper.a(-this.s * 0.017453292F);
            return Vec3D.b((double) (f3 * f4), (double) f5, (double) (f2 * f4));
        } else {
            f2 = this.u + (this.s - this.u) * f1;
            f3 = this.t + (this.r - this.t) * f1;
            f4 = MathHelper.b(-f3 * 0.017453292F - 3.1415927F);
            f5 = MathHelper.a(-f3 * 0.017453292F - 3.1415927F);
            float f6 = -MathHelper.b(-f2 * 0.017453292F);
            float f7 = MathHelper.a(-f2 * 0.017453292F);

            return Vec3D.b((double) (f5 * f6), (double) f7, (double) (f4 * f6));
        }
    }

    public MovingObjectPosition a(double d1, float f1) {
        Vec3D vec3d = this.c(f1);
        Vec3D vec3d1 = this.d(f1);
        Vec3D vec3d2 = vec3d.c(vec3d1.a * d1, vec3d1.b * d1, vec3d1.c * d1);

        return this.h.a(vec3d, vec3d2);
    }
}
