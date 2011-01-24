package net.minecraft.server;

public class ItemPickaxe extends ItemTool {

    private static Block[] bb = new Block[] { Block.w, Block.aj, Block.ak, Block.t, Block.ao, Block.H, Block.ai, Block.I, Block.ah, Block.G, Block.aw, Block.ax, Block.aT, Block.bb};
    private int bc;

    public ItemPickaxe(int i, int j) {
        super(i, 2, j, bb);
        this.bc = j;
    }

    public boolean a(Block block) {
        return block == Block.ap ? this.bc == 3 : (block != Block.ax && block != Block.aw ? (block != Block.ah && block != Block.G ? (block != Block.ai && block != Block.H ? (block != Block.aN && block != Block.aO ? (block.bs == Material.d ? true : block.bs == Material.e) : this.bc >= 2) : this.bc >= 1) : this.bc >= 2) : this.bc >= 2);
    }
}
