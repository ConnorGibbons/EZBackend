package EZFile.EZBackend;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "PROPOSAL_INFO")
public class PROPOSAL_INFO {
    @Id
    @Column
    private Integer PROPOSAL_ID;

    @Column
    private String PROPOSAL_LABEL;

    @Column
    private Integer PROJECT_ID;

    @Column
    private String PROJECT_TYPE;

    @Column
    private Integer RESOURCE_ID;

    @Column
    private Integer CUSTOMER_ID;

    @Column
    private Integer AUCTION_ID;

    @Column
    private Integer PERIOD_ID;

    //Relationships
    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", insertable = false, updatable = false)
    @JsonIgnore
    private PROJ_INFO proj_info;

    @ManyToOne
    @JoinColumn(name = "PROJECT_TYPE", insertable = false, updatable = false)
    @JsonIgnore
    private PROJ_TYPE proj_type;

    @ManyToOne
    @JoinColumn(name = "RESOURCE_ID", insertable = false, updatable = false)
    @JsonIgnore
    private RES_INFO res_info;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", insertable = false, updatable = false)
    @JsonIgnore
    private CUST_INFO cust_info;

    @ManyToOne
    @JoinColumn(name = "PERIOD_ID", insertable = false, updatable = false)
    @JsonIgnore
    private PERIOD_INFO period_info;

    @ManyToOne
    @JoinColumn(name = "AUCTION_ID", insertable = false, updatable = false)
    @JsonIgnore
    private AUC_INFO auc_info;

    @OneToMany(mappedBy = "proposal_info")
    @JsonIgnore
    private List<ATTACH_PROPOSAL> attach_proposal;

    // Getters

    public Integer getPROPOSAL_ID() {
        return PROPOSAL_ID;
    }

    public String getPROPOSAL_LABEL() {
        return PROPOSAL_LABEL;
    }

    public Integer getPROJECT_ID() {
        return PROJECT_ID;
    }

    public String getPROJECT_TYPE() {
        return PROJECT_TYPE;
    }

    public Integer getRESOURCE_ID() {
        return RESOURCE_ID;
    }

    public Integer getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public Integer getAUCTION_ID() {
        return AUCTION_ID;
    }

    public Integer getPERIOD_ID() {
        return PERIOD_ID;
    }

    public PROJ_INFO getProj_info() {
        return proj_info;
    }

    public PROJ_TYPE getProj_type() {
        return proj_type;
    }

    public RES_INFO getRes_info() {
        return res_info;
    }

    public CUST_INFO getCust_info() {
        return cust_info;
    }

    public PERIOD_INFO getPeriod_info() {
        return period_info;
    }

    public AUC_INFO getAuc_info() {
        return auc_info;
    }

    public List<ATTACH_PROPOSAL> getAttach_proposal() {
        return attach_proposal;
    }

    // Setters

    public void setPROPOSAL_ID(Integer PROPOSAL_ID) {
        this.PROPOSAL_ID = PROPOSAL_ID;
    }

    public void setPROPOSAL_LABEL(String PROPOSAL_LABEL) {
        this.PROPOSAL_LABEL = PROPOSAL_LABEL;
    }

    public void setPROJECT_ID(Integer PROJECT_ID) {
        this.PROJECT_ID = PROJECT_ID;
    }

    public void setPROJECT_TYPE(String PROJECT_TYPE) {
        this.PROJECT_TYPE = PROJECT_TYPE;
    }

    public void setRESOURCE_ID(Integer RESOURCE_ID) {
        this.RESOURCE_ID = RESOURCE_ID;
    }

    public void setCUSTOMER_ID(Integer CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public void setAUCTION_ID(Integer AUCTION_ID) {
        this.AUCTION_ID = AUCTION_ID;
    }

    public void setPERIOD_ID(Integer PERIOD_ID) {
        this.PERIOD_ID = PERIOD_ID;
    }

    public void setProj_info(PROJ_INFO proj_info) {
        this.proj_info = proj_info;
    }

    public void setProj_type(PROJ_TYPE proj_type) {
        this.proj_type = proj_type;
    }

    public void setRes_info(RES_INFO res_info) {
        this.res_info = res_info;
    }

    public void setCust_info(CUST_INFO cust_info) {
        this.cust_info = cust_info;
    }

    public void setPeriod_info(PERIOD_INFO period_info) {
        this.period_info = period_info;
    }

    public void setAuc_info(AUC_INFO auc_info) {
        this.auc_info = auc_info;
    }

    public void setAttach_proposal(List<ATTACH_PROPOSAL> attach_proposal) {
        this.attach_proposal = attach_proposal;
    }

}
