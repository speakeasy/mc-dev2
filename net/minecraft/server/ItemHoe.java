package net.minecraft.server;

public class ItemHoe extends Item {

    public ItemHoe(int i, int j) {
        super(i);
        this.aT = 1;
        this.aU = 32 << j;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        int i1 = world.a(i, j, k);
        Material material = world.c(i, j + 1, k);

        if ((material.a() || i1 != Block.v.bc) && i1 != Block.w.bc) {
            return false;
        } else {
            Block block = Block.aB;

            world.a((double) ((float) i + 0.5F), (double) ((float) j + 0.5F), (double) ((float) k + 0.5F), block.bl.c(), (block.bl.a() + 1.0F) / 2.0F, block.bl.b() * 0.8F);
            world.d(i, j, k, block.bc);
            itemstack.a(1);
            if (world.m.nextInt(8) == 0 && i1 == Block.v.bc) {
                byte b1 = 1;

                for (int j1 = 0; j1 < b1; ++j1) {
                    float f1 = 0.7F;
                    float f2 = world.m.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                    float f3 = 1.2F;
                    float f4 = world.m.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                    EntityItem entityitem = new EntityItem(world, (double) ((float) i + f2), (double) ((float) j + f3), (double) ((float) k + f4), new ItemStack(Item.Q));

                    entityitem.ad = 10;
                    world.a((Entity) entityitem);
                }
            }

            return true;
        }
    }
}
