package com.problems.d;

import java.util.*;

public class DesignTwitter {

    Map<Integer, Set<Integer>> follows;
    Map<Integer, List<Tweet>> tweets;
    int timestamp =0;

    static class Tweet{
        int tweetId;
        int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    /** Initialize your data structure here. */
    public DesignTwitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)){
            tweets.put(userId, new LinkedList<Tweet>());
        }
        tweets.get(userId).add(0, new Tweet(tweetId, timestamp++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<List<Tweet>> queue = new PriorityQueue<>((s, t) -> Integer.compare(t.get(0).time, s.get(0).time));
        if(follows.containsKey(userId)){
            Set<Integer> set = follows.get(userId);
            for(Integer id: set){
                if(tweets.containsKey(id)){
                    queue.add(tweets.get(id));
                }
            }
        }
        if(tweets.containsKey(userId)){
            queue.add(tweets.get(userId));
        }
        while(!queue.isEmpty() && res.size()<10){
            LinkedList<Tweet> list = (LinkedList)queue.poll();
            res.add(list.get(0).tweetId);
            list.removeFirst();
            if(!list.isEmpty()){
                queue.add(list);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId)){
            follows.put(followerId, new HashSet<>());
        }
        follows.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)){
            follows.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        DesignTwitter d = new DesignTwitter();
        d.postTweet(1,5);
        d.getNewsFeed(1);
        d.follow(1,2);
        d.postTweet(2,6);
        d.getNewsFeed(1);
        d.unfollow(1,2);
        d.getNewsFeed(1);
    }
}
