package org.hopto.delow.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class InfrastructureModule extends AbstractModule {

    private final ObjectMapper mapper;

    public InfrastructureModule() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Provides
    public ObjectWriter provideObjectWriter() {
        return mapper.writerWithDefaultPrettyPrinter();
    }

    @Provides
    public ObjectMapper provideObjectMapper() {
        return mapper;
    }

}
