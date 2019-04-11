package com.haidong.sixDegreeNetworkTheory;

import java.text.DecimalFormat;

public class Network {
    public final Member[] members;

    public Network(Member[] members) {
        this.members = members;
    }

    public String percentageOfRelatedMembers(int index) {
        SixDegreeCounter sixDegreeCounter = new SixDegreeCounter(this);

        int count = sixDegreeCounter.siblingMembersNum(index);
        System.out.printf("The final count is %d\n", count);

        DecimalFormat df = new DecimalFormat("00.00%");
        String percentage = df.format((float) count / members.length);

        System.out.printf("The percentage is %s\n", percentage);
        return percentage;
    }


}
