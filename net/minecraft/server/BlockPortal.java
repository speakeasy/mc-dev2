package net.minecraft.server;

import java.util.Random;

public class BlockPortal extends BlockBreakable {

    public BlockPortal(int i, int j) {
        super(i, j, Material.x, false);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {
        float f1;
        float f2;

        if (iblockaccess.a(i - 1, j, k) != this.bi && iblockaccess.a(i + 1, j, k) != this.bi) {
            f1 = 0.125F;
            f2 = 0.5F;
            this.a(0.5F - f1, 0.0F, 0.5F - f2, 0.5F + f1, 1.0F, 0.5F + f2);
        } else {
            f1 = 0.5F;
            f2 = 0.125F;
            this.a(0.5F - f1, 0.0F, 0.5F - f2, 0.5F + f1, 1.0F, 0.5F + f2);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b_(World world, int i, int j, int k) {
        byte b1 = 0;
        byte b2 = 0;

        if (world.a(i - 1, j, k) == Block.ap.bi || world.a(i + 1, j, k) == Block.ap.bi) {
            b1 = 1;
        }

        if (world.a(i, j, k - 1) == Block.ap.bi || world.a(i, j, k + 1) == Block.ap.bi) {
            b2 = 1;
        }

        System.out.println(b1 + ", " + b2);
        if (b1 == b2) {
            return false;
        } else {
            if (world.a(i - b1, j, k - b2) == 0) {
                i -= b1;
                k -= b2;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l) {
                for (i1 = -1; i1 <= 3; ++i1) {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
                        int j1 = world.a(i + b1 * l, j + i1, k + b2 * l);

                        if (flag) {
                            if (j1 != Block.ap.bi) {
                                return false;
                            }
                        } else if (j1 != 0 && j1 != Block.ar.bi) {
                            return false;
                        }
                    }
                }
            }

            world.i = true;

            for (l = 0; l < 2; ++l) {
                for (i1 = 0; i1 < 3; ++i1) {
                    world.e(i + b1 * l, j + i1, k + b2 * l, Block.be.bi);
                }
            }

            world.i = false;
            return true;
        }
    }

    public void b(World world, int i, int j, int k, int l) {
        byte b1 = 0;
        byte b2 = 1;

        if (world.a(i - 1, j, k) == this.bi || world.a(i + 1, j, k) == this.bi) {
            b1 = 1;
            b2 = 0;
        }

        int i1;

        for (i1 = j; world.a(i, i1 - 1, k) == this.bi; --i1) {
            ;
        }

        if (world.a(i, i1 - 1, k) != Block.ap.bi) {
            world.e(i, j, k, 0);
        } else {
            int j1;

            for (j1 = 1; j1 < 4 && world.a(i, i1 + j1, k) == this.bi; ++j1) {
                ;
            }

            if (j1 == 3 && world.a(i, i1 + j1, k) == Block.ap.bi) {
                boolean flag = world.a(i - 1, j, k) == this.bi || world.a(i + 1, j, k) == this.bi;
                boolean flag1 = world.a(i, j, k - 1) == this.bi || world.a(i, j, k + 1) == this.bi;

                if (flag && flag1) {
                    world.e(i, j, k, 0);
                } else if ((world.a(i + b1, j, k + b2) != Block.ap.bi || world.a(i - b1, j, k - b2) != this.bi) && (world.a(i - b1, j, k - b2) != Block.ap.bi || world.a(i + b1, j, k + b2) != this.bi)) {
                    world.e(i, j, k, 0);
                }
            } else {
                world.e(i, j, k, 0);
            }
        }
    }

    public boolean a(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return true;
    }

    public int a(Random random) {
        return 0;
    }

    public void a(World world, int i, int j, int k, Entity entity) {
        if (!world.z) {
            entity.H();
        }
    }
}
