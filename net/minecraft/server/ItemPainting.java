package net.minecraft.server;

public class ItemPainting extends Item {

    public ItemPainting(int i) {
        super(i);
        this.bc = 64;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l == 0) {
            return false;
        } else if (l == 1) {
            return false;
        } else {
            byte b1 = 0;

            if (l == 4) {
                b1 = 1;
            }

            if (l == 3) {
                b1 = 2;
            }

            if (l == 5) {
                b1 = 3;
            }

            EntityPainting entitypainting = new EntityPainting(world, i, j, k, b1);

            if (entitypainting.d()) {
                if (!world.z) {
                    world.a((Entity) entitypainting);
                }

                --itemstack.a;
            }

            return true;
        }
    }
}
