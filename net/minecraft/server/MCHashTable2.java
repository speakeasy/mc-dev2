package net.minecraft.server;

public class MCHashTable2 {

    private transient HashEntry2[] a = new HashEntry2[16];
    private transient int b;
    private int c = 12;
    private final float d = 0.75F;
    private transient volatile int e;

    public MCHashTable2() {}

    private static int e(long i) {
        return a((int) (i ^ i >>> 32));
    }

    private static int a(int i) {
        i ^= i >>> 20 ^ i >>> 12;
        return i ^ i >>> 7 ^ i >>> 4;
    }

    private static int a(int i, int j) {
        return i & j - 1;
    }

    public Object a(long i) {
        int j = e(i);

        for (HashEntry2 hashentry2 = this.a[a(j, this.a.length)]; hashentry2 != null; hashentry2 = hashentry2.c) {
            if (hashentry2.a == i) {
                return hashentry2.b;
            }
        }

        return null;
    }

    public void a(long i, Object object) {
        int j = e(i);
        int k = a(j, this.a.length);

        for (HashEntry2 hashentry2 = this.a[k]; hashentry2 != null; hashentry2 = hashentry2.c) {
            if (hashentry2.a == i) {
                hashentry2.b = object;
            }
        }

        ++this.e;
        this.a(j, i, object, k);
    }

    private void b(int i) {
        HashEntry2[] ahashentry2 = this.a;
        int j = ahashentry2.length;

        if (j == 1073741824) {
            this.c = Integer.MAX_VALUE;
        } else {
            HashEntry2[] ahashentry21 = new HashEntry2[i];

            this.a(ahashentry21);
            this.a = ahashentry21;
            this.c = (int) ((float) i * this.d);
        }
    }

    private void a(HashEntry2[] ahashentry2) {
        HashEntry2[] ahashentry21 = this.a;
        int i = ahashentry2.length;

        for (int j = 0; j < ahashentry21.length; ++j) {
            HashEntry2 hashentry2 = ahashentry21[j];

            if (hashentry2 != null) {
                ahashentry21[j] = null;

                HashEntry2 hashentry21;

                do {
                    hashentry21 = hashentry2.c;
                    int k = a(hashentry2.d, i);

                    hashentry2.c = ahashentry2[k];
                    ahashentry2[k] = hashentry2;
                    hashentry2 = hashentry21;
                } while (hashentry21 != null);
            }
        }
    }

    public Object b(long i) {
        HashEntry2 hashentry2 = this.c(i);

        return hashentry2 == null ? null : hashentry2.b;
    }

    final HashEntry2 c(long i) {
        int j = e(i);
        int k = a(j, this.a.length);
        HashEntry2 hashentry2 = this.a[k];

        HashEntry2 hashentry21;
        HashEntry2 hashentry22;

        for (hashentry21 = hashentry2; hashentry21 != null; hashentry21 = hashentry22) {
            hashentry22 = hashentry21.c;
            if (hashentry21.a == i) {
                ++this.e;
                --this.b;
                if (hashentry2 == hashentry21) {
                    this.a[k] = hashentry22;
                } else {
                    hashentry2.c = hashentry22;
                }

                return hashentry21;
            }

            hashentry2 = hashentry21;
        }

        return hashentry21;
    }

    private void a(int i, long j, Object object, int k) {
        HashEntry2 hashentry2 = this.a[k];

        this.a[k] = new HashEntry2(i, j, object, hashentry2);
        if (this.b++ >= this.c) {
            this.b(2 * this.a.length);
        }
    }

    static int d(long i) {
        return e(i);
    }
}
