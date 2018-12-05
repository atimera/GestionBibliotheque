package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.model.DomainObject;

import java.util.*;


public abstract class AbstractMapService {

    protected Map<Integer, DomainObject> domainMap;

    public AbstractMapService(){
        domainMap = new HashMap<>();

    }

    public List<DomainObject> getAll() {
        return new ArrayList<>(domainMap.values());
    }


    public DomainObject getById(Integer id) {
        return domainMap.get(id);
    }

    public DomainObject saveOrUpdate(DomainObject domainObject) {
        if(domainObject != null){
            if(domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);
        }else {
            throw new RuntimeException("méthode saveOrUpdate : L'Objet ne peut pas être nul");
        }
        return domainObject;
    }


    public void delete(Integer id){
        domainMap.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(domainMap.keySet()) + 1;
    }

    protected abstract void loadAddresses();
}
