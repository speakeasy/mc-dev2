package net.minecraft.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class ServerConfigurationManager {

    public static Logger a = Logger.getLogger("Minecraft");
    public List b = new ArrayList();
    private MinecraftServer c;
    private PlayerManager d;
    private int e;
    private Set f = new HashSet();
    private Set g = new HashSet();
    private Set h = new HashSet();
    private File i;
    private File j;
    private File k;
    private PlayerNBTManager l;

    public ServerConfigurationManager(MinecraftServer minecraftserver) {
        this.c = minecraftserver;
        this.i = minecraftserver.a("banned-players.txt");
        this.j = minecraftserver.a("banned-ips.txt");
        this.k = minecraftserver.a("ops.txt");
        this.d = new PlayerManager(minecraftserver);
        this.e = minecraftserver.d.a("max-players", 20);
        this.e();
        this.g();
        this.i();
        this.f();
        this.h();
        this.j();
    }

    public void a(WorldServer worldserver) {
        this.l = new PlayerNBTManager(new File(worldserver.t, "players"));
    }

    public int a() {
        return this.d.b();
    }

    public void a(EntityPlayerMP entityplayermp) {
        this.b.add(entityplayermp);
        this.l.b(entityplayermp);
        this.c.e.A.d((int) entityplayermp.p >> 4, (int) entityplayermp.r >> 4);

        while (this.c.e.a(entityplayermp, entityplayermp.z).size() != 0) {
            entityplayermp.a(entityplayermp.p, entityplayermp.q + 1.0D, entityplayermp.r);
        }

        this.c.e.a(entityplayermp);
        this.d.a(entityplayermp);
    }

    public void b(EntityPlayerMP entityplayermp) {
        this.d.c(entityplayermp);
    }

    public void c(EntityPlayerMP entityplayermp) {
        this.d.b(entityplayermp);
        this.l.a(entityplayermp);
        this.c.e.d(entityplayermp);
        this.b.remove(entityplayermp);
    }

    public EntityPlayerMP a(NetLoginHandler netloginhandler, String s, String s1) {
        if (this.f.contains(s.trim().toLowerCase())) {
            netloginhandler.b("You are banned from this server!");
            return null;
        } else {
            String s2 = netloginhandler.b.b().toString();

            s2 = s2.substring(s2.indexOf("/") + 1);
            s2 = s2.substring(0, s2.indexOf(":"));
            if (this.g.contains(s2)) {
                netloginhandler.b("Your IP address is banned from this server!");
                return null;
            } else if (this.b.size() >= this.e) {
                netloginhandler.b("The server is full!");
                return null;
            } else {
                for (int i = 0; i < this.b.size(); ++i) {
                    EntityPlayerMP entityplayermp = (EntityPlayerMP) this.b.get(i);

                    if (entityplayermp.ar.equalsIgnoreCase(s)) {
                        entityplayermp.a.c("You logged in from another location");
                    }
                }

                return new EntityPlayerMP(this.c, this.c.e, s, new ItemInWorldManager(this.c.e));
            }
        }
    }

    public void b() {
        this.d.a();
    }

    public void a(int i, int j, int k) {
        this.d.a(i, j, k);
    }

    public void a(Packet packet) {
        for (int i = 0; i < this.b.size(); ++i) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) this.b.get(i);

            entityplayermp.a.b(packet);
        }
    }

    public String c() {
        String s = "";

        for (int i = 0; i < this.b.size(); ++i) {
            if (i > 0) {
                s = s + ", ";
            }

            s = s + ((EntityPlayerMP) this.b.get(i)).ar;
        }

        return s;
    }

    public void a(String s) {
        this.f.add(s.toLowerCase());
        this.f();
    }

    public void b(String s) {
        this.f.remove(s.toLowerCase());
        this.f();
    }

    private void e() {
        try {
            this.f.clear();
            BufferedReader bufferedreader = new BufferedReader(new FileReader(this.i));
            String s = "";

            while ((s = bufferedreader.readLine()) != null) {
                this.f.add(s.trim().toLowerCase());
            }

            bufferedreader.close();
        } catch (Exception exception) {
            a.warning("Failed to load ban list: " + exception);
        }
    }

    private void f() {
        try {
            PrintWriter printwriter = new PrintWriter(new FileWriter(this.i, false));
            Iterator iterator = this.f.iterator();

            while (iterator.hasNext()) {
                String s = (String) iterator.next();

                printwriter.println(s);
            }

            printwriter.close();
        } catch (Exception exception) {
            a.warning("Failed to save ban list: " + exception);
        }
    }

    public void c(String s) {
        this.g.add(s.toLowerCase());
        this.h();
    }

    public void d(String s) {
        this.g.remove(s.toLowerCase());
        this.h();
    }

    private void g() {
        try {
            this.g.clear();
            BufferedReader bufferedreader = new BufferedReader(new FileReader(this.j));
            String s = "";

            while ((s = bufferedreader.readLine()) != null) {
                this.g.add(s.trim().toLowerCase());
            }

            bufferedreader.close();
        } catch (Exception exception) {
            a.warning("Failed to load ip ban list: " + exception);
        }
    }

    private void h() {
        try {
            PrintWriter printwriter = new PrintWriter(new FileWriter(this.j, false));
            Iterator iterator = this.g.iterator();

            while (iterator.hasNext()) {
                String s = (String) iterator.next();

                printwriter.println(s);
            }

            printwriter.close();
        } catch (Exception exception) {
            a.warning("Failed to save ip ban list: " + exception);
        }
    }

    public void e(String s) {
        this.h.add(s.toLowerCase());
        this.j();
    }

    public void f(String s) {
        this.h.remove(s.toLowerCase());
        this.j();
    }

    private void i() {
        try {
            this.h.clear();
            BufferedReader bufferedreader = new BufferedReader(new FileReader(this.k));
            String s = "";

            while ((s = bufferedreader.readLine()) != null) {
                this.h.add(s.trim().toLowerCase());
            }

            bufferedreader.close();
        } catch (Exception exception) {
            a.warning("Failed to load ip ban list: " + exception);
        }
    }

    private void j() {
        try {
            PrintWriter printwriter = new PrintWriter(new FileWriter(this.k, false));
            Iterator iterator = this.h.iterator();

            while (iterator.hasNext()) {
                String s = (String) iterator.next();

                printwriter.println(s);
            }

            printwriter.close();
        } catch (Exception exception) {
            a.warning("Failed to save ip ban list: " + exception);
        }
    }

    public boolean g(String s) {
        return this.h.contains(s.trim().toLowerCase());
    }

    public EntityPlayerMP h(String s) {
        for (int i = 0; i < this.b.size(); ++i) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) this.b.get(i);

            if (entityplayermp.ar.equalsIgnoreCase(s)) {
                return entityplayermp;
            }
        }

        return null;
    }

    public void a(String s, String s1) {
        EntityPlayerMP entityplayermp = this.h(s);

        if (entityplayermp != null) {
            entityplayermp.a.b((Packet) (new Packet3Chat(s1)));
        }
    }

    public void i(String s) {
        Packet3Chat packet3chat = new Packet3Chat(s);

        for (int i = 0; i < this.b.size(); ++i) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) this.b.get(i);

            if (this.g(entityplayermp.ar)) {
                entityplayermp.a.b((Packet) packet3chat);
            }
        }
    }

    public boolean a(String s, Packet packet) {
        EntityPlayerMP entityplayermp = this.h(s);

        if (entityplayermp != null) {
            entityplayermp.a.b(packet);
            return true;
        } else {
            return false;
        }
    }

    public void a(int i, int j, int k, TileEntity tileentity) {
        this.d.a(new Packet59ComplexEntity(i, j, k, tileentity), i, j, k);
    }

    public void d() {
        for (int i = 0; i < this.b.size(); ++i) {
            this.l.a((EntityPlayerMP) this.b.get(i));
        }
    }
}
