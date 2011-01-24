package net.minecraft.server;

import java.util.Arrays;

public class WorldChunkManagerHell extends WorldChunkManager {

    private MobSpawnerBase e;
    private double f;
    private double g;

    public WorldChunkManagerHell(MobSpawnerBase mobspawnerbase, double d1, double d2) {
        this.e = mobspawnerbase;
        this.f = d1;
        this.g = d2;
    }

    public MobSpawnerBase a(ChunkCoordIntPair chunkcoordintpair) {
        return this.e;
    }

    public MobSpawnerBase a(int i, int j) {
        return this.e;
    }

    public MobSpawnerBase[] a(int i, int j, int k, int l) {
        this.d = this.a(this.d, i, j, k, l);
        return this.d;
    }

    public double[] a(double[] adouble, int i, int j, int k, int l) {
        if (adouble == null || adouble.length < k * l) {
            adouble = new double[k * l];
        }

        Arrays.fill(adouble, 0, k * l, this.f);
        return adouble;
    }

    public MobSpawnerBase[] a(MobSpawnerBase[] amobspawnerbase, int i, int j, int k, int l) {
        if (amobspawnerbase == null || amobspawnerbase.length < k * l) {
            amobspawnerbase = new MobSpawnerBase[k * l];
            this.a = new double[k * l];
            this.b = new double[k * l];
        }

        Arrays.fill(amobspawnerbase, 0, k * l, this.e);
        Arrays.fill(this.b, 0, k * l, this.g);
        Arrays.fill(this.a, 0, k * l, this.f);
        return amobspawnerbase;
    }
}
