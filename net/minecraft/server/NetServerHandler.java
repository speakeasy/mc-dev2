package net.minecraft.server;

import java.util.logging.Logger;

public class NetServerHandler extends NetHandler implements ICommandListener {

    public static Logger a = Logger.getLogger("Minecraft");
    public NetworkManager b;
    public boolean c = false;
    private MinecraftServer d;
    private EntityPlayerMP e;
    private int f = 0;
    private double g;
    private double h;
    private double i;
    private boolean j = true;
    private String color;
    private ItemStack k = null;

    public NetServerHandler(MinecraftServer minecraftserver, NetworkManager networkmanager, EntityPlayerMP entityplayermp) {
        this.d = minecraftserver;
        this.b = networkmanager;
        networkmanager.a((NetHandler) this);
        this.e = entityplayermp;
        entityplayermp.a = this;
        this.color = Integer.toHexString((int) (Math.random() * 15.0D));
    }

    public void a() {
        this.b.a();
        if (this.f++ % 20 == 0) {
            this.b.a((Packet) (new Packet0KeepAlive()));
        }
    }

    public void c(String s) {
        this.b.a((Packet) (new Packet255KickDisconnect(s)));
        this.b.c();
        this.d.f.c(this.e);
        this.c = true;
    }

    public void a(Packet10Flying packet10flying) {
        double d1;

        if (!this.j) {
            d1 = packet10flying.b - this.h;
            if (packet10flying.a == this.g && d1 * d1 < 0.01D && packet10flying.c == this.i) {
                this.j = true;
            }
        }

        if (this.j) {
            this.g = this.e.l;
            this.h = this.e.m;
            this.i = this.e.n;
            d1 = this.e.l;
            double d2 = this.e.m;
            double d3 = this.e.n;
            float f1 = this.e.r;
            float f2 = this.e.s;
            double d4;

            if (packet10flying.h) {
                d1 = packet10flying.a;
                d2 = packet10flying.b;
                d3 = packet10flying.c;
                d4 = packet10flying.d - packet10flying.b;
                if (d4 > 1.65D || d4 < 0.1D) {
                    this.c("Illegal stance");
                    a.warning(this.e.aq + " had an illegal stance: " + d4);
                }

                this.e.ai = packet10flying.d;
            }

            if (packet10flying.i) {
                f1 = packet10flying.e;
                f2 = packet10flying.f;
            }

            this.e.i();
            this.e.M = 0.0F;
            this.e.b(this.g, this.h, this.i, f1, f2);
            d4 = d1 - this.e.l;
            double d5 = d2 - this.e.m;
            double d6 = d3 - this.e.n;
            float f3 = 0.0625F;
            boolean l = this.d.e.a(this.e, this.e.v.b().e((double) f3, (double) f3, (double) f3)).size() == 0;

            this.e.c(d4, d5, d6);
            d4 = d1 - this.e.l;
            d5 = d2 - this.e.m;
            if (d5 > -0.5D || d5 < 0.5D) {
                d5 = 0.0D;
            }

            d6 = d3 - this.e.n;
            double d7 = d4 * d4 + d5 * d5 + d6 * d6;
            boolean i1 = false;

            if (d7 > 0.0625D) {
                i1 = true;
                a.warning(this.e.aq + " moved wrongly!");
            }

            this.e.b(d1, d2, d3, f1, f2);
            boolean i2 = this.d.e.a(this.e, this.e.v.b().e((double) f3, (double) f3, (double) f3)).size() == 0;

            if (l && (i1 || !i2)) {
                this.a(this.g, this.h, this.i, f1, f2);
                return;
            }

            this.e.w = packet10flying.g;
            this.d.f.b(this.e);
        }
    }

    public void a(double d1, double d2, double d3, float f1, float f2) {
        this.j = false;
        this.g = d1;
        this.h = d2;
        this.i = d3;
        this.e.b(d1, d2, d3, f1, f2);
        this.e.a.b((Packet) (new Packet13PlayerLookMove(d1, d2 + 1.620000004768372D, d2, d3, f1, f2, false)));
    }

