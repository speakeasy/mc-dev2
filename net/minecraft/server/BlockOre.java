package net.minecraft.server;

import java.util.Random;

public class BlockOre extends Block {

    public BlockOre(int i, int j) {
        super(i, j, Material.d);
    }

    public int a(int i, Random random) {
        return this.bi == Block.COAL_ORE.bi ? Item.k.ba : (this.bi == Block.DIAMOND_ORE.bi ? Item.l.ba : (this.bi == Block.LAPIS_ORE.bi ? Item.aU.ba : this.bi));
    }

    public int a(Random random) {
        return 1;
    }

    protected int b(int i) {
        return this.bi == Block.LAPIS_ORE.bi ? 4 : 0;
    }
}
