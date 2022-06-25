/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:19 下午 2022/6/22
 **/


package org.example.bytedance;

import java.util.HashMap;
import java.util.Map;

public class Lemon {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                Integer integer = map.get(5);
                map.put(5,++integer);
            }
            if(bills[i]==10){
                if(map.get(5)!=0){
                    Integer integer = map.get(10);
                    Integer integer1 = map.get(5);
                    map.put(10,++integer);
                    map.put(5,--integer1);
                }else{
                    return false;
                }
            }
            if(bills[i]==20){
                if(map.get(10)!=0&&map.get(5)!=0){
                    Integer integer = map.get(5);
                    Integer integer1 = map.get(10);
                    Integer integer2 = map.get(20);
                    map.put(5,--integer);
                    map.put(10,--integer1);
                    map.put(20,++integer2);
                }else if(map.get(5)>=3){
                    int temp=map.get(5);
                    map.put(5,temp-3);
                }else{
                    return false;
                }

            }
        }
        return true;
    }
}
