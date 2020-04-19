package com.project.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Launcher {
    /** Workaround Method to Load resources
     *
     * @param name
     * @return
     * @throws IOException
     */
    public static InputStream loadResourceAnywhereAsStream(String name) throws IOException {
        InputStream is = Launcher.class.getClassLoader().getResourceAsStream(name);
        if (is != null) return is;

        Path p = Files.walk(Paths.get("./"))
                .filter(path -> path.toString().endsWith(name))
                .findFirst().orElseThrow(() -> new FileNotFoundException(name));
        return new FileInputStream(p.toString());
    }

    /** Workaround Method to Load resources
     *
     * @param name
     * @return
     * @throws IOException
     */
    public static URL loadResourceAnywhere(String name) throws IOException {
        URL url = Launcher.class.getClassLoader().getResource(name);
        if (url != null) return url;

        Path p = Files.walk(Paths.get("./"))
                .filter(path -> path.toString().endsWith(name))
                .findFirst().orElseThrow(() -> new FileNotFoundException(name));
        return p.toFile().toURI().toURL();
    }

    public static void main(String[] args) throws IOException {
        // this method is null - except when I build a Jar Then the Classloader locates the Resources properly
        System.out.println(Launcher.class.getClassLoader().getResource("test.txt"));
        // this method is a workaround -
        System.out.println(loadResourceAnywhere("test.txt"));
        // The App I actually want to launch
        //  V V V V V V V V V
        // Application.launch(App.class,args);
    }
}
