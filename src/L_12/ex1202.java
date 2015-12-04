package L_12;

import L_12.ex02.IPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


abstract class PluginManager {
    public static IPlugin load(String name) throws Exception {
        Class<?> c = Class.forName(name);
        return (IPlugin) c.newInstance();
    }
}

public class ex1202 {
    public static void main(String[] args) throws Exception {
        File proxyList = new File("src/L_12/Static.d/reflection/plugins/ex02");
        List<IPlugin> plgs = new ArrayList<>();
        for (String f : proxyList.list())
            try {
                plgs.add(PluginManager.load("L_12.ex02." + f.substring(0, f.lastIndexOf('.'))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        for (IPlugin plg : plgs)
            System.out.println(plg.doSomething());
    }
}