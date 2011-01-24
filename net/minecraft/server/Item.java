package net.minecraft.server;

import java.util.Random;

public class Item {

    protected static Random b = new Random();
    public static Item[] c = new Item[32000];
    public static Item d = (new ItemSpade(0, 2)).a(82);
    public static Item e = (new ItemPickaxe(1, 2)).a(98);
    public static Item f = (new ItemAxe(2, 2)).a(114);
    public static Item g = (new ItemFlintAndSteel(3)).a(5);
    public static Item h = (new ItemFood(4, 4)).a(10);
    public static Item i = (new ItemBow(5)).a(21);
    public static Item j = (new Item(6)).a(37);
    public static Item k = (new Item(7)).a(7);
    public static Item l = (new Item(8)).a(55);
    public static Item m = (new Item(9)).a(23);
    public static Item n = (new Item(10)).a(39);
    public static Item o = (new ItemSword(11, 2)).a(66);
    public static Item p = (new ItemSword(12, 0)).a(64);
    public static Item q = (new ItemSpade(13, 0)).a(80);
    public static Item r = (new ItemPickaxe(14, 0)).a(96);
    public static Item s = (new ItemAxe(15, 0)).a(112);
    public static Item t = (new ItemSword(16, 1)).a(65);
    public static Item u = (new ItemSpade(17, 1)).a(81);
    public static Item v = (new ItemPickaxe(18, 1)).a(97);
    public static Item w = (new ItemAxe(19, 1)).a(113);
    public static Item x = (new ItemSword(20, 3)).a(67);
    public static Item y = (new ItemSpade(21, 3)).a(83);
    public static Item z = (new ItemPickaxe(22, 3)).a(99);
    public static Item A = (new ItemAxe(23, 3)).a(115);
    public static Item B = (new Item(24)).a(53).c();
    public static Item C = (new Item(25)).a(71);
    public static Item D = (new ItemSoup(26, 10)).a(72);
    public static Item E = (new ItemSword(27, 0)).a(68);
    public static Item F = (new ItemSpade(28, 0)).a(84);
    public static Item G = (new ItemPickaxe(29, 0)).a(100);
    public static Item H = (new ItemAxe(30, 0)).a(116);
    public static Item I = (new Item(31)).a(8);
    public static Item J = (new Item(32)).a(24);
    public static Item K = (new Item(33)).a(40);
    public static Item L = (new ItemHoe(34, 0)).a(128);
    public static Item M = (new ItemHoe(35, 1)).a(129);
    public static Item N = (new ItemHoe(36, 2)).a(130);
    public static Item O = (new ItemHoe(37, 3)).a(131);
    public static Item P = (new ItemHoe(38, 1)).a(132);
    public static Item Q = (new ItemSeeds(39, Block.aA.bc)).a(9);
    public static Item R = (new Item(40)).a(25);
    public static Item S = (new ItemFood(41, 5)).a(41);
    public static Item T = (new ItemArmor(42, 0, 0, 0)).a(0);
    public static Item U = (new ItemArmor(43, 0, 0, 1)).a(16);
    public static Item V = (new ItemArmor(44, 0, 0, 2)).a(32);
    public static Item W = (new ItemArmor(45, 0, 0, 3)).a(48);
    public static Item X = (new ItemArmor(46, 1, 1, 0)).a(1);
    public static Item Y = (new ItemArmor(47, 1, 1, 1)).a(17);
    public static Item Z = (new ItemArmor(48, 1, 1, 2)).a(33);
    public static Item aa = (new ItemArmor(49, 1, 1, 3)).a(49);
    public static Item ab = (new ItemArmor(50, 2, 2, 0)).a(2);
    public static Item ac = (new ItemArmor(51, 2, 2, 1)).a(18);
    public static Item ad = (new ItemArmor(52, 2, 2, 2)).a(34);
    public static Item ae = (new ItemArmor(53, 2, 2, 3)).a(50);
    public static Item af = (new ItemArmor(54, 3, 3, 0)).a(3);
    public static Item ag = (new ItemArmor(55, 3, 3, 1)).a(19);
    public static Item ah = (new ItemArmor(56, 3, 3, 2)).a(35);
    public static Item ai = (new ItemArmor(57, 3, 3, 3)).a(51);
    public static Item aj = (new ItemArmor(58, 1, 4, 0)).a(4);
    public static Item ak = (new ItemArmor(59, 1, 4, 1)).a(20);
    public static Item al = (new ItemArmor(60, 1, 4, 2)).a(36);
    public static Item am = (new ItemArmor(61, 1, 4, 3)).a(52);
    public static Item an = (new Item(62)).a(6);
    public static Item ao = (new ItemFood(63, 3)).a(87);
    public static Item ap = (new ItemFood(64, 8)).a(88);
    public static Item aq = (new ItemPainting(65)).a(26);
    public static Item ar = (new ItemFood(66, 42)).a(11);
    public static Item as = (new ItemSign(67)).a(42);
    public static Item at = (new ItemDoor(68, Material.c)).a(43);
    public static Item au = (new ItemBucket(69, 0)).a(74);
    public static Item av = (new ItemBucket(70, Block.B.bc)).a(75);
    public static Item aw = (new ItemBucket(71, Block.D.bc)).a(76);
    public static Item ax = (new ItemMinecart(72, 0)).a(135);
    public static Item ay = (new ItemSaddle(73)).a(104);
    public static Item az = (new ItemDoor(74, Material.e)).a(44);
    public static Item aA = (new ItemRedstone(75)).a(56);
    public static Item aB = (new ItemSnowball(76)).a(14);
    public static Item aC = (new ItemBoat(77)).a(136);
    public static Item aD = (new Item(78)).a(103);
    public static Item aE = (new ItemBucket(79, -1)).a(77);
    public static Item aF = (new Item(80)).a(22);
    public static Item aG = (new Item(81)).a(57);
    public static Item aH = (new ItemReed(82, Block.aY)).a(27);
    public static Item aI = (new Item(83)).a(58);
    public static Item aJ = (new Item(84)).a(59);
    public static Item aK = (new Item(85)).a(30);
    public static Item aL = (new ItemMinecart(86, 1)).a(151);
    public static Item aM = (new ItemMinecart(87, 2)).a(167);
    public static Item aN = (new Item(88)).a(12);
    public static Item aO = (new Item(89)).a(54);
    public static Item aP = (new Item(90)).a(69);
    public static Item aQ = (new ItemRecord(2000, "13")).a(240);
    public static Item aR = (new ItemRecord(2001, "cat")).a(241);
    public final int aS;
    protected int aT = 64;
    protected int aU = 32;
    protected int aV;
    protected boolean aW = false;

    protected Item(int i) {
        this.aS = 256 + i;
        if (c[256 + i] != null) {
            System.out.println("CONFLICT @ " + i);
        }

        c[256 + i] = this;
    }

    public Item a(int i) {
        this.aV = i;
        return this;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        return false;
    }

    public float a(ItemStack itemstack, Block block) {
        return 1.0F;
    }

    public int a() {
        return this.aT;
    }

    public int b() {
        return this.aU;
    }

    public void a(ItemStack itemstack, int i, int j, int k, int l) {}

    public boolean a(Block block) {
        return false;
    }

    public Item c() {
        this.aW = true;
        return this;
    }
}
