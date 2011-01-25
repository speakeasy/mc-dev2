package net.minecraft.server;

public class ItemHoe extends Item {

    public ItemHoe(int i, EnumToolMaterial enumtoolmaterial) {
        super(i);
        this.bb = 1;
        this.bc = enumtoolmaterial.a();
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        int i1 = world.a(i, j, k);
        Material material = world.c(i, j + 1, k);

        if ((material.a() || i1 != Block.GRASS.bi) && i1 != Block.DIRT.bi) {
            return false;
        } else {
            Block block = Block.SOIL;

            world.a((double) ((float) i + 0.5F), (double) ((float) j + 0.5F), (double) ((float) k + 0.5F), block.br.c(), (block.br.a() + 1.0F) / 2.0F, block.br.b() * 0.8F);
            if (world.z) {
                return true;
            } else {
                world.e(i, j, k, block.bi);
                itemstack.b(1);
                if (world.l.nextInt(8) == 0 && i1 == Block.GRASS.bi) {
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
