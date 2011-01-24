package net.minecraft.server;

public class EntitySlime extends EntityLiving implements IMobs {

    public float a;
    public float b;
    private int d = 0;
    public int c = 1;

    public EntitySlime(World world) {
        super(world);
        this.aP = "/mob/slime.png";
        this.c = 1 << this.W.nextInt(3);
        this.H = 0.0F;
        this.d = this.W.nextInt(20) + 10;
        this.a(this.c);
    }

    public void a(int i) {
        this.c = i;
        this.a(0.6F * (float) i, 0.6F * (float) i);
        this.aZ = i * i;
        this.a(this.p, this.q, this.r);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Size", this.c - 1);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        this.c = nbttagcompound.d("Size") + 1;
    }

    public void b_() {
        this.b = this.a;
        boolean flag = this.A;

        super.b_();
        if (this.A && !flag) {
            for (int i = 0; i < this.c * 8; ++i) {
                float f1 = this.W.nextFloat() * 3.1415927F * 2.0F;
                float f2 = this.W.nextFloat() * 0.5F + 0.5F;
                float f3 = MathHelper.a(f1) * (float) this.c * 0.5F * f2;
                float f4 = MathHelper.b(f1) * (float) this.c * 0.5F * f2;

                this.l.a("slime", this.p + (double) f3, this.z.b, this.r + (double) f4, 0.0D, 0.0D, 0.0D);
            }

            if (this.c > 2) {
                this.l.a(this, "mob.slime", this.i(), ((this.W.nextFloat() - this.W.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }

            this.a = -0.5F;
        }

        this.a *= 0.6F;
    }

    protected void d() {
        EntityPlayer entityplayer = this.l.a(this, 16.0D);

        if (entityplayer != null) {
            this.b(entityplayer, 10.0F);
        }

        if (this.A && this.d-- <= 0) {
            this.d = this.W.nextInt(20) + 10;
            if (entityplayer != null) {
                this.d /= 3;
            }

            this.bA = true;
            if (this.c > 1) {
                this.l.a(this, "mob.slime", this.i(), ((this.W.nextFloat() - this.W.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }

            this.a = 1.0F;
            this.bx = 1.0F - this.W.nextFloat() * 2.0F;
            this.by = (float) (1 * this.c);
        } else {
            this.bA = false;
            if (this.A) {
                this.bx = this.by = 0.0F;
            }
        }
    }

    public void q() {
        if (this.c > 1 && this.aZ == 0) {
            for (int i = 0; i < 4; ++i) {
                float f1 = ((float) (i % 2) - 0.5F) * (float) this.c / 4.0F;
                float f2 = ((float) (i / 2) - 0.5F) * (float) this.c / 4.0F;
                EntitySlime entityslime = new EntitySlime(this.l);

                entityslime.a(this.c / 2);
                entityslime.c(this.p + (double) f1, this.q + 0.5D, this.r + (double) f2, this.W.nextFloat() * 360.0F, 0.0F);
                this.l.a((Entity) entityslime);
            }
        }

        super.q();
    }

    public void b(EntityPlayer entityplayer) {
        if (this.c > 1 && this.i(entityplayer) && (double) this.a(entityplayer) < 0.6D * (double) this.c && entityplayer.a(this, this.c)) {
            this.l.a(this, "mob.slimeattack", 1.0F, (this.W.nextFloat() - this.W.nextFloat()) * 0.2F + 1.0F);
        }
    }

    protected String f() {
        return "mob.slime";
    }

    protected String g() {
        return "mob.slime";
    }

    protected int h() {
        return this.c == 1 ? Item.aK.ba : 0;
    }

    public boolean b() {
        Chunk chunk = this.l.b(MathHelper.b(this.p), MathHelper.b(this.r));

        return (this.c == 1 || this.l.k > 0) && this.W.nextInt(10) == 0 && chunk.a(987234911L).nextInt(10) == 0 && this.q < 16.0D;
    }

    protected float i() {
        return 0.6F;
    }
}
