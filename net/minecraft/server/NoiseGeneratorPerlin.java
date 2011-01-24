package net.minecraft.server;

import java.util.Random;

public class NoiseGeneratorPerlin extends NoiseGenerator {

    private int[] d;
    public double a;
    public double b;
    public double c;

    public NoiseGeneratorPerlin() {
        this(new Random());
    }

    public NoiseGeneratorPerlin(Random random) {
        this.d = new int[512];
        this.a = random.nextDouble() * 256.0D;
        this.b = random.nextDouble() * 256.0D;
        this.c = random.nextDouble() * 256.0D;

        int i;

        for (i = 0; i < 256; this.d[i] = i++) {
            ;
        }

        for (i = 0; i < 256; ++i) {
            int j = random.nextInt(256 - i) + i;
            int k = this.d[i];

            this.d[i] = this.d[j];
            this.d[j] = k;
            this.d[i + 256] = this.d[i];
        }
    }

    public double a(double d1, double d2, double d3) {
        double d4 = d1 + this.a;
        double d5 = d2 + this.b;
        double d6 = d3 + this.c;
        int i = (int) d4;
        int j = (int) d5;
        int k = (int) d6;

        if (d4 < (double) i) {
            --i;
        }

        if (d5 < (double) j) {
            --j;
        }

        if (d6 < (double) k) {
            --k;
        }

        int l = i & 255;
        int i1 = j & 255;
        int j1 = k & 255;

        d4 -= (double) i;
        d5 -= (double) j;
        d6 -= (double) k;
        double d7 = d4 * d4 * d4 * (d4 * (d4 * 6.0D - 15.0D) + 10.0D);
        double d8 = d5 * d5 * d5 * (d5 * (d5 * 6.0D - 15.0D) + 10.0D);
        double d9 = d6 * d6 * d6 * (d6 * (d6 * 6.0D - 15.0D) + 10.0D);
        int k1 = this.d[l] + i1;
        int l1 = this.d[k1] + j1;
        int i2 = this.d[k1 + 1] + j1;
        int j2 = this.d[l + 1] + i1;
        int k2 = this.d[j2] + j1;
        int l2 = this.d[j2 + 1] + j1;

        return this.b(d9, this.b(d8, this.b(d7, this.a(this.d[l1], d4, d5, d6), this.a(this.d[k2], d4 - 1.0D, d5, d6)), this.b(d7, this.a(this.d[i2], d4, d5 - 1.0D, d6), this.a(this.d[l2], d4 - 1.0D, d5 - 1.0D, d6))), this.b(d8, this.b(d7, this.a(this.d[l1 + 1], d4, d5, d6 - 1.0D), this.a(this.d[k2 + 1], d4 - 1.0D, d5, d6 - 1.0D)), this.b(d7, this.a(this.d[i2 + 1], d4, d5 - 1.0D, d6 - 1.0D), this.a(this.d[l2 + 1], d4 - 1.0D, d5 - 1.0D, d6 - 1.0D))));
    }

    public final double b(double d1, double d2, double d3) {
        return d2 + d1 * (d3 - d2);
    }

    public final double a(int i, double d1, double d2) {
        int j = i & 15;
        double d3 = (double) (1 - ((j & 8) >> 3)) * d1;
        double d4 = j < 4 ? 0.0D : (j != 12 && j != 14 ? d2 : d1);

        return ((j & 1) == 0 ? d3 : -d3) + ((j & 2) == 0 ? d4 : -d4);
    }

    public final double a(int i, double d1, double d2, double d3) {
        int j = i & 15;
        double d4 = j < 8 ? d1 : d2;
        double d5 = j < 4 ? d2 : (j != 12 && j != 14 ? d3 : d1);

        return ((j & 1) == 0 ? d4 : -d4) + ((j & 2) == 0 ? d5 : -d5);
    }

    public double a(double d1, double d2) {
        return this.a(d1, d2, 0.0D);
    }

