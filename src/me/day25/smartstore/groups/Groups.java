package me.day25.smartstore.groups;


import me.day25.smartstore.customers.Customer;
import me.day25.smartstore.customers.Customers;

public class Groups { // singleton

    ////////////// singleton ////////////////
    private static Groups allGroups;

    public static Groups getInstance() {
        if (allGroups == null) {
            allGroups = new Groups();
        }
        return allGroups;
    }
    /////////////////////////////////////////

    private int size;
    private int capacity;
    private Group[] groups;


    public Groups() {
        this.groups = new Group[GroupType.size()];
        initialize();
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public int size() {
        return size;
    }

    public int length() {
        return this.groups.length;
    }

    private boolean isNull() {
        return groups == null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void initialize() {
        for (int i = 0; i < GroupType.size(); i++) {
            groups[i] = new Group(GroupType.values()[i], null);
            size++;
        }
    }

    public void add(Group group) {
        Group grp = find(group.getType());

        if (grp != null) {
            update(group);
        } else {
            groups[size] = group;
            size++;
        }

    }

    public Group get(int i) {
        return groups[i];
    }

    public void update(Group group) {
        Group grp = find(group.getType());
        if (grp != null) {
            grp.setParam(group.getParam());
        }

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (groups[i] != null) {
                System.out.println(groups[i]);
            }
        }
    }

    public Group find(GroupType groupType) {
        for (Group grp : groups) {
            if (grp.getType() == groupType)
                return grp;
        }
        return null;
    }

    public Group findGroupFor(Customer cust) {
        if (groups == null || cust == null) return null;
        System.out.println(cust);

        for(int i = size - 1; i >= 0; i--) {
            Parameter param = groups[i].getParam();
            System.out.println(param);
            if (param == null) continue;

            if (cust.getSpentTime() >= param.getMinimumSpentTime()
                    && cust.getTotalPay() >= param.getMinimumTotalPay()) {
                return groups[i];
            }

            return null;
        }

        return null;
    }

    @Override
    public String toString() {
        String str = "";

        for(int i = 0; i < size; ++i) {
            str = str + " " + groups[i].toString() + "\n";
        }

        return str;
    }
}
