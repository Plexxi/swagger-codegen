package io.swagger.api;

import java.math.BigDecimal;
import io.swagger.model.Client;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * A decorator to be called by the {@link FakeApiController}}.
 * Should be implemented as a controller but without the {@link org.springframework.stereotype.Controller} annotation.
 * Instead, use spring to autowire this class into the {@link FakeApiController}.
 */

public interface FakeApiDecorator {

    /**
     * @see FakeApi#testClientModel
     */
    ResponseEntity<Client> testClientModel(Client body);

    /**
     * @see FakeApi#testEndpointParameters
     */
    ResponseEntity<Void> testEndpointParameters(BigDecimal number,
        Double _double,
        String patternWithoutDelimiter,
        byte[] _byte,
        Integer integer,
        Integer int32,
        Long int64,
        Float _float,
        String string,
        byte[] binary,
        LocalDate date,
        DateTime dateTime,
        String password,
        String paramCallback);

    /**
     * @see FakeApi#testEnumParameters
     */
    ResponseEntity<Void> testEnumParameters(List<String> enumFormStringArray,
        String enumFormString,
        List<String> enumHeaderStringArray,
        String enumHeaderString,
        List<String> enumQueryStringArray,
        String enumQueryString,
        Integer enumQueryInteger,
        Double enumQueryDouble);

}
