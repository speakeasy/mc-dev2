package net.minecraft.server;

public class WorldManager implements IWorldAccess {

    private MinecraftServer a;

    public WorldManager(MinecraftServer minecraftserver) {
        this.a = minecraftserver;
    }

    public void a(String s, double d1, double d2, double d3, double d4, double d5, double d6) {}

    public void a(Entity entity) {
        this.a.k.a(entity);
    }

    public void b(Entity entity) {
        this.a.k.b(entity);
    }

    public void a(String s, double d1, double d2, double d3, float f1, float f2) {}

    public void a(int i, int j, int k, int l, int i1, int j1) {}

    public void a() {}

    public void a(int i, int j, int k) {
        this.a.f.a(i, j, k);
    }

    public void a(String s, int i, int j, int k) {}

    public void a(int i, int j, int k, TileEntity tileentity) {
        this.a.f.a(i, j, k, tileentity);
    }
}
