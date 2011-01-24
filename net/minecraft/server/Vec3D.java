package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;

public class Vec3D {

    private static List d = new ArrayList();
    private static int e = 0;
    public double a;
    public double b;
    public double c;

    public static Vec3D a(double d1, double d2, double d3) {
        return new Vec3D(d1, d2, d3);
    }

    public static void a() {
        e = 0;
    }

    public static Vec3D b(double d1, double d2, double d3) {
        if (e >= d.size()) {
            d.add(a(0.0D, 0.0D, 0.0D));
        }

        return ((Vec3D) d.get(e++)).e(d1, d2, d3);
    }

    private Vec3D(double d1, double d2, double d3) {
        if (d1 == -0.0D) {
            d1 = 0.0D;
        }

        if (d2 == -0.0D) {
            d2 = 0.0D;
        }

        if (d3 == -0.0D) {
            d3 = 0.0D;
        }

        this.a = d1;
        this.b = d2;
        this.c = d3;
    }

    private Vec3D e(double d1, double d2, double d3) {
        this.a = d1;
        this.b = d2;
        this.c = d3;
        return this;
    }

    public Vec3D b() {
        double d1 = (double) MathHelper.a(this.a * this.a + this.b * this.b + this.c * this.c);

        return d1 < 1.0E-4D ? b(0.0D, 0.0D, 0.0D) : b(this.a / d1, this.b / d1, this.c / d1);
    }

    public Vec3D c(double d1, double d2, double d3) {
        return b(this.a + d1, this.b + d2, this.c + d3);
    }

    public double a(Vec3D vec3d) {
        double d1 = vec3d.a - this.a;
        double d2 = vec3d.b - this.b;
        double d3 = vec3d.c - this.c;

        return (double) MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);
    }

    public double b(Vec3D vec3d) {
        double d1 = vec3d.a - this.a;
        double d2 = vec3d.b - this.b;
        double d3 = vec3d.c - this.c;

        return d1 * d1 + d2 * d2 + d3 * d3;
    }

    public double d(double d1, double d2, double d3) {
        double d4 = d1 - this.a;
        double d5 = d2 - this.b;
        double d6 = d3 - this.c;

        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double c() {
        return (double) MathHelper.a(this.a * this.a + this.b * this.b + this.c * this.c);
    }

    public Vec3D a(Vec3D vec3d, double d1) {
        double d2 = vec3d.a - this.a;
        double d3 = vec3d.b - this.b;
        double d4 = vec3d.c - this.c;

        if (d2 * d2 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double d5 = (d1 - this.a) / d2;

            return d5 >= 0.0D && d5 <= 1.0D ? b(this.a + d2 * d5, this.b + d3 * d5, this.c + d4 * d5) : null;
        }
    }

    public Vec3D b(Vec3D vec3d, double d1) {
        double d2 = vec3d.a - this.a;
        double d3 = vec3d.b - this.b;
        double d4 = vec3d.c - this.c;

        if (d3 * d3 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double d5 = (d1 - this.b) / d3;

            return d5 >= 0.0D && d5 <= 1.0D ? b(this.a + d2 * d5, this.b + d3 * d5, this.c + d4 * d5) : null;
        }
    }

    public Vec3D c(Vec3D vec3d, double d1) {
        double d2 = vec3d.a - this.a;
        double d3 = vec3d.b - this.b;
        double d4 = vec3d.c - this.c;

        if (d4 * d4 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double d5 = (d1 - this.c) / d4;

            return d5 >= 0.0D && d5 <= 1.0D ? b(this.a + d2 * d5, this.b + d3 * d5, this.c + d4 * d5) : null;
        }
    }

    public String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + ")";
    }
}
