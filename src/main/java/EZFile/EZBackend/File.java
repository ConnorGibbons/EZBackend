package EZFile.EZBackend;
import java.util.*;
import java.io.Serializable;

// The idea behind this class is to take what's given to us by the database, and turn it into an easily digestable format.
// It is constructed using database calls so that we don't need to query the database every time we want to access a piece of data.

public class File implements Serializable {

    // Information present in ATTACHMENT_FILE or ATTACH_PROPOSAL table
    private Integer fileID; // Same as ATTACHMENT_ID
    private String fileName;
    private String fileExtension;
    private String fileDescription;
    private String filePath;
    private List<Integer> proposalIDs; // A single file could possibly be attached to multiple proposals.
    private List<String> attachmentTypes; // A single file (ATTACHMENT_ID) could exist in multiple rows in the "ATTACH_PROPOSAL" table, potentially with different attachment types.

    // Data present in ATTACHMENT_FILERepository (Some are attributes of attributes of the file)
    private Integer customerID;
    private List<Integer> auctionIDs; // Auctions related to proposals where this file was an attachment.
    private List<Integer> periodIDs;  // Periods related to proposals where this file was an attachment.
    private List<Integer> projectIDs; // Projects related to proposals where this file was an attachment.
    private List<String> projectTypes; // Types of projects related to proposals where this file was an attachment.
    private List<Integer> resourceIDs; // Resources related to proposals where this file was an attachment.
    private List<String> proposalLabels; // Labels of proposals where this file was an attachment.
    // Data that can be found using the above data
    private String customerName;
    private List<String> periodTypes;
    private List<String> auctionTypes;
    private List<String> projectNames;
    private List<String> resourceNames;

    public File(ATTACHMENT_FILE file, CUST_INFORepository customers, PERIOD_INFORepository periods, AUC_INFORepository auctions, PROJ_INFORepository projects, RES_INFORepository resources) {
        this.fileID = file.getATTACHMENT_ID();
        this.fileName = file.getFILE_NAME();
        this.fileExtension = file.getFILE_NAME().substring(file.getFILE_NAME().lastIndexOf('.') + 1);
        this.fileDescription = file.getDESCRIPTION();
        this.filePath = file.getFILE_PATH();
        this.proposalIDs = new ArrayList<>();
        this.attachmentTypes = new ArrayList<>();
        this.auctionIDs = new ArrayList<>();
        this.periodIDs = new ArrayList<>();
        this.projectIDs = new ArrayList<>();
        this.projectTypes = new ArrayList<>();
        this.resourceIDs = new ArrayList<>();
        this.proposalLabels = new ArrayList<>();
        this.periodTypes = new ArrayList<>();
        this.auctionTypes = new ArrayList<>();
        this.projectNames = new ArrayList<>();
        this.resourceNames = new ArrayList<>();

        for (ATTACH_PROPOSAL attachmentInstance : file.getATTACH_PROPOSAL()) {
            this.customerID = attachmentInstance.getPROPOSAL_INFO().getCUSTOMER_ID();
            this.proposalIDs.add(attachmentInstance.getPROPOSAL_ID());
            this.attachmentTypes.add(attachmentInstance.getATTACHMENT_TYPE());
            this.auctionIDs.add(attachmentInstance.getPROPOSAL_INFO().getAUCTION_ID());
            this.periodIDs.add(attachmentInstance.getPROPOSAL_INFO().getPERIOD_ID());
            this.resourceIDs.add(attachmentInstance.getPROPOSAL_INFO().getRESOURCE_ID());
            this.projectIDs.add(attachmentInstance.getPROPOSAL_INFO().getPROJECT_ID());
            this.projectTypes.add(attachmentInstance.getPROPOSAL_INFO().getPROJECT_TYPE());
            this.proposalLabels.add(attachmentInstance.getPROPOSAL_INFO().getPROPOSAL_LABEL());
        }

        this.customerName = customers.findById(this.customerID).get().getCUSTOMER_NAME();

        for (Integer periodID : this.periodIDs) {
            this.periodTypes.add(periods.findById(periodID).get().getPERIOD_TYPE());
        }

        for (Integer auctionID : this.auctionIDs) {
            this.auctionTypes.add(auctions.findById(auctionID).get().getAUCTION_TYPE());
        }

        for (Integer projectID : this.projectIDs) {
            this.projectNames.add(projects.findById(projectID).get().getPROJECT_NAME());
        }

        for (Integer resourceID : this.resourceIDs) {
            this.resourceNames.add(resources.findById(resourceID).get().getRESOURCE_NAME());
        }

    }

