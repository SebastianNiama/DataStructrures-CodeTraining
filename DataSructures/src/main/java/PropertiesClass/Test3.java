/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PropertiesClass;

import java.util.*;
import java.io.*;

public class Test3 {

    public static void main(String[] args) throws Exception {

        Properties p = new Properties();
        
        p.setProperty("name", "Sonoo Jaiswal");
        p.setProperty("email", "sonoojaiswal@javatpoint.com");

        p.store(new FileWriter("C:\\Users\\henry\\OneDrive - Universidad Técnica Particular de Loja - UTPL\\Documentos\\Java\\EjerciciosNetBeansJava\\DataSructures\\src\\main\\java\\PropertiesClass\\creado.txt"), "Javatpoint Properties Example");

    }
}
