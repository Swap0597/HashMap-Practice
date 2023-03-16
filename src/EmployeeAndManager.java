import java.util.*;

public class EmployeeAndManager {
    public int helper(Map<String, ArrayList<String>> mngr, Map<String, Integer> ans, String ceo){
        if(mngr.containsKey(ceo) == false){
            ans.put(ceo, 0);
            return 1;
        }
        int count = 0;
        for(String key : mngr.get(ceo)){
            count += helper(mngr, ans, key);
        }
        ans.put(ceo, count);
        return count+1;
    }
    public void EmpUnderManager(Map<String, String> emp)
    {
        // 1. manager, employee And find ceo
        Map<String, ArrayList<String>> mngr = new HashMap<>();
        String ceo = "";
        for( String key : emp.keySet()){
            String manager = emp.get(key);
            if(manager.equals(key)){
                ceo = manager;
            }
            else {
                if(mngr.containsKey(manager)){
                    ArrayList<String> list = mngr.get(manager);
                    list.add(key);
                    mngr.put(manager, list);
                }
                else{
                    ArrayList<String> list = new ArrayList<>();
                    list.add(key);
                    mngr.put(manager, list);
                }
            }
        }
        Map<String, Integer> ans = new TreeMap<>();
        helper(mngr, ans, ceo);
        for(String key : ans.keySet()){
            System.out.println(key +" " + ans.get(key));
        }
    }
}

