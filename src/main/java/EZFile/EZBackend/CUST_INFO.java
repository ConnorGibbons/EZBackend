package EZFile.EZBackend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "CUST_INFO")
public class CUST_INFO {
    @Id
    @Column
    private int CUSTOMER_ID;

    @Column
    private String CUSTOMER_NAME;

    // Relationships

    @OneToMany(mappedBy = "cust_info")
    @JsonIgnore
    private List<PROPOSAL_INFO> proposal_info;

    // Getters 
    
    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public List<PROPOSAL_INFO> getPROPOSAL_INFO() {
        return proposal_info;
    }

    // Setters

    public void setCUSTOMER_ID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    public void setPROPOSAL_INFO(List<PROPOSAL_INFO> proposal_info) {
        this.proposal_info = proposal_info;
    }
    
}
