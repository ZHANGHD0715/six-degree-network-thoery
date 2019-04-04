package com.haidong.sixDegreeNetworkTheory;

import com.haidong.sixDegreeNetworkTheory.Network.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        readNetwork();

        Network network = new Network(loadMembers());
        network.percentageOfRelatedMembers(1);
    }

    private static List<Member> loadMembers() {
        return new ArrayList<Member>() {{
            add(new Member(new int[]{2, 3}));
            add(new Member(new int[]{1, 3, 4, 6}));
            add(new Member(new int[]{1, 2, 4, 5, 6}));
            add(new Member(new int[]{2, 3, 5}));
            add(new Member(new int[]{3, 6}));
            add(new Member(new int[]{2, 3, 5, 7, 8}));
            add(new Member(new int[]{6, 8}));
            add(new Member(new int[]{6, 7}));
        }};
    }

    private static void readNetwork() {
        Scanner sc = new Scanner(System.in);
        int memberNum = sc.nextInt();
        int networkEdgeNum = sc.nextInt();

        Member[] members = new Member[memberNum];

        for (int i = 0; i < memberNum; i++) {
            members[i] = new Member(i + 1);
        }

        for (int i = 0; i < networkEdgeNum; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
        }
    }
}
