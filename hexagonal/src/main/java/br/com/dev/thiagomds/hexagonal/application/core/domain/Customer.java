package br.com.dev.thiagomds.hexagonal.application.core.domain;

public class Customer {

    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCPF;

    public Customer() {
        setIsValidCPF(false);
    }

    public Customer(String id, String name, Address address, String cpf, Boolean isValidCPF) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCPF = isValidCPF;
    }

    public String getId()                     { return id; }
    public void setId(String id)              { this.id = id; }
    public String getName()                   { return name; }
    public void setName(String name)          { this.name = name; }
    public Address getAddress()               { return address; }
    public void setAddress(Address address)   { this.address = address; }
    public String getCpf()                    { return cpf; }
    public void setCpf(String cpf)            { this.cpf = cpf; }
    public Boolean getIsValidCPF()              { return isValidCPF; }
    public void setIsValidCPF(Boolean validCPF) { this.isValidCPF = validCPF; }
}
