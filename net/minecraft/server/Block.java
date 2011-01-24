package net.minecraft.server;

import java.util.ArrayList;
import java.util.Random;

public class Block {

    public static final StepSound e = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound f = new StepSound("wood", 1.0F, 1.0F);
    public static final StepSound g = new StepSound("gravel", 1.0F, 1.0F);
    public static final StepSound h = new StepSound("grass", 1.0F, 1.0F);
    public static final StepSound i = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound j = new StepSound("stone", 1.0F, 1.5F);
    public static final StepSound k = new StepSoundStone("stone", 1.0F, 1.0F);
    public static final StepSound l = new StepSound("cloth", 1.0F, 1.0F);
    public static final StepSound m = new StepSoundSand("sand", 1.0F, 1.0F);
    public static final Block[] n = new Block[256];
    public static final boolean[] o = new boolean[256];
    public static final boolean[] p = new boolean[256];
    public static final boolean[] q = new boolean[256];
    public static final int[] r = new int[256];
    public static final boolean[] s = new boolean[256];
    public static final int[] t = new int[256];
    public static final Block u = (new BlockStone(1, 1)).c(1.5F).b(10.0F).a(i);
    public static final BlockGrass v = (BlockGrass) (new BlockGrass(2)).c(0.6F).a(h);
    public static final Block w = (new BlockDirt(3, 2)).c(0.5F).a(g);
    public static final Block x = (new Block(4, 16, Material.d)).c(2.0F).b(10.0F).a(i);
    public static final Block y = (new Block(5, 4, Material.c)).c(2.0F).b(5.0F).a(f);
    public static final Block z = (new BlockSapling(6, 15)).c(0.0F).a(h);
    public static final Block A = (new Block(7, 17, Material.d)).c(-1.0F).b(6000000.0F).a(i);
    public static final Block B = (new BlockFlowing(8, Material.f)).c(100.0F).c(3);
    public static final Block C = (new BlockStationary(9, Material.f)).c(100.0F).c(3);
    public static final Block D = (new BlockFlowing(10, Material.g)).c(0.0F).a(1.0F).c(255);
    public static final Block E = (new BlockStationary(11, Material.g)).c(100.0F).a(1.0F).c(255);
    public static final Block F = (new BlockSand(12, 18)).c(0.5F).a(m);
    public static final Block G = (new BlockGravel(13, 19)).c(0.6F).a(g);
    public static final Block H = (new BlockOre(14, 32)).c(3.0F).b(5.0F).a(i);
    public static final Block I = (new BlockOre(15, 33)).c(3.0F).b(5.0F).a(i);
    public static final Block J = (new BlockOre(16, 34)).c(3.0F).b(5.0F).a(i);
    public static final Block K = (new BlockLog(17)).c(2.0F).a(f);
    public static final BlockLeaves L = (BlockLeaves) (new BlockLeaves(18, 52)).c(0.2F).c(1).a(h);
    public static final Block M = (new BlockSponge(19)).c(0.6F).a(h);
    public static final Block N = (new BlockGlass(20, 49, Material.o, false)).c(0.3F).a(k);
    public static final Block O = null;
    public static final Block P = null;
    public static final Block Q = null;
    public static final Block R = null;
    public static final Block S = null;
    public static final Block T = null;
    public static final Block U = null;
    public static final Block V = null;
    public static final Block W = null;
    public static final Block X = null;
    public static final Block Y = null;
    public static final Block Z = null;
    public static final Block aa = null;
    public static final Block ab = null;
    public static final Block ac = (new Block(35, 64, Material.k)).c(0.8F).a(l);
    public static final Block ad = null;
    public static final BlockFlower ae = (BlockFlower) (new BlockFlower(37, 13)).c(0.0F).a(h);
    public static final BlockFlower af = (BlockFlower) (new BlockFlower(38, 12)).c(0.0F).a(h);
    public static final BlockFlower ag = (BlockFlower) (new BlockMushroom(39, 29)).c(0.0F).a(h).a(0.125F);
    public static final BlockFlower ah = (BlockFlower) (new BlockMushroom(40, 28)).c(0.0F).a(h);
    public static final Block ai = (new BlockOreBlock(41, 39)).c(3.0F).b(10.0F).a(j);
    public static final Block aj = (new BlockOreBlock(42, 38)).c(5.0F).b(10.0F).a(j);
    public static final Block ak = (new BlockStep(43, true)).c(2.0F).b(10.0F).a(i);
    public static final Block al = (new BlockStep(44, false)).c(2.0F).b(10.0F).a(i);
    public static final Block am = (new Block(45, 7, Material.d)).c(2.0F).b(10.0F).a(i);
    public static final Block an = (new BlockTNT(46, 8)).c(0.0F).a(h);
    public static final Block ao = (new BlockBookshelf(47, 35)).c(1.5F).a(f);
    public static final Block ap = (new Block(48, 36, Material.d)).c(2.0F).b(10.0F).a(i);
    public static final Block aq = (new BlockObsidian(49, 37)).c(10.0F).b(2000.0F).a(i);
    public static final Block ar = (new BlockTorch(50, 80)).c(0.0F).a(0.9375F).a(f);
    public static final BlockFire as = (BlockFire) ((BlockFire) (new BlockFire(51, 31)).c(0.0F).a(1.0F).a(f));
    public static final Block at = (new BlockMobSpawner(52, 65)).c(5.0F).a(j);
    public static final Block au = new BlockStairs(53, y);
    public static final Block av = (new BlockChest(54)).c(2.5F).a(f);
    public static final Block aw = (new BlockRedstoneWire(55, 84)).c(0.0F).a(e);
    public static final Block ax = (new BlockOre(56, 50)).c(3.0F).b(5.0F).a(i);
    public static final Block ay = (new BlockOreBlock(57, 40)).c(5.0F).b(10.0F).a(j);
    public static final Block az = (new BlockWorkbench(58)).c(2.5F).a(f);
    public static final Block aA = (new BlockCrops(59, 88)).c(0.0F).a(h);
    public static final Block aB = (new BlockSoil(60)).c(0.6F).a(g);
    public static final Block aC = (new BlockFurnace(61, false)).c(3.5F).a(i);
    public static final Block aD = (new BlockFurnace(62, true)).c(3.5F).a(i).a(0.875F);
    public static final Block aE = (new BlockSign(63, TileEntitySign.class, true)).c(1.0F).a(f);
    public static final Block aF = (new BlockDoor(64, Material.c)).c(3.0F).a(f);
    public static final Block aG = (new BlockLadder(65, 83)).c(0.4F).a(f);
    public static final Block aH = (new BlockMinecartTrack(66, 128)).c(0.7F).a(j);
    public static final Block aI = new BlockStairs(67, x);
    public static final Block aJ = (new BlockSign(68, TileEntitySign.class, false)).c(1.0F).a(f);
    public static final Block aK = (new BlockLever(69, 96)).c(0.5F).a(f);
    public static final Block aL = (new BlockPressurePlate(70, u.bb, EnumMobType.b)).c(0.5F).a(i);
    public static final Block aM = (new BlockDoor(71, Material.e)).c(5.0F).a(j);
    public static final Block aN = (new BlockPressurePlate(72, y.bb, EnumMobType.a)).c(0.5F).a(f);
    public static final Block aO = (new BlockRedstoneOre(73, 51, false)).c(3.0F).b(5.0F).a(i);
    public static final Block aP = (new BlockRedstoneOre(74, 51, true)).a(0.625F).c(3.0F).b(5.0F).a(i);
    public static final Block aQ = (new BlockRedstoneTorch(75, 115, false)).c(0.0F).a(f);
    public static final Block aR = (new BlockRedstoneTorch(76, 99, true)).c(0.0F).a(0.5F).a(f);
    public static final Block aS = (new BlockButton(77, u.bb)).c(0.5F).a(i);
    public static final Block aT = (new BlockSnow(78, 66)).c(0.1F).a(l);
    public static final Block aU = (new BlockIce(79, 67)).c(0.5F).c(3).a(k);
    public static final Block aV = (new BlockSnowBlock(80, 66)).c(0.2F).a(l);
    public static final Block aW = (new BlockCactus(81, 70)).c(0.4F).a(l);
    public static final Block aX = (new BlockClay(82, 72)).c(0.6F).a(g);
    public static final Block aY = (new BlockReed(83, 73)).c(0.0F).a(h);
    public static final Block aZ = (new BlockJukeBox(84, 74)).c(2.0F).b(10.0F).a(i);
    public static final Block ba = (new BlockFence(85, 4)).c(2.0F).b(5.0F).a(f);
    public int bb;
    public final int bc;
    protected float bd;
    protected float be;
    public double bf;
    public double bg;
    public double bh;
    public double bi;
    public double bj;
    public double bk;
    public StepSound bl;
    public float bm;
    public final Material bn;
    public float bo;

