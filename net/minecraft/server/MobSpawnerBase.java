package net.minecraft.server;

import java.util.Random;

public class MobSpawnerBase {

    public static final MobSpawnerBase RAINFOREST = (new MobSpawnerRainforest()).b(588342).a("Rainforest").a(2094168);
    public static final MobSpawnerBase SWAMPLAND = (new MobSpawnerSwamp()).b(522674).a("Swampland").a(9154376);
    public static final MobSpawnerBase SEASONAL_FOREST = (new MobSpawnerBase()).b(10215459).a("Seasonal Forest");
    public static final MobSpawnerBase FOREST = (new MobSpawnerForest()).b(353825).a("Forest").a(5159473);
    public static final MobSpawnerBase SAVANNA = (new MobSpawnerDesert()).b(14278691).a("Savanna");
    public static final MobSpawnerBase SHRUBLAND = (new MobSpawnerBase()).b(10595616).a("Shrubland");
    public static final MobSpawnerBase TAIGA = (new MobSpawnerTaiga()).b(3060051).a("Taiga").b().a(8107825);
    public static final MobSpawnerBase DESERT = (new MobSpawnerDesert()).b(16421912).a("Desert");
    public static final MobSpawnerBase PLAINS = (new MobSpawnerDesert()).b(16767248).a("Plains");
    public static final MobSpawnerBase ICE_DESERT = (new MobSpawnerDesert()).b(16772499).a("Ice Desert").b().a(12899129);
    public static final MobSpawnerBase TUNDRA = (new MobSpawnerBase()).b(5762041).a("Tundra").b().a(12899129);
    public static final MobSpawnerBase HELL = (new MobSpawnerHell()).b(16711680).a("Hell");
    public String m;
    public int n;
    public byte o;
    public byte p;
    public int q;
    protected Class[] r;
    protected Class[] s;
    protected Class[] t;
    private static MobSpawnerBase[] u = new MobSpawnerBase[4096];

    public MobSpawnerBase() {
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

        DESERT.o = DESERT.p = (byte) Block.SAND.bi;
        ICE_DESERT.o = ICE_DESERT.p = (byte) Block.SAND.bi;
    }

    public WorldGenerator a(Random random) {
        return (WorldGenerator) (random.nextInt(10) == 0 ? new WorldGenBigTree() : new WorldGenTrees());
    }

    protected MobSpawnerBase b() {
        return this;
    }

    protected MobSpawnerBase a(String s) {
        this.m = s;
        return this;
    }

    protected MobSpawnerBase a(int i) {
        this.q = i;
        return this;
    }

    protected MobSpawnerBase b(int i) {
        this.n = i;
        return this;
    }

    public static MobSpawnerBase a(double d1, double d2) {
        int i = (int) (d1 * 63.0D);
        int j = (int) (d2 * 63.0D);

        return u[i + j * 64];
    }

    public static MobSpawnerBase a(float f1, float f2) {
        f2 *= f1;
        return f1 < 0.1F ? TUNDRA : (f2 < 0.2F ? (f1 < 0.5F ? TUNDRA : (f1 < 0.95F ? SAVANNA : DESERT)) : (f2 > 0.5F && f1 < 0.7F ? SWAMPLAND : (f1 < 0.5F ? TAIGA : (f1 < 0.97F ? (f2 < 0.35F ? SHRUBLAND : FOREST) : (f2 < 0.45F ? PLAINS : (f2 < 0.9F ? SEASONAL_FOREST : RAINFOREST))))));
    }

    public Class[] a(EnumCreatureType enumcreaturetype) {
        return enumcreaturetype == EnumCreatureType.MONSTER ? this.r : (enumcreaturetype == EnumCreatureType.CREATURE ? this.s : (enumcreaturetype == EnumCreatureType.WATER_CREATURE ? this.t : null));
    }

    static {
        a();
    }
}
