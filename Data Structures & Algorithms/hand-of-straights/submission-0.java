class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) count.merge(card, 1, Integer::sum);
        while(!count.isEmpty())
        {
            int first = count.firstKey();
            for(int i=first;i<first+groupSize;i++)
            {
                if(!count.containsKey(i)) return false;
                count.merge(i, -1, Integer::sum);
                if (count.get(i) == 0) count.remove(i);
            }
        }
        return true;
    }
}
