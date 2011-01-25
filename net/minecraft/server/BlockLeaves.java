package net.minecraft.server;

import java.util.Random;

public class BlockLeaves extends BlockLeavesBase {

    private int c;
    int[] b;

    protected BlockLeaves(int i, int j) {
        super(i, j, Material.h, false);
        this.c = j;
        this.a(true);
    }

    public void b(World world, int i, int j, int k) {
        byte b1 = 1;
        int l = b1 + 1;

        if (world.a(i - l, j - l, k - l, i + l, j + l, k + l)) {
            for (int i1 = -b1; i1 <= b1; ++i1) {
                for (int j1 = -b1; j1 <= b1; ++j1) {
                    for (int k1 = -b1; k1 <= b1; ++k1) {
                        int l1 = world.a(i + i1, j + j1, k + k1);

                        if (l1 == Block.LEAVES.bi) {
                            int i2 = world.b(i + i1, j + j1, k + k1);

                            world.d(i + i1, j + j1, k + k1, i2 | 4);
                        }
                    }
                }
            }
        }
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (!world.z) {
            int l = world.b(i, j, k);

            if ((l & 4) != 0) {
                byte b1 = 4;
                int i1 = b1 + 1;
                byte b2 = 32;
                int j1 = b2 * b2;
                int k1 = b2 / 2;

                if (this.b == null) {
                    this.b = new int[b2 * b2 * b2];
                }

                int l1;

                if (world.a(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1)) {
                    int i2;
                    int j2;
                    int k2;

                    for (l1 = -b1; l1 <= b1; ++l1) {
                        for (i2 = -b1; i2 <= b1; ++i2) {
                            for (j2 = -b1; j2 <= b1; ++j2) {
                                k2 = world.a(i + l1, j + i2, k + j2);
                                if (k2 == Block.LOG.bi) {
                                    this.b[(l1 + k1) * j1 + (i2 + k1) * b2 + j2 + k1] = 0;
                                } else if (k2 == Block.LEAVES.bi) {
                                    this.b[(l1 + k1) * j1 + (i2 + k1) * b2 + j2 + k1] = -2;
                                } else {
                                    this.b[(l1 + k1) * j1 + (i2 + k1) * b2 + j2 + k1] = -1;
                                }
                            }
                        }
                    }

                    for (l1 = 1; l1 <= 4; ++l1) {
                        for (i2 = -b1; i2 <= b1; ++i2) {
                            for (j2 = -b1; j2 <= b1; ++j2) {
                                for (k2 = -b1; k2 <= b1; ++k2) {
                                    if (this.b[(i2 + k1) * j1 + (j2 + k1) * b2 + k2 + k1] == l1 - 1) {
                                        if (this.b[(i2 + k1 - 1) * j1 + (j2 + k1) * b2 + k2 + k1] == -2) {
                                            this.b[(i2 + k1 - 1) * j1 + (j2 + k1) * b2 + k2 + k1] = l1;
                                        }

                                        if (this.b[(i2 + k1 + 1) * j1 + (j2 + k1) * b2 + k2 + k1] == -2) {
                                            this.b[(i2 + k1 + 1) * j1 + (j2 + k1) * b2 + k2 + k1] = l1;
                                        }

                                        if (this.b[(i2 + k1) * j1 + (j2 + k1 - 1) * b2 + k2 + k1] == -2) {
                                            this.b[(i2 + k1) * j1 + (j2 + k1 - 1) * b2 + k2 + k1] = l1;
                                        }

                                        if (this.b[(i2 + k1) * j1 + (j2 + k1 + 1) * b2 + k2 + k1] == -2) {
                                            this.b[(i2 + k1) * j1 + (j2 + k1 + 1) * b2 + k2 + k1] = l1;
                                        }

                                        if (this.b[(i2 + k1) * j1 + (j2 + k1) * b2 + (k2 + k1 - 1)] == -2) {
                                            this.b[(i2 + k1) * j1 + (j2 + k1) * b2 + (k2 + k1 - 1)] = l1;
                                        }

                                        if (this.b[(i2 + k1) * j1 + (j2 + k1) * b2 + k2 + k1 + 1] == -2) {
                                            this.b[(i2 + k1) * j1 + (j2 + k1) * b2 + k2 + k1 + 1] = l1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                l1 = this.b[k1 * j1 + k1 * b2 + k1];
                if (l1 >= 0) {
                    world.c(i, j, k, l & -5);
                } else {
                    this.g(world, i, j, k);
                }
            }
        }
    }

    private void g(World world, int i, int j, int k) {
        this.a_(world, i, j, k, world.b(i, j, k));
        world.e(i, j, k, 0);
    }

    public int a(Random random) {
        return random.nextInt(16) == 0 ? 1 : 0;
    }

    public int a(int i, Random random) {
        return Block.SAPLING.bi;
    }

    public boolean a() {
        return !this.a;
    }

    public void b(World world, int i, int j, int k, Entity entity) {
        super.b(world, i, j, k, entity);
    }
}
