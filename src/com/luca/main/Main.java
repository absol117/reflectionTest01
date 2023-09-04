package com.luca.main;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String className = "java.lang.Object";

        if(args.length > 0) {
            className = args[0];
        }

        Class<?> objetClass = Class.forName(className);

        Method[] methods = objetClass.getMethods();

        for (int i = 0; i < methods.length; i++) {

            AnnotatedType annotatedReturnType = methods[i].getAnnotatedReturnType();        //restituisce il tipo di ritorno pi eventuali annotazioni (non ancora viste)
            System.out.println(annotatedReturnType);            // mi da il tipo di ritorno


            Class<?> declaringClass = methods[i].getDeclaringClass();
            System.out.println("AAAAAAAAAAA"    + " " + declaringClass);                 //fornisce la classe a cui appartiene il metodo specifico
                                                                                        // es.. equals == class java.lang.Object



            int modifiers = methods[i].getModifiers();
            System.out.println(modifiers);              //mi stampa dei numeri?? bho? a cosa corrispondono?? ai buchi di tua madre?

            Type[] genericExceptionTypes = methods[i].getGenericExceptionTypes();
            System.out.println(genericExceptionTypes);              // Stampa eccezioni, ma non ci ho capito na sega



            String name = methods[i].getName();
            System.out.println(name);                               // stampa il nome del metodo

            int parameterCount = methods[i].getParameterCount();
            System.out.println(parameterCount);                     // stampa il numero di parametri che prende in input il metodo

            Parameter[] parameters = methods[i].getParameters();
            int length =  parameters.length;
            for(int j = 0; j < length; j++) {
                String name1 = parameters[j].getType().getName();   // mi da il nome del tipo del parametro (es int, long, String, Obj..)

                String name2 = parameters[j].getName();             // mi da il nome del parametro (x, y, altezza, peso...)
                                                                    // per vedere i nomi reali, serve mettere un "--suka" al compileTime
                System.out.println(name1 + "\n" + name2);
            }



        }


    }
}