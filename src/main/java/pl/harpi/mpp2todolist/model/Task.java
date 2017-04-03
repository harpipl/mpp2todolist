package pl.harpi.mpp2todolist.model;

import pl.harpi.mpp2todolist.utils.DateHelper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
    private String title;
    private Integer id;
    private Integer refId = 0;
    private String commentsType = "PLAIN_TEXT";
    private String createdBy;
    private String priority;
    private String risk = "0";
    private String percentDone = "0";
    private String calcPercentDone = "0";
    private Date startDate;
    private Date dueDate;
    private Date creationDate;
    private Date finishDate;
    private Date lastModDate;
    private Date doneDate;
    private String textColor = "0";
    private String textWebColor = "#000000";
    private String priorityColor = "15732480";
    private String priorityWebColor = "#000FF0";
    private String subtaskDone;
    private Duration duration;

    private List<Person> personList = new ArrayList<Person>();
    private List<Task> taskList = new ArrayList<Task>();

    public Task(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @XmlAttribute(name = "TITLE")
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    @XmlAttribute(name = "ID")
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRefId() {
        return refId;
    }

    @XmlAttribute(name = "REFID")
    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public String getCommentsType() {
        return commentsType;
    }

    @XmlAttribute(name = "COMMENTSTYPE")
    public void setCommentsType(String commentsType) {
        this.commentsType = commentsType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    @XmlAttribute(name = "CREATEDBY")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getPriority() {
        return priority;
    }

    @XmlAttribute(name = "PRIORITY")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRisk() {
        return risk;
    }

    @XmlAttribute(name = "RISK")
    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getCalcPercentDone() {
        return calcPercentDone;
    }

    @XmlAttribute(name = "CALCPERCENTDONE")
    public void setCalcPercentDone(String calcPercentDone) {
        this.calcPercentDone = calcPercentDone;
    }

    public String getPercentDone() {
        return percentDone;
    }

    @XmlAttribute(name = "PERCENTDONE")
    public void setPercentDone(String percentDone) {
        this.percentDone = percentDone;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    @XmlTransient
    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    @XmlAttribute(name = "DONEDATE")
    public String getDoneDateAsNum() {
        return DateHelper.toNum(doneDate);
    }

    @XmlAttribute(name = "DONEDATESTRING")
    public String getDoneDateAsString() {
        return DateHelper.toString(doneDate, DateHelper.DATE_WITH_TIME_FORMAT_STR);
    }

    public Date getStartDate() {
        return startDate;
    }

    @XmlTransient
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @XmlAttribute(name = "STARTDATE")
    public String getStartDateAsNum() {
        return DateHelper.toNum(startDate);
    }

    @XmlAttribute(name = "STARTDATESTRING")
    public String getStartDateAsString() {
        return DateHelper.toString(startDate, DateHelper.DATE_WITH_TIME_FORMAT_STR);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @XmlTransient
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @XmlAttribute(name = "CREATIONDATE")
    public String getCreationDateAsNum() {
        return DateHelper.toNum(creationDate);
    }

    @XmlAttribute(name = "CREATIONDATESTRING")
    public String getCreationDateAsString() {
        return DateHelper.toString(creationDate, DateHelper.DATE_WITH_TIME_FORMAT_STR);
    }

    public String getTextColor() {
        return textColor;
    }

    @XmlAttribute(name = "TEXTCOLOR")
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getTextWebColor() {
        return textWebColor;
    }

    @XmlAttribute(name = "TEXTWEBCOLOR")
    public void setTextWebColor(String textWebColor) {
        this.textWebColor = textWebColor;
    }

    public String getPriorityColor() {
        return priorityColor;
    }

    @XmlAttribute(name = "PRIORITYCOLOR")
    public void setPriorityColor(String priorityColor) {
        this.priorityColor = priorityColor;
    }

    public String getPriorityWebColor() {
        return priorityWebColor;
    }

    @XmlAttribute(name = "PRIORITYWEBCOLOR")
    public void setPriorityWebColor(String priorityWebColor) {
        this.priorityWebColor = priorityWebColor;
    }

    public String getSubtaskDone() {
        return subtaskDone;
    }

    @XmlAttribute(name = "SUBTASKDONE")
    public void setSubtaskDone(String subtaskDone) {
        this.subtaskDone = subtaskDone;
    }

    @XmlElement(name = "PERSON")
    public List<Person> getPersonList() {
        return personList;
    }

    @XmlElement(name = "TASK")
    public List<Task> getTaskList() {
        return taskList;
    }

    public Date getDueDate() {
        return dueDate;
    }

    @XmlTransient
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @XmlAttribute(name = "DUEDATE")
    public String getDueDateAsNum() {
        return DateHelper.toNum(dueDate);
    }

    @XmlAttribute(name = "DUEDATESTRING")
    public String getDueDateAsString() {
        return DateHelper.toString(dueDate, DateHelper.DATE_WITH_TIME_FORMAT_STR);
    }

    public Date getFinishDate() {
        return finishDate;
    }

    @XmlTransient
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @XmlAttribute(name = "DONEDATE")
    public String getFinishDateAsNum() {
        return DateHelper.toNum(finishDate);
    }

    @XmlAttribute(name = "DONEDATESTRING")
    public String getFinishDateAsString() {
        return DateHelper.toString(finishDate, DateHelper.DATE_WITH_TIME_FORMAT_STR);
    }

    public Date getLastModDate() {
        return lastModDate;
    }

    @XmlTransient
    public void setLastModDate(Date lastModDate) {
        this.lastModDate = lastModDate;
    }

    @XmlAttribute(name = "LASTMOD")
    public String getLastDateAsNum() {
        return DateHelper.toNum(lastModDate);
    }

    @XmlAttribute(name = "LASTMODSTRING")
    public String getLastModString() {
        return DateHelper.toString(lastModDate, DateHelper.DATE_WITH_TIME_FORMAT_STR);
    }

    @XmlTransient
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @XmlAttribute(name = "TIMEESTIMATE")
    public String getTimeEstimate() {
        return (duration == null) ? "0.00000000" : String.valueOf(duration.getDuration());
    }

    @XmlAttribute(name = "TIMEESTUNITS")
    public String getTimeEstimateUnits() {
        return (duration == null) ? TimeUnit.HOURS.getSymbol() : String.valueOf(duration.getUnits().getSymbol());
    }
}
