package com.example.whatdoyouknowaboutme;

import java.util.HashMap;

public class UsersBank {
    private static HashMap<String, int[]> users = new HashMap<>();


    static void AddAUser(User user){
        users.put(user.getName(), user.getCorrectAnswers());
    }

    static int[] getAUserAnswers(String name){
        return users.get(name);
    }

    public HashMap<String, int[]> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, int[]> users) {
        UsersBank.users = users;
    }
}
