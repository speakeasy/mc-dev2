package net.minecraft.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    private Map k = new HashMap();

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

    public void a(String s) {
        this.b.a((Packet) (new Packet255KickDisconnect(s)));
        this.b.c();
        this.d.f.a((Packet) (new Packet3Chat("§e" + this.e.aw + " left the game.")));
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
            double d2;
            double d3;
            double d4;
            double d5;

            if (this.e.k != null) {
                float f1 = this.e.v;
                float f2 = this.e.w;

                this.e.k.E();
                d2 = this.e.p;
                d3 = this.e.q;
                d4 = this.e.r;
                double d6 = 0.0D;

                d5 = 0.0D;
                if (packet10flying.i) {
                    f1 = packet10flying.e;
                    f2 = packet10flying.f;
                }

                if (packet10flying.h && packet10flying.b == -999.0D && packet10flying.d == -999.0D) {
                    d6 = packet10flying.a;
                    d5 = packet10flying.c;
                }

                this.e.A = packet10flying.g;
                this.e.n();
                this.e.c(d6, 0.0D, d5);
                this.e.b(d2, d3, d4, f1, f2);
                this.e.s = d6;
                this.e.u = d5;
                if (this.e.k != null) {
                    this.d.e.b(this.e.k, true);
                }

                if (this.e.k != null) {
                    this.e.k.E();
                }

                this.d.f.b(this.e);
                this.g = this.e.p;
                this.h = this.e.q;
                this.i = this.e.r;
                this.d.e.f(this.e);
                return;
            }

            d1 = this.e.q;
            this.g = this.e.p;
            this.h = this.e.q;
            this.i = this.e.r;
            d2 = this.e.p;
            d3 = this.e.q;
            d4 = this.e.r;
            float f3 = this.e.v;
            float f4 = this.e.w;

            if (packet10flying.h && packet10flying.b == -999.0D && packet10flying.d == -999.0D) {
                packet10flying.h = false;
            }

            if (packet10flying.h) {
                d2 = packet10flying.a;
                d3 = packet10flying.b;
                d4 = packet10flying.c;
                d5 = packet10flying.d - packet10flying.b;
                if (d5 > 1.65D || d5 < 0.1D) {
                    this.a("Illegal stance");
                    a.warning(this.e.aw + " had an illegal stance: " + d5);
                }

                this.e.al = packet10flying.d;
            }

            if (packet10flying.i) {
                f3 = packet10flying.e;
                f4 = packet10flying.f;
            }

            this.e.n();
            this.e.R = 0.0F;
            this.e.b(this.g, this.h, this.i, f3, f4);
            d5 = d2 - this.e.p;
            double d7 = d3 - this.e.q;
            double d8 = d4 - this.e.r;
            float f5 = 0.0625F;
            boolean flag = this.d.e.a(this.e, this.e.z.b().e((double) f5, (double) f5, (double) f5)).size() == 0;

            this.e.c(d5, d7, d8);
            d5 = d2 - this.e.p;
            d7 = d3 - this.e.q;
            if (d7 > -0.5D || d7 < 0.5D) {
                d7 = 0.0D;
            }

            d8 = d4 - this.e.r;
            double d9 = d5 * d5 + d7 * d7 + d8 * d8;
            boolean flag1 = false;

            if (d9 > 0.0625D) {
                flag1 = true;
                a.warning(this.e.aw + " moved wrongly!");
                System.out.println("Got position " + d2 + ", " + d3 + ", " + d4);
                System.out.println("Expected " + this.e.p + ", " + this.e.q + ", " + this.e.r);
            }

            this.e.b(d2, d3, d4, f3, f4);
            boolean flag2 = this.d.e.a(this.e, this.e.z.b().e((double) f5, (double) f5, (double) f5)).size() == 0;

            if (flag && (flag1 || !flag2)) {
                this.a(this.g, this.h, this.i, f3, f4);
                return;
            }

            this.e.A = packet10flying.g;
            this.d.f.b(this.e);
            this.e.b(this.e.q - d1, packet10flying.g);
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
        if (packet14blockdig.e == 4) {
            this.e.O();
        } else {
            boolean flag = this.d.e.B = this.d.f.g(this.e.aw);
            boolean flag1 = false;

            if (packet14blockdig.e == 0) {
                flag1 = true;
            }

            if (packet14blockdig.e == 1) {
                flag1 = true;
            }

            int i = packet14blockdig.a;
            int j = packet14blockdig.b;
            int k = packet14blockdig.c;

            if (flag1) {
                double d1 = this.e.p - ((double) i + 0.5D);
                double d2 = this.e.q - ((double) j + 0.5D);
                double d3 = this.e.r - ((double) k + 0.5D);
                double d4 = d1 * d1 + d2 * d2 + d3 * d3;

                if (d4 > 36.0D) {
                    return;
                }

                double d5 = this.e.q;

                this.e.q = this.e.al;
                this.e.q = d5;
            }

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
                double d6 = this.e.p - ((double) i + 0.5D);
                double d7 = this.e.q - ((double) j + 0.5D);
                double d8 = this.e.r - ((double) k + 0.5D);
                double d9 = d6 * d6 + d7 * d7 + d8 * d8;

                if (d9 < 256.0D) {
                    this.e.a.b((Packet) (new Packet53BlockChange(i, j, k, this.d.e)));
                }
            }

            this.d.e.B = false;
        }
    }

    public void a(Packet15Place packet15place) {
        ItemStack itemstack = this.e.an.e();
        boolean flag = this.d.e.B = this.d.f.g(this.e.aw);

        if (packet15place.d == 255) {
            if (itemstack == null) {
                return;
            }

            this.e.c.a(this.e, this.d.e, itemstack);
        } else {
            int i = packet15place.a;
            int j = packet15place.b;
            int k = packet15place.c;
            int l = packet15place.d;
            int i1 = (int) MathHelper.e((float) (i - this.d.e.m));
            int j1 = (int) MathHelper.e((float) (k - this.d.e.o));

            if (i1 > j1) {
                j1 = i1;
            }

            if (j1 > 16 || flag) {
                this.e.c.a(this.e, this.d.e, itemstack, i, j, k, l);
            }

            this.e.a.b((Packet) (new Packet53BlockChange(i, j, k, this.d.e)));
            if (l == 0) {
                --j;
            }

            if (l == 1) {
                ++j;
            }

            if (l == 2) {
                --k;
            }

            if (l == 3) {
                ++k;
            }

            if (l == 4) {
                --i;
            }

            if (l == 5) {
                ++i;
            }

            this.e.a.b((Packet) (new Packet53BlockChange(i, j, k, this.d.e)));
        }

        if (itemstack != null && itemstack.a == 0) {
            this.e.an.a[this.e.an.c] = null;
        }

        this.e.am = true;
        this.e.an.a[this.e.an.c] = ItemStack.b(this.e.an.a[this.e.an.c]);
        Slot slot = this.e.ap.a(this.e.an, this.e.an.c);

        this.e.ap.a();
        this.e.am = false;
        if (!ItemStack.a(this.e.an.e(), packet15place.e)) {
            this.b((Packet) (new Packet103(this.e.ap.f, slot.c, this.e.an.e())));
        }

        this.d.e.B = false;
    }

    public void a(String s, Object[] aobject) {
        a.info(this.e.aw + " lost connection: " + s);
        this.d.f.a((Packet) (new Packet3Chat("§e" + this.e.aw + " left the game.")));
        this.d.f.c(this.e);
        this.c = true;
    }

    public void a(Packet packet) {
        a.warning(this.getClass() + " wasn\'t prepared to deal with a " + packet.getClass());
        this.a("Protocol error, unexpected packet");
    }

    public void b(Packet packet) {
        this.b.a(packet);
    }

    public void a(Packet16BlockItemSwitch packet16blockitemswitch) {
        this.e.an.c = packet16blockitemswitch.a;
    }

    public void a(Packet3Chat packet3chat) {
        String s = packet3chat.a;

        if (s.length() > 100) {
            this.a("Chat message too long");
        } else {
            s = s.trim();

            for (int i = 0; i < s.length(); ++i) {
                if (FontAllowedCharacters.a.indexOf(s.charAt(i)) < 0) {
                    this.a("Illegal characters in chat");
                    return;
                }
            }

            if (s.startsWith("/")) {
                this.c(s);
            } else {
                s = "<" + this.e.aw + "> " + s;
                a.info(s);
                this.d.f.a((Packet) (new Packet3Chat(s)));
            }
        }
    }

    private void c(String s) {
        if (s.toLowerCase().startsWith("/me ")) {
            s = "* " + this.e.aw + " " + s.substring(s.indexOf(" ")).trim();
            a.info(s);
            this.d.f.a((Packet) (new Packet3Chat(s)));
        } else if (s.toLowerCase().startsWith("/kill")) {
            this.e.a((Entity) null, 1000);
        } else if (s.toLowerCase().startsWith("/tell ")) {
            String[] astring = s.split(" ");

            if (astring.length >= 3) {
                s = s.substring(s.indexOf(" ")).trim();
                s = s.substring(s.indexOf(" ")).trim();
                s = "§7" + this.e.aw + " whispers " + s;
                a.info(s + " to " + astring[1]);
                if (!this.d.f.a(astring[1], (Packet) (new Packet3Chat(s)))) {
                    this.b((Packet) (new Packet3Chat("§cThere\'s no player by that name online.")));
                }
            }
        } else {
            String s1;

            if (this.d.f.g(this.e.aw)) {
                s1 = s.substring(1);
                a.info(this.e.aw + " issued server command: " + s1);
                this.d.a(s1, (ICommandListener) this);
            } else {
                s1 = s.substring(1);
                a.info(this.e.aw + " tried command: " + s1);
            }
        }
    }

    public void a(Packet18ArmAnimation packet18armanimation) {
        if (packet18armanimation.b == 1) {
            this.e.K();
        }
    }

    public void a(Packet19 packet19) {
        System.out.println("handlePlayerCommand " + packet19.a + " " + packet19.b);
        if (packet19.b == 1) {
            this.e.b(true);
        } else if (packet19.b == 2) {
            this.e.b(false);
        }
    }

    public void a(Packet255KickDisconnect packet255kickdisconnect) {
        this.b.a("disconnect.quitting", new Object[0]);
    }

    public int b() {
        return this.b.d();
    }

    public void b(String s) {
        this.b((Packet) (new Packet3Chat("§7" + s)));
    }

    public String c() {
        return this.e.aw;
    }

    public void a(Packet7 packet7) {
        Entity entity = this.d.e.a(packet7.b);

        if (entity != null && this.e.i(entity)) {
            if (packet7.c == 0) {
                this.e.g(entity);
            } else if (packet7.c == 1) {
                this.e.h(entity);
            }
        }
    }

    public void a(Packet9 packet9) {
        if (this.e.aZ <= 0) {
            this.e = this.d.f.d(this.e);
        }
    }

    public void a(Packet101 packet101) {
        this.e.N();
    }

    public void a(Packet102 packet102) {
        if (this.e.ap.f == packet102.a && this.e.ap.c(this.e)) {
            ItemStack itemstack = this.e.ap.a(packet102.b, packet102.c, this.e);

            if (ItemStack.a(packet102.e, itemstack)) {
                this.e.a.b((Packet) (new Packet106(packet102.a, packet102.d, true)));
                this.e.am = true;
                this.e.ap.a();
                this.e.M();
                this.e.am = false;
            } else {
                this.k.put(Integer.valueOf(this.e.ap.f), Short.valueOf(packet102.d));
                this.e.a.b((Packet) (new Packet106(packet102.a, packet102.d, false)));
                this.e.ap.a(this.e, false);
                ArrayList arraylist = new ArrayList();

                for (int i = 0; i < this.e.ap.e.size(); ++i) {
                    arraylist.add(((Slot) this.e.ap.e.get(i)).c());
                }

                this.e.a(this.e.ap, arraylist);
            }
        }
    }

    public void a(Packet106 packet106) {
        Short oshort = (Short) this.k.get(Integer.valueOf(this.e.ap.f));

        if (oshort != null && packet106.b == oshort.shortValue() && this.e.ap.f == packet106.a && !this.e.ap.c(this.e)) {
            this.e.ap.a(this.e, true);
        }
    }

    public void a(Packet130 packet130) {
        if (this.d.e.f(packet130.a, packet130.b, packet130.c)) {
            TileEntity tileentity = this.d.e.m(packet130.a, packet130.b, packet130.c);

            int i;
            int j;

            for (i = 0; i < 4; ++i) {
                boolean flag = true;

                if (packet130.d[i].length() > 15) {
                    flag = false;
                } else {
                    for (j = 0; j < packet130.d[i].length(); ++j) {
                        if (FontAllowedCharacters.a.indexOf(packet130.d[i].charAt(j)) < 0) {
                            flag = false;
                        }
                    }
                }

                if (!flag) {
                    packet130.d[i] = "!?";
                }
            }

            if (tileentity instanceof TileEntitySign) {
                i = packet130.a;
                int k = packet130.b;

                j = packet130.c;
                TileEntitySign tileentitysign = (TileEntitySign) tileentity;

                for (int l = 0; l < 4; ++l) {
                    tileentitysign.e[l] = packet130.d[l];
                }

                tileentitysign.d();
                this.d.e.g(i, k, j);
            }
        }
    }
}
