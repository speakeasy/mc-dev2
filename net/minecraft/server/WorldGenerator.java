package net.minecraft.server;

import java.util.Random;

public abstract class WorldGenerator {

    public WorldGenerator() {}

    public abstract boolean a(World world, Random random, int i, int j, int k);

    public void a(double d1, double d2, double d3) {}
}
