class Twitter {

    private int timestamp = 0;
    private Map<Integer, List<int[]>> tweets;
    private Map<Integer, Set<Integer>> following;
    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
             tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // [timestamp, tweetId, userId, index]

        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }

        for (int user : users) {
            List<int[]> userTweets = tweets.get(user);
            if (userTweets != null && !userTweets.isEmpty()) {
                int lastIndex = userTweets.size() - 1;
                int[] latest = userTweets.get(lastIndex);
                maxHeap.offer(new int[]{latest[0], latest[1], user, lastIndex});
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] curr = maxHeap.poll();
            result.add(curr[1]); // tweetId

            int user = curr[2];
            int index = curr[3] - 1;
            if (index >= 0) {
                int[] next = tweets.get(user).get(index);
                maxHeap.offer(new int[]{next[0], next[1], user, index});
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
