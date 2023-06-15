package top.qinchao4j.common.web.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.qinchao4j.base.util.DateUtils;

import java.text.SimpleDateFormat;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/4/18 10:25
 */
@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizeLocalDateTimeFormat() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.serializers()
                .serializers(new LocalDateTimeSerializer(DateUtils.DATE_TIME_FORMATTER), new LocalDateSerializer(DateUtils.DATE_FORMATTER))
                .deserializers(new LocalDateTimeDeserializer(DateUtils.DATE_TIME_FORMATTER), new LocalDateDeserializer(DateUtils.DATE_FORMATTER))
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .dateFormat(new SimpleDateFormat(DateUtils.DATE_TIME_PATTERN));
    }

}
