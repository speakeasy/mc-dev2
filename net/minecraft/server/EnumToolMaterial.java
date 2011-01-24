package net.minecraft.server;

public enum EnumToolMaterial {

    a("WOOD", 0, 0, 59, 2.0F, 0), b("STONE", 1, 1, 131, 4.0F, 1), c("IRON", 2, 2, 250, 6.0F, 2), d("EMERALD", 3, 3, 1561, 8.0F, 3), e("GOLD", 4, 0, 32, 12.0F, 0);
    private final int f;
    private final int g;
    private final float h;
    private final int i;

    private static final EnumToolMaterial[] j = new EnumToolMaterial[] { a, b, c, d, e};

    private EnumToolMaterial(String s, int i, int j, int k, float f1, int l) {
        this.f = j;
        this.g = k;
        this.h = f1;
        this.i = l;
    }

    public int a() {
        return this.g;
    }

    public float b() {
        return this.h;
    }

    public int c() {
        return this.i;
    }

    public int d() {
        return this.f;
    }
}
