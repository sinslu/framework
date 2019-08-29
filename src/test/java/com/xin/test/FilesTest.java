package com.xin.test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by xsl on 2019/8/27.
 */
public class FilesTest {
    public static void main(String[] args) {
/*         try(Stream<Path> entries= Files.walk(Paths.get("target/classes"))){
            entries.forEach(p-> System.out.println(p.toAbsolutePath()));
         }catch (Exception e){

         }*/
        Path base=Paths.get(System.getProperty("user.dir"));
        Path path=Paths.get("classes");
        System.out.println(base.resolve(path));
    }
}