    public void a(Packet14BlockDig packet14blockdig) {
        this.e.aj.a[this.e.aj.d] = this.k;
        boolean bool = this.d.e.z = this.d.f.g(this.e.aq);
        boolean l = false;

        if (packet14blockdig.e == 0) {
            l = true;
        }

        if (packet14blockdig.e == 1) {
            l = true;
        }

        if (l) {
            double d1 = this.e.m;

            this.e.m = this.e.ai;
            MovingObjectPosition i3 = this.e.a(4.0D, 1.0F);

            this.e.m = d1;
            if (i3 == null) {
                return;
            }

            if (i3.b != packet14blockdig.a || i3.c != packet14blockdig.b || i3.d != packet14blockdig.c || i3.e != packet14blockdig.d) {
                return;
            }
        }

        int i1 = packet14blockdig.a;
        int i2 = packet14blockdig.b;
        int i31 = packet14blockdig.c;
        int i4 = packet14blockdig.d;
        int i5 = (int) MathHelper.e((float) (i1 - this.d.e.n));
        int i6 = (int) MathHelper.e((float) (i31 - this.d.e.p));

        if (i5 > i6) {
            i6 = i5;
        }

        if (packet14blockdig.e == 0) {
            if (i6 > 16 || bool) {
                this.e.ad.a(i1, i2, i31);
            }
        } else if (packet14blockdig.e == 2) {
            this.e.ad.a();
        } else if (packet14blockdig.e == 1) {
            if (i6 > 16 || bool) {
                this.e.ad.a(i1, i2, i31, i4);
            }
        } else if (packet14blockdig.e == 3) {
            double d2 = this.e.l - ((double) i1 + 0.5D);
            double d3 = this.e.m - ((double) i2 + 0.5D);
            double d4 = this.e.n - ((double) i31 + 0.5D);
            double d5 = d2 * d2 + d3 * d3 + d4 * d4;

            if (d5 < 256.0D) {
                this.e.a.b((Packet) (new Packet53BlockChange(i1, i2, i31, this.d.e)));
            }
        }

        this.d.e.z = false;
    }

    public void a(Packet15Place packet15place) {
        boolean bool = this.d.e.z = this.d.f.g(this.e.aq);
        int l = packet15place.b;
        int i1 = packet15place.c;
        int i2 = packet15place.d;
        int i3 = packet15place.e;
        int i4 = (int) MathHelper.e((float) (l - this.d.e.n));
        int i5 = (int) MathHelper.e((float) (i2 - this.d.e.p));

        if (i4 > i5) {
            i5 = i4;
        }

        if (i5 > 16 || bool) {
            ItemStack localgp = packet15place.a >= 0 ? new ItemStack(packet15place.a) : null;

            this.e.ad.a(this.e, this.d.e, localgp, l, i1, i2, i3);
        }

        this.e.a.b((Packet) (new Packet53BlockChange(l, i1, i2, this.d.e)));
        this.d.e.z = false;
    }

    public void a(String s) {
        a.info(this.e.aq + " lost connection: " + s);
        this.d.f.c(this.e);
        this.c = true;
    }

    public void a(Packet packet) {
        a.warning(super.getClass() + " wasn\'t prepared to deal with a " + packet.getClass());
        this.c("Protocol error, unexpected packet");
    }

    public void b(Packet packet) {
        this.b.a(packet);
    }

    public void a(Packet16BlockItemSwitch packet16blockitemswitch) {
        int l = packet16blockitemswitch.b;

        this.e.aj.d = this.e.aj.a.length - 1;
        if (l == 0) {
            this.k = null;
        } else {
            this.k = new ItemStack(l);
        }

        this.e.aj.a[this.e.aj.d] = this.k;
        this.d.k.a(this.e, new Packet16BlockItemSwitch(this.e.c, l));
    }

    public void a(Packet21PickupSpawn packet21pickupspawn) {
        double d1 = (double) packet21pickupspawn.b / 32.0D;
        double d2 = (double) packet21pickupspawn.c / 32.0D;
        double d3 = (double) packet21pickupspawn.d / 32.0D;
        EntityItem localfn = new EntityItem(this.d.e, d1, d2, d3, new ItemStack(packet21pickupspawn.h, packet21pickupspawn.i));

        localfn.o = (double) packet21pickupspawn.e / 128.0D;
        localfn.p = (double) packet21pickupspawn.f / 128.0D;
        localfn.q = (double) packet21pickupspawn.g / 128.0D;
        localfn.ad = 10;
        this.d.e.a(localfn);
    }

    public void a(Packet3Chat packet3chat) {
        String str = packet3chat.a;

        if (str.length() > 100) {
            this.c("Chat message too long");
        } else {
            str = str.trim();

            for (int l = 0; l < str.length(); ++l) {
                if (" !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\'abcdefghijklmnopqrstuvwxyz{|}~⌂ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»".indexOf(str.charAt(l)) < 0) {
                    this.c("Illegal characters in chat");
                    return;
                }
            }

            if (str.startsWith("/")) {
                this.d(str);
            } else {
                str = "<§" + this.color + this.e.aq + "§f> " + str;
                a.info(str);
                this.d.f.a((Packet) (new Packet3Chat(str)));
            }
        }
    }

