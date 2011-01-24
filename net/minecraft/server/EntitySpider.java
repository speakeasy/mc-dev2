package net.minecraft.server;

public class EntitySpider extends EntityMobs {

    public EntitySpider(World world) {
        super(world);
        this.aC = "/mob/spider.png";
        this.a(1.4F, 0.9F);
        this.bi = 0.8F;
    }

    public double h() {
        return (double) this.E * 0.75D - 0.5D;
    }

    protected Entity i() {
        float f1 = this.b(1.0F);

        if (f1 < 0.5F) {
            double d1 = 16.0D;

            return this.h.a(this, d1);
        } else {
            return null;
        }
    }

    protected String c() {
        return "mob.spider";
    }

    protected String d() {
        return "mob.spider";
    }

    protected String e() {
        return "mob.spiderdeath";
    }

    protected void a(Entity entity, float f1) {
        float f2 = this.b(1.0F);

        if (f2 > 0.5F && this.R.nextInt(100) == 0) {
            this.ag = null;
        } else {
            if (f1 > 2.0F && f1 < 6.0F && this.R.nextInt(10) == 0) {
                if (this.w) {
                    double d1 = entity.l - this.l;
                    double d2 = entity.n - this.n;
                    float f3 = MathHelper.a(d1 * d1 + d2 * d2);

                    this.o = d1 / (double) f3 * 0.5D * 0.800000011920929D + this.o * 0.20000000298023224D;
                    this.q = d2 / (double) f3 * 0.5D * 0.800000011920929D + this.q * 0.20000000298023224D;
                    this.p = 0.4000000059604645D;
                }
            } else {
                super.a(entity, f1);
            }
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected int g() {
        return Item.I.aS;
    }
}
