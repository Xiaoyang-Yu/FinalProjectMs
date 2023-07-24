package com.management.API;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GptAPI {
    public String GptResult(String text) throws Exception {
        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", text);
        data.put("max_tokens", 4000);
        data.put("temperature", 0.8);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();
        return new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");
    }

    int age;
    int weight;
    int Height;

    String diteType;
    String userGander;
    String foodUnit;
    String advancedPrompt="[{meal:breakfast,details:[{name:'egg',fat='6g'}]...}]";
//
//    public String GetPrompt(User user) throws Exception {
//        String qustion= userGander + weight
//                +" and "+ Height+",and "+age +" year old," +
//                diteType +",give a diet sheet include "+foodUnit+" food in each meal," +
//                "detailed information has breakfast,lunch,dinner,names of food,food units," +
//                "protein grams,carbohydrates grams,fat grams,dietary fiber grams,sodium grams," +
//                "and calories.output must be " + advancedPrompt;
//    }
}
