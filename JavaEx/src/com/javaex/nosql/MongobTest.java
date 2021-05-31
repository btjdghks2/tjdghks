package com.javaex.nosql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongodbTest {
	static String MONGODB_IP = "127.0.0.1";	//	localhost
 public static void main(String[] args) {
//		testInsertMany();
//		testFindFirst();
//		testFindAll();
		testFindFilter();
//		testFindFilter();
//		testDelete();
//		testUpdateOne();
		testUpdateMany();
	}

	//	���� �����ϴ� ��� ���� ������Ʈ
	private static void testUpdateMany() {
		//	gender == FEMALE�� ��� ����
		//		method = "updateMany"
		MongoCollection<Document> coll = 
				getCollection(DB_NAME, COLL_NAME);
		Bson filter = Filters.eq("gender", "FEMALE");
		Bson doc = new Document("$set",
						new Document("method", "updateMany"));
		UpdateResult result = coll.updateMany(filter, doc);

		//	������ ���ǿ� ��Ī �Ǿ ������ �ٸ��� ������
		//	 Update ���� ����
		System.out.println(result.getMatchedCount() + 
				"���� ������ ã����!");
		System.out.println(result.getModifiedCount() +
				"���� ������ ������Ʈ!");
	}

	//	�� �� ���� ������Ʈ (updateOne)
	private static void testUpdateOne() {
		//	species == �ΰ��� ���� �Ѱ��� ������Ʈ
		//		method �ʵ� updateOne
		//	db.testCollection.update({ ���� }, { "$set" : { ���� } })
		MongoCollection<Document> coll =
				getCollection(DB_NAME, COLL_NAME);
		Bson filter = Filters.eq("species", "�ΰ�"); // { species: "�ΰ�" }
		//	����: ������Ʈ�� $set �����ڸ� ����ؾ� update
		Bson doc = new Document("$set", 
									new Document("method", "updateOne"));
		UpdateResult result = coll.updateOne(filter, doc);

		System.out.println(result.getModifiedCount() 
				+ "�� ���ڵ� ������Ʈ!");
	}

	//	�����ϱ�
	private static void testDelete() {
		//	db.testCollection.delete({ ���� })
		//	��ü ����: db.testCollection.delete({})
		//	gender == MALE�� ���� ����
		MongoCollection<Document> coll = 
				getCollection(DB_NAME, COLL_NAME);
		//	Filter: ������ �̿��� ����\
		/*
		Bson filter = Filters.eq("gender", "MALE");
		DeleteResult result = coll.deleteMany(filter);
		*/
		//	��ü ����
		DeleteResult result = coll.deleteMany(new Document());

		System.out.println("���� ���:" + result);
		System.out.println(result.getDeletedCount() + 
				"���� ���ڵ� ����! ");
	}

	//	���ǿ� �����ϴ� ���� ��������
	private static void testFindFilter() {
		//	species�� �ΰ��̰� gender�� FEMALE�� ���� - $and
		/*
		db.javaMongo.find({ $and: 
								[
									{"species": "�ΰ�"},
									{"gender": "FEMALE"
								]
							})
		*/
		
		//	���� Bson ����
//		Bson bsonFilter = Filters.and(
//					Filters.eq("species", "�ΰ�"),
//					Filters.eq("gender", "FEMALE")
//				);
		
		//	species == �ΰ� or gender == FEMALE�� ������
		Bson bsonFilter = Filters.or(
					Filters.eq("species", "�ΰ�"),
					Filters.eq("gender", "FEMALE")
				);
		System.out.println("Filter:" + bsonFilter);
		
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		//	���� �˻�
		MongoCursor<Document> cursor = coll.find(bsonFilter).iterator();
		
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			System.out.println("DOC:" + doc);
		}
		cursor.close();
	}
	
	//	��ü ���� ��������
	private static void testFindAll() {
		//	db.javaMongo.find()
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		
		MongoCursor<Document> cursor = coll.find().iterator();
		//	loop
		while(cursor.hasNext()) {	//	�ڿ� ���� �ִ� ������ ������
			Document doc = cursor.next();
			System.out.println(doc.toJson());
		}
		cursor.close();
	}
	
	//	���� �� �� ��������: findOne
	private static void testFindFirst() {
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		
		Document doc = coll.find().first();
		System.out.println("DOC:" + doc);
		System.out.println("JSON:" + doc.toJson());
		
		//	�ʵ� �� �������� .get
		System.out.printf("%s, %s, %s, %s\n", 
				doc.get("_id"),
				doc.get("name"),
				doc.get("species"),
				doc.get("gender"));
	}
	
	//	���� �� ���� insert 
	private static void testInsertMany() {
		/*
		 db.javaMongo.insertMany([
		 	{ ���� }, { ���� }
		 ]);
		 */
		List<Document> docs = new ArrayList<>();	//	List ����
		Document doc = new Document("name", "��浿")
									.append("species", "�ΰ�")
									.append("gender", "MALE");
		//	����Ʈ�� �߰�
		docs.add(doc);
		
		doc = new Document("name", "��ġ")
							.append("species", "����")
							.append("gender", "FEMALE");
		docs.add(doc);
		
		doc = new Document("name", "�����")
							.append("species", "�ܰ���")
							.append("gender", "MALE");
		docs.add(doc);
		
		doc = new Document("name", "����")
							.append("species", "�ΰ�")
							.append("gender", "FEMALE");
		docs.add(doc);
		System.out.println("DOCUMENTS:" + docs);
		
		//	���� ���� INSERT
		//	db.javaMongo.insertMany([ ������ �迭 ])
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		coll.insertMany(docs);	//	����Ʈ ����
	}
	
	//	1�� ���� insert
	private static void testInsert() {
		//	���� ���� ����
		//	Bson -> Document
		/*
		{ name: "�Ѹ�", species: "����", gender: "MALE" }
		 */
		Document doc = new Document("name", "�Ѹ�")
							.append("species", "����")
							.append("gender", "MALE");
		System.out.println("DOC:" + doc);
		System.out.println("JSON:" + doc.toJson());
		// DB ���� -> �÷��� -> insert
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		//	1���� ���� insert
		coll.insertOne(doc); //	db.testCollection.insert({})
	}
	
	private static MongoCollection<Document> getCollection(
			String databaseName, String collectionName) {
		//	����
		MongoClient client = connect();
		//	use �����ͺ��̽�
		MongoDatabase db = client.getDatabase(databaseName);	//	use javaMongo
		System.out.println("DATABASE:" + db);
		//	�÷��� ����
		MongoCollection<Document> coll = 
				db.getCollection(collectionName);
		System.out.println("COLLECTION:" + coll);
		return coll;
	}
	
	private static MongoClient connect() {
		//	���� DB ����
//		MongoClient client = MongoClients.create();	//	�⺻ ����
		//	�⺻�� ���: ip -> localhost, port -> 27017
		//	����� ���� ��ġ
		//	Mongodb ip localhost�� �̴ϰ�, 
		//	port 27017 �ƴϴ�
		MongoClient client = MongoClients.create(	//	���� ����
				MongoClientSettings.builder()
					.applyToClusterSettings(builder -> 
						builder.hosts(
								Arrays.asList(
										new ServerAddress(MONGODB_IP, MONGODB_PORT)
										)
								)
					).build()
			);
		
		System.out.println(client);
		return client;
	}
}