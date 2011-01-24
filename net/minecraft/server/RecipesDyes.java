package net.minecraft.server;

public class RecipesDyes {

    public RecipesDyes() {}

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < 16; ++i) {
            craftingmanager.b(new ItemStack(Block.ab, 1, BlockCloth.d(i)), new Object[] { new ItemStack(Item.aU, 1, i), new ItemStack(Item.c[Block.ab.bi], 1, 0)});
        }

        craftingmanager.b(new ItemStack(Item.aU, 2, 11), new Object[] { Block.ad});
        craftingmanager.b(new ItemStack(Item.aU, 2, 1), new Object[] { Block.ae});
        craftingmanager.b(new ItemStack(Item.aU, 3, 15), new Object[] { Item.aV});
        craftingmanager.b(new ItemStack(Item.aU, 2, 9), new Object[] { new ItemStack(Item.aU, 1, 1), new ItemStack(Item.aU, 1, 15)});
        craftingmanager.b(new ItemStack(Item.aU, 2, 14), new Object[] { new ItemStack(Item.aU, 1, 1), new ItemStack(Item.aU, 1, 11)});
        craftingmanager.b(new ItemStack(Item.aU, 2, 10), new Object[] { new ItemStack(Item.aU, 1, 2), new ItemStack(Item.aU, 1, 15)});
        craftingmanager.b(new ItemStack(Item.aU, 2, 8), new Object[] { new ItemStack(Item.aU, 1, 0), new ItemStack(Item.aU, 1, 15)});
        craftingmanager.b(new ItemStack(Item.aU, 2, 7), new Object[] { new ItemStack(Item.aU, 1, 8), new ItemStack(Item.aU, 1, 15)});
        craftingmanager.b(new ItemStack(Item.aU, 3, 7), new Object[] { new ItemStack(Item.aU, 1, 0), new ItemStack(Item.aU, 1, 15), new ItemStack(Item.aU, 1, 15)});
        craftingmanager.b(new ItemStack(Item.aU, 2, 12), new Object[] { new ItemStack(Item.aU, 1, 4), new ItemStack(Item.aU, 1, 15)});
        craftingmanager.b(new ItemStack(Item.aU, 2, 6), new Object[] { new ItemStack(Item.aU, 1, 4), new ItemStack(Item.aU, 1, 2)});
        craftingmanager.b(new ItemStack(Item.aU, 2, 5), new Object[] { new ItemStack(Item.aU, 1, 4), new ItemStack(Item.aU, 1, 1)});
        craftingmanager.b(new ItemStack(Item.aU, 2, 13), new Object[] { new ItemStack(Item.aU, 1, 5), new ItemStack(Item.aU, 1, 9)});
        craftingmanager.b(new ItemStack(Item.aU, 3, 13), new Object[] { new ItemStack(Item.aU, 1, 4), new ItemStack(Item.aU, 1, 1), new ItemStack(Item.aU, 1, 9)});
        craftingmanager.b(new ItemStack(Item.aU, 4, 13), new Object[] { new ItemStack(Item.aU, 1, 4), new ItemStack(Item.aU, 1, 1), new ItemStack(Item.aU, 1, 1), new ItemStack(Item.aU, 1, 15)});
    }
}
