package Framework.Utils;

import Models.UserData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
public class DataUtil {

    private static final String configFileName = "src/test/resources/config.json";
    private static final String testUsersDataFileName = "src/test/resources/test_users_data.json";
    private static final String testDataFileName = "src/test/resources/test_data.json";

    public static JsonNode getConfig() {
        try {
            log.info("Reading config from {}", configFileName);
            String configString = Files.readString(Path.of(configFileName));
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(configString, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed reading config", e);
        }
    }

    public static Object[][] getTestData() {
        try {
            log.info("Reading test data from {}", testUsersDataFileName);
            String testDataString = Files.readString(Path.of(testUsersDataFileName));
            ObjectMapper mapper = new ObjectMapper();
            CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, UserData.class);
            List<UserData> users;
            users = mapper.readValue(testDataString, javaType);
            UserData[][] arr = new UserData[users.size()][1];
            for (int i = 0; i < users.size(); i++) {
                arr[i][0] = users.get(i);
            }
            return arr;
        } catch (IOException e) {
            throw new RuntimeException("Failed reading test data", e);
        }
    }

    public static String getValue(String fieldName) {
        try {
            String configString = Files.readString(Path.of(testDataFileName));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readValue(configString, JsonNode.class);
            return node.findValuesAsText(fieldName).get(0);
        } catch (IOException e) {
            throw new RuntimeException("Failed reading test data", e);
        }
    }
}
