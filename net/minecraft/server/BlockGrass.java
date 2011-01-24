package net.minecraft.server;

import java.util.Random;

public class BlockGrass extends Block {

    protected BlockGrass(int i) {
        super(i, Material.b);
        this.bb = 3;
        this.a(true);
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.h(i, j + 1, k) < 4 && world.c(i, j + 1, k).b()) {
            if (random.nextInt(4) != 0) {
                return;
            }

            world.d(i, j, k, Block.w.bc);
        } else if (world.h(i, j + 1, k) >= 9) {
            int l = i + random.nextInt(3) - 1;
            int i1 = j + random.nextInt(5) - 3;
            int j1 = k + random.nextInt(3) - 1;

            if (world.a(l, i1, j1) == Block.w.bc && world.h(l, i1 + 1, j1) >= 4 && !world.c(l, i1 + 1, j1).b()) {
                world.d(l, i1, j1, Block.v.bc);
            }
        }
    }

    public int a(int i, Random random) {
        return Block.w.a(0, random);
    }
}
