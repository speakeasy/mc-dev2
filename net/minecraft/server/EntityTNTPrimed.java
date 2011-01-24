package net.minecraft.server;

public class EntityTNTPrimed extends Entity {

    public int a;

    public EntityTNTPrimed(World world) {
        super(world);
        this.a = 0;
        this.i = true;
        this.a(0.98F, 0.98F);
        this.H = this.J / 2.0F;
    }

    public EntityTNTPrimed(World world, double d1, double d2, double d3) {
        this(world);
        this.a(d1, d2, d3);
        float f1 = (float) (Math.random() * 3.1415927410125732D * 2.0D);

        this.s = (double) (-MathHelper.a(f1 * 3.1415927F / 180.0F) * 0.02F);
        this.t = 0.20000000298023224D;
        this.u = (double) (-MathHelper.b(f1 * 3.1415927F / 180.0F) * 0.02F);
        this.M = false;
        this.a = 80;
        this.m = d1;
        this.n = d2;
        this.o = d3;
    }

    public boolean c_() {
        return !this.G;
    }

    public void b_() {
        this.m = this.p;
        this.n = this.q;
        this.o = this.r;
        this.t -= 0.03999999910593033D;
        this.c(this.s, this.t, this.u);
        this.s *= 0.9800000190734863D;
        this.t *= 0.9800000190734863D;
        this.u *= 0.9800000190734863D;
        if (this.A) {
            this.s *= 0.699999988079071D;
            this.u *= 0.699999988079071D;
            this.t *= -0.5D;
        }

        if (this.a-- <= 0) {
            this.l();
            this.c();
        } else {
            this.l.a("smoke", this.p, this.q + 0.5D, this.r, 0.0D, 0.0D, 0.0D);
        }
    }

    private void c() {
        float f1 = 4.0F;

        this.l.a((Entity) null, this.p, this.q, this.r, f1);
    }

    protected void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Fuse", (byte) this.a);
    }

    protected void b(NBTTagCompound nbttagcompound) {
        this.a = nbttagcompound.b("Fuse");
    }
}
