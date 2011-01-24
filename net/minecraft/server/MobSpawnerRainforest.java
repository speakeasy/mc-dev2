package net.minecraft.server;

import java.util.Random;

public class MobSpawnerRainforest extends MobSpawnerBase {

    public MobSpawnerRainforest() {}

    public WorldGenerator a(Random random) {
        return (WorldGenerator) (random.nextInt(3) == 0 ? new WorldGenBigTree() : new WorldGenTrees());
    }
}
