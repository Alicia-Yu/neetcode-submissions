class TimeMap {
    private Map<String, TreeMap<Integer, String>> m;

    public TimeMap() {
        m = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if (!m.containsKey(key)) {
            m.put(key, new TreeMap<>());
        }
        m.get(key).put(timestamp, value); 
    }
    
    public String get(String key, int timestamp) {
        if (!m.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> timestamps = m.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
        if (entry == null) {
            return "";
        } else {
            return entry.getValue(); 
        }
    }
}
