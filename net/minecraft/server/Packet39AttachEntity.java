package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet39AttachEntity extends Packet {

    public int a;
    public int b;

    public Packet39AttachEntity() {}

    public Packet39AttachEntity(Entity entity, Entity entity1) {
        this.a = entity.g;
        this.b = entity1 != null ? entity1.g : -1;
    }

    public int a() {
        return 8;
    }

    public void a(DataInputStream datainputstream) {
        this.a = datainputstream.readInt();
        this.b = datainputstream.readInt();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(this.a);
        dataoutputstream.writeInt(this.b);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }
}
