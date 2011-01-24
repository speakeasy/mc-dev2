package net.minecraft.server;

public class TileEntityMobSpawner extends TileEntity {

    public int e = -1;
    public String f = "Pig";
    public double g;
    public double h = 0.0D;

    public TileEntityMobSpawner() {
        this.e = 20;
    }

    public boolean a() {
        return this.a.a((double) this.b + 0.5D, (double) this.c + 0.5D, (double) this.d + 0.5D, 16.0D) != null;
    }

    public void e() {
        this.h = this.g;
        if (this.a()) {
            double d1 = (double) ((float) this.b + this.a.l.nextFloat());
            double d2 = (double) ((float) this.c + this.a.l.nextFloat());
            double d3 = (double) ((float) this.d + this.a.l.nextFloat());

            this.a.a("smoke", d1, d2, d3, 0.0D, 0.0D, 0.0D);
            this.a.a("flame", d1, d2, d3, 0.0D, 0.0D, 0.0D);

            for (this.g += (double) (1000.0F / ((float) this.e + 200.0F)); this.g > 360.0D; this.h -= 360.0D) {
                this.g -= 360.0D;
            }

            if (this.e == -1) {
                this.b();
            }

            if (this.e > 0) {
                --this.e;
            } else {
                byte b1 = 4;

                for (int i = 0; i < b1; ++i) {
                    EntityLiving entityliving = (EntityLiving) ((EntityLiving) EntityList.a(this.f, this.a));

                    if (entityliving == null) {
                        return;
                    }

                    int j = this.a.a(entityliving.getClass(), AxisAlignedBB.b((double) this.b, (double) this.c, (double) this.d, (double) (this.b + 1), (double) (this.c + 1), (double) (this.d + 1)).b(8.0D, 4.0D, 8.0D)).size();

                    if (j >= 6) {
                        this.b();
                        return;
                    }

                    if (entityliving != null) {
                        double d4 = (double) this.b + (this.a.l.nextDouble() - this.a.l.nextDouble()) * 4.0D;
                        double d5 = (double) (this.c + this.a.l.nextInt(3) - 1);
                        double d6 = (double) this.d + (this.a.l.nextDouble() - this.a.l.nextDouble()) * 4.0D;

                        entityliving.c(d4, d5, d6, this.a.l.nextFloat() * 360.0F, 0.0F);
                        if (entityliving.a()) {
                            this.a.a((Entity) entityliving);

                            for (int k = 0; k < 20; ++k) {
                                d1 = (double) this.b + 0.5D + ((double) this.a.l.nextFloat() - 0.5D) * 2.0D;
                                d2 = (double) this.c + 0.5D + ((double) this.a.l.nextFloat() - 0.5D) * 2.0D;
                                d3 = (double) this.d + 0.5D + ((double) this.a.l.nextFloat() - 0.5D) * 2.0D;
                                this.a.a("smoke", d1, d2, d3, 0.0D, 0.0D, 0.0D);
                                this.a.a("flame", d1, d2, d3, 0.0D, 0.0D, 0.0D);
                            }

                            entityliving.O();
                            this.b();
                        }
                    }
                }

                super.e();
            }
        }
    }

    private void b() {
        this.e = 200 + this.a.l.nextInt(600);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.f = nbttagcompound.h("EntityId");
        this.e = nbttagcompound.c("Delay");
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("EntityId", this.f);
        nbttagcompound.a("Delay", (short) this.e);
    }
}
