package org.tools4j.juicy;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ProcessModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            //Example of binding multiple objects of the same type (in this case Sessions)
            Multibinder<Session> sessionBinder = Multibinder.newSetBinder(binder(), Session.class);
            sessionBinder.addBinding().to(HttpSession.class);
            sessionBinder.addBinding().to(KafkaSession.class);

            bind(UserService.class).to(MyUserService.class);

            //Example of binding to class whereby we only have the name, e.g. from config
            bind(Process.class).to((Class<? extends Process>) Class.forName("org.tools4j.juicy.MyProcess"));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
