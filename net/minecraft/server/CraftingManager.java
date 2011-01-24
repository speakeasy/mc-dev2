package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CraftingManager {

    private static final CraftingManager a = new CraftingManager();
    private List b = new ArrayList();

    public static final CraftingManager a() {
        return a;
    }

    private CraftingManager() {
        (new RecipesTools()).a(this);
        (new RecipesWeapons()).a(this);
        (new RecipeIngots()).a(this);
        (new RecipesFood()).a(this);
        (new RecipesCrafting()).a(this);
        (new RecipesArmor()).a(this);
        (new RecipesDyes()).a(this);
        this.a(new ItemStack(Item.aI, 3), new Object[] { "###", Character.valueOf('#'), Item.aH});
        this.a(new ItemStack(Item.aJ, 1), new Object[] { "#", "#", "#", Character.valueOf('#'), Item.aI});
        this.a(new ItemStack(Block.aZ, 2), new Object[] { "###", "###", Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Block.aY, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Block.x, Character.valueOf('X'), Item.l});
        this.a(new ItemStack(Block.R, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Block.x, Character.valueOf('X'), Item.aA});
        this.a(new ItemStack(Block.an, 1), new Object[] { "###", "XXX", "###", Character.valueOf('#'), Block.x, Character.valueOf('X'), Item.aJ});
        this.a(new ItemStack(Block.aU, 1), new Object[] { "##", "##", Character.valueOf('#'), Item.aB});
        this.a(new ItemStack(Block.aW, 1), new Object[] { "##", "##", Character.valueOf('#'), Item.aG});
        this.a(new ItemStack(Block.al, 1), new Object[] { "##", "##", Character.valueOf('#'), Item.aF});
        this.a(new ItemStack(Block.bd, 1), new Object[] { "###", "###", "###", Character.valueOf('#'), Item.aR});
        this.a(new ItemStack(Block.ab, 1), new Object[] { "###", "###", "###", Character.valueOf('#'), Item.I});
        this.a(new ItemStack(Block.am, 1), new Object[] { "X#X", "#X#", "X#X", Character.valueOf('X'), Item.K, Character.valueOf('#'), Block.E});
        this.a(new ItemStack(Block.ak, 3), new Object[] { "###", Character.valueOf('#'), Block.w});
        this.a(new ItemStack(Block.aF, 1), new Object[] { "# #", "###", "# #", Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Item.at, 1), new Object[] { "##", "##", "##", Character.valueOf('#'), Block.x});
        this.a(new ItemStack(Item.az, 1), new Object[] { "##", "##", "##", Character.valueOf('#'), Item.m});
        this.a(new ItemStack(Item.as, 1), new Object[] { "###", "###", " X ", Character.valueOf('#'), Block.x, Character.valueOf('X'), Item.B});
        this.a(new ItemStack(Item.aX, 1), new Object[] { "AAA", "BEB", "CCC", Character.valueOf('A'), Item.aE, Character.valueOf('B'), Item.aW, Character.valueOf('C'), Item.R, Character.valueOf('E'), Item.aN});
        this.a(new ItemStack(Item.aW, 1), new Object[] { "#", Character.valueOf('#'), Item.aH});
        this.a(new ItemStack(Block.x, 4), new Object[] { "#", Character.valueOf('#'), Block.J});
        this.a(new ItemStack(Item.B, 4), new Object[] { "#", "#", Character.valueOf('#'), Block.x});
        this.a(new ItemStack(Block.aq, 4), new Object[] { "X", "#", Character.valueOf('X'), Item.k, Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Block.aq, 4), new Object[] { "X", "#", Character.valueOf('X'), new ItemStack(Item.k, 1, 1), Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Item.C, 4), new Object[] { "# #", " # ", Character.valueOf('#'), Block.x});
        this.a(new ItemStack(Block.aG, 16), new Object[] { "X X", "X#X", "X X", Character.valueOf('X'), Item.m, Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Item.ax, 1), new Object[] { "# #", "###", Character.valueOf('#'), Item.m});
        this.a(new ItemStack(Block.bf, 1), new Object[] { "A", "B", Character.valueOf('A'), Block.ba, Character.valueOf('B'), Block.aq});
        this.a(new ItemStack(Item.aL, 1), new Object[] { "A", "B", Character.valueOf('A'), Block.au, Character.valueOf('B'), Item.ax});
        this.a(new ItemStack(Item.aM, 1), new Object[] { "A", "B", Character.valueOf('A'), Block.aB, Character.valueOf('B'), Item.ax});
        this.a(new ItemStack(Item.aC, 1), new Object[] { "# #", "###", Character.valueOf('#'), Block.x});
        this.a(new ItemStack(Item.au, 1), new Object[] { "# #", " # ", Character.valueOf('#'), Item.m});
        this.a(new ItemStack(Item.g, 1), new Object[] { "A ", " B", Character.valueOf('A'), Item.m, Character.valueOf('B'), Item.an});
        this.a(new ItemStack(Item.S, 1), new Object[] { "###", Character.valueOf('#'), Item.R});
        this.a(new ItemStack(Block.at, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Block.x});
        this.a(new ItemStack(Item.aP, 1), new Object[] { "  #", " #X", "# X", Character.valueOf('#'), Item.B, Character.valueOf('X'), Item.I});
        this.a(new ItemStack(Block.aH, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Block.w});
        this.a(new ItemStack(Item.aq, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Item.B, Character.valueOf('X'), Block.ab});
        this.a(new ItemStack(Item.ar, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Block.ah, Character.valueOf('X'), Item.h});
        this.a(new ItemStack(Block.aJ, 1), new Object[] { "X", "#", Character.valueOf('#'), Block.w, Character.valueOf('X'), Item.B});
        this.a(new ItemStack(Block.aQ, 1), new Object[] { "X", "#", Character.valueOf('#'), Item.B, Character.valueOf('X'), Item.aA});
        this.a(new ItemStack(Item.aQ, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Item.n, Character.valueOf('X'), Item.aA});
        this.a(new ItemStack(Item.aO, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Item.m, Character.valueOf('X'), Item.aA});
        this.a(new ItemStack(Block.aR, 1), new Object[] { "#", "#", Character.valueOf('#'), Block.t});
        this.a(new ItemStack(Block.aK, 1), new Object[] { "###", Character.valueOf('#'), Block.t});
        this.a(new ItemStack(Block.aM, 1), new Object[] { "###", Character.valueOf('#'), Block.x});
        this.a(new ItemStack(Block.P, 1), new Object[] { "###", "#X#", "#R#", Character.valueOf('#'), Block.w, Character.valueOf('X'), Item.i, Character.valueOf('R'), Item.aA});
        Collections.sort(this.b, new RecipeSorter(this));
        System.out.println(this.b.size() + " recipes");
    }

    void a(ItemStack itemstack, Object... aobject) {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (aobject[i] instanceof String[]) {
            String[] astring = (String[]) ((String[]) aobject[i++]);

            for (int l = 0; l < astring.length; ++l) {
                String s1 = astring[l];

                ++k;
                j = s1.length();
                s = s + s1;
            }
        } else {
            while (aobject[i] instanceof String) {
                String s2 = (String) aobject[i++];

                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < aobject.length; i += 2) {
            Character character = (Character) aobject[i];
            ItemStack itemstack1 = null;

            if (aobject[i + 1] instanceof Item) {
                itemstack1 = new ItemStack((Item) aobject[i + 1]);
            } else if (aobject[i + 1] instanceof Block) {
                itemstack1 = new ItemStack((Block) aobject[i + 1], 1, -1);
            } else if (aobject[i + 1] instanceof ItemStack) {
                itemstack1 = (ItemStack) aobject[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1) {
            char c1 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c1))) {
                aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c1))).j();
            } else {
                aitemstack[i1] = null;
            }
        }

        this.b.add(new ShapedRecipes(j, k, aitemstack, itemstack));
    }

    void b(ItemStack itemstack, Object... aobject) {
        ArrayList arraylist = new ArrayList();
        Object[] aobject1 = aobject;
        int i = aobject.length;

        for (int j = 0; j < i; ++j) {
            Object object = aobject1[j];

            if (object instanceof ItemStack) {
                arraylist.add(((ItemStack) object).j());
            } else if (object instanceof Item) {
                arraylist.add(new ItemStack((Item) object));
            } else {
                if (!(object instanceof Block)) {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block) object));
            }
        }

        this.b.add(new ShapelessRecipes(itemstack, arraylist));
    }

    public ItemStack a(InventoryCrafting inventorycrafting) {
        for (int i = 0; i < this.b.size(); ++i) {
            CraftingRecipe craftingrecipe = (CraftingRecipe) this.b.get(i);

            if (craftingrecipe.a(inventorycrafting)) {
                return craftingrecipe.b(inventorycrafting);
            }
        }

        return null;
    }
}
