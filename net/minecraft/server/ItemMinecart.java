package net.minecraft.server;

public class ItemMinecart extends Item {

    public int a;

    public ItemMinecart(int i, int j) {
        super(i);
        this.aT = 1;
        this.a = j;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        int i1 = world.a(i, j, k);

        if (i1 == Block.aH.bc) {
            world.a((Entity) (new EntityMinecart(world, (double) ((float) i + 0.5F), (double) ((float) j + 0.5F), (double) ((float) k + 0.5F), this.a)));
            --itemstack.a;
            return true;
        } else {
            return false;
        }
    }
}
