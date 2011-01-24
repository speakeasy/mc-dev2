package net.minecraft.server;

public class RecipesTools {

    private String[][] a = new String[][] { { "XXX", " # ", " # "}, { "X", "#", "#"}, { "XX", "X#", " #"}, { "XX", " #", " #"}};
    private Object[][] b;

    public RecipesTools() {
        this.b = new Object[][] { { Block.x, Block.w, Item.m, Item.l, Item.n}, { Item.r, Item.v, Item.e, Item.z, Item.G}, { Item.q, Item.u, Item.d, Item.y, Item.F}, { Item.s, Item.w, Item.f, Item.A, Item.H}, { Item.L, Item.M, Item.N, Item.O, Item.P}};
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];

            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item) this.b[j + 1][i];

                craftingmanager.a(new ItemStack(item), new Object[] { this.a[j], Character.valueOf('#'), Item.B, Character.valueOf('X'), object});
            }
        }
    }
}
