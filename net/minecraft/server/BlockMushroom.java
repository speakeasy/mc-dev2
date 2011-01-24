package net.minecraft.server;

public class BlockMushroom extends BlockFlower {

    protected BlockMushroom(int i, int j) {
        super(i, j);
        float f1 = 0.2F;

        this.a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f1 * 2.0F, 0.5F + f1);
    }

    protected boolean b(int i) {
        return Block.o[i];
    }

    public boolean f(World world, int i, int j, int k) {
        return world.i(i, j, k) <= 13 && this.b(world.a(i, j - 1, k));
    }
}
