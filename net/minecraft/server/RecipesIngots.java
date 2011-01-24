package net.minecraft.server;

public class RecipesIngots {

    private Object[][] a;

    public RecipesIngots() {
        this.a = new Object[][] { { Block.ah, Item.n}, { Block.ai, Item.m}, { Block.ax, Item.l}};
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < this.a.length; ++i) {
            Block block = (Block) this.a[i][0];
            Item item = (Item) this.a[i][1];

            craftingmanager.a(new ItemStack(block), new Object[] { "###", "###", "###", Character.valueOf('#'), item});
            craftingmanager.a(new ItemStack(item, 9), new Object[] { "#", Character.valueOf('#'), block});
        }
    }
}
