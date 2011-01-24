package net.minecraft.server;

import java.util.Random;

public class NoiseGeneratorOctaves2 extends NoiseGenerator {

    private NoiseGenerator2[] a;
    private int b;

    public NoiseGeneratorOctaves2(Random random, int i) {
        this.b = i;
        this.a = new NoiseGenerator2[i];

        for (int j = 0; j < i; ++j) {
            this.a[j] = new NoiseGenerator2(random);
        }
    }

    public double[] a(double[] adouble, double d1, double d2, int i, int j, double d3, double d4, double d5) {
        return this.a(adouble, d1, d2, i, j, d3, d4, d5, 0.5D);
    }

    public double[] a(double[] adouble, double d1, double d2, int i, int j, double d3, double d4, double d5, double d6) {
        d3 /= 1.5D;
        d4 /= 1.5D;
        if (adouble != null && adouble.length >= i * j) {
            for (int k = 0; k < adouble.length; ++k) {
                adouble[k] = 0.0D;
            }
        } else {
            adouble = new double[i * j];
        }

        double d7 = 1.0D;
        double d8 = 1.0D;

        for (int l = 0; l < this.b; ++l) {
            this.a[l].a(adouble, d1, d2, i, j, d3 * d8, d4 * d8, 0.55D / d7);
            d8 *= d5;
            d7 *= d6;
        }

        return adouble;
    }
}
