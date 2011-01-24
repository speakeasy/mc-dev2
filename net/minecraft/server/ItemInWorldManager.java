package net.minecraft.server;

public class ItemInWorldManager {

    private World b;
    public EntityPlayer a;
    private float c;
    private float d = 0.0F;
    private int e = 0;
    private float f = 0.0F;
    private int g;
    private int h;
    private int i;

    public ItemInWorldManager(World world) {
        this.b = world;
    }

    public void a(int i, int j, int k) {
        int l = this.b.a(i, j, k);

        if (l > 0 && this.d == 0.0F) {
            Block.n[l].b(this.b, i, j, k, this.a);
        }

        if (l > 0 && Block.n[l].a(this.a) >= 1.0F) {
            this.c(i, j, k);
        }
    }

    public void a() {
        this.d = 0.0F;
        this.e = 0;
    }

    public void a(int i, int j, int k, int l) {
        if (this.e > 0) {
            --this.e;
        } else {
            if (i == this.g && j == this.h && k == this.i) {
                int i1 = this.b.a(i, j, k);

                if (i1 == 0) {
                    return;
                }

                Block block = Block.n[i1];

                this.d += block.a(this.a);
                ++this.f;
                if (this.d >= 1.0F) {
                    this.c(i, j, k);
                    this.d = 0.0F;
                    this.c = 0.0F;
                    this.f = 0.0F;
                    this.e = 5;
                }
            } else {
                this.d = 0.0F;
                this.c = 0.0F;
                this.f = 0.0F;
                this.g = i;
                this.h = j;
                this.i = k;
            }
        }
    }

    public boolean b(int i, int j, int k) {
        Block block = Block.n[this.b.a(i, j, k)];
        int l = this.b.b(i, j, k);
        boolean flag = this.b.d(i, j, k, 0);

        if (block != null && flag) {
            block.a(this.b, i, j, k, l);
        }

        return flag;
    }

    public boolean c(int i, int j, int k) {
        int l = this.b.a(i, j, k);
        int i1 = this.b.b(i, j, k);
        boolean flag = this.b(i, j, k);
        ItemStack itemstack = this.a.G();

        if (itemstack != null) {
            itemstack.a(l, i, j, k);
            if (itemstack.a == 0) {
                itemstack.a(this.a);
                this.a.H();
            }
        }

        if (flag && this.a.b(Block.n[l])) {
            Block.n[l].a_(this.b, i, j, k, i1);
        }

        return flag;
    }

    public boolean a(EntityPlayer entityplayer, World world, ItemStack itemstack, int i, int j, int k, int l) {
        int i1 = world.a(i, j, k);

        return i1 > 0 && Block.n[i1].a(world, i, j, k, entityplayer) ? true : (itemstack == null ? false : itemstack.a(entityplayer, world, i, j, k, l));
    }
}
