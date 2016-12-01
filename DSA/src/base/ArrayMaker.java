package base;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 由泛型创建数组
 * Created by Ellery on 2016/12/1.
 */

public class ArrayMaker<T> {

    private Class<T> type;

    public ArrayMaker(Class<T> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    T[] createArray(int size) {
        return (T[]) Array.newInstance(type, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> am = new ArrayMaker<>(String.class);
        System.out.println(Arrays.asList(am.createArray(10)));
        String[] a = am.createArray(10);
    }

}

