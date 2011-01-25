package net.minecraft.server;

import java.util.HashMap;
import java.util.Map;

public class FurnaceRecipes {

    private static final FurnaceRecipes a = new FurnaceRecipes();
    private Map b = new HashMap();

    public static final FurnaceRecipes a() {
        return a;
    }

    private FurnaceRecipes() {
        this.a(Block.IRON_ORE.bi, new ItemStack(Item.m));
        this.a(Block.GOLD_ORE.bi, new ItemStack(Item.n));
        this.a(Block.DIAMOND_ORE.bi, new ItemStack(Item.l));
        this.a(Block.SAND.bi, new ItemStack(Block.GLASS));
        this.a(Item.ao.ba, new ItemStack(Item.ap));
        this.a(Item.aS.ba, new ItemStack(Item.aT));
        this.a(Block.COBBLESTONE.bi, new ItemStack(Block.STONE));
        this.a(Item.aG.ba, new ItemStack(Item.aF));
        this.a(Block.CACTUS.bi, new ItemStack(Item.aU, 1, 2));
        this.a(Block.LOG.bi, new ItemStack(Item.k, 1, 1));
    }

    public void a(int i, ItemStack itemstack) {
        this.b.put(Integer.valueOf(i), itemstack);
    }

    public ItemStack a(int i) {
        return (ItemStack) this.b.get(Integer.valueOf(i));
    }
}
