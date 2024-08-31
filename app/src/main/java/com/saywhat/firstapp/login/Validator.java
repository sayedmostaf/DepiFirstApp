package com.saywhat.firstapp.login;

public class Validator {
    public boolean validEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        int atIdx = -1, dotIdx = -1;

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (c == '@') atIdx = i;
            else if (c == '.') dotIdx = i;
        }

        // sayed@gmail.com
        if (atIdx > 0 && dotIdx > atIdx + 1 && dotIdx < email.length() - 1) return true;
        return false;
    }

    public boolean validPassword(String password) {
        return password != null && password.length() >= 8;
    }
}
