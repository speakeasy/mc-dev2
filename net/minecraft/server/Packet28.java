package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet28 extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;

    public Packet28() {}

    public Packet28(int i, double d1, double d2, double d3) {
        this.a = i;
        double d4 = 0.9D;

        if (d1 < -d4) {
            d1 = -d4;
        }

        if (d2 < -d4) {
            d2 = -d4;
        }

        if (d3 < -d4) {
            d3 = -d4;
        }

        if (d1 > d4) {
            d1 = d4;
        }

        if (d2 > d4) {
            d2 = d4;
        }

        if (d3 > d4) {
            d3 = d4;
        }

        this.b = (int) (d1 * 32000.0D);
        this.c = (int) (d2 * 32000.0D);
        this.d = (int) (d3 * 32000.0D);
    }

    public void a(DataInputStream datainputstream) {
        this.a = datainputstream.readInt();
        this.b = datainputstream.readShort();
        this.c = datainputstream.readShort();
        this.d = datainputstream.readShort();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(this.a);
        dataoutputstream.writeShort(this.b);
        dataoutputstream.writeShort(this.c);
        dataoutputstream.writeShort(this.d);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 10;
    }
}
