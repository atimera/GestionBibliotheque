package com.opc.projet.gestionbiblio.model.bean;

public class Address {
    // ===================== Attributs =================//
    private Integer id;
    private String address;
    private String address2;
    private String postalCode;
    private String city;

    // ==================== Constructeurs =====================//
   public Address(){
    }

    public Address(Integer pId){
        id = pId;
    }

    // ==================== Getters/Setters ====================//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    // ==================== Methods ====================//

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id=").append(id)
                .append(vSEP).append("address=\"").append(address).append('"')
                .append(vSEP).append("address2=\"").append(address2).append('"')
                .append(vSEP).append("codePostal=\"").append(postalCode).append('"')
                .append(vSEP).append("ville=\"").append(city).append('"')
                .append("}");
        return vStB.toString();
    }

}
