package net.minecraft.server;

import java.util.Random;

public class BlockCake extends Block {

    protected BlockCake(int i, int j) {
        super(i, j, Material.y);
        this.a(true);
    }

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {
        int l = iblockaccess.b(i, j, k);
        float f1 = 0.0625F;
        float f2 = (float) (1 + l * 2) / 16.0F;
        float f3 = 0.5F;

        this.a(f2, 0.0F, f1, 1.0F - f1, f3, 1.0F - f1);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        int l = world.b(i, j, k);
        float f1 = 0.0625F;
        float f2 = (float) (1 + l * 2) / 16.0F;
        float f3 = 0.5F;

        return AxisAlignedBB.b((double) ((float) i + f2), (double) j, (double) ((float) k + f1), (double) ((float) (i + 1) - f1), (double) ((float) j + f3 - f1), (double) ((float) (k + 1) - f1));
    }

    public int a(int i) {
        return i == 1 ? this.bh : (i == 0 ? this.bh + 3 : this.bh + 1);
    }

    public boolean a() {
        return false;
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        this.c(world, i, j, k, entityplayer);
        return true;
    }

    public void b(World world, int i, int j, int k, EntityPlayer entityplayer) {
        this.c(world, i, j, k, entityplayer);
    }

    private void c(World world, int i, int j, int k, EntityPlayer entityplayer) {
        if (entityplayer.aZ < 20) {
            entityplayer.d(3);
            int l = world.b(i, j, k) + 1;

            if (l >= 6) {
                world.e(i, j, k, 0);
            } else {
                world.c(i, j, k, l);
                world.h(i, j, k);
            }
        }
    }

    public boolean a(World world, int i, int j, int k) {
        return !super.a(world, i, j, k) ? false : this.f(world, i, j, k);
    }

    public void b(World world, int i, int j, int k, int l) {
        if (!this.f(world, i, j, k)) {
            this.a_(world, i, j, k, world.b(i, j, k));
            world.e(i, j, k, 0);
        }
    }

    public boolean f(World world, int i, int j, int k) {
        return world.c(i, j - 1, k).a();
    }

    public int a(Random random) {
        return 0;
    }

    public int a(int i, Random random) {
        return 0;
    }
}
