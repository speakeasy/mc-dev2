package net.minecraft.server;

public class RecipeIngots {

    private Object[][] a;

    public RecipeIngots() {
        this.a = new Object[][] { { Block.ah, new ItemStack(Item.n, 9)}, { Block.ai, new ItemStack(Item.m, 9)}, { Block.ax, new ItemStack(Item.l, 9)}, { Block.O, new ItemStack(Item.aU, 9, 4)}};
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < this.a.length; ++i) {
            Block block = (Block) this.a[i][0];
            ItemStack itemstack = (ItemStack) this.a[i][1];

            craftingmanager.a(new ItemStack(block), new Object[] { "###", "###", "###", Character.valueOf('#'), itemstack});
            craftingmanager.a(itemstack, new Object[] { "#", Character.valueOf('#'), block});
        }
    }
}
