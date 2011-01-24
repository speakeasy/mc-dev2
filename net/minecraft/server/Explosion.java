package net.minecraft.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Explosion {

    public Explosion() {}

    public void a(World world, Entity entity, double d1, double d2, double d3, float f1) {
        world.a(d1, d2, d3, "random.explode", 4.0F, (1.0F + (world.m.nextFloat() - world.m.nextFloat()) * 0.2F) * 0.7F);
        HashSet hashset = new HashSet();
        float f2 = f1;
        byte b1 = 16;

        int i;
        int j;
        int k;
        double d4;
        double d5;
        double d6;

        for (i = 0; i < b1; ++i) {
            for (j = 0; j < b1; ++j) {
                for (k = 0; k < b1; ++k) {
                    if (i == 0 || i == b1 - 1 || j == 0 || j == b1 - 1 || k == 0 || k == b1 - 1) {
                        double d7 = (double) ((float) i / ((float) b1 - 1.0F) * 2.0F - 1.0F);
                        double d8 = (double) ((float) j / ((float) b1 - 1.0F) * 2.0F - 1.0F);
                        double d9 = (double) ((float) k / ((float) b1 - 1.0F) * 2.0F - 1.0F);
                        double d10 = Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);

                        d7 /= d10;
                        d8 /= d10;
                        d9 /= d10;
                        float f3 = f1 * (0.7F + world.m.nextFloat() * 0.6F);

                        d4 = d1;
                        d5 = d2;
                        d6 = d3;

                        for (float f4 = 0.3F; f3 > 0.0F; f3 -= f4 * 0.75F) {
                            int l = MathHelper.b(d4);
                            int i1 = MathHelper.b(d5);
                            int j1 = MathHelper.b(d6);
                            int k1 = world.a(l, i1, j1);

                            if (k1 > 0) {
                                f3 -= (Block.n[k1].a(entity) + 0.3F) * f4;
                            }

                            if (f3 > 0.0F) {
                                hashset.add(new ChunkPosition(l, i1, j1));
                            }

                            d4 += d7 * (double) f4;
                            d5 += d8 * (double) f4;
                            d6 += d9 * (double) f4;
                        }
                    }
                }
            }
        }

        f1 *= 2.0F;
        i = MathHelper.b(d1 - (double) f1 - 1.0D);
        j = MathHelper.b(d1 + (double) f1 + 1.0D);
        k = MathHelper.b(d2 - (double) f1 - 1.0D);
        int l1 = MathHelper.b(d2 + (double) f1 + 1.0D);
        int i2 = MathHelper.b(d3 - (double) f1 - 1.0D);
        int j2 = MathHelper.b(d3 + (double) f1 + 1.0D);
        List list = world.b(entity, AxisAlignedBB.b((double) i, (double) k, (double) i2, (double) j, (double) l1, (double) j2));
        Vec3D vec3d = Vec3D.b(d1, d2, d3);

        double d11;
        double d12;
        double d13;

        for (int k2 = 0; k2 < list.size(); ++k2) {
            Entity entity1 = (Entity) list.get(k2);
            double d14 = entity1.e(d1, d2, d3) / (double) f1;

            if (d14 <= 1.0D) {
                d4 = entity1.l - d1;
                d5 = entity1.m - d2;
                d6 = entity1.n - d3;
                d12 = (double) MathHelper.a(d4 * d4 + d5 * d5 + d6 * d6);
                d4 /= d12;
                d5 /= d12;
                d6 /= d12;
                d11 = (double) world.a(vec3d, entity1.v);
                d13 = (1.0D - d14) * d11;
                entity1.a(entity, (int) ((d13 * d13 + d13) / 2.0D * 8.0D * (double) f1 + 1.0D));
                entity1.o += d4 * d13;
                entity1.p += d5 * d13;
                entity1.q += d6 * d13;
            }
        }

        f1 = f2;
        ArrayList arraylist = new ArrayList();

        arraylist.addAll(hashset);

        for (int l2 = arraylist.size() - 1; l2 >= 0; --l2) {
            ChunkPosition chunkposition = (ChunkPosition) arraylist.get(l2);
            int i3 = chunkposition.a;
            int j3 = chunkposition.b;
            int k3 = chunkposition.c;
            int l3 = world.a(i3, j3, k3);

            for (int i4 = 0; i4 < 1; ++i4) {
                d6 = (double) ((float) i3 + world.m.nextFloat());
                d12 = (double) ((float) j3 + world.m.nextFloat());
                d11 = (double) ((float) k3 + world.m.nextFloat());
                d13 = d6 - d1;
                double d15 = d12 - d2;
                double d16 = d11 - d3;
                double d17 = (double) MathHelper.a(d13 * d13 + d15 * d15 + d16 * d16);

                d13 /= d17;
                d15 /= d17;
                d16 /= d17;
                double d18 = 0.5D / (d17 / (double) f1 + 0.1D);

                d18 *= (double) (world.m.nextFloat() * world.m.nextFloat() + 0.3F);
                d13 *= d18;
                d15 *= d18;
                d16 *= d18;
                world.a("explode", (d6 + d1 * 1.0D) / 2.0D, (d12 + d2 * 1.0D) / 2.0D, (d11 + d3 * 1.0D) / 2.0D, d13, d15, d16);
                world.a("smoke", d6, d12, d11, d13, d15, d16);
            }

            if (l3 > 0) {
                Block.n[l3].a(world, i3, j3, k3, world.b(i3, j3, k3), 0.3F);
                world.d(i3, j3, k3, 0);
                Block.n[l3].c(world, i3, j3, k3);
            }
        }
    }
}
