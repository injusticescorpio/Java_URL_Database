package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String, Integer> counter= new HashMap<String, Integer>();
        HashMap<String, String> short_key = new HashMap<String, String>();
        List <String> li=new ArrayList<>();
        System.out.println("=====================================================JAVA URL DATABASE=================================================================");
        System.out.println("To start Enter RUN");
        String intro=sc.nextLine();
        if (intro.toLowerCase().equals("run"))
        {
            while (true)
            {
                System.out.println("Enter command like\n 1. storeurl <url>(Seperated by a whitespace)\n 2.get <url>(Seperated by a whitespace)\n 3.count <url>(Seperated by a whitespace)\n 4.list\n 5.Table_format\n 6.exit\n");
                String main_input = sc.nextLine().toLowerCase();
                if (main_input.toLowerCase().equals("exit"))
                {
                    break;
                }
                if (main_input.toLowerCase().equals("list"))
                {
                    if (li.isEmpty())
                    {
                        System.out.println("URL Table Empty");
                        continue;
                    }
                    counter.clear();
                    for(String i:li)
                    {
                        if(!counter.containsKey(i))
                        {
                            counter.put(i,1);
                        }
                        else
                        {
                            counter.put(i, counter.get(i)+ 1);
                        }
                    }

                    System.out.println("The details are\n "+counter);
                    continue;

                }
                if(main_input.toLowerCase().equals("table_format"))
                {
                    if (li.isEmpty())
                    {
                        System.out.println("URL Table Empty");
                        continue;
                    }
                    if (counter.isEmpty())
                    {
                        System.out.println("First store some url");
                        continue;
                    }
                    Set<String> hSet = new HashSet<String>();
                    for (String x : li)
                        hSet.add(x);

                    System.out.println("Index   ||     hostname     ||      shortkey  ||    count");
                    int k=1;
                    for(String i:hSet)
                    {
                        System.out.println(k+"            "+i+"            "+short_key.get(i)+"            "+counter.get(i));
                        System.out.println("==================================================================");
                        k++;
                    }
                    continue;
                }
                String[] subinput1 = main_input.trim().split(" ");
                switch (subinput1[0])
                {
                    case "storeurl":
                        li.add(subinput1[1]);
                        counter.clear();
                        for(String i:li)
                        {
                            if(!counter.containsKey(i))
                            {
                                counter.put(i,1);
                            }
                            else
                            {
                                counter.put(i, counter.get(i)+ 1);
                            }
                        }
                        for(String i:li)
                        {
                            if(!short_key.containsKey(i))
                            {
                                short_key.put(i,i.trim().split("\\.")[0]);
                            }
                        }
                        break;
                    case "get":
                        if (short_key.get(subinput1[1])==null)
                        {
                            System.out.println("No value exists in table");
                            continue;
                        }
                        System.out.println("Short Key is "+short_key.get(subinput1[1]));
                        break;
                    case "count":
                        System.out.println(subinput1[1]+" has occured "+counter.get(subinput1[1])+" times");
                        break;

                    default:
                        System.out.println("Wrong choice");
                }

            }
        }
        else
        {
        System.exit(0);
        }
    }
}
