package be.italent.model.buider;

import be.italent.model.Project;

public class ProjectBuilder {
    private Project project = new Project();

    public ProjectBuilder projectId(int projectId) {
        project.setProjectId(projectId);
        return this;
    }

    public ProjectBuilder title(String title) {
        project.setTitle(title);
        return this;
    }

    public ProjectBuilder shortDescription(String shortDescription) {
        project.setShortDescription(shortDescription);
        return this;
    }

    public Project build() {
        return project;
    }
}
