package com.view;

import com.model.Post;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.function.Consumer;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class App {


    public static void main(String[] args) {

        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClient mongoClient = new MongoClient("localhost",
                MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());

        MongoDatabase database = mongoClient.getDatabase("post").
                withCodecRegistry(pojoCodecRegistry);

        MongoCollection <Post> collection = database.getCollection("Post", Post.class);

//        collection.insertOne(new Post("Boa noite", "Texto do post aqui...", "julia.cz@hotmail.com"));
//        collection.insertOne(new Post("Bom dia", "Texto do post aqui...", "allyson.cz@hotmail.com"));
//        collection.insertOne(new Post("Boa tarde", "Texto do post aqui...", "igor.cz@hotmail.com"));
//        collection.insertOne(new Post("Algo aconteceu hoje", "Texto do post aqui...", "julia.cz@hotmail.com"));
//        collection.insertOne(new Post("Fui ao mercado", "Texto do post aqui...", "allyson.cz@hotmail.com"));


        collection.find(new Document("email", "julia.cz@hotmail.com")).forEach((Consumer<? super Post>) a -> System.out.println(a));

        mongoClient.close();



    }

}
