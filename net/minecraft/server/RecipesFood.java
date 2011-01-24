package net.minecraft.server;

public class RecipesFood {

    public RecipesFood() {}

    public void a(CraftingManager craftingmanager) {
        craftingmanager.a(new ItemStack(Item.D), new Object[] { "Y", "X", "#", Character.valueOf('X'), Block.af, Character.valueOf('Y'), Block.ag, Character.valueOf('#'), Item.C});
        craftingmanager.a(new ItemStack(Item.D), new Object[] { "Y", "X", "#", Character.valueOf('X'), Block.ag, Character.valueOf('Y'), Block.af, Character.valueOf('#'), Item.C});
    }
}
