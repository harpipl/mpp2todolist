package pl.harpi.mpp2todolist.utils;

import net.sf.mpxj.Priority;

public class ConvertHelper {
    public static String fromPriority(int priority) {
        int p = priority / 100;

        if (p == 10) p = 0;

        return String.valueOf(p);
    }
}
