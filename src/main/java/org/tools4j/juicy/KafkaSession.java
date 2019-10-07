package org.tools4j.juicy;

public class KafkaSession implements Session {
    @Override
    public String getName() {
        return "kafkaSession";
    }

    @Override
    public String getPayload() {
        return "kafka payload!";
    }
}
