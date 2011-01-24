package net.minecraft.server;

public class ItemSpade extends ItemTool {

    private static Block[] bg = new Block[] { Block.u, Block.v, Block.E, Block.F, Block.aS, Block.aU, Block.aW};

    public ItemSpade(int i, EnumToolMaterial enumtoolmaterial) {
        super(i, 1, enumtoolmaterial, bg);
    }

    public boolean a(Block block) {
        return block == Block.aS ? true : block == Block.aU;
    }
}
