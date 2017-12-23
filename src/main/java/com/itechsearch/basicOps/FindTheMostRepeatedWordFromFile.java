package com.itechsearch.basicOps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class FindTheMostRepeatedWordFromFile {
    public static void main(String[] args) throws IOException {
        FindTheMostRepeatedWordFromFile findTheMostRepeatedWordFromFile=new FindTheMostRepeatedWordFromFile();
        File file=findTheMostRepeatedWordFromFile.getFileDetails();
        if(file.exists()){
            String content = new String(Files.readAllBytes(file.toPath()));
            identifyRepeatedWords(content);
        }
    }

    private static void identifyRepeatedWords(String content) {
        Map<String,Integer> map=new HashMap<>();
        convertStringToMap(content, map);
        List<Map.Entry<String,Integer>>  descOrderList=   descOrderBasedOnOccurence((HashMap<String, Integer>) map);
        for(Map.Entry<String, Integer> entry: descOrderList ){
            System.out.println("String "+ entry.getKey() +" Count "+ entry.getValue());
        }
    }

    private static List<Map.Entry<String,Integer>> descOrderBasedOnOccurence(HashMap<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> firstEntry, Map.Entry<String, Integer> secondEntry) {
                    return secondEntry.getValue().compareTo(firstEntry.getValue());
            }
        });
        return entryList;
    }

    private static void convertStringToMap(String content, Map<String, Integer> map) {
        String[] stringArray=content.split("\\s+");
        for(String string: stringArray){
            string=string.toLowerCase();
            if(!map.containsKey(string)){
                map.put(string,1);
            }
            else {
                map.put(string,map.get(string)+1);
            }
        }
    }

    private File getFileDetails() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/test.txt").getFile());
        return file;
    }

}
