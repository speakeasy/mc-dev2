package net.minecraft.server;

import java.util.Random;

public class BlockOre extends Block {

    public BlockOre(int i, int j) {
        super(i, j, Material.d);
    }

    public int a(int i, Random random) {
        return this.bh == Block.I.bh ? Item.k.aW : (this.bh == Block.aw.bh ? Item.l.aW : this.bh);
    }

    public int a(Random random) {
        return 1;
    }
}
