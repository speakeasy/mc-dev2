package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;

class PlayerInstance {

    private List b;
    private int c;
    private int d;
    private ChunkCoordIntPair e;
    private short[] f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    final PlayerManager a;

    public PlayerInstance(PlayerManager playermanager, int i, int j) {
        this.a = playermanager;
        this.b = new ArrayList();
        this.f = new short[10];
        this.g = 0;
        this.c = i;
        this.d = j;
        this.e = new ChunkCoordIntPair(i, j);
        PlayerManager.a(playermanager).e.A.d(i, j);
    }

    public void a(EntityPlayerMP entityplayermp) {
        if (this.b.contains(entityplayermp)) {
            throw new IllegalStateException("Failed to add player. " + entityplayermp + " already is in chunk " + this.c + ", " + this.d);
        } else {
            entityplayermp.aj.add(this.e);
            entityplayermp.a.b((Packet) (new Packet50PreChunk(this.e.a, this.e.b, true)));
            this.b.add(entityplayermp);
            entityplayermp.f.add(this.e);
        }
    }

    public void b(EntityPlayerMP entityplayermp) {
        if (!this.b.contains(entityplayermp)) {
            (new IllegalStateException("Failed to remove player. " + entityplayermp + " isn\'t in chunk " + this.c + ", " + this.d)).printStackTrace();
        } else {
            this.b.remove(entityplayermp);
            if (this.b.size() == 0) {
                long i = (long) this.c + 2147483647L | (long) this.d + 2147483647L << 32;

                PlayerManager.b(this.a).b(i);
                if (this.g > 0) {
                    PlayerManager.c(this.a).remove(this);
                }

                PlayerManager.a(this.a).e.A.c(this.c, this.d);
            }

            entityplayermp.f.remove(this.e);
            if (entityplayermp.aj.contains(this.e)) {
                entityplayermp.a.b((Packet) (new Packet50PreChunk(this.c, this.d, false)));
            }
        }
    }

    public void a(int i, int j, int k) {
        if (this.g == 0) {
            PlayerManager.c(this.a).add(this);
            this.h = this.i = i;
            this.j = this.k = j;
            this.l = this.m = k;
        }

        if (this.h > i) {
            this.h = i;
        }

        if (this.i < i) {
            this.i = i;
        }

        if (this.j > j) {
            this.j = j;
        }

        if (this.k < j) {
            this.k = j;
        }

        if (this.l > k) {
            this.l = k;
        }

        if (this.m < k) {
            this.m = k;
        }

        if (this.g < 10) {
            short short1 = (short) (i << 12 | k << 8 | j);

            for (int l = 0; l < this.g; ++l) {
                if (this.f[l] == short1) {
                    return;
                }
            }

            this.f[this.g++] = short1;
        }
    }

    public void a(Packet packet) {
        for (int i = 0; i < this.b.size(); ++i) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) this.b.get(i);

            if (entityplayermp.aj.contains(this.e)) {
                entityplayermp.a.b(packet);
            }
        }
    }

    public void a() {
        if (this.g != 0) {
            int i;
            int j;
            int k;

            if (this.g == 1) {
                i = this.c * 16 + this.h;
                j = this.j;
                k = this.d * 16 + this.l;
                this.a((Packet) (new Packet53BlockChange(i, j, k, PlayerManager.a(this.a).e)));
                if (Block.p[PlayerManager.a(this.a).e.a(i, j, k)]) {
                    this.a(PlayerManager.a(this.a).e.l(i, j, k));
                }
            } else {
                int l;

                if (this.g == 10) {
                    this.j = this.j / 2 * 2;
                    this.k = (this.k / 2 + 1) * 2;
                    i = this.h + this.c * 16;
                    j = this.j;
                    k = this.l + this.d * 16;
                    l = this.i - this.h + 1;
                    int i1 = this.k - this.j + 2;
                    int j1 = this.m - this.l + 1;

                    this.a((Packet) (new Packet51MapChunk(i, j, k, l, i1, j1, PlayerManager.a(this.a).e)));
                    List list = PlayerManager.a(this.a).e.d(i, j, k, i + l, j + i1, k + j1);

                    for (int k1 = 0; k1 < list.size(); ++k1) {
                        this.a((TileEntity) list.get(k1));
                    }
                } else {
                    this.a((Packet) (new Packet52MultiBlockChange(this.c, this.d, this.f, this.g, PlayerManager.a(this.a).e)));

                    for (i = 0; i < this.g; ++i) {
                        j = this.c * 16 + (this.g >> 12 & 15);
                        k = this.g & 255;
                        l = this.d * 16 + (this.g >> 8 & 15);
                        if (Block.p[PlayerManager.a(this.a).e.a(j, k, l)]) {
                            System.out.println("Sending!");
                            this.a(PlayerManager.a(this.a).e.l(j, k, l));
                        }
                    }
                }
            }

            this.g = 0;
        }
    }

    private void a(TileEntity tileentity) {
        if (tileentity != null) {
            Packet packet = tileentity.f();

            if (packet != null) {
                this.a(packet);
            }
        }
    }
}
