package net.minecraft.server;

public enum EnumCreatureType {

    a("monster", 0, IMobs.class, 100, Material.a, false), b("creature", 1, EntityAnimals.class, 20, Material.a, true), c("waterCreature", 2, EntityWaterMob.class, 5, Material.f, true);
    private final Class d;
    private final int e;
    private final Material f;
    private final boolean g;

    private static final EnumCreatureType[] h = new EnumCreatureType[] { a, b, c};

    private EnumCreatureType(String s, int i, Class oclass, int j, Material material, boolean flag) {
        this.d = oclass;
        this.e = j;
        this.f = material;
        this.g = flag;
    }

    public Class a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public Material c() {
        return this.f;
    }

    public boolean d() {
        return this.g;
    }
}
