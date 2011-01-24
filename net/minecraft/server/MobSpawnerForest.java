package net.minecraft.server;

import java.util.Random;

public class MobSpawnerForest extends MobSpawnerBase {

    public MobSpawnerForest() {}

    public WorldGenerator a(Random random) {
        return (WorldGenerator) (random.nextInt(5) == 0 ? new WorldGenForest() : (random.nextInt(3) == 0 ? new WorldGenBigTree() : new WorldGenTrees()));
    }
}
