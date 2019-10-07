package org.tools4j.juicy;

public class HttpSession implements Session {
    @Override
    public String getName() {
        return "httpSession";
    }

    @Override
    public String getPayload() {
        return "http payload!";
    }
}
