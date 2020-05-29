
public class MoviesToDatabase {

	public static void main (String[] args)
	{
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
		DynamoDB dynamoDB = new DynamoDB(client);
		
		Table table = dynamoDB.getTable("Movies");
		
		// Building the item
		Item item = new Item()
				.withPrimaryKey("Id", 1)
				.withString("Title", "Star Wars")
				.withNumber("Released", 1998)
				.withNumber("Rating", 4)
				.withString("Director", "George Lucas");
				
		// putting the item in the table
		PutItemOutcome outcome = table.putItem(item);
	}

}
