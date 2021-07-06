package com.techprimers.jaegerserver.config;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class JaegerConfig {

  @Bean
  public WebClient webClient() {
    return WebClient.create();
  }

 @Bean
	public JaegerTracer jaegerTracer() {
			  SamplerConfiguration samplerConfig = SamplerConfiguration.fromEnv().withType(ConstSampler.TYPE).withParam(1);
			  ReporterConfiguration reporterConfig = ReporterConfiguration.fromEnv().withLogSpans(true).withSender(
			      SenderConfiguration.fromEnv().withAgentHost("localhost").withAgentPort(6831));
			  io.jaegertracing.Configuration config =  new io.jaegertracing.Configuration("jaeger-server").withSampler(samplerConfig).withReporter(reporterConfig);
			  return config.getTracer();
			
		
	//return new io.jaegertracing.internal.JaegerTracer.Builder("jaeger-server").build();

	/*return new io.jaegertracing.Configuration("jaeger-server")
				.withSampler(new io.jaegertracing.Configuration.SamplerConfiguration().withType(ConstSampler.TYPE)
						.withParam(1))
				.withReporter(new io.jaegertracing.Configuration.ReporterConfiguration().withLogSpans(true))
				.getTracer();*/
	}
}
