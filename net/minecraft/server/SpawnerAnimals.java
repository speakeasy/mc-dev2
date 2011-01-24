package net.minecraft.server;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class SpawnerAnimals {

    private static Set a = new HashSet();

    public SpawnerAnimals() {}

    protected static ChunkPosition a(World world, int i, int j) {
        int k = i + world.l.nextInt(16);
        int l = world.l.nextInt(128);
        int i1 = j + world.l.nextInt(16);

        return new ChunkPosition(k, l, i1);
    }

    public static final int a(World world) {
        a.clear();

        int i;

        for (i = 0; i < world.d.size(); ++i) {
            EntityPlayer entityplayer = (EntityPlayer) world.d.get(i);
            int j = MathHelper.b(entityplayer.p / 16.0D);
            int k = MathHelper.b(entityplayer.r / 16.0D);
            byte b1 = 8;

            for (int l = -b1; l <= b1; ++l) {
                for (int i1 = -b1; i1 <= b1; ++i1) {
                    a.add(new ChunkCoordIntPair(l + j, i1 + k));
                }
            }
        }

        i = 0;

        for (int j1 = 0; j1 < EnumCreatureType.values().length; ++j1) {
            EnumCreatureType enumcreaturetype = EnumCreatureType.values()[j1];

            if (world.a(enumcreaturetype.c) <= enumcreaturetype.d * a.size() / 256) {
                Iterator iterator = a.iterator();

                label90:
                while (iterator.hasNext()) {
                    ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) iterator.next();

                    if (world.l.nextInt(50) == 0) {
                        MobSpawnerBase mobspawnerbase = world.a().a(chunkcoordintpair);
                        Class[] aclass = mobspawnerbase.a(enumcreaturetype);

                        if (aclass != null && aclass.length != 0) {
                            int k1 = world.l.nextInt(aclass.length);
                            ChunkPosition chunkposition = a(world, chunkcoordintpair.a * 16, chunkcoordintpair.b * 16);
                            int l1 = chunkposition.a;
                            int i2 = chunkposition.b;
                            int j2 = chunkposition.c;

                            if (!world.d(l1, i2, j2) && world.c(l1, i2, j2) == Material.a) {
                                int k2 = 0;

                                for (int l2 = 0; l2 < 3; ++l2) {
                                    int i3 = l1;
                                    int j3 = i2;
                                    int k3 = j2;
                                    byte b2 = 6;

                                    for (int l3 = 0; l3 < 4; ++l3) {
                                        i3 += world.l.nextInt(b2) - world.l.nextInt(b2);
                                        j3 += world.l.nextInt(1) - world.l.nextInt(1);
                                        k3 += world.l.nextInt(b2) - world.l.nextInt(b2);
                                        if (world.d(i3, j3 - 1, k3) && !world.d(i3, j3, k3) && !world.c(i3, j3, k3).d() && !world.d(i3, j3 + 1, k3)) {
                                            float f1 = (float) i3 + 0.5F;
                                            float f2 = (float) j3;
                                            float f3 = (float) k3 + 0.5F;

                                            if (world.a((double) f1, (double) f2, (double) f3, 24.0D) == null) {
                                                float f4 = f1 - (float) world.m;
                                                float f5 = f2 - (float) world.n;
                                                float f6 = f3 - (float) world.o;
                                                float f7 = f4 * f4 + f5 * f5 + f6 * f6;

                                                if (f7 >= 576.0F) {
                                                    EntityLiving entityliving;

                                                    try {
                                                        entityliving = (EntityLiving) aclass[k1].getConstructor(new Class[] { World.class}).newInstance(new Object[] { world});
                                                    } catch (Exception exception) {
                                                        exception.printStackTrace();
                                                        return i;
                                                    }

                                                    entityliving.c((double) f1, (double) f2, (double) f3, world.l.nextFloat() * 360.0F, 0.0F);
                                                    if (entityliving.a()) {
                                                        ++k2;
                                                        world.a((Entity) entityliving);
                                                        if (entityliving instanceof EntitySpider && world.l.nextInt(100) == 0) {
                                                            EntitySkeleton entityskeleton = new EntitySkeleton(world);

                                                            entityskeleton.c((double) f1, (double) f2, (double) f3, entityliving.v, 0.0F);
                                                            world.a((Entity) entityskeleton);
                                                            entityskeleton.e(entityliving);
                                                        }

                                                        if (k2 >= entityliving.i()) {
                                                            continue label90;
                                                        }
                                                    }

                                                    i += k2;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return i;
    }
}
