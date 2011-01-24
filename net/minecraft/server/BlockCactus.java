package net.minecraft.server;

import java.util.Random;

public class BlockCactus extends Block {

    protected BlockCactus(int i, int j) {
        super(i, j, Material.u);
        this.a(true);
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.a(i, j + 1, k) == 0) {
            int l;

            for (l = 1; world.a(i, j - l, k) == this.bc; ++l) {
                ;
            }

            if (l < 3) {
                int i1 = world.b(i, j, k);

                if (i1 == 15) {
                    world.d(i, j + 1, k, this.bc);
                    world.b(i, j, k, 0);
                } else {
                    world.b(i, j, k, i1 + 1);
                }
            }
        }
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        float f1 = 0.0625F;

        return AxisAlignedBB.b((double) ((float) i + f1), (double) j, (double) ((float) k + f1), (double) ((float) (i + 1) - f1), (double) ((float) (j + 1) - f1), (double) ((float) (k + 1) - f1));
    }

    public int a(int i) {
        return i == 1 ? this.bb - 1 : (i == 0 ? this.bb + 1 : this.bb);
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 13;
    }

    public boolean a(World world, int i, int j, int k) {
        return !super.a(world, i, j, k) ? false : this.f(world, i, j, k);
    }

    public void b(World world, int i, int j, int k, int l) {
        if (!this.f(world, i, j, k)) {
            this.a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
        }
    }

    public boolean f(World world, int i, int j, int k) {
        if (world.c(i - 1, j, k).a()) {
            return false;
        } else if (world.c(i + 1, j, k).a()) {
            return false;
        } else if (world.c(i, j, k - 1).a()) {
            return false;
        } else if (world.c(i, j, k + 1).a()) {
            return false;
        } else {
            int l = world.a(i, j - 1, k);

            return l == Block.aW.bc || l == Block.F.bc;
        }
    }

    public void a(World world, int i, int j, int k, Entity entity) {
        entity.a((Entity) null, 1);
    }
}
