package com.digitalinnovationone.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.REGION_DYNAMO;

public class HeroesData {
    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Api_Table");

        Item hero = new Item()
                .withPrimaryKey("id","1")
                .withString("name","Mulher maravilha")
                .withString("universe", "dc comics")
                .withNumber("films", 3);

        Item hero2 = new Item()
                .withPrimaryKey("id","2")
                .withString("name","Superman")
                .withString("universe", "dc comics")
                .withNumber("films", 10);

        Item hero3 = new Item()
                .withPrimaryKey("id","3")
                .withString("name","Iron Man")
                .withString("universe", "Marvel")
                .withNumber("films", 10);

        PutItemOutcome outcome = table.putItem(hero);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);
    }

}
