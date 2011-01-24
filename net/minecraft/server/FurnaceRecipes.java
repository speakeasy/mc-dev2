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
        this.a(Block.H.bi, new ItemStack(Item.m));
        this.a(Block.G.bi, new ItemStack(Item.n));
        this.a(Block.aw.bi, new ItemStack(Item.l));
        this.a(Block.E.bi, new ItemStack(Block.M));
        this.a(Item.ao.ba, new ItemStack(Item.ap));
        this.a(Item.aS.ba, new ItemStack(Item.aT));
        this.a(Block.w.bi, new ItemStack(Block.t));
        this.a(Item.aG.ba, new ItemStack(Item.aF));
        this.a(Block.aV.bi, new ItemStack(Item.aU, 1, 2));
        this.a(Block.J.bi, new ItemStack(Item.k, 1, 1));
    }

    public void a(int i, ItemStack itemstack) {
        this.b.put(Integer.valueOf(i), itemstack);
    }

    public ItemStack a(int i) {
        return (ItemStack) this.b.get(Integer.valueOf(i));
    }
}
