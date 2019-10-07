package org.tools4j.juicy;

import javax.inject.Inject;
import java.util.Set;

public class MyProcess implements Process {
    private final UserService userService;
    private final Set<Session> sessions;

    //Constructor injection ensures immutability
    //Using javax.inject.Inject.  i.e. other DI frameworks could be swapped in later
    @Inject
    public MyProcess(UserService userService, Set<Session> sessions) {
        this.userService = userService;
        this.sessions = sessions;
    }

    @Override
    public void run() {
        System.out.println("I ran " + userService.getUser() + " sessions:" + sessions);
    }
}
