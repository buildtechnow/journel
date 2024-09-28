package com.example.buildjournel.controller;


import com.example.buildjournel.Entity.Journel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
        @RequestMapping("/journel")
public  class JournelController {
    private Map<Long, Journel> myJournel=new HashMap<>();
    @GetMapping
    public List<Journel> getJournel(){
        return new ArrayList<>(myJournel.values());
    }

    @PostMapping
    public Journel addJournel(@RequestBody Journel journel){
        myJournel.put(journel.getId(),journel);
        return journel;
    }

    @GetMapping("/id/{myId}")
    public Journel getJournelById(@PathVariable Long myId){
        return myJournel.get(myId);
    }

    @PutMapping("/id/{id}")
    public Journel updateJournel(@PathVariable Long id,@RequestBody Journel journel){
        return myJournel.put(journel.getId(),journel);
    }

    @DeleteMapping("/id/{dId}")
    public boolean deleteJournel(@PathVariable Long dId){
        myJournel.remove(dId);
        return true;
    }
}
