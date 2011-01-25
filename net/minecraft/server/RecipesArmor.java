package net.minecraft.server;

public class RecipesArmor {

    private String[][] a = new String[][] { { "XXX", "X X"}, { "X X", "XXX", "XXX"}, { "XXX", "X X", "X X"}, { "X X", "X X"}};
    private Object[][] b;

    public RecipesArmor() {
        this.b = new Object[][] { { Item.aD, Block.FIRE, Item.m, Item.l, Item.n}, { Item.T, Item.X, Item.ab, Item.af, Item.aj}, { Item.U, Item.Y, Item.ac, Item.ag, Item.ak}, { Item.V, Item.Z, Item.ad, Item.ah, Item.al}, { Item.W, Item.aa, Item.ae, Item.ai, Item.am}};
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];

            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item) this.b[j + 1][i];

                craftingmanager.a(new ItemStack(item), new Object[] { this.a[j], Character.valueOf('X'), object});
            }
        }
    }
}
