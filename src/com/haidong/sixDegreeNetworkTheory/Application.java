package com.haidong.sixDegreeNetworkTheory;

import com.haidong.sixDegreeNetworkTheory.Network.Member;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Network network = new Network(loadMembers());
        network.percentageOfRelatedMembers(1);
    }

    private static List<Member> loadMembers() {
        return new ArrayList<Member>() {{
            add(new Member(new int[]{2, 3, 7}));
            add(new Member(new int[]{1, 3, 4, 6}));
            add(new Member(new int[]{1, 2, 4, 5, 6, 7, 8}));
            add(new Member(new int[]{2, 3, 5, 7}));
            add(new Member(new int[]{3, 6}));
            add(new Member(new int[]{2, 3, 5, 7, 8}));
            add(new Member(new int[]{1, 3, 4, 6, 8}));
            add(new Member(new int[]{3, 6, 7}));
        }};
    }
}
