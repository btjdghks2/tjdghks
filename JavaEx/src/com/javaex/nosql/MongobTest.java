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

	//	조건 만족하는 모든 문서 업데이트
	private static void testUpdateMany() {
		//	gender == FEMALE인 모든 문서
		//		method = "updateMany"
		MongoCollection<Document> coll = 
				getCollection(DB_NAME, COLL_NAME);
		Bson filter = Filters.eq("gender", "FEMALE");
		Bson doc = new Document("$set",
						new Document("method", "updateMany"));
		UpdateResult result = coll.updateMany(filter, doc);

		//	문서가 조건에 매칭 되어도 내용이 다르지 않으면
		//	 Update 되지 않음
		System.out.println(result.getMatchedCount() + 
				"개의 문서를 찾았음!");
		System.out.println(result.getModifiedCount() +
				"개의 문서가 업데이트!");
	}

	//	한 개 문서 업데이트 (updateOne)
	private static void testUpdateOne() {
		//	species == 인간인 문서 한개를 업데이트
		//		method 필드 updateOne
		//	db.testCollection.update({ 조건 }, { "$set" : { 문서 } })
		MongoCollection<Document> coll =
				getCollection(DB_NAME, COLL_NAME);
		Bson filter = Filters.eq("species", "인간"); // { species: "인간" }
		//	주의: 업데이트시 $set 연산자를 사용해야 update
		Bson doc = new Document("$set", 
									new Document("method", "updateOne"));
		UpdateResult result = coll.updateOne(filter, doc);

		System.out.println(result.getModifiedCount() 
				+ "개 레코드 업데이트!");
	}

	//	삭제하기
	private static void testDelete() {
		//	db.testCollection.delete({ 조건 })
		//	전체 삭제: db.testCollection.delete({})
		//	gender == MALE인 문서 제거
		MongoCollection<Document> coll = 
				getCollection(DB_NAME, COLL_NAME);
		//	Filter: 조건을 이용한 삭제\
		/*
		Bson filter = Filters.eq("gender", "MALE");
		DeleteResult result = coll.deleteMany(filter);
		*/
		//	전체 삭제
		DeleteResult result = coll.deleteMany(new Document());

		System.out.println("삭제 결과:" + result);
		System.out.println(result.getDeletedCount() + 
				"개의 레코드 삭제! ");
	}

	//	조건에 만족하는 문서 가져오기
	private static void testFindFilter() {
		//	species가 인간이고 gender가 FEMALE인 문서 - $and
		/*
		db.javaMongo.find({ $and: 
								[
									{"species": "인간"},
									{"gender": "FEMALE"
								]
							})
		*/
		
		//	조건 Bson 생성
//		Bson bsonFilter = Filters.and(
//					Filters.eq("species", "인간"),
//					Filters.eq("gender", "FEMALE")
//				);
		
		//	species == 인간 or gender == FEMALE인 문서들
		Bson bsonFilter = Filters.or(
					Filters.eq("species", "인간"),
					Filters.eq("gender", "FEMALE")
				);
		System.out.println("Filter:" + bsonFilter);
		
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		//	조건 검색
		MongoCursor<Document> cursor = coll.find(bsonFilter).iterator();
		
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			System.out.println("DOC:" + doc);
		}
		cursor.close();
	}
	
	//	전체 문서 가져오기
	private static void testFindAll() {
		//	db.javaMongo.find()
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		
		MongoCursor<Document> cursor = coll.find().iterator();
		//	loop
		while(cursor.hasNext()) {	//	뒤에 남아 있는 문서가 있으면
			Document doc = cursor.next();
			System.out.println(doc.toJson());
		}
		cursor.close();
	}
	
	//	문서 한 개 가져오기: findOne
	private static void testFindFirst() {
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		
		Document doc = coll.find().first();
		System.out.println("DOC:" + doc);
		System.out.println("JSON:" + doc.toJson());
		
		//	필드 값 가져오기 .get
		System.out.printf("%s, %s, %s, %s\n", 
				doc.get("_id"),
				doc.get("name"),
				doc.get("species"),
				doc.get("gender"));
	}
	
	//	여러 개 문서 insert 
	private static void testInsertMany() {
		/*
		 db.javaMongo.insertMany([
		 	{ 문서 }, { 문서 }
		 ]);
		 */
		List<Document> docs = new ArrayList<>();	//	List 생성
		Document doc = new Document("name", "고길동")
									.append("species", "인간")
									.append("gender", "MALE");
		//	리스트에 추가
		docs.add(doc);
		
		doc = new Document("name", "또치")
							.append("species", "조류")
							.append("gender", "FEMALE");
		docs.add(doc);
		
		doc = new Document("name", "도우너")
							.append("species", "외계인")
							.append("gender", "MALE");
		docs.add(doc);
		
		doc = new Document("name", "고영희")
							.append("species", "인간")
							.append("gender", "FEMALE");
		docs.add(doc);
		System.out.println("DOCUMENTS:" + docs);
		
		//	여러 문서 INSERT
		//	db.javaMongo.insertMany([ 문서의 배열 ])
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		coll.insertMany(docs);	//	리스트 전달
	}
	
	//	1개 문서 insert
	private static void testInsert() {
		//	삽입 문서 생성
		//	Bson -> Document
		/*
		{ name: "둘리", species: "공룡", gender: "MALE" }
		 */
		Document doc = new Document("name", "둘리")
							.append("species", "공룡")
							.append("gender", "MALE");
		System.out.println("DOC:" + doc);
		System.out.println("JSON:" + doc.toJson());
		// DB 접속 -> 컬렉션 -> insert
		MongoCollection<Document> coll = getCollection(DB_NAME, COLL_NAME);
		//	1개의 문서 insert
		coll.insertOne(doc); //	db.testCollection.insert({})
	}
	
	private static MongoCollection<Document> getCollection(
			String databaseName, String collectionName) {
		//	접속
		MongoClient client = connect();
		//	use 데이터베이스
		MongoDatabase db = client.getDatabase(databaseName);	//	use javaMongo
		System.out.println("DATABASE:" + db);
		//	컬렉션 접속
		MongoCollection<Document> coll = 
				db.getCollection(collectionName);
		System.out.println("COLLECTION:" + coll);
		return coll;
	}
	
	private static MongoClient connect() {
		//	몽고 DB 접속
//		MongoClient client = MongoClients.create();	//	기본 접속
		//	기본값 사용: ip -> localhost, port -> 27017
		//	사용자 정의 설치
		//	Mongodb ip localhost가 이니고, 
		//	port 27017 아니다
		MongoClient client = MongoClients.create(	//	서버 정보
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