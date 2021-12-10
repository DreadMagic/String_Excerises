package com.company;

public class Main {
    public static String scroll(String m) {
        return (m.substring(1) + m.substring(0, 1));
    }

    public static String convertName(String m) {
        int f = m.indexOf(",") + 1;
        return m.substring(f).trim() + " " + m.substring(0, f-1).trim();
    }

    public static String negative(String m){
        m = m.replace("1","2");
        m = m.replace("0","1");
        m = m.replace("2","0");
        return m;
    }

    public static String convertDate(String m){
        String r = "";
        String cut = m.substring(m.indexOf("/")+1);
        r+=m.substring(m.indexOf("/")+1,m.lastIndexOf("/"));
        r+="-";
        r+=m.substring(0,m.indexOf("/"));
        r+="-";
        r+=m.substring(m.lastIndexOf("/")+1);
        return r;
    }

    public static String convertDate2(String m){
        String r = "";
        String cut = m.substring(m.indexOf("/")+1);

        String day = m.substring(m.indexOf("/")+1,m.lastIndexOf("/"));
        if(day.length() == 1) day = "0" + day;

        String month = m.substring(0,m.indexOf("/"));
        if(month.length() == 1) month = "0" + month;

        return day + "-" + month + "-" + m.substring(m.lastIndexOf("/")+1);
    }

    public static boolean startsWith(String s, String prefix){
        int n = prefix.length();
        if (n>s.length()) return false;
        return s.substring(0,n).equals(prefix);
    }

    public static boolean endsWith(String s, String suffix){
        int n = suffix.length();
        int l = s.length();
        if (n>l) return false;
        return s.substring(l-n).equals(suffix);
    }

    public static String removeTag(String s, String tag){
        int x = s.indexOf("<"+tag+">");
        int y = s.indexOf("</"+tag+">");
        if (s.contains("<"+tag+">") && s.substring(x).contains("</"+tag+">")) {
            s = s.substring(x+tag.length()+2, y);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(scroll("Hello World"));
        System.out.println(scroll("happy"));
        System.out.println(scroll("h"));

        System.out.println();

        System.out.println(convertName(" Reubenstein, Lori Renee "));
        System.out.println(convertName("Biden,Joe"));
        System.out.println(convertName("the Clown, Bozo"));

        System.out.println();

        System.out.println(negative("0010111001"));
        System.out.println(negative("11111111"));

        System.out.println();

        System.out.println("04/20/2014 becomes " + convertDate("04/20/2014"));
        System.out.println("04/20/2014 becomes " + convertDate2("04/20/2014"));
        System.out.println("4/20/2014 becomes " + convertDate2("4/20/2014"));
        System.out.println("04/2/2014 becomes " + convertDate2("04/2/2014"));
        System.out.println("4/2/2014 becomes " + convertDate2("4/2/2014"));

        System.out.println("\nstartsWith");
        System.out.println(startsWith("architecture", "arch"));
        System.out.println(startsWith("architecture", "a"));
        System.out.println(startsWith("arch", "architecture"));
        System.out.println(startsWith("architecture", "rch"));
        System.out.println(startsWith("architecture", "architecture"));

        System.out.println("\nendsWith");
        System.out.println(endsWith("astronomy", "nomy"));
        System.out.println(endsWith("astronomy", "y"));
        System.out.println(endsWith("astronomy", "nom"));
        System.out.println(endsWith("nomy", "astronomy"));
        System.out.println(endsWith("astronomy", "astronomy"));

        System.out.println("\nremoveTag");
        System.out.println(removeTag("<b>Hello World</b>", "b"));
        System.out.println(removeTag("<b>Hello World</b>", "head"));
        System.out.println(removeTag("Hello World</b>", "b"));
        System.out.println(removeTag("<b>Hello World", "b"));
        System.out.println(removeTag("</img>Hello World<img>", "img"));
        System.out.println(removeTag("Happy Birthday <b>Hello World</b>", "b"));
        System.out.println(removeTag("<title>Hello World</title> Happy Birthday",
                "title"));
        System.out.println(removeTag("Happy <b>Hello World</b> Birthday", "b"));
    }
}

//ello WorldH
//appyh
//h
//
//Lori Renee Reubenstein
//Joe Biden
//Bozo the Clown
//
//1101000110
//00000000
//
//04/20/2014 becomes 20-04-2014
//04/20/2014 becomes 20-04-2014
//4/20/2014 becomes 20-04-2014
//04/2/2014 becomes 02-04-2014
//4/2/2014 becomes 02-04-2014
//
//startsWith
//true
//true
//false
//false
//true
//
//endsWith
//true
//true
//false
//false
//true
//
//removeTag
//Hello World
//<b>Hello World</b>
//Hello World</b>
//<b>Hello World
//</img>Hello World<img>
//Hello World
//Hello World
//Hello World
//
//Process finished with exit code 0