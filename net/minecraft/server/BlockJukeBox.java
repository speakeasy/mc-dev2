package net.minecraft.server;

public class BlockJukeBox extends Block {

    protected BlockJukeBox(int i, int j) {
        super(i, j, Material.c);
    }

    public int a(int i) {
        return this.bh + (i == 1 ? 1 : 0);
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        int l = world.b(i, j, k);

        if (l > 0) {
            this.f(world, i, j, k, l);
            return true;
        } else {
            return false;
        }
    }

    public void f(World world, int i, int j, int k, int l) {
        world.a((String) null, i, j, k);
        world.c(i, j, k, 0);
        int i1 = Item.aY.ba + l - 1;
        float f1 = 0.7F;
        double d1 = (double) (world.l.nextFloat() * f1) + (double) (1.0F - f1) * 0.5D;
        double d2 = (double) (world.l.nextFloat() * f1) + (double) (1.0F - f1) * 0.2D + 0.6D;
        double d3 = (double) (world.l.nextFloat() * f1) + (double) (1.0F - f1) * 0.5D;
        EntityItem entityitem = new EntityItem(world, (double) i + d1, (double) j + d2, (double) k + d3, new ItemStack(i1, 1, 0));

        entityitem.c = 10;
        world.a((Entity) entityitem);
    }

    public void a(World world, int i, int j, int k, int l, float f1) {
        if (!world.z) {
            if (l > 0) {
                this.f(world, i, j, k, l);
            }

            super.a(world, i, j, k, l, f1);
        }
    }
}
