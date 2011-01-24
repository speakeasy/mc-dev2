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
    double[] d;
    double[] e;
    double[] f;
    double[] g;
    double[] h;
    int[][] i = new int[32][32];

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

    public void a(int i, int j, byte[] abyte) {
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
                                int l2 = 0;

                                if (k1 * 8 + l1 < b2) {
                                    if (this.p.d && k1 * 8 + l1 >= b2 - 1) {
                                        l2 = Block.aU.bc;
                                    } else {
                                        l2 = Block.C.bc;
                                    }
                                }

                                if (d16 > 0.0D) {
                                    l2 = Block.u.bc;
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

    public void b(int i, int j, byte[] abyte) {
        byte b1 = 64;
        double d1 = 0.03125D;

        this.r = this.n.a(this.r, (double) (i * 16), (double) (j * 16), 0.0D, 16, 16, 1, d1, d1, 1.0D);
        this.s = this.n.a(this.s, (double) (j * 16), 109.0134D, (double) (i * 16), 16, 1, 16, d1, 1.0D, d1);
        this.t = this.o.a(this.t, (double) (i * 16), (double) (j * 16), 0.0D, 16, 16, 1, d1 * 2.0D, d1 * 2.0D, d1 * 2.0D);

        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                boolean flag = this.r[k + l * 16] + this.j.nextDouble() * 0.2D > 0.0D;
                boolean flag1 = this.s[k + l * 16] + this.j.nextDouble() * 0.2D > 3.0D;
                int i1 = (int) (this.t[k + l * 16] / 3.0D + 3.0D + this.j.nextDouble() * 0.25D);
                int j1 = -1;
                byte b2 = (byte) Block.v.bc;
                byte b3 = (byte) Block.w.bc;

                for (int k1 = 127; k1 >= 0; --k1) {
                    int l1 = (k * 16 + l) * 128 + k1;

                    if (k1 <= 0 + this.j.nextInt(6) - 1) {
                        abyte[l1] = (byte) Block.A.bc;
                    } else {
                        byte b4 = abyte[l1];

                        if (b4 == 0) {
                            j1 = -1;
                        } else if (b4 == Block.u.bc) {
                            if (j1 == -1) {
                                if (i1 <= 0) {
                                    b2 = 0;
                                    b3 = (byte) Block.u.bc;
                                } else if (k1 >= b1 - 4 && k1 <= b1 + 1) {
                                    b2 = (byte) Block.v.bc;
                                    b3 = (byte) Block.w.bc;
                                    if (flag1) {
                                        b2 = 0;
                                    }

                                    if (flag1) {
                                        b3 = (byte) Block.G.bc;
                                    }

                                    if (flag) {
                                        b2 = (byte) Block.F.bc;
                                    }

                                    if (flag) {
                                        b3 = (byte) Block.F.bc;
                                    }
                                }

                                if (k1 < b1 && b2 == 0) {
                                    b2 = (byte) Block.C.bc;
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

        this.a(i, j, abyte);
        this.b(i, j, abyte);
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

        this.g = this.a.a(this.g, (double) i, (double) j, (double) k, l, 1, j1, 1.0D, 0.0D, 1.0D);
        this.h = this.b.a(this.h, (double) i, (double) j, (double) k, l, 1, j1, 100.0D, 0.0D, 100.0D);
        this.d = this.m.a(this.d, (double) i, (double) j, (double) k, l, i1, j1, d1 / 80.0D, d2 / 160.0D, d1 / 80.0D);
        this.e = this.k.a(this.e, (double) i, (double) j, (double) k, l, i1, j1, d1, d2, d1);
        this.f = this.l.a(this.f, (double) i, (double) j, (double) k, l, i1, j1, d1, d2, d1);
        int k1 = 0;
        int l1 = 0;

        for (int i2 = 0; i2 < l; ++i2) {
            for (int j2 = 0; j2 < j1; ++j2) {
                double d3 = (this.g[l1] + 256.0D) / 512.0D;

                if (d3 > 1.0D) {
                    d3 = 1.0D;
                }

                double d4 = 0.0D;
                double d5 = this.h[l1] / 8000.0D;

                if (d5 < 0.0D) {
                    d5 = -d5;
                }

                d5 = d5 * 3.0D - 3.0D;
                if (d5 < 0.0D) {
                    d5 /= 2.0D;
                    if (d5 < -1.0D) {
                        d5 = -1.0D;
                    }

                    d5 /= 1.4D;
                    d5 /= 2.0D;
                    d3 = 0.0D;
                } else {
                    if (d5 > 1.0D) {
                        d5 = 1.0D;
                    }

                    d5 /= 6.0D;
                }

                d3 += 0.5D;
                d5 = d5 * (double) i1 / 16.0D;
                double d6 = (double) i1 / 2.0D + d5 * 4.0D;

                ++l1;

                for (int k2 = 0; k2 < i1; ++k2) {
                    double d7 = 0.0D;
                    double d8 = ((double) k2 - d6) * 12.0D / d3;

                    if (d8 < 0.0D) {
                        d8 *= 4.0D;
                    }

                    double d9 = this.e[k1] / 512.0D;
                    double d10 = this.f[k1] / 512.0D;
                    double d11 = (this.d[k1] / 10.0D + 1.0D) / 2.0D;

                    if (d11 < 0.0D) {
                        d7 = d9;
                    } else if (d11 > 1.0D) {
                        d7 = d10;
                    } else {
                        d7 = d9 + (d10 - d9) * d11;
                    }

                    d7 -= d8;
                    double d12;

                    if (k2 > i1 - 4) {
                        d12 = (double) ((float) (k2 - (i1 - 4)) / 3.0F);
                        d7 = d7 * (1.0D - d12) + -10.0D * d12;
                    }

                    if ((double) k2 < d4) {
                        d12 = (d4 - (double) k2) / 4.0D;
                        if (d12 < 0.0D) {
                            d12 = 0.0D;
                        }

                        if (d12 > 1.0D) {
                            d12 = 1.0D;
                        }

                        d7 = d7 * (1.0D - d12) + -10.0D * d12;
                    }

                    adouble[k1] = d7;
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

        this.j.setSeed(this.p.t);
        long i1 = this.j.nextLong() / 2L * 2L + 1L;
        long j1 = this.j.nextLong() / 2L * 2L + 1L;

        this.j.setSeed((long) i * i1 + (long) j * j1 ^ this.p.t);
        double d1 = 0.25D;

        int k1;
        int l1;
        int i2;
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
            (new WorldGenMinable(Block.w.bc, 32)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 10; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(128);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.G.bc, 32)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 20; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(128);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.J.bc, 16)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 20; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(64);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.I.bc, 8)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 2; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(32);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.H.bc, 8)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 8; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(16);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.aO.bc, 7)).a(this.p, this.j, l1, i2, j2);
        }

        for (k1 = 0; k1 < 1; ++k1) {
            l1 = k + this.j.nextInt(16);
            i2 = this.j.nextInt(16);
            j2 = l + this.j.nextInt(16);
            (new WorldGenMinable(Block.ax.bc, 7)).a(this.p, this.j, l1, i2, j2);
        }

        d1 = 0.5D;
        k1 = (int) ((this.c.a((double) k * d1, (double) l * d1) / 8.0D + this.j.nextDouble() * 4.0D + 4.0D) / 3.0D);
        if (k1 < 0) {
            k1 = 0;
        }

        if (this.j.nextInt(10) == 0) {
            ++k1;
        }

        Object object = new WorldGenTrees();

        if (this.j.nextInt(10) == 0) {
            object = new WorldGenBigTree();
        }

        int k2;

        for (i2 = 0; i2 < k1; ++i2) {
            j2 = k + this.j.nextInt(16) + 8;
            k2 = l + this.j.nextInt(16) + 8;
            ((WorldGenerator) object).a(1.0D, 1.0D, 1.0D);
            ((WorldGenerator) object).a(this.p, this.j, j2, this.p.c(j2, k2), k2);
        }

        int l2;

        for (i2 = 0; i2 < 2; ++i2) {
            j2 = k + this.j.nextInt(16) + 8;
            k2 = this.j.nextInt(128);
            l2 = l + this.j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.ae.bc)).a(this.p, this.j, j2, k2, l2);
        }

        if (this.j.nextInt(2) == 0) {
            i2 = k + this.j.nextInt(16) + 8;
            j2 = this.j.nextInt(128);
            k2 = l + this.j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.af.bc)).a(this.p, this.j, i2, j2, k2);
        }

        if (this.j.nextInt(4) == 0) {
            i2 = k + this.j.nextInt(16) + 8;
            j2 = this.j.nextInt(128);
            k2 = l + this.j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.ag.bc)).a(this.p, this.j, i2, j2, k2);
        }

        if (this.j.nextInt(8) == 0) {
            i2 = k + this.j.nextInt(16) + 8;
            j2 = this.j.nextInt(128);
            k2 = l + this.j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.ah.bc)).a(this.p, this.j, i2, j2, k2);
        }

        for (i2 = 0; i2 < 10; ++i2) {
            j2 = k + this.j.nextInt(16) + 8;
            k2 = this.j.nextInt(128);
            l2 = l + this.j.nextInt(16) + 8;
            (new WorldGenReed()).a(this.p, this.j, j2, k2, l2);
        }

        for (i2 = 0; i2 < 1; ++i2) {
            j2 = k + this.j.nextInt(16) + 8;
            k2 = this.j.nextInt(128);
            l2 = l + this.j.nextInt(16) + 8;
            (new WorldGenCactus()).a(this.p, this.j, j2, k2, l2);
        }

        for (i2 = 0; i2 < 50; ++i2) {
            j2 = k + this.j.nextInt(16) + 8;
            k2 = this.j.nextInt(this.j.nextInt(120) + 8);
            l2 = l + this.j.nextInt(16) + 8;
            (new WorldGenLiquids(Block.B.bc)).a(this.p, this.j, j2, k2, l2);
        }

        for (i2 = 0; i2 < 20; ++i2) {
            j2 = k + this.j.nextInt(16) + 8;
            k2 = this.j.nextInt(this.j.nextInt(this.j.nextInt(112) + 8) + 8);
            l2 = l + this.j.nextInt(16) + 8;
            (new WorldGenLiquids(Block.D.bc)).a(this.p, this.j, j2, k2, l2);
        }

        for (i2 = k + 8 + 0; i2 < k + 8 + 16; ++i2) {
            for (j2 = l + 8 + 0; j2 < l + 8 + 16; ++j2) {
                k2 = this.p.d(i2, j2);
                if (this.p.d && k2 > 0 && k2 < 128 && this.p.a(i2, k2, j2) == 0 && this.p.c(i2, k2 - 1, j2).c() && this.p.c(i2, k2 - 1, j2) != Material.r) {
                    this.p.d(i2, k2, j2, Block.aT.bc);
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
