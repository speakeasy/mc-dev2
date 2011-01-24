package net.minecraft.server;

import java.util.Random;

public class BlockSign extends BlockContainer {

    private Class a;
    private boolean b;

    protected BlockSign(int i, Class oclass, boolean flag) {
        super(i, Material.c);
        this.b = flag;
        this.bg = 4;
        this.a = oclass;
        float f1 = 0.25F;
        float f2 = 1.0F;

        this.a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f2, 0.5F + f1);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {
        if (!this.b) {
            int l = iblockaccess.b(i, j, k);
            float f1 = 0.28125F;
            float f2 = 0.78125F;
            float f3 = 0.0F;
            float f4 = 1.0F;
            float f5 = 0.125F;

            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            if (l == 2) {
                this.a(f3, f1, 1.0F - f5, f4, f2, 1.0F);
            }

            if (l == 3) {
                this.a(f3, f1, 0.0F, f4, f2, f5);
            }

            if (l == 4) {
                this.a(1.0F - f5, f1, f3, 1.0F, f2, f4);
            }

            if (l == 5) {
                this.a(0.0F, f1, f3, f5, f2, f4);
            }
        }
    }

    public boolean a() {
        return false;
    }

    protected TileEntity a_() {
        try {
            return (TileEntity) this.a.newInstance();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public int a(int i, Random random) {
        return Item.as.aW;
    }

    public void b(World world, int i, int j, int k, int l) {
        boolean flag = false;

        if (this.b) {
            if (!world.c(i, j - 1, k).a()) {
                flag = true;
            }
        } else {
            int i1 = world.b(i, j, k);

            flag = true;
            if (i1 == 2 && world.c(i, j, k + 1).a()) {
                flag = false;
            }

            if (i1 == 3 && world.c(i, j, k - 1).a()) {
                flag = false;
            }

            if (i1 == 4 && world.c(i + 1, j, k).a()) {
                flag = false;
            }

            if (i1 == 5 && world.c(i - 1, j, k).a()) {
                flag = false;
            }
        }

        if (flag) {
            this.a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
        }

        super.b(world, i, j, k, l);
    }
}
