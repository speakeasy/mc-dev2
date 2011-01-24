package net.minecraft.server;

public class ItemHoe extends Item {

    public ItemHoe(int i, int j) {
        super(i);
        this.aX = 1;
        this.aY = 32 << j;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        int i1 = world.a(i, j, k);
        Material material = world.c(i, j + 1, k);

        if ((material.a() || i1 != Block.u.bh) && i1 != Block.v.bh) {
            return false;
        } else {
            Block block = Block.aA;

            world.a((double) ((float) i + 0.5F), (double) ((float) j + 0.5F), (double) ((float) k + 0.5F), block.bq.c(), (block.bq.a() + 1.0F) / 2.0F, block.bq.b() * 0.8F);
            if (world.z) {
                return true;
            } else {
                world.d(i, j, k, block.bh);
                itemstack.a(1);
                if (world.l.nextInt(8) == 0 && i1 == Block.u.bh) {
                    byte b1 = 1;

                    for (int j1 = 0; j1 < b1; ++j1) {
                        float f1 = 0.7F;
                        float f2 = world.l.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                        float f3 = 1.2F;
                        float f4 = world.l.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                        EntityItem entityitem = new EntityItem(world, (double) ((float) i + f2), (double) ((float) j + f3), (double) ((float) k + f4), new ItemStack(Item.Q));

                        entityitem.c = 10;
                        world.a((Entity) entityitem);
                    }
                }

                return true;
            }
        }
    }
}
