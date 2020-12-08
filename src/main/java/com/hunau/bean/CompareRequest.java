package com.hunau.bean;

/**
 * @author Wking
 * @create 2020-12-07 9:18
 */
public class CompareRequest extends com.bimface.api.bean.request.modelCompare.CompareRequest {
    Long previousId;
    Long followingId;

    public CompareRequest() {
    }

    public CompareRequest(Long previousId, Long followingId) {
        this.previousId = previousId;
        this.followingId = followingId;
    }

    @Override
    public Long getPreviousId() {
        return previousId;
    }

    @Override
    public void setPreviousId(Long previousId) {
        this.previousId = previousId;
    }

    @Override
    public Long getFollowingId() {
        return followingId;
    }

    @Override
    public void setFollowingId(Long followingId) {
        this.followingId = followingId;
    }

    @Override
    public String toString() {
        return "CompareRequest{" +
                "previousId=" + previousId +
                ", followingId=" + followingId +
                '}';
    }
}