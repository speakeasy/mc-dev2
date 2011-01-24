package net.minecraft.server;

import java.util.Random;

public class NoiseGeneratorOctaves extends NoiseGenerator {

    private NoiseGeneratorPerlin[] a;
    private int b;

    public NoiseGeneratorOctaves(Random random, int i) {
        this.b = i;
        this.a = new NoiseGeneratorPerlin[i];

        for (int j = 0; j < i; ++j) {
            this.a[j] = new NoiseGeneratorPerlin(random);
        }
    }

    public double a(double d1, double d2) {
        double d3 = 0.0D;
        double d4 = 1.0D;

        for (int i = 0; i < this.b; ++i) {
            d3 += this.a[i].a(d1 * d4, d2 * d4) / d4;
            d4 /= 2.0D;
        }

        return d3;
    }

    public double[] a(double[] adouble, double d1, double d2, double d3, int i, int j, int k, double d4, double d5, double d6) {
        if (adouble == null) {
            adouble = new double[i * j * k];
        } else {
            for (int l = 0; l < adouble.length; ++l) {
                adouble[l] = 0.0D;
            }
        }

        double d7 = 1.0D;

        for (int i1 = 0; i1 < this.b; ++i1) {
            this.a[i1].a(adouble, d1, d2, d3, i, j, k, d4 * d7, d5 * d7, d6 * d7, d7);
            d7 /= 2.0D;
        }

        return adouble;
    }

    public double[] a(double[] adouble, int i, int j, int k, int l, double d1, double d2, double d3) {
        return this.a(adouble, (double) i, 10.0D, (double) j, k, 1, l, d1, 1.0D, d2);
    }
}
