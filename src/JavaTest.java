import java.io.Serializable;
import java.nio.CharBuffer;
import java.util.*;

public class JavaTest {


    public static void main(String[] args) {

        System.out.println("null instanceof Object: ");
        System.out.println(null instanceof Object);

        System.out.println(" \"\" instanceof Object: ");
        System.out.println("" instanceof Object);

        Map m = new TreeMap();
        Map newMap = new Map() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Object get(Object key) {
                return null;
            }

            @Override
            public Object put(Object key, Object value) {
                return null;
            }

            @Override
            public Object remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set keySet() {
                return null;
            }

            @Override
            public Collection values() {
                return null;
            }

            @Override
            public Set<Entry> entrySet() {
                return null;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
        String s = "";
        System.out.println(m instanceof HashMap);
        //Compiler errror
        //System.out.println(s instanceof HashMap);
        //
        Cloneable c = new Cloneable() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

        System.out.println("cloneable");
        System.out.println(c instanceof Serializable);

        System.out.println("map");
        System.out.println(m instanceof Serializable);

        System.out.println("newMap");
        System.out.println(newMap instanceof Serializable);

        List<CharBuffer> l = new ArrayList<CharBuffer>();

    }
}
