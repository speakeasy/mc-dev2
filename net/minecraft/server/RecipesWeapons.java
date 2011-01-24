package net.minecraft.server;

public class RecipesWeapons {

    private String[][] a = new String[][] { { "X", "X", "#"}};
    private Object[][] b;

    public RecipesWeapons() {
        this.b = new Object[][] { { Block.x, Block.w, Item.m, Item.l, Item.n}, { Item.p, Item.t, Item.o, Item.x, Item.E}};
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];

            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item) this.b[j + 1][i];

                craftingmanager.a(new ItemStack(item), new Object[] { this.a[j], Character.valueOf('#'), Item.B, Character.valueOf('X'), object});
            }
        }

        craftingmanager.a(new ItemStack(Item.i, 1), new Object[] { " #X", "# X", " #X", Character.valueOf('X'), Item.I, Character.valueOf('#'), Item.B});
        craftingmanager.a(new ItemStack(Item.j, 4), new Object[] { "X", "#", "Y", Character.valueOf('Y'), Item.J, Character.valueOf('X'), Item.an, Character.valueOf('#'), Item.B});
    }
}
