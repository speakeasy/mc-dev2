package net.minecraft.server;

public class ItemSeeds extends Item {

    private int a;

    public ItemSeeds(int i, int j) {
        super(i);
        this.a = j;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l != 1) {
            return false;
        } else {
            int i1 = world.a(i, j, k);

            if (i1 == Block.aA.bi && world.e(i, j + 1, k)) {
                world.e(i, j + 1, k, this.a);
                --itemstack.a;
                return true;
            } else {
                return false;
            }
        }
    }
}
