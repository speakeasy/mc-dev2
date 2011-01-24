package net.minecraft.server;

import java.util.List;

public class EntityLiving extends Entity {

    public int au = 20;
    public float av;
    public float aw;
    public float ax;
    public float ay = 0.0F;
    public float az = 0.0F;
    protected float aA;
    protected float aB;
    protected float aC;
    protected float aD;
    protected boolean aE = true;
    protected String aF = "/mob/char.png";
    protected boolean aG = true;
    protected float aH = 0.0F;
    protected String aI = null;
    protected float aJ = 1.0F;
    protected int aK = 0;
    protected float aL = 0.0F;
    public boolean aM = false;
    public float aN;
    public float aO;
    public int aP = 10;
    public int aQ;
    private int a;
    public int aR;
    public int aS;
    public float aT = 0.0F;
    public int aU = 0;
    public int aV = 0;
    public float aW;
    public float aX;
    protected boolean aY = false;
    public int aZ = -1;
    public float ba = (float) (Math.random() * 0.8999999761581421D + 0.10000000149011612D);
    public float bb;
    public float bc;
    public float bd;
    protected int be;
    protected double bf;
    protected double bg;
    protected double bh;
    protected double bi;
    protected double bj;
    float bk = 0.0F;
    private int b = 0;
    protected int bl = 0;
    protected float bm;
    protected float bn;
    protected float bo;
    protected boolean bp = false;
    protected float bq = 0.0F;
    protected float br = 0.7F;
    private Entity c;
    private int d = 0;

    public EntityLiving(World world) {
        super(world);
        this.i = true;
        this.ax = (float) (Math.random() + 1.0D) * 0.01F;
        this.a(this.p, this.q, this.r);
        this.av = (float) Math.random() * 12398.0F;
        this.v = (float) (Math.random() * 3.1415927410125732D * 2.0D);
        this.aw = 1.0F;
        this.R = 0.5F;
    }

    public boolean g(Entity entity) {
        return this.l.a(Vec3D.b(this.p, this.q + (double) this.s(), this.r), Vec3D.b(entity.p, entity.q + (double) entity.s(), entity.r)) == null;
    }

    public boolean c_() {
        return !this.F;
    }

    public boolean u() {
        return !this.F;
    }

    public float s() {
        return this.I * 0.85F;
    }

    public int b() {
        return 80;
    }

