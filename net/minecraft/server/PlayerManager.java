package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private List a = new ArrayList();
    private PlayerList b = new PlayerList();
    private List c = new ArrayList();
    private MinecraftServer d;

    public PlayerManager(MinecraftServer minecraftserver) {
        this.d = minecraftserver;
    }

    public void a() {
        for (int i = 0; i < this.c.size(); ++i) {
            ((PlayerInstance) this.c.get(i)).a();
        }

        this.c.clear();
    }

    private PlayerInstance a(int i, int j, boolean flag) {
        long k = (long) i + 2147483647L | (long) j + 2147483647L << 32;
        PlayerInstance playerinstance = (PlayerInstance) this.b.a(k);

        if (playerinstance == null && flag) {
            playerinstance = new PlayerInstance(this, i, j);
            this.b.a(k, playerinstance);
        }

        return playerinstance;
    }

    public void a(int i, int j, int k) {
        int l = i >> 4;
        int i1 = k >> 4;
        PlayerInstance playerinstance = this.a(l, i1, false);

        if (playerinstance != null) {
            playerinstance.a(i & 15, j, k & 15);
        }
    }

    public void a(EntityPlayerMP entityplayermp) {
        int i = (int) entityplayermp.p >> 4;
        int j = (int) entityplayermp.r >> 4;

        entityplayermp.d = entityplayermp.p;
        entityplayermp.e = entityplayermp.r;

        for (int k = i - 10; k <= i + 10; ++k) {
            for (int l = j - 10; l <= j + 10; ++l) {
                this.a(k, l, true).a(entityplayermp);
            }
        }

        this.a.add(entityplayermp);
    }

    public void b(EntityPlayerMP entityplayermp) {
        int i = (int) entityplayermp.d >> 4;
        int j = (int) entityplayermp.e >> 4;

        for (int k = i - 10; k <= i + 10; ++k) {
            for (int l = j - 10; l <= j + 10; ++l) {
                PlayerInstance playerinstance = this.a(k, l, false);

                if (playerinstance != null) {
                    playerinstance.b(entityplayermp);
                }
            }
        }

        this.a.remove(entityplayermp);
    }

    private boolean a(int i, int j, int k, int l) {
        int i1 = i - k;
        int j1 = j - l;

        return i1 >= -10 && i1 <= 10 ? j1 >= -10 && j1 <= 10 : false;
    }

    public void c(EntityPlayerMP entityplayermp) {
        int i = (int) entityplayermp.p >> 4;
        int j = (int) entityplayermp.r >> 4;
        double d1 = entityplayermp.d - entityplayermp.p;
        double d2 = entityplayermp.e - entityplayermp.r;
        double d3 = d1 * d1 + d2 * d2;

        if (d3 >= 64.0D) {
            int k = (int) entityplayermp.d >> 4;
            int l = (int) entityplayermp.e >> 4;
            int i1 = i - k;
            int j1 = j - l;

            if (i1 != 0 || j1 != 0) {
                for (int k1 = i - 10; k1 <= i + 10; ++k1) {
                    for (int l1 = j - 10; l1 <= j + 10; ++l1) {
                        if (!this.a(k1, l1, k, l)) {
                            this.a(k1, l1, true).a(entityplayermp);
                        }

                        if (!this.a(k1 - i1, l1 - j1, i, j)) {
                            PlayerInstance playerinstance = this.a(k1 - i1, l1 - j1, false);

                            if (playerinstance != null) {
                                playerinstance.b(entityplayermp);
                            }
                        }
                    }
                }

                entityplayermp.d = entityplayermp.p;
                entityplayermp.e = entityplayermp.r;
            }
        }
    }

    public int b() {
        return 144;
    }

    static MinecraftServer a(PlayerManager playermanager) {
        return playermanager.d;
    }

    static PlayerList b(PlayerManager playermanager) {
        return playermanager.b;
    }

    static List c(PlayerManager playermanager) {
        return playermanager.c;
    }
}
