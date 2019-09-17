package io.smallrye.reactive.messaging.mqtt.health;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import io.smallrye.reactive.messaging.mqtt.MqttConnector;

@Readiness
public class MqttReadinessCheck implements HealthCheck {

    @Inject
    @Any
    MqttConnector connector;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.builder()
                .name("mqtt-connector")
                .state(connector.isReady())
                .build();
    }

}
