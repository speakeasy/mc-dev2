package net.minecraft.server;

public class EntityCreature extends EntityLiving {

    private PathEntity a;
    protected Entity ag;
    protected boolean ah = false;

    public EntityCreature(World world) {
        super(world);
    }

    protected void d_() {
        this.ah = false;
        float f1 = 16.0F;

        if (this.ag == null) {
            this.ag = this.i();
            if (this.ag != null) {
                this.a = this.h.a(this, this.ag, f1);
            }
        } else if (!this.ag.t()) {
            this.ag = null;
        } else {
            float f2 = this.ag.a((Entity) this);

            if (this.g(this.ag)) {
                this.a(this.ag, f2);
            }
        }

        if (!this.ah && this.ag != null && (this.a == null || this.R.nextInt(20) == 0)) {
            this.a = this.h.a(this, this.ag, f1);
        } else if (this.a == null && this.R.nextInt(80) == 0 || this.R.nextInt(80) == 0) {
            boolean flag = false;
            int i = -1;
            int j = -1;
            int k = -1;
            float f3 = -99999.0F;

            for (int l = 0; l < 10; ++l) {
                int i1 = MathHelper.b(this.l + (double) this.R.nextInt(13) - 6.0D);
                int j1 = MathHelper.b(this.m + (double) this.R.nextInt(7) - 3.0D);
                int k1 = MathHelper.b(this.n + (double) this.R.nextInt(13) - 6.0D);
                float f4 = this.a(i1, j1, k1);

                if (f4 > f3) {
                    f3 = f4;
                    i = i1;
                    j = j1;
                    k = k1;
                    flag = true;
                }
            }

            if (flag) {
                this.a = this.h.a(this, i, j, k, 10.0F);
            }
        }

        int l1 = MathHelper.b(this.v.b);
        boolean flag1 = this.o();
        boolean flag2 = this.q();

        this.s = 0.0F;
        if (this.a != null && this.R.nextInt(100) != 0) {
            Vec3D vec3d = this.a.a(this);
            double d1 = (double) (this.D * 2.0F);

            while (vec3d != null && vec3d.d(this.l, vec3d.b, this.n) < d1 * d1) {
                this.a.a();
                if (this.a.b()) {
                    vec3d = null;
                    this.a = null;
                } else {
                    vec3d = this.a.a(this);
                }
            }

            this.bg = false;
            if (vec3d != null) {
                double d2 = vec3d.a - this.l;
                double d3 = vec3d.c - this.n;
                double d4 = vec3d.b - (double) l1;
                float f5 = (float) (Math.atan2(d3, d2) * 180.0D / 3.1415927410125732D) - 90.0F;
                float f6 = f5 - this.r;

                for (this.be = this.bi; f6 < -180.0F; f6 += 360.0F) {
                    ;
                }

                while (f6 >= 180.0F) {
                    f6 -= 360.0F;
                }

                if (f6 > 30.0F) {
                    f6 = 30.0F;
                }

                if (f6 < -30.0F) {
                    f6 = -30.0F;
                }

                this.r += f6;
                if (this.ah && this.ag != null) {
                    double d5 = this.ag.l - this.l;
                    double d6 = this.ag.n - this.n;
                    float f7 = this.r;

                    this.r = (float) (Math.atan2(d6, d5) * 180.0D / 3.1415927410125732D) - 90.0F;
                    f6 = (f7 - this.r + 90.0F) * 3.1415927F / 180.0F;
                    this.bd = -MathHelper.a(f6) * this.be * 1.0F;
                    this.be = MathHelper.b(f6) * this.be * 1.0F;
                }

                if (d4 > 0.0D) {
                    this.bg = true;
                }
            }

            if (this.ag != null) {
                this.b(this.ag, 30.0F);
            }

            if (this.x) {
                this.bg = true;
            }

            if (this.R.nextFloat() < 0.8F && (flag1 || flag2)) {
                this.bg = true;
            }
        } else {
            super.d_();
            this.a = null;
        }
    }

    protected void a(Entity entity, float f1) {}

    protected float a(int i, int j, int k) {
        return 0.0F;
    }

    protected Entity i() {
        return null;
    }

    public boolean a() {
        int i = MathHelper.b(this.l);
        int j = MathHelper.b(this.v.b);
        int k = MathHelper.b(this.n);

        return super.a() && this.a(i, j, k) >= 0.0F;
    }
}
