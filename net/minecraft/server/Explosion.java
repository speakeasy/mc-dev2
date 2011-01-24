package net.minecraft.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Explosion {

    public boolean a = false;
    private Random h = new Random();
    private World i;
    public double b;
    public double c;
    public double d;
    public Entity e;
    public float f;
    public Set g = new HashSet();

    public Explosion(World world, Entity entity, double d1, double d2, double d3, float f1) {
        this.i = world;
        this.e = entity;
        this.f = f1;
        this.b = d1;
        this.c = d2;
        this.d = d3;
    }

    public void a() {
        float f1 = this.f;
        byte b1 = 16;

        int i;
        int j;
        int k;
        double d1;
        double d2;
        double d3;

        for (i = 0; i < b1; ++i) {
            for (j = 0; j < b1; ++j) {
                for (k = 0; k < b1; ++k) {
                    if (i == 0 || i == b1 - 1 || j == 0 || j == b1 - 1 || k == 0 || k == b1 - 1) {
                        double d4 = (double) ((float) i / ((float) b1 - 1.0F) * 2.0F - 1.0F);
                        double d5 = (double) ((float) j / ((float) b1 - 1.0F) * 2.0F - 1.0F);
                        double d6 = (double) ((float) k / ((float) b1 - 1.0F) * 2.0F - 1.0F);
                        double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);

                        d4 /= d7;
                        d5 /= d7;
                        d6 /= d7;
                        float f2 = this.f * (0.7F + this.i.l.nextFloat() * 0.6F);

                        d1 = this.b;
                        d2 = this.c;
                        d3 = this.d;

                        for (float f3 = 0.3F; f2 > 0.0F; f2 -= f3 * 0.75F) {
                            int l = MathHelper.b(d1);
                            int i1 = MathHelper.b(d2);
                            int j1 = MathHelper.b(d3);
                            int k1 = this.i.a(l, i1, j1);

                            if (k1 > 0) {
                                f2 -= (Block.m[k1].a(this.e) + 0.3F) * f3;
                            }

                            if (f2 > 0.0F) {
                                this.g.add(new ChunkPosition(l, i1, j1));
                            }

                            d1 += d4 * (double) f3;
                            d2 += d5 * (double) f3;
                            d3 += d6 * (double) f3;
                        }
                    }
                }
            }
        }

        this.f *= 2.0F;
        i = MathHelper.b(this.b - (double) this.f - 1.0D);
        j = MathHelper.b(this.b + (double) this.f + 1.0D);
        k = MathHelper.b(this.c - (double) this.f - 1.0D);
        int l1 = MathHelper.b(this.c + (double) this.f + 1.0D);
        int i2 = MathHelper.b(this.d - (double) this.f - 1.0D);
        int j2 = MathHelper.b(this.d + (double) this.f + 1.0D);
        List list = this.i.b(this.e, AxisAlignedBB.b((double) i, (double) k, (double) i2, (double) j, (double) l1, (double) j2));
        Vec3D vec3d = Vec3D.b(this.b, this.c, this.d);

        for (int k2 = 0; k2 < list.size(); ++k2) {
            Entity entity = (Entity) list.get(k2);
            double d8 = entity.e(this.b, this.c, this.d) / (double) this.f;

            if (d8 <= 1.0D) {
                d1 = entity.p - this.b;
                d2 = entity.q - this.c;
                d3 = entity.r - this.d;
                double d9 = (double) MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);

                d1 /= d9;
                d2 /= d9;
                d3 /= d9;
                double d10 = (double) this.i.a(vec3d, entity.z);
                double d11 = (1.0D - d8) * d10;

                entity.a(this.e, (int) ((d11 * d11 + d11) / 2.0D * 8.0D * (double) this.f + 1.0D));
                entity.s += d1 * d11;
                entity.t += d2 * d11;
                entity.u += d3 * d11;
            }
        }

        this.f = f1;
        ArrayList arraylist = new ArrayList();

        arraylist.addAll(this.g);
        if (this.a) {
            for (int l2 = arraylist.size() - 1; l2 >= 0; --l2) {
                ChunkPosition chunkposition = (ChunkPosition) arraylist.get(l2);
                int i3 = chunkposition.a;
                int j3 = chunkposition.b;
                int k3 = chunkposition.c;
                int l3 = this.i.a(i3, j3, k3);
                int i4 = this.i.a(i3, j3 - 1, k3);

                if (l3 == 0 && Block.o[i4] && this.h.nextInt(3) == 0) {
                    this.i.d(i3, j3, k3, Block.ar.bh);
                }
            }
        }
    }

    public void b() {
        this.i.a(this.b, this.c, this.d, "random.explode", 4.0F, (1.0F + (this.i.l.nextFloat() - this.i.l.nextFloat()) * 0.2F) * 0.7F);
        ArrayList arraylist = new ArrayList();

        arraylist.addAll(this.g);

        for (int i = arraylist.size() - 1; i >= 0; --i) {
            ChunkPosition chunkposition = (ChunkPosition) arraylist.get(i);
            int j = chunkposition.a;
            int k = chunkposition.b;
            int l = chunkposition.c;
            int i1 = this.i.a(j, k, l);

            for (int j1 = 0; j1 < 1; ++j1) {
                double d1 = (double) ((float) j + this.i.l.nextFloat());
                double d2 = (double) ((float) k + this.i.l.nextFloat());
                double d3 = (double) ((float) l + this.i.l.nextFloat());
                double d4 = d1 - this.b;
                double d5 = d2 - this.c;
                double d6 = d3 - this.d;
                double d7 = (double) MathHelper.a(d4 * d4 + d5 * d5 + d6 * d6);

                d4 /= d7;
                d5 /= d7;
                d6 /= d7;
                double d8 = 0.5D / (d7 / (double) this.f + 0.1D);

                d8 *= (double) (this.i.l.nextFloat() * this.i.l.nextFloat() + 0.3F);
                d4 *= d8;
                d5 *= d8;
                d6 *= d8;
                this.i.a("explode", (d1 + this.b * 1.0D) / 2.0D, (d2 + this.c * 1.0D) / 2.0D, (d3 + this.d * 1.0D) / 2.0D, d4, d5, d6);
                this.i.a("smoke", d1, d2, d3, d4, d5, d6);
            }

            if (i1 > 0) {
                Block.m[i1].a(this.i, j, k, l, this.i.b(j, k, l), 0.3F);
                this.i.d(j, k, l, 0);
                Block.m[i1].c(this.i, j, k, l);
            }
        }
    }
}
