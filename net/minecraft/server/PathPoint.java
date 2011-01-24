package net.minecraft.server;

public class PathPoint {

    public final int a;
    public final int b;
    public final int c;
    public final int d;
    int e = -1;
    float f;
    float g;
    float h;
    PathPoint i;
    public boolean j = false;

    public PathPoint(int i, int j, int k) {
        this.a = i;
        this.b = j;
        this.c = k;
        this.d = i | j << 10 | k << 20;
    }

    public float a(PathPoint pathpoint) {
        float f1 = (float) (pathpoint.a - this.a);
        float f2 = (float) (pathpoint.b - this.b);
        float f3 = (float) (pathpoint.c - this.c);

        return MathHelper.c(f1 * f1 + f2 * f2 + f3 * f3);
    }

    public boolean equals(Object object) {
        return ((PathPoint) object).d == this.d;
    }

    public int hashCode() {
        return this.d;
    }

    public boolean a() {
        return this.e >= 0;
    }

    public String toString() {
        return this.a + ", " + this.b + ", " + this.c;
    }
}
