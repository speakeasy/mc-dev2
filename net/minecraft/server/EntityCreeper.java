package net.minecraft.server;

public class EntityCreeper extends EntityMobs {

    int a;
    int b;
    int c = 30;
    int d = -1;
    int e = -1;

    public EntityCreeper(World world) {
        super(world);
        this.aH = "/mob/creeper.png";
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public void b_() {
        this.b = this.a;
        if (this.l.z) {
            this.a += this.d;
            if (this.a < 0) {
                this.a = 0;
            }

            if (this.a >= this.c) {
                this.a = this.c;
            }
        }

        super.b_();
    }

    protected void c() {
        if (this.e != this.d) {
            this.e = this.d;
            if (this.d > 0) {
                this.l.a(this, (byte) 4);
            } else {
                this.l.a(this, (byte) 5);
            }
        }

        this.b = this.a;
        if (this.l.z) {
            super.c();
        } else {
            if (this.a > 0 && this.d < 0) {
                --this.a;
            }

            if (this.d >= 0) {
                this.d = 2;
            }

            super.c();
            if (this.d != 1) {
                this.d = -1;
            }
        }
    }

    protected String e() {
        return "mob.creeper";
    }

    protected String f() {
        return "mob.creeperdeath";
    }

    public void f(Entity entity) {
        super.f(entity);
        if (entity instanceof EntitySkeleton) {
            this.a(Item.aU.aW + this.W.nextInt(2), 1);
        }
    }

    protected void a(Entity entity, float f1) {
        if (this.d <= 0 && f1 < 3.0F || this.d > 0 && f1 < 7.0F) {
            if (this.a == 0) {
                this.l.a(this, "random.fuse", 1.0F, 0.5F);
            }

            this.d = 1;
            ++this.a;
            if (this.a == this.c) {
                this.l.a(this, this.p, this.q, this.r, 3.0F);
                this.l();
            }

            this.ak = true;
        }
    }

    protected int g() {
        return Item.K.aW;
    }
}
