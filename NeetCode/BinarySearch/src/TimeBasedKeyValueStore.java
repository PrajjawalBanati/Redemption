import java.util.*;

public class TimeBasedKeyValueStore {
    static class Pair <K,V>{
        K x;
        V y;
        public Pair(K x, V y)
        {
            this.x = x;
            this.y = y;
        }

        public K getKey() {
            return x;
        }

        public V getValue() {
            return y;
        }
    }
    class TimeMap {
        HashMap<String, List<Pair<String,Integer>>> hashMap;
        public TimeMap() {
            this.hashMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            this.hashMap.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair<>(value,timestamp));
        }

        public String get(String key, int timestamp) {
            String res="";
            if(this.hashMap.isEmpty())
            {
               return res;
            }
            else if(!this.hashMap.containsKey(key))
            {
                return res;
            }
            else
            {
                List<Pair<String,Integer>> pairList = this.hashMap.get(key);
                int left = 0, right = pairList.size()-1;
                while(left <= right)
                {
                    int mid = left + (right - left)/2;
                    if(pairList.get(mid).getValue() <= timestamp)
                    {
                        res = pairList.get(mid).getKey();
                        left = mid+1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
            }
            return res;
        }
    }
}
