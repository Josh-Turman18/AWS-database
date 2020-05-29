
import java.util.ArrayList;

public class MovieQuery {

	public static void main(String[] args)
	{
		ArrayList<Item> itemList = connect();
	}
	
	public static ArrayList<Item> connect()
	{
		ArrayList<Item> itemList = new ArrayList<Item>();
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (/Users/Owner/.aws/credentials), and is in valid format.",
                    e);
        }
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        	.withCredentials(credentialsProvider)
            .withRegion("us-east-2")
            .build();
        
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("Movies");
        ScanRequest scanRequest = new ScanRequest().withTableName("Movies");
        
        ScanResult result = client.scan(scanRequest);
        Item item;
        
        for(int x = 1 ; x <= result.getCount() ; x++)
        {
        	item = table.getItem("Id", x);
        	
        	itemList.add(item);
        }
        
        return itemList;
	}

}
