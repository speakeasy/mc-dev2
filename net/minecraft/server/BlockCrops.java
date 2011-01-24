package net.minecraft.server;

import java.util.Random;

public class BlockCrops extends BlockFlower {

    protected BlockCrops(int i, int j) {
        super(i, j);
        this.bb = j;
        this.a(true);
        float f1 = 0.5F;

        this.a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 0.25F, 0.5F + f1);
    }

    protected boolean b(int i) {
        return i == Block.aB.bc;
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
        boolean flag = j1 == this.bc || k1 == this.bc;
        boolean flag1 = l == this.bc || i1 == this.bc;
        boolean flag2 = l1 == this.bc || i2 == this.bc || j2 == this.bc || k2 == this.bc;

        for (int l2 = i - 1; l2 <= i + 1; ++l2) {
            for (int i3 = k - 1; i3 <= k + 1; ++i3) {
                int j3 = world.a(l2, j - 1, i3);
                float f2 = 0.0F;

                if (j3 == Block.aB.bc) {
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

    public int a() {
        return 6;
    }

    public void a(World world, int i, int j, int k, int l) {
        super.a(world, i, j, k, l);

        for (int i1 = 0; i1 < 3; ++i1) {
            if (world.m.nextInt(15) <= l) {
                float f1 = 0.7F;
                float f2 = world.m.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f3 = world.m.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f4 = world.m.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                EntityItem entityitem = new EntityItem(world, (double) ((float) i + f2), (double) ((float) j + f3), (double) ((float) k + f4), new ItemStack(Item.Q));

                entityitem.ad = 10;
                world.a((Entity) entityitem);
            }
        }
    }

    public int a(int i, Random random) {
        System.out.println("Get resource: " + i);
        return i == 7 ? Item.R.aS : -1;
    }

    public int a(Random random) {
        return 1;
    }
}