    public void m() {
        this.aN = this.aO;
        super.m();
        if (this.V.nextInt(1000) < this.a++) {
            this.a = -this.b();
            String s = this.d();

            if (s != null) {
                this.l.a(this, s, this.h(), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
            }
        }

        if (this.w() && this.x()) {
            this.a((Entity) null, 1);
        }

        if (this.ad) {
            this.Y = 0;
        }

        int i;

        if (this.w() && this.a(Material.f)) {
            --this.ac;
            if (this.ac == -20) {
                this.ac = 0;

                for (i = 0; i < 8; ++i) {
                    float f1 = this.V.nextFloat() - this.V.nextFloat();
                    float f2 = this.V.nextFloat() - this.V.nextFloat();
                    float f3 = this.V.nextFloat() - this.V.nextFloat();

                    this.l.a("bubble", this.p + (double) f1, this.q + (double) f2, this.r + (double) f3, this.s, this.t, this.u);
                }

                this.a((Entity) null, 2);
            }

            this.Y = 0;
        } else {
            this.ac = this.Z;
        }

        this.aW = this.aX;
        if (this.aV > 0) {
            --this.aV;
        }

        if (this.aR > 0) {
            --this.aR;
        }

        if (this.ab > 0) {
            --this.ab;
        }

        if (this.aP <= 0) {
            ++this.aU;
            if (this.aU > 20) {
                this.K();
                this.l();

                for (i = 0; i < 20; ++i) {
                    double d1 = this.V.nextGaussian() * 0.02D;
                    double d2 = this.V.nextGaussian() * 0.02D;
                    double d3 = this.V.nextGaussian() * 0.02D;

                    this.l.a("explode", this.p + (double) (this.V.nextFloat() * this.H * 2.0F) - (double) this.H, this.q + (double) (this.V.nextFloat() * this.I), this.r + (double) (this.V.nextFloat() * this.H * 2.0F) - (double) this.H, d1, d2, d3);
                }
            }
        }

        this.aD = this.aC;
        this.az = this.ay;
        this.x = this.v;
        this.y = this.w;
    }

    public void I() {
        for (int i = 0; i < 20; ++i) {
            double d1 = this.V.nextGaussian() * 0.02D;
            double d2 = this.V.nextGaussian() * 0.02D;
            double d3 = this.V.nextGaussian() * 0.02D;
            double d4 = 10.0D;

            this.l.a("explode", this.p + (double) (this.V.nextFloat() * this.H * 2.0F) - (double) this.H - d1 * d4, this.q + (double) (this.V.nextFloat() * this.I) - d2 * d4, this.r + (double) (this.V.nextFloat() * this.H * 2.0F) - (double) this.H - d3 * d4, d1, d2, d3);
        }
    }

    public void y() {
        super.y();
        this.aA = this.aB;
        this.aB = 0.0F;
    }

    public void b_() {
        super.b_();
        this.D();
        double d1 = this.p - this.m;
        double d2 = this.r - this.o;
        float f1 = MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = this.ay;
        float f3 = 0.0F;

        this.aA = this.aB;
        float f4 = 0.0F;

        if (f1 > 0.05F) {
            f4 = 1.0F;
            f3 = f1 * 3.0F;
            f2 = (float) Math.atan2(d2, d1) * 180.0F / 3.1415927F - 90.0F;
        }

        if (this.aO > 0.0F) {
            f2 = this.v;
        }

        if (!this.A) {
            f4 = 0.0F;
        }

        this.aB += (f4 - this.aB) * 0.3F;

        float f5;

        for (f5 = f2 - this.ay; f5 < -180.0F; f5 += 360.0F) {
            ;
        }

        while (f5 >= 180.0F) {
            f5 -= 360.0F;
        }

        this.ay += f5 * 0.3F;

        float f6;

        for (f6 = this.v - this.ay; f6 < -180.0F; f6 += 360.0F) {
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

        this.ay = this.v - f6;
        if (f6 * f6 > 2500.0F) {
            this.ay += f6 * 0.2F;
        }

        if (flag) {
            f3 *= -1.0F;
        }

        while (this.v - this.x < -180.0F) {
            this.x -= 360.0F;
        }

        while (this.v - this.x >= 180.0F) {
            this.x += 360.0F;
        }

        while (this.ay - this.az < -180.0F) {
            this.az -= 360.0F;
        }

        while (this.ay - this.az >= 180.0F) {
            this.az += 360.0F;
        }

        while (this.w - this.y < -180.0F) {
            this.y -= 360.0F;
        }

        while (this.w - this.y >= 180.0F) {
            this.y += 360.0F;
        }

        this.aC += f3;
    }

    protected void a(float f1, float f2) {
        super.a(f1, f2);
    }

    public void a(int i) {
        if (this.aP > 0) {
            this.aP += i;
            if (this.aP > 20) {
                this.aP = 20;
            }

            this.ab = this.au / 2;
        }
    }

    public boolean a(Entity entity, int i) {
        if (this.l.z) {
            i = 0;
        }

        this.bl = 0;
        if (this.aP <= 0) {
            return false;
        } else {
            this.bc = 1.5F;
            boolean flag = true;

            if ((float) this.ab > (float) this.au / 2.0F) {
                if (i <= this.b) {
                    return false;
                }

                this.c(i - this.b);
                this.b = i;
                flag = false;
            } else {
                this.b = i;
                this.aQ = this.aP;
                this.ab = this.au;
                this.c(i);
                this.aR = this.aS = 10;
            }

            this.aT = 0.0F;
            if (flag) {
                if (entity != null) {
                    double d1 = entity.p - this.p;

                    double d2;

                    for (d2 = entity.r - this.r; d1 * d1 + d2 * d2 < 1.0E-4D; d2 = (Math.random() - Math.random()) * 0.01D) {
                        d1 = (Math.random() - Math.random()) * 0.01D;
                    }

                    this.aT = (float) (Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - this.v;
                    this.a(entity, i, d1, d2);
                } else {
                    this.aT = (float) ((int) (Math.random() * 2.0D) * 180);
                }
            }

            if (this.aP <= 0) {
                if (flag) {
                    this.l.a(this, this.f(), this.h(), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
                }

                this.f(entity);
            } else if (flag) {
                this.l.a(this, this.e(), this.h(), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
            }

            return true;
        }
    }

    protected void c(int i) {
        this.aP -= i;
    }

    protected float h() {
        return 1.0F;
    }

    protected String d() {
        return null;
    }

    protected String e() {
        return "random.hurt";
    }

    protected String f() {
        return "random.hurt";
    }

    public void a(Entity entity, int i, double d1, double d2) {
        float f1 = MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = 0.4F;

        this.s /= 2.0D;
        this.t /= 2.0D;
        this.u /= 2.0D;
        this.s -= d1 / (double) f1 * (double) f2;
        this.t += 0.4000000059604645D;
        this.u -= d2 / (double) f1 * (double) f2;
        if (this.t > 0.4000000059604645D) {
            this.t = 0.4000000059604645D;
        }
    }

    public void f(Entity entity) {
        if (this.aK > 0 && entity != null) {
            entity.b(this, this.aK);
        }

        this.aY = true;
        int i = this.g();

        if (i > 0) {
            int j = this.V.nextInt(3);

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
            int j = this.l.a(MathHelper.b(this.p), MathHelper.b(this.q - 0.20000000298023224D - (double) this.G), MathHelper.b(this.r));

            if (j > 0) {
                StepSound stepsound = Block.m[j].bq;

                this.l.a(this, stepsound.c(), stepsound.a() * 0.5F, stepsound.b() * 0.75F);
            }
        }
    }

    public void c(float f1, float f2) {
        double d1;

        if (this.r()) {
            d1 = this.q;
            this.a(f1, f2, 0.02F);
            this.c(this.s, this.t, this.u);
            this.s *= 0.800000011920929D;
            this.t *= 0.800000011920929D;
            this.u *= 0.800000011920929D;
            this.t -= 0.02D;
            if (this.B && this.b(this.s, this.t + 0.6000000238418579D - this.q + d1, this.u)) {
                this.t = 0.30000001192092896D;
            }
        } else if (this.t()) {
            d1 = this.q;
            this.a(f1, f2, 0.02F);
            this.c(this.s, this.t, this.u);
            this.s *= 0.5D;
            this.t *= 0.5D;
            this.u *= 0.5D;
            this.t -= 0.02D;
            if (this.B && this.b(this.s, this.t + 0.6000000238418579D - this.q + d1, this.u)) {
                this.t = 0.30000001192092896D;
            }
        } else {
            float f3 = 0.91F;

            if (this.A) {
                f3 = 0.54600006F;
                int i = this.l.a(MathHelper.b(this.p), MathHelper.b(this.z.b) - 1, MathHelper.b(this.r));

                if (i > 0) {
                    f3 = Block.m[i].bt * 0.91F;
                }
            }

            float f4 = 0.16277136F / (f3 * f3 * f3);

            this.a(f1, f2, this.A ? 0.1F * f4 : 0.02F);
            f3 = 0.91F;
            if (this.A) {
                f3 = 0.54600006F;
                int j = this.l.a(MathHelper.b(this.p), MathHelper.b(this.z.b) - 1, MathHelper.b(this.r));

                if (j > 0) {
                    f3 = Block.m[j].bt * 0.91F;
                }
            }

            if (this.d_()) {
                this.M = 0.0F;
                if (this.t < -0.15D) {
                    this.t = -0.15D;
                }
            }

            this.c(this.s, this.t, this.u);
            if (this.B && this.d_()) {
                this.t = 0.2D;
            }

            this.t -= 0.08D;
            this.t *= 0.9800000190734863D;
            this.s *= (double) f3;
            this.u *= (double) f3;
        }

        this.bb = this.bc;
        d1 = this.p - this.m;
        double d2 = this.r - this.o;
        float f5 = MathHelper.a(d1 * d1 + d2 * d2) * 4.0F;

        if (f5 > 1.0F) {
            f5 = 1.0F;
        }

        this.bc += (f5 - this.bc) * 0.4F;
        this.bd += this.bc;
    }

    public boolean d_() {
        int i = MathHelper.b(this.p);
        int j = MathHelper.b(this.z.b);
        int k = MathHelper.b(this.r);

        return this.l.a(i, j, k) == Block.aF.bh || this.l.a(i, j + 1, k) == Block.aF.bh;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Health", (short) this.aP);
        nbttagcompound.a("HurtTime", (short) this.aR);
        nbttagcompound.a("DeathTime", (short) this.aU);
        nbttagcompound.a("AttackTime", (short) this.aV);
    }

    public void b(NBTTagCompound nbttagcompound) {
        this.aP = nbttagcompound.c("Health");
        if (!nbttagcompound.a("Health")) {
            this.aP = 10;
        }

        this.aR = nbttagcompound.c("HurtTime");
        this.aU = nbttagcompound.c("DeathTime");
        this.aV = nbttagcompound.c("AttackTime");
    }

    public boolean w() {
        return !this.F && this.aP > 0;
    }

    public void D() {
        if (this.be > 0) {
            double d1 = this.p + (this.bf - this.p) / (double) this.be;
            double d2 = this.q + (this.bg - this.q) / (double) this.be;
            double d3 = this.r + (this.bh - this.r) / (double) this.be;

            double d4;

            for (d4 = this.bi - (double) this.v; d4 < -180.0D; d4 += 360.0D) {
                ;
            }

            while (d4 >= 180.0D) {
                d4 -= 360.0D;
            }

            this.v = (float) ((double) this.v + d4 / (double) this.be);
            this.w = (float) ((double) this.w + (this.bj - (double) this.w) / (double) this.be);
            --this.be;
            this.a(d1, d2, d3);
            this.b(this.v, this.w);
        }

        if (this.aP <= 0) {
            this.bp = false;
            this.bm = 0.0F;
            this.bn = 0.0F;
            this.bo = 0.0F;
        } else if (!this.aM) {
            this.c();
        }

        boolean flag = this.r();
        boolean flag1 = this.t();

        if (this.bp) {
            if (flag) {
                this.t += 0.03999999910593033D;
            } else if (flag1) {
                this.t += 0.03999999910593033D;
            } else if (this.A) {
                this.J();
            }
        }

        this.bm *= 0.98F;
        this.bn *= 0.98F;
        this.bo *= 0.9F;
        this.c(this.bm, this.bn);
        List list = this.l.b((Entity) this, this.z.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity) list.get(i);

                if (entity.u()) {
                    entity.c((Entity) this);
                }
            }
        }
    }

    protected void J() {
        this.t = 0.41999998688697815D;
    }

    protected void c() {
        ++this.bl;
        EntityPlayer entityplayer = this.l.a(this, -1.0D);

        if (entityplayer != null) {
            double d1 = entityplayer.p - this.p;
            double d2 = entityplayer.q - this.q;
            double d3 = entityplayer.r - this.r;
            double d4 = d1 * d1 + d2 * d2 + d3 * d3;

            if (d4 > 16384.0D) {
                this.l();
            }

            if (this.bl > 600 && this.V.nextInt(800) == 0) {
                if (d4 < 1024.0D) {
                    this.bl = 0;
                } else {
                    this.l();
                }
            }
        }

        this.bm = 0.0F;
        this.bn = 0.0F;
        float f1 = 8.0F;

        if (this.V.nextFloat() < 0.02F) {
            entityplayer = this.l.a(this, (double) f1);
            if (entityplayer != null) {
                this.c = entityplayer;
                this.d = 10 + this.V.nextInt(20);
            } else {
                this.bo = (this.V.nextFloat() - 0.5F) * 20.0F;
            }
        }

        if (this.c != null) {
            this.b(this.c, 10.0F);
            if (this.d-- <= 0 || this.c.F || this.c.b((Entity) this) > (double) (f1 * f1)) {
                this.c = null;
            }
        } else {
            if (this.V.nextFloat() < 0.05F) {
                this.bo = (this.V.nextFloat() - 0.5F) * 20.0F;
            }

            this.v += this.bo;
            this.w = this.bq;
        }

        boolean flag = this.r();
        boolean flag1 = this.t();

        if (flag || flag1) {
            this.bp = this.V.nextFloat() < 0.8F;
        }
    }

    public void b(Entity entity, float f1) {
        double d1 = entity.p - this.p;
        double d2 = entity.r - this.r;
        double d3;

        if (entity instanceof EntityLiving) {
            EntityLiving entityliving = (EntityLiving) entity;

            d3 = entityliving.q + (double) entityliving.s() - (this.q + (double) this.s());
        } else {
            d3 = (entity.z.b + entity.z.e) / 2.0D - (this.q + (double) this.s());
        }

        double d4 = (double) MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = (float) (Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
        float f3 = (float) (Math.atan2(d3, d4) * 180.0D / 3.1415927410125732D);

        this.w = this.b(this.w, f3, f1);
        this.v = this.b(this.v, f2, f1);
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

    public void K() {}

    public boolean a() {
        return this.l.a(this.z) && this.l.a((Entity) this, this.z).size() == 0 && !this.l.b(this.z);
    }

    protected void o() {
        this.a((Entity) null, 4);
    }

    public Vec3D c(float f1) {
        if (f1 == 1.0F) {
            return Vec3D.b(this.p, this.q, this.r);
        } else {
            double d1 = this.m + (this.p - this.m) * (double) f1;
            double d2 = this.n + (this.q - this.n) * (double) f1;
            double d3 = this.o + (this.r - this.o) * (double) f1;

            return Vec3D.b(d1, d2, d3);
        }
    }

    public Vec3D B() {
        return this.d(1.0F);
    }

    public Vec3D d(float f1) {
        float f2;
        float f3;
        float f4;
        float f5;

        if (f1 == 1.0F) {
            f2 = MathHelper.b(-this.v * 0.017453292F - 3.1415927F);
            f3 = MathHelper.a(-this.v * 0.017453292F - 3.1415927F);
            f4 = -MathHelper.b(-this.w * 0.017453292F);
            f5 = MathHelper.a(-this.w * 0.017453292F);
            return Vec3D.b((double) (f3 * f4), (double) f5, (double) (f2 * f4));
        } else {
            f2 = this.y + (this.w - this.y) * f1;
            f3 = this.x + (this.v - this.x) * f1;
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

        return this.l.a(vec3d, vec3d2);
    }

    public int i() {
        return 4;
    }
}
