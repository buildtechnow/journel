package com.example.buildjournel.service;

import com.example.buildjournel.Entity.Journel;
import com.example.buildjournel.Repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalService {


    @Autowired
    private JournalRepository journalRepository;

    public void saveJournal(Journel journel){
        journalRepository.save(journel);
    }
    public List<Journel> getAll(){
        return journalRepository.findAll();
    }

    public Optional<Journel> getbyId(ObjectId id){
        return journalRepository.findById(id);
    }

    public Boolean deleteById(ObjectId id){
          journalRepository.deleteById(id);
          return true;
    }



}
