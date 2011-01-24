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
        boolean flag;
        int i1;
        boolean flag1;
        double d8;
        double d9;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;

        if (j == 1) {
            boolean flag2 = false;
            boolean flag3 = false;
            boolean flag4 = false;
            boolean flag5 = false;

            flag = false;
            flag1 = false;
            double d10 = 0.0D;
            double d11 = 0.0D;

            d8 = 0.0D;
            d9 = 0.0D;
            int k2 = 0;
            double d12 = 1.0D / d7;

            for (int l2 = 0; l2 < i; ++l2) {
                double d13 = (d1 + (double) l2) * d4 + this.a;
                int i3 = (int) d13;

                if (d13 < (double) i3) {
                    --i3;
                }

                j1 = i3 & 255;
                d13 -= (double) i3;
                double d14 = d13 * d13 * d13 * (d13 * (d13 * 6.0D - 15.0D) + 10.0D);

                for (int j3 = 0; j3 < k; ++j3) {
                    double d15 = (d3 + (double) j3) * d6 + this.c;
                    int k3 = (int) d15;

                    if (d15 < (double) k3) {
                        --k3;
                    }

                    l1 = k3 & 255;
                    d15 -= (double) k3;
                    double d16 = d15 * d15 * d15 * (d15 * (d15 * 6.0D - 15.0D) + 10.0D);

                    l = this.d[j1] + 0;
                    int l3 = this.d[l] + l1;
                    int i4 = this.d[l + 1] + l1;

                    i1 = this.d[j1 + 1] + 0;
                    j2 = this.d[i1] + l1;
                    i2 = this.d[i1 + 1] + l1;
                    d10 = this.b(d14, this.a(this.d[l3], d13, d15), this.a(this.d[j2], d13 - 1.0D, 0.0D, d15));
                    d8 = this.b(d14, this.a(this.d[l3 + 1], d13, 0.0D, d15 - 1.0D), this.a(this.d[j2 + 1], d13 - 1.0D, 0.0D, d15 - 1.0D));
                    double d17 = this.b(d16, d10, d8);

                    k1 = k2++;
                    adouble[k1] += d17 * d12;
                }
            }
        } else {
            l = 0;
            double d18 = 1.0D / d7;

            i1 = -1;
            flag = false;
            flag1 = false;
            boolean flag6 = false;
            boolean flag7 = false;
            boolean flag8 = false;
            boolean flag9 = false;

            d8 = 0.0D;
            d9 = 0.0D;
            double d19 = 0.0D;
            double d20 = 0.0D;

            for (int j4 = 0; j4 < i; ++j4) {
                double d21 = (d1 + (double) j4) * d4 + this.a;

                j1 = (int) d21;
                if (d21 < (double) j1) {
                    --j1;
                }

                int k4 = j1 & 255;

                d21 -= (double) j1;
                double d22 = d21 * d21 * d21 * (d21 * (d21 * 6.0D - 15.0D) + 10.0D);

                for (int l4 = 0; l4 < k; ++l4) {
                    double d23 = (d3 + (double) l4) * d6 + this.c;

                    l1 = (int) d23;
                    if (d23 < (double) l1) {
                        --l1;
                    }

                    int i5 = l1 & 255;

                    d23 -= (double) l1;
                    double d24 = d23 * d23 * d23 * (d23 * (d23 * 6.0D - 15.0D) + 10.0D);

                    for (int j5 = 0; j5 < j; ++j5) {
                        double d25 = (d2 + (double) j5) * d5 + this.b;
                        int k5 = (int) d25;

                        if (d25 < (double) k5) {
                            --k5;
                        }

                        int l5 = k5 & 255;

                        d25 -= (double) k5;
                        double d26 = d25 * d25 * d25 * (d25 * (d25 * 6.0D - 15.0D) + 10.0D);

                        if (j5 == 0 || l5 != i1) {
                            i1 = l5;
                            j2 = this.d[k4] + l5;
                            i2 = this.d[j2] + i5;
                            int i6 = this.d[j2 + 1] + i5;
                            int j6 = this.d[k4 + 1] + l5;
                            int k6 = this.d[j6] + i5;
                            int l6 = this.d[j6 + 1] + i5;

                            d8 = this.b(d22, this.a(this.d[i2], d21, d25, d23), this.a(this.d[k6], d21 - 1.0D, d25, d23));
                            d9 = this.b(d22, this.a(this.d[i6], d21, d25 - 1.0D, d23), this.a(this.d[l6], d21 - 1.0D, d25 - 1.0D, d23));
                            d19 = this.b(d22, this.a(this.d[i2 + 1], d21, d25, d23 - 1.0D), this.a(this.d[k6 + 1], d21 - 1.0D, d25, d23 - 1.0D));
                            d20 = this.b(d22, this.a(this.d[i6 + 1], d21, d25 - 1.0D, d23 - 1.0D), this.a(this.d[l6 + 1], d21 - 1.0D, d25 - 1.0D, d23 - 1.0D));
                        }

                        double d27 = this.b(d26, d8, d9);
                        double d28 = this.b(d26, d19, d20);
                        double d29 = this.b(d24, d27, d28);

                        k1 = l++;
                        adouble[k1] += d29 * d18;
                    }
                }
            }
        }
    }
}
