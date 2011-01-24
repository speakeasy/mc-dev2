package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class World implements IBlockAccess {

    public boolean a = false;
    private List A = new ArrayList();
    public List b = new ArrayList();
    private List B = new ArrayList();
    private TreeSet C = new TreeSet();
    private Set D = new HashSet();
    public List c = new ArrayList();
    public List d = new ArrayList();
    public long e = 0L;
    private long E = 16777215L;
    public int f = 0;
    protected int g = (new Random()).nextInt();
    protected int h = 1013904223;
    public boolean i = false;
    private long F = System.currentTimeMillis();
    protected int j = 40;
    public int k;
    public Random l = new Random();
    public int m;
    public int n;
    public int o;
    public boolean p = false;
    public final WorldProvider q;
    protected List r = new ArrayList();
    private IChunkProvider G;
    public File s;
    public File t;
    public long u = 0L;
    private NBTTagCompound H;
    public long v = 0L;
    public final String w;
    public boolean x;
    private ArrayList I = new ArrayList();
    private int J = 0;
    static int y = 0;
    private Set K = new HashSet();
    private int L;
    private List M;
    public boolean z;

    public WorldChunkManager a() {
        return this.q.b;
    }

    public World(File file1, String s, long i, WorldProvider worldprovider) {
        this.L = this.l.nextInt(12000);
        this.M = new ArrayList();
        this.z = false;
        this.s = file1;
        this.w = s;
        file1.mkdirs();
        this.t = new File(file1, s);
        this.t.mkdirs();

        try {
            File file2 = new File(this.t, "session.lock");
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file2));

            try {
                dataoutputstream.writeLong(this.F);
            } finally {
                dataoutputstream.close();
            }
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }

        Object object = new WorldProvider();
        File file3 = new File(this.t, "level.dat");

        this.p = !file3.exists();
        if (file3.exists()) {
            try {
                NBTTagCompound nbttagcompound = CompressedStreamTools.a((InputStream) (new FileInputStream(file3)));
                NBTTagCompound nbttagcompound1 = nbttagcompound.j("Data");

                this.u = nbttagcompound1.e("RandomSeed");
                this.m = nbttagcompound1.d("SpawnX");
                this.n = nbttagcompound1.d("SpawnY");
                this.o = nbttagcompound1.d("SpawnZ");
                this.e = nbttagcompound1.e("Time");
                this.v = nbttagcompound1.e("SizeOnDisk");
                if (nbttagcompound1.a("Player")) {
                    this.H = nbttagcompound1.j("Player");
                    int j = this.H.d("Dimension");

                    if (j == -1) {
                        object = new WorldProviderHell();
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        if (worldprovider != null) {
            object = worldprovider;
        }

        boolean flag = false;

        if (this.u == 0L) {
            this.u = i;
            flag = true;
        }

        this.q = (WorldProvider) object;
        this.q.a(this);
        this.G = this.a(this.t);
        if (flag) {
            this.x = true;
            this.m = 0;
            this.n = 64;

            for (this.o = 0; !this.q.a(this.m, this.o); this.o += this.l.nextInt(64) - this.l.nextInt(64)) {
                this.m += this.l.nextInt(64) - this.l.nextInt(64);
            }

            this.x = false;
        }

        this.e();
    }

    protected IChunkProvider a(File file1) {
        return new ChunkProviderLoadOrGenerate(this, this.q.a(file1), this.q.c());
    }

    public int a(int i, int j) {
        int k;

        for (k = 63; !this.e(i, k + 1, j); ++k) {
            ;
        }

        return this.a(i, k, j);
    }

    public void a(boolean flag, IProgressUpdate iprogressupdate) {
        if (this.G.b()) {
            if (iprogressupdate != null) {
                iprogressupdate.a("Saving level");
            }

            this.i();
            if (iprogressupdate != null) {
                iprogressupdate.b("Saving chunks");
            }

            this.G.a(flag, iprogressupdate);
        }
    }

    private void i() {
        this.h();
        NBTTagCompound nbttagcompound = new NBTTagCompound();

        nbttagcompound.a("RandomSeed", this.u);
        nbttagcompound.a("SpawnX", this.m);
        nbttagcompound.a("SpawnY", this.n);
        nbttagcompound.a("SpawnZ", this.o);
        nbttagcompound.a("Time", this.e);
        nbttagcompound.a("SizeOnDisk", this.v);
        nbttagcompound.a("LastPlayed", System.currentTimeMillis());
        EntityPlayer entityplayer = null;

        if (this.d.size() > 0) {
            entityplayer = (EntityPlayer) this.d.get(0);
        }

        NBTTagCompound nbttagcompound1;

        if (entityplayer != null) {
            nbttagcompound1 = new NBTTagCompound();
            entityplayer.d(nbttagcompound1);
            nbttagcompound.a("Player", nbttagcompound1);
        }

        nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.a("Data", (NBTBase) nbttagcompound);

        try {
            File file1 = new File(this.t, "level.dat_new");
            File file2 = new File(this.t, "level.dat_old");
            File file3 = new File(this.t, "level.dat");

            CompressedStreamTools.a(nbttagcompound1, (OutputStream) (new FileOutputStream(file1)));
            if (file2.exists()) {
                file2.delete();
            }

            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }

            file1.renameTo(file3);
            if (file1.exists()) {
                file1.delete();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int a(int i, int j, int k) {
        return i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000 ? (j < 0 ? 0 : (j >= 128 ? 0 : this.c(i >> 4, k >> 4).a(i & 15, j, k & 15))) : 0;
    }

    public boolean e(int i, int j, int k) {
        return this.a(i, j, k) == 0;
    }

    public boolean f(int i, int j, int k) {
        return j >= 0 && j < 128 ? this.f(i >> 4, k >> 4) : false;
    }

    public boolean a(int i, int j, int k, int l, int i1, int j1) {
        if (i1 >= 0 && j < 128) {
            i >>= 4;
            j >>= 4;
            k >>= 4;
            l >>= 4;
            i1 >>= 4;
            j1 >>= 4;

            for (int k1 = i; k1 <= l; ++k1) {
                for (int l1 = k; l1 <= j1; ++l1) {
                    if (!this.f(k1, l1)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean f(int i, int j) {
        return this.G.a(i, j);
    }

    public Chunk b(int i, int j) {
        return this.c(i >> 4, j >> 4);
    }

    public Chunk c(int i, int j) {
        return this.G.b(i, j);
    }

    public boolean a(int i, int j, int k, int l, int i1) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j < 0) {
                return false;
            } else if (j >= 128) {
                return false;
            } else {
                Chunk chunk = this.c(i >> 4, k >> 4);

                return chunk.a(i & 15, j, k & 15, l, i1);
            }
        } else {
            return false;
        }
    }

    public boolean a(int i, int j, int k, int l) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j < 0) {
                return false;
            } else if (j >= 128) {
                return false;
            } else {
                Chunk chunk = this.c(i >> 4, k >> 4);

                return chunk.a(i & 15, j, k & 15, l);
            }
        } else {
            return false;
        }
    }

    public Material c(int i, int j, int k) {
        int l = this.a(i, j, k);

        return l == 0 ? Material.a : Block.m[l].bs;
    }

    public int b(int i, int j, int k) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j < 0) {
                return 0;
            } else if (j >= 128) {
                return 0;
            } else {
                Chunk chunk = this.c(i >> 4, k >> 4);

                i &= 15;
                k &= 15;
                return chunk.b(i, j, k);
            }
        } else {
            return 0;
        }
    }

    public void b(int i, int j, int k, int l) {
        if (this.c(i, j, k, l)) {
            this.e(i, j, k, this.a(i, j, k));
        }
    }

    public boolean c(int i, int j, int k, int l) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j < 0) {
                return false;
            } else if (j >= 128) {
                return false;
            } else {
                Chunk chunk = this.c(i >> 4, k >> 4);

                i &= 15;
                k &= 15;
                chunk.b(i, j, k, l);
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean d(int i, int j, int k, int l) {
        if (this.a(i, j, k, l)) {
            this.e(i, j, k, l);
            return true;
        } else {
            return false;
        }
    }

    public boolean b(int i, int j, int k, int l, int i1) {
        if (this.a(i, j, k, l, i1)) {
            this.e(i, j, k, l);
            return true;
        } else {
            return false;
        }
    }

    public void g(int i, int j, int k) {
        for (int l = 0; l < this.r.size(); ++l) {
            ((IWorldAccess) this.r.get(l)).a(i, j, k);
        }
    }

    protected void e(int i, int j, int k, int l) {
        this.g(i, j, k);
        this.g(i, j, k, l);
    }

    public void f(int i, int j, int k, int l) {
        if (k > l) {
            int i1 = l;

            l = k;
            k = i1;
        }

        this.b(i, k, j, i, l, j);
    }

    public void b(int i, int j, int k, int l, int i1, int j1) {
        for (int k1 = 0; k1 < this.r.size(); ++k1) {
            ((IWorldAccess) this.r.get(k1)).a(i, j, k, l, i1, j1);
        }
    }

    public void g(int i, int j, int k, int l) {
        this.k(i - 1, j, k, l);
        this.k(i + 1, j, k, l);
        this.k(i, j - 1, k, l);
        this.k(i, j + 1, k, l);
        this.k(i, j, k - 1, l);
        this.k(i, j, k + 1, l);
    }

    private void k(int i, int j, int k, int l) {
        if (!this.i && !this.z) {
            Block block = Block.m[this.a(i, j, k)];

            if (block != null) {
                block.b(this, i, j, k, l);
            }
        }
    }

    public boolean h(int i, int j, int k) {
        return this.c(i >> 4, k >> 4).c(i & 15, j, k & 15);
    }

    public int i(int i, int j, int k) {
        return this.a(i, j, k, true);
    }

    public int a(int i, int j, int k, boolean flag) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            int l;

            if (flag) {
                l = this.a(i, j, k);
                if (l == Block.ak.bh || l == Block.aA.bh) {
                    int i1 = this.a(i, j + 1, k, false);
                    int j1 = this.a(i + 1, j, k, false);
                    int k1 = this.a(i - 1, j, k, false);
                    int l1 = this.a(i, j, k + 1, false);
                    int i2 = this.a(i, j, k - 1, false);

                    if (j1 > i1) {
                        i1 = j1;
                    }

                    if (k1 > i1) {
                        i1 = k1;
                    }

                    if (l1 > i1) {
                        i1 = l1;
                    }

                    if (i2 > i1) {
                        i1 = i2;
                    }

                    return i1;
                }
            }

            if (j < 0) {
                return 0;
            } else if (j >= 128) {
                l = 15 - this.f;
                if (l < 0) {
                    l = 0;
                }

                return l;
            } else {
                Chunk chunk = this.c(i >> 4, k >> 4);

                i &= 15;
                k &= 15;
                return chunk.c(i, j, k, this.f);
            }
        } else {
            return 15;
        }
    }

    public boolean j(int i, int j, int k) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j < 0) {
                return false;
            } else if (j >= 128) {
                return true;
            } else if (!this.f(i >> 4, k >> 4)) {
                return false;
            } else {
                Chunk chunk = this.c(i >> 4, k >> 4);

                i &= 15;
                k &= 15;
                return chunk.c(i, j, k);
            }
        } else {
            return false;
        }
    }

    public int d(int i, int j) {
        if (i >= -32000000 && j >= -32000000 && i < 32000000 && j <= 32000000) {
            if (!this.f(i >> 4, j >> 4)) {
                return 0;
            } else {
                Chunk chunk = this.c(i >> 4, j >> 4);

                return chunk.b(i & 15, j & 15);
            }
        } else {
            return 0;
        }
    }

    public void a(EnumSkyBlock enumskyblock, int i, int j, int k, int l) {
        if (!this.q.e || enumskyblock != EnumSkyBlock.a) {
            if (this.f(i, j, k)) {
                if (enumskyblock == EnumSkyBlock.a) {
                    if (this.j(i, j, k)) {
                        l = 15;
                    }
                } else if (enumskyblock == EnumSkyBlock.b) {
                    int i1 = this.a(i, j, k);

                    if (Block.s[i1] > l) {
                        l = Block.s[i1];
                    }
                }

                if (this.a(enumskyblock, i, j, k) != l) {
                    this.a(enumskyblock, i, j, k, i, j, k);
                }
            }
        }
    }

    public int a(EnumSkyBlock enumskyblock, int i, int j, int k) {
        if (j >= 0 && j < 128 && i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            int l = i >> 4;
            int i1 = k >> 4;

            if (!this.f(l, i1)) {
                return 0;
            } else {
                Chunk chunk = this.c(l, i1);

                return chunk.a(enumskyblock, i & 15, j, k & 15);
            }
        } else {
            return enumskyblock.c;
        }
    }

    public void b(EnumSkyBlock enumskyblock, int i, int j, int k, int l) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j >= 0) {
                if (j < 128) {
                    if (this.f(i >> 4, k >> 4)) {
                        Chunk chunk = this.c(i >> 4, k >> 4);

                        chunk.a(enumskyblock, i & 15, j, k & 15, l);

                        for (int i1 = 0; i1 < this.r.size(); ++i1) {
                            ((IWorldAccess) this.r.get(i1)).a(i, j, k);
                        }
                    }
                }
            }
        }
    }

    public float k(int i, int j, int k) {
        return this.q.f[this.i(i, j, k)];
    }

    public boolean b() {
        return this.f < 4;
    }

    public MovingObjectPosition a(Vec3D vec3d, Vec3D vec3d1) {
        return this.a(vec3d, vec3d1, false);
    }

    public MovingObjectPosition a(Vec3D vec3d, Vec3D vec3d1, boolean flag) {
        if (!Double.isNaN(vec3d.a) && !Double.isNaN(vec3d.b) && !Double.isNaN(vec3d.c)) {
            if (!Double.isNaN(vec3d1.a) && !Double.isNaN(vec3d1.b) && !Double.isNaN(vec3d1.c)) {
                int i = MathHelper.b(vec3d1.a);
                int j = MathHelper.b(vec3d1.b);
                int k = MathHelper.b(vec3d1.c);
                int l = MathHelper.b(vec3d.a);
                int i1 = MathHelper.b(vec3d.b);
                int j1 = MathHelper.b(vec3d.c);
                int k1 = 200;

                while (k1-- >= 0) {
                    if (Double.isNaN(vec3d.a) || Double.isNaN(vec3d.b) || Double.isNaN(vec3d.c)) {
                        return null;
                    }

                    if (l == i && i1 == j && j1 == k) {
                        return null;
                    }

                    double d1 = 999.0D;
                    double d2 = 999.0D;
                    double d3 = 999.0D;

                    if (i > l) {
                        d1 = (double) l + 1.0D;
                    }

                    if (i < l) {
                        d1 = (double) l + 0.0D;
                    }

                    if (j > i1) {
                        d2 = (double) i1 + 1.0D;
                    }

                    if (j < i1) {
                        d2 = (double) i1 + 0.0D;
                    }

                    if (k > j1) {
                        d3 = (double) j1 + 1.0D;
                    }

                    if (k < j1) {
                        d3 = (double) j1 + 0.0D;
                    }

                    double d4 = 999.0D;
                    double d5 = 999.0D;
                    double d6 = 999.0D;
                    double d7 = vec3d1.a - vec3d.a;
                    double d8 = vec3d1.b - vec3d.b;
                    double d9 = vec3d1.c - vec3d.c;

                    if (d1 != 999.0D) {
                        d4 = (d1 - vec3d.a) / d7;
                    }

                    if (d2 != 999.0D) {
                        d5 = (d2 - vec3d.b) / d8;
                    }

                    if (d3 != 999.0D) {
                        d6 = (d3 - vec3d.c) / d9;
                    }

                    boolean flag1 = false;
                    byte b1;

                    if (d4 < d5 && d4 < d6) {
                        if (i > l) {
                            b1 = 4;
                        } else {
                            b1 = 5;
                        }

                        vec3d.a = d1;
                        vec3d.b += d8 * d4;
                        vec3d.c += d9 * d4;
                    } else if (d5 < d6) {
                        if (j > i1) {
                            b1 = 0;
                        } else {
                            b1 = 1;
                        }

                        vec3d.a += d7 * d5;
                        vec3d.b = d2;
                        vec3d.c += d9 * d5;
                    } else {
                        if (k > j1) {
                            b1 = 2;
                        } else {
                            b1 = 3;
                        }

                        vec3d.a += d7 * d6;
                        vec3d.b += d8 * d6;
                        vec3d.c = d3;
                    }

                    Vec3D vec3d2 = Vec3D.b(vec3d.a, vec3d.b, vec3d.c);

                    l = (int) (vec3d2.a = (double) MathHelper.b(vec3d.a));
                    if (b1 == 5) {
                        --l;
                        ++vec3d2.a;
                    }

                    i1 = (int) (vec3d2.b = (double) MathHelper.b(vec3d.b));
                    if (b1 == 1) {
                        --i1;
                        ++vec3d2.b;
                    }

                    j1 = (int) (vec3d2.c = (double) MathHelper.b(vec3d.c));
                    if (b1 == 3) {
                        --j1;
                        ++vec3d2.c;
                    }

                    int l1 = this.a(l, i1, j1);
                    int i2 = this.b(l, i1, j1);
                    Block block = Block.m[l1];

                    if (l1 > 0 && block.a(i2, flag)) {
                        MovingObjectPosition movingobjectposition = block.a(this, l, i1, j1, vec3d, vec3d1);

                        if (movingobjectposition != null) {
                            return movingobjectposition;
                        }
                    }
                }

                return null;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void a(Entity entity, String s, float f1, float f2) {
        for (int i = 0; i < this.r.size(); ++i) {
            ((IWorldAccess) this.r.get(i)).a(s, entity.p, entity.q - (double) entity.H, entity.r, f1, f2);
        }
    }

    public void a(double d1, double d2, double d3, String s, float f1, float f2) {
        for (int i = 0; i < this.r.size(); ++i) {
            ((IWorldAccess) this.r.get(i)).a(s, d1, d2, d3, f1, f2);
        }
    }

    public void a(String s, int i, int j, int k) {
        for (int l = 0; l < this.r.size(); ++l) {
            ((IWorldAccess) this.r.get(l)).a(s, i, j, k);
        }
    }

    public void a(String s, double d1, double d2, double d3, double d4, double d5, double d6) {
        for (int i = 0; i < this.r.size(); ++i) {
            ((IWorldAccess) this.r.get(i)).a(s, d1, d2, d3, d4, d5, d6);
        }
    }

    public boolean a(Entity entity) {
        int i = MathHelper.b(entity.p / 16.0D);
        int j = MathHelper.b(entity.r / 16.0D);
        boolean flag = false;

        if (entity instanceof EntityPlayer) {
            flag = true;
        }

        if (!flag && !this.f(i, j)) {
            return false;
        } else {
            if (entity instanceof EntityPlayer) {
                this.d.add((EntityPlayer) entity);
                System.out.println("Player count: " + this.d.size());
            }

            this.c(i, j).a(entity);
            this.b.add(entity);
            this.b(entity);
            return true;
        }
    }

    protected void b(Entity entity) {
        for (int i = 0; i < this.r.size(); ++i) {
            ((IWorldAccess) this.r.get(i)).a(entity);
        }
    }

    protected void c(Entity entity) {
        for (int i = 0; i < this.r.size(); ++i) {
            ((IWorldAccess) this.r.get(i)).b(entity);
        }
    }

    public void d(Entity entity) {
        entity.l();
        if (entity instanceof EntityPlayer) {
            this.d.remove((EntityPlayer) entity);
        }
    }

    public void e(Entity entity) {
        entity.l();
        if (entity instanceof EntityPlayer) {
            this.d.remove((EntityPlayer) entity);
        }

        int i = entity.ag;
        int j = entity.ai;

        if (entity.af && this.f(i, j)) {
            this.c(i, j).b(entity);
        }

        this.b.remove(entity);
        this.c(entity);
    }

    public void a(IWorldAccess iworldaccess) {
        this.r.add(iworldaccess);
    }

    public List a(Entity entity, AxisAlignedBB axisalignedbb) {
        this.I.clear();
        int i = MathHelper.b(axisalignedbb.a);
        int j = MathHelper.b(axisalignedbb.d + 1.0D);
        int k = MathHelper.b(axisalignedbb.b);
        int l = MathHelper.b(axisalignedbb.e + 1.0D);
        int i1 = MathHelper.b(axisalignedbb.c);
        int j1 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k1 = i; k1 < j; ++k1) {
            for (int l1 = i1; l1 < j1; ++l1) {
                if (this.f(k1, 64, l1)) {
                    for (int i2 = k - 1; i2 < l; ++i2) {
                        Block block = Block.m[this.a(k1, i2, l1)];

                        if (block != null) {
                            block.a(this, k1, i2, l1, axisalignedbb, this.I);
                        }
                    }
                }
            }
        }

        double d1 = 0.25D;
        List list = this.b(entity, axisalignedbb.b(d1, d1, d1));

        for (int j2 = 0; j2 < list.size(); ++j2) {
            AxisAlignedBB axisalignedbb1 = ((Entity) list.get(j2)).q();

            if (axisalignedbb1 != null && axisalignedbb1.a(axisalignedbb)) {
                this.I.add(axisalignedbb1);
            }

            axisalignedbb1 = entity.d((Entity) list.get(j2));
            if (axisalignedbb1 != null && axisalignedbb1.a(axisalignedbb)) {
                this.I.add(axisalignedbb1);
            }
        }

        return this.I;
    }

    public int a(float f1) {
        float f2 = this.b(f1);
        float f3 = 1.0F - (MathHelper.b(f2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);

        if (f3 < 0.0F) {
            f3 = 0.0F;
        }

        if (f3 > 1.0F) {
            f3 = 1.0F;
        }

        return (int) (f3 * 11.0F);
    }

    public float b(float f1) {
        return this.q.a(this.e, f1);
    }

    public int e(int i, int j) {
        Chunk chunk = this.b(i, j);

        int k;

        for (k = 127; this.c(i, k, j).c() && k > 0; --k) {
            ;
        }

        i &= 15;

        for (j &= 15; k > 0; --k) {
            int l = chunk.a(i, k, j);

            if (l != 0 && (Block.m[l].bs.c() || Block.m[l].bs.d())) {
                return k + 1;
            }
        }

        return -1;
    }

    public void h(int i, int j, int k, int l) {
        NextTickListEntry nextticklistentry = new NextTickListEntry(i, j, k, l);
        byte b1 = 8;

        if (this.a) {
            if (this.a(nextticklistentry.a - b1, nextticklistentry.b - b1, nextticklistentry.c - b1, nextticklistentry.a + b1, nextticklistentry.b + b1, nextticklistentry.c + b1)) {
                int i1 = this.a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);

                if (i1 == nextticklistentry.d && i1 > 0) {
                    Block.m[i1].a(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, this.l);
                }
            }
        } else {
            if (this.a(i - b1, j - b1, k - b1, i + b1, j + b1, k + b1)) {
                if (l > 0) {
                    nextticklistentry.a((long) Block.m[l].b() + this.e);
                }

                if (!this.D.contains(nextticklistentry)) {
                    this.D.add(nextticklistentry);
                    this.C.add(nextticklistentry);
                }
            }
        }
    }

    public void c() {
        this.b.removeAll(this.B);

        int i;
        Entity entity;
        int j;
        int k;

        for (i = 0; i < this.B.size(); ++i) {
            entity = (Entity) this.B.get(i);
            j = entity.ag;
            k = entity.ai;
            if (entity.af && this.f(j, k)) {
                this.c(j, k).b(entity);
            }
        }

        for (i = 0; i < this.B.size(); ++i) {
            this.c((Entity) this.B.get(i));
        }

        this.B.clear();

        for (i = 0; i < this.b.size(); ++i) {
            entity = (Entity) this.b.get(i);
            if (entity.k != null) {
                if (!entity.k.G && entity.k.j == entity) {
                    continue;
                }

                entity.k.j = null;
                entity.k = null;
            }

            if (!entity.G) {
                this.f(entity);
            }

            if (entity.G) {
                j = entity.ag;
                k = entity.ai;
                if (entity.af && this.f(j, k)) {
                    this.c(j, k).b(entity);
                }

                this.b.remove(i--);
                this.c(entity);
            }
        }

        for (i = 0; i < this.c.size(); ++i) {
            TileEntity tileentity = (TileEntity) this.c.get(i);

            tileentity.e();
        }
    }

    public void f(Entity entity) {
        this.a(entity, true);
    }

    public void a(Entity entity, boolean flag) {
        int i = MathHelper.b(entity.p);
        int j = MathHelper.b(entity.r);
        byte b1 = 16;

        if (flag || this.a(i - b1, 0, j - b1, i + b1, 128, j + b1)) {
            entity.O = entity.p;
            entity.P = entity.q;
            entity.Q = entity.r;
            entity.x = entity.v;
            entity.y = entity.w;
            if (flag && entity.af) {
                if (entity.k != null) {
                    entity.z();
                } else {
                    entity.b_();
                }
            }

            if (Double.isNaN(entity.p) || Double.isInfinite(entity.p)) {
                entity.p = entity.O;
            }

            if (Double.isNaN(entity.q) || Double.isInfinite(entity.q)) {
                entity.q = entity.P;
            }

            if (Double.isNaN(entity.r) || Double.isInfinite(entity.r)) {
                entity.r = entity.Q;
            }

            if (Double.isNaN((double) entity.w) || Double.isInfinite((double) entity.w)) {
                entity.w = entity.y;
            }

            if (Double.isNaN((double) entity.v) || Double.isInfinite((double) entity.v)) {
                entity.v = entity.x;
            }

            int k = MathHelper.b(entity.p / 16.0D);
            int l = MathHelper.b(entity.q / 16.0D);
            int i1 = MathHelper.b(entity.r / 16.0D);

            if (!entity.af || entity.ag != k || entity.ah != l || entity.ai != i1) {
                if (entity.af && this.f(entity.ag, entity.ai)) {
                    this.c(entity.ag, entity.ai).a(entity, entity.ah);
                }

                if (this.f(k, i1)) {
                    entity.af = true;
                    this.c(k, i1).a(entity);
                } else {
                    entity.af = false;
                }
            }

            if (flag && entity.af && entity.j != null) {
                if (!entity.j.G && entity.j.k == entity) {
                    this.f(entity.j);
                } else {
                    entity.j.k = null;
                    entity.j = null;
                }
            }
        }
    }

    public boolean a(AxisAlignedBB axisalignedbb) {
        List list = this.b((Entity) null, axisalignedbb);

        for (int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity) list.get(i);

            if (!entity.G && entity.i) {
                return false;
            }
        }

        return true;
    }

    public boolean b(AxisAlignedBB axisalignedbb) {
        int i = MathHelper.b(axisalignedbb.a);
        int j = MathHelper.b(axisalignedbb.d + 1.0D);
        int k = MathHelper.b(axisalignedbb.b);
        int l = MathHelper.b(axisalignedbb.e + 1.0D);
        int i1 = MathHelper.b(axisalignedbb.c);
        int j1 = MathHelper.b(axisalignedbb.f + 1.0D);

        if (axisalignedbb.a < 0.0D) {
            --i;
        }

        if (axisalignedbb.b < 0.0D) {
            --k;
        }

        if (axisalignedbb.c < 0.0D) {
            --i1;
        }

        for (int k1 = i; k1 < j; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    Block block = Block.m[this.a(k1, l1, i2)];

                    if (block != null && block.bs.d()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean c(AxisAlignedBB axisalignedbb) {
        int i = MathHelper.b(axisalignedbb.a);
        int j = MathHelper.b(axisalignedbb.d + 1.0D);
        int k = MathHelper.b(axisalignedbb.b);
        int l = MathHelper.b(axisalignedbb.e + 1.0D);
        int i1 = MathHelper.b(axisalignedbb.c);
        int j1 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k1 = i; k1 < j; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    int j2 = this.a(k1, l1, i2);

                    if (j2 == Block.ar.bh || j2 == Block.C.bh || j2 == Block.D.bh) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean a(AxisAlignedBB axisalignedbb, Material material, Entity entity) {
        int i = MathHelper.b(axisalignedbb.a);
        int j = MathHelper.b(axisalignedbb.d + 1.0D);
        int k = MathHelper.b(axisalignedbb.b);
        int l = MathHelper.b(axisalignedbb.e + 1.0D);
        int i1 = MathHelper.b(axisalignedbb.c);
        int j1 = MathHelper.b(axisalignedbb.f + 1.0D);
        boolean flag = false;
        Vec3D vec3d = Vec3D.b(0.0D, 0.0D, 0.0D);

        for (int k1 = i; k1 < j; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    Block block = Block.m[this.a(k1, l1, i2)];

                    if (block != null && block.bs == material) {
                        double d1 = (double) ((float) (l1 + 1) - BlockFluids.b(this.b(k1, l1, i2)));

                        if ((double) l >= d1) {
                            flag = true;
                            block.a(this, k1, l1, i2, entity, vec3d);
                        }
                    }
                }
            }
        }

        if (vec3d.c() > 0.0D) {
            vec3d = vec3d.b();
            double d2 = 0.0040D;

            entity.s += vec3d.a * d2;
            entity.t += vec3d.b * d2;
            entity.u += vec3d.c * d2;
        }

        return flag;
    }

    public boolean a(AxisAlignedBB axisalignedbb, Material material) {
        int i = MathHelper.b(axisalignedbb.a);
        int j = MathHelper.b(axisalignedbb.d + 1.0D);
        int k = MathHelper.b(axisalignedbb.b);
        int l = MathHelper.b(axisalignedbb.e + 1.0D);
        int i1 = MathHelper.b(axisalignedbb.c);
        int j1 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k1 = i; k1 < j; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    Block block = Block.m[this.a(k1, l1, i2)];

                    if (block != null && block.bs == material) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean b(AxisAlignedBB axisalignedbb, Material material) {
        int i = MathHelper.b(axisalignedbb.a);
        int j = MathHelper.b(axisalignedbb.d + 1.0D);
        int k = MathHelper.b(axisalignedbb.b);
        int l = MathHelper.b(axisalignedbb.e + 1.0D);
        int i1 = MathHelper.b(axisalignedbb.c);
        int j1 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k1 = i; k1 < j; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    Block block = Block.m[this.a(k1, l1, i2)];

                    if (block != null && block.bs == material) {
                        int j2 = this.b(k1, l1, i2);
                        double d1 = (double) (l1 + 1);

                        if (j2 < 8) {
                            d1 = (double) (l1 + 1) - (double) j2 / 8.0D;
                        }

                        if (d1 >= axisalignedbb.b) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public Explosion a(Entity entity, double d1, double d2, double d3, float f1) {
        return this.a(entity, d1, d2, d3, f1, false);
    }

    public Explosion a(Entity entity, double d1, double d2, double d3, float f1, boolean flag) {
        Explosion explosion = new Explosion(this, entity, d1, d2, d3, f1);

        explosion.a = flag;
        explosion.a();
        explosion.b();
        return explosion;
    }

    public float a(Vec3D vec3d, AxisAlignedBB axisalignedbb) {
        double d1 = 1.0D / ((axisalignedbb.d - axisalignedbb.a) * 2.0D + 1.0D);
        double d2 = 1.0D / ((axisalignedbb.e - axisalignedbb.b) * 2.0D + 1.0D);
        double d3 = 1.0D / ((axisalignedbb.f - axisalignedbb.c) * 2.0D + 1.0D);
        int i = 0;
        int j = 0;

        for (float f1 = 0.0F; f1 <= 1.0F; f1 = (float) ((double) f1 + d1)) {
            for (float f2 = 0.0F; f2 <= 1.0F; f2 = (float) ((double) f2 + d2)) {
                for (float f3 = 0.0F; f3 <= 1.0F; f3 = (float) ((double) f3 + d3)) {
                    double d4 = axisalignedbb.a + (axisalignedbb.d - axisalignedbb.a) * (double) f1;
                    double d5 = axisalignedbb.b + (axisalignedbb.e - axisalignedbb.b) * (double) f2;
                    double d6 = axisalignedbb.c + (axisalignedbb.f - axisalignedbb.c) * (double) f3;

                    if (this.a(Vec3D.b(d4, d5, d6), vec3d) == null) {
                        ++i;
                    }

                    ++j;
                }
            }
        }

        return (float) i / (float) j;
    }

    public TileEntity l(int i, int j, int k) {
        Chunk chunk = this.c(i >> 4, k >> 4);

        return chunk != null ? chunk.d(i & 15, j, k & 15) : null;
    }

    public void a(int i, int j, int k, TileEntity tileentity) {
        Chunk chunk = this.c(i >> 4, k >> 4);

        if (chunk != null) {
            chunk.a(i & 15, j, k & 15, tileentity);
        }
    }

    public void m(int i, int j, int k) {
        Chunk chunk = this.c(i >> 4, k >> 4);

        if (chunk != null) {
            chunk.e(i & 15, j, k & 15);
        }
    }

    public boolean d(int i, int j, int k) {
        Block block = Block.m[this.a(i, j, k)];

        return block == null ? false : block.a();
    }

    public boolean d() {
        if (this.J >= 50) {
            return false;
        } else {
            ++this.J;

            try {
                int i = 5000;

                boolean flag;

                while (this.A.size() > 0) {
                    --i;
                    if (i <= 0) {
                        flag = true;
                        return flag;
                    }

                    ((MetadataChunkBlock) this.A.remove(this.A.size() - 1)).a(this);
                }

                flag = false;
                return flag;
            } finally {
                --this.J;
            }
        }
    }

    public void a(EnumSkyBlock enumskyblock, int i, int j, int k, int l, int i1, int j1) {
        this.a(enumskyblock, i, j, k, l, i1, j1, true);
    }

    public void a(EnumSkyBlock enumskyblock, int i, int j, int k, int l, int i1, int j1, boolean flag) {
        if (!this.q.e || enumskyblock != EnumSkyBlock.a) {
            ++y;
            if (y == 50) {
                --y;
            } else {
                int k1 = (l + i) / 2;
                int l1 = (j1 + k) / 2;

                if (!this.f(k1, 64, l1)) {
                    --y;
                } else {
                    int i2 = this.A.size();

                    if (flag) {
                        int j2 = 4;

                        if (j2 > i2) {
                            j2 = i2;
                        }

                        for (int k2 = 0; k2 < j2; ++k2) {
                            MetadataChunkBlock metadatachunkblock = (MetadataChunkBlock) this.A.get(this.A.size() - k2 - 1);

                            if (metadatachunkblock.a == enumskyblock && metadatachunkblock.a(i, j, k, l, i1, j1)) {
                                --y;
                                return;
                            }
                        }
                    }

                    this.A.add(new MetadataChunkBlock(enumskyblock, i, j, k, l, i1, j1));
                    if (this.A.size() > 100000) {
                        this.A.clear();
                    }

                    --y;
                }
            }
        }
    }

    public void e() {
        int i = this.a(1.0F);

        if (i != this.f) {
            this.f = i;
        }
    }

    public void f() {
        SpawnerAnimals.a(this);
        this.G.a();
        int i = this.a(1.0F);

        if (i != this.f) {
            this.f = i;

            for (int j = 0; j < this.r.size(); ++j) {
                ((IWorldAccess) this.r.get(j)).a();
            }
        }

        ++this.e;
        if (this.e % (long) this.j == 0L) {
            this.a(false, (IProgressUpdate) null);
        }

        this.a(false);
        this.g();
    }

    protected void g() {
        this.K.clear();

        int i;
        int j;
        int k;
        int l;

        for (int i1 = 0; i1 < this.d.size(); ++i1) {
            EntityPlayer entityplayer = (EntityPlayer) this.d.get(i1);

            i = MathHelper.b(entityplayer.p / 16.0D);
            j = MathHelper.b(entityplayer.r / 16.0D);
            byte b1 = 9;

            for (k = -b1; k <= b1; ++k) {
                for (l = -b1; l <= b1; ++l) {
                    this.K.add(new ChunkCoordIntPair(k + i, l + j));
                }
            }
        }

        if (this.L > 0) {
            --this.L;
        }

        Iterator iterator = this.K.iterator();

        while (iterator.hasNext()) {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) iterator.next();

            i = chunkcoordintpair.a * 16;
            j = chunkcoordintpair.b * 16;
            Chunk chunk = this.c(chunkcoordintpair.a, chunkcoordintpair.b);
            int j1;
            int k1;
            int l1;

            if (this.L == 0) {
                this.g = this.g * 3 + this.h;
                k = this.g >> 2;
                l = k & 15;
                j1 = k >> 8 & 15;
                k1 = k >> 16 & 127;
                l1 = chunk.a(l, k1, j1);
                l += i;
                j1 += j;
                if (l1 == 0 && this.i(l, k1, j1) <= this.l.nextInt(8) && this.a(EnumSkyBlock.a, l, k1, j1) <= 0) {
                    EntityPlayer entityplayer1 = this.a((double) l + 0.5D, (double) k1 + 0.5D, (double) j1 + 0.5D, 8.0D);

                    if (entityplayer1 != null && entityplayer1.d((double) l + 0.5D, (double) k1 + 0.5D, (double) j1 + 0.5D) > 4.0D) {
                        this.a((double) l + 0.5D, (double) k1 + 0.5D, (double) j1 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.l.nextFloat() * 0.2F);
                        this.L = this.l.nextInt(12000) + 6000;
                    }
                }
            }

            for (k = 0; k < 80; ++k) {
                this.g = this.g * 3 + this.h;
                l = this.g >> 2;
                j1 = l & 15;
                k1 = l >> 8 & 15;
                l1 = l >> 16 & 127;
                byte b2 = chunk.b[j1 << 11 | k1 << 7 | l1];

                if (Block.n[b2]) {
                    Block.m[b2].a(this, j1 + i, l1, k1 + j, this.l);
                }
            }
        }
    }

    public boolean a(boolean flag) {
        int i = this.C.size();

        if (i != this.D.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        } else {
            if (i > 1000) {
                i = 1000;
            }

            for (int j = 0; j < i; ++j) {
                NextTickListEntry nextticklistentry = (NextTickListEntry) this.C.first();

                if (!flag && nextticklistentry.e > this.e) {
                    break;
                }

                this.C.remove(nextticklistentry);
                this.D.remove(nextticklistentry);
                byte b1 = 8;

                if (this.a(nextticklistentry.a - b1, nextticklistentry.b - b1, nextticklistentry.c - b1, nextticklistentry.a + b1, nextticklistentry.b + b1, nextticklistentry.c + b1)) {
                    int k = this.a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);

                    if (k == nextticklistentry.d && k > 0) {
                        Block.m[k].a(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, this.l);
                    }
                }
            }

            return this.C.size() != 0;
        }
    }

    public List b(Entity entity, AxisAlignedBB axisalignedbb) {
        this.M.clear();
        int i = MathHelper.b((axisalignedbb.a - 2.0D) / 16.0D);
        int j = MathHelper.b((axisalignedbb.d + 2.0D) / 16.0D);
        int k = MathHelper.b((axisalignedbb.c - 2.0D) / 16.0D);
        int l = MathHelper.b((axisalignedbb.f + 2.0D) / 16.0D);

        for (int i1 = i; i1 <= j; ++i1) {
            for (int j1 = k; j1 <= l; ++j1) {
                if (this.f(i1, j1)) {
                    this.c(i1, j1).a(entity, axisalignedbb, this.M);
                }
            }
        }

        return this.M;
    }

    public List a(Class oclass, AxisAlignedBB axisalignedbb) {
        int i = MathHelper.b((axisalignedbb.a - 2.0D) / 16.0D);
        int j = MathHelper.b((axisalignedbb.d + 2.0D) / 16.0D);
        int k = MathHelper.b((axisalignedbb.c - 2.0D) / 16.0D);
        int l = MathHelper.b((axisalignedbb.f + 2.0D) / 16.0D);
        ArrayList arraylist = new ArrayList();

        for (int i1 = i; i1 <= j; ++i1) {
            for (int j1 = k; j1 <= l; ++j1) {
                if (this.f(i1, j1)) {
                    this.c(i1, j1).a(oclass, axisalignedbb, arraylist);
                }
            }
        }

        return arraylist;
    }

    public void b(int i, int j, int k, TileEntity tileentity) {
        if (this.f(i, j, k)) {
            this.b(i, k).f();
        }

        for (int l = 0; l < this.r.size(); ++l) {
            ((IWorldAccess) this.r.get(l)).a(i, j, k, tileentity);
        }
    }

    public int a(Class oclass) {
        int i = 0;

        for (int j = 0; j < this.b.size(); ++j) {
            Entity entity = (Entity) this.b.get(j);

            if (oclass.isAssignableFrom(entity.getClass())) {
                ++i;
            }
        }

        return i;
    }

    public void a(List list) {
        this.b.addAll(list);

        for (int i = 0; i < list.size(); ++i) {
            this.b((Entity) list.get(i));
        }
    }

    public void b(List list) {
        this.B.addAll(list);
    }

    public boolean a(int i, int j, int k, int l, boolean flag) {
        int i1 = this.a(j, k, l);
        Block block = Block.m[i1];
        Block block1 = Block.m[i];
        AxisAlignedBB axisalignedbb = block1.d(this, j, k, l);

        if (flag) {
            axisalignedbb = null;
        }

        return axisalignedbb != null && !this.a(axisalignedbb) ? false : (block != Block.A && block != Block.B && block != Block.C && block != Block.D && block != Block.ar && block != Block.aS ? i > 0 && block == null && block1.a(this, j, k, l) : true);
    }

    public PathEntity a(Entity entity, Entity entity1, float f1) {
        int i = MathHelper.b(entity.p);
        int j = MathHelper.b(entity.q);
        int k = MathHelper.b(entity.r);
        int l = (int) (f1 + 16.0F);
        int i1 = i - l;
        int j1 = j - l;
        int k1 = k - l;
        int l1 = i + l;
        int i2 = j + l;
        int j2 = k + l;
        ChunkCache chunkcache = new ChunkCache(this, i1, j1, k1, l1, i2, j2);

        return (new Pathfinder(chunkcache)).a(entity, entity1, f1);
    }

    public PathEntity a(Entity entity, int i, int j, int k, float f1) {
        int l = MathHelper.b(entity.p);
        int i1 = MathHelper.b(entity.q);
        int j1 = MathHelper.b(entity.r);
        int k1 = (int) (f1 + 8.0F);
        int l1 = l - k1;
        int i2 = i1 - k1;
        int j2 = j1 - k1;
        int k2 = l + k1;
        int l2 = i1 + k1;
        int i3 = j1 + k1;
        ChunkCache chunkcache = new ChunkCache(this, l1, i2, j2, k2, l2, i3);

        return (new Pathfinder(chunkcache)).a(entity, i, j, k, f1);
    }

    public boolean i(int i, int j, int k, int l) {
        int i1 = this.a(i, j, k);

        return i1 == 0 ? false : Block.m[i1].d(this, i, j, k, l);
    }

    public boolean n(int i, int j, int k) {
        return this.i(i, j - 1, k, 0) ? true : (this.i(i, j + 1, k, 1) ? true : (this.i(i, j, k - 1, 2) ? true : (this.i(i, j, k + 1, 3) ? true : (this.i(i - 1, j, k, 4) ? true : this.i(i + 1, j, k, 5)))));
    }

    public boolean j(int i, int j, int k, int l) {
        if (this.d(i, j, k)) {
            return this.n(i, j, k);
        } else {
            int i1 = this.a(i, j, k);

            return i1 == 0 ? false : Block.m[i1].b((IBlockAccess) this, i, j, k, l);
        }
    }

    public boolean o(int i, int j, int k) {
        return this.j(i, j - 1, k, 0) ? true : (this.j(i, j + 1, k, 1) ? true : (this.j(i, j, k - 1, 2) ? true : (this.j(i, j, k + 1, 3) ? true : (this.j(i - 1, j, k, 4) ? true : this.j(i + 1, j, k, 5)))));
    }

    public EntityPlayer a(Entity entity, double d1) {
        return this.a(entity.p, entity.q, entity.r, d1);
    }

    public EntityPlayer a(double d1, double d2, double d3, double d4) {
        double d5 = -1.0D;
        EntityPlayer entityplayer = null;

        for (int i = 0; i < this.d.size(); ++i) {
            EntityPlayer entityplayer1 = (EntityPlayer) this.d.get(i);
            double d6 = entityplayer1.d(d1, d2, d3);

            if ((d4 < 0.0D || d6 < d4 * d4) && (d5 == -1.0D || d6 < d5)) {
                d5 = d6;
                entityplayer = entityplayer1;
            }
        }

        return entityplayer;
    }

    public byte[] c(int i, int j, int k, int l, int i1, int j1) {
        byte[] abyte = new byte[l * i1 * j1 * 5 / 2];
        int k1 = i >> 4;
        int l1 = k >> 4;
        int i2 = i + l - 1 >> 4;
        int j2 = k + j1 - 1 >> 4;
        int k2 = 0;
        int l2 = j;
        int i3 = j + i1;

        if (j < 0) {
            l2 = 0;
        }

        if (i3 > 128) {
            i3 = 128;
        }

        for (int j3 = k1; j3 <= i2; ++j3) {
            int k3 = i - j3 * 16;
            int l3 = i + l - j3 * 16;

            if (k3 < 0) {
                k3 = 0;
            }

            if (l3 > 16) {
                l3 = 16;
            }

            for (int i4 = l1; i4 <= j2; ++i4) {
                int j4 = k - i4 * 16;
                int k4 = k + j1 - i4 * 16;

                if (j4 < 0) {
                    j4 = 0;
                }

                if (k4 > 16) {
                    k4 = 16;
                }

                k2 = this.c(j3, i4).a(abyte, k3, l2, j4, l3, i3, k4, k2);
            }
        }

        return abyte;
    }

    public void h() {
        try {
            File file1 = new File(this.t, "session.lock");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file1));

            try {
                if (datainputstream.readLong() != this.F) {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            } finally {
                datainputstream.close();
            }
        } catch (IOException ioexception) {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    public boolean a(EntityPlayer entityplayer, int i, int j, int k) {
        return true;
    }

    public void a(Entity entity, byte b1) {}
}