    public void a(double[] adouble, double d1, double d2, double d3, int i, int j, int k, double d4, double d5, double d6, double d7) {
        int l;
        int i1;
        double d8;
        double d9;
        double d10;
        int j1;
        double d11;
        int k1;
        int l1;
        int i2;
        int j2;

        if (j == 1) {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            double d12 = 0.0D;
            double d13 = 0.0D;

            j2 = 0;
            double d14 = 1.0D / d7;

            for (int k2 = 0; k2 < i; ++k2) {
                d8 = (d1 + (double) k2) * d4 + this.a;
                int l2 = (int) d8;

                if (d8 < (double) l2) {
                    --l2;
                }

                int i3 = l2 & 255;

                d8 -= (double) l2;
                d9 = d8 * d8 * d8 * (d8 * (d8 * 6.0D - 15.0D) + 10.0D);

                for (j1 = 0; j1 < k; ++j1) {
                    d10 = (d3 + (double) j1) * d6 + this.c;
                    k1 = (int) d10;
                    if (d10 < (double) k1) {
                        --k1;
                    }

                    l1 = k1 & 255;
                    d10 -= (double) k1;
                    d11 = d10 * d10 * d10 * (d10 * (d10 * 6.0D - 15.0D) + 10.0D);
                    l = this.d[i3] + 0;
                    int j3 = this.d[l] + l1;
                    int k3 = this.d[i3 + 1] + 0;

                    i1 = this.d[k3] + l1;
                    d12 = this.b(d9, this.a(this.d[j3], d8, d10), this.a(this.d[i1], d8 - 1.0D, 0.0D, d10));
                    d13 = this.b(d9, this.a(this.d[j3 + 1], d8, 0.0D, d10 - 1.0D), this.a(this.d[i1 + 1], d8 - 1.0D, 0.0D, d10 - 1.0D));
                    double d15 = this.b(d11, d12, d13);

                    i2 = j2++;
                    adouble[i2] += d15 * d14;
                }
            }
        } else {
            l = 0;
            double d16 = 1.0D / d7;

            i1 = -1;
            boolean flag4 = false;
            boolean flag5 = false;
            boolean flag6 = false;
            boolean flag7 = false;
            boolean flag8 = false;
            boolean flag9 = false;
            double d17 = 0.0D;

            d8 = 0.0D;
            double d18 = 0.0D;

            d9 = 0.0D;

            for (j1 = 0; j1 < i; ++j1) {
                d10 = (d1 + (double) j1) * d4 + this.a;
                k1 = (int) d10;
                if (d10 < (double) k1) {
                    --k1;
                }

                l1 = k1 & 255;
                d10 -= (double) k1;
                d11 = d10 * d10 * d10 * (d10 * (d10 * 6.0D - 15.0D) + 10.0D);

                for (int l3 = 0; l3 < k; ++l3) {
                    double d19 = (d3 + (double) l3) * d6 + this.c;
                    int i4 = (int) d19;

                    if (d19 < (double) i4) {
                        --i4;
                    }

                    int j4 = i4 & 255;

                    d19 -= (double) i4;
                    double d20 = d19 * d19 * d19 * (d19 * (d19 * 6.0D - 15.0D) + 10.0D);

                    for (int k4 = 0; k4 < j; ++k4) {
                        double d21 = (d2 + (double) k4) * d5 + this.b;
                        int l4 = (int) d21;

                        if (d21 < (double) l4) {
                            --l4;
                        }

                        int i5 = l4 & 255;

                        d21 -= (double) l4;
                        double d22 = d21 * d21 * d21 * (d21 * (d21 * 6.0D - 15.0D) + 10.0D);

                        if (k4 == 0 || i5 != i1) {
                            i1 = i5;
                            int j5 = this.d[l1] + i5;
                            int k5 = this.d[j5] + j4;
                            int l5 = this.d[j5 + 1] + j4;
                            int i6 = this.d[l1 + 1] + i5;

                            j2 = this.d[i6] + j4;
                            int j6 = this.d[i6 + 1] + j4;

                            d17 = this.b(d11, this.a(this.d[k5], d10, d21, d19), this.a(this.d[j2], d10 - 1.0D, d21, d19));
                            d8 = this.b(d11, this.a(this.d[l5], d10, d21 - 1.0D, d19), this.a(this.d[j6], d10 - 1.0D, d21 - 1.0D, d19));
                            d18 = this.b(d11, this.a(this.d[k5 + 1], d10, d21, d19 - 1.0D), this.a(this.d[j2 + 1], d10 - 1.0D, d21, d19 - 1.0D));
                            d9 = this.b(d11, this.a(this.d[l5 + 1], d10, d21 - 1.0D, d19 - 1.0D), this.a(this.d[j6 + 1], d10 - 1.0D, d21 - 1.0D, d19 - 1.0D));
                        }

                        double d23 = this.b(d22, d17, d8);
                        double d24 = this.b(d22, d18, d9);
                        double d25 = this.b(d20, d23, d24);

                        i2 = l++;
                        adouble[i2] += d25 * d16;
                    }
                }
            }
        }
    }
}
