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
        Queue<Integer> queue = new LinkedList<>();

        int count = 1,
            level = 1,
            last = index;
        visited.add(index);
        queue.add(index);

        while (queue.size() > 0) {
            System.out.printf("The current count is %d\n", count);
            System.out.printf("The current level: %d\n", level);
            int nextMember = queue.poll();
            int[] memberSiblings = members.get(nextMember - 1).siblings;
            for (int i = 0; i < memberSiblings.length; i++) {
                if (!visited.contains(memberSiblings[i])) {
                    queue.add(memberSiblings[i] - 1);
                    count++;
                    visited.add(memberSiblings[i]);
                }
            }

            if (nextMember == last) {
                level = ++level;
                last = memberSiblings[memberSiblings.length - 1];
            }

            if (level == 6) {
                break;
            }

        }

        return count;
    }
}
