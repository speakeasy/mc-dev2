package net.minecraft.server;

public enum EnumSkyBlock {

    a("Sky", 0, 15), b("Block", 1, 0);
    public final int c;

    private static final EnumSkyBlock[] d = new EnumSkyBlock[] { a, b};

    private EnumSkyBlock(String s, int i, int j) {
        this.c = j;
    }
}
