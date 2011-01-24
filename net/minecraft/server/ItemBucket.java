package net.minecraft.server;

public class ItemBucket extends Item {

    private int a;

    public ItemBucket(int i, int j) {
        super(i);
        this.aX = 1;
        this.aY = 64;
        this.a = j;
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
        MovingObjectPosition movingobjectposition = world.a(vec3d, vec3d1, this.a == 0);

        if (movingobjectposition == null) {
            return itemstack;
        } else {
            if (movingobjectposition.a == 0) {
                int i = movingobjectposition.b;
                int j = movingobjectposition.c;
                int k = movingobjectposition.d;

                if (!world.a(entityplayer, i, j, k)) {
                    return itemstack;
                }

                if (this.a == 0) {
                    if (world.c(i, j, k) == Material.f && world.b(i, j, k) == 0) {
                        world.d(i, j, k, 0);
                        return new ItemStack(Item.av);
                    }

                    if (world.c(i, j, k) == Material.g && world.b(i, j, k) == 0) {
                        world.d(i, j, k, 0);
                        return new ItemStack(Item.aw);
                    }
                } else {
                    if (this.a < 0) {
                        return new ItemStack(Item.au);
                    }

                    if (movingobjectposition.e == 0) {
                        --j;
                    }

                    if (movingobjectposition.e == 1) {
                        ++j;
                    }

                    if (movingobjectposition.e == 2) {
                        --k;
                    }

                    if (movingobjectposition.e == 3) {
                        ++k;
                    }

                    if (movingobjectposition.e == 4) {
                        --i;
                    }

                    if (movingobjectposition.e == 5) {
                        ++i;
                    }

                    if (world.a(i, j, k) == 0 || !world.c(i, j, k).a()) {
                        if (world.q.d && this.a == Block.A.bh) {
                            world.a(d1 + 0.5D, d2 + 0.5D, d3 + 0.5D, "random.fizz", 0.5F, 2.6F + (world.l.nextFloat() - world.l.nextFloat()) * 0.8F);

                            for (int l = 0; l < 8; ++l) {
                                world.a("largesmoke", (double) i + Math.random(), (double) j + Math.random(), (double) k + Math.random(), 0.0D, 0.0D, 0.0D);
                            }
                        } else {
                            world.b(i, j, k, this.a, 0);
                        }

                        return new ItemStack(Item.au);
                    }
                }
            } else if (this.a == 0 && movingobjectposition.g instanceof EntityCow) {
                return new ItemStack(Item.aE);
            }

            return itemstack;
        }
    }
}
