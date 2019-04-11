package com.haidong.sixDegreeNetworkTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SixDegreeCounter {
    private final Network network;
    private final List<Integer> visited = new ArrayList<>();
    private final Queue<Integer> queue = new LinkedList<>();
    private int count = 1;
    private int level = 1;
    private int last;

    public SixDegreeCounter(Network network) {
        this.network = network;
    }

    protected int siblingMembersNum(int index) {
        last = index;
        visited.add(index);
        queue.add(index);

        while (queue.size() > 0) {
            System.out.printf("The current count is %d\n", count);
            System.out.printf("The current level: %d\n", level);
            int nextMember = queue.poll();
            List<Integer> memberSiblings = network.members[nextMember - 1].friends;

            count = appendSiblingsCount(count, memberSiblings);
            level = updateLevel(nextMember, last, level);
            last = updateLast(last, memberSiblings);

            if (level == 6) {
                break;
            }
        }

        return count;
    }

    private int updateLevel(int nextMember, int last, int level) {
        if (nextMember == last) {
            level = ++level;
        }
        return level;
    }

    private int updateLast(int last, List<Integer> memberSiblings) {
        if (memberSiblings.size() > 0) {
            last = memberSiblings.get(memberSiblings.size() - 1);
        }
        return last;
    }

    private int appendSiblingsCount(int count, List<Integer> memberSiblings) {
        for (int i = 0; i < memberSiblings.size(); i++) {
            if (!visited.contains(memberSiblings.get(i))) {
                queue.add(memberSiblings.get(i));
                count++;
                visited.add(memberSiblings.get(i));
            }
        }
        return count;
    }
}
