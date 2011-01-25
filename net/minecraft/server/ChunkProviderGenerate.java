package net.minecraft.server;

import java.util.Random;

public class ChunkProviderGenerate implements IChunkProvider {

    private Random j;
    private NoiseGeneratorOctaves k;
    private NoiseGeneratorOctaves l;
    private NoiseGeneratorOctaves m;
    private NoiseGeneratorOctaves n;
    private NoiseGeneratorOctaves o;
    public NoiseGeneratorOctaves a;
    public NoiseGeneratorOctaves b;
    public NoiseGeneratorOctaves c;
    private World p;
    private double[] q;
    private double[] r = new double[256];
    private double[] s = new double[256];
    private double[] t = new double[256];
    private MapGenBase u = new MapGenCaves();
    private BiomeBase[] v;
    double[] d;
    double[] e;
    double[] f;
    double[] g;
    double[] h;
    int[][] i = new int[32][32];
    private double[] w;

    public ChunkProviderGenerate(World world, long i) {
        this.p = world;
        this.j = new Random(i);
        this.k = new NoiseGeneratorOctaves(this.j, 16);
        this.l = new NoiseGeneratorOctaves(this.j, 16);
        this.m = new NoiseGeneratorOctaves(this.j, 8);
        this.n = new NoiseGeneratorOctaves(this.j, 4);
        this.o = new NoiseGeneratorOctaves(this.j, 4);
        this.a = new NoiseGeneratorOctaves(this.j, 10);
        this.b = new NoiseGeneratorOctaves(this.j, 16);
        this.c = new NoiseGeneratorOctaves(this.j, 8);
    }

