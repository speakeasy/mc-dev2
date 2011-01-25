package net.minecraft.server;

import java.util.Random;

public class BlockFlower extends Block {

    protected BlockFlower(int i, int j) {
        super(i, Material.i);
        this.bh = j;
        this.a(true);
        float f1 = 0.2F;

        this.a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f1 * 3.0F, 0.5F + f1);
    }

    public boolean a(World world, int i, int j, int k) {
        return this.c(world.a(i, j - 1, k));
    }

    protected boolean c(int i) {
        return i == Block.GRASS.bi || i == Block.DIRT.bi || i == Block.SOIL.bi;
    }

    public void b(World world, int i, int j, int k, int l) {
        super.b(world, i, j, k, l);
        this.g(world, i, j, k);
    }

    public void a(World world, int i, int j, int k, Random random) {
        this.g(world, i, j, k);
    }

    protected final void g(World world, int i, int j, int k) {
        if (!this.f(world, i, j, k)) {
            this.a_(world, i, j, k, world.b(i, j, k));
            world.e(i, j, k, 0);
        }
    }

    public boolean f(World world, int i, int j, int k) {
        return (world.j(i, j, k) >= 8 || world.i(i, j, k)) && this.c(world.a(i, j - 1, k));
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public boolean a() {
        return false;
    }
}
