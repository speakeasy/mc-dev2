package net.minecraft.server;

import java.util.Random;

public class MobSpawnerTaiga extends MobSpawnerBase {

    public MobSpawnerTaiga() {}

    public WorldGenerator a(Random random) {
        return (WorldGenerator) (random.nextInt(3) == 0 ? new WorldGenTaiga1() : new WorldGenTaiga2());
    }
}
