package net.minecraft.server;

import java.util.Random;

public class BlockOre extends Block {

    public BlockOre(int i, int j) {
        super(i, j, Material.d);
    }

    public int a(int i, Random random) {
        return this.bi == Block.I.bi ? Item.k.ba : (this.bi == Block.aw.bi ? Item.l.ba : (this.bi == Block.N.bi ? Item.aU.ba : this.bi));
    }

    public int a(Random random) {
        return 1;
    }

    protected int b(int i) {
        return this.bi == Block.N.bi ? 4 : 0;
    }
}
