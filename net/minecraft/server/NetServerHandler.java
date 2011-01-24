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
    private ItemStack k = null;

    public NetServerHandler(MinecraftServer minecraftserver, NetworkManager networkmanager, EntityPlayerMP entityplayermp) {
        this.d = minecraftserver;
        this.b = networkmanager;
        networkmanager.a((NetHandler) this);
        this.e = entityplayermp;
        entityplayermp.a = this;
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
            this.g = this.e.p;
            this.h = this.e.q;
            this.i = this.e.r;
            d1 = this.e.p;
            double d2 = this.e.q;
            double d3 = this.e.r;
            float f1 = this.e.v;
            float f2 = this.e.w;
            double d4;

            if (packet10flying.h) {
                d1 = packet10flying.a;
                d2 = packet10flying.b;
                d3 = packet10flying.c;
                d4 = packet10flying.d - packet10flying.b;
                if (d4 > 1.65D || d4 < 0.1D) {
                    this.c("Illegal stance");
                    a.warning(this.e.ar + " had an illegal stance: " + d4);
                }

                this.e.aj = packet10flying.d;
            }

            if (packet10flying.i) {
                f1 = packet10flying.e;
                f2 = packet10flying.f;
            }

            this.e.k();
            this.e.Q = 0.0F;
            this.e.b(this.g, this.h, this.i, f1, f2);
            d4 = d1 - this.e.p;
            double d5 = d2 - this.e.q;
            double d6 = d3 - this.e.r;
            float f3 = 0.0625F;
            boolean flag = this.d.e.a(this.e, this.e.z.b().e((double) f3, (double) f3, (double) f3)).size() == 0;

            this.e.c(d4, d5, d6);
            d4 = d1 - this.e.p;
            d5 = d2 - this.e.q;
            if (d5 > -0.5D || d5 < 0.5D) {
                d5 = 0.0D;
            }

            d6 = d3 - this.e.r;
            double d7 = d4 * d4 + d5 * d5 + d6 * d6;
            boolean flag1 = false;

            if (d7 > 0.0625D) {
                flag1 = true;
                a.warning(this.e.ar + " moved wrongly!");
            }

            this.e.b(d1, d2, d3, f1, f2);
            boolean flag2 = this.d.e.a(this.e, this.e.z.b().e((double) f3, (double) f3, (double) f3)).size() == 0;

            if (flag && (flag1 || !flag2)) {
                this.a(this.g, this.h, this.i, f1, f2);
                return;
            }

            this.e.A = packet10flying.g;
            this.d.f.b(this.e);
        }
    }

    public void a(double d1, double d2, double d3, float f1, float f2) {
        this.j = false;
        this.g = d1;
        this.h = d2;
        this.i = d3;
        this.e.b(d1, d2, d3, f1, f2);
        this.e.a.b((Packet) (new Packet13PlayerLookMove(d1, d2 + 1.6200000047683716D, d2, d3, f1, f2, false)));
    }

    public void a(Packet14BlockDig packet14blockdig) {
        this.e.ak.a[this.e.ak.d] = this.k;
        boolean flag = this.d.e.B = this.d.f.g(this.e.ar);
        boolean flag1 = false;

        if (packet14blockdig.e == 0) {
            flag1 = true;
        }

        if (packet14blockdig.e == 1) {
            flag1 = true;
        }

        if (flag1) {
            double d1 = this.e.q;

            this.e.q = this.e.aj;
            MovingObjectPosition movingobjectposition = this.e.a(4.0D, 1.0F);

            this.e.q = d1;
            if (movingobjectposition == null) {
                return;
            }

            if (movingobjectposition.b != packet14blockdig.a || movingobjectposition.c != packet14blockdig.b || movingobjectposition.d != packet14blockdig.c || movingobjectposition.e != packet14blockdig.d) {
                return;
            }
        }

        int i = packet14blockdig.a;
        int j = packet14blockdig.b;
        int k = packet14blockdig.c;
        int l = packet14blockdig.d;
        int i1 = (int) MathHelper.e((float) (i - this.d.e.m));
        int j1 = (int) MathHelper.e((float) (k - this.d.e.o));

        if (i1 > j1) {
            j1 = i1;
        }

        if (packet14blockdig.e == 0) {
            if (j1 > 16 || flag) {
                this.e.c.a(i, j, k);
            }
        } else if (packet14blockdig.e == 2) {
            this.e.c.a();
        } else if (packet14blockdig.e == 1) {
            if (j1 > 16 || flag) {
                this.e.c.a(i, j, k, l);
            }
        } else if (packet14blockdig.e == 3) {
            double d2 = this.e.p - ((double) i + 0.5D);
            double d3 = this.e.q - ((double) j + 0.5D);
            double d4 = this.e.r - ((double) k + 0.5D);
            double d5 = d2 * d2 + d3 * d3 + d4 * d4;

            if (d5 < 256.0D) {
                this.e.a.b((Packet) (new Packet53BlockChange(i, j, k, this.d.e)));
            }
        }

        this.d.e.B = false;
    }

    public void a(Packet15Place packet15place) {
        boolean flag = this.d.e.B = this.d.f.g(this.e.ar);
        int i = packet15place.b;
        int j = packet15place.c;
        int k = packet15place.d;
        int l = packet15place.e;
        int i1 = (int) MathHelper.e((float) (i - this.d.e.m));
        int j1 = (int) MathHelper.e((float) (k - this.d.e.o));

        if (i1 > j1) {
            j1 = i1;
        }

        if (j1 > 16 || flag) {
            ItemStack itemstack = packet15place.a >= 0 ? new ItemStack(packet15place.a) : null;

            this.e.c.a(this.e, this.d.e, itemstack, i, j, k, l);
        }

        this.e.a.b((Packet) (new Packet53BlockChange(i, j, k, this.d.e)));
        this.d.e.B = false;
    }

    public void a(String s) {
        a.info(this.e.ar + " lost connection: " + s);
        this.d.f.c(this.e);
        this.c = true;
    }

    public void a(Packet packet) {
        a.warning(this.getClass() + " wasn\'t prepared to deal with a " + packet.getClass());
        this.c("Protocol error, unexpected packet");
    }

    public void b(Packet packet) {
        this.b.a(packet);
    }

    public void a(Packet16BlockItemSwitch packet16blockitemswitch) {
        int i = packet16blockitemswitch.b;

        this.e.ak.d = this.e.ak.a.length - 1;
        if (i == 0) {
            this.k = null;
        } else {
            this.k = new ItemStack(i);
        }

        this.e.ak.a[this.e.ak.d] = this.k;
        this.d.k.a(this.e, new Packet16BlockItemSwitch(this.e.g, i));
    }

    public void a(Packet21PickupSpawn packet21pickupspawn) {
        double d1 = (double) packet21pickupspawn.b / 32.0D;
        double d2 = (double) packet21pickupspawn.c / 32.0D;
        double d3 = (double) packet21pickupspawn.d / 32.0D;
        EntityItem entityitem = new EntityItem(this.d.e, d1, d2, d3, new ItemStack(packet21pickupspawn.h, packet21pickupspawn.i));

        entityitem.s = (double) packet21pickupspawn.e / 128.0D;
        entityitem.t = (double) packet21pickupspawn.f / 128.0D;
        entityitem.u = (double) packet21pickupspawn.g / 128.0D;
        entityitem.c = 10;
        this.d.e.a(entityitem);
    }

    public void a(Packet3Chat packet3chat) {
        String s = packet3chat.a;

        if (s.length() > 100) {
            this.c("Chat message too long");
        } else {
            s = s.trim();

            for (int i = 0; i < s.length(); ++i) {
                if (" !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\'abcdefghijklmnopqrstuvwxyz{|}~⌂ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»".indexOf(s.charAt(i)) < 0) {
                    this.c("Illegal characters in chat");
                    return;
                }
            }

            if (s.startsWith("/")) {
                this.d(s);
            } else {
                s = "<" + this.e.ar + "> " + s;
                a.info(s);
                this.d.f.a((Packet) (new Packet3Chat(s)));
            }
        }
    }

    private void d(String s) {
        if (s.toLowerCase().startsWith("/me ")) {
            s = "* " + this.e.ar + " " + s.substring(s.indexOf(" ")).trim();
            a.info(s);
            this.d.f.a((Packet) (new Packet3Chat(s)));
        } else if (s.toLowerCase().startsWith("/tell ")) {
            String[] astring = s.split(" ");

            if (astring.length >= 3) {
                s = s.substring(s.indexOf(" ")).trim();
                s = s.substring(s.indexOf(" ")).trim();
                s = "§7" + this.e.ar + " whispers " + s;
                a.info(s + " to " + astring[1]);
                if (!this.d.f.a(astring[1], (Packet) (new Packet3Chat(s)))) {
                    this.b((Packet) (new Packet3Chat("§cThere\'s no player by that name online.")));
                }
            }
        } else if (s.toLowerCase().equalsIgnoreCase("/home")) {
            a.info(this.e.ar + " returned home");
            int i = this.d.e.e(this.d.e.m, this.d.e.o);

            this.a((double) this.d.e.m + 0.5D, (double) i + 1.5D, (double) this.d.e.o + 0.5D, 0.0F, 0.0F);
        } else {
            String s1;

            if (this.d.f.g(this.e.ar)) {
                s1 = s.substring(1);
                a.info(this.e.ar + " issued server command: " + s1);
                this.d.a(s1, (ICommandListener) this);
            } else {
                s1 = s.substring(1);
                a.info(this.e.ar + " tried command: " + s1);
            }
        }
    }

    public void a(Packet18ArmAnimation packet18armanimation) {
        if (packet18armanimation.b == 1) {
            this.e.E();
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
        return this.e.ar;
    }

    public void a(Packet5PlayerInventory packet5playerinventory) {
        if (packet5playerinventory.a == -1) {
            this.e.ak.a = packet5playerinventory.b;
        }

        if (packet5playerinventory.a == -2) {
            this.e.ak.c = packet5playerinventory.b;
        }

        if (packet5playerinventory.a == -3) {
            this.e.ak.b = packet5playerinventory.b;
        }
    }

    public void d() {
        this.b.a((Packet) (new Packet5PlayerInventory(-1, this.e.ak.a)));
        this.b.a((Packet) (new Packet5PlayerInventory(-2, this.e.ak.c)));
        this.b.a((Packet) (new Packet5PlayerInventory(-3, this.e.ak.b)));
    }

    public void a(Packet59ComplexEntity packet59complexentity) {
        if (packet59complexentity.e.d("x") == packet59complexentity.a) {
            if (packet59complexentity.e.d("y") == packet59complexentity.b) {
                if (packet59complexentity.e.d("z") == packet59complexentity.c) {
                    TileEntity tileentity = this.d.e.k(packet59complexentity.a, packet59complexentity.b, packet59complexentity.c);

                    if (tileentity != null) {
                        try {
                            tileentity.a(packet59complexentity.e);
                        } catch (Exception exception) {
                            ;
                        }

                        tileentity.c();
                    }
                }
            }
        }
    }
}
