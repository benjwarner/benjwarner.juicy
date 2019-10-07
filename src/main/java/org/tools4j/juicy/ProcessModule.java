package org.tools4j.juicy;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ProcessModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            Multibinder<Session> sessionBinder = Multibinder.newSetBinder(binder(), Session.class);
            sessionBinder.addBinding().to(HttpSession.class);
            sessionBinder.addBinding().to(KafkaSession.class);

            bind(UserService.class).to(MyUserService.class);
            bind(Process.class).to((Class<? extends Process>) Class.forName("org.tools4j.juicy.MyProcess"));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
