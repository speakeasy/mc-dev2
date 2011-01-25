package net.minecraft.server;

import java.util.Random;

public class BlockRedstoneOre extends Block {

    private boolean a;

    public BlockRedstoneOre(int i, int j, boolean flag) {
        super(i, j, Material.d);
        if (flag) {
            this.a(true);
        }

        this.a = flag;
    }

    public int b() {
        return 30;
    }

    public void b(World world, int i, int j, int k, EntityPlayer entityplayer) {
        this.g(world, i, j, k);
        super.b(world, i, j, k, entityplayer);
    }

    public void b(World world, int i, int j, int k, Entity entity) {
        this.g(world, i, j, k);
        super.b(world, i, j, k, entity);
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        this.g(world, i, j, k);
        return super.a(world, i, j, k, entityplayer);
    }

    private void g(World world, int i, int j, int k) {
        this.h(world, i, j, k);
        if (this.bi == Block.REDSTONE_ORE.bi) {
            world.e(i, j, k, Block.GLOWING_REDSTONE_ORE.bi);
        }
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (this.bi == Block.GLOWING_REDSTONE_ORE.bi) {
            world.e(i, j, k, Block.REDSTONE_ORE.bi);
        }
    }

    public int a(int i, Random random) {
        return Item.aA.ba;
    }

    public int a(Random random) {
        return 4 + random.nextInt(2);
    }

    private void h(World world, int i, int j, int k) {
        Random random = world.l;
        double d1 = 0.0625D;

        for (int l = 0; l < 6; ++l) {
            double d2 = (double) ((float) i + random.nextFloat());
            double d3 = (double) ((float) j + random.nextFloat());
            double d4 = (double) ((float) k + random.nextFloat());

            if (l == 0 && !world.d(i, j + 1, k)) {
                d3 = (double) (j + 1) + d1;
            }

            if (l == 1 && !world.d(i, j - 1, k)) {
                d3 = (double) (j + 0) - d1;
            }

            if (l == 2 && !world.d(i, j, k + 1)) {
                d4 = (double) (k + 1) + d1;
            }

            if (l == 3 && !world.d(i, j, k - 1)) {
                d4 = (double) (k + 0) - d1;
            }

            if (l == 4 && !world.d(i + 1, j, k)) {
                d2 = (double) (i + 1) + d1;
            }

            if (l == 5 && !world.d(i - 1, j, k)) {
                d2 = (double) (i + 0) - d1;
            }

            if (d2 < (double) i || d2 > (double) (i + 1) || d3 < 0.0D || d3 > (double) (j + 1) || d4 < (double) k || d4 > (double) (k + 1)) {
                world.a("reddust", d2, d3, d4, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
