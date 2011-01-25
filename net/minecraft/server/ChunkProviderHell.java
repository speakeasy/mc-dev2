package net.minecraft.server;

import java.util.Random;

public class ChunkProviderHell implements IChunkProvider {

    private Random h;
    private NoiseGeneratorOctaves i;
    private NoiseGeneratorOctaves j;
    private NoiseGeneratorOctaves k;
    private NoiseGeneratorOctaves l;
    private NoiseGeneratorOctaves m;
    public NoiseGeneratorOctaves a;
    public NoiseGeneratorOctaves b;
    private World n;
    private double[] o;
    private double[] p = new double[256];
    private double[] q = new double[256];
    private double[] r = new double[256];
    private MapGenBase s = new MapGenCavesHell();
    double[] c;
    double[] d;
    double[] e;
    double[] f;
    double[] g;

    public ChunkProviderHell(World world, long i) {
        this.n = world;
        this.h = new Random(i);
        this.i = new NoiseGeneratorOctaves(this.h, 16);
        this.j = new NoiseGeneratorOctaves(this.h, 16);
        this.k = new NoiseGeneratorOctaves(this.h, 8);
        this.l = new NoiseGeneratorOctaves(this.h, 4);
        this.m = new NoiseGeneratorOctaves(this.h, 4);
        this.a = new NoiseGeneratorOctaves(this.h, 10);
        this.b = new NoiseGeneratorOctaves(this.h, 16);
    }

