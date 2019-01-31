import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 解析json
 */
public class Analysjson {
    public static void main(String args[]){
        anayles();
    }

    public static void anayles(){
        try{
            JsonParser parser = new JsonParser();
            JsonArray Barray = (JsonArray) parser.parse(new FileReader("/home/amarsoft/neon_workspace/FeatureOfJava/src/main/resources/json/album.json"));
            for(int i = 0 ; i < Barray.size(); i++){
                JsonObject jo = (JsonObject)Barray.get(i);
                System.out.println(jo.get("title").getAsString());
                if(jo.get("subalbum")!=null) {
                    JsonArray ja = jo.get("subalbum").getAsJsonArray();
                    for (int j = 0; j < ja.size(); j++) {
                        JsonObject joo = (JsonObject) ja.get(j);
                        System.out.println("  -->" + joo.get("title"));
                    }
                }
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void returnJson(){
        Gson gson = new Gson();
        System.out.println(gson.toJson("success").toString());
    }
}
