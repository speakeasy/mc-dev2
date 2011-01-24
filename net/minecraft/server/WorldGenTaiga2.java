package net.minecraft.server;

import java.util.Random;

public class WorldGenTaiga2 extends WorldGenerator {

    public WorldGenTaiga2() {}

    public boolean a(World world, Random random, int i, int j, int k) {
        int l = random.nextInt(4) + 6;
        int i1 = 1 + random.nextInt(2);
        int j1 = l - i1;
        int k1 = 2 + random.nextInt(2);
        boolean flag = true;

        if (j >= 1 && j + l + 1 <= 128) {
            int l1;
            int i2;
            int j2;
            int k2;

            for (l1 = j; l1 <= j + 1 + l && flag; ++l1) {
                boolean flag1 = true;

                if (l1 - j < i1) {
                    k2 = 0;
                } else {
                    k2 = k1;
                }

                for (i2 = i - k2; i2 <= i + k2 && flag; ++i2) {
                    for (int l2 = k - k2; l2 <= k + k2 && flag; ++l2) {
                        if (l1 >= 0 && l1 < 128) {
                            j2 = world.a(i2, l1, l2);
                            if (j2 != 0 && j2 != Block.K.bi) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                l1 = world.a(i, j - 1, k);
                if ((l1 == Block.u.bi || l1 == Block.v.bi) && j < 128 - l - 1) {
                    world.b(i, j - 1, k, Block.v.bi);
                    k2 = random.nextInt(2);
                    i2 = 1;
                    byte b1 = 0;

                    int i3;
                    int j3;

                    for (j2 = 0; j2 <= j1; ++j2) {
                        j3 = j + l - j2;

                        for (i3 = i - k2; i3 <= i + k2; ++i3) {
                            int k3 = i3 - i;

                            for (int l3 = k - k2; l3 <= k + k2; ++l3) {
                                int i4 = l3 - k;

                                if ((Math.abs(k3) != k2 || Math.abs(i4) != k2 || k2 <= 0) && !Block.o[world.a(i3, j3, l3)]) {
                                    world.a(i3, j3, l3, Block.K.bi, 1);
                                }
                            }
                        }

                        if (k2 >= i2) {
                            k2 = b1;
                            b1 = 1;
                            ++i2;
                            if (i2 > k1) {
                                i2 = k1;
                            }
                        } else {
                            ++k2;
                        }
                    }

                    j2 = random.nextInt(3);

                    for (j3 = 0; j3 < l - j2; ++j3) {
                        i3 = world.a(i, j + j3, k);
                        if (i3 == 0 || i3 == Block.K.bi) {
                            world.a(i, j + j3, k, Block.J.bi, 1);
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
