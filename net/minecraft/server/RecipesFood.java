package net.minecraft.server;

public class RecipesFood {

    public RecipesFood() {}

    public void a(CraftingManager craftingmanager) {
        craftingmanager.a(new ItemStack(Item.D), new Object[] { "Y", "X", "#", Character.valueOf('X'), Block.BROWN_MUSHROOM, Character.valueOf('Y'), Block.RED_MUSHROOM, Character.valueOf('#'), Item.C});
        craftingmanager.a(new ItemStack(Item.D), new Object[] { "Y", "X", "#", Character.valueOf('X'), Block.RED_MUSHROOM, Character.valueOf('Y'), Block.BROWN_MUSHROOM, Character.valueOf('#'), Item.C});
    }
}
