package com.haidong.sixDegreeNetworkTheory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Network {
    private List<Member> members;

    public Network(List<Member> members) {
        this.members = members;
    }

    public String percentageOfRelatedMembers(int index) {
        int count = siblingMembersNum(index);
        System.out.printf("The final count is %d\n", count);

        DecimalFormat df = new DecimalFormat("00.00%");
        String percentage = df.format((float) count / members.size());

        System.out.printf("The percentage is %s\n", percentage);
        return percentage;
    }

    protected int siblingMembersNum(int index) {
        List<Integer> visited = new ArrayList<>();
        Queue<Member> queue = new LinkedList<Member>();
        Member member = members.get(index - 1);

        int count = 1;
        visited.add(index);
        queue.add(member);

        while(queue.size() > 0) {
            System.out.printf("The current count is %d\n", count);
            Member nextMember = queue.poll();
            int[] memberSiblings = nextMember.siblings;
            for (int i = 0; i < memberSiblings.length; i++) {
                if (!visited.contains(memberSiblings[i])) {
                    queue.add(members.get(memberSiblings[i] - 1));
                    count++;
                    visited.add(memberSiblings[i]);
                }
            }
        }

        return count;
    }

    public static class Member {
        final int[] siblings;

        public Member(int[] siblings) {
            this.siblings = siblings;
        }
    }
}
