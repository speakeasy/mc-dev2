package net.minecraft.server;

public class ItemAxe extends ItemTool {

    private static Block[] bb = new Block[] { Block.x, Block.an, Block.J, Block.au};

    public ItemAxe(int i, int j) {
        super(i, 3, j, bb);
    }
}
