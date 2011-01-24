package net.minecraft.server;

public class BlockSponge extends Block {

    protected BlockSponge(int i) {
        super(i, Material.j);
        this.bh = 48;
    }

    public void e(World world, int i, int j, int k) {
        byte b1 = 2;

        for (int l = i - b1; l <= i + b1; ++l) {
            for (int i1 = j - b1; i1 <= j + b1; ++i1) {
                for (int j1 = k - b1; j1 <= k + b1; ++j1) {
                    if (world.c(l, i1, j1) == Material.f) {
                        ;
                    }
                }
            }
        }
    }

    public void b(World world, int i, int j, int k) {
        byte b1 = 2;

        for (int l = i - b1; l <= i + b1; ++l) {
            for (int i1 = j - b1; i1 <= j + b1; ++i1) {
                for (int j1 = k - b1; j1 <= k + b1; ++j1) {
                    world.h(l, i1, j1, world.a(l, i1, j1));
                }
            }
        }
    }
}
