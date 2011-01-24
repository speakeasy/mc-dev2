package net.minecraft.server;

import java.util.List;

public class EntityLiving extends Entity {

    public int aF = 20;
    public float aG;
    public float aH;
    public float aI;
    public float aJ = 0.0F;
    public float aK = 0.0F;
    protected float aL;
    protected float aM;
    protected float aN;
    protected float aO;
    protected boolean aP = true;
    protected String aQ = "/mob/char.png";
    protected boolean aR = true;
    protected float aS = 0.0F;
    protected String aT = null;
    protected float aU = 1.0F;
    protected int aV = 0;
    protected float aW = 0.0F;
    public boolean aX = false;
    public float aY;
    public float aZ;
    public int ba = 10;
    public int bb;
    private int a;
    public int bc;
    public int bd;
    public float be = 0.0F;
    public int bf = 0;
    public int bg = 0;
    public float bh;
    public float bi;
    protected boolean bj = false;
    public int bk = -1;
    public float bl = (float) (Math.random() * 0.8999999761581421D + 0.10000000149011612D);
    public float bm;
    public float bn;
    public float bo;
    protected int bp;
    protected double bq;
    protected double br;
    protected double bs;
    protected double bt;
    protected double bu;
    float bv = 0.0F;
    protected int bw = 0;
    protected int bx = 0;
    protected float by;
    protected float bz;
    protected float bA;
    protected boolean bB = false;
    protected float bC = 0.0F;
    protected float bD = 0.7F;
    private Entity b;
    private int c = 0;

    public EntityLiving(World world) {
        super(world);
        this.i = true;
        this.aI = (float) (Math.random() + 1.0D) * 0.01F;
        this.a(this.p, this.q, this.r);
        this.aG = (float) Math.random() * 12398.0F;
        this.v = (float) (Math.random() * 3.1415927410125732D * 2.0D);
        this.aH = 1.0F;
        this.S = 0.5F;
    }

    public boolean i(Entity entity) {
        return this.l.a(Vec3D.b(this.p, this.q + (double) this.s(), this.r), Vec3D.b(entity.p, entity.q + (double) entity.s(), entity.r)) == null;
    }

    public boolean c_() {
        return !this.G;
    }

    public boolean v() {
        return !this.G;
    }

    public float s() {
        return this.J * 0.85F;
    }

    public int b() {
        return 80;
    }

    public void m() {
        this.aY = this.aZ;
        super.m();
        if (this.W.nextInt(1000) < this.a++) {
            this.a = -this.b();
            String s = this.d();

            if (s != null) {
                this.l.a(this, s, this.h(), (this.W.nextFloat() - this.W.nextFloat()) * 0.2F + 1.0F);
            }
        }

        if (this.x() && this.y()) {
            this.a((Entity) null, 1);
        }

        if (this.ae || this.l.z) {
            this.Z = 0;
        }

        int i;

        if (this.x() && this.a(Material.f)) {
            --this.ad;
            if (this.ad == -20) {
                this.ad = 0;

                for (i = 0; i < 8; ++i) {
                    float f1 = this.W.nextFloat() - this.W.nextFloat();
                    float f2 = this.W.nextFloat() - this.W.nextFloat();
                    float f3 = this.W.nextFloat() - this.W.nextFloat();

                    this.l.a("bubble", this.p + (double) f1, this.q + (double) f2, this.r + (double) f3, this.s, this.t, this.u);
                }

                this.a((Entity) null, 2);
            }

            this.Z = 0;
        } else {
            this.ad = this.aa;
        }

        this.bh = this.bi;
        if (this.bg > 0) {
            --this.bg;
        }

        if (this.bc > 0) {
            --this.bc;
        }

        if (this.ac > 0) {
            --this.ac;
        }

        if (this.ba <= 0) {
            ++this.bf;
            if (this.bf > 20) {
                this.Q();
                this.l();

                for (i = 0; i < 20; ++i) {
                    double d1 = this.W.nextGaussian() * 0.02D;
                    double d2 = this.W.nextGaussian() * 0.02D;
                    double d3 = this.W.nextGaussian() * 0.02D;

                    this.l.a("explode", this.p + (double) (this.W.nextFloat() * this.I * 2.0F) - (double) this.I, this.q + (double) (this.W.nextFloat() * this.J), this.r + (double) (this.W.nextFloat() * this.I * 2.0F) - (double) this.I, d1, d2, d3);
                }
            }
        }

        this.aO = this.aN;
        this.aK = this.aJ;
        this.x = this.v;
        this.y = this.w;
    }

    public void O() {
        for (int i = 0; i < 20; ++i) {
            double d1 = this.W.nextGaussian() * 0.02D;
            double d2 = this.W.nextGaussian() * 0.02D;
            double d3 = this.W.nextGaussian() * 0.02D;
            double d4 = 10.0D;

            this.l.a("explode", this.p + (double) (this.W.nextFloat() * this.I * 2.0F) - (double) this.I - d1 * d4, this.q + (double) (this.W.nextFloat() * this.J) - d2 * d4, this.r + (double) (this.W.nextFloat() * this.I * 2.0F) - (double) this.I - d3 * d4, d1, d2, d3);
        }
    }

