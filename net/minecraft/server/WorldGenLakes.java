package net.minecraft.server;

import java.util.Random;

public class WorldGenLakes extends WorldGenerator {

    private int a;

    public WorldGenLakes(int i) {
        this.a = i;
    }

    public boolean a(World world, Random random, int i, int j, int k) {
        i -= 8;

        for (k -= 8; j > 0 && world.e(i, j, k); --j) {
            ;
        }

        j -= 4;
        boolean[] aboolean = new boolean[2048];
        int l = random.nextInt(4) + 4;

        int i1;

        for (i1 = 0; i1 < l; ++i1) {
            double d1 = random.nextDouble() * 6.0D + 3.0D;
            double d2 = random.nextDouble() * 4.0D + 2.0D;
            double d3 = random.nextDouble() * 6.0D + 3.0D;
            double d4 = random.nextDouble() * (16.0D - d1 - 2.0D) + 1.0D + d1 / 2.0D;
            double d5 = random.nextDouble() * (8.0D - d2 - 4.0D) + 2.0D + d2 / 2.0D;
            double d6 = random.nextDouble() * (16.0D - d3 - 2.0D) + 1.0D + d3 / 2.0D;

            for (int j1 = 1; j1 < 15; ++j1) {
                for (int k1 = 1; k1 < 15; ++k1) {
                    for (int l1 = 1; l1 < 7; ++l1) {
                        double d7 = ((double) j1 - d4) / (d1 / 2.0D);
                        double d8 = ((double) l1 - d5) / (d2 / 2.0D);
                        double d9 = ((double) k1 - d6) / (d3 / 2.0D);
                        double d10 = d7 * d7 + d8 * d8 + d9 * d9;

                        if (d10 < 1.0D) {
                            aboolean[(j1 * 16 + k1) * 8 + l1] = true;
                        }
                    }
                }
            }
        }

        boolean flag;
        int i2;
        int j2;

        for (i1 = 0; i1 < 16; ++i1) {
            for (i2 = 0; i2 < 16; ++i2) {
                for (j2 = 0; j2 < 8; ++j2) {
                    flag = !aboolean[(i1 * 16 + i2) * 8 + j2] && (i1 < 15 && aboolean[((i1 + 1) * 16 + i2) * 8 + j2] || i1 > 0 && aboolean[((i1 - 1) * 16 + i2) * 8 + j2] || i2 < 15 && aboolean[(i1 * 16 + i2 + 1) * 8 + j2] || i2 > 0 && aboolean[(i1 * 16 + (i2 - 1)) * 8 + j2] || j2 < 7 && aboolean[(i1 * 16 + i2) * 8 + j2 + 1] || j2 > 0 && aboolean[(i1 * 16 + i2) * 8 + (j2 - 1)]);
                    if (flag) {
                        Material material = world.c(i + i1, j + j2, k + i2);

                        if (j2 >= 4 && material.d()) {
                            return false;
                        }

                        if (j2 < 4 && !material.a() && world.a(i + i1, j + j2, k + i2) != this.a) {
                            return false;
                        }
                    }
                }
            }
        }

        for (i1 = 0; i1 < 16; ++i1) {
            for (i2 = 0; i2 < 16; ++i2) {
                for (j2 = 0; j2 < 8; ++j2) {
                    if (aboolean[(i1 * 16 + i2) * 8 + j2]) {
                        world.b(i + i1, j + j2, k + i2, j2 >= 4 ? 0 : this.a);
                    }
                }
            }
        }

        for (i1 = 0; i1 < 16; ++i1) {
            for (i2 = 0; i2 < 16; ++i2) {
                for (j2 = 4; j2 < 8; ++j2) {
                    if (aboolean[(i1 * 16 + i2) * 8 + j2] && world.a(i + i1, j + j2 - 1, k + i2) == Block.DIRT.bi && world.a(EnumSkyBlock.a, i + i1, j + j2, k + i2) > 0) {
                        world.b(i + i1, j + j2 - 1, k + i2, Block.GRASS.bi);
                    }
                }
            }
        }

        if (Block.m[this.a].bt == Material.g) {
            for (i1 = 0; i1 < 16; ++i1) {
                for (i2 = 0; i2 < 16; ++i2) {
                    for (j2 = 0; j2 < 8; ++j2) {
                        flag = !aboolean[(i1 * 16 + i2) * 8 + j2] && (i1 < 15 && aboolean[((i1 + 1) * 16 + i2) * 8 + j2] || i1 > 0 && aboolean[((i1 - 1) * 16 + i2) * 8 + j2] || i2 < 15 && aboolean[(i1 * 16 + i2 + 1) * 8 + j2] || i2 > 0 && aboolean[(i1 * 16 + (i2 - 1)) * 8 + j2] || j2 < 7 && aboolean[(i1 * 16 + i2) * 8 + j2 + 1] || j2 > 0 && aboolean[(i1 * 16 + i2) * 8 + (j2 - 1)]);
                        if (flag && (j2 < 4 || random.nextInt(2) != 0) && world.c(i + i1, j + j2, k + i2).a()) {
                            world.b(i + i1, j + j2, k + i2, Block.STONE.bi);
                        }
                    }
                }
            }
        }

        return true;
    }
}
