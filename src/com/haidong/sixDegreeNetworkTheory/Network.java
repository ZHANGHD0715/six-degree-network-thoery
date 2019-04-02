package com.haidong.sixDegreeNetworkTheory;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Member> members;

    public Network(List<Member> members) {
        this.members = members;
    }

    public float percentageOfRelatedMembers(int index) {
        int count = siblingMembersNum(index);
        System.out.printf("The final count is %d\n", count);
        float percentage = (float) count / members.size();
        System.out.printf("The percentage is %.2f\n", percentage);
        return percentage;
    }

    protected int siblingMembersNum(int index) {
        List<Integer> visited = new ArrayList<>();
        List<Member> queue = new ArrayList<>();
        Member member = members.get(index - 1);

        int count = 1;
        visited.add(index);
        queue.add(member);

        while(queue.size() > 0) {
            System.out.printf("The current count is %d\n", count);
            Member nextMember = queue.remove(0);
            int[] memberSiblings = nextMember.siblings;
            for (int i = 0; i < memberSiblings.length; i++) {
                if (!visited.contains(memberSiblings[i])) {
                    queue.add(nextMember);
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
