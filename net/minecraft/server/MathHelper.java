package net.minecraft.server;

public class MathHelper {

    private static float[] a = new float[65536];

    public MathHelper() {}

    public static final float a(float f1) {
        return a[(int) (f1 * 10430.378F) & '\uffff'];
    }

    public static final float b(float f1) {
        return a[(int) (f1 * 10430.378F + 16384.0F) & '\uffff'];
    }

    public static final float c(float f1) {
        return (float) Math.sqrt((double) f1);
    }

    public static final float a(double d1) {
        return (float) Math.sqrt(d1);
    }

    public static int d(float f1) {
        int i = (int) f1;

        return f1 < (float) i ? i - 1 : i;
    }

    public static int b(double d1) {
        int i = (int) d1;

        return d1 < (double) i ? i - 1 : i;
    }

    public static float e(float f1) {
        return f1 >= 0.0F ? f1 : -f1;
    }

    public static double a(double d1, double d2) {
        if (d1 < 0.0D) {
            d1 = -d1;
        }

        if (d2 < 0.0D) {
            d2 = -d2;
        }

        return d1 > d2 ? d1 : d2;
    }

    static {
        for (int i = 0; i < 65536; ++i) {
            a[i] = (float) Math.sin((double) i * 3.141592653589793D * 2.0D / 65536.0D);
        }
    }
}
