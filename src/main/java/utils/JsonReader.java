package utils;

import java.io.File;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.apache.commons.io.FileUtils;

/**
 * JsonReader provides the ability to interact with the data from testData.json.
 * This can be more genericized. (Currently, unused.)
 */
public class JsonReader {

    public static JSONObject getJsonData() throws IOException, ParseException {
        // pass the path of the testData.json file
        File filename = new File("resources//testData//testData.json");
        //convert json file into string
        String json = FileUtils.readFileToString(filename, "UTF-8");
        // parse the string into object
        Object obj = new JSONParser().parse(json);
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }
}
