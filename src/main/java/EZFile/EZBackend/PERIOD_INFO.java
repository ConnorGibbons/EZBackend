package EZFile.EZBackend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "PERIOD_INFO")
public class PERIOD_INFO {
    @Id
    @Column
    private Integer PERIOD_ID;

    @Column
    private String PERIOD_TYPE;

    @Column
    private String DESCRIPTION;

    @Column 
    private Date BEGIN_DATE;

    @Column
    private Date END_DATE;

    @Column
    private Integer PARENT_PERIOD_ID;

    // Relations
    @OneToMany(mappedBy = "period_info")
    @JsonIgnore
    private List<PROPOSAL_INFO> proposal_info;

    @OneToMany(mappedBy = "commit_period_info")
    @JsonIgnore
    private List<AUC_INFO> commit_auc_info;

    @OneToMany(mappedBy = "auc_period_info")
    @JsonIgnore
    private List<AUC_INFO> auc_info;

    // Getters

    public Integer getPERIOD_ID() {
        return PERIOD_ID;
    }

    public String getPERIOD_TYPE() {
        return PERIOD_TYPE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public Date getBEGIN_DATE() {
        return BEGIN_DATE;
    }

    public Date getEND_DATE() {
        return END_DATE;
    }

    public Integer getPARENT_PERIOD_ID() {
        return PARENT_PERIOD_ID;
    }

    public List<PROPOSAL_INFO> getPROPOSAL_INFO() {
        return proposal_info;
    }

    // Setters 

    public void setPERIOD_ID(Integer PERIOD_ID) {
        this.PERIOD_ID = PERIOD_ID;
    }

    public void setPERIOD_TYPE(String PERIOD_TYPE) {
        this.PERIOD_TYPE = PERIOD_TYPE;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setBEGIN_DATE(Date BEGIN_DATE) {
        this.BEGIN_DATE = BEGIN_DATE;
    }

    public void setEND_DATE(Date END_DATE) {
        this.END_DATE = END_DATE;
    }

    public void setPARENT_PERIOD_ID(Integer PARENT_PERIOD_ID) {
        this.PARENT_PERIOD_ID = PARENT_PERIOD_ID;
    }

    public void setPROPOSAL_INFO(List<PROPOSAL_INFO> proposal_info) {
        this.proposal_info = proposal_info;
    }

}
