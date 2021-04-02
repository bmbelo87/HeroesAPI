package com.digitalinnovationone.heroesapi.config;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.REGION_DYNAMO;

public class HeroesSelect {
    public static void main(String[] args) {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Api_Table");

        try {
            Item item = table.getItem("id", "1");
            if (item != null) {
                System.out.println("Result: " + item);
            } else {
                System.out.println("Não encontrado");
            }
        } catch (AmazonServiceException ase) {
            System.err.println("Não completo");
            System.err.println("Mensagem: " + ase.getMessage());
            System.err.println("AWS Error Code: " + ase.getErrorCode());
            System.err.println("Error Type:     " + ase.getErrorType());
            System.err.println("Request ID:     " + ase.getRequestId());

        } catch (AmazonClientException ace) {
            System.err.println("Internal error occurred communicating with DynamoDB");
            System.out.println("Error Message:  " + ace.getMessage());
        }


    }
}