    private void d(String s) {
        if (s.toLowerCase().startsWith("/me ")) {
            s = "* " + this.e.aq + " " + s.substring(s.indexOf(" ")).trim();
            a.info(s);
            this.d.f.a((Packet) (new Packet3Chat(s)));
        } else if (s.toLowerCase().startsWith("/tell ")) {
            String[] l = s.split(" ");

            if (l.length >= 3) {
                s = s.substring(s.indexOf(" ")).trim();
                s = s.substring(s.indexOf(" ")).trim();
                s = "§7" + this.e.aq + " whispers " + s;
                a.info(s + " to " + l[1]);
                if (!this.d.f.a(l[1], (Packet) (new Packet3Chat(s)))) {
                    this.b((Packet) (new Packet3Chat("§cThere\'s no player by that name online.")));
                }
            }
        } else if (s.toLowerCase().startsWith("/color ")) {
            String s1 = s.substring(s.indexOf(" ")).trim();

            if (s1.matches("[0123456789abcdefABCDEF]")) {
                this.color = s1;
                this.b((Packet) (new Packet3Chat("§" + s1 + "Your color has changed to " + s1)));
            } else {
                this.b((Packet) (new Packet3Chat("§c/color only accepts a single hex digit.")));
                this.b((Packet) (new Packet3Chat("Values: §00§11§22§33§44§55§66§77§88§99§AA§BB§CC§DD§EE§FF")));
            }
        } else if (s.toLowerCase().equalsIgnoreCase("/color")) {
            this.b((Packet) (new Packet3Chat("§cUse /color to change the color of your name.")));
            this.b((Packet) (new Packet3Chat("Values: §00§11§22§33§44§55§66§77§88§99§AA§BB§CC§DD§EE§FF")));
        } else {
            int i;

            if (s.toLowerCase().equalsIgnoreCase("/playerlist")) {
                for (i = 0; i < this.d.f.b.size(); ++i) {
                    EntityPlayerMP str = (EntityPlayerMP) this.d.f.b.get(i);

                    this.b((Packet) (new Packet3Chat("§" + str.a.color + str.aq)));
                }
            } else if (s.toLowerCase().equalsIgnoreCase("/help")) {
                this.b((Packet) (new Packet3Chat("§e/home - return to the spawn point")));
                this.b((Packet) (new Packet3Chat("§e/playerlist - list the players on the server")));
                this.b((Packet) (new Packet3Chat("§e/tell - whisper to a player")));
                this.b((Packet) (new Packet3Chat("§e/color - change your name\'s color")));
            } else if (s.toLowerCase().equalsIgnoreCase("/home")) {
                a.info(this.e.aq + " returned home");
                i = this.d.e.d(this.d.e.n, this.d.e.p);
                this.a((double) this.d.e.n + 0.5D, (double) i + 1.5D, (double) this.d.e.p + 0.5D, 0.0F, 0.0F);
            } else {
                String s2;

                if (this.d.f.g(this.e.aq)) {
                    s2 = s.substring(1);
                    a.info(this.e.aq + " issued server command: " + s2);
                    this.d.a(s2, (ICommandListener) this);
                } else {
                    s2 = s.substring(1);
                    a.info(this.e.aq + " tried command: " + s2);
                }
            }
        }
    }

    public void a(Packet18ArmAnimation packet18armanimation) {
        if (packet18armanimation.b == 1) {
            this.e.z();
        }
    }

    public void a(Packet255KickDisconnect packet255kickdisconnect) {
        this.b.a("Quitting");
    }

    public int b() {
        return this.b.d();
    }

    public void b(String s) {
        this.b((Packet) (new Packet3Chat("§7" + s)));
    }

    public String c() {
        return this.e.aq;
    }

    public void a(Packet5PlayerInventory packet5playerinventory) {
        if (packet5playerinventory.a == -1) {
            this.e.aj.a = packet5playerinventory.b;
        }

        if (packet5playerinventory.a == -2) {
            this.e.aj.c = packet5playerinventory.b;
        }

        if (packet5playerinventory.a == -3) {
            this.e.aj.b = packet5playerinventory.b;
        }
    }

    public void d() {
        this.b.a((Packet) (new Packet5PlayerInventory(-1, this.e.aj.a)));
        this.b.a((Packet) (new Packet5PlayerInventory(-2, this.e.aj.c)));
        this.b.a((Packet) (new Packet5PlayerInventory(-3, this.e.aj.b)));
    }

    public void a(Packet59ComplexEntity packet59complexentity) {
        TileEntity localas = this.d.e.k(packet59complexentity.a, packet59complexentity.b, packet59complexentity.c);

        if (localas != null) {
            localas.a(packet59complexentity.e);
            localas.c();
        }
    }
}
