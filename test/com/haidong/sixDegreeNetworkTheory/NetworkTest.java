package com.haidong.sixDegreeNetworkTheory;

import org.junit.Assert;
import org.junit.Test;

public class NetworkTest {
    @Test
    public void should_return_100_percentage_when_given_certain_members() {
        Member[] members = new Member[]{new Member(1)};
        Network network = new Network(members);

        Assert.assertEquals("100.00%", network.percentageOfRelatedMembers(1));
    }
}
