package net.minecraft.server;

import java.io.File;

public class WorldProviderHell extends WorldProvider {

    public WorldProviderHell() {}

    public void a() {
        this.b = new WorldChunkManagerHell(MobSpawnerBase.l, 1.0D, 0.0D);
        this.c = true;
        this.d = true;
        this.e = true;
        this.g = -1;
    }

    protected void b() {
        float f1 = 0.1F;

        for (int i = 0; i <= 15; ++i) {
            float f2 = 1.0F - (float) i / 15.0F;

            this.f[i] = (1.0F - f2) / (f2 * 3.0F + 1.0F) * (1.0F - f1) + f1;
        }
    }

    public IChunkProvider c() {
        return new ChunkProviderHell(this.a, this.a.u);
    }

    public IChunkLoader a(File file1) {
        File file2 = new File(file1, "DIM-1");

        file2.mkdirs();
        return new ChunkLoader(file2, true);
    }

    public boolean a(int i, int j) {
        int k = this.a.a(i, j);

        return k == Block.z.bh ? false : (k == 0 ? false : Block.o[k]);
    }

    public float a(long i, float f1) {
        return 0.5F;
    }
}
