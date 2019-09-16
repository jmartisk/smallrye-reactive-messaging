package io.smallrye.reactive.messaging.mqtt;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.inject.Inject;

@Readiness
public class MqttHealthCheck implements HealthCheck {

  @Inject
  MqttConnector connector;

  @Override
  public HealthCheckResponse call() {
    return HealthCheckResponse.builder()
      .name("mqtt-connector")
      .state(connector.isReady())
      .build();
  }

}
