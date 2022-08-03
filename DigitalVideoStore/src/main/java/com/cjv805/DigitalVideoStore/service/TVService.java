package com.cjv805.DigitalVideoStore.service;

import com.cjv805.DigitalVideoStore.model.Movie;
import com.cjv805.DigitalVideoStore.model.TV;
import com.cjv805.DigitalVideoStore.repository.TVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TVService {

    @Autowired
    private TVRepository tvRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<TV> getTVs(){
        return tvRepository.findAll();
    }

    public Optional<TV> getTV(String id){
        return tvRepository.findById(id);
    }

    public TV addTV(TV tv) {
        return tvRepository.insert(tv);
    }

    public TV updatetv(String id, TV tv) throws Exception {
        tv.set_id(id);
        Optional<TV> tv1 = tvRepository.findById(id);
        if (!tv1.isPresent())
        {
            throw new Exception("Movie not found");

        }
        return tvRepository.save(tv);
    }

    public List<TV> gettvsWithTitle(String t) throws Exception {

        Query query = new Query();
        query.addCriteria(Criteria.where("Title" ).is(t));
        List<TV> tvs = mongoTemplate.find(query, TV.class);
        if (!tvs.isEmpty())
        {
            return tvs;
        }
        throw new Exception("Movie not found");


    }



    public void deletetv(String id) throws Exception {
        Optional<TV> tv1 = tvRepository.findById(id);
        if (!tv1.isPresent())
        {
            throw new Exception("Tv not found");

        }
        tvRepository.deleteById(id);}





}
