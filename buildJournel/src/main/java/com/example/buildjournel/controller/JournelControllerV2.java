package com.example.buildjournel.controller;


import com.example.buildjournel.Entity.Journel;
import com.example.buildjournel.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@RestController
        @RequestMapping("/journel")
public  class JournelControllerV2 {

    @Autowired
    private JournalService journalService;
    @GetMapping
    public List<Journel> getJournel(){
        return journalService.getAll();
    }

    @PostMapping
    public Journel addJournel(@RequestBody Journel journel){
        journel.setDate(LocalDateTime.now());
         journalService.saveJournal(journel);
        return journel;
    }

    @GetMapping("/id/{myId}")
    public Journel getJournelById(@PathVariable ObjectId myId){
        return journalService.getbyId(myId).orElse(null);
    }

    @PutMapping("/id/{id}")
    public Journel updateJournel(@PathVariable ObjectId id,@RequestBody Journel journel){
        Journel oldJournal=journalService.getbyId(id).orElse(null);
         if(oldJournal!=null){
            oldJournal.setName(journel.getName()!=null && ! journel.getName().equals(" ")? journel.getName() : oldJournal.getName());
            oldJournal.setContent(journel.getContent() !=null && ! journel.getContent().equals(" ")?journel.getContent():oldJournal.getContent());
        }
        journalService.saveJournal(oldJournal);
        return oldJournal;
    }

    @DeleteMapping("/id/{dId}")
    public boolean deleteJournel(@PathVariable ObjectId dId){
        return journalService.deleteById(dId);
    }
}
