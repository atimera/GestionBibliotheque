//package com.opc.projet.gestionbiblio.rest.resource.address;
//
//import com.opc.projet.gestionbiblio.entity.Address;
//import com.opc.projet.gestionbiblio.service.contract.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Ressource REST pour les {@link Address}.
// *
// * @author lgu
// */
//@Path("/addresses")
//@Produces(MediaType.APPLICATION_JSON)
//public class AddressResource {
//
//    @Autowired
//    AddressService addressService;
//
//    /**
//     * Renvoie tous les {@link Address}
//     *
//     * @return List
//     */
//    @GET
//    public List<Address> get() {
//        //ProjetManager vProjetManager = new ProjetManager();
//        List<Address> vListAddresses = new ArrayList<>();
//        Address a = new Address();
//        a.setId(1L);
//        a.setCity("Paris");
//        a.setPostalCode("75999");
//        a.setAddress("tour du lion");
//        vListAddresses.add(a);
//        return vListAddresses;
//    }
//
//
//
////    /**
////     * Renvoie le {@link Projet} d'identifiant {@code pId}
////     *
////     * @param pId identifiant du {@link Projet}
////     * @return Le {@link Projet}
////     * @throws NotFoundException Si le {@link Projet} n'a pas été trouvé
////     */
////    @GET
////    @Path("{id}")
////    public Projet get(@PathParam("id") Integer pId) throws NotFoundException {
////        ProjetManager vProjetManager = new ProjetManager();
////        Projet vProjet = vProjetManager.getProjet(pId);
////        return vProjet;
////    }
//
//}
