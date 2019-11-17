package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.HolidayModel;
import util.JsonDeserializerHoliday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HolidayMain {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "iso-8859-1");
        String url = "https://api.calendario.com.br/?json=true&ano=2017&estado=SP&token=" + System.getenv("token");

        try{
            String content = fetchContent(url);
            Gson gson = new GsonBuilder().registerTypeAdapter(new TypeToken<List<HolidayModel>>(){}.getType(), new JsonDeserializerHoliday())
                    .serializeNulls().create();

            List<HolidayModel> holidayModels = gson.fromJson(content, new TypeToken<List<HolidayModel>>(){}.getType());

            System.out.println(holidayModels);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static String fetchContent(String uri) throws IOException {

        final int OK = 200;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        int responseCode = connection.getResponseCode();
        if(responseCode == OK){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        }

        return null;
    }
}
