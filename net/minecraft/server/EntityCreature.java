package net.minecraft.server;

public class EntityCreature extends EntityLiving {

    private PathEntity a;
    protected Entity f;
    protected boolean ai = false;

    public EntityCreature(World world) {
        super(world);
    }

    protected void c() {
        this.ai = false;
        float f1 = 16.0F;

        if (this.f == null) {
            this.f = this.k();
            if (this.f != null) {
                this.a = this.l.a(this, this.f, f1);
            }
        } else if (!this.f.w()) {
            this.f = null;
        } else {
            float f2 = this.f.a((Entity) this);

            if (this.g(this.f)) {
                this.a(this.f, f2);
            }
        }

        if (!this.ai && this.f != null && (this.a == null || this.V.nextInt(20) == 0)) {
            this.a = this.l.a(this, this.f, f1);
        } else if (this.a == null && this.V.nextInt(80) == 0 || this.V.nextInt(80) == 0) {
            boolean flag = false;
            int i = -1;
            int j = -1;
            int k = -1;
            float f3 = -99999.0F;

            for (int l = 0; l < 10; ++l) {
                int i1 = MathHelper.b(this.p + (double) this.V.nextInt(13) - 6.0D);
                int j1 = MathHelper.b(this.q + (double) this.V.nextInt(7) - 3.0D);
                int k1 = MathHelper.b(this.r + (double) this.V.nextInt(13) - 6.0D);
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
        boolean flag1 = this.r();
        boolean flag2 = this.t();

        this.w = 0.0F;
        if (this.a != null && this.V.nextInt(100) != 0) {
            Vec3D vec3d = this.a.a(this);
            double d1 = (double) (this.H * 2.0F);

            while (vec3d != null && vec3d.d(this.p, vec3d.b, this.r) < d1 * d1) {
                this.a.a();
                if (this.a.b()) {
                    vec3d = null;
                    this.a = null;
                } else {
                    vec3d = this.a.a(this);
                }
            }

            this.bp = false;
            if (vec3d != null) {
                double d2 = vec3d.a - this.p;
                double d3 = vec3d.c - this.r;
                double d4 = vec3d.b - (double) l1;
                float f5 = (float) (Math.atan2(d3, d2) * 180.0D / 3.1415927410125732D) - 90.0F;
                float f6 = f5 - this.v;

                for (this.bn = this.br; f6 < -180.0F; f6 += 360.0F) {
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
                if (this.ai && this.f != null) {
                    double d5 = this.f.p - this.p;
                    double d6 = this.f.r - this.r;
                    float f7 = this.v;

                    this.v = (float) (Math.atan2(d6, d5) * 180.0D / 3.1415927410125732D) - 90.0F;
                    f6 = (f7 - this.v + 90.0F) * 3.1415927F / 180.0F;
                    this.bm = -MathHelper.a(f6) * this.bn * 1.0F;
                    this.bn = MathHelper.b(f6) * this.bn * 1.0F;
                }

                if (d4 > 0.0D) {
                    this.bp = true;
                }
            }

            if (this.f != null) {
                this.b(this.f, 30.0F);
            }

            if (this.B) {
                this.bp = true;
            }

            if (this.V.nextFloat() < 0.8F && (flag1 || flag2)) {
                this.bp = true;
            }
        } else {
            super.c();
            this.a = null;
        }
    }

    protected void a(Entity entity, float f1) {}

    protected float a(int i, int j, int k) {
        return 0.0F;
    }

    protected Entity k() {
        return null;
    }

    public boolean a() {
        int i = MathHelper.b(this.p);
        int j = MathHelper.b(this.z.b);
        int k = MathHelper.b(this.r);

        return super.a() && this.a(i, j, k) >= 0.0F;
    }
}
