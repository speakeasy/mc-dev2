package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet101 extends Packet {

    public int a;

    public Packet101() {}

    public Packet101(int i) {
        this.a = i;
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public void a(DataInputStream datainputstream) {
        this.a = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeByte(this.a);
    }

    public int a() {
        return 1;
    }
}
