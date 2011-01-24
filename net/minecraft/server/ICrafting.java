package net.minecraft.server;

import java.util.List;

public interface ICrafting {

    void a(CraftingInventoryCB craftinginventorycb, List list);

    void a(CraftingInventoryCB craftinginventorycb, int i, ItemStack itemstack);

    void a(CraftingInventoryCB craftinginventorycb, int i, int j);
}
