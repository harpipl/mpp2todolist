package pl.harpi.mpp2todolist.model;

import pl.harpi.mpp2todolist.utils.DateHelper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "TODOLIST")
public class TodoList {
    private String projectName;
    private String fileFormat = "11";
    private String earliestDueDate = "0.00000000";
    private Date lastModDate;
    private String fileVersion = "11";
    private String appVer = "7.1.0.5";

    private List<Person> personList = new ArrayList<Person>();
    private List<Category> categoryList = new ArrayList<>();
    private List<Task> taskList = new ArrayList<Task>();

    public String getProjectName() {
        return projectName;
    }

    @XmlAttribute(name = "PROJECTNAME")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @XmlAttribute(name = "FILEFORMAT")
    public String getFileFormat() {
        return fileFormat;
    }

    @XmlAttribute(name = "EARLIESTDUEDATE")
    public String getEarliestDueDate() {
        return earliestDueDate;
    }

    @XmlAttribute(name = "NEXTUNIQUEID")
    public String getNextUniqueID() {
        // TODO
        return "5";
    }

    @XmlAttribute(name = "FILENAME")
    public String getFileName() {
        return this.projectName + ".tdl";
    }

    @XmlAttribute(name = "FILEVERSION")
    public String getFileVersion() {
        return fileVersion;
    }

    @XmlAttribute(name = "APPVER")
    public String getAppVer() {
        return appVer;
    }

    @XmlElement(name = "PERSON")
    public List<Person> getPersonList() { return personList; }

    @XmlElement(name = "CATEGORY")
    public List<Category> getCategoryList() { return categoryList; }

    @XmlElement(name = "TASK")
    public List<Task> getTaskList() {
        return taskList;
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
}
