package net.minecraft.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EntityTracker {

    private Set a = new HashSet();
    private MCHashTable b = new MCHashTable();
    private MinecraftServer c;
    private int d;

    public EntityTracker(MinecraftServer minecraftserver) {
        this.c = minecraftserver;
        this.d = minecraftserver.f.a();
    }

    public void a(Entity entity) {
        if (entity instanceof EntityPlayerMP) {
            this.a(entity, 512, 2);
            EntityPlayerMP entityplayermp = (EntityPlayerMP) entity;
            Iterator iterator = this.a.iterator();

            while (iterator.hasNext()) {
                EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) iterator.next();

                if (entitytrackerentry.a != entityplayermp) {
                    entitytrackerentry.a(entityplayermp);
                }
            }
        } else if (entity instanceof EntityFish) {
            this.a(entity, 64, 5, true);
        } else if (entity instanceof EntityArrow) {
            this.a(entity, 64, 5, true);
        } else if (entity instanceof EntitySnowball) {
            this.a(entity, 64, 5, true);
        } else if (entity instanceof EntityItem) {
            this.a(entity, 64, 20, true);
        } else if (entity instanceof EntityMinecart) {
            this.a(entity, 160, 5, true);
        } else if (entity instanceof EntityBoat) {
            this.a(entity, 160, 5, true);
        } else if (entity instanceof IAnimals) {
            this.a(entity, 160, 3);
        } else if (entity instanceof EntityTNTPrimed) {
            this.a(entity, 160, 10, true);
        }
    }

    public void a(Entity entity, int i, int j) {
        this.a(entity, i, j, false);
    }

    public void a(Entity entity, int i, int j, boolean flag) {
        if (i > this.d) {
            i = this.d;
        }

        if (this.b.b(entity.g)) {
            throw new IllegalStateException("Entity is already tracked!");
        } else {
            EntityTrackerEntry entitytrackerentry = new EntityTrackerEntry(entity, i, j, flag);

            this.a.add(entitytrackerentry);
            this.b.a(entity.g, entitytrackerentry);
            entitytrackerentry.b(this.c.e.d);
        }
    }

    public void b(Entity entity) {
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) this.b.d(entity.g);

        if (entitytrackerentry != null) {
            this.a.remove(entitytrackerentry);
            entitytrackerentry.a();
        }
    }

    public void a() {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = this.a.iterator();

        while (iterator.hasNext()) {
            EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) iterator.next();

            entitytrackerentry.a(this.c.e.d);
            if (entitytrackerentry.p && entitytrackerentry.a instanceof EntityPlayerMP) {
                arraylist.add((EntityPlayerMP) entitytrackerentry.a);
            }
        }

        for (int i = 0; i < arraylist.size(); ++i) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) arraylist.get(i);
            Iterator iterator1 = this.a.iterator();

            while (iterator1.hasNext()) {
                EntityTrackerEntry entitytrackerentry1 = (EntityTrackerEntry) iterator1.next();

                if (entitytrackerentry1.a != entityplayermp) {
                    entitytrackerentry1.a(entityplayermp);
                }
            }
        }
    }

    public void a(Entity entity, Packet packet) {
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) this.b.a(entity.g);

        if (entitytrackerentry != null) {
            entitytrackerentry.a(packet);
        }
    }

    public void b(Entity entity, Packet packet) {
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) this.b.a(entity.g);

        if (entitytrackerentry != null) {
            entitytrackerentry.b(packet);
        }
    }

    public void a(EntityPlayerMP entityplayermp) {
        Iterator iterator = this.a.iterator();

        while (iterator.hasNext()) {
            EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) iterator.next();

            entitytrackerentry.b(entityplayermp);
        }
    }
}
