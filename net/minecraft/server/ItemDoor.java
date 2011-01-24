package net.minecraft.server;

public class ItemDoor extends Item {

    private Material a;

    public ItemDoor(int i, Material material) {
        super(i);
        this.a = material;
        this.aU = 64;
        this.aT = 1;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l != 1) {
            return false;
        } else {
            ++j;
            Block block;

            if (this.a == Material.c) {
                block = Block.aF;
            } else {
                block = Block.aM;
            }

            if (!block.a(world, i, j, k)) {
                return false;
            } else {
                int i1 = MathHelper.b((double) ((entityplayer.r + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
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
                boolean flag = world.a(i - b1, j, k - b2) == block.bc || world.a(i - b1, j + 1, k - b2) == block.bc;
                boolean flag1 = world.a(i + b1, j, k + b2) == block.bc || world.a(i + b1, j + 1, k + b2) == block.bc;
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

                world.d(i, j, k, block.bc);
                world.b(i, j, k, i1);
                world.d(i, j + 1, k, block.bc);
                world.b(i, j + 1, k, i1 + 8);
                --itemstack.a;
                return true;
            }
        }
    }
}
