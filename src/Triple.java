public class Triple<T1, T2, T3> {

    private String first, second, third;
    public static int count = 0;

    public Triple(String s1, String s2, String s3) {
        this.first = s1;
        this.second = s2;
        this.third = s3;
    }

    public Triple(Triple<T1,T2,T3> t) {
        this.first = t.first;
        this.second = t.second;
        this.third = t.third;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Triple))
            return false;
        Triple<T1, T2, T3> t = (Triple<T1, T2, T3>) o;
        boolean same = first.equals(t.first) && second.equals(t.second) && third.equals(t.third);
        if (!same) {
            System.out.println(this + "(" + hashCode() + ") " + t + "(" + t.hashCode() + ")");
            count++;
        }
        return same;
    }

    public int hashCode() {
        int h1 = first.hashCode();
        int h2 = second.hashCode();
        int h3 = third.hashCode();
        return ((h1 + h2 + h3) * (h1 + h2 + h3 + 1)) / 2;
    }

    public String toString() {
        return "<" + first + "," + second + "," + third + ">";
    }
}