    @Override
    public String toString() {
        return "File{" +
                "fileID=" + fileID +
                ", fileName='" + fileName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                ", filePath='" + filePath + '\'' +
                ", proposalIDs=" + proposalIDs +
                ", attachmentTypes=" + attachmentTypes +
                ", customerID=" + customerID +
                ", auctionIDs=" + auctionIDs +
                ", periodIDs=" + periodIDs +
                ", projectIDs=" + projectIDs +
                ", projectTypes=" + projectTypes +
                ", resourceIDs=" + resourceIDs +
                ", proposalLabels=" + proposalLabels +
                ", customerName='" + customerName + '\'' +
                ", periodTypes=" + periodTypes +
                ", auctionTypes=" + auctionTypes +
                ", projectNames=" + projectNames +
                ", resourceNames=" + resourceNames +
                '}';
    }

    // Getters 

    public Integer getFileID() {
        return fileID;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public String getFilePath() {
        return filePath;
    }

    public List<Integer> getProposalIDs() {
        return proposalIDs;
    }

    public List<String> getAttachmentTypes() {
        return attachmentTypes;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public List<Integer> getAuctionIDs() {
        return auctionIDs;
    }

    public List<Integer> getPeriodIDs() {
        return periodIDs;
    }

    public List<Integer> getProjectIDs() {
        return projectIDs;
    }

    public List<String> getProjectTypes() {
        return projectTypes;
    }

    public List<Integer> getResourceIDs() {
        return resourceIDs;
    }

    public List<String> getProposalLabels() {
        return proposalLabels;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getPeriodTypes() {
        return periodTypes;
    }

    public List<String> getAuctionTypes() {
        return auctionTypes;
    }

    public List<String> getProjectNames() {
        return projectNames;
    }

    public List<String> getResourceNames() {
        return resourceNames;
    }

    // Setters 

    public void setFileID(Integer fileID) {
        this.fileID = fileID;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setProposalIDs(List<Integer> proposalIDs) {
        this.proposalIDs = proposalIDs;
    }

    public void setAttachmentTypes(List<String> attachmentTypes) {
        this.attachmentTypes = attachmentTypes;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public void setAuctionIDs(List<Integer> auctionIDs) {
        this.auctionIDs = auctionIDs;
    }

    public void setPeriodIDs(List<Integer> periodIDs) {
        this.periodIDs = periodIDs;
    }

    public void setProjectIDs(List<Integer> projectIDs) {
        this.projectIDs = projectIDs;
    }

    public void setProjectTypes(List<String> projectTypes) {
        this.projectTypes = projectTypes;
    }

    public void setResourceIDs(List<Integer> resourceIDs) {
        this.resourceIDs = resourceIDs;
    }

    public void setProposalLabels(List<String> proposalLabels) {
        this.proposalLabels = proposalLabels;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPeriodTypes(List<String> periodTypes) {
        this.periodTypes = periodTypes;
    }

    public void setAuctionTypes(List<String> auctionTypes) {
        this.auctionTypes = auctionTypes;
    }

    public void setProjectNames(List<String> projectNames) {
        this.projectNames = projectNames;
    }

    public void setResourceNames(List<String> resourceNames) {
        this.resourceNames = resourceNames;
    }

}
