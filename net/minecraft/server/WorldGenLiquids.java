package net.minecraft.server;

import java.util.Random;

public class WorldGenLiquids extends WorldGenerator {

    private int a;

    public WorldGenLiquids(int i) {
        this.a = i;
    }

    public boolean a(World world, Random random, int i, int j, int k) {
        if (world.a(i, j + 1, k) != Block.u.bc) {
            return false;
        } else if (world.a(i, j - 1, k) != Block.u.bc) {
            return false;
        } else if (world.a(i, j, k) != 0 && world.a(i, j, k) != Block.u.bc) {
            return false;
        } else {
            int l = 0;

            if (world.a(i - 1, j, k) == Block.u.bc) {
                ++l;
            }

            if (world.a(i + 1, j, k) == Block.u.bc) {
                ++l;
            }

            if (world.a(i, j, k - 1) == Block.u.bc) {
                ++l;
            }

            if (world.a(i, j, k + 1) == Block.u.bc) {
                ++l;
            }

            int i1 = 0;

            if (world.a(i - 1, j, k) == 0) {
                ++i1;
            }

            if (world.a(i + 1, j, k) == 0) {
                ++i1;
            }

            if (world.a(i, j, k - 1) == 0) {
                ++i1;
            }

            if (world.a(i, j, k + 1) == 0) {
                ++i1;
            }

            if (l == 3 && i1 == 1) {
                world.d(i, j, k, this.a);
            }

            return true;
        }
    }
}
