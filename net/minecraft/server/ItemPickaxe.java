package net.minecraft.server;

public class ItemPickaxe extends ItemTool {

    private static Block[] bb = new Block[] { Block.x, Block.ak, Block.al, Block.u, Block.ap, Block.I, Block.aj, Block.J, Block.ai, Block.H, Block.ax, Block.ay, Block.aU, Block.bc};
    private int bc;

    public ItemPickaxe(int i, int j) {
        super(i, 2, j, bb);
        this.bc = j;
    }

    public boolean a(Block block) {
        return block == Block.aq ? this.bc == 3 : (block != Block.ay && block != Block.ax ? (block != Block.ai && block != Block.H ? (block != Block.aj && block != Block.I ? (block != Block.aO && block != Block.aP ? (block.bt == Material.d ? true : block.bt == Material.e) : this.bc >= 2) : this.bc >= 1) : this.bc >= 2) : this.bc >= 2);
    }
}
