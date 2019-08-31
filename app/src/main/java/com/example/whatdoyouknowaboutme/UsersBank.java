package com.example.whatdoyouknowaboutme;

import java.util.HashMap;

public class UsersBank {
    private static HashMap<String, int[]> users;

    public UsersBank() {
        users = new HashMap<>();
    }

    public static void AddAUser(User user){
        users.put(user.getName(), user.getCorrectAnswers());
    }

    public static int[] getAUserAnswers(String name){
        return users.get(name);
    }

    public HashMap<String, int[]> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, int[]> users) {
        this.users = users;
    }
}
