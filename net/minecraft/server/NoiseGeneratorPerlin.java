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

    public double b(double d1, double d2, double d3) {
        return d2 + d1 * (d3 - d2);
    }

    public double a(int i, double d1, double d2, double d3) {
        int j = i & 15;
        double d4 = j < 8 ? d1 : d2;
        double d5 = j < 4 ? d2 : (j != 12 && j != 14 ? d3 : d1);

        return ((j & 1) == 0 ? d4 : -d4) + ((j & 2) == 0 ? d5 : -d5);
    }

    public double a(double d1, double d2) {
        return this.a(d1, d2, 0.0D);
    }

    public void a(double[] adouble, double d1, double d2, double d3, int i, int j, int k, double d4, double d5, double d6, double d7) {
        int l = 0;
        double d8 = 1.0D / d7;
        int i1 = -1;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        double d9 = 0.0D;
        double d10 = 0.0D;
        double d11 = 0.0D;
        double d12 = 0.0D;

        for (int j1 = 0; j1 < i; ++j1) {
            double d13 = (d1 + (double) j1) * d4 + this.a;
            int k1 = (int) d13;

            if (d13 < (double) k1) {
                --k1;
            }

            int l1 = k1 & 255;

            d13 -= (double) k1;
            double d14 = d13 * d13 * d13 * (d13 * (d13 * 6.0D - 15.0D) + 10.0D);

            for (int i2 = 0; i2 < k; ++i2) {
                double d15 = (d3 + (double) i2) * d6 + this.c;
                int j2 = (int) d15;

                if (d15 < (double) j2) {
                    --j2;
                }

                int k2 = j2 & 255;

                d15 -= (double) j2;
                double d16 = d15 * d15 * d15 * (d15 * (d15 * 6.0D - 15.0D) + 10.0D);

                for (int l2 = 0; l2 < j; ++l2) {
                    double d17 = (d2 + (double) l2) * d5 + this.b;
                    int i3 = (int) d17;

                    if (d17 < (double) i3) {
                        --i3;
                    }

                    int j3 = i3 & 255;

                    d17 -= (double) i3;
                    double d18 = d17 * d17 * d17 * (d17 * (d17 * 6.0D - 15.0D) + 10.0D);

                    if (l2 == 0 || j3 != i1) {
                        i1 = j3;
                        int k3 = this.d[l1] + j3;
                        int l3 = this.d[k3] + k2;
                        int i4 = this.d[k3 + 1] + k2;
                        int j4 = this.d[l1 + 1] + j3;
                        int k4 = this.d[j4] + k2;
                        int l4 = this.d[j4 + 1] + k2;

                        d9 = this.b(d14, this.a(this.d[l3], d13, d17, d15), this.a(this.d[k4], d13 - 1.0D, d17, d15));
                        d10 = this.b(d14, this.a(this.d[i4], d13, d17 - 1.0D, d15), this.a(this.d[l4], d13 - 1.0D, d17 - 1.0D, d15));
                        d11 = this.b(d14, this.a(this.d[l3 + 1], d13, d17, d15 - 1.0D), this.a(this.d[k4 + 1], d13 - 1.0D, d17, d15 - 1.0D));
                        d12 = this.b(d14, this.a(this.d[i4 + 1], d13, d17 - 1.0D, d15 - 1.0D), this.a(this.d[l4 + 1], d13 - 1.0D, d17 - 1.0D, d15 - 1.0D));
                    }

                    double d19 = this.b(d18, d9, d10);
                    double d20 = this.b(d18, d11, d12);
                    double d21 = this.b(d16, d19, d20);
                    int i5 = l++;

                    adouble[i5] += d21 * d8;
                }
            }
        }
    }
}
