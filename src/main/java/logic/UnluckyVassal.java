package logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnluckyVassal {
    public void printReportForKing(List<String> pollResults) {

        Map<String, String> child1 = new HashMap<>();
        Map<String, String> child2 = new HashMap<>();

        pollResults.forEach(k -> {
            if(k.contains(":")){
                String [] arr = k.split(":");
                for (int i=0; i<arr.length-1; i++){
                    child1.put(arr[i], arr[i+1]);
                }
            }
        });

        child1.forEach((key, value) -> {
            if (value.contains(",")) {
                String[] arr = value.split(",");
                for (String s : arr) {
                    child2.put(s, key);
                }
            }
        });

        pollResults.stream().sorted().forEach(k->{
            String substring = k.contains(":")?k.substring(0, k.indexOf(":")):null;
            if(child1.keySet().contains(substring)){
                if(child2.containsValue(substring)){
                    System.out.println(substring);
                    child2.entrySet().stream()
                          .sorted(Map.Entry.comparingByKey()).forEach(x -> {
                        if(x.getValue().equals(substring)){
                            System.out.println(x.getKey());
                        }
                    });
                }else{
                    System.out.println(substring);
                    System.out.println(child1.get(substring));
                }
            }else{
                System.out.println(k);
            }
        });

    }
}
