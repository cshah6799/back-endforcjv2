package com.cjv805.DigitalVideoStore.controller;

import com.cjv805.DigitalVideoStore.CustomizedResponse;
import com.cjv805.DigitalVideoStore.model.Movie;
import com.cjv805.DigitalVideoStore.model.TV;
import com.cjv805.DigitalVideoStore.service.TVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TVController {

    @Autowired
    private TVService tvService;

    @GetMapping("/tvs")
    public ResponseEntity getTVs(){
        return new ResponseEntity(tvService.getTVs(), HttpStatus.OK);
    }

    @GetMapping("/detail/tv/{id}")
    public ResponseEntity getTV(@PathVariable("id") String id) {
        CustomizedResponse customizedResponse = null;
        try {
            return new ResponseEntity(tvService.getTV(id), HttpStatus.OK);
        }catch (Exception e){
            customizedResponse = new CustomizedResponse(e.getMessage(),null);
            return new ResponseEntity(customizedResponse,HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/tvs/{title}")
    public ResponseEntity gettvsByTitle(@RequestParam(value = "title") String t)
    {
        CustomizedResponse customizedResponse = null;
        try {
            return new ResponseEntity(tvService.gettvsWithTitle(t), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Tv Show not found", HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/tvs/delete/{id}")
    public ResponseEntity deletetv(@PathVariable("id") String id) {
        try {
            tvService.deletetv(id);
            return new ResponseEntity("Tv Show Deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Tv show not deleted", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/tvs/update/{id}")
    public ResponseEntity updatetv(@PathVariable("id") String id, @RequestBody TV tv) {
        try {
            tvService.updatetv(id, tv);
            return new ResponseEntity("Tv Show Updated", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Tv Show not updated", HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping(value = "/tvs", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity createMovie(@RequestBody TV tv){
        if(tvService.addTV(tv)==null){
            return new ResponseEntity("Tv show not added",HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity("Tv show added",HttpStatus.OK);
        }
    }
}
