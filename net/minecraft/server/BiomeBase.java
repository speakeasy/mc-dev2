package net.minecraft.server;

import java.util.Random;

public class BiomeBase {

    public static final BiomeBase a = (new BiomeRainforest()).b(588342).a("Rainforest").a(2094168);
    public static final BiomeBase b = (new BiomeSwamp()).b(522674).a("Swampland").a(9154376);
    public static final BiomeBase c = (new BiomeBase()).b(10215459).a("Seasonal Forest");
    public static final BiomeBase d = (new BiomeForest()).b(353825).a("Forest").a(5159473);
    public static final BiomeBase e = (new BiomeDesert()).b(14278691).a("Savanna");
    public static final BiomeBase f = (new BiomeBase()).b(10595616).a("Shrubland");
    public static final BiomeBase g = (new BiomeTaiga()).b(3060051).a("Taiga").b().a(8107825);
    public static final BiomeBase h = (new BiomeDesert()).b(16421912).a("Desert");
    public static final BiomeBase i = (new BiomeDesert()).b(16767248).a("Plains");
    public static final BiomeBase j = (new BiomeDesert()).b(16772499).a("Ice Desert").b().a(12899129);
    public static final BiomeBase k = (new BiomeBase()).b(5762041).a("Tundra").b().a(12899129);
    public static final BiomeBase l = (new BiomeHell()).b(16711680).a("Hell");
    public String m;
    public int n;
    public byte o;
    public byte p;
    public int q;
    protected Class[] r;
    protected Class[] s;
    protected Class[] t;
    private static BiomeBase[] u = new BiomeBase[4096];

    public BiomeBase() {
        this.o = (byte) Block.GRASS.bi;
        this.p = (byte) Block.DIRT.bi;
        this.q = 5169201;
        this.r = new Class[] { EntitySpider.class, EntityZombie.class, EntitySkeleton.class, EntityCreeper.class};
        this.s = new Class[] { EntitySheep.class, EntityPig.class, EntityChicken.class, EntityCow.class};
        this.t = new Class[] { EntitySquid.class};
    }

    public static void a() {
        for (int i = 0; i < 64; ++i) {
            for (int j = 0; j < 64; ++j) {
                u[i + j * 64] = a((float) i / 63.0F, (float) j / 63.0F);
            }
        }

        h.o = h.p = (byte) Block.SAND.bi;
        j.o = j.p = (byte) Block.SAND.bi;
    }

    public WorldGenerator a(Random random) {
        return (WorldGenerator) (random.nextInt(10) == 0 ? new WorldGenBigTree() : new WorldGenTrees());
    }

    protected BiomeBase b() {
        return this;
    }

    protected BiomeBase a(String s) {
        this.m = s;
        return this;
    }

    protected BiomeBase a(int i) {
        this.q = i;
        return this;
    }

    protected BiomeBase b(int i) {
        this.n = i;
        return this;
    }

    public static BiomeBase a(double d1, double d2) {
        int i = (int) (d1 * 63.0D);
        int j = (int) (d2 * 63.0D);

        return u[i + j * 64];
    }

    public static BiomeBase a(float f1, float f2) {
        f2 *= f1;
        return f1 < 0.1F ? k : (f2 < 0.2F ? (f1 < 0.5F ? k : (f1 < 0.95F ? e : h)) : (f2 > 0.5F && f1 < 0.7F ? b : (f1 < 0.5F ? g : (f1 < 0.97F ? (f2 < 0.35F ? f : d) : (f2 < 0.45F ? i : (f2 < 0.9F ? c : a))))));
    }

    public Class[] a(EnumCreatureType enumcreaturetype) {
        return enumcreaturetype == EnumCreatureType.MONSTER ? this.r : (enumcreaturetype == EnumCreatureType.CREATURE ? this.s : (enumcreaturetype == EnumCreatureType.WATER_CREATURE ? this.t : null));
    }

    static {
        a();
    }
}
