package net.minecraft.server;

public class EntitySpider extends EntityMobs {

    public EntitySpider(World world) {
        super(world);
        this.aH = "/mob/spider.png";
        this.a(1.4F, 0.9F);
        this.bu = 0.8F;
    }

    public double j() {
        return (double) this.J * 0.75D - 0.5D;
    }

    protected Entity k() {
        float f1 = this.b(1.0F);

        if (f1 < 0.5F) {
            double d1 = 16.0D;

            return this.l.a(this, d1);
        } else {
            return null;
        }
    }

    protected String d() {
        return "mob.spider";
    }

    protected String e() {
        return "mob.spider";
    }

    protected String f() {
        return "mob.spiderdeath";
    }

    protected void a(Entity entity, float f1) {
        float f2 = this.b(1.0F);

        if (f2 > 0.5F && this.W.nextInt(100) == 0) {
            this.aj = null;
        } else {
            if (f1 > 2.0F && f1 < 6.0F && this.W.nextInt(10) == 0) {
                if (this.A) {
                    double d1 = entity.p - this.p;
                    double d2 = entity.r - this.r;
                    float f3 = MathHelper.a(d1 * d1 + d2 * d2);

                    this.s = d1 / (double) f3 * 0.5D * 0.800000011920929D + this.s * 0.20000000298023224D;
                    this.u = d2 / (double) f3 * 0.5D * 0.800000011920929D + this.u * 0.20000000298023224D;
                    this.t = 0.4000000059604645D;
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
        return Item.I.aW;
    }
}
