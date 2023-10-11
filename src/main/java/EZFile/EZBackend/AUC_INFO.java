package EZFile.EZBackend;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "AUC_INFO")
public class AUC_INFO {

    @Id
    @Column
    private Integer AUCTION_ID;

    @Column
    private Integer COMMITMENT_PERIOD_ID;

    @Column
    private Integer AUCTION_PERIOD_ID;

    @Column
    private Date AUCTION_BEGIN_DATE;

    @Column
    private Date AUCTION_END_DATE;

    @Column
    private String AUCTION_TYPE;

    // Relations
    @ManyToOne
    @JoinColumn(name = "COMMITMENT_PERIOD_ID", insertable = false, updatable = false)
    @JsonIgnore
    private PERIOD_INFO commit_period_info;

    @ManyToOne
    @JoinColumn(name = "AUCTION_PERIOD_ID", insertable = false, updatable = false)  
    @JsonIgnore
    private PERIOD_INFO auc_period_info;

    @OneToMany(mappedBy = "auc_info")
    @JsonIgnore
    private List<PROPOSAL_INFO> proposal_info;

    // Getters

    public Integer getAUCTION_ID() {
        return AUCTION_ID;
    }

    public Integer getCOMMITMENT_PERIOD_ID() {
        return COMMITMENT_PERIOD_ID;
    }

    public Integer getAUCTION_PERIOD_ID() {
        return AUCTION_PERIOD_ID;
    }

    public Date getAUCTION_BEGIN_DATE() {
        return AUCTION_BEGIN_DATE;
    }

    public Date getAUCTION_END_DATE() {
        return AUCTION_END_DATE;
    }

    public String getAUCTION_TYPE() {
        return AUCTION_TYPE;
    }

    public PERIOD_INFO getCOMMIT_PERIOD_INFO() {
        return commit_period_info;
    }

    public PERIOD_INFO getAUCTION_PERIOD_INFO() {
        return auc_period_info;
    }

    public List<PROPOSAL_INFO> getPROPOSAL_INFO() {
        return proposal_info;
    }
    
    // Setters 

    public void setAUCTION_ID(Integer AUCTION_ID) {
        this.AUCTION_ID = AUCTION_ID;
    }

    public void setCOMMITMENT_PERIOD_ID(Integer COMMITMENT_PERIOD_ID) {
        this.COMMITMENT_PERIOD_ID = COMMITMENT_PERIOD_ID;
    }

    public void setAUCTION_PERIOD_ID(Integer AUCTION_PERIOD_ID) {
        this.AUCTION_PERIOD_ID = AUCTION_PERIOD_ID;
    }

    public void setAUCTION_BEGIN_DATE(Date AUCTION_BEGIN_DATE) {
        this.AUCTION_BEGIN_DATE = AUCTION_BEGIN_DATE;
    }

    public void setAUCTION_END_DATE(Date AUCTION_END_DATE) {
        this.AUCTION_END_DATE = AUCTION_END_DATE;
    }

    public void setAUCTION_TYPE(String AUCTION_TYPE) {
        this.AUCTION_TYPE = AUCTION_TYPE;
    }

    public void setCOMMIT_PERIOD_INFO(PERIOD_INFO commit_period_info) {
        this.commit_period_info = commit_period_info;
    }

    public void setAUCTION_PERIOD_INFO(PERIOD_INFO auc_period_info) {
        this.auc_period_info = auc_period_info;
    }

    public void setPROPOSAL_INFO(List<PROPOSAL_INFO> proposal_info) {
        this.proposal_info = proposal_info;
    }
}
