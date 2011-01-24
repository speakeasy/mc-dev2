package net.minecraft.server;

public class EntityItem extends Entity {

    public ItemStack a;
    private int e;
    public int b = 0;
    public int c;
    private int f = 5;
    public float d = (float) (Math.random() * 3.141592653589793D * 2.0D);

    public EntityItem(World world, double d1, double d2, double d3, ItemStack itemstack) {
        super(world);
        this.a(0.25F, 0.25F);
        this.H = this.J / 2.0F;
        this.a(d1, d2, d3);
        this.a = itemstack;
        this.v = (float) (Math.random() * 360.0D);
        this.s = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
        this.t = 0.20000000298023224D;
        this.u = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
        this.M = false;
    }

    public EntityItem(World world) {
        super(world);
        this.a(0.25F, 0.25F);
        this.H = this.J / 2.0F;
    }

    public void b_() {
        super.b_();
        if (this.c > 0) {
            --this.c;
        }

        this.m = this.p;
        this.n = this.q;
        this.o = this.r;
        this.t -= 0.03999999910593033D;
        if (this.l.c(MathHelper.b(this.p), MathHelper.b(this.q), MathHelper.b(this.r)) == Material.g) {
            this.t = 0.20000000298023224D;
            this.s = (double) ((this.W.nextFloat() - this.W.nextFloat()) * 0.2F);
            this.u = (double) ((this.W.nextFloat() - this.W.nextFloat()) * 0.2F);
            this.l.a(this, "random.fizz", 0.4F, 2.0F + this.W.nextFloat() * 0.4F);
        }

        this.g(this.p, this.q, this.r);
        this.r();
        this.c(this.s, this.t, this.u);
        float f1 = 0.98F;

        if (this.A) {
            f1 = 0.58800006F;
            int i = this.l.a(MathHelper.b(this.p), MathHelper.b(this.z.b) - 1, MathHelper.b(this.r));

            if (i > 0) {
                f1 = Block.m[i].bt * 0.98F;
            }
        }

        this.s *= (double) f1;
        this.t *= 0.9800000190734863D;
        this.u *= (double) f1;
        if (this.A) {
            this.t *= -0.5D;
        }

        ++this.e;
        ++this.b;
        if (this.b >= 6000) {
            this.l();
        }
    }

    public boolean r() {
        return this.l.a(this.z, Material.f, this);
    }

    private boolean g(double d1, double d2, double d3) {
        int i = MathHelper.b(d1);
        int j = MathHelper.b(d2);
        int k = MathHelper.b(d3);
        double d4 = d1 - (double) i;
        double d5 = d2 - (double) j;
        double d6 = d3 - (double) k;

        if (Block.o[this.l.a(i, j, k)]) {
            boolean flag = !Block.o[this.l.a(i - 1, j, k)];
            boolean flag1 = !Block.o[this.l.a(i + 1, j, k)];
            boolean flag2 = !Block.o[this.l.a(i, j - 1, k)];
            boolean flag3 = !Block.o[this.l.a(i, j + 1, k)];
            boolean flag4 = !Block.o[this.l.a(i, j, k - 1)];
            boolean flag5 = !Block.o[this.l.a(i, j, k + 1)];
            byte b1 = -1;
            double d7 = 9999.0D;

            if (flag && d4 < d7) {
                d7 = d4;
                b1 = 0;
            }

            if (flag1 && 1.0D - d4 < d7) {
                d7 = 1.0D - d4;
                b1 = 1;
            }

            if (flag2 && d5 < d7) {
                d7 = d5;
                b1 = 2;
            }

            if (flag3 && 1.0D - d5 < d7) {
                d7 = 1.0D - d5;
                b1 = 3;
            }

            if (flag4 && d6 < d7) {
                d7 = d6;
                b1 = 4;
            }

            if (flag5 && 1.0D - d6 < d7) {
                d7 = 1.0D - d6;
                b1 = 5;
            }

            float f1 = this.W.nextFloat() * 0.2F + 0.1F;

            if (b1 == 0) {
                this.s = (double) (-f1);
            }

            if (b1 == 1) {
                this.s = (double) f1;
            }

            if (b1 == 2) {
                this.t = (double) (-f1);
            }

            if (b1 == 3) {
                this.t = (double) f1;
            }

            if (b1 == 4) {
                this.u = (double) (-f1);
            }

            if (b1 == 5) {
                this.u = (double) f1;
            }
        }

        return false;
    }

    protected void b(int i) {
        this.a((Entity) null, i);
    }

    public boolean a(Entity entity, int i) {
        this.u();
        this.f -= i;
        if (this.f <= 0) {
            this.l();
        }

        return false;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Health", (short) ((byte) this.f));
        nbttagcompound.a("Age", (short) this.b);
        nbttagcompound.a("Item", this.a.a(new NBTTagCompound()));
    }

    public void b(NBTTagCompound nbttagcompound) {
        this.f = nbttagcompound.c("Health") & 255;
        this.b = nbttagcompound.c("Age");
        NBTTagCompound nbttagcompound1 = nbttagcompound.j("Item");

        this.a = new ItemStack(nbttagcompound1);
    }

    public void b(EntityPlayer entityplayer) {
        if (!this.l.z) {
            int i = this.a.a;

            if (this.c == 0 && entityplayer.al.a(this.a)) {
                this.l.a(this, "random.pop", 0.2F, ((this.W.nextFloat() - this.W.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                entityplayer.c(this, i);
                this.l();
            }
        }
    }
}
