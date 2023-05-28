import quicksort.QuickSort;

import java.util.*;
import java.util.stream.Stream;


public class IteratorExample {


    public static void main(String[] args) {
        List<String> myList = Arrays.asList("Foo", "Bar", "Baz", "Hello", "World");
        var mymyList = myList.stream().filter(name -> name.length() > 3);
        Stream<?> mymyList2 = myList.stream().filter(name -> name.length() < 4);

        System.out.println(mymyList.toList());
        System.out.println(mymyList2.toList());


//        Iterator<String> iterator = myList.iterator();
//
//        while (iterator.hasNext()) {
//            String element = iterator.next();
//            System.out.println(element);
//        }

    }






//    public static <T> Iterable<T> nCopies(T value, int count) {
//        if (count < 0)
//            throw new IllegalArgumentException("Negative count " + count);
//        return () -> new Iterator<>() {
//            int rest = count;
//
//            @Override
//            public boolean hasNext() {
//                return rest > 0;
//            }
//
//            @Override
//            public T next() {
//                if (rest-- == 0)
//                    throw new NoSuchElementException();
//                return value;
//            }
//        };
//    }
}

