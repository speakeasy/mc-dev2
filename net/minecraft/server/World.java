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

    private List y;
    public List a;
    private List z;
    private TreeSet A;
    private Set B;
    public List b;
    public long c;
    public boolean d;
    private long C;
    private long D;
    private long E;
    public int e;
    protected int f;
    protected int g;
    public boolean h;
    public static float[] i = new float[16];
    private final long F;
    protected int j;
    public List k;
    public int l;
    public Random m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    protected List r;
    private IChunkProvider G;
    public File s;
    public long t;
    private NBTTagCompound H;
    public long u;
    public final String v;
    public boolean w;
    private ArrayList I;
    private Set J;
    private int K;
    private List L;
    public boolean x;

    public World(File file1, String s) {
        this(file1, s, (new Random()).nextLong());
    }

    public World(String s) {
        this.y = new ArrayList();
        this.a = new ArrayList();
        this.z = new ArrayList();
        this.A = new TreeSet();
        this.B = new HashSet();
        this.b = new ArrayList();
        this.c = 0L;
        this.d = false;
        this.C = 8961023L;
        this.D = 12638463L;
        this.E = 16777215L;
        this.e = 0;
        this.f = (new Random()).nextInt();
        this.g = 1013904223;
        this.h = false;
        this.F = System.currentTimeMillis();
        this.j = 40;
        this.k = new ArrayList();
        this.m = new Random();
        this.q = false;
        this.r = new ArrayList();
        this.t = 0L;
        this.u = 0L;
        this.I = new ArrayList();
        this.J = new HashSet();
        this.K = this.m.nextInt(12000);
        this.L = new ArrayList();
        this.x = false;
        this.v = s;
        this.G = this.a(this.s);
        this.d();
    }

    public World(File file1, String s, long i) {
        this.y = new ArrayList();
        this.a = new ArrayList();
        this.z = new ArrayList();
        this.A = new TreeSet();
        this.B = new HashSet();
        this.b = new ArrayList();
        this.c = 0L;
        this.d = false;
        this.C = 8961023L;
        this.D = 12638463L;
        this.E = 16777215L;
        this.e = 0;
        this.f = (new Random()).nextInt();
        this.g = 1013904223;
        this.h = false;
        this.F = System.currentTimeMillis();
        this.j = 40;
        this.k = new ArrayList();
        this.m = new Random();
        this.q = false;
        this.r = new ArrayList();
        this.t = 0L;
        this.u = 0L;
        this.I = new ArrayList();
        this.J = new HashSet();
        this.K = this.m.nextInt(12000);
        this.L = new ArrayList();
        this.x = false;
        this.v = s;
        file1.mkdirs();
        this.s = new File(file1, s);
        this.s.mkdirs();

        File file2;

        try {
            file2 = new File(this.s, "session.lock");
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file2));

            try {
                dataoutputstream.writeLong(this.F);
            } finally {
                dataoutputstream.close();
            }
        } catch (IOException ioexception) {
            throw new RuntimeException("Failed to check session lock, aborting");
        }

        file2 = new File(this.s, "level.dat");
        this.q = !file2.exists();
        if (file2.exists()) {
            try {
                NBTTagCompound nbttagcompound = CompressedStreamTools.a((InputStream) (new FileInputStream(file2)));
                NBTTagCompound nbttagcompound1 = nbttagcompound.j("Data");

                this.t = nbttagcompound1.e("RandomSeed");
                this.n = nbttagcompound1.d("SpawnX");
                this.o = nbttagcompound1.d("SpawnY");
                this.p = nbttagcompound1.d("SpawnZ");
                this.c = nbttagcompound1.e("Time");
                this.u = nbttagcompound1.e("SizeOnDisk");
                this.d = nbttagcompound1.l("SnowCovered");
                if (nbttagcompound1.a("Player")) {
                    this.H = nbttagcompound1.j("Player");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            this.d = this.m.nextInt(4) == 0;
        }

        boolean flag = false;

        if (this.t == 0L) {
            this.t = i;
            flag = true;
        }

        this.G = this.a(this.s);
        if (flag) {
            this.w = true;
            this.n = 0;
            this.o = 64;

            for (this.p = 0; !this.e(this.n, this.p); this.p += this.m.nextInt(64) - this.m.nextInt(64)) {
                this.n += this.m.nextInt(64) - this.m.nextInt(64);
            }

            this.w = false;
        }

        this.d();
    }

    protected IChunkProvider a(File file1) {
        return new ChunkProviderLoadOrGenerate(this, new ChunkLoader(file1, true), new ChunkProviderGenerate(this, this.t));
    }

    private boolean e(int i, int j) {
        int k = this.f(i, j);

        return k == Block.F.bc;
    }

    private int f(int i, int j) {
        int k;

        for (k = 63; this.a(i, k + 1, j) != 0; ++k) {
            ;
        }

        return this.a(i, k, j);
    }

    public void a(boolean flag, IProgressUpdate iprogressupdate) {
        if (this.G.b()) {
            if (iprogressupdate != null) {
                iprogressupdate.a("Saving level");
            }

            this.h();
            if (iprogressupdate != null) {
                iprogressupdate.b("Saving chunks");
            }

            this.G.a(flag, iprogressupdate);
        }
    }

    private void h() {
        this.g();
        NBTTagCompound nbttagcompound = new NBTTagCompound();

        nbttagcompound.a("RandomSeed", this.t);
        nbttagcompound.a("SpawnX", this.n);
        nbttagcompound.a("SpawnY", this.o);
        nbttagcompound.a("SpawnZ", this.p);
        nbttagcompound.a("Time", this.c);
        nbttagcompound.a("SizeOnDisk", this.u);
        nbttagcompound.a("SnowCovered", this.d);
        nbttagcompound.a("LastPlayed", System.currentTimeMillis());
        EntityPlayer entityplayer = null;

        if (this.k.size() > 0) {
            entityplayer = (EntityPlayer) this.k.get(0);
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
            File file1 = new File(this.s, "level.dat_new");
            File file2 = new File(this.s, "level.dat_old");
            File file3 = new File(this.s, "level.dat");

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
        return i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000 ? (j < 0 ? 0 : (j >= 128 ? 0 : this.b(i >> 4, k >> 4).a(i & 15, j, k & 15))) : 0;
    }

    public boolean e(int i, int j, int k) {
        return j >= 0 && j < 128 ? this.g(i >> 4, k >> 4) : false;
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
                    if (!this.g(k1, l1)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean g(int i, int j) {
        return this.G.a(i, j);
    }

    public Chunk a(int i, int j) {
        return this.b(i >> 4, j >> 4);
    }

    public Chunk b(int i, int j) {
        return this.G.b(i, j);
    }

    public boolean a(int i, int j, int k, int l, int i1) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j < 0) {
                return false;
            } else if (j >= 128) {
                return false;
            } else {
                Chunk chunk = this.b(i >> 4, k >> 4);

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
                Chunk chunk = this.b(i >> 4, k >> 4);

                return chunk.a(i & 15, j, k & 15, l);
            }
        } else {
            return false;
        }
    }

    public Material c(int i, int j, int k) {
        int l = this.a(i, j, k);

        return l == 0 ? Material.a : Block.n[l].bn;
    }

    public int b(int i, int j, int k) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j < 0) {
                return 0;
            } else if (j >= 128) {
                return 0;
            } else {
                Chunk chunk = this.b(i >> 4, k >> 4);

                i &= 15;
                k &= 15;
                return chunk.b(i, j, k);
            }
        } else {
            return 0;
        }
    }

    public void b(int i, int j, int k, int l) {
        this.c(i, j, k, l);
    }

    public boolean c(int i, int j, int k, int l) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j < 0) {
                return false;
            } else if (j >= 128) {
                return false;
            } else {
                Chunk chunk = this.b(i >> 4, k >> 4);

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

    public void f(int i, int j, int k) {
        for (int l = 0; l < this.r.size(); ++l) {
            ((IWorldAccess) this.r.get(l)).a(i, j, k);
        }
    }

    protected void e(int i, int j, int k, int l) {
        this.f(i, j, k);
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
        if (!this.h && !this.x) {
            Block block = Block.n[this.a(i, j, k)];

            if (block != null) {
                block.b(this, i, j, k, l);
            }
        }
    }

    public boolean g(int i, int j, int k) {
        return this.b(i >> 4, k >> 4).c(i & 15, j, k & 15);
    }

    public int h(int i, int j, int k) {
        return this.a(i, j, k, true);
    }

    public int a(int i, int j, int k, boolean flag) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            int l;

            if (flag) {
                l = this.a(i, j, k);
                if (l == Block.al.bc || l == Block.aB.bc) {
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
                l = 15 - this.e;
                if (l < 0) {
                    l = 0;
                }

                return l;
            } else {
                Chunk chunk = this.b(i >> 4, k >> 4);

                i &= 15;
                k &= 15;
                return chunk.c(i, j, k, this.e);
            }
        } else {
            return 15;
        }
    }

    public boolean i(int i, int j, int k) {
        if (i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            if (j < 0) {
                return false;
            } else if (j >= 128) {
                return true;
            } else if (!this.g(i >> 4, k >> 4)) {
                return false;
            } else {
                Chunk chunk = this.b(i >> 4, k >> 4);

                i &= 15;
                k &= 15;
                return chunk.c(i, j, k);
            }
        } else {
            return false;
        }
    }

    public int c(int i, int j) {
        if (i >= -32000000 && j >= -32000000 && i < 32000000 && j <= 32000000) {
            if (!this.g(i >> 4, j >> 4)) {
                return 0;
            } else {
                Chunk chunk = this.b(i >> 4, j >> 4);

                return chunk.b(i & 15, j & 15);
            }
        } else {
            return 0;
        }
    }

    public void a(EnumSkyBlock enumskyblock, int i, int j, int k, int l) {
        if (this.e(i, j, k)) {
            if (enumskyblock == EnumSkyBlock.a) {
                if (this.i(i, j, k)) {
                    l = 15;
                }
            } else if (enumskyblock == EnumSkyBlock.b) {
                int i1 = this.a(i, j, k);

                if (Block.t[i1] > l) {
                    l = Block.t[i1];
                }
            }

            if (this.a(enumskyblock, i, j, k) != l) {
                this.a(enumskyblock, i, j, k, i, j, k);
            }
        }
    }

    public int a(EnumSkyBlock enumskyblock, int i, int j, int k) {
        if (j >= 0 && j < 128 && i >= -32000000 && k >= -32000000 && i < 32000000 && k <= 32000000) {
            int l = i >> 4;
            int i1 = k >> 4;

            if (!this.g(l, i1)) {
                return 0;
            } else {
                Chunk chunk = this.b(l, i1);

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
                    if (this.g(i >> 4, k >> 4)) {
                        Chunk chunk = this.b(i >> 4, k >> 4);

                        chunk.a(enumskyblock, i & 15, j, k & 15, l);

                        for (int i1 = 0; i1 < this.r.size(); ++i1) {
                            ((IWorldAccess) this.r.get(i1)).a(i, j, k);
                        }
                    }
                }
            }
        }
    }

    public float j(int i, int j, int k) {
        return i[this.h(i, j, k)];
    }

    public boolean a() {
        return this.e < 4;
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
                int k1 = 20;

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
                    Block block = Block.n[l1];

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
            ((IWorldAccess) this.r.get(i)).a(s, entity.l, entity.m - (double) entity.C, entity.n, f1, f2);
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
        int i = MathHelper.b(entity.l / 16.0D);
        int j = MathHelper.b(entity.n / 16.0D);
        boolean flag = false;

        if (entity instanceof EntityPlayer) {
            flag = true;
        }

        if (!flag && !this.g(i, j)) {
            return false;
        } else {
            if (entity instanceof EntityPlayer) {
                this.k.add((EntityPlayer) entity);
                System.out.println("Player count: " + this.k.size());
            }

            this.b(i, j).a(entity);
            this.a.add(entity);
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
        entity.j();
        if (entity instanceof EntityPlayer) {
            this.k.remove((EntityPlayer) entity);
            System.out.println("Player count: " + this.k.size());
        }
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
                if (this.e(k1, 64, l1)) {
                    for (int i2 = k - 1; i2 < l; ++i2) {
                        Block block = Block.n[this.a(k1, i2, l1)];

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
            AxisAlignedBB axisalignedbb1 = ((Entity) list.get(j2)).n();

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
        int i = (int) (this.c % 24000L);
        float f2 = ((float) i + f1) / 24000.0F - 0.25F;

        if (f2 < 0.0F) {
            ++f2;
        }

        if (f2 > 1.0F) {
            --f2;
        }

        float f3 = f2;

        f2 = 1.0F - (float) ((Math.cos((double) f2 * 3.141592653589793D) + 1.0D) / 2.0D);
        f2 = f3 + (f2 - f3) / 3.0F;
        return f2;
    }

    public int d(int i, int j) {
        Chunk chunk = this.a(i, j);
        int k = 127;

        i &= 15;

        for (j &= 15; k > 0; --k) {
            int l = chunk.a(i, k, j);

            if (l != 0 && (Block.n[l].bn.c() || Block.n[l].bn.d())) {
                return k + 1;
            }
        }

        return -1;
    }

    public void h(int i, int j, int k, int l) {
        NextTickListEntry nextticklistentry = new NextTickListEntry(i, j, k, l);
        byte b1 = 8;

        if (this.a(i - b1, j - b1, k - b1, i + b1, j + b1, k + b1)) {
            if (l > 0) {
                nextticklistentry.a((long) Block.n[l].c() + this.c);
            }

            if (!this.B.contains(nextticklistentry)) {
                this.B.add(nextticklistentry);
                this.A.add(nextticklistentry);
            }
        }
    }

    public void b() {
        this.a.removeAll(this.z);

        int i;
        Entity entity;
        int j;
        int k;

        for (i = 0; i < this.z.size(); ++i) {
            entity = (Entity) this.z.get(i);
            j = entity.aa;
            k = entity.ac;
            if (entity.Z && this.g(j, k)) {
                this.b(j, k).b(entity);
            }
        }

        for (i = 0; i < this.z.size(); ++i) {
            this.c((Entity) this.z.get(i));
        }

        this.z.clear();

        for (i = 0; i < this.a.size(); ++i) {
            entity = (Entity) this.a.get(i);
            if (entity.g != null) {
                if (!entity.g.B && entity.g.f == entity) {
                    continue;
                }

                entity.g.f = null;
                entity.g = null;
            }

            if (!entity.B) {
                this.e(entity);
            }

            if (entity.B) {
                j = entity.aa;
                k = entity.ac;
                if (entity.Z && this.g(j, k)) {
                    this.b(j, k).b(entity);
                }

                this.a.remove(i--);
                this.c(entity);
            }
        }

        for (i = 0; i < this.b.size(); ++i) {
            TileEntity tileentity = (TileEntity) this.b.get(i);

            tileentity.b();
        }
    }

    protected void e(Entity entity) {
        int i = MathHelper.b(entity.l);
        int j = MathHelper.b(entity.n);
        byte b1 = 16;

        if (this.a(i - b1, 0, j - b1, i + b1, 128, j + b1)) {
            entity.J = entity.l;
            entity.K = entity.m;
            entity.L = entity.n;
            entity.t = entity.r;
            entity.u = entity.s;
            if (entity.g != null) {
                entity.v();
            } else {
                entity.b_();
            }

            int k = MathHelper.b(entity.l / 16.0D);
            int l = MathHelper.b(entity.m / 16.0D);
            int i1 = MathHelper.b(entity.n / 16.0D);

            if (!entity.Z || entity.aa != k || entity.ab != l || entity.ac != i1) {
                if (entity.Z && this.g(entity.aa, entity.ac)) {
                    this.b(entity.aa, entity.ac).a(entity, entity.ab);
                }

                if (this.g(k, i1)) {
                    this.b(k, i1).a(entity);
                } else {
                    entity.Z = false;
                    System.out.println("Removing entity because it\'s not in a chunk!!");
                    entity.j();
                }
            }

            if (entity.f != null) {
                if (!entity.f.B && entity.f.g == entity) {
                    this.e(entity.f);
                } else {
                    entity.f.g = null;
                    entity.f = null;
                }
            }

            if (Double.isNaN(entity.l) || Double.isInfinite(entity.l)) {
                entity.l = entity.J;
            }

            if (Double.isNaN(entity.m) || Double.isInfinite(entity.m)) {
                entity.m = entity.K;
            }

            if (Double.isNaN(entity.n) || Double.isInfinite(entity.n)) {
                entity.n = entity.L;
            }

            if (Double.isNaN((double) entity.s) || Double.isInfinite((double) entity.s)) {
                entity.s = entity.u;
            }

            if (Double.isNaN((double) entity.r) || Double.isInfinite((double) entity.r)) {
                entity.r = entity.t;
            }
        }
    }

    public boolean a(AxisAlignedBB axisalignedbb) {
        List list = this.b((Entity) null, axisalignedbb);

        for (int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity) list.get(i);

            if (!entity.B && entity.e) {
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
                    Block block = Block.n[this.a(k1, l1, i2)];

                    if (block != null && block.bn.d()) {
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

                    if (j2 == Block.as.bc || j2 == Block.D.bc || j2 == Block.E.bc) {
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
                    Block block = Block.n[this.a(k1, l1, i2)];

                    if (block != null && block.bn == material) {
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

            entity.o += vec3d.a * d2;
            entity.p += vec3d.b * d2;
            entity.q += vec3d.c * d2;
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
                    Block block = Block.n[this.a(k1, l1, i2)];

                    if (block != null && block.bn == material) {
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
                    Block block = Block.n[this.a(k1, l1, i2)];

                    if (block != null && block.bn == material) {
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

    public void a(Entity entity, double d1, double d2, double d3, float f1) {
        (new Explosion()).a(this, entity, d1, d2, d3, f1);
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

    public TileEntity k(int i, int j, int k) {
        Chunk chunk = this.b(i >> 4, k >> 4);

        return chunk != null ? chunk.d(i & 15, j, k & 15) : null;
    }

    public void a(int i, int j, int k, TileEntity tileentity) {
        Chunk chunk = this.b(i >> 4, k >> 4);

        if (chunk != null) {
            chunk.a(i & 15, j, k & 15, tileentity);
        }
    }

    public void l(int i, int j, int k) {
        Chunk chunk = this.b(i >> 4, k >> 4);

        if (chunk != null) {
            chunk.e(i & 15, j, k & 15);
        }
    }

    public boolean d(int i, int j, int k) {
        Block block = Block.n[this.a(i, j, k)];

        return block == null ? false : block.b();
    }

    public boolean c() {
        int i = 1000;

        while (this.y.size() > 0) {
            --i;
            if (i <= 0) {
                return true;
            }

            ((MetadataChunkBlock) this.y.remove(this.y.size() - 1)).a(this);
        }

        return false;
    }

    public void a(EnumSkyBlock enumskyblock, int i, int j, int k, int l, int i1, int j1) {
        this.a(enumskyblock, i, j, k, l, i1, j1, true);
    }

    public void a(EnumSkyBlock enumskyblock, int i, int j, int k, int l, int i1, int j1, boolean flag) {
        int k1 = (l + i) / 2;
        int l1 = (j1 + k) / 2;

        if (this.e(k1, 64, l1)) {
            int i2 = this.y.size();

            if (flag) {
                int j2 = 4;

                if (j2 > i2) {
                    j2 = i2;
                }

                for (int k2 = 0; k2 < j2; ++k2) {
                    MetadataChunkBlock metadatachunkblock = (MetadataChunkBlock) this.y.get(this.y.size() - k2 - 1);

                    if (metadatachunkblock.a == enumskyblock && metadatachunkblock.a(i, j, k, l, i1, j1)) {
                        return;
                    }
                }
            }

            this.y.add(new MetadataChunkBlock(enumskyblock, i, j, k, l, i1, j1));
            if (this.y.size() > 100000) {
                while (this.y.size() > '\uc350') {
                    this.c();
                }
            }
        }
    }

    public void d() {
        int i = this.a(1.0F);

        if (i != this.e) {
            this.e = i;
        }
    }

    public void e() {
        this.G.a();
        int i = this.a(1.0F);

        if (i != this.e) {
            this.e = i;

            for (int j = 0; j < this.r.size(); ++j) {
                ((IWorldAccess) this.r.get(j)).a();
            }
        }

        ++this.c;
        if (this.c % (long) this.j == 0L) {
            this.a(false, (IProgressUpdate) null);
        }

        this.a(false);
        this.f();
    }

    protected void f() {
        this.J.clear();

        int i;
        int j;
        int k;
        int l;

        for (int i1 = 0; i1 < this.k.size(); ++i1) {
            EntityPlayer entityplayer = (EntityPlayer) this.k.get(i1);

            i = MathHelper.b(entityplayer.l / 16.0D);
            j = MathHelper.b(entityplayer.n / 16.0D);
            byte b1 = 9;

            for (k = -b1; k <= b1; ++k) {
                for (l = -b1; l <= b1; ++l) {
                    this.J.add(new ChunkCoordIntPair(k + i, l + j));
                }
            }
        }

        if (this.K > 0) {
            --this.K;
        }

        Iterator iterator = this.J.iterator();

        while (iterator.hasNext()) {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) iterator.next();

            i = chunkcoordintpair.a * 16;
            j = chunkcoordintpair.b * 16;
            Chunk chunk = this.b(chunkcoordintpair.a, chunkcoordintpair.b);
            int j1;
            int k1;
            int l1;

            if (this.K == 0) {
                this.f = this.f * 3 + this.g;
                k = this.f >> 2;
                l = k & 15;
                j1 = k >> 8 & 15;
                k1 = k >> 16 & 127;
                l1 = chunk.a(l, k1, j1);
                l += i;
                j1 += j;
                if (l1 == 0 && this.h(l, k1, j1) <= this.m.nextInt(8) && this.a(EnumSkyBlock.a, l, k1, j1) <= 0) {
                    EntityPlayer entityplayer1 = this.a((double) l + 0.5D, (double) k1 + 0.5D, (double) j1 + 0.5D, 8.0D);

                    if (entityplayer1 != null && entityplayer1.d((double) l + 0.5D, (double) k1 + 0.5D, (double) j1 + 0.5D) > 4.0D) {
                        this.a((double) l + 0.5D, (double) k1 + 0.5D, (double) j1 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.m.nextFloat() * 0.2F);
                        this.K = this.m.nextInt(12000) + 6000;
                    }
                }
            }

            if (this.d && this.m.nextInt(4) == 0) {
                this.f = this.f * 3 + this.g;
                k = this.f >> 2;
                l = k & 15;
                j1 = k >> 8 & 15;
                k1 = this.d(l + i, j1 + j);
                if (k1 >= 0 && k1 < 128 && chunk.a(EnumSkyBlock.b, l, k1, j1) < 10) {
                    l1 = chunk.a(l, k1 - 1, j1);
                    if (chunk.a(l, k1, j1) == 0 && Block.aT.a(this, l + i, k1, j1 + j)) {
                        this.d(l + i, k1, j1 + j, Block.aT.bc);
                    }

                    if (l1 == Block.C.bc && chunk.b(l, k1 - 1, j1) == 0) {
                        this.d(l + i, k1 - 1, j1 + j, Block.aU.bc);
                    }
                }
            }

            for (k = 0; k < 80; ++k) {
                this.f = this.f * 3 + this.g;
                l = this.f >> 2;
                j1 = l & 15;
                k1 = l >> 8 & 15;
                l1 = l >> 16 & 127;
                byte b2 = chunk.b[j1 << 11 | k1 << 7 | l1];

                if (Block.o[b2]) {
                    Block.n[b2].a(this, j1 + i, l1, k1 + j, this.m);
                }
            }
        }
    }

    public boolean a(boolean flag) {
        int i = this.A.size();

        if (i != this.B.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        } else {
            if (i > 1000) {
                i = 1000;
            }

            for (int j = 0; j < i; ++j) {
                NextTickListEntry nextticklistentry = (NextTickListEntry) this.A.first();

                if (!flag && nextticklistentry.e > this.c) {
                    break;
                }

                this.A.remove(nextticklistentry);
                this.B.remove(nextticklistentry);
                byte b1 = 8;

                if (this.a(nextticklistentry.a - b1, nextticklistentry.b - b1, nextticklistentry.c - b1, nextticklistentry.a + b1, nextticklistentry.b + b1, nextticklistentry.c + b1)) {
                    int k = this.a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);

                    if (k == nextticklistentry.d && k > 0) {
                        Block.n[k].a(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, this.m);
                    }
                }
            }

            return this.A.size() != 0;
        }
    }

    public List b(Entity entity, AxisAlignedBB axisalignedbb) {
        this.L.clear();
        int i = MathHelper.b((axisalignedbb.a - 2.0D) / 16.0D);
        int j = MathHelper.b((axisalignedbb.d + 2.0D) / 16.0D);
        int k = MathHelper.b((axisalignedbb.c - 2.0D) / 16.0D);
        int l = MathHelper.b((axisalignedbb.f + 2.0D) / 16.0D);

        for (int i1 = i; i1 <= j; ++i1) {
            for (int j1 = k; j1 <= l; ++j1) {
                if (this.g(i1, j1)) {
                    this.b(i1, j1).a(entity, axisalignedbb, this.L);
                }
            }
        }

        return this.L;
    }

    public List a(Class oclass, AxisAlignedBB axisalignedbb) {
        int i = MathHelper.b((axisalignedbb.a - 2.0D) / 16.0D);
        int j = MathHelper.b((axisalignedbb.d + 2.0D) / 16.0D);
        int k = MathHelper.b((axisalignedbb.c - 2.0D) / 16.0D);
        int l = MathHelper.b((axisalignedbb.f + 2.0D) / 16.0D);
        ArrayList arraylist = new ArrayList();

        for (int i1 = i; i1 <= j; ++i1) {
            for (int j1 = k; j1 <= l; ++j1) {
                if (this.g(i1, j1)) {
                    this.b(i1, j1).a(oclass, axisalignedbb, arraylist);
                }
            }
        }

        return arraylist;
    }

    public void b(int i, int j, int k, TileEntity tileentity) {
        if (this.e(i, j, k)) {
            this.a(i, k).e();
        }

        for (int l = 0; l < this.r.size(); ++l) {
            ((IWorldAccess) this.r.get(l)).a(i, j, k, tileentity);
        }
    }

    public int a(Class oclass) {
        int i = 0;

        for (int j = 0; j < this.a.size(); ++j) {
            Entity entity = (Entity) this.a.get(j);

            if (oclass.isAssignableFrom(entity.getClass())) {
                ++i;
            }
        }

        return i;
    }

    public void a(List list) {
        this.a.addAll(list);

        for (int i = 0; i < list.size(); ++i) {
            this.b((Entity) list.get(i));
        }
    }

    public void b(List list) {
        this.z.addAll(list);
    }

    public boolean a(int i, int j, int k, int l, boolean flag) {
        int i1 = this.a(j, k, l);
        Block block = Block.n[i1];
        Block block1 = Block.n[i];
        AxisAlignedBB axisalignedbb = block1.d(this, j, k, l);

        if (flag) {
            axisalignedbb = null;
        }

        return axisalignedbb != null && !this.a(axisalignedbb) ? false : (block != Block.B && block != Block.C && block != Block.D && block != Block.E && block != Block.as && block != Block.aT ? i > 0 && block == null && block1.a(this, j, k, l) : true);
    }

    public PathEntity a(Entity entity, Entity entity1, float f1) {
        int i = MathHelper.b(entity.l);
        int j = MathHelper.b(entity.m);
        int k = MathHelper.b(entity.n);
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
        int l = MathHelper.b(entity.l);
        int i1 = MathHelper.b(entity.m);
        int j1 = MathHelper.b(entity.n);
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

        return i1 == 0 ? false : Block.n[i1].d(this, i, j, k, l);
    }

    public boolean m(int i, int j, int k) {
        return this.i(i, j - 1, k, 0) ? true : (this.i(i, j + 1, k, 1) ? true : (this.i(i, j, k - 1, 2) ? true : (this.i(i, j, k + 1, 3) ? true : (this.i(i - 1, j, k, 4) ? true : this.i(i + 1, j, k, 5)))));
    }

    public boolean j(int i, int j, int k, int l) {
        if (this.d(i, j, k)) {
            return this.m(i, j, k);
        } else {
            int i1 = this.a(i, j, k);

            return i1 == 0 ? false : Block.n[i1].b((IBlockAccess) this, i, j, k, l);
        }
    }

    public boolean n(int i, int j, int k) {
        return this.j(i, j - 1, k, 0) ? true : (this.j(i, j + 1, k, 1) ? true : (this.j(i, j, k - 1, 2) ? true : (this.j(i, j, k + 1, 3) ? true : (this.j(i - 1, j, k, 4) ? true : this.j(i + 1, j, k, 5)))));
    }

    public EntityPlayer a(Entity entity, double d1) {
        return this.a(entity.l, entity.m, entity.n, d1);
    }

    public EntityPlayer a(double d1, double d2, double d3, double d4) {
        double d5 = -1.0D;
        EntityPlayer entityplayer = null;

        for (int i = 0; i < this.k.size(); ++i) {
            EntityPlayer entityplayer1 = (EntityPlayer) this.k.get(i);
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

                k2 = this.b(j3, i4).a(abyte, k3, l2, j4, l3, i3, k4, k2);
            }
        }

        return abyte;
    }

    public void g() {
        try {
            File file1 = new File(this.s, "session.lock");
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

    static {
        float f1 = 0.05F;

        for (int i = 0; i <= 15; ++i) {
            float f2 = 1.0F - (float) i / 15.0F;

            i[i] = (1.0F - f2) / (f2 * 3.0F + 1.0F) * (1.0F - f1) + f1;
        }
    }
}
