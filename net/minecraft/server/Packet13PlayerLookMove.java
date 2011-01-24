package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet13PlayerLookMove extends Packet10Flying {

    public Packet13PlayerLookMove() {
        this.i = true;
        this.h = true;
    }

    public Packet13PlayerLookMove(double d1, double d2, double d3, double d4, float f1, float f2, boolean flag) {
        this.a = d1;
        this.b = d2;
        this.d = d3;
        this.c = d4;
        this.e = f1;
        this.f = f2;
        this.g = flag;
        this.i = true;
        this.h = true;
    }

    public void a(DataInputStream datainputstream) {
        this.a = datainputstream.readDouble();
        this.b = datainputstream.readDouble();
        this.d = datainputstream.readDouble();
        this.c = datainputstream.readDouble();
        this.e = datainputstream.readFloat();
        this.f = datainputstream.readFloat();
        super.a(datainputstream);
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeDouble(this.a);
        dataoutputstream.writeDouble(this.b);
        dataoutputstream.writeDouble(this.d);
        dataoutputstream.writeDouble(this.c);
        dataoutputstream.writeFloat(this.e);
        dataoutputstream.writeFloat(this.f);
        super.a(dataoutputstream);
    }

    public int a() {
        return 41;
    }
}
