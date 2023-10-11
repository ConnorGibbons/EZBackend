package EZFile.EZBackend;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "PROPOSAL_INFO")
public class PROPOSAL_INFO {
    @Id
    @Column
    private int PROPOSAL_ID;

    @Column
    private String PROPOSAL_LABEL;

    @Column
    private int PROJECT_ID;

    @Column
    private String PROJECT_TYPE;

    @Column
    private int RESOURCE_ID;

    @Column
    private int CUSTOMER_ID;

    @Column
    private int AUCTION_ID;

    @Column
    private int PERIOD_ID;

    //Relationships
    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", insertable = false, updatable = false)
    @JsonIgnore
    private PROJ_INFO proj_info;

    @ManyToOne
    @JoinColumn(name = "PROJECT_TYPE", insertable = false, updatable = false)
    @JsonIgnore
    private PROJ_TYPE proj_type;

    // Getters

    public int getPROPOSAL_ID() {
        return PROPOSAL_ID;
    }

    public String getPROPOSAL_LABEL() {
        return PROPOSAL_LABEL;
    }

    public int getPROJECT_ID() {
        return PROJECT_ID;
    }

    public String getPROJECT_TYPE() {
        return PROJECT_TYPE;
    }

    public int getRESOURCE_ID() {
        return RESOURCE_ID;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public int getAUCTION_ID() {
        return AUCTION_ID;
    }

    public int getPERIOD_ID() {
        return PERIOD_ID;
    }

    public PROJ_INFO getProj_info() {
        return proj_info;
    }

    public PROJ_TYPE getProj_type() {
        return proj_type;
    }

    // Setters

    public void setPROPOSAL_ID(int PROPOSAL_ID) {
        this.PROPOSAL_ID = PROPOSAL_ID;
    }

    public void setPROPOSAL_LABEL(String PROPOSAL_LABEL) {
        this.PROPOSAL_LABEL = PROPOSAL_LABEL;
    }

    public void setPROJECT_ID(int PROJECT_ID) {
        this.PROJECT_ID = PROJECT_ID;
    }

    public void setPROJECT_TYPE(String PROJECT_TYPE) {
        this.PROJECT_TYPE = PROJECT_TYPE;
    }

    public void setRESOURCE_ID(int RESOURCE_ID) {
        this.RESOURCE_ID = RESOURCE_ID;
    }

    public void setCUSTOMER_ID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public void setAUCTION_ID(int AUCTION_ID) {
        this.AUCTION_ID = AUCTION_ID;
    }

    public void setPERIOD_ID(int PERIOD_ID) {
        this.PERIOD_ID = PERIOD_ID;
    }

    public void setProj_info(PROJ_INFO proj_info) {
        this.proj_info = proj_info;
    }

    public void setProj_type(PROJ_TYPE proj_type) {
        this.proj_type = proj_type;
    }
}
