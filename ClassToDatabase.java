
public class ClassToDatabase {

	public static void main (String[] args)
	{
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
		DynamoDB dynamoDB = new DynamoDB(client);
		
		Table table = dynamoDB.getTable("Classes");
		
		// Building the item
		Item item = new Item()
				.withPrimaryKey("Id", 1)
				.withString("subject", "Computer Science")
				.withNumber("room number", 132)
				.withNumber("student count", 34)
				.withString("teacher", "Mr. M");
				
		// putting the item in the table
		PutItemOutcome outcome = table.putItem(item);
	}

}
