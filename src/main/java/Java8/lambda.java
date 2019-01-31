package Java8;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author: haojie
 * @Description:
 * @Date: Created in 下午3:51 17-8-31
 */
public class lambda {
    public static void main(String[] args){
        File f = new File(".");
        File[] files = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.endsWith(".txt")){
                    return true;
                }
                return  false;
            }
        });
        for(File a:files){
            System.out.println(a.toString());
        }
        FileFilter filter = pathname -> pathname.getName().endsWith(".txt");
        FilenameFilter filenameFilter = (dir,name) -> name.endsWith(".txt");
        Comparator<File> comparator = (F1, F2) ->F1.getName().compareTo(f.getName());
        Runnable task = () -> System.out.println("hello world");
    }

    public static <E> List<E> filter(List<E> list, Predicate<E> pred){
        List<E> relist = new ArrayList<>();
        for(E e : list){
            if(pred.test(e))
                relist.add(e);
        }
        return relist;
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> mapper){
        List<R> retList = new ArrayList<>(list.size());
        for(T e : list){
            retList.add(mapper.apply(e));
        }
        return retList;
    }
}
