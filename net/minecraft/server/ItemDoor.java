package net.minecraft.server;

public class ItemDoor extends Item {

    private Material a;

    public ItemDoor(int i, Material material) {
        super(i);
        this.a = material;
        this.bc = 64;
        this.bb = 1;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l != 1) {
            return false;
        } else {
            ++j;
            Block block;

            if (this.a == Material.c) {
                block = Block.aE;
            } else {
                block = Block.aL;
            }

            if (!block.a(world, i, j, k)) {
                return false;
            } else {
                int i1 = MathHelper.b((double) ((entityplayer.v + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                byte b1 = 0;
                byte b2 = 0;

                if (i1 == 0) {
                    b2 = 1;
                }

                if (i1 == 1) {
                    b1 = -1;
                }

                if (i1 == 2) {
                    b2 = -1;
                }

                if (i1 == 3) {
                    b1 = 1;
                }

                int j1 = (world.d(i - b1, j, k - b2) ? 1 : 0) + (world.d(i - b1, j + 1, k - b2) ? 1 : 0);
                int k1 = (world.d(i + b1, j, k + b2) ? 1 : 0) + (world.d(i + b1, j + 1, k + b2) ? 1 : 0);
                boolean flag = world.a(i - b1, j, k - b2) == block.bi || world.a(i - b1, j + 1, k - b2) == block.bi;
                boolean flag1 = world.a(i + b1, j, k + b2) == block.bi || world.a(i + b1, j + 1, k + b2) == block.bi;
                boolean flag2 = false;

                if (flag && !flag1) {
                    flag2 = true;
                } else if (k1 > j1) {
                    flag2 = true;
                }

                if (flag2) {
                    i1 = i1 - 1 & 3;
                    i1 += 4;
                }

                world.e(i, j, k, block.bi);
                world.c(i, j, k, i1);
                world.e(i, j + 1, k, block.bi);
                world.c(i, j + 1, k, i1 + 8);
                --itemstack.a;
                return true;
            }
        }
    }
}
