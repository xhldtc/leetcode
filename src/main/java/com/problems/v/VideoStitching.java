package com.problems.v;

import java.util.Arrays;

public class VideoStitching {

    public int videoStitching(int[][] clips, int T) {
        if(T ==0){
            return 0;
        }
        Arrays.sort(clips, (c1, c2) -> c1[0]!=c2[0] ? Integer.compare(c1[0], c2[0]) : Integer.compare(c1[1], c2[1]));
        if(clips[0][0]!=0){
            return -1;
        }
        int[] dp = new int[T+1];
        int limit =  clips.length+1;
        Arrays.fill(dp, limit);
        dp[0] = 0;
        for(int[] clip : clips){
            if(clip[0] <= T && dp[clip[0]]!=limit){
                for(int i=clip[0];i<=Math.min(T,clip[1]);i++){
                    dp[i] = Math.min(dp[i], dp[clip[0]] +1);
                }
            }
        }
        return dp[T] == limit ? -1 : dp[T];
    }
}
