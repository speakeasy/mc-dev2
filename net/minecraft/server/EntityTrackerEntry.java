package net.minecraft.server;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EntityTrackerEntry {

    public Entity a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public double i;
    public double j;
    public double k;
    public int l = 0;
    private double o;
    private double p;
    private double q;
    private boolean r = false;
    private boolean s;
    public boolean m = false;
    public Set n = new HashSet();

    public EntityTrackerEntry(Entity entity, int i, int j, boolean flag) {
        this.a = entity;
        this.b = i;
        this.c = j;
        this.s = flag;
        this.d = MathHelper.b(entity.p * 32.0D);
        this.e = MathHelper.b(entity.q * 32.0D);
        this.f = MathHelper.b(entity.r * 32.0D);
        this.g = MathHelper.d(entity.v * 256.0F / 360.0F);
        this.h = MathHelper.d(entity.w * 256.0F / 360.0F);
    }

    public boolean equals(Object object) {
        return object instanceof EntityTrackerEntry ? ((EntityTrackerEntry) object).a.g == this.a.g : false;
    }

    public int hashCode() {
        return this.a.g;
    }

    public void a(List list) {
        this.m = false;
        if (!this.r || this.a.d(this.o, this.p, this.q) > 16.0D) {
            this.o = this.a.p;
            this.p = this.a.q;
            this.q = this.a.r;
            this.r = true;
            this.m = true;
            this.b(list);
        }

        if (++this.l % this.c == 0) {
            int i = MathHelper.b(this.a.p * 32.0D);
            int j = MathHelper.b(this.a.q * 32.0D);
            int k = MathHelper.b(this.a.r * 32.0D);
            int l = MathHelper.d(this.a.v * 256.0F / 360.0F);
            int i1 = MathHelper.d(this.a.w * 256.0F / 360.0F);
            boolean flag = i != this.d || j != this.e || k != this.f;
            boolean flag1 = l != this.g || i1 != this.h;
            int j1 = i - this.d;
            int k1 = j - this.e;
            int l1 = k - this.f;
            Object object = null;

            if (j1 >= -128 && j1 < 128 && k1 >= -128 && k1 < 128 && l1 >= -128 && l1 < 128) {
                if (flag && flag1) {
                    object = new Packet33RelEntityMoveLook(this.a.g, (byte) j1, (byte) k1, (byte) l1, (byte) l, (byte) i1);
                } else if (flag) {
                    object = new Packet31RelEntityMove(this.a.g, (byte) j1, (byte) k1, (byte) l1);
                } else if (flag1) {
                    object = new Packet32EntityLook(this.a.g, (byte) l, (byte) i1);
                } else {
                    object = new Packet30Entity(this.a.g);
                }
            } else {
                object = new Packet34EntityTeleport(this.a.g, i, j, k, (byte) l, (byte) i1);
            }

            if (this.s) {
                double d1 = this.a.s - this.i;
                double d2 = this.a.t - this.j;
                double d3 = this.a.u - this.k;
                double d4 = 0.02D;
                double d5 = d1 * d1 + d2 * d2 + d3 * d3;

                if (d5 > d4 * d4 || d5 > 0.0D && this.a.s == 0.0D && this.a.t == 0.0D && this.a.u == 0.0D) {
                    this.i = this.a.s;
                    this.j = this.a.t;
                    this.k = this.a.u;
                    this.a((Packet) (new Packet28(this.a.g, this.i, this.j, this.k)));
                }
            }

            if (object != null) {
                this.a((Packet) object);
            }

            DataWatcher datawatcher = this.a.p();

            if (datawatcher.a()) {
                this.b((Packet) (new Packet40(this.a.g, datawatcher)));
            }

            this.d = i;
            this.e = j;
            this.f = k;
            this.g = l;
            this.h = i1;
        }

        if (this.a.E) {
            this.b((Packet) (new Packet28(this.a)));
            this.a.E = false;
        }
    }

    public void a(Packet packet) {
        Iterator iterator = this.n.iterator();

        while (iterator.hasNext()) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) iterator.next();

            entityplayermp.a.b(packet);
        }
    }

    public void b(Packet packet) {
        this.a(packet);
        if (this.a instanceof EntityPlayerMP) {
            ((EntityPlayerMP) this.a).a.b(packet);
        }
    }

    public void a() {
        this.a((Packet) (new Packet29DestroyEntity(this.a.g)));
    }

    public void a(EntityPlayerMP entityplayermp) {
        if (this.n.contains(entityplayermp)) {
            this.n.remove(entityplayermp);
        }
    }

    public void b(EntityPlayerMP entityplayermp) {
        if (entityplayermp != this.a) {
            double d1 = entityplayermp.p - (double) (this.d / 32);
            double d2 = entityplayermp.r - (double) (this.f / 32);

            if (d1 >= (double) (-this.b) && d1 <= (double) this.b && d2 >= (double) (-this.b) && d2 <= (double) this.b) {
                if (!this.n.contains(entityplayermp)) {
                    this.n.add(entityplayermp);
                    entityplayermp.a.b(this.b());
                    if (this.s) {
                        entityplayermp.a.b((Packet) (new Packet28(this.a.g, this.a.s, this.a.t, this.a.u)));
                    }

                    ItemStack[] aitemstack = this.a.I();

                    if (aitemstack != null) {
                        for (int i = 0; i < aitemstack.length; ++i) {
                            entityplayermp.a.b((Packet) (new Packet5PlayerInventory(this.a.g, i, aitemstack[i])));
                        }
                    }
                }
            } else if (this.n.contains(entityplayermp)) {
                this.n.remove(entityplayermp);
                entityplayermp.a.b((Packet) (new Packet29DestroyEntity(this.a.g)));
            }
        }
    }

    public void b(List list) {
        for (int i = 0; i < list.size(); ++i) {
            this.b((EntityPlayerMP) list.get(i));
        }
    }

    private Packet b() {
        if (this.a instanceof EntityItem) {
            EntityItem entityitem = (EntityItem) this.a;
            Packet21PickupSpawn packet21pickupspawn = new Packet21PickupSpawn(entityitem);

            entityitem.p = (double) packet21pickupspawn.b / 32.0D;
            entityitem.q = (double) packet21pickupspawn.c / 32.0D;
            entityitem.r = (double) packet21pickupspawn.d / 32.0D;
            return packet21pickupspawn;
        } else if (this.a instanceof EntityPlayerMP) {
            return new Packet20NamedEntitySpawn((EntityPlayer) this.a);
        } else {
            if (this.a instanceof EntityMinecart) {
                EntityMinecart entityminecart = (EntityMinecart) this.a;

                if (entityminecart.d == 0) {
                    return new Packet23VehicleSpawn(this.a, 10);
                }

                if (entityminecart.d == 1) {
                    return new Packet23VehicleSpawn(this.a, 11);
                }

                if (entityminecart.d == 2) {
                    return new Packet23VehicleSpawn(this.a, 12);
                }
            }

            if (this.a instanceof EntityBoat) {
                return new Packet23VehicleSpawn(this.a, 1);
            } else if (this.a instanceof IAnimals) {
                return new Packet24MobSpawn((EntityLiving) this.a);
            } else if (this.a instanceof EntityFish) {
                return new Packet23VehicleSpawn(this.a, 90);
            } else if (this.a instanceof EntityArrow) {
                return new Packet23VehicleSpawn(this.a, 60);
            } else if (this.a instanceof EntitySnowball) {
                return new Packet23VehicleSpawn(this.a, 61);
            } else if (this.a instanceof EntityEgg) {
                return new Packet23VehicleSpawn(this.a, 62);
            } else if (this.a instanceof EntityTNTPrimed) {
                return new Packet23VehicleSpawn(this.a, 50);
            } else {
                if (this.a instanceof EntityFallingSand) {
                    EntityFallingSand entityfallingsand = (EntityFallingSand) this.a;

                    if (entityfallingsand.a == Block.SAND.bi) {
                        return new Packet23VehicleSpawn(this.a, 70);
                    }

                    if (entityfallingsand.a == Block.GRAVEL.bi) {
                        return new Packet23VehicleSpawn(this.a, 71);
                    }
                }

                if (this.a instanceof EntityPainting) {
                    return new Packet25((EntityPainting) this.a);
                } else {
                    throw new IllegalArgumentException("Don\'t know how to add " + this.a.getClass() + "!");
                }
            }
        }
    }

    public void c(EntityPlayerMP entityplayermp) {
        if (this.n.contains(entityplayermp)) {
            this.n.remove(entityplayermp);
            entityplayermp.a.b((Packet) (new Packet29DestroyEntity(this.a.g)));
        }
    }
}
