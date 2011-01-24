package net.minecraft.server;

import java.util.Random;

public class BlockOre extends Block {

    public BlockOre(int i, int j) {
        super(i, j, Material.d);
    }

    public int a(int i, Random random) {
        return this.bi == Block.J.bi ? Item.k.aW : (this.bi == Block.ax.bi ? Item.l.aW : this.bi);
    }

    public int a(Random random) {
        return 1;
    }
}
