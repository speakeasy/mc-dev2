package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;

public class EntityPainting extends Entity {

    private int f;
    public int a;
    public int b;
    public int c;
    public int d;
    public EnumArt e;

    public EntityPainting(World world) {
        super(world);
        this.f = 0;
        this.a = 0;
        this.H = 0.0F;
        this.a(0.5F, 0.5F);
    }

    public EntityPainting(World world, int i, int j, int k, int l) {
        this(world);
        this.b = i;
        this.c = j;
        this.d = k;
        ArrayList arraylist = new ArrayList();
        EnumArt[] aenumart = EnumArt.values();
        int i1 = aenumart.length;

        for (int j1 = 0; j1 < i1; ++j1) {
            EnumArt enumart = aenumart[j1];

            this.e = enumart;
            this.a(l);
            if (this.d()) {
                arraylist.add(enumart);
            }
        }

        if (arraylist.size() > 0) {
            this.e = (EnumArt) arraylist.get(this.W.nextInt(arraylist.size()));
        }

        this.a(l);
    }

    protected void a() {}

    public void a(int i) {
        this.a = i;
        this.x = this.v = (float) (i * 90);
        float f1 = (float) this.e.z;
        float f2 = (float) this.e.A;
        float f3 = (float) this.e.z;

        if (i != 0 && i != 2) {
            f1 = 0.5F;
        } else {
            f3 = 0.5F;
        }

        f1 /= 32.0F;
        f2 /= 32.0F;
        f3 /= 32.0F;
        float f4 = (float) this.b + 0.5F;
        float f5 = (float) this.c + 0.5F;
        float f6 = (float) this.d + 0.5F;
        float f7 = 0.5625F;

        if (i == 0) {
            f6 -= f7;
        }

        if (i == 1) {
            f4 -= f7;
        }

        if (i == 2) {
            f6 += f7;
        }

        if (i == 3) {
            f4 += f7;
        }

        if (i == 0) {
            f4 -= this.d(this.e.z);
        }

        if (i == 1) {
            f6 += this.d(this.e.z);
        }

        if (i == 2) {
            f4 += this.d(this.e.z);
        }

        if (i == 3) {
            f6 -= this.d(this.e.z);
        }

        f5 += this.d(this.e.A);
        this.a((double) f4, (double) f5, (double) f6);
        float f8 = -0.00625F;

        this.z.c((double) (f4 - f1 - f8), (double) (f5 - f2 - f8), (double) (f6 - f3 - f8), (double) (f4 + f1 + f8), (double) (f5 + f2 + f8), (double) (f6 + f3 + f8));
    }

    private float d(int i) {
        return i == 32 ? 0.5F : (i == 64 ? 0.5F : 0.0F);
    }

    public void b_() {
        if (this.f++ == 100 && !this.l.z) {
            this.f = 0;
            if (!this.d()) {
                this.q();
                this.l.a((Entity) (new EntityItem(this.l, this.p, this.q, this.r, new ItemStack(Item.aq))));
            }
        }
    }

    public boolean d() {
        if (this.l.a((Entity) this, this.z).size() > 0) {
            return false;
        } else {
            int i = this.e.z / 16;
            int j = this.e.A / 16;
            int k = this.b;
            int l = this.c;
            int i1 = this.d;

            if (this.a == 0) {
                k = MathHelper.b(this.p - (double) ((float) this.e.z / 32.0F));
            }

            if (this.a == 1) {
                i1 = MathHelper.b(this.r - (double) ((float) this.e.z / 32.0F));
            }

            if (this.a == 2) {
                k = MathHelper.b(this.p - (double) ((float) this.e.z / 32.0F));
            }

            if (this.a == 3) {
                i1 = MathHelper.b(this.r - (double) ((float) this.e.z / 32.0F));
            }

            l = MathHelper.b(this.q - (double) ((float) this.e.A / 32.0F));

            int j1;

            for (int k1 = 0; k1 < i; ++k1) {
                for (j1 = 0; j1 < j; ++j1) {
                    Material material;

                    if (this.a != 0 && this.a != 2) {
                        material = this.l.c(this.b, l + j1, i1 + k1);
                    } else {
                        material = this.l.c(k + k1, l + j1, this.d);
                    }

                    if (!material.a()) {
                        return false;
                    }
                }
            }

            List list = this.l.b((Entity) this, this.z);

            for (j1 = 0; j1 < list.size(); ++j1) {
                if (list.get(j1) instanceof EntityPainting) {
                    return false;
                }
            }

            return true;
        }
    }

    public boolean c_() {
        return true;
    }

    public boolean a(Entity entity, int i) {
        if (!this.G && !this.l.z) {
            this.q();
            this.y();
            this.l.a((Entity) (new EntityItem(this.l, this.p, this.q, this.r, new ItemStack(Item.aq))));
        }

        return true;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Dir", (byte) this.a);
        nbttagcompound.a("Motive", this.e.y);
        nbttagcompound.a("TileX", this.b);
        nbttagcompound.a("TileY", this.c);
        nbttagcompound.a("TileZ", this.d);
    }

    public void b(NBTTagCompound nbttagcompound) {
        this.a = nbttagcompound.b("Dir");
        this.b = nbttagcompound.d("TileX");
        this.c = nbttagcompound.d("TileY");
        this.d = nbttagcompound.d("TileZ");
        String s = nbttagcompound.h("Motive");
        EnumArt[] aenumart = EnumArt.values();
        int i = aenumart.length;

        for (int j = 0; j < i; ++j) {
            EnumArt enumart = aenumart[j];

            if (enumart.y.equals(s)) {
                this.e = enumart;
            }
        }

        if (this.e == null) {
            this.e = EnumArt.a;
        }

        this.a(this.a);
    }
}
