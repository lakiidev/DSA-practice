class TimeMap {
    Map<String, List<Integer>> timestamps;
    Map<String, List<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!timestamps.containsKey(key))
        {
            timestamps.put(key,new ArrayList<>());
            values.put(key,new ArrayList<>());
        }
        timestamps.get(key).add(timestamp);
        values.get(key).add(value);
    }

    public String get(String key, int timestamp) {
        if(!timestamps.containsKey(key)) return "";
        List<Integer> times = timestamps.get(key);
        List<String> vals = values.get(key);

        int low=0;
        int high = times.size()-1;
        String result="";
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(times.get(mid)<=timestamp)
            {
                result = vals.get(mid);
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;
    }
}
