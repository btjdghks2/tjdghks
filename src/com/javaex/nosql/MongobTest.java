package com.javaex.nosql;

import com.mongodb.client.MongoClient;

public class MongobTest {
	static String MONGODB_IP = "127.0.0.1"; // localhost
	static int MONGODB_PORT = 27017;
	static String DB_NAME = "javaMongo";
	static String COLL_NAme = "testCollection";
	
	public static void main(String[] args) {
//	connect();
		getCollection(DB_NAME, COLL_NAME);

	}
	
	private static MongoCollection<Document> getCollection(
			String databaseName, String collection() {
			// 접속
				MongoClient client = connect();
				// use 데이터 베이스
				MongoDatabase db = client.getDatabase(databaseName); // use javaMongo
				System.out.println("DATABASE:" + db)
				// 컬렉션 접속
				MongoCollection<Document> coll =
					db.getCollection(collectionName);
				System.out.println("COLLECTION:" + coll)
				return coll;
			}
	private static MongoClient connect() {
		// 몽고 db 접속
		MongoClient client = MongoClients.create();
		
		System.out.println(client);
		return client;
		
	}

}
