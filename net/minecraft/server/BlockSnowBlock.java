package net.minecraft.server;

import java.util.Random;

public class BlockSnowBlock extends Block {

    protected BlockSnowBlock(int i, int j) {
        super(i, j, Material.t);
        this.a(true);
    }

    public int a(int i, Random random) {
        return Item.aB.aW;
    }

    public int a(Random random) {
        return 4;
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.a(EnumSkyBlock.b, i, j, k) > 11) {
            this.a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
        }
    }
}
