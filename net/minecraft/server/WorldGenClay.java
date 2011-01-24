package net.minecraft.server;

import java.util.Random;

public class WorldGenClay extends WorldGenerator {

    private int a;
    private int b;

    public WorldGenClay(int i) {
        this.a = Block.aX.bc;
        this.b = i;
    }

    public boolean a(World world, Random random, int i, int j, int k) {
        if (world.c(i, j, k) != Material.f) {
            return false;
        } else {
            float f1 = random.nextFloat() * 3.1415927F;
            double d1 = (double) ((float) (i + 8) + MathHelper.a(f1) * (float) this.b / 8.0F);
            double d2 = (double) ((float) (i + 8) - MathHelper.a(f1) * (float) this.b / 8.0F);
            double d3 = (double) ((float) (k + 8) + MathHelper.b(f1) * (float) this.b / 8.0F);
            double d4 = (double) ((float) (k + 8) - MathHelper.b(f1) * (float) this.b / 8.0F);
            double d5 = (double) (j + random.nextInt(3) + 2);
            double d6 = (double) (j + random.nextInt(3) + 2);

            for (int l = 0; l <= this.b; ++l) {
                double d7 = d1 + (d2 - d1) * (double) l / (double) this.b;
                double d8 = d5 + (d6 - d5) * (double) l / (double) this.b;
                double d9 = d3 + (d4 - d3) * (double) l / (double) this.b;
                double d10 = random.nextDouble() * (double) this.b / 16.0D;
                double d11 = (double) (MathHelper.a((float) l * 3.1415927F / (float) this.b) + 1.0F) * d10 + 1.0D;
                double d12 = (double) (MathHelper.a((float) l * 3.1415927F / (float) this.b) + 1.0F) * d10 + 1.0D;

                for (int i1 = (int) (d7 - d11 / 2.0D); i1 <= (int) (d7 + d11 / 2.0D); ++i1) {
                    for (int j1 = (int) (d8 - d12 / 2.0D); j1 <= (int) (d8 + d12 / 2.0D); ++j1) {
                        for (int k1 = (int) (d9 - d11 / 2.0D); k1 <= (int) (d9 + d11 / 2.0D); ++k1) {
                            double d13 = ((double) i1 + 0.5D - d7) / (d11 / 2.0D);
                            double d14 = ((double) j1 + 0.5D - d8) / (d12 / 2.0D);
                            double d15 = ((double) k1 + 0.5D - d9) / (d11 / 2.0D);

                            if (d13 * d13 + d14 * d14 + d15 * d15 < 1.0D) {
                                int l1 = world.a(i1, j1, k1);

                                if (l1 == Block.F.bc) {
                                    world.a(i1, j1, k1, this.a);
                                }
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
