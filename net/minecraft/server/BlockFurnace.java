package net.minecraft.server;

import java.util.Random;

public class BlockFurnace extends BlockContainer {

    private final boolean a;

    protected BlockFurnace(int i, boolean flag) {
        super(i, Material.d);
        this.a = flag;
        this.bb = 45;
    }

    public int a(int i, Random random) {
        return Block.aC.bc;
    }

    public void e(World world, int i, int j, int k) {
        super.e(world, i, j, k);
        this.g(world, i, j, k);
    }

    private void g(World world, int i, int j, int k) {
        int l = world.a(i, j, k - 1);
        int i1 = world.a(i, j, k + 1);
        int j1 = world.a(i - 1, j, k);
        int k1 = world.a(i + 1, j, k);
        byte b1 = 3;

        if (Block.p[l] && !Block.p[i1]) {
            b1 = 3;
        }

        if (Block.p[i1] && !Block.p[l]) {
            b1 = 2;
        }

        if (Block.p[j1] && !Block.p[k1]) {
            b1 = 5;
        }

        if (Block.p[k1] && !Block.p[j1]) {
            b1 = 4;
        }

        world.b(i, j, k, b1);
    }

    public int a(int i) {
        return i == 1 ? Block.u.bc : (i == 0 ? Block.u.bc : (i == 3 ? this.bb - 1 : this.bb));
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        TileEntityFurnace tileentityfurnace = (TileEntityFurnace) world.k(i, j, k);

        entityplayer.a(tileentityfurnace);
        return true;
    }

    public static void a(boolean flag, World world, int i, int j, int k) {
        int l = world.b(i, j, k);
        TileEntity tileentity = world.k(i, j, k);

        if (flag) {
            world.d(i, j, k, Block.aD.bc);
        } else {
            world.d(i, j, k, Block.aC.bc);
        }

        world.b(i, j, k, l);
        world.a(i, j, k, tileentity);
    }

    protected TileEntity a_() {
        return new TileEntityFurnace();
    }
}
