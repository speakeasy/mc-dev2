package net.minecraft.server;

public class MobSpawnerBase {

    public static final MobSpawnerBase a = (new MobSpawnerBase()).b(588342).a("Rainforest").a(2094168);
    public static final MobSpawnerBase b = (new MobSpawnerSwamp()).b(522674).a("Swampland").a(9154376);
    public static final MobSpawnerBase c = (new MobSpawnerBase()).b(10215459).a("Seasonal Forest");
    public static final MobSpawnerBase d = (new MobSpawnerBase()).b(353825).a("Forest").a(5159473);
    public static final MobSpawnerBase e = (new MobSpawnerDesert()).b(14278691).a("Savanna");
    public static final MobSpawnerBase f = (new MobSpawnerBase()).b(10595616).a("Shrubland");
    public static final MobSpawnerBase g = (new MobSpawnerBase()).b(3060051).a("Taiga").b().a(8107825);
    public static final MobSpawnerBase h = (new MobSpawnerDesert()).b(16421912).a("Desert");
    public static final MobSpawnerBase i = (new MobSpawnerDesert()).b(16767248).a("Plains");
    public static final MobSpawnerBase j = (new MobSpawnerDesert()).b(16772499).a("Ice Desert").b().a(12899129);
    public static final MobSpawnerBase k = (new MobSpawnerBase()).b(5762041).a("Tundra").b().a(12899129);
    public static final MobSpawnerBase l = (new MobSpawnerHell()).b(16711680).a("Hell");
    public String m;
    public int n;
    public byte o;
    public byte p;
    public int q;
    protected Class[] r;
    protected Class[] s;
    private static MobSpawnerBase[] t = new MobSpawnerBase[4096];

    public MobSpawnerBase() {
        this.o = (byte) Block.v.bi;
        this.p = (byte) Block.w.bi;
        this.q = 5169201;
        this.r = new Class[] { EntitySpider.class, EntityZombie.class, EntitySkeleton.class, EntityCreeper.class};
        this.s = new Class[] { EntitySheep.class, EntityPig.class, EntityChicken.class, EntityCow.class};
    }

    public static void a() {
        for (int i = 0; i < 64; ++i) {
            for (int j = 0; j < 64; ++j) {
                t[i + j * 64] = a((float) i / 63.0F, (float) j / 63.0F);
            }
        }

        h.o = h.p = (byte) Block.F.bi;
        j.o = j.p = (byte) Block.F.bi;
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

        return t[i + j * 64];
    }

    public static MobSpawnerBase a(float f1, float f2) {
        f2 *= f1;
        return f1 < 0.1F ? k : (f2 < 0.2F ? (f1 < 0.5F ? k : (f1 < 0.95F ? e : h)) : (f2 > 0.5F && f1 < 0.7F ? b : (f1 < 0.5F ? g : (f1 < 0.97F ? (f2 < 0.35F ? f : d) : (f2 < 0.45F ? i : (f2 < 0.9F ? c : a))))));
    }

    public Class[] a(EnumCreatureType enumcreaturetype) {
        return enumcreaturetype == EnumCreatureType.a ? this.r : (enumcreaturetype == EnumCreatureType.b ? this.s : null);
    }

    static {
        a();
    }
}
