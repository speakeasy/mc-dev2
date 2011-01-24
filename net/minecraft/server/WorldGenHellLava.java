package net.minecraft.server;

import java.util.Random;

public class WorldGenHellLava extends WorldGenerator {

    private int a;

    public WorldGenHellLava(int i) {
        this.a = i;
    }

    public boolean a(World world, Random random, int i, int j, int k) {
        if (world.a(i, j + 1, k) != Block.bb.bh) {
            return false;
        } else if (world.a(i, j, k) != 0 && world.a(i, j, k) != Block.bb.bh) {
            return false;
        } else {
            int l = 0;

            if (world.a(i - 1, j, k) == Block.bb.bh) {
                ++l;
            }

            if (world.a(i + 1, j, k) == Block.bb.bh) {
                ++l;
            }

            if (world.a(i, j, k - 1) == Block.bb.bh) {
                ++l;
            }

            if (world.a(i, j, k + 1) == Block.bb.bh) {
                ++l;
            }

            if (world.a(i, j - 1, k) == Block.bb.bh) {
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

            if (world.a(i, j - 1, k) == 0) {
                ++i1;
            }

            if (l == 4 && i1 == 1) {
                world.d(i, j, k, this.a);
                world.a = true;
                Block.m[this.a].a(world, i, j, k, random);
                world.a = false;
            }

            return true;
        }
    }
}
