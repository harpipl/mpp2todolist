package pl.harpi.mpp2todolist.main;

import net.sf.mpxj.*;
import net.sf.mpxj.Duration;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;
import pl.harpi.mpp2todolist.model.*;
import pl.harpi.mpp2todolist.model.TimeUnit;
import pl.harpi.mpp2todolist.utils.ConvertHelper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Date;
import java.util.List;

public class Run {
    private static pl.harpi.mpp2todolist.model.Task createTask(Task task) {
        pl.harpi.mpp2todolist.model.Task t = new pl.harpi.mpp2todolist.model.Task(task.getUniqueID() + 1, task.getName());
        t.setStartDate(task.getStart());
        t.setDueDate(task.getFinish());
        t.setCreationDate(task.getCreateDate());
        t.setDuration(new pl.harpi.mpp2todolist.model.Duration(task.getDuration().getDuration(), TimeUnit.fromMpp(task.getDuration().getUnits())));
        t.setPriority(ConvertHelper.fromPriority(task.getPriority().getValue()));

        if (task.getPercentageComplete() != null) {
            int value = task.getPercentageComplete().intValue();

            t.setPercentDone("" + value);
            if (value == 100) {
                t.setDoneDate(t.getDueDate());
            }
        }

        for (ResourceAssignment ra : task.getResourceAssignments()) {
            if (ra.getResource() != null && ra.getResource().getName() != null) {
                t.getPersonList().add(new Person(ra.getResource().getName()));
            }
        }

        return t;
    }

    private static void copyTasks(List<Task> fromTaskList, List<pl.harpi.mpp2todolist.model.Task> toTaskList) {
        for (Task task : fromTaskList) {
            if (task.getName() != null) {
                pl.harpi.mpp2todolist.model.Task t = createTask(task);
                toTaskList.add(t);
                copyTasks(task.getChildTasks(), t.getTaskList());
            }
        }
    }

    public static void main(String args[]) throws MPXJException, JAXBException {
        if (args.length < 1) {
            System.out.println("Please specify the name of mpp file (without extension).");
            return;
        }

        String input = args[0] + ".mpp";
        String output = args[0] + ".tdl";

        File inputFile = new File(input);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("File with given name '" + input + "' doesn't exist.");
        }

        MPPReader reader = new MPPReader();
        ProjectFile projectFile = reader.read(inputFile);

        TodoList todoList = new TodoList();

        todoList.setProjectName(projectFile.getProjectProperties().getName());
        todoList.setLastModDate(projectFile.getProjectProperties().getLastSaved());

        for (Resource resource : projectFile.getAllResources()) {
            if (resource.getName() != null) {
                todoList.getPersonList().add(new Person(resource.getName()));
            }
        }

        for (Task task : projectFile.getAllTasks()) {
            if (task.getName() != null && task.getParentTask() == null) {
                pl.harpi.mpp2todolist.model.Task t = createTask(task);
                todoList.getTaskList().add(t);
                copyTasks(task.getChildTasks(), t.getTaskList());
            }
        }

        File file = new File(output);
        JAXBContext jaxbContext = JAXBContext.newInstance(TodoList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // jaxbMarshaller.marshal(todoList, System.out);
        jaxbMarshaller.marshal(todoList, file);
    }
}
