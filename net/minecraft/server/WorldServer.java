package net.minecraft.server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldServer extends World {

    public ChunkProviderServer A;
    public boolean B = false;
    public boolean C;
    private MinecraftServer D;
    private MCHashTable E = new MCHashTable();

    public WorldServer(MinecraftServer minecraftserver, File file1, String s, int i) {
        super(file1, s, (new Random()).nextLong(), WorldProvider.a(i));
        this.D = minecraftserver;
    }

    public void f() {
        super.f();
    }

    public void a(Entity entity, boolean flag) {
        if (!this.D.m && (entity instanceof EntityAnimals || entity instanceof EntityWaterMob)) {
            entity.q();
        }

        if (entity.j == null || !(entity.j instanceof EntityPlayer)) {
            super.a(entity, flag);
        }
    }

    public void b(Entity entity, boolean flag) {
        super.a(entity, flag);
    }

    protected IChunkProvider a(File file1) {
        this.A = new ChunkProviderServer(this, this.q.a(file1), this.q.c());
        return this.A;
    }

    public List d(int i, int j, int k, int l, int i1, int j1) {
        ArrayList arraylist = new ArrayList();

        for (int k1 = 0; k1 < this.c.size(); ++k1) {
            TileEntity tileentity = (TileEntity) this.c.get(k1);

            if (tileentity.b >= i && tileentity.c >= j && tileentity.d >= k && tileentity.b < l && tileentity.c < i1 && tileentity.d < j1) {
                arraylist.add(tileentity);
            }
        }

        return arraylist;
    }

    public boolean a(EntityPlayer entityplayer, int i, int j, int k) {
        int l = (int) MathHelper.e((float) (i - this.m));
        int i1 = (int) MathHelper.e((float) (k - this.o));

        if (l > i1) {
            i1 = l;
        }

        return i1 > 16 || this.D.f.g(entityplayer.aw);
    }

    protected void b(Entity entity) {
        super.b(entity);
        this.E.a(entity.g, entity);
    }

    protected void c(Entity entity) {
        super.c(entity);
        this.E.d(entity.g);
    }

    public Entity a(int i) {
        return (Entity) this.E.a(i);
    }

    public void a(Entity entity, byte b1) {
        Packet38 packet38 = new Packet38(entity.g, b1);

        this.D.k.b(entity, packet38);
    }

    public Explosion a(Entity entity, double d1, double d2, double d3, float f1, boolean flag) {
        Explosion explosion = super.a(entity, d1, d2, d3, f1, flag);

        this.D.f.a(d1, d2, d3, 64.0D, new Packet60(d1, d2, d3, f1, explosion.g));
        return explosion;
    }

    public void c(int i, int j, int k, int l, int i1) {
        super.c(i, j, k, l, i1);
        this.D.f.a((double) i, (double) j, (double) k, 64.0D, new Packet54(i, j, k, l, i1));
    }
}
