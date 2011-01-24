package net.minecraft.server;

public class ItemSpade extends ItemTool {

    private static Block[] aX = new Block[] { Block.v, Block.w, Block.F, Block.G, Block.aT, Block.aV, Block.aX};

    public ItemSpade(int i, int j) {
        super(i, 1, j, aX);
    }

    public boolean a(Block block) {
        return block == Block.aT ? true : block == Block.aV;
    }
}
