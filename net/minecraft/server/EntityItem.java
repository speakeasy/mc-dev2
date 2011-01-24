package net.minecraft.server;

public class EntityItem extends Entity {

    public ItemStack a;
    private int af;
    public int b = 0;
    public int ad;
    private int ag = 5;
    public float ae = (float) (Math.random() * 3.141592653589793D * 2.0D);

    public EntityItem(World world, double d1, double d2, double d3, ItemStack itemstack) {
        super(world);
        this.a(0.25F, 0.25F);
        this.C = this.E / 2.0F;
        this.a(d1, d2, d3);
        this.a = itemstack;
        this.r = (float) (Math.random() * 360.0D);
        this.o = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
        this.p = 0.20000000298023224D;
        this.q = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
        this.H = false;
    }

    public EntityItem(World world) {
        super(world);
        this.a(0.25F, 0.25F);
        this.C = this.E / 2.0F;
    }

    public void b_() {
        super.b_();
        if (this.ad > 0) {
            --this.ad;
        }

        this.i = this.l;
        this.j = this.m;
        this.k = this.n;
        this.p -= 0.03999999910593033D;
        if (this.h.c(MathHelper.b(this.l), MathHelper.b(this.m), MathHelper.b(this.n)) == Material.g) {
            this.p = 0.20000000298023224D;
            this.o = (double) ((this.R.nextFloat() - this.R.nextFloat()) * 0.2F);
            this.q = (double) ((this.R.nextFloat() - this.R.nextFloat()) * 0.2F);
            this.h.a(this, "random.fizz", 0.4F, 2.0F + this.R.nextFloat() * 0.4F);
        }

        this.g(this.l, this.m, this.n);
        this.o();
        this.c(this.o, this.p, this.q);
        float f1 = 0.98F;

        if (this.w) {
            f1 = 0.58800006F;
            int i = this.h.a(MathHelper.b(this.l), MathHelper.b(this.v.b) - 1, MathHelper.b(this.n));

            if (i > 0) {
                f1 = Block.n[i].bo * 0.98F;
            }
        }

        this.o *= (double) f1;
        this.p *= 0.9800000190734863D;
        this.q *= (double) f1;
        if (this.w) {
            this.p *= -0.5D;
        }

        ++this.af;
        ++this.b;
        if (this.b >= 6000) {
            this.j();
        }
    }

    public boolean o() {
        return this.h.a(this.v, Material.f, this);
    }

    private boolean g(double d1, double d2, double d3) {
        int i = MathHelper.b(d1);
        int j = MathHelper.b(d2);
        int k = MathHelper.b(d3);
        double d4 = d1 - (double) i;
        double d5 = d2 - (double) j;
        double d6 = d3 - (double) k;

        if (Block.p[this.h.a(i, j, k)]) {
            boolean flag = !Block.p[this.h.a(i - 1, j, k)];
            boolean flag1 = !Block.p[this.h.a(i + 1, j, k)];
            boolean flag2 = !Block.p[this.h.a(i, j - 1, k)];
            boolean flag3 = !Block.p[this.h.a(i, j + 1, k)];
            boolean flag4 = !Block.p[this.h.a(i, j, k - 1)];
            boolean flag5 = !Block.p[this.h.a(i, j, k + 1)];
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

            float f1 = this.R.nextFloat() * 0.2F + 0.1F;

            if (b1 == 0) {
                this.o = (double) (-f1);
            }

            if (b1 == 1) {
                this.o = (double) f1;
            }

            if (b1 == 2) {
                this.p = (double) (-f1);
            }

            if (b1 == 3) {
                this.p = (double) f1;
            }

            if (b1 == 4) {
                this.q = (double) (-f1);
            }

            if (b1 == 5) {
                this.q = (double) f1;
            }
        }

        return false;
    }

    protected void b(int i) {
        this.a((Entity) null, i);
    }

    public boolean a(Entity entity, int i) {
        this.ag -= i;
        if (this.ag <= 0) {
            this.j();
        }

        return false;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Health", (short) ((byte) this.ag));
        nbttagcompound.a("Age", (short) this.b);
        nbttagcompound.a("Item", this.a.a(new NBTTagCompound()));
    }

    public void b(NBTTagCompound nbttagcompound) {
        this.ag = nbttagcompound.c("Health") & 255;
        this.b = nbttagcompound.c("Age");
        NBTTagCompound nbttagcompound1 = nbttagcompound.j("Item");

        this.a = new ItemStack(nbttagcompound1);
    }

    public void a(EntityPlayer entityplayer) {
        if (!this.h.x) {
            int i = this.a.a;

            if (this.ad == 0 && entityplayer.aj.a(this.a)) {
                this.h.a(this, "random.pop", 0.2F, ((this.R.nextFloat() - this.R.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                entityplayer.c(this, i);
                this.j();
            }
        }
    }
}
