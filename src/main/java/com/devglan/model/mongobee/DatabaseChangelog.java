package com.devglan.model.mongobee;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@ChangeLog
public class DatabaseChangelog {

	@ChangeSet(order = "1", id = "initialUser", author = "alo")
	public void importantWorkToDo(DB db) {
		DBCollection mycollection = db.getCollection("users");
		BasicDBObject doc = new BasicDBObject()
				.append("firstname", "schorsch")
				.append("lastname", "hackl")
				.append("username", "test")
				.append("password", "$2a$10$8GNI2G26sPYbGDutRFqLUu0BJ3/AxMkkOdNpX9utUIriTUhSXvEmu")
				.append("salary", 56000)
				.append("age", 50)
				.append("_class", "com.devglan.model.User");
		mycollection.insert(doc);
	}

}
