package net.minecraft.server;

public class ItemSign extends Item {

    public ItemSign(int i) {
        super(i);
        this.bc = 64;
        this.bb = 1;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l == 0) {
            return false;
        } else if (!world.c(i, j, k).a()) {
            return false;
        } else {
            if (l == 1) {
                ++j;
            }

            if (l == 2) {
                --k;
            }

            if (l == 3) {
                ++k;
            }

            if (l == 4) {
                --i;
            }

            if (l == 5) {
                ++i;
            }

            if (!Block.SIGN_POST.a(world, i, j, k)) {
                return false;
            } else {
                if (l == 1) {
                    world.b(i, j, k, Block.SIGN_POST.bi, MathHelper.b((double) ((entityplayer.v + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15);
                } else {
                    world.b(i, j, k, Block.WALL_SIGN.bi, l);
                }

                --itemstack.a;
                TileEntitySign tileentitysign = (TileEntitySign) world.m(i, j, k);

                if (tileentitysign != null) {
                    entityplayer.a(tileentitysign);
                }

                return true;
            }
        }
    }
}
