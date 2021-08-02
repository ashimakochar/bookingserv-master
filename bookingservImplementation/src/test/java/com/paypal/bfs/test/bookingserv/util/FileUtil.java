package com.paypal.bfs.test.bookingserv.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Slf4j
public class FileUtil {

  @Getter
  private static ObjectMapper objectMapper;

  static{
    JavaTimeModule module = new JavaTimeModule();
    LocalDateTimeDeserializer localDateTimeDeserializer =  new
        LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
    objectMapper = Jackson2ObjectMapperBuilder.json()
        .modules(module)
        .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .build();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
  }

  public static Object getObjectFromFile(String fileName, Class tClass){
    InputStream is = tClass.getResourceAsStream(fileName);
    Object object = null;
    try {
      object = objectMapper.readValue(is, tClass);
    } catch (IOException e) {
      log.error("Unable to parse json file = {} for class = {} exception = {}", fileName, tClass, e);
    }
    return object;
  }

  public static List getObjectListFromFile(String fileName, Class tClass){
    InputStream is = tClass.getResourceAsStream(fileName);
    List<Object> object = null;
    try {
      object = objectMapper.readValue(is, objectMapper.getTypeFactory().constructCollectionType(List.class, tClass));
    } catch (IOException e) {
      log.error("Unable to parse json file = {} for class = {} exception = {}", fileName, tClass, e);
    }
    return object;
  }

  public static String getContentsOfFile(String fileName) throws URISyntaxException, IOException {
    return Files.readAllLines(Paths.get(FileUtil.class.getResource(fileName).toURI()))
        .stream()
        .collect(Collectors.joining("\n"));
  }

  public static JSONObject readJsonFileResource(String resource, String charsetName) throws Exception {

    InputStream input = FileUtil.class.getResourceAsStream(resource);
    JSONParser parser = new JSONParser();

    return (JSONObject) parser.parse(new InputStreamReader(input, charsetName));
  }

}
