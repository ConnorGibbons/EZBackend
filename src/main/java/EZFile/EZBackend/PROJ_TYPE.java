package EZFile.EZBackend;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "PROJ_TYPE")
public class PROJ_TYPE {
    @Id
    @Column
    private String PROJECT_TYPE;

    @Column
    private String PROJECT_TYPE_DESC;

    // Relationships
    @OneToMany(mappedBy = "proj_type")
    @JsonIgnore
    private List<PROPOSAL_INFO> proposal_info;

    // Getters (needed for Spring to access the data)
    public String getPROJECT_TYPE() {
        return PROJECT_TYPE;
    }

    public String getPROJECT_TYPE_DESC() {
        return PROJECT_TYPE_DESC;
    }

    public List<PROPOSAL_INFO> getPROPOSAL_INFO() {
        return proposal_info;
    }

    // Setters 

    public void setPROJECT_TYPE(String PROJECT_TYPE) {
        this.PROJECT_TYPE = PROJECT_TYPE;
    }

    public void setPROJECT_TYPE_DESC(String PROJECT_TYPE_DESC) {
        this.PROJECT_TYPE_DESC = PROJECT_TYPE_DESC;
    }

    public void setPROPOSAL_INFO(List<PROPOSAL_INFO> proposal_info) {
        this.proposal_info = proposal_info;
    }
}
