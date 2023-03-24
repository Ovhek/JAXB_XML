/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m06uf3pracma.dao;

import m06uf3pracma.Utils.MongoDBConnector;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import m06uf3pracma.model.IdProvider;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Alex
 */
public class GenericDAO<Entidad extends IdProvider> implements GenericDAOInterface<Entidad> {

    private final MongoCollection<Entidad> collection;
    //private final Gson gson;
    private final Class<Entidad> clazz;

    public GenericDAO(Class<Entidad> clazz) {
        //creamos el gson y especificamos como ha de mapear el LocalDateTime a Json
        //https://stackoverflow.com/questions/22310143/java-8-localdatetime-deserialized-using-gson
        /*gson = new GsonBuilder()
                .registerTypeAdapter(ObjectId.class, new JsonSerializer<ObjectId>() {
                    @Override
                    public JsonElement serialize(ObjectId src, Type typeOfSrc, JsonSerializationContext context) {
                        return new JsonPrimitive(src.toHexString());
                    }
                })
                .registerTypeAdapter(ObjectId.class, new JsonDeserializer<ObjectId>() {
                    @Override
                    public ObjectId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        JsonObject jsonObject = json.getAsJsonObject();
                        JsonPrimitive jsonPrimitive = jsonObject.getAsJsonPrimitive("$oid");
                        String objectIdString = jsonPrimitive.getAsString();
                        return new ObjectId(objectIdString);
                    }
                })
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()).create();
        */
        this.collection = MongoDBConnector.getInstance().getDB().getCollection(clazz.getSimpleName()).withDocumentClass(clazz);
        this.clazz = clazz;
    }

    @Override
    public List<Entidad> getAll() {
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Entidad getById(ObjectId id) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);
        return collection.find(query).first();
    }

    @Override
    public void update(Entidad entidad) {
        delete(entidad);
        save(entidad);
    }

    @Override
    public void delete(Entidad entidad) {
        Document query = new Document("_id", entidad.getId());
        collection.deleteOne(query);
    }

    @Override
    public void save(Entidad entidad) {
        collection.insertOne(entidad);
    }
}
