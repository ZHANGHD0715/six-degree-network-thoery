package com.haidong.sixDegreeNetworkTheory;

import java.util.LinkedList;
import java.util.List;

public class Member {
    final int index;
    List<Integer> friends = new LinkedList<>();

    public Member(int index) {
        this.index = index;
    }
}
