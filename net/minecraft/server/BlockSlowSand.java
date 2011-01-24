package net.minecraft.server;

public class BlockSlowSand extends Block {

    public BlockSlowSand(int i, int j) {
        super(i, j, Material.m);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        float f1 = 0.125F;

        return AxisAlignedBB.b((double) i, (double) j, (double) k, (double) (i + 1), (double) ((float) (j + 1) - f1), (double) (k + 1));
    }

    public void a(World world, int i, int j, int k, Entity entity) {
        entity.s *= 0.4D;
        entity.u *= 0.4D;
    }
}
