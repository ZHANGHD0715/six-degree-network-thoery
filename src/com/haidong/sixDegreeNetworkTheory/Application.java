package com.haidong.sixDegreeNetworkTheory;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Network network = new Network(loadMembers());
        network.percentageOfRelatedMembers(1);
    }

    private static Member[] loadMembers() {
        System.out.println("Please start enter:");
        Scanner sc = new Scanner(System.in);
        int memberNum = sc.nextInt();
        int networkEdgeNum = sc.nextInt();

        Member[] members = new Member[memberNum];

        for (int i = 0; i < members.length; i++) {
            members[i] = new Member(i + 1);
            System.out.println(members[i].index);
        }

        for (int i = 0; i < networkEdgeNum; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println("Start:" + start);
            System.out.println("End:" + end);
            members[start - 1].friends.add(end);
        }
        return members;
    }
}
