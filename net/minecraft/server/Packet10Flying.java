package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet10Flying extends Packet {

    public double a;
    public double b;
    public double c;
    public double d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public boolean i;

    public Packet10Flying() {}

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public void a(DataInputStream datainputstream) {
        this.g = datainputstream.read() != 0;
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.write(this.g ? 1 : 0);
    }

    public int a() {
        return 1;
    }
}
