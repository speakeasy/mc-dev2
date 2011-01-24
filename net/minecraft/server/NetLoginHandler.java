package net.minecraft.server;

import java.net.Socket;
import java.util.Random;
import java.util.logging.Logger;

public class NetLoginHandler extends NetHandler {

    public static Logger a = Logger.getLogger("Minecraft");
    private static Random d = new Random();
    public NetworkManager b;
    public boolean c = false;
    private MinecraftServer e;
    private int f = 0;
    private String g = null;
    private Packet1Login h = null;
    private String i = "";

    public NetLoginHandler(MinecraftServer minecraftserver, Socket socket, String s) {
        this.e = minecraftserver;
        this.b = new NetworkManager(socket, s, this);
    }

    public void a() {
        if (this.h != null) {
            this.b(this.h);
            this.h = null;
        }

        if (this.f++ == 600) {
            this.b("Took too long to log in");
        } else {
            this.b.a();
        }
    }

    public void b(String s) {
        a.info("Disconnecting " + this.b() + ": " + s);
        this.b.a((Packet) (new Packet255KickDisconnect(s)));
        this.b.c();
        this.c = true;
    }

    public void a(Packet2Handshake packet2handshake) {
        if (this.e.l) {
            this.i = Long.toHexString(d.nextLong());
            this.b.a((Packet) (new Packet2Handshake(this.i)));
        } else {
            this.b.a((Packet) (new Packet2Handshake("-")));
        }
    }

    public void a(Packet1Login packet1login) {
        this.g = packet1login.b;
        if (packet1login.a != 6) {
            if (packet1login.a > 6) {
                this.b("Outdated server!");
            } else {
                this.b("Outdated client!");
            }
        } else {
            if (!this.e.l) {
                this.b(packet1login);
            } else {
                (new ThreadLoginVerifier(this, packet1login)).start();
            }
        }
    }

    public void b(Packet1Login packet1login) {
        EntityPlayerMP entityplayermp = this.e.f.a(this, packet1login.b, packet1login.c);

        if (entityplayermp != null) {
            a.info(this.b() + " logged in with entity id " + entityplayermp.g);
            NetServerHandler netserverhandler = new NetServerHandler(this.e, this.b, entityplayermp);

            netserverhandler.b((Packet) (new Packet1Login("", "", entityplayermp.g, this.e.e.u, (byte) this.e.e.q.g)));
            netserverhandler.b((Packet) (new Packet6SpawnPosition(this.e.e.m, this.e.e.n, this.e.e.o)));
            this.e.f.a((Packet) (new Packet3Chat("§e" + entityplayermp.at + " joined the game.")));
            this.e.f.a(entityplayermp);
            netserverhandler.a(entityplayermp.p, entityplayermp.q, entityplayermp.r, entityplayermp.v, entityplayermp.w);
            netserverhandler.d();
            this.e.c.a(netserverhandler);
            netserverhandler.b((Packet) (new Packet4UpdateTime(this.e.e.e)));
            entityplayermp.a(new ItemStack(Item.aB, 64));
        }

        this.c = true;
    }

    public void a(String s) {
        a.info(this.b() + " lost connection");
        this.c = true;
    }

    public void a(Packet packet) {
        this.b("Protocol error");
    }

    public String b() {
        return this.g != null ? this.g + " [" + this.b.b().toString() + "]" : this.b.b().toString();
    }

    static String a(NetLoginHandler netloginhandler) {
        return netloginhandler.i;
    }

    static Packet1Login a(NetLoginHandler netloginhandler, Packet1Login packet1login) {
        return netloginhandler.h = packet1login;
    }
}
