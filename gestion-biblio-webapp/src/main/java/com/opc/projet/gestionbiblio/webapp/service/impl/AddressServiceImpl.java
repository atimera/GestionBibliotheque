//package com.opc.projet.gestionbiblio.webapp.service.impl;
//
//import com.opc.projet.gestionbiblio.webapp.dao.contract.AddressDao;
//import com.opc.projet.gestionbiblio.webapp.entity.Address;
//import com.opc.projet.gestionbiblio.webapp.service.contract.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class AddressServiceImpl implements AddressService {
//
//    @Autowired
//    private AddressDao addressDao;
//
//
//    @Override
//    @Transactional
//    public List<Address> getAddresses() {
//        return addressDao.getAddresses();
//    }
//
//    @Override
//    @Transactional
//    public void saveAddress(Address address) {
//        addressDao.save(address);
//    }
//
//    @Override
//    @Transactional
//    public Address get(Integer addressId) {
//        return addressDao.get(addressId);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Integer addressId) {
//        addressDao.delete(addressId);
//    }
//
//}