    protected Block(int i, Material material) {
        this.bl = e;
        this.bm = 1.0F;
        this.bo = 0.6F;
        if (n[i] != null) {
            throw new IllegalArgumentException("Slot " + i + " is already occupied by " + n[i] + " when adding " + this);
        } else {
            this.bn = material;
            n[i] = this;
            this.bc = i;
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            p[i] = this.b();
            r[i] = this.b() ? 255 : 0;
            s[i] = this.f();
            q[i] = false;
        }
    }

    protected Block(int i, int j, Material material) {
        this(i, material);
        this.bb = j;
    }

    protected Block a(StepSound stepsound) {
        this.bl = stepsound;
        return this;
    }

    protected Block c(int i) {
        r[this.bc] = i;
        return this;
    }

    protected Block a(float f1) {
        t[this.bc] = (int) (15.0F * f1);
        return this;
    }

    protected Block b(float f1) {
        this.be = f1 * 3.0F;
        return this;
    }

    private boolean f() {
        return false;
    }

    public int a() {
        return 0;
    }

    protected Block c(float f1) {
        this.bd = f1;
        if (this.be < f1 * 5.0F) {
            this.be = f1 * 5.0F;
        }

        return this;
    }

    protected void a(boolean flag) {
        o[this.bc] = flag;
    }

