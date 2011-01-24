package net.minecraft.server;

import java.util.Random;

public class BlockChest extends BlockContainer {

    private Random a = new Random();

    protected BlockChest(int i) {
        super(i, Material.c);
        this.bg = 26;
    }

    public int a(int i) {
        return i == 1 ? this.bg - 1 : (i == 0 ? this.bg - 1 : (i == 3 ? this.bg + 1 : this.bg));
    }

    public boolean a(World world, int i, int j, int k) {
        int l = 0;

        if (world.a(i - 1, j, k) == this.bh) {
            ++l;
        }

        if (world.a(i + 1, j, k) == this.bh) {
            ++l;
        }

        if (world.a(i, j, k - 1) == this.bh) {
            ++l;
        }

        if (world.a(i, j, k + 1) == this.bh) {
            ++l;
        }

        return l > 1 ? false : (this.g(world, i - 1, j, k) ? false : (this.g(world, i + 1, j, k) ? false : (this.g(world, i, j, k - 1) ? false : !this.g(world, i, j, k + 1))));
    }

    private boolean g(World world, int i, int j, int k) {
        return world.a(i, j, k) != this.bh ? false : (world.a(i - 1, j, k) == this.bh ? true : (world.a(i + 1, j, k) == this.bh ? true : (world.a(i, j, k - 1) == this.bh ? true : world.a(i, j, k + 1) == this.bh)));
    }

    public void b(World world, int i, int j, int k) {
        TileEntityChest tileentitychest = (TileEntityChest) world.k(i, j, k);

        for (int l = 0; l < tileentitychest.a(); ++l) {
            ItemStack itemstack = tileentitychest.a(l);

            if (itemstack != null) {
                float f1 = this.a.nextFloat() * 0.8F + 0.1F;
                float f2 = this.a.nextFloat() * 0.8F + 0.1F;
                float f3 = this.a.nextFloat() * 0.8F + 0.1F;

                while (itemstack.a > 0) {
                    int i1 = this.a.nextInt(21) + 10;

                    if (i1 > itemstack.a) {
                        i1 = itemstack.a;
                    }

                    itemstack.a -= i1;
                    EntityItem entityitem = new EntityItem(world, (double) ((float) i + f1), (double) ((float) j + f2), (double) ((float) k + f3), new ItemStack(itemstack.c, i1, itemstack.d));
                    float f4 = 0.05F;

                    entityitem.s = (double) ((float) this.a.nextGaussian() * f4);
                    entityitem.t = (double) ((float) this.a.nextGaussian() * f4 + 0.2F);
                    entityitem.u = (double) ((float) this.a.nextGaussian() * f4);
                    world.a((Entity) entityitem);
                }
            }
        }

        super.b(world, i, j, k);
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        Object object = (TileEntityChest) world.k(i, j, k);

        if (world.d(i, j + 1, k)) {
            return true;
        } else if (world.a(i - 1, j, k) == this.bh && world.d(i - 1, j + 1, k)) {
            return true;
        } else if (world.a(i + 1, j, k) == this.bh && world.d(i + 1, j + 1, k)) {
            return true;
        } else if (world.a(i, j, k - 1) == this.bh && world.d(i, j + 1, k - 1)) {
            return true;
        } else if (world.a(i, j, k + 1) == this.bh && world.d(i, j + 1, k + 1)) {
            return true;
        } else {
            if (world.a(i - 1, j, k) == this.bh) {
                object = new InventoryLargeChest("Large chest", (TileEntityChest) world.k(i - 1, j, k), (IInventory) object);
            }

            if (world.a(i + 1, j, k) == this.bh) {
                object = new InventoryLargeChest("Large chest", (IInventory) object, (TileEntityChest) world.k(i + 1, j, k));
            }

            if (world.a(i, j, k - 1) == this.bh) {
                object = new InventoryLargeChest("Large chest", (TileEntityChest) world.k(i, j, k - 1), (IInventory) object);
            }

            if (world.a(i, j, k + 1) == this.bh) {
                object = new InventoryLargeChest("Large chest", (IInventory) object, (TileEntityChest) world.k(i, j, k + 1));
            }

            entityplayer.a((IInventory) object);
            return true;
        }
    }

    protected TileEntity a_() {
        return new TileEntityChest();
    }
}
