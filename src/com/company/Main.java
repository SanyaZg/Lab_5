package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String str=new String();
        Scanner scn= new Scanner(System.in);
        System.out.println("Из заданной строки исключить все символы, входящие в нее более одного раза.");
        System.out.print("Введите строку:");
        str=scn.next();


        //string

        char[] arrayDelete=new char[10];
        int t=0;
        boolean f2=false;
        System.out.println("Символы, подлежащие удалению:");
        for (int i = 0; i < str.length(); i++) {

            for (int j = i+1; j < str.length(); j++) {

                if(str.charAt(i)==str.charAt(j))
                {
                    f2=false;
                    for (int k = 0; k <arrayDelete.length ; k++) {
                        if(str.charAt(i)==arrayDelete[k] )
                            f2=true;
                    }
                    if(f2==false) {
                        arrayDelete[t] = str.charAt(i);
                        t++;
                        break;
                    }
                }
            }
        }
        System.out.println();

        for (int j = 0; j <arrayDelete.length ; j++) {
            System.out.print(arrayDelete[j]+" ");
        }
        //чтобы уйти от неявного использования стринг буффер, выполним задачу, не изменяя строки
        char[] strChar=str.toCharArray();
        char [] temp=new char[str.length()];
        boolean flag=false;
        for (int i = 0; i <strChar.length ; i++) {
            flag=false;
            for (int j = 0; j <arrayDelete.length ; j++) {
                if(strChar[i]==arrayDelete[j])
                {flag=true;break;}
            }
            if(flag==false)
                temp[i]=strChar[i];

        }
        System.out.println();
        System.out.println("Результат 1:");
        for (int i = 0; i <temp.length ; i++) {
            System.out.print(temp[i]);
        }


        //stringBuffer

        System.out.println("\nТеперь удалим повторяющиеся символы в самой строке с помощью метода replace,который работает с StringBuffer.");
        for (int i = 0; i <arrayDelete.length ; i++) {
            str=str.replace(arrayDelete[i],'\0');
        }

        System.out.println("Результат 2:\n"+str);

    }
}

