package EZFile.EZBackend;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "ATTACH_PROPOSAL")
@IdClass(ATTACH_PROPOSALId.class)
public class ATTACH_PROPOSAL {

    @Id
    @Column
    private Integer PROPOSAL_ID;

    @Id
    @Column
    private Integer ATTACHMENT_ID;

    @Column
    private String ATTACHMENT_TYPE;

    // Relations

    @ManyToOne
    @JoinColumn(name = "PROPOSAL_ID", insertable = false, updatable = false)
    @JsonIgnore
    private PROPOSAL_INFO proposal_info;

    @ManyToOne
    @JoinColumn(name = "ATTACHMENT_ID", insertable = false, updatable = false)
    @JsonIgnore
    private ATTACHMENT_FILE attachment_file;

    @ManyToOne
    @JoinColumn(name = "ATTACHMENT_TYPE", insertable = false, updatable = false)
    @JsonIgnore
    private ATTACH_TYPE attach_type;


    // Getters

    public Integer getPROPOSAL_ID() {
        return PROPOSAL_ID;
    }

    public Integer getATTACHMENT_ID() {
        return ATTACHMENT_ID;
    }

    public String getATTACHMENT_TYPE() {
        return ATTACHMENT_TYPE;
    }

    public PROPOSAL_INFO getPROPOSAL_INFO() {
        return proposal_info;
    }

    // Setters

    public void setPROPOSAL_ID(Integer PROPOSAL_ID) {
        this.PROPOSAL_ID = PROPOSAL_ID;
    }

    public void setATTACHMENT_ID(Integer ATTACHMENT_ID) {
        this.ATTACHMENT_ID = ATTACHMENT_ID;
    }

    public void setATTACHMENT_TYPE(String ATTACHMENT_TYPE) {
        this.ATTACHMENT_TYPE = ATTACHMENT_TYPE;
    }

    public void setPROPOSAL_INFO(PROPOSAL_INFO proposal_info) {
        this.proposal_info = proposal_info;
    }

}
