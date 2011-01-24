package net.minecraft.server;

import java.util.Random;

public class BlockStep extends Block {

    private boolean a;

    public BlockStep(int i, boolean flag) {
        super(i, 6, Material.d);
        this.a = flag;
        if (!flag) {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }

        this.c(255);
    }

    public int a(int i) {
        return i <= 1 ? 6 : 5;
    }

    public boolean a() {
        return this.a;
    }

    public void b(World world, int i, int j, int k, int l) {
        if (this == Block.ak) {
            ;
        }
    }

    public void e(World world, int i, int j, int k) {
        if (this != Block.ak) {
            super.e(world, i, j, k);
        }

        int l = world.a(i, j - 1, k);

        if (l == ak.bh) {
            world.d(i, j, k, 0);
            world.d(i, j - 1, k, Block.aj.bh);
        }
    }

    public int a(int i, Random random) {
        return Block.ak.bh;
    }

    public boolean a(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        if (this != Block.ak) {
            super.a(iblockaccess, i, j, k, l);
        }

        return l == 1 ? true : (!super.a(iblockaccess, i, j, k, l) ? false : (l == 0 ? true : iblockaccess.a(i, j, k) != this.bh));
    }
}
