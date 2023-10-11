package EZFile.EZBackend;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "RES_INFO")
public class RES_INFO {
    @Id
    @Column
    private Integer RESOURCE_ID;
    
    @Column
    private String RESOURCE_NAME;

    @Column
    private String RESOURCE_TYPE;

    // Relationships
    @OneToMany(mappedBy = "res_info")
    @JsonIgnore
    private List<PROPOSAL_INFO> proposal_info;

    // Getters
    public Integer getRESOURCE_ID() {
        return RESOURCE_ID;
    }

    public String getRESOURCE_NAME() {
        return RESOURCE_NAME;
    }

    public String getRESOURCE_TYPE() {
        return RESOURCE_TYPE;
    }

    public List<PROPOSAL_INFO> getPROPOSAL_INFO() {
        return proposal_info;
    }

    // Setters
    public void setRESOURCE_ID(Integer RESOURCE_ID) {
        this.RESOURCE_ID = RESOURCE_ID;
    }

    public void setRESOURCE_NAME(String RESOURCE_NAME) {
        this.RESOURCE_NAME = RESOURCE_NAME;
    }

    public void setRESOURCE_TYPE(String RESOURCE_TYPE) {
        this.RESOURCE_TYPE = RESOURCE_TYPE;
    }

    public void setPROPOSAL_INFO(List<PROPOSAL_INFO> proposal_info) {
        this.proposal_info = proposal_info;
    }
}
