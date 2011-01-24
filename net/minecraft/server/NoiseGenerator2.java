package net.minecraft.server;

import java.util.Random;

public class NoiseGenerator2 {

    private static int[][] d = new int[][] { { 1, 1, 0}, { -1, 1, 0}, { 1, -1, 0}, { -1, -1, 0}, { 1, 0, 1}, { -1, 0, 1}, { 1, 0, -1}, { -1, 0, -1}, { 0, 1, 1}, { 0, -1, 1}, { 0, 1, -1}, { 0, -1, -1}};
    private int[] e;
    public double a;
    public double b;
    public double c;
    private static final double f = 0.5D * (Math.sqrt(3.0D) - 1.0D);
    private static final double g = (3.0D - Math.sqrt(3.0D)) / 6.0D;

    public NoiseGenerator2() {
        this(new Random());
    }

    public NoiseGenerator2(Random random) {
        this.e = new int[512];
        this.a = random.nextDouble() * 256.0D;
        this.b = random.nextDouble() * 256.0D;
        this.c = random.nextDouble() * 256.0D;

        int i;

        for (i = 0; i < 256; this.e[i] = i++) {
            ;
        }

        for (i = 0; i < 256; ++i) {
            int j = random.nextInt(256 - i) + i;
            int k = this.e[i];

            this.e[i] = this.e[j];
            this.e[j] = k;
            this.e[i + 256] = this.e[i];
        }
    }

    private static int a(double d1) {
        return d1 > 0.0D ? (int) d1 : (int) d1 - 1;
    }

    private static double a(int[] aint, double d1, double d2) {
        return (double) aint[0] * d1 + (double) aint[1] * d2;
    }

    public void a(double[] adouble, double d1, double d2, int i, int j, double d3, double d4, double d5) {
        int k = 0;

        for (int l = 0; l < i; ++l) {
            double d6 = (d1 + (double) l) * d3 + this.a;

            for (int i1 = 0; i1 < j; ++i1) {
                double d7 = (d2 + (double) i1) * d4 + this.b;
                double d8 = (d6 + d7) * f;
                int j1 = a(d6 + d8);
                int k1 = a(d7 + d8);
                double d9 = (double) (j1 + k1) * g;
                double d10 = (double) j1 - d9;
                double d11 = (double) k1 - d9;
                double d12 = d6 - d10;
                double d13 = d7 - d11;
                byte b1;
                byte b2;

                if (d12 > d13) {
                    b1 = 1;
                    b2 = 0;
                } else {
                    b1 = 0;
                    b2 = 1;
                }

                double d14 = d12 - (double) b1 + g;
                double d15 = d13 - (double) b2 + g;
                double d16 = d12 - 1.0D + 2.0D * g;
                double d17 = d13 - 1.0D + 2.0D * g;
                int l1 = j1 & 255;
                int i2 = k1 & 255;
                int j2 = this.e[l1 + this.e[i2]] % 12;
                int k2 = this.e[l1 + b1 + this.e[i2 + b2]] % 12;
                int l2 = this.e[l1 + 1 + this.e[i2 + 1]] % 12;
                double d18 = 0.5D - d12 * d12 - d13 * d13;
                double d19;

                if (d18 < 0.0D) {
                    d19 = 0.0D;
                } else {
                    d18 *= d18;
                    d19 = d18 * d18 * a(d[j2], d12, d13);
                }

                double d20 = 0.5D - d14 * d14 - d15 * d15;
                double d21;

                if (d20 < 0.0D) {
                    d21 = 0.0D;
                } else {
                    d20 *= d20;
                    d21 = d20 * d20 * a(d[k2], d14, d15);
                }

                double d22 = 0.5D - d16 * d16 - d17 * d17;
                double d23;

                if (d22 < 0.0D) {
                    d23 = 0.0D;
                } else {
                    d22 *= d22;
                    d23 = d22 * d22 * a(d[l2], d16, d17);
                }

                int i3 = k++;

                adouble[i3] += 70.0D * (d19 + d21 + d23) * d5;
            }
        }
    }
}
