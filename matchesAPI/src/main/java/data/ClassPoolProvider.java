package data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dror Nir on 27/05/2017.
 */
public class ClassPoolProvider {
    private static ClassPoolProvider ourInstance = new ClassPoolProvider();
    private static Map<Class<?>, Map<String,Object>> classes = new HashMap<>();

    public static ClassPoolProvider getInstance() {
        return ourInstance;
    }

    private ClassPoolProvider() {
    }

    Map<String,Object> get(Class<?> c){
        classes.putIfAbsent(c,new HashMap<>());
        return classes.get(c);
    }
}
