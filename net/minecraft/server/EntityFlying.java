package net.minecraft.server;

public class EntityFlying extends EntityLiving {

    public EntityFlying(World world) {
        super(world);
    }

    protected void a(float f1) {}

    public void c(float f1, float f2) {
        double d1;

        if (this.r()) {
            this.a(f1, f2, 0.02F);
            this.c(this.s, this.t, this.u);
            this.s *= 0.800000011920929D;
            this.t *= 0.800000011920929D;
            this.u *= 0.800000011920929D;
        } else if (this.t()) {
            d1 = this.q;
            this.a(f1, f2, 0.02F);
            this.c(this.s, this.t, this.u);
            this.s *= 0.5D;
            this.t *= 0.5D;
            this.u *= 0.5D;
        } else {
            float f3 = 0.91F;

            if (this.A) {
                f3 = 0.54600006F;
                int i = this.l.a(MathHelper.b(this.p), MathHelper.b(this.z.b) - 1, MathHelper.b(this.r));

                if (i > 0) {
                    f3 = Block.n[i].bu * 0.91F;
                }
            }

            float f4 = 0.16277136F / (f3 * f3 * f3);

            this.a(f1, f2, this.A ? 0.1F * f4 : 0.02F);
            f3 = 0.91F;
            if (this.A) {
                f3 = 0.54600006F;
                int j = this.l.a(MathHelper.b(this.p), MathHelper.b(this.z.b) - 1, MathHelper.b(this.r));

                if (j > 0) {
                    f3 = Block.n[j].bu * 0.91F;
                }
            }

            this.c(this.s, this.t, this.u);
            this.s *= (double) f3;
            this.t *= (double) f3;
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
        return false;
    }
}
