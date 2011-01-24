package net.minecraft.server;

public enum EnumCreatureType {

    a("monster", 0, IMobs.class, 100), b("creature", 1, EntityAnimals.class, 20);
    public final Class c;
    public final int d;

    private static final EnumCreatureType[] e = new EnumCreatureType[] { a, b};

    private EnumCreatureType(String s, int i, Class oclass, int j) {
        this.c = oclass;
        this.d = j;
    }
}