    public void a(int i, int j, byte[] abyte) {
        byte b1 = 4;
        byte b2 = 32;
        int k = b1 + 1;
        byte b3 = 17;
        int l = b1 + 1;

        this.o = this.a(this.o, i * b1, 0, j * b1, k, b3, l);

        for (int i1 = 0; i1 < b1; ++i1) {
            for (int j1 = 0; j1 < b1; ++j1) {
                for (int k1 = 0; k1 < 16; ++k1) {
                    double d1 = 0.125D;
                    double d2 = this.o[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
                    double d3 = this.o[((i1 + 0) * l + j1 + 1) * b3 + k1 + 0];
                    double d4 = this.o[((i1 + 1) * l + j1 + 0) * b3 + k1 + 0];
                    double d5 = this.o[((i1 + 1) * l + j1 + 1) * b3 + k1 + 0];
                    double d6 = (this.o[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d2) * d1;
                    double d7 = (this.o[((i1 + 0) * l + j1 + 1) * b3 + k1 + 1] - d3) * d1;
                    double d8 = (this.o[((i1 + 1) * l + j1 + 0) * b3 + k1 + 1] - d4) * d1;
                    double d9 = (this.o[((i1 + 1) * l + j1 + 1) * b3 + k1 + 1] - d5) * d1;

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
                                    l2 = Block.STATIONARY_LAVA.bi;
                                }

                                if (d16 > 0.0D) {
                                    l2 = Block.NETHERRACK.bi;
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

        this.p = this.l.a(this.p, (double) (i * 16), (double) (j * 16), 0.0D, 16, 16, 1, d1, d1, 1.0D);
        this.q = this.l.a(this.q, (double) (j * 16), 109.0134D, (double) (i * 16), 16, 1, 16, d1, 1.0D, d1);
        this.r = this.m.a(this.r, (double) (i * 16), (double) (j * 16), 0.0D, 16, 16, 1, d1 * 2.0D, d1 * 2.0D, d1 * 2.0D);

        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                boolean flag = this.p[k + l * 16] + this.h.nextDouble() * 0.2D > 0.0D;
                boolean flag1 = this.q[k + l * 16] + this.h.nextDouble() * 0.2D > 0.0D;
                int i1 = (int) (this.r[k + l * 16] / 3.0D + 3.0D + this.h.nextDouble() * 0.25D);
                int j1 = -1;
                byte b2 = (byte) Block.NETHERRACK.bi;
                byte b3 = (byte) Block.NETHERRACK.bi;

                for (int k1 = 127; k1 >= 0; --k1) {
                    int l1 = (k * 16 + l) * 128 + k1;

                    if (k1 >= 127 - this.h.nextInt(5)) {
                        abyte[l1] = (byte) Block.BEDROCK.bi;
                    } else if (k1 <= 0 + this.h.nextInt(5)) {
                        abyte[l1] = (byte) Block.BEDROCK.bi;
                    } else {
                        byte b4 = abyte[l1];

                        if (b4 == 0) {
                            j1 = -1;
                        } else if (b4 == Block.NETHERRACK.bi) {
                            if (j1 == -1) {
                                if (i1 <= 0) {
                                    b2 = 0;
                                    b3 = (byte) Block.NETHERRACK.bi;
                                } else if (k1 >= b1 - 4 && k1 <= b1 + 1) {
                                    b2 = (byte) Block.NETHERRACK.bi;
                                    b3 = (byte) Block.NETHERRACK.bi;
                                    if (flag1) {
                                        b2 = (byte) Block.GRAVEL.bi;
                                    }

                                    if (flag1) {
                                        b3 = (byte) Block.NETHERRACK.bi;
                                    }

                                    if (flag) {
                                        b2 = (byte) Block.SOUL_SAND.bi;
                                    }

                                    if (flag) {
                                        b3 = (byte) Block.SOUL_SAND.bi;
                                    }
                                }

                                if (k1 < b1 && b2 == 0) {
                                    b2 = (byte) Block.STATIONARY_LAVA.bi;
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
        this.h.setSeed((long) i * 341873128712L + (long) j * 132897987541L);
        byte[] abyte = new byte['\u8000'];

        this.a(i, j, abyte);
        this.b(i, j, abyte);
        this.s.a(this, this.n, i, j, abyte);
        Chunk chunk = new Chunk(this.n, abyte, i, j);

        return chunk;
    }

    private double[] a(double[] adouble, int i, int j, int k, int l, int i1, int j1) {
        if (adouble == null) {
            adouble = new double[l * i1 * j1];
        }

        double d1 = 684.412D;
        double d2 = 2053.236D;

        this.f = this.a.a(this.f, (double) i, (double) j, (double) k, l, 1, j1, 1.0D, 0.0D, 1.0D);
        this.g = this.b.a(this.g, (double) i, (double) j, (double) k, l, 1, j1, 100.0D, 0.0D, 100.0D);
        this.c = this.k.a(this.c, (double) i, (double) j, (double) k, l, i1, j1, d1 / 80.0D, d2 / 60.0D, d1 / 80.0D);
        this.d = this.i.a(this.d, (double) i, (double) j, (double) k, l, i1, j1, d1, d2, d1);
        this.e = this.j.a(this.e, (double) i, (double) j, (double) k, l, i1, j1, d1, d2, d1);
        int k1 = 0;
        int l1 = 0;
        double[] adouble1 = new double[i1];

        int i2;

        for (i2 = 0; i2 < i1; ++i2) {
            adouble1[i2] = Math.cos((double) i2 * 3.141592653589793D * 6.0D / (double) i1) * 2.0D;
            double d3 = (double) i2;

            if (i2 > i1 / 2) {
                d3 = (double) (i1 - 1 - i2);
            }

            if (d3 < 4.0D) {
                d3 = 4.0D - d3;
                adouble1[i2] -= d3 * d3 * d3 * 10.0D;
            }
        }

        for (i2 = 0; i2 < l; ++i2) {
            for (int j2 = 0; j2 < j1; ++j2) {
                double d4 = (this.f[l1] + 256.0D) / 512.0D;

                if (d4 > 1.0D) {
                    d4 = 1.0D;
                }

                double d5 = 0.0D;
                double d6 = this.g[l1] / 8000.0D;

                if (d6 < 0.0D) {
                    d6 = -d6;
                }

                d6 = d6 * 3.0D - 3.0D;
                if (d6 < 0.0D) {
                    d6 /= 2.0D;
                    if (d6 < -1.0D) {
                        d6 = -1.0D;
                    }

                    d6 /= 1.4D;
                    d6 /= 2.0D;
                    d4 = 0.0D;
                } else {
                    if (d6 > 1.0D) {
                        d6 = 1.0D;
                    }

                    d6 /= 6.0D;
                }

                d4 += 0.5D;
                d6 = d6 * (double) i1 / 16.0D;
                ++l1;

                for (int k2 = 0; k2 < i1; ++k2) {
                    double d7 = 0.0D;
                    double d8 = adouble1[k2];
                    double d9 = this.d[k1] / 512.0D;
                    double d10 = this.e[k1] / 512.0D;
                    double d11 = (this.c[k1] / 10.0D + 1.0D) / 2.0D;

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

                    if ((double) k2 < d5) {
                        d12 = (d5 - (double) k2) / 4.0D;
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

        int i1;
        int j1;
        int k1;
        int l1;

        for (i1 = 0; i1 < 8; ++i1) {
            j1 = k + this.h.nextInt(16) + 8;
            k1 = this.h.nextInt(120) + 4;
            l1 = l + this.h.nextInt(16) + 8;
            (new WorldGenHellLava(Block.LAVA.bi)).a(this.n, this.h, j1, k1, l1);
        }

        i1 = this.h.nextInt(this.h.nextInt(10) + 1) + 1;

        int i2;

        for (j1 = 0; j1 < i1; ++j1) {
            k1 = k + this.h.nextInt(16) + 8;
            l1 = this.h.nextInt(120) + 4;
            i2 = l + this.h.nextInt(16) + 8;
            (new WorldGenFire()).a(this.n, this.h, k1, l1, i2);
        }

        i1 = this.h.nextInt(this.h.nextInt(10) + 1);

        for (j1 = 0; j1 < i1; ++j1) {
            k1 = k + this.h.nextInt(16) + 8;
            l1 = this.h.nextInt(120) + 4;
            i2 = l + this.h.nextInt(16) + 8;
            (new WorldGenLightStone1()).a(this.n, this.h, k1, l1, i2);
        }

        for (j1 = 0; j1 < 10; ++j1) {
            k1 = k + this.h.nextInt(16) + 8;
            l1 = this.h.nextInt(128);
            i2 = l + this.h.nextInt(16) + 8;
            (new WorldGenLightStone2()).a(this.n, this.h, k1, l1, i2);
        }

        if (this.h.nextInt(1) == 0) {
            j1 = k + this.h.nextInt(16) + 8;
            k1 = this.h.nextInt(128);
            l1 = l + this.h.nextInt(16) + 8;
            (new WorldGenFlowers(Block.BROWN_MUSHROOM.bi)).a(this.n, this.h, j1, k1, l1);
        }

        if (this.h.nextInt(1) == 0) {
            j1 = k + this.h.nextInt(16) + 8;
            k1 = this.h.nextInt(128);
            l1 = l + this.h.nextInt(16) + 8;
            (new WorldGenFlowers(Block.RED_MUSHROOM.bi)).a(this.n, this.h, j1, k1, l1);
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
