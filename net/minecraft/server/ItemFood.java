package net.minecraft.server;

public class ItemFood extends Item {

    private int a;

    public ItemFood(int i, int j) {
        super(i);
        this.a = j;
        this.bb = 1;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        --itemstack.a;
        entityplayer.d(this.a);
        return itemstack;
    }
}
