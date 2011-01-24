package net.minecraft.server;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class EntityPlayerMP extends EntityPlayer {

    public NetServerHandler a;
    public MinecraftServer b;
    public ItemInWorldManager c;
    public double d;
    public double e;
    public List f = new LinkedList();
    public Set aj = new HashSet();
    public double ak;
    private int bu = -1;

    public EntityPlayerMP(MinecraftServer minecraftserver, World world, String s, ItemInWorldManager iteminworldmanager) {
        super(world);
        int i = world.m;
        int j = world.o;
        int k = world.n;

        if (!world.q.e) {
            i += this.W.nextInt(20) - 10;
            k = world.e(i, j);
            j += this.W.nextInt(20) - 10;
        }

        this.c((double) i + 0.5D, (double) k, (double) j + 0.5D, 0.0F, 0.0F);
        this.b = minecraftserver;
        this.S = 0.0F;
        iteminworldmanager.a = this;
        this.as = s;
        this.c = iteminworldmanager;
        this.H = 0.0F;
    }

    public void b_() {}

    public void f(Entity entity) {
        this.al.f();
    }

    public boolean a(Entity entity, int i) {
        if (!this.b.n) {
            if (entity instanceof EntityPlayer) {
                return false;
            }

            if (entity instanceof EntityArrow) {
                EntityArrow entityarrow = (EntityArrow) entity;

                if (entityarrow.b instanceof EntityPlayer) {
                    return false;
                }
            }
        }

        return super.a(entity, i);
    }

    public void a(int i) {
        super.a(i);
    }

    public void k() {
        super.b_();
        ChunkCoordIntPair chunkcoordintpair = null;
        double d1 = 0.0D;

        for (int i = 0; i < this.f.size(); ++i) {
            ChunkCoordIntPair chunkcoordintpair1 = (ChunkCoordIntPair) this.f.get(i);
            double d2 = chunkcoordintpair1.a(this);

            if (i == 0 || d2 < d1) {
                chunkcoordintpair = chunkcoordintpair1;
                d1 = chunkcoordintpair1.a(this);
            }
        }

        if (chunkcoordintpair != null) {
            boolean flag = false;

            if (d1 < 1024.0D) {
                flag = true;
            }

            if (this.a.b() < 2) {
                flag = true;
            }

            if (flag) {
                this.f.remove(chunkcoordintpair);
                this.a.b((Packet) (new Packet51MapChunk(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, 16, 128, 16, this.b.e)));
                List list = this.b.e.d(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, chunkcoordintpair.a * 16 + 16, 128, chunkcoordintpair.b * 16 + 16);

                for (int j = 0; j < list.size(); ++j) {
                    TileEntity tileentity = (TileEntity) list.get(j);

                    this.a.b((Packet) (new Packet59ComplexEntity(tileentity.b, tileentity.c, tileentity.d, tileentity)));
                }
            }
        }

        if (this.aQ != this.bu) {
            this.a.b((Packet) (new Packet8(this.aQ)));
            this.bu = this.aQ;
        }
    }

    public void E() {
        this.s = this.t = this.u = 0.0D;
        this.br = false;
        super.E();
    }

    public void c(Entity entity, int i) {
        if (!entity.G && entity instanceof EntityItem) {
            this.a.b((Packet) (new Packet17AddToInventory(((EntityItem) entity).a, i)));
            this.b.k.a(entity, new Packet22Collect(entity.g, this.g));
        }

        super.c(entity, i);
    }

    public void F() {
        if (!this.aq) {
            this.ar = -1;
            this.aq = true;
            this.b.k.a(this, new Packet18ArmAnimation(this, 1));
        }
    }

    public float s() {
        return 1.62F;
    }

    public void e(Entity entity) {
        super.e(entity);
        this.a.b((Packet) (new Packet39(this, this.k)));
        this.a.a(this.p, this.q, this.r, this.v, this.w);
    }

    public void G() {
        this.aQ = 20;
        int i = this.l.m;
        int j = this.l.o;
        int k = this.l.n;

        if (!this.l.q.e) {
            i += this.W.nextInt(20) - 10;
            k = this.l.e(i, j);
            j += this.W.nextInt(20) - 10;
        }

        this.a.a((double) i + 0.5D, (double) k, (double) j + 0.5D, 0.0F, 0.0F);
        this.a.b((Packet) (new Packet6SpawnPosition(i, k, j)));
        this.bu = -1;
        this.Z = 0;
        this.A = true;
        this.ad = 300;
        this.aa = 300;
        this.aZ = false;
        this.G = false;
    }

    protected void a(double d1, boolean flag) {}

    public void b(double d1, boolean flag) {
        super.a(d1, flag);
    }
}
