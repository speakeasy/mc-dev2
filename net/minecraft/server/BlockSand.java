package net.minecraft.server;

import java.util.Random;

public class BlockSand extends Block {

    public static boolean a = false;

    public BlockSand(int i, int j) {
        super(i, j, Material.m);
    }

    public void e(World world, int i, int j, int k) {
        world.i(i, j, k, this.bi);
    }

    public void b(World world, int i, int j, int k, int l) {
        world.i(i, j, k, this.bi);
    }

    public void a(World world, int i, int j, int k, Random random) {
        this.h(world, i, j, k);
    }

    private void h(World world, int i, int j, int k) {
        if (g(world, i, j - 1, k) && j >= 0) {
            byte b1 = 32;

            if (!a && world.a(i - b1, j - b1, k - b1, i + b1, j + b1, k + b1)) {
                EntityFallingSand entityfallingsand = new EntityFallingSand(world, (double) ((float) i + 0.5F), (double) ((float) j + 0.5F), (double) ((float) k + 0.5F), this.bi);

                world.a((Entity) entityfallingsand);
            } else {
                world.e(i, j, k, 0);

                while (g(world, i, j - 1, k) && j > 0) {
                    --j;
                }

                if (j > 0) {
                    world.e(i, j, k, this.bi);
                }
            }
        }
    }

    public int b() {
        return 3;
    }

    public static boolean g(World world, int i, int j, int k) {
        int l = world.a(i, j, k);

        if (l == 0) {
            return true;
        } else if (l == Block.FIRE.bi) {
            return true;
        } else {
            Material material = Block.m[l].bt;

            return material == Material.f ? true : material == Material.g;
        }
    }
}
