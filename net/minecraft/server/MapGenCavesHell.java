package net.minecraft.server;

import java.util.Random;

public class MapGenCavesHell extends MapGenBase {

    public MapGenCavesHell() {}

    protected void a(int i, int j, byte[] abyte, double d1, double d2, double d3) {
        this.a(i, j, abyte, d1, d2, d3, 1.0F + this.b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
    }

    protected void a(int i, int j, byte[] abyte, double d1, double d2, double d3, float f1, float f2, float f3, int k, int l, double d4) {
        double d5 = (double) (i * 16 + 8);
        double d6 = (double) (j * 16 + 8);
        float f4 = 0.0F;
        float f5 = 0.0F;
        Random random = new Random(this.b.nextLong());

        if (l <= 0) {
            int i1 = this.a * 16 - 16;

            l = i1 - random.nextInt(i1 / 4);
        }

        boolean flag = false;

        if (k == -1) {
            k = l / 2;
            flag = true;
        }

        int j1 = random.nextInt(l / 2) + l / 4;

        for (boolean flag1 = random.nextInt(6) == 0; k < l; ++k) {
            double d7 = 1.5D + (double) (MathHelper.a((float) k * 3.1415927F / (float) l) * f1 * 1.0F);
            double d8 = d7 * d4;
            float f6 = MathHelper.b(f3);
            float f7 = MathHelper.a(f3);

            d1 += (double) (MathHelper.b(f2) * f6);
            d2 += (double) f7;
            d3 += (double) (MathHelper.a(f2) * f6);
            if (flag1) {
                f3 *= 0.92F;
            } else {
                f3 *= 0.7F;
            }

            f3 += f5 * 0.1F;
            f2 += f4 * 0.1F;
            f5 *= 0.9F;
            f4 *= 0.75F;
            f5 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
            if (!flag && k == j1 && f1 > 1.0F) {
                this.a(i, j, abyte, d1, d2, d3, random.nextFloat() * 0.5F + 0.5F, f2 - 1.5707964F, f3 / 3.0F, k, l, 1.0D);
                this.a(i, j, abyte, d1, d2, d3, random.nextFloat() * 0.5F + 0.5F, f2 + 1.5707964F, f3 / 3.0F, k, l, 1.0D);
                return;
            }

            if (flag || random.nextInt(4) != 0) {
                double d9 = d1 - d5;
                double d10 = d3 - d6;
                double d11 = (double) (l - k);
                double d12 = (double) (f1 + 2.0F + 16.0F);

                if (d9 * d9 + d10 * d10 - d11 * d11 > d12 * d12) {
                    return;
                }

                if (d1 >= d5 - 16.0D - d7 * 2.0D && d3 >= d6 - 16.0D - d7 * 2.0D && d1 <= d5 + 16.0D + d7 * 2.0D && d3 <= d6 + 16.0D + d7 * 2.0D) {
                    int k1 = MathHelper.b(d1 - d7) - i * 16 - 1;
                    int l1 = MathHelper.b(d1 + d7) - i * 16 + 1;
                    int i2 = MathHelper.b(d2 - d8) - 1;
                    int j2 = MathHelper.b(d2 + d8) + 1;
                    int k2 = MathHelper.b(d3 - d7) - j * 16 - 1;
                    int l2 = MathHelper.b(d3 + d7) - j * 16 + 1;

                    if (k1 < 0) {
                        k1 = 0;
                    }

                    if (l1 > 16) {
                        l1 = 16;
                    }

                    if (i2 < 1) {
                        i2 = 1;
                    }

                    if (j2 > 120) {
                        j2 = 120;
                    }

                    if (k2 < 0) {
                        k2 = 0;
                    }

                    if (l2 > 16) {
                        l2 = 16;
                    }

                    boolean flag2 = false;

                    int i3;
                    int j3;

                    for (j3 = k1; !flag2 && j3 < l1; ++j3) {
                        for (int k3 = k2; !flag2 && k3 < l2; ++k3) {
                            for (int l3 = j2 + 1; !flag2 && l3 >= i2 - 1; --l3) {
                                i3 = (j3 * 16 + k3) * 128 + l3;
                                if (l3 >= 0 && l3 < 128) {
                                    if (abyte[i3] == Block.C.bi || abyte[i3] == Block.D.bi) {
                                        flag2 = true;
                                    }

                                    if (l3 != i2 - 1 && j3 != k1 && j3 != l1 - 1 && k3 != k2 && k3 != l2 - 1) {
                                        l3 = i2;
                                    }
                                }
                            }
                        }
                    }

                    if (!flag2) {
                        for (j3 = k1; j3 < l1; ++j3) {
                            double d13 = ((double) (j3 + i * 16) + 0.5D - d1) / d7;

                            for (i3 = k2; i3 < l2; ++i3) {
                                double d14 = ((double) (i3 + j * 16) + 0.5D - d3) / d7;
                                int i4 = (j3 * 16 + i3) * 128 + j2;

                                for (int j4 = j2 - 1; j4 >= i2; --j4) {
                                    double d15 = ((double) j4 + 0.5D - d2) / d8;

                                    if (d15 > -0.7D && d13 * d13 + d15 * d15 + d14 * d14 < 1.0D) {
                                        byte b1 = abyte[i4];

                                        if (b1 == Block.bb.bi || b1 == Block.v.bi || b1 == Block.u.bi) {
                                            abyte[i4] = 0;
                                        }
                                    }

                                    --i4;
                                }
                            }
                        }

                        if (flag) {
                            break;
                        }
                    }
                }
            }
        }
    }

    protected void a(World world, int i, int j, int k, int l, byte[] abyte) {
        int i1 = this.b.nextInt(this.b.nextInt(this.b.nextInt(10) + 1) + 1);

        if (this.b.nextInt(5) != 0) {
            i1 = 0;
        }

        for (int j1 = 0; j1 < i1; ++j1) {
            double d1 = (double) (i * 16 + this.b.nextInt(16));
            double d2 = (double) this.b.nextInt(128);
            double d3 = (double) (j * 16 + this.b.nextInt(16));
            int k1 = 1;

            if (this.b.nextInt(4) == 0) {
                this.a(k, l, abyte, d1, d2, d3);
                k1 += this.b.nextInt(4);
            }

            for (int l1 = 0; l1 < k1; ++l1) {
                float f1 = this.b.nextFloat() * 3.1415927F * 2.0F;
                float f2 = (this.b.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f3 = this.b.nextFloat() * 2.0F + this.b.nextFloat();

                this.a(k, l, abyte, d1, d2, d3, f3 * 2.0F, f1, f2, 0, 0, 0.5D);
            }
        }
    }
}
