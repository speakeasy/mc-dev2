package net.minecraft.server;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SpawnerAnimals {

    private int a;
    private Class b;
    private Class[] c;
    private Set d = new HashSet();

    public SpawnerAnimals(int i, Class oclass, Class[] aclass) {
        this.a = i;
        this.b = oclass;
        this.c = aclass;
    }

    public void a(World world) {
        int i = world.a(this.b);

        if (i < this.a) {
            for (int j = 0; j < 3; ++j) {
                this.a(world, 1, (IProgressUpdate) null);
            }
        }
    }

    protected ChunkPosition a(World world, int i, int j) {
        int k = i + world.m.nextInt(16);
        int l = world.m.nextInt(128);
        int i1 = j + world.m.nextInt(16);

        return new ChunkPosition(k, l, i1);
    }

    private int a(World world, int i, IProgressUpdate iprogressupdate) {
        this.d.clear();

        int j;
        int k;
        int l;
        int i1;

        for (j = 0; j < world.k.size(); ++j) {
            EntityPlayer entityplayer = (EntityPlayer) world.k.get(j);
            int j1 = MathHelper.b(entityplayer.l / 16.0D);

            k = MathHelper.b(entityplayer.n / 16.0D);
            byte b1 = 4;

            for (l = -b1; l <= b1; ++l) {
                for (i1 = -b1; i1 <= b1; ++i1) {
                    this.d.add(new ChunkCoordIntPair(l + j1, i1 + k));
                }
            }
        }

        j = 0;
        Iterator iterator = this.d.iterator();

        while (iterator.hasNext()) {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) iterator.next();

            if (world.m.nextInt(10) == 0) {
                k = world.m.nextInt(this.c.length);
                ChunkPosition chunkposition = this.a(world, chunkcoordintpair.a * 16, chunkcoordintpair.b * 16);

                l = chunkposition.a;
                i1 = chunkposition.b;
                int k1 = chunkposition.c;

                if (world.d(l, i1, k1)) {
                    return 0;
                }

                if (world.c(l, i1, k1) != Material.a) {
                    return 0;
                }

                for (int l1 = 0; l1 < 3; ++l1) {
                    int i2 = l;
                    int j2 = i1;
                    int k2 = k1;
                    byte b2 = 6;

                    for (int l2 = 0; l2 < 2; ++l2) {
                        i2 += world.m.nextInt(b2) - world.m.nextInt(b2);
                        j2 += world.m.nextInt(1) - world.m.nextInt(1);
                        k2 += world.m.nextInt(b2) - world.m.nextInt(b2);
                        if (world.d(i2, j2 - 1, k2) && !world.d(i2, j2, k2) && !world.c(i2, j2, k2).d() && !world.d(i2, j2 + 1, k2)) {
                            float f1 = (float) i2 + 0.5F;
                            float f2 = (float) j2;
                            float f3 = (float) k2 + 0.5F;

                            if (world.a((double) f1, (double) f2, (double) f3, 24.0D) == null) {
                                float f4 = f1 - (float) world.n;
                                float f5 = f2 - (float) world.o;
                                float f6 = f3 - (float) world.p;
                                float f7 = f4 * f4 + f5 * f5 + f6 * f6;

                                if (f7 >= 576.0F) {
                                    EntityLiving entityliving;

                                    try {
                                        entityliving = (EntityLiving) this.c[k].getConstructor(new Class[] { World.class}).newInstance(new Object[] { world});
                                    } catch (Exception exception) {
                                        exception.printStackTrace();
                                        return j;
                                    }

                                    entityliving.c((double) f1, (double) f2, (double) f3, world.m.nextFloat() * 360.0F, 0.0F);
                                    if (entityliving.a()) {
                                        ++j;
                                        world.a((Entity) entityliving);
                                        if (entityliving instanceof EntitySpider && world.m.nextInt(100) == 0) {
                                            EntitySkeleton entityskeleton = new EntitySkeleton(world);

                                            entityskeleton.c((double) f1, (double) f2, (double) f3, entityliving.r, 0.0F);
                                            world.a((Entity) entityskeleton);
                                            entityskeleton.e(entityliving);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return j;
    }
}
