package net.minecraft.server;

public class ItemPickaxe extends ItemTool {

    private static Block[] aX = new Block[] { Block.x, Block.ak, Block.al, Block.u, Block.ap, Block.I, Block.aj, Block.J, Block.ai, Block.H, Block.ax, Block.ay, Block.aU};
    private int aY;

    public ItemPickaxe(int i, int j) {
        super(i, 2, j, aX);
        this.aY = j;
    }

    public boolean a(Block block) {
        return block == Block.aq ? this.aY == 3 : (block != Block.ay && block != Block.ax ? (block != Block.ai && block != Block.H ? (block != Block.aj && block != Block.I ? (block != Block.aO && block != Block.aP ? (block.bn == Material.d ? true : block.bn == Material.e) : this.aY >= 2) : this.aY >= 1) : this.aY >= 2) : this.aY >= 2);
    }
}
