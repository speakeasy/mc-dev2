package net.minecraft.server;

public class EntityCreature extends EntityLiving {

    private PathEntity a;
    protected Entity d;
    protected boolean e = false;

    public EntityCreature(World world) {
        super(world);
    }

    protected void d() {
        this.e = false;
        float f1 = 16.0F;

        if (this.d == null) {
            this.d = this.l();
            if (this.d != null) {
                this.a = this.l.a(this, this.d, f1);
            }
        } else if (!this.d.B()) {
            this.d = null;
        } else {
            float f2 = this.d.a((Entity) this);

            if (this.i(this.d)) {
                this.a(this.d, f2);
            }
        }

        if (!this.e && this.d != null && (this.a == null || this.W.nextInt(20) == 0)) {
            this.a = this.l.a(this, this.d, f1);
        } else if (this.a == null && this.W.nextInt(80) == 0 || this.W.nextInt(80) == 0) {
            boolean flag = false;
            int i = -1;
            int j = -1;
            int k = -1;
            float f3 = -99999.0F;

            for (int l = 0; l < 10; ++l) {
                int i1 = MathHelper.b(this.p + (double) this.W.nextInt(13) - 6.0D);
                int j1 = MathHelper.b(this.q + (double) this.W.nextInt(7) - 3.0D);
                int k1 = MathHelper.b(this.r + (double) this.W.nextInt(13) - 6.0D);
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
                this.a = this.l.a(this, i, j, k, 10.0F);
            }
        }

        int l1 = MathHelper.b(this.z.b);
        boolean flag1 = this.v();
        boolean flag2 = this.x();

        this.w = 0.0F;
        if (this.a != null && this.W.nextInt(100) != 0) {
            Vec3D vec3d = this.a.a(this);
            double d1 = (double) (this.I * 2.0F);

            while (vec3d != null && vec3d.d(this.p, vec3d.b, this.r) < d1 * d1) {
                this.a.a();
                if (this.a.b()) {
                    vec3d = null;
                    this.a = null;
                } else {
                    vec3d = this.a.a(this);
                }
            }

            this.bA = false;
            if (vec3d != null) {
                double d2 = vec3d.a - this.p;
                double d3 = vec3d.c - this.r;
                double d4 = vec3d.b - (double) l1;
                float f5 = (float) (Math.atan2(d3, d2) * 180.0D / 3.1415927410125732D) - 90.0F;
                float f6 = f5 - this.v;

                for (this.by = this.bC; f6 < -180.0F; f6 += 360.0F) {
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

                this.v += f6;
                if (this.e && this.d != null) {
                    double d5 = this.d.p - this.p;
                    double d6 = this.d.r - this.r;
                    float f7 = this.v;

                    this.v = (float) (Math.atan2(d6, d5) * 180.0D / 3.1415927410125732D) - 90.0F;
                    f6 = (f7 - this.v + 90.0F) * 3.1415927F / 180.0F;
                    this.bx = -MathHelper.a(f6) * this.by * 1.0F;
                    this.by = MathHelper.b(f6) * this.by * 1.0F;
                }

                if (d4 > 0.0D) {
                    this.bA = true;
                }
            }

            if (this.d != null) {
                this.b(this.d, 30.0F);
            }

            if (this.B) {
                this.bA = true;
            }

            if (this.W.nextFloat() < 0.8F && (flag1 || flag2)) {
                this.bA = true;
            }
        } else {
            super.d();
            this.a = null;
        }
    }

    protected void a(Entity entity, float f1) {}

    protected float a(int i, int j, int k) {
        return 0.0F;
    }

    protected Entity l() {
        return null;
    }

    public boolean b() {
        int i = MathHelper.b(this.p);
        int j = MathHelper.b(this.z.b);
        int k = MathHelper.b(this.r);

        return super.b() && this.a(i, j, k) >= 0.0F;
    }
}