    public void a(float f1, float f2, float f3, float f4, float f5, float f6) {
        this.bf = (double) f1;
        this.bg = (double) f2;
        this.bh = (double) f3;
        this.bi = (double) f4;
        this.bj = (double) f5;
        this.bk = (double) f6;
    }

    public boolean a(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return l == 0 && this.bg > 0.0D ? true : (l == 1 && this.bj < 1.0D ? true : (l == 2 && this.bh > 0.0D ? true : (l == 3 && this.bk < 1.0D ? true : (l == 4 && this.bf > 0.0D ? true : (l == 5 && this.bi < 1.0D ? true : !iblockaccess.d(i, j, k))))));
    }

    public int a(int i) {
        return this.bb;
    }

    public void a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        AxisAlignedBB axisalignedbb1 = this.d(world, i, j, k);

        if (axisalignedbb1 != null && axisalignedbb.a(axisalignedbb1)) {
            arraylist.add(axisalignedbb1);
        }
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return AxisAlignedBB.b((double) i + this.bf, (double) j + this.bg, (double) k + this.bh, (double) i + this.bi, (double) j + this.bj, (double) k + this.bk);
    }

    public boolean b() {
        return true;
    }

    public boolean a(int i, boolean flag) {
        return this.e();
    }

    public boolean e() {
        return true;
    }

    public void a(World world, int i, int j, int k, Random random) {}

    public void a(World world, int i, int j, int k, int l) {}

    public void b(World world, int i, int j, int k, int l) {}

    public int c() {
        return 10;
    }

    public void e(World world, int i, int j, int k) {}

    public void b(World world, int i, int j, int k) {}

    public int a(Random random) {
        return 1;
    }

    public int a(int i, Random random) {
        return this.bc;
    }

    public float a(EntityPlayer entityplayer) {
        return this.bd < 0.0F ? 0.0F : (!entityplayer.b(this) ? 1.0F / this.bd / 100.0F : entityplayer.a(this) / this.bd / 30.0F);
    }

    public void a_(World world, int i, int j, int k, int l) {
        this.a(world, i, j, k, l, 1.0F);
    }

    public void a(World world, int i, int j, int k, int l, float f1) {
        if (!world.x) {
            int i1 = this.a(world.m);

            for (int j1 = 0; j1 < i1; ++j1) {
                if (world.m.nextFloat() <= f1) {
                    int k1 = this.a(l, world.m);

                    if (k1 > 0) {
                        float f2 = 0.7F;
                        double d1 = (double) (world.m.nextFloat() * f2) + (double) (1.0F - f2) * 0.5D;
                        double d2 = (double) (world.m.nextFloat() * f2) + (double) (1.0F - f2) * 0.5D;
                        double d3 = (double) (world.m.nextFloat() * f2) + (double) (1.0F - f2) * 0.5D;
                        EntityItem entityitem = new EntityItem(world, (double) i + d1, (double) j + d2, (double) k + d3, new ItemStack(k1));

                        entityitem.ad = 10;
                        world.a((Entity) entityitem);
                    }
                }
            }
        }
    }

    public float a(Entity entity) {
        return this.be / 5.0F;
    }

    public MovingObjectPosition a(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1) {
        this.a((IBlockAccess) world, i, j, k);
        vec3d = vec3d.c((double) (-i), (double) (-j), (double) (-k));
        vec3d1 = vec3d1.c((double) (-i), (double) (-j), (double) (-k));
        Vec3D vec3d2 = vec3d.a(vec3d1, this.bf);
        Vec3D vec3d3 = vec3d.a(vec3d1, this.bi);
        Vec3D vec3d4 = vec3d.b(vec3d1, this.bg);
        Vec3D vec3d5 = vec3d.b(vec3d1, this.bj);
        Vec3D vec3d6 = vec3d.c(vec3d1, this.bh);
        Vec3D vec3d7 = vec3d.c(vec3d1, this.bk);

        if (!this.a(vec3d2)) {
            vec3d2 = null;
        }

        if (!this.a(vec3d3)) {
            vec3d3 = null;
        }

        if (!this.b(vec3d4)) {
            vec3d4 = null;
        }

        if (!this.b(vec3d5)) {
            vec3d5 = null;
        }

        if (!this.c(vec3d6)) {
            vec3d6 = null;
        }

        if (!this.c(vec3d7)) {
            vec3d7 = null;
        }

        Vec3D vec3d8 = null;

        if (vec3d2 != null && (vec3d8 == null || vec3d.a(vec3d2) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d2;
        }

        if (vec3d3 != null && (vec3d8 == null || vec3d.a(vec3d3) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d3;
        }

        if (vec3d4 != null && (vec3d8 == null || vec3d.a(vec3d4) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d4;
        }

        if (vec3d5 != null && (vec3d8 == null || vec3d.a(vec3d5) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d5;
        }

        if (vec3d6 != null && (vec3d8 == null || vec3d.a(vec3d6) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d6;
        }

        if (vec3d7 != null && (vec3d8 == null || vec3d.a(vec3d7) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d7;
        }

        if (vec3d8 == null) {
            return null;
        } else {
            byte b1 = -1;

            if (vec3d8 == vec3d2) {
                b1 = 4;
            }

            if (vec3d8 == vec3d3) {
                b1 = 5;
            }

            if (vec3d8 == vec3d4) {
                b1 = 0;
            }

            if (vec3d8 == vec3d5) {
                b1 = 1;
            }

            if (vec3d8 == vec3d6) {
                b1 = 2;
            }

            if (vec3d8 == vec3d7) {
                b1 = 3;
            }

            return new MovingObjectPosition(i, j, k, b1, vec3d8.c((double) i, (double) j, (double) k));
        }
    }

    private boolean a(Vec3D vec3d) {
        return vec3d == null ? false : vec3d.b >= this.bg && vec3d.b <= this.bj && vec3d.c >= this.bh && vec3d.c <= this.bk;
    }

    private boolean b(Vec3D vec3d) {
        return vec3d == null ? false : vec3d.a >= this.bf && vec3d.a <= this.bi && vec3d.c >= this.bh && vec3d.c <= this.bk;
    }

    private boolean c(Vec3D vec3d) {
        return vec3d == null ? false : vec3d.a >= this.bf && vec3d.a <= this.bi && vec3d.b >= this.bg && vec3d.b <= this.bj;
    }

    public void c(World world, int i, int j, int k) {}

    public boolean a(World world, int i, int j, int k) {
        int l = world.a(i, j, k);

        return l == 0 || n[l].bn.d();
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        return false;
    }

    public void b(World world, int i, int j, int k, Entity entity) {}

    public void c(World world, int i, int j, int k, int l) {}

    public void b(World world, int i, int j, int k, EntityPlayer entityplayer) {}

    public void a(World world, int i, int j, int k, Entity entity, Vec3D vec3d) {}

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {}

    public boolean b(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return false;
    }

    public boolean d() {
        return false;
    }

    public void a(World world, int i, int j, int k, Entity entity) {}

    public boolean d(World world, int i, int j, int k, int l) {
        return false;
    }

    public boolean f(World world, int i, int j, int k) {
        return true;
    }

    static {
        for (int i = 0; i < 256; ++i) {
            if (n[i] != null) {
                Item.c[i] = new ItemBlock(i - 256);
            }
        }
    }
}
