package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet33RelEntityMoveLook extends Packet30Entity {

    public Packet33RelEntityMoveLook() {
        this.g = true;
    }

    public Packet33RelEntityMoveLook(int i, byte b1, byte b2, byte b3, byte b4, byte b5) {
        super(i);
        this.b = b1;
        this.c = b2;
        this.d = b3;
        this.e = b4;
        this.f = b5;
        this.g = true;
    }

    public void a(DataInputStream datainputstream) {
        super.a(datainputstream);
        this.b = datainputstream.readByte();
        this.c = datainputstream.readByte();
        this.d = datainputstream.readByte();
        this.e = datainputstream.readByte();
        this.f = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        super.a(dataoutputstream);
        dataoutputstream.writeByte(this.b);
        dataoutputstream.writeByte(this.c);
        dataoutputstream.writeByte(this.d);
        dataoutputstream.writeByte(this.e);
        dataoutputstream.writeByte(this.f);
    }

    public int a() {
        return 9;
    }
}
