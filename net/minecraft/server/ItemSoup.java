package net.minecraft.server;

public class ItemSoup extends ItemFood {

    public ItemSoup(int i, int j) {
        super(i, j);
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        super.a(itemstack, world, entityplayer);
        return new ItemStack(Item.C);
    }
}