    public void z() {
        super.z();
        this.aL = this.aM;
        this.aM = 0.0F;
    }

    public void b_() {
        super.b_();
        this.G();
        double d1 = this.p - this.m;
        double d2 = this.r - this.o;
        float f1 = MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = this.aJ;
        float f3 = 0.0F;

        this.aL = this.aM;
        float f4 = 0.0F;

        if (f1 > 0.05F) {
            f4 = 1.0F;
            f3 = f1 * 3.0F;
            f2 = (float) Math.atan2(d2, d1) * 180.0F / 3.1415927F - 90.0F;
        }

        if (this.aZ > 0.0F) {
            f2 = this.v;
        }

        if (!this.A) {
            f4 = 0.0F;
        }

        this.aM += (f4 - this.aM) * 0.3F;

        float f5;

        for (f5 = f2 - this.aJ; f5 < -180.0F; f5 += 360.0F) {
            ;
        }

        while (f5 >= 180.0F) {
            f5 -= 360.0F;
        }

        this.aJ += f5 * 0.3F;

        float f6;

        for (f6 = this.v - this.aJ; f6 < -180.0F; f6 += 360.0F) {
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

        this.aJ = this.v - f6;
        if (f6 * f6 > 2500.0F) {
            this.aJ += f6 * 0.2F;
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

        while (this.aJ - this.aK < -180.0F) {
            this.aK -= 360.0F;
        }

        while (this.aJ - this.aK >= 180.0F) {
            this.aK += 360.0F;
        }

        while (this.w - this.y < -180.0F) {
            this.y -= 360.0F;
        }

        while (this.w - this.y >= 180.0F) {
            this.y += 360.0F;
        }

        this.aN += f3;
    }

    protected void a(float f1, float f2) {
        super.a(f1, f2);
    }

    public void c(int i) {
        if (this.ba > 0) {
            this.ba += i;
            if (this.ba > 20) {
                this.ba = 20;
            }

            this.ac = this.aF / 2;
        }
    }

    public boolean a(Entity entity, int i) {
        if (this.l.z) {
            return false;
        } else {
            this.bx = 0;
            if (this.ba <= 0) {
                return false;
            } else {
                this.bn = 1.5F;
                boolean flag = true;

                if ((float) this.ac > (float) this.aF / 2.0F) {
                    if (i <= this.bw) {
                        return false;
                    }

                    this.d(i - this.bw);
                    this.bw = i;
                    flag = false;
                } else {
                    this.bw = i;
                    this.bb = this.ba;
                    this.ac = this.aF;
                    this.d(i);
                    this.bc = this.bd = 10;
                }

                this.be = 0.0F;
                if (flag) {
                    this.l.a(this, (byte) 2);
                    this.u();
                    if (entity != null) {
                        double d1 = entity.p - this.p;

                        double d2;

                        for (d2 = entity.r - this.r; d1 * d1 + d2 * d2 < 1.0E-4D; d2 = (Math.random() - Math.random()) * 0.01D) {
                            d1 = (Math.random() - Math.random()) * 0.01D;
                        }

                        this.be = (float) (Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - this.v;
                        this.a(entity, i, d1, d2);
                    } else {
                        this.be = (float) ((int) (Math.random() * 2.0D) * 180);
                    }
                }

                if (this.ba <= 0) {
                    if (flag) {
                        this.l.a(this, this.f(), this.h(), (this.W.nextFloat() - this.W.nextFloat()) * 0.2F + 1.0F);
                    }

                    this.f(entity);
                } else if (flag) {
                    this.l.a(this, this.e(), this.h(), (this.W.nextFloat() - this.W.nextFloat()) * 0.2F + 1.0F);
                }

                return true;
            }
        }
    }

    protected void d(int i) {
        this.ba -= i;
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
        if (this.aV > 0 && entity != null) {
            entity.b(this, this.aV);
        }

        this.bj = true;
        if (!this.l.z) {
            int i = this.g();

            if (i > 0) {
                int j = this.W.nextInt(3);

                for (int k = 0; k < j; ++k) {
                    this.b(i, 1);
                }
            }
        }

        this.l.a(this, (byte) 3);
    }

    protected int g() {
        return 0;
    }

    protected void a(float f1) {
        int i = (int) Math.ceil((double) (f1 - 3.0F));

        if (i > 0) {
            this.a((Entity) null, i);
            int j = this.l.a(MathHelper.b(this.p), MathHelper.b(this.q - 0.20000000298023224D - (double) this.H), MathHelper.b(this.r));

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
                this.N = 0.0F;
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

        this.bm = this.bn;
        d1 = this.p - this.m;
        double d2 = this.r - this.o;
        float f5 = MathHelper.a(d1 * d1 + d2 * d2) * 4.0F;

        if (f5 > 1.0F) {
            f5 = 1.0F;
        }

        this.bn += (f5 - this.bn) * 0.4F;
        this.bo += this.bn;
    }

    public boolean d_() {
        int i = MathHelper.b(this.p);
        int j = MathHelper.b(this.z.b);
        int k = MathHelper.b(this.r);

        return this.l.a(i, j, k) == Block.aF.bh || this.l.a(i, j + 1, k) == Block.aF.bh;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Health", (short) this.ba);
        nbttagcompound.a("HurtTime", (short) this.bc);
        nbttagcompound.a("DeathTime", (short) this.bf);
        nbttagcompound.a("AttackTime", (short) this.bg);
    }

    public void b(NBTTagCompound nbttagcompound) {
        this.ba = nbttagcompound.c("Health");
        if (!nbttagcompound.a("Health")) {
            this.ba = 10;
        }

        this.bc = nbttagcompound.c("HurtTime");
        this.bf = nbttagcompound.c("DeathTime");
        this.bg = nbttagcompound.c("AttackTime");
    }

    public boolean x() {
        return !this.G && this.ba > 0;
    }

    public void G() {
        if (this.bp > 0) {
            double d1 = this.p + (this.bq - this.p) / (double) this.bp;
            double d2 = this.q + (this.br - this.q) / (double) this.bp;
            double d3 = this.r + (this.bs - this.r) / (double) this.bp;

            double d4;

            for (d4 = this.bt - (double) this.v; d4 < -180.0D; d4 += 360.0D) {
                ;
            }

            while (d4 >= 180.0D) {
                d4 -= 360.0D;
            }

            this.v = (float) ((double) this.v + d4 / (double) this.bp);
            this.w = (float) ((double) this.w + (this.bu - (double) this.w) / (double) this.bp);
            --this.bp;
            this.a(d1, d2, d3);
            this.b(this.v, this.w);
        }

        if (this.ba <= 0) {
            this.bB = false;
            this.by = 0.0F;
            this.bz = 0.0F;
            this.bA = 0.0F;
        } else if (!this.aX) {
            this.c();
        }

        boolean flag = this.r();
        boolean flag1 = this.t();

        if (this.bB) {
            if (flag) {
                this.t += 0.03999999910593033D;
            } else if (flag1) {
                this.t += 0.03999999910593033D;
            } else if (this.A) {
                this.P();
            }
        }

        this.by *= 0.98F;
        this.bz *= 0.98F;
        this.bA *= 0.9F;
        this.c(this.by, this.bz);
        List list = this.l.b((Entity) this, this.z.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity) list.get(i);

                if (entity.v()) {
                    entity.c((Entity) this);
                }
            }
        }
    }

    protected void P() {
        this.t = 0.41999998688697815D;
    }

    protected void c() {
        ++this.bx;
        EntityPlayer entityplayer = this.l.a(this, -1.0D);

        if (entityplayer != null) {
            double d1 = entityplayer.p - this.p;
            double d2 = entityplayer.q - this.q;
            double d3 = entityplayer.r - this.r;
            double d4 = d1 * d1 + d2 * d2 + d3 * d3;

            if (d4 > 16384.0D) {
                this.l();
            }

            if (this.bx > 600 && this.W.nextInt(800) == 0) {
                if (d4 < 1024.0D) {
                    this.bx = 0;
                } else {
                    this.l();
                }
            }
        }

        this.by = 0.0F;
        this.bz = 0.0F;
        float f1 = 8.0F;

        if (this.W.nextFloat() < 0.02F) {
            entityplayer = this.l.a(this, (double) f1);
            if (entityplayer != null) {
                this.b = entityplayer;
                this.c = 10 + this.W.nextInt(20);
            } else {
                this.bA = (this.W.nextFloat() - 0.5F) * 20.0F;
            }
        }

        if (this.b != null) {
            this.b(this.b, 10.0F);
            if (this.c-- <= 0 || this.b.G || this.b.b((Entity) this) > (double) (f1 * f1)) {
                this.b = null;
            }
        } else {
            if (this.W.nextFloat() < 0.05F) {
                this.bA = (this.W.nextFloat() - 0.5F) * 20.0F;
            }

            this.v += this.bA;
            this.w = this.bC;
        }

        boolean flag = this.r();
        boolean flag1 = this.t();

        if (flag || flag1) {
            this.bB = this.W.nextFloat() < 0.8F;
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

        this.w = -this.b(this.w, f3, f1);
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

    public void Q() {}

    public boolean a() {
        return this.l.a(this.z) && this.l.a((Entity) this, this.z).size() == 0 && !this.l.b(this.z);
    }

    protected void o() {
        this.a((Entity) null, 4);
    }

    public Vec3D C() {
        return this.c(1.0F);
    }

    public Vec3D c(float f1) {
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

    public int i() {
        return 4;
    }
}
