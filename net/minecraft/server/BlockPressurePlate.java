package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class BlockPressurePlate extends Block {

    private EnumMobType a;

    protected BlockPressurePlate(int i, int j, EnumMobType enummobtype) {
        super(i, j, Material.d);
        this.a = enummobtype;
        this.a(true);
        float f1 = 0.0625F;

        this.a(f1, 0.0F, f1, 1.0F - f1, 0.03125F, 1.0F - f1);
    }

    public int b() {
        return 20;
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public boolean a(World world, int i, int j, int k) {
        return world.d(i, j - 1, k);
    }

    public void e(World world, int i, int j, int k) {}

    public void b(World world, int i, int j, int k, int l) {
        boolean flag = false;

        if (!world.d(i, j - 1, k)) {
            flag = true;
        }

        if (flag) {
            this.a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
        }
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.b(i, j, k) != 0) {
            this.g(world, i, j, k);
        }
    }

    public void a(World world, int i, int j, int k, Entity entity) {
        if (world.b(i, j, k) != 1) {
            this.g(world, i, j, k);
        }
    }

    private void g(World world, int i, int j, int k) {
        boolean flag = world.b(i, j, k) == 1;
        boolean flag1 = false;
        float f1 = 0.125F;
        List list = null;

        if (this.a == EnumMobType.a) {
            list = world.b((Entity) null, AxisAlignedBB.b((double) ((float) i + f1), (double) j, (double) ((float) k + f1), (double) ((float) (i + 1) - f1), (double) j + 0.25D, (double) ((float) (k + 1) - f1)));
        }

        if (this.a == EnumMobType.b) {
            list = world.a(EntityLiving.class, AxisAlignedBB.b((double) ((float) i + f1), (double) j, (double) ((float) k + f1), (double) ((float) (i + 1) - f1), (double) j + 0.25D, (double) ((float) (k + 1) - f1)));
        }

        if (this.a == EnumMobType.c) {
            list = world.a(EntityPlayer.class, AxisAlignedBB.b((double) ((float) i + f1), (double) j, (double) ((float) k + f1), (double) ((float) (i + 1) - f1), (double) j + 0.25D, (double) ((float) (k + 1) - f1)));
        }

        if (list.size() > 0) {
            flag1 = true;
        }

        if (flag1 && !flag) {
            world.b(i, j, k, 1);
            world.g(i, j, k, this.bi);
            world.g(i, j - 1, k, this.bi);
            world.b(i, j, k, i, j, k);
            world.a((double) i + 0.5D, (double) j + 0.1D, (double) k + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (!flag1 && flag) {
            world.b(i, j, k, 0);
            world.g(i, j, k, this.bi);
            world.g(i, j - 1, k, this.bi);
            world.b(i, j, k, i, j, k);
            world.a((double) i + 0.5D, (double) j + 0.1D, (double) k + 0.5D, "random.click", 0.3F, 0.5F);
        }

        if (flag1) {
            world.h(i, j, k, this.bi);
        }
    }

    public void b(World world, int i, int j, int k) {
        int l = world.b(i, j, k);

        if (l > 0) {
            world.g(i, j, k, this.bi);
            world.g(i, j - 1, k, this.bi);
        }

        super.b(world, i, j, k);
    }

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {
        boolean flag = iblockaccess.b(i, j, k) == 1;
        float f1 = 0.0625F;

        if (flag) {
            this.a(f1, 0.0F, f1, 1.0F - f1, 0.03125F, 1.0F - f1);
        } else {
            this.a(f1, 0.0F, f1, 1.0F - f1, 0.0625F, 1.0F - f1);
        }
    }

    public boolean b(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return iblockaccess.b(i, j, k) > 0;
    }

    public boolean d(World world, int i, int j, int k, int l) {
        return world.b(i, j, k) == 0 ? false : l == 1;
    }

    public boolean c() {
        return true;
    }
}
