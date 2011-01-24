package net.minecraft.server;

import java.util.Random;

public class BlockCrops extends BlockFlower {

    protected BlockCrops(int i, int j) {
        super(i, j);
        this.bg = j;
        this.a(true);
        float f1 = 0.5F;

        this.a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 0.25F, 0.5F + f1);
    }

    protected boolean b(int i) {
        return i == Block.aA.bh;
    }

    public void a(World world, int i, int j, int k, Random random) {
        super.a(world, i, j, k, random);
        if (world.h(i, j + 1, k) >= 9) {
            int l = world.b(i, j, k);

            if (l < 7) {
                float f1 = this.h(world, i, j, k);

                if (random.nextInt((int) (100.0F / f1)) == 0) {
                    ++l;
                    world.b(i, j, k, l);
                }
            }
        }
    }

    private float h(World world, int i, int j, int k) {
        float f1 = 1.0F;
        int l = world.a(i, j, k - 1);
        int i1 = world.a(i, j, k + 1);
        int j1 = world.a(i - 1, j, k);
        int k1 = world.a(i + 1, j, k);
        int l1 = world.a(i - 1, j, k - 1);
        int i2 = world.a(i + 1, j, k - 1);
        int j2 = world.a(i + 1, j, k + 1);
        int k2 = world.a(i - 1, j, k + 1);
        boolean flag = j1 == this.bh || k1 == this.bh;
        boolean flag1 = l == this.bh || i1 == this.bh;
        boolean flag2 = l1 == this.bh || i2 == this.bh || j2 == this.bh || k2 == this.bh;

        for (int l2 = i - 1; l2 <= i + 1; ++l2) {
            for (int i3 = k - 1; i3 <= k + 1; ++i3) {
                int j3 = world.a(l2, j - 1, i3);
                float f2 = 0.0F;

                if (j3 == Block.aA.bh) {
                    f2 = 1.0F;
                    if (world.b(l2, j - 1, i3) > 0) {
                        f2 = 3.0F;
                    }
                }

                if (l2 != i || i3 != k) {
                    f2 /= 4.0F;
                }

                f1 += f2;
            }
        }

        if (flag2 || flag && flag1) {
            f1 /= 2.0F;
        }

        return f1;
    }

    public void a(World world, int i, int j, int k, int l) {
        super.a(world, i, j, k, l);

        for (int i1 = 0; i1 < 3; ++i1) {
            if (world.l.nextInt(15) <= l) {
                float f1 = 0.7F;
                float f2 = world.l.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f3 = world.l.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f4 = world.l.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                EntityItem entityitem = new EntityItem(world, (double) ((float) i + f2), (double) ((float) j + f3), (double) ((float) k + f4), new ItemStack(Item.Q));

                entityitem.c = 10;
                world.a((Entity) entityitem);
            }
        }
    }

    public int a(int i, Random random) {
        return i == 7 ? Item.R.aW : -1;
    }

    public int a(Random random) {
        return 1;
    }
}
