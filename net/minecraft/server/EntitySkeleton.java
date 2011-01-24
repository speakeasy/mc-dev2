package net.minecraft.server;

public class EntitySkeleton extends EntityMobs {

    public EntitySkeleton(World world) {
        super(world);
        this.aC = "/mob/skeleton.png";
    }

    protected String c() {
        return "mob.skeleton";
    }

    protected String d() {
        return "mob.skeletonhurt";
    }

    protected String e() {
        return "mob.skeletonhurt";
    }

    public void y() {
        if (this.h.a()) {
            float f1 = this.b(1.0F);

            if (f1 > 0.5F && this.h.g(MathHelper.b(this.l), MathHelper.b(this.m), MathHelper.b(this.n)) && this.R.nextFloat() * 30.0F < (f1 - 0.4F) * 2.0F) {
                this.U = 300;
            }
        }

        super.y();
    }

    protected void a(Entity entity, float f1) {
        if (f1 < 10.0F) {
            double d1 = entity.l - this.l;
            double d2 = entity.n - this.n;

            if (this.aS == 0) {
                EntityArrow entityarrow = new EntityArrow(this.h, this);

                ++entityarrow.m;
                double d3 = entity.m - 0.20000000298023224D - entityarrow.m;
                float f2 = MathHelper.a(d1 * d1 + d2 * d2) * 0.2F;

                this.h.a(this, "random.bow", 1.0F, 1.0F / (this.R.nextFloat() * 0.4F + 0.8F));
                this.h.a((Entity) entityarrow);
                entityarrow.a(d1, d3 + (double) f2, d2, 0.6F, 12.0F);
                this.aS = 30;
            }

            this.r = (float) (Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.ah = true;
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected int g() {
        return Item.j.aS;
    }
}
