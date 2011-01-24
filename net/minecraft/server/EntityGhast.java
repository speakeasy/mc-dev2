package net.minecraft.server;

public class EntityGhast extends EntityFlying implements IMobs {

    public int a = 0;
    public double b;
    public double c;
    public double d;
    private Entity ak = null;
    private int al = 0;
    public int e = 0;
    public int f = 0;

    public EntityGhast(World world) {
        super(world);
        this.aP = "/mob/ghast.png";
        this.a(4.0F, 4.0F);
        this.ae = true;
    }

    protected void d() {
        if (this.l.k == 0) {
            this.q();
        }

        this.e = this.f;
        double d1 = this.b - this.p;
        double d2 = this.c - this.q;
        double d3 = this.d - this.r;
        double d4 = (double) MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);

        if (d4 < 1.0D || d4 > 60.0D) {
            this.b = this.p + (double) ((this.W.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.c = this.q + (double) ((this.W.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.d = this.r + (double) ((this.W.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.a-- <= 0) {
            this.a += this.W.nextInt(5) + 2;
            if (this.a(this.b, this.c, this.d, d4)) {
                this.s += d1 / d4 * 0.1D;
                this.t += d2 / d4 * 0.1D;
                this.u += d3 / d4 * 0.1D;
            } else {
                this.b = this.p;
                this.c = this.q;
                this.d = this.r;
            }
        }

        if (this.ak != null && this.ak.G) {
            this.ak = null;
        }

        if (this.ak == null || this.al-- <= 0) {
            this.ak = this.l.a(this, 100.0D);
            if (this.ak != null) {
                this.al = 20;
            }
        }

        double d5 = 64.0D;

        if (this.ak != null && this.ak.b((Entity) this) < d5 * d5) {
            double d6 = this.ak.p - this.p;
            double d7 = this.ak.z.b + (double) (this.ak.J / 2.0F) - (this.q + (double) (this.J / 2.0F));
            double d8 = this.ak.r - this.r;

            this.aI = this.v = -((float) Math.atan2(d6, d8)) * 180.0F / 3.1415927F;
            if (this.i(this.ak)) {
                if (this.f == 10) {
                    this.l.a(this, "mob.ghast.charge", this.i(), (this.W.nextFloat() - this.W.nextFloat()) * 0.2F + 1.0F);
                }

                ++this.f;
                if (this.f == 20) {
                    this.l.a(this, "mob.ghast.fireball", this.i(), (this.W.nextFloat() - this.W.nextFloat()) * 0.2F + 1.0F);
                    EntityFireball entityfireball = new EntityFireball(this.l, this, d6, d7, d8);
                    double d9 = 4.0D;
                    Vec3D vec3d = this.c(1.0F);

                    entityfireball.p = this.p + vec3d.a * d9;
                    entityfireball.q = this.q + (double) (this.J / 2.0F) + 0.5D;
                    entityfireball.r = this.r + vec3d.c * d9;
                    this.l.a((Entity) entityfireball);
                    this.f = -40;
                }
            } else if (this.f > 0) {
                --this.f;
            }
        } else {
            this.aI = this.v = -((float) Math.atan2(this.s, this.u)) * 180.0F / 3.1415927F;
            if (this.f > 0) {
                --this.f;
            }
        }

        this.aP = this.f > 10 ? "/mob/ghast_fire.png" : "/mob/ghast.png";
    }

    private boolean a(double d1, double d2, double d3, double d4) {
        double d5 = (this.b - this.p) / d4;
        double d6 = (this.c - this.q) / d4;
        double d7 = (this.d - this.r) / d4;
        AxisAlignedBB axisalignedbb = this.z.b();

        for (int i = 1; (double) i < d4; ++i) {
            axisalignedbb.d(d5, d6, d7);
            if (this.l.a((Entity) this, axisalignedbb).size() > 0) {
                return false;
            }
        }

        return true;
    }

    protected String e() {
        return "mob.ghast.moan";
    }

    protected String f() {
        return "mob.ghast.scream";
    }

    protected String g() {
        return "mob.ghast.death";
    }

    protected int h() {
        return Item.K.ba;
    }

    protected float i() {
        return 10.0F;
    }

    public boolean b() {
        return this.W.nextInt(20) == 0 && super.b() && this.l.k > 0;
    }

    public int j() {
        return 1;
    }
}
