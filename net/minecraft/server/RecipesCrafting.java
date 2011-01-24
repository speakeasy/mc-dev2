package net.minecraft.server;

public class RecipesCrafting {

    public RecipesCrafting() {}

    public void a(CraftingManager craftingmanager) {
        craftingmanager.a(new ItemStack(Block.au), new Object[] { "###", "# #", "###", Character.valueOf('#'), Block.x});
        craftingmanager.a(new ItemStack(Block.aB), new Object[] { "###", "# #", "###", Character.valueOf('#'), Block.w});
        craftingmanager.a(new ItemStack(Block.ay), new Object[] { "##", "##", Character.valueOf('#'), Block.x});
    }
}
