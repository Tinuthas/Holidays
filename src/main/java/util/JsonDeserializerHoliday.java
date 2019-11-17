package util;

import com.google.gson.*;
import model.HolidayModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonDeserializerHoliday implements JsonDeserializer<List<HolidayModel>> {
    public List<HolidayModel> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        Gson g = new Gson();
        List<HolidayModel> holidayModels = new ArrayList<HolidayModel>();
        Iterator<JsonElement> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JsonElement next = iterator.next();
            HolidayModel holidayModel = g.fromJson(next, HolidayModel.class);
            holidayModels.add(holidayModel);
        }

        return holidayModels;
    }
}
