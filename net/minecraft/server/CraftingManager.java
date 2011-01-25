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
        this.a(new ItemStack(Block.FENCE, 2), new Object[] { "###", "###", Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Block.JUKEBOX, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Block.WOOD, Character.valueOf('X'), Item.l});
        this.a(new ItemStack(Block.NOTE_BLOCK, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Block.WOOD, Character.valueOf('X'), Item.aA});
        this.a(new ItemStack(Block.BOOKSHELF, 1), new Object[] { "###", "XXX", "###", Character.valueOf('#'), Block.WOOD, Character.valueOf('X'), Item.aJ});
        this.a(new ItemStack(Block.SNOW_BLOCK, 1), new Object[] { "##", "##", Character.valueOf('#'), Item.aB});
        this.a(new ItemStack(Block.CLAY, 1), new Object[] { "##", "##", Character.valueOf('#'), Item.aG});
        this.a(new ItemStack(Block.BRICK, 1), new Object[] { "##", "##", Character.valueOf('#'), Item.aF});
        this.a(new ItemStack(Block.GLOWSTONE, 1), new Object[] { "###", "###", "###", Character.valueOf('#'), Item.aR});
        this.a(new ItemStack(Block.WOOL, 1), new Object[] { "###", "###", "###", Character.valueOf('#'), Item.I});
        this.a(new ItemStack(Block.TNT, 1), new Object[] { "X#X", "#X#", "X#X", Character.valueOf('X'), Item.K, Character.valueOf('#'), Block.SAND});
        this.a(new ItemStack(Block.STEP, 3), new Object[] { "###", Character.valueOf('#'), Block.COBBLESTONE});
        this.a(new ItemStack(Block.LADDER, 1), new Object[] { "# #", "###", "# #", Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Item.at, 1), new Object[] { "##", "##", "##", Character.valueOf('#'), Block.WOOD});
        this.a(new ItemStack(Item.az, 1), new Object[] { "##", "##", "##", Character.valueOf('#'), Item.m});
        this.a(new ItemStack(Item.as, 1), new Object[] { "###", "###", " X ", Character.valueOf('#'), Block.WOOD, Character.valueOf('X'), Item.B});
        this.a(new ItemStack(Item.aX, 1), new Object[] { "AAA", "BEB", "CCC", Character.valueOf('A'), Item.aE, Character.valueOf('B'), Item.aW, Character.valueOf('C'), Item.R, Character.valueOf('E'), Item.aN});
        this.a(new ItemStack(Item.aW, 1), new Object[] { "#", Character.valueOf('#'), Item.aH});
        this.a(new ItemStack(Block.WOOD, 4), new Object[] { "#", Character.valueOf('#'), Block.LOG});
        this.a(new ItemStack(Item.B, 4), new Object[] { "#", "#", Character.valueOf('#'), Block.WOOD});
        this.a(new ItemStack(Block.TORCH, 4), new Object[] { "X", "#", Character.valueOf('X'), Item.k, Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Block.TORCH, 4), new Object[] { "X", "#", Character.valueOf('X'), new ItemStack(Item.k, 1, 1), Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Item.C, 4), new Object[] { "# #", " # ", Character.valueOf('#'), Block.WOOD});
        this.a(new ItemStack(Block.RAILS, 16), new Object[] { "X X", "X#X", "X X", Character.valueOf('X'), Item.m, Character.valueOf('#'), Item.B});
        this.a(new ItemStack(Item.ax, 1), new Object[] { "# #", "###", Character.valueOf('#'), Item.m});
        this.a(new ItemStack(Block.JACK_O_LANTERN, 1), new Object[] { "A", "B", Character.valueOf('A'), Block.PUMPKIN, Character.valueOf('B'), Block.TORCH});
        this.a(new ItemStack(Item.aL, 1), new Object[] { "A", "B", Character.valueOf('A'), Block.CHEST, Character.valueOf('B'), Item.ax});
        this.a(new ItemStack(Item.aM, 1), new Object[] { "A", "B", Character.valueOf('A'), Block.FURNACE, Character.valueOf('B'), Item.ax});
        this.a(new ItemStack(Item.aC, 1), new Object[] { "# #", "###", Character.valueOf('#'), Block.WOOD});
        this.a(new ItemStack(Item.au, 1), new Object[] { "# #", " # ", Character.valueOf('#'), Item.m});
        this.a(new ItemStack(Item.g, 1), new Object[] { "A ", " B", Character.valueOf('A'), Item.m, Character.valueOf('B'), Item.an});
        this.a(new ItemStack(Item.S, 1), new Object[] { "###", Character.valueOf('#'), Item.R});
        this.a(new ItemStack(Block.WOOD_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Block.WOOD});
        this.a(new ItemStack(Item.aP, 1), new Object[] { "  #", " #X", "# X", Character.valueOf('#'), Item.B, Character.valueOf('X'), Item.I});
        this.a(new ItemStack(Block.COBBLESTONE_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Block.COBBLESTONE});
        this.a(new ItemStack(Item.aq, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Item.B, Character.valueOf('X'), Block.WOOL});
        this.a(new ItemStack(Item.ar, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Block.GOLD_BLOCK, Character.valueOf('X'), Item.h});
        this.a(new ItemStack(Block.LEVER, 1), new Object[] { "X", "#", Character.valueOf('#'), Block.COBBLESTONE, Character.valueOf('X'), Item.B});
        this.a(new ItemStack(Block.REDSTONE_TORCH_ON, 1), new Object[] { "X", "#", Character.valueOf('#'), Item.B, Character.valueOf('X'), Item.aA});
        this.a(new ItemStack(Item.aQ, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Item.n, Character.valueOf('X'), Item.aA});
        this.a(new ItemStack(Item.aO, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Item.m, Character.valueOf('X'), Item.aA});
        this.a(new ItemStack(Block.STONE_BUTTON, 1), new Object[] { "#", "#", Character.valueOf('#'), Block.STONE});
        this.a(new ItemStack(Block.STONE_PLATE, 1), new Object[] { "###", Character.valueOf('#'), Block.STONE});
        this.a(new ItemStack(Block.WOOD_PLATE, 1), new Object[] { "###", Character.valueOf('#'), Block.WOOD});
        this.a(new ItemStack(Block.DISPENSER, 1), new Object[] { "###", "#X#", "#R#", Character.valueOf('#'), Block.COBBLESTONE, Character.valueOf('X'), Item.i, Character.valueOf('R'), Item.aA});
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
