package net.minecraft.server;

import java.util.Random;

public class BlockDispenser extends BlockContainer {

    protected BlockDispenser(int i) {
        super(i, Material.d);
        this.bh = 45;
    }

    public int b() {
        return 4;
    }

    public int a(int i, Random random) {
        return Block.DISPENSER.bi;
    }

    public void e(World world, int i, int j, int k) {
        super.e(world, i, j, k);
        this.g(world, i, j, k);
    }

    private void g(World world, int i, int j, int k) {
        int l = world.a(i, j, k - 1);
        int i1 = world.a(i, j, k + 1);
        int j1 = world.a(i - 1, j, k);
        int k1 = world.a(i + 1, j, k);
        byte b1 = 3;

        if (Block.o[l] && !Block.o[i1]) {
            b1 = 3;
        }

        if (Block.o[i1] && !Block.o[l]) {
            b1 = 2;
        }

        if (Block.o[j1] && !Block.o[k1]) {
            b1 = 5;
        }

        if (Block.o[k1] && !Block.o[j1]) {
            b1 = 4;
        }

        world.c(i, j, k, b1);
    }

    public int a(int i) {
        return i == 1 ? this.bh + 17 : (i == 0 ? this.bh + 17 : (i == 3 ? this.bh + 1 : this.bh));
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        if (world.z) {
            return true;
        } else {
            TileEntityDispenser tileentitydispenser = (TileEntityDispenser) world.m(i, j, k);

            entityplayer.a(tileentitydispenser);
            return true;
        }
    }

    private void b(World world, int i, int j, int k, Random random) {
        int l = world.b(i, j, k);
        float f1 = 0.0F;
        float f2 = 0.0F;

        if (l == 3) {
            f2 = 1.0F;
        } else if (l == 2) {
            f2 = -1.0F;
        } else if (l == 5) {
            f1 = 1.0F;
        } else {
            f1 = -1.0F;
        }

        TileEntityDispenser tileentitydispenser = (TileEntityDispenser) world.m(i, j, k);
        ItemStack itemstack = tileentitydispenser.e();
        double d1 = (double) i + (double) f1 * 0.5D + 0.5D;
        double d2 = (double) j + 0.5D;
        double d3 = (double) k + (double) f2 * 0.5D + 0.5D;

        if (itemstack == null) {
            world.a((double) i, (double) j, (double) k, "random.click", 1.0F, 1.2F);
        } else {
            double d4;

            if (itemstack.c == Item.j.ba) {
                EntityArrow entityarrow = new EntityArrow(world, d1, d2, d3);

                entityarrow.a((double) f1, 0.10000000149011612D, (double) f2, 1.1F, 6.0F);
                world.a((Entity) entityarrow);
                world.a((double) i, (double) j, (double) k, "random.bow", 1.0F, 1.2F);
            } else if (itemstack.c == Item.aN.ba) {
                EntityEgg entityegg = new EntityEgg(world, d1, d2, d3);

                entityegg.a((double) f1, 0.10000000149011612D, (double) f2, 1.1F, 6.0F);
                world.a((Entity) entityegg);
                world.a((double) i, (double) j, (double) k, "random.bow", 1.0F, 1.2F);
            } else if (itemstack.c == Item.aB.ba) {
                EntitySnowball entitysnowball = new EntitySnowball(world, d1, d2, d3);

                entitysnowball.a((double) f1, 0.10000000149011612D, (double) f2, 1.1F, 6.0F);
                world.a((Entity) entitysnowball);
                world.a((double) i, (double) j, (double) k, "random.bow", 1.0F, 1.2F);
            } else {
                EntityItem entityitem = new EntityItem(world, d1, d2 - 0.3D, d3, itemstack);

                d4 = random.nextDouble() * 0.1D + 0.2D;
                entityitem.s = (double) f1 * d4;
                entityitem.t = 0.20000000298023224D;
                entityitem.u = (double) f2 * d4;
                entityitem.s += random.nextGaussian() * 0.007499999832361937D * 6.0D;
                entityitem.t += random.nextGaussian() * 0.007499999832361937D * 6.0D;
                entityitem.u += random.nextGaussian() * 0.007499999832361937D * 6.0D;
                world.a((Entity) entityitem);
                world.a((double) i, (double) j, (double) k, "random.click", 1.0F, 1.0F);
            }

            for (int i1 = 0; i1 < 10; ++i1) {
                d4 = random.nextDouble() * 0.2D + 0.01D;
                double d5 = d1 + (double) f1 * 0.01D + (random.nextDouble() - 0.5D) * (double) f2 * 0.5D;
                double d6 = d2 + (random.nextDouble() - 0.5D) * 0.5D;
                double d7 = d3 + (double) f2 * 0.01D + (random.nextDouble() - 0.5D) * (double) f1 * 0.5D;
                double d8 = (double) f1 * d4 + random.nextGaussian() * 0.01D;
                double d9 = -0.03D + random.nextGaussian() * 0.01D;
                double d10 = (double) f2 * d4 + random.nextGaussian() * 0.01D;

                world.a("smoke", d5, d6, d7, d8, d9, d10);
            }
        }
    }

    public void b(World world, int i, int j, int k, int l) {
        if (l > 0 && Block.m[l].c()) {
            boolean flag = world.p(i, j, k) || world.p(i, j + 1, k);

            if (flag) {
                world.i(i, j, k, this.bi);
            }
        }
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.p(i, j, k) || world.p(i, j + 1, k)) {
            this.b(world, i, j, k, random);
        }
    }

    protected TileEntity a_() {
        return new TileEntityDispenser();
    }

    public void a(World world, int i, int j, int k, EntityLiving entityliving) {
        int l = MathHelper.b((double) (entityliving.v * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.c(i, j, k, 2);
        }

        if (l == 1) {
            world.c(i, j, k, 5);
        }

        if (l == 2) {
            world.c(i, j, k, 3);
        }

        if (l == 3) {
            world.c(i, j, k, 4);
        }
    }
}