    public void a(int i, int j, byte[] abyte, BiomeBase[] abiomebase, double[] adouble) {
        byte b1 = 4;
        byte b2 = 64;
        int k = b1 + 1;
        byte b3 = 17;
        int l = b1 + 1;

        this.q = this.a(this.q, i * b1, 0, j * b1, k, b3, l);

        for (int i1 = 0; i1 < b1; ++i1) {
            for (int j1 = 0; j1 < b1; ++j1) {
                for (int k1 = 0; k1 < 16; ++k1) {
                    double d1 = 0.125D;
                    double d2 = this.q[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
                    double d3 = this.q[((i1 + 0) * l + j1 + 1) * b3 + k1 + 0];
                    double d4 = this.q[((i1 + 1) * l + j1 + 0) * b3 + k1 + 0];
                    double d5 = this.q[((i1 + 1) * l + j1 + 1) * b3 + k1 + 0];
                    double d6 = (this.q[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d2) * d1;
                    double d7 = (this.q[((i1 + 0) * l + j1 + 1) * b3 + k1 + 1] - d3) * d1;
                    double d8 = (this.q[((i1 + 1) * l + j1 + 0) * b3 + k1 + 1] - d4) * d1;
                    double d9 = (this.q[((i1 + 1) * l + j1 + 1) * b3 + k1 + 1] - d5) * d1;

                    for (int l1 = 0; l1 < 8; ++l1) {
                        double d10 = 0.25D;
                        double d11 = d2;
                        double d12 = d3;
                        double d13 = (d4 - d2) * d10;
                        double d14 = (d5 - d3) * d10;

                        for (int i2 = 0; i2 < 4; ++i2) {
                            int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
                            short short1 = 128;
                            double d15 = 0.25D;
                            double d16 = d11;
                            double d17 = (d12 - d11) * d15;

                            for (int k2 = 0; k2 < 4; ++k2) {
                                double d18 = adouble[(i1 * 4 + i2) * 16 + j1 * 4 + k2];
                                int l2 = 0;

                                if (k1 * 8 + l1 < b2) {
                                    if (d18 < 0.5D && k1 * 8 + l1 >= b2 - 1) {
                                        l2 = Block.ICE.bi;
                                    } else {
                                        l2 = Block.STATIONARY_WATER.bi;
                                    }
                                }

                                if (d16 > 0.0D) {
                                    l2 = Block.STONE.bi;
                                }

                                abyte[j2] = (byte) l2;
                                j2 += short1;
                                d16 += d17;
                            }

                            d11 += d13;
                            d12 += d14;
                        }

                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }

    public void a(int i, int j, byte[] abyte, BiomeBase[] abiomebase) {
        byte b1 = 64;
        double d1 = 0.03125D;

        this.r = this.n.a(this.r, (double) (i * 16), (double) (j * 16), 0.0D, 16, 16, 1, d1, d1, 1.0D);
        this.s = this.n.a(this.s, (double) (j * 16), 109.0134D, (double) (i * 16), 16, 1, 16, d1, 1.0D, d1);
        this.t = this.o.a(this.t, (double) (i * 16), (double) (j * 16), 0.0D, 16, 16, 1, d1 * 2.0D, d1 * 2.0D, d1 * 2.0D);

        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                BiomeBase biomebase = abiomebase[k + l * 16];
                boolean flag = this.r[k + l * 16] + this.j.nextDouble() * 0.2D > 0.0D;
                boolean flag1 = this.s[k + l * 16] + this.j.nextDouble() * 0.2D > 3.0D;
                int i1 = (int) (this.t[k + l * 16] / 3.0D + 3.0D + this.j.nextDouble() * 0.25D);
                int j1 = -1;
                byte b2 = biomebase.o;
                byte b3 = biomebase.p;

                for (int k1 = 127; k1 >= 0; --k1) {
                    int l1 = (k * 16 + l) * 128 + k1;

                    if (k1 <= 0 + this.j.nextInt(5)) {
                        abyte[l1] = (byte) Block.BEDROCK.bi;
                    } else {
                        byte b4 = abyte[l1];

                        if (b4 == 0) {
                            j1 = -1;
                        } else if (b4 == Block.STONE.bi) {
                            if (j1 == -1) {
                                if (i1 <= 0) {
                                    b2 = 0;
                                    b3 = (byte) Block.STONE.bi;
                                } else if (k1 >= b1 - 4 && k1 <= b1 + 1) {
                                    b2 = biomebase.o;
                                    b3 = biomebase.p;
                                    if (flag1) {
                                        b2 = 0;
                                    }

                                    if (flag1) {
                                        b3 = (byte) Block.GRAVEL.bi;
                                    }

                                    if (flag) {
                                        b2 = (byte) Block.SAND.bi;
                                    }

                                    if (flag) {
                                        b3 = (byte) Block.SAND.bi;
                                    }
                                }

                                if (k1 < b1 && b2 == 0) {
                                    b2 = (byte) Block.STATIONARY_WATER.bi;
                                }

                                j1 = i1;
                                if (k1 >= b1 - 1) {
                                    abyte[l1] = b2;
                                } else {
                                    abyte[l1] = b3;
                                }
                            } else if (j1 > 0) {
                                --j1;
                                abyte[l1] = b3;
                            }
                        }
                    }
                }
            }
        }
    }

    public Chunk b(int i, int j) {
        this.j.setSeed((long) i * 341873128712L + (long) j * 132897987541L);
        byte[] abyte = new byte['\u8000'];
        Chunk chunk = new Chunk(this.p, abyte, i, j);

        this.v = this.p.a().a(this.v, i * 16, j * 16, 16, 16);
        double[] adouble = this.p.a().a;

        this.a(i, j, abyte, this.v, adouble);
        this.a(i, j, abyte, this.v);
        this.u.a(this, this.p, i, j, abyte);
        chunk.b();
        return chunk;
    }

    private double[] a(double[] adouble, int i, int j, int k, int l, int i1, int j1) {
        if (adouble == null) {
            adouble = new double[l * i1 * j1];
        }

        double d1 = 684.412D;
        double d2 = 684.412D;
        double[] adouble1 = this.p.a().a;
        double[] adouble2 = this.p.a().b;

        this.g = this.a.a(this.g, i, k, l, j1, 1.121D, 1.121D, 0.5D);
        this.h = this.b.a(this.h, i, k, l, j1, 200.0D, 200.0D, 0.5D);
        this.d = this.m.a(this.d, (double) i, (double) j, (double) k, l, i1, j1, d1 / 80.0D, d2 / 160.0D, d1 / 80.0D);
        this.e = this.k.a(this.e, (double) i, (double) j, (double) k, l, i1, j1, d1, d2, d1);
        this.f = this.l.a(this.f, (double) i, (double) j, (double) k, l, i1, j1, d1, d2, d1);
        int k1 = 0;
        int l1 = 0;
        int i2 = 16 / l;

        for (int j2 = 0; j2 < l; ++j2) {
            int k2 = j2 * i2 + i2 / 2;

            for (int l2 = 0; l2 < j1; ++l2) {
                int i3 = l2 * i2 + i2 / 2;
                double d3 = adouble1[k2 * 16 + i3];
                double d4 = adouble2[k2 * 16 + i3] * d3;
                double d5 = 1.0D - d4;

                d5 *= d5;
                d5 *= d5;
                d5 = 1.0D - d5;
                double d6 = (this.g[l1] + 256.0D) / 512.0D;

                d6 *= d5;
                if (d6 > 1.0D) {
                    d6 = 1.0D;
                }

                double d7 = this.h[l1] / 8000.0D;

                if (d7 < 0.0D) {
                    d7 = -d7 * 0.3D;
                }

                d7 = d7 * 3.0D - 2.0D;
                if (d7 < 0.0D) {
                    d7 /= 2.0D;
                    if (d7 < -1.0D) {
                        d7 = -1.0D;
                    }

                    d7 /= 1.4D;
                    d7 /= 2.0D;
                    d6 = 0.0D;
                } else {
                    if (d7 > 1.0D) {
                        d7 = 1.0D;
                    }

                    d7 /= 8.0D;
                }

                if (d6 < 0.0D) {
                    d6 = 0.0D;
                }

                d6 += 0.5D;
                d7 = d7 * (double) i1 / 16.0D;
                double d8 = (double) i1 / 2.0D + d7 * 4.0D;

                ++l1;

                for (int j3 = 0; j3 < i1; ++j3) {
                    double d9 = 0.0D;
                    double d10 = ((double) j3 - d8) * 12.0D / d6;

                    if (d10 < 0.0D) {
                        d10 *= 4.0D;
                    }

                    double d11 = this.e[k1] / 512.0D;
                    double d12 = this.f[k1] / 512.0D;
                    double d13 = (this.d[k1] / 10.0D + 1.0D) / 2.0D;

                    if (d13 < 0.0D) {
                        d9 = d11;
                    } else if (d13 > 1.0D) {
                        d9 = d12;
                    } else {
                        d9 = d11 + (d12 - d11) * d13;
                    }

                    d9 -= d10;
                    if (j3 > i1 - 4) {
                        double d14 = (double) ((float) (j3 - (i1 - 4)) / 3.0F);

                        d9 = d9 * (1.0D - d14) + -10.0D * d14;
                    }

                    adouble[k1] = d9;
                    ++k1;
                }
            }
        }

        return adouble;
    }

    public boolean a(int i, int j) {
        return true;
    }

    public void a(IChunkProvider ichunkprovider, int i, int j) {
        BlockSand.a = true;
        int k = i * 16;
        int l = j * 16;
        BiomeBase biomebase = this.p.a().a(k + 16, l + 16);

        this.j.setSeed(this.p.u);
        long i1 = this.j.nextLong() / 2L * 2L + 1L;
        long j1 = this.j.nextLong() / 2L * 2L + 1L;

        this.j.setSeed((long) i * i1 + (long) j * j1 ^ this.p.u);
        double d1 = 0.25D;
        int k1;
        int l1;
        int i2;

        if (this.j.nextInt(4) == 0) {
            k1 = k + this.j.nextInt(16) + 8;
            l1 = this.j.nextInt(128);
            i2 = l + this.j.nextInt(16) + 8;
            (new WorldGenLakes(Block.STATIONARY_WATER.bi)).a(this.p, this.j, k1, l1, i2);
        }

        if (this.j.nextInt(8) == 0) {
            k1 = k + this.j.nextInt(16) + 8;
            l1 = this.j.nextInt(this.j.nextInt(120) + 8);
            i2 = l + this.j.nextInt(16) + 8;
            if (l1 < 64 || this.j.nextInt(10) == 0) {
                (new WorldGenLakes(Block.STATIONARY_LAVA.bi)).a(this.p, this.j, k1, l1, i2);
            }
        }

        int j2;

        for (k1 = 0; k1 < 8; ++k1) {
            l1 = k + this.j.nextInt(16) + 8;
            i2 = this.j.nextInt(128);
            j2 = l + this.j.nextInt(16) + 8;
            (new WorldGenDungeons()).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 10; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(128);
            j2 = l + this.j.nextInt(16);
            (new WorldGenClay(32)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 20; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(128);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.DIRT.bi, 32)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 10; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(128);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.GRAVEL.bi, 32)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 20; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(128);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.COAL_ORE.bi, 16)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 20; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(64);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.IRON_ORE.bi, 8)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 2; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(32);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.GOLD_ORE.bi, 8)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 8; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(16);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.REDSTONE_ORE.bi, 7)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 1; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(16);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.DIAMOND_ORE.bi, 7)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 1; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(16) + this.j.nextInt(16);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.LAPIS_ORE.bi, 6)).a(this.p, this.j, l1, i2, j2);
        }

        d1 = 0.5D;
        k1 = (int) ((this.c.a((double) k * d1, (double) l * d1) / 8.0D + this.j.nextDouble() * 4.0D + 4.0D) / 3.0D);
        l1 = 0;
        if (this.j.nextInt(10) == 0) {
            ++l1;
        }

        if (biomebase == BiomeBase.d) {
            l1 += k1 + 5;
        }

        if (biomebase == BiomeBase.a) {
            l1 += k1 + 5;
        }

        if (biomebase == BiomeBase.c) {
            l1 += k1 + 2;
        }

        if (biomebase == BiomeBase.g) {
            l1 += k1 + 5;
        }

        if (biomebase == BiomeBase.h) {
            l1 -= 20;
        }

        if (biomebase == BiomeBase.k) {
            l1 -= 20;
        }

        if (biomebase == BiomeBase.i) {
            l1 -= 20;
        }

        int k2;

        for (i2 = 0; i2 < l1; ++i2) {
            j2 = k + this.j.nextInt(16) + 8;
            k2 = l + this.j.nextInt(16) + 8;
            WorldGenerator worldgenerator = biomebase.a(this.j);

            worldgenerator.a(1.0D, 1.0D, 1.0D);
            worldgenerator.a(this.p, this.j, j2, this.p.d(j2, k2), k2);
        }

        int l2;

        for (i2 = 0; i2 < 2; ++i2) {
            j2 = k + this.j.nextInt(16) + 8;
            k2 = this.j.nextInt(128);
            l2 = l + this.j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.YELLOW_FLOWER.bi)).a(this.p, this.j, j2, k2, l2);
        }

        if (this.j.nextInt(2) == 0) {
            i2 = k + this.j.nextInt(16) + 8;
            j2 = this.j.nextInt(128);
            k2 = l + this.j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.RED_ROSE.bi)).a(this.p, this.j, i2, j2, k2);
        }

        if (this.j.nextInt(4) == 0) {
            i2 = k + this.j.nextInt(16) + 8;
            j2 = this.j.nextInt(128);
            k2 = l + this.j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.BROWN_MUSHROOM.bi)).a(this.p, this.j, i2, j2, k2);
        }

        if (this.j.nextInt(8) == 0) {
            i2 = k + this.j.nextInt(16) + 8;
            j2 = this.j.nextInt(128);
            k2 = l + this.j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.RED_MUSHROOM.bi)).a(this.p, this.j, i2, j2, k2);
        }

        for (i2 = 0; i2 < 10; ++i2) {
            j2 = k + this.j.nextInt(16) + 8;
            k2 = this.j.nextInt(128);
            l2 = l + this.j.nextInt(16) + 8;
            (new WorldGenReed()).a(this.p, this.j, j2, k2, l2);
        }

        if (this.j.nextInt(32) == 0) {
            i2 = k + this.j.nextInt(16) + 8;
            j2 = this.j.nextInt(128);
            k2 = l + this.j.nextInt(16) + 8;
            (new WorldGenPumpkin()).a(this.p, this.j, i2, j2, k2);
        }

        i2 = 0;
        if (biomebase == BiomeBase.h) {
            i2 += 10;
        }

        int i3;

        for (j2 = 0; j2 < i2; ++j2) {
            k2 = k + this.j.nextInt(16) + 8;
            l2 = this.j.nextInt(128);
            i3 = l + this.j.nextInt(16) + 8;
            (new WorldGenCactus()).a(this.p, this.j, k2, l2, i3);
        }

        for (j2 = 0; j2 < 50; ++j2) {
            k2 = k + this.j.nextInt(16) + 8;
            l2 = this.j.nextInt(this.j.nextInt(120) + 8);
            i3 = l + this.j.nextInt(16) + 8;
            (new WorldGenLiquids(Block.WATER.bi)).a(this.p, this.j, k2, l2, i3);
        }

        for (j2 = 0; j2 < 20; ++j2) {
            k2 = k + this.j.nextInt(16) + 8;
            l2 = this.j.nextInt(this.j.nextInt(this.j.nextInt(112) + 8) + 8);
            i3 = l + this.j.nextInt(16) + 8;
            (new WorldGenLiquids(Block.LAVA.bi)).a(this.p, this.j, k2, l2, i3);
        }

        this.w = this.p.a().a(this.w, k + 8, l + 8, 16, 16);

        for (j2 = k + 8; j2 < k + 8 + 16; ++j2) {
            for (k2 = l + 8; k2 < l + 8 + 16; ++k2) {
                l2 = j2 - (k + 8);
                i3 = k2 - (l + 8);
                int j3 = this.p.e(j2, k2);
                double d2 = this.w[l2 * 16 + i3] - (double) (j3 - 64) / 64.0D * 0.3D;

                if (d2 < 0.5D && j3 > 0 && j3 < 128 && this.p.e(j2, j3, k2) && this.p.c(j2, j3 - 1, k2).c() && this.p.c(j2, j3 - 1, k2) != Material.r) {
                    this.p.e(j2, j3, k2, Block.SNOW.bi);
                }
            }
        }

        BlockSand.a = false;
    }

    public boolean a(boolean flag, IProgressUpdate iprogressupdate) {
        return true;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }
}
