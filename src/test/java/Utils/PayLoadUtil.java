package Utils;

import com.github.javafaker.Faker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayLoadUtil {

    public static String getPetPayLoad() {

        Faker faker=new Faker();
        long id=System.currentTimeMillis();
        System.out.println(id);
        return "{\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \" " + RandomName.getRandomName() + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \" available \"\n" +
                "}";
    }
    public static String getPetPayLoad2(int id,String name,String status) {


        return "{\n" +
                "  \"id\": \"" +id+ "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"" +name+ "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" +status+ "\"\n" +
                "}";
    }
    public   static  String slackMessage(String message
    ){
        return "{\n" +
                "  \"channel\": \"C0164SXRETU\",\n" +
                "  \"text\": \""+ message+"\"\n" +
                "}";
    }
    public static String generateStringFromResourse(String path) throws IOException {
        String petPAyLoad = new String(Files.readAllBytes(Paths.get(path)));
return petPAyLoad;
    }
}
