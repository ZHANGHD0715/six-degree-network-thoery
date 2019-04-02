package com.haidong.sixDegreeNetworkTheory;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NetworkTest {
    @Test
    public void should_return_100_percentage_when_given_certain_members () {
        Network network = new Network(new ArrayList<Network.Member>() {{
            add(new Network.Member(new int[]{}));
        }});

        Assert.assertEquals(1.00f, network.percentageOfRelatedMembers(1), 0.00f);
    }
}
