package data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dror Nir on 27/05/2017.
 */
public class IdFactory {
    private static IdFactory ourInstance = new IdFactory();
    private Map<Class<?>,Integer> map = new HashMap<>();
    public static IdFactory getInstance() {
        return ourInstance;
    }
    private IdFactory(){
    }

    public int getAndIncrement(Class<?> c){
        map.putIfAbsent(c, 0);
        int value = map.get(c);
        map.put(c,value+1);
        return value;
    }

}
