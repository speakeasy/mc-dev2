package net.minecraft.server;

class HashEntry2 {

    final long a;
    Object b;
    HashEntry2 c;
    final int d;

    HashEntry2(int i, long j, Object object, HashEntry2 hashentry2) {
        this.b = object;
        this.c = hashentry2;
        this.a = j;
        this.d = i;
    }

    public final long a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof HashEntry2)) {
            return false;
        } else {
            HashEntry2 hashentry2 = (HashEntry2) object;
            Long olong = Long.valueOf(this.a());
            Long olong1 = Long.valueOf(hashentry2.a());

            if (olong == olong1 || olong != null && olong.equals(olong1)) {
                Object object1 = this.b();
                Object object2 = hashentry2.b();

                if (object1 == object2 || object1 != null && object1.equals(object2)) {
                    return true;
                }
            }

            return false;
        }
    }

    public final int hashCode() {
        return MCHashTable2.d(this.a);
    }

    public final String toString() {
        return this.a() + "=" + this.b();
    }
}
