package EZFile.EZBackend;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROJ_INFO")
public class PROJ_INFO {
    @Id
    @Column
    private Integer PROJECT_ID;

    @Column
    private String PROJECT_NAME;

    @OneToMany(mappedBy = "proj_info")
    @JsonIgnore
    private List<PROPOSAL_INFO> proposal_info;

    public Integer getPROJECT_ID() {
        return PROJECT_ID;
    }

    public String getPROJECT_NAME() {
        return PROJECT_NAME;
    }

    public List<PROPOSAL_INFO> getPROPOSAL_INFO() {
        return proposal_info;
    }

    public void setPROJECT_ID(Integer PROJECT_ID) {
        this.PROJECT_ID = PROJECT_ID;
    }

    public void setPROJECT_NAME(String PROJECT_NAME) {
        this.PROJECT_NAME = PROJECT_NAME;
    }

    public void setPROPOSAL_INFO(List<PROPOSAL_INFO> proposal_info) {
        this.proposal_info = proposal_info;
    }
}
