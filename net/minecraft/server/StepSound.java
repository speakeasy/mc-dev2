package net.minecraft.server;

public class StepSound {

    public final String a;
    public final float b;
    public final float c;

    public StepSound(String s, float f1, float f2) {
        this.a = s;
        this.b = f1;
        this.c = f2;
    }

    public float a() {
        return this.b;
    }

    public float b() {
        return this.c;
    }

    public String c() {
        return "step." + this.a;
    }
}
