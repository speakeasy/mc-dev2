package net.minecraft.server;

public class ItemPickaxe extends ItemTool {

    private static Block[] bg = new Block[] { Block.w, Block.aj, Block.ak, Block.t, Block.ao, Block.H, Block.ai, Block.I, Block.ah, Block.G, Block.aw, Block.ax, Block.aT, Block.bb, Block.N, Block.O};

    protected ItemPickaxe(int i, EnumToolMaterial enumtoolmaterial) {
        super(i, 2, enumtoolmaterial, bg);
    }

    public boolean a(Block block) {
        return block == Block.ap ? this.a.d() == 3 : (block != Block.ax && block != Block.aw ? (block != Block.ah && block != Block.G ? (block != Block.ai && block != Block.H ? (block != Block.O && block != Block.N ? (block != Block.aN && block != Block.aO ? (block.bt == Material.d ? true : block.bt == Material.e) : this.a.d() >= 2) : this.a.d() >= 1) : this.a.d() >= 1) : this.a.d() >= 2) : this.a.d() >= 2);
    }
}
