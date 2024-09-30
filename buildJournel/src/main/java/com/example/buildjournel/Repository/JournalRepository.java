package com.example.buildjournel.Repository;

import com.example.buildjournel.Entity.Journel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface JournalRepository extends MongoRepository<Journel, ObjectId> {
}

