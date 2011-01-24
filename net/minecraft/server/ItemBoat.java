package net.minecraft.server;

public class ItemBoat extends Item {

    public ItemBoat(int i) {
        super(i);
        this.aX = 1;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        float f1 = 1.0F;
        float f2 = entityplayer.y + (entityplayer.w - entityplayer.y) * f1;
        float f3 = entityplayer.x + (entityplayer.v - entityplayer.x) * f1;
        double d1 = entityplayer.m + (entityplayer.p - entityplayer.m) * (double) f1;
        double d2 = entityplayer.n + (entityplayer.q - entityplayer.n) * (double) f1 + 1.62D - (double) entityplayer.G;
        double d3 = entityplayer.o + (entityplayer.r - entityplayer.o) * (double) f1;
        Vec3D vec3d = Vec3D.b(d1, d2, d3);
        float f4 = MathHelper.b(-f3 * 0.017453292F - 3.1415927F);
        float f5 = MathHelper.a(-f3 * 0.017453292F - 3.1415927F);
        float f6 = -MathHelper.b(-f2 * 0.017453292F);
        float f7 = MathHelper.a(-f2 * 0.017453292F);
        float f8 = f5 * f6;
        float f9 = f4 * f6;
        double d4 = 5.0D;
        Vec3D vec3d1 = vec3d.c((double) f8 * d4, (double) f7 * d4, (double) f9 * d4);
        MovingObjectPosition movingobjectposition = world.a(vec3d, vec3d1, true);

        if (movingobjectposition == null) {
            return itemstack;
        } else {
            if (movingobjectposition.a == 0) {
                int i = movingobjectposition.b;
                int j = movingobjectposition.c;
                int k = movingobjectposition.d;

                if (!world.z) {
                    world.a((Entity) (new EntityBoat(world, (double) ((float) i + 0.5F), (double) ((float) j + 1.5F), (double) ((float) k + 0.5F))));
                }

                --itemstack.a;
            }

            return itemstack;
        }
    }
}
