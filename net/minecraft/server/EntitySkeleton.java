package net.minecraft.server;

public class EntitySkeleton extends EntityMobs {

    private static final ItemStack a = new ItemStack(Item.i, 1);

    public EntitySkeleton(World world) {
        super(world);
        this.aP = "/mob/skeleton.png";
    }

    protected String e() {
        return "mob.skeleton";
    }

    protected String f() {
        return "mob.skeletonhurt";
    }

    protected String g() {
        return "mob.skeletonhurt";
    }

    public void o() {
        if (this.l.b()) {
            float f1 = this.b(1.0F);

            if (f1 > 0.5F && this.l.i(MathHelper.b(this.p), MathHelper.b(this.q), MathHelper.b(this.r)) && this.W.nextFloat() * 30.0F < (f1 - 0.4F) * 2.0F) {
                this.Z = 300;
            }
        }

        super.o();
    }

    protected void a(Entity entity, float f1) {
        if (f1 < 10.0F) {
            double d1 = entity.p - this.p;
            double d2 = entity.r - this.r;

            if (this.bf == 0) {
                EntityArrow entityarrow = new EntityArrow(this.l, this);

                ++entityarrow.q;
                double d3 = entity.q - 0.20000000298023224D - entityarrow.q;
                float f2 = MathHelper.a(d1 * d1 + d2 * d2) * 0.2F;

                this.l.a(this, "random.bow", 1.0F, 1.0F / (this.W.nextFloat() * 0.4F + 0.8F));
                this.l.a((Entity) entityarrow);
                entityarrow.a(d1, d3 + (double) f2, d2, 0.6F, 12.0F);
                this.bf = 30;
            }

            this.v = (float) (Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.e = true;
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected int h() {
        return Item.j.ba;
    }

    protected void g_() {
        int i = this.W.nextInt(3);

        int j;

        for (j = 0; j < i; ++j) {
            this.a(Item.j.ba, 1);
        }

        i = this.W.nextInt(3);

        for (j = 0; j < i; ++j) {
            this.a(Item.aV.ba, 1);
        }
    }
